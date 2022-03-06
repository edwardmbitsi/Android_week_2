package com.moringaschool.plenty.network;

import com.moringaschool.plenty.models.MealResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MealApi {
    @GET("search.php?s=Arrabiata")
    Call<MealResponse> getMeals(
    );
}