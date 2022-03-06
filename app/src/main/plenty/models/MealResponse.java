package com.moringaschool.plenty.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.io.Serializable;
import java.util.List;

@Parcel
public class    MealResponse implements Serializable {

    @SerializedName("meals")
    @Expose
    private List<Meal> meals ;

    /**
     * No args constructor for use in serialization
     *
     */
    public MealResponse() {
    }

    /**
     *
     * @param meals
     */
    public MealResponse(List<Meal> meals) {
        super();
        this.meals = meals;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

}