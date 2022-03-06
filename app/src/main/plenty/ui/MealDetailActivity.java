package com.moringaschool.plenty.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.moringaschool.plenty.MealDetailFragment;
import com.moringaschool.plenty.R;
import com.moringaschool.plenty.models.Meal;

import java.io.Serializable;

import butterknife.ButterKnife;

public class MealDetailActivity extends AppCompatActivity {

    Meal mMeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mMeals =(Meal) intent.getSerializableExtra("meal");
        int startingPosition = getIntent().getIntExtra("position", 0);

        Bundle bundle = new Bundle();
        bundle.putSerializable("meal", (Serializable) mMeals);
        Fragment fragment = new MealDetailFragment();
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.pagerHeader, fragment, "my fragment")
                .commit();


    }
}