package com.moringaschool.plenty;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.moringaschool.plenty.models.Meal;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MealDetailFragment extends Fragment {
    Meal mMeals;
    @BindView(R.id.mealNameTextView) TextView mMealNameTextView;
    @BindView(R.id.mealImageView) ImageView mMealImageView;
    @BindView(R.id.categoryTextView) TextView mCategoryTextView;
    @BindView(R.id.ingredientsTextView) TextView mIngredientsTextView;
    @BindView(R.id.instructionsTextView) TextView mInstructionsTextView;
    @BindView(R.id.measurementsTextView) TextView mMeasurementsTextView;





    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_food_detail, container, false);
        ButterKnife.bind(this, view);
        mMealNameTextView.setText(mMeals.getStrMeal());
        Picasso.get().load(mMeals.getStrMealThumb()).into(mMealImageView);
        mCategoryTextView.setText(mMeals.getStrCategory());
        mIngredientsTextView.setText(mMeals.getStrIngredient1() + "\n" + mMeals.getStrIngredient2());
        mInstructionsTextView.setText(mMeals.getStrInstructions());
        mMeasurementsTextView.setText(mMeals.getStrMeasure1()+ "\n" + mMeals.getStrMeasure2());
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mMeals = (Meal) bundle.getSerializable("meal");

    }
}