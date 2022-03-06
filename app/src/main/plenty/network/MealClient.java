package com.moringaschool.plenty.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealClient {

    private static Retrofit retrofit = null;
    public static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    public static MealApi getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(MealApi.class);
    }

}