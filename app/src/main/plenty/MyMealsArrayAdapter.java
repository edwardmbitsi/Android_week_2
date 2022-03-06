package com.moringaschool.plenty;


import android.content.Context;
import android.widget.ArrayAdapter;

public class MyMealsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mMeals;
    private String[] mIngredients;

    public MyMealsArrayAdapter(Context mContext, int resource, String[] mMeals, String[] mIngredients) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mMeals = mMeals;
        this.mIngredients = mIngredients;
    }

    @Override
    public Object getItem(int position) {
        String meals = mMeals[position];
        String ingredient = mIngredients[position];
        return String.format("%s \nMain ingredient: %s", meals, ingredient);
    }

    @Override
    public int getCount() {
        return mMeals.length;
    }
}