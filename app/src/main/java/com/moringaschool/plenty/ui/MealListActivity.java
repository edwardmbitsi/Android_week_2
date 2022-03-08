package com.moringaschool.plenty.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.plenty.R;
import com.moringaschool.plenty.adapters.MealListAdapter;
import com.moringaschool.plenty.models.Meal;
import com.moringaschool.plenty.models.MealResponse;
import com.moringaschool.plenty.network.MealApi;
import com.moringaschool.plenty.network.MealClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealListActivity extends AppCompatActivity {
    private static final String TAG = MealListActivity.class.getSimpleName();
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    private MealListAdapter mAdapter;
    public List<Meal> meals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        ButterKnife.bind(this);

        meals = new ArrayList<>();


        Intent intent = getIntent();
        String meal = intent.getStringExtra("meals");


        MealApi client = MealClient.getClient();
        Call<MealResponse> call = client.getMeals();

        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                hideProgressBar();
                if(response.isSuccessful()){
                    List<Meal> allMeals = response.body().getMeals();
                    for(Meal meal : allMeals){
                        Log.d(TAG, "onResponse: " + meal.getStrMeal());
                    }
                    meals.addAll(allMeals);

                    startRecyclerView(meals);
                    showMeal();
                } else {
                    showUnsuccessfulMessage();
                }
            }
            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ",t );
                hideProgressBar();
                showFailureMessage();
            }

        });
    }

    private void startRecyclerView(List<Meal> meals) {
        MealListAdapter mealListAdapter = new MealListAdapter(MealListActivity.this, meals);
        mRecyclerView.setAdapter(mealListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showMeal() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}