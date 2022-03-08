package com.moringaschool.plenty.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.plenty.ui.MealDetailActivity;
import com.moringaschool.plenty.R;
import com.moringaschool.plenty.models.Meal;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MealListAdapter extends RecyclerView.Adapter<MealListAdapter.myHolder>{
    private List<Meal> mMeals;
    private Context mContext;

    public MealListAdapter(Context context, List<Meal> meals) {
        mContext = context;
        mMeals = meals;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list_item, parent, false);
        myHolder viewHolder = new myHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        holder.bindMeal(mMeals.get(position));
    }

    @Override
    public int getItemCount() {
        return mMeals.size();
    }



    class myHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.mealImageView) ImageView mMealImageView;
        @BindView(R.id.mealNameTextView) TextView mNameTextView;
        @BindView(R.id.typeTextView) TextView mTypeTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        private Context mContext;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindMeal(Meal meal) {
            mNameTextView.setText(meal.getStrMeal());
            mTypeTextView.setText(meal.getStrArea());
            mCategoryTextView.setText(meal.getStrCategory());
            Picasso.get().load(meal.getStrMealThumb()).into(mMealImageView);
        }
        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, MealDetailActivity.class);
            intent.putExtra("meals", (Serializable) mMeals.get(itemPosition));
            mContext.startActivity(intent);
        }
    }
}
