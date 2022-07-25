package com.example.recipeapp;

import android.content.Context;

import com.example.recipeapp.Listeners.RandomRecipeResponseListener;
import com.example.recipeapp.Models.RandomRecipeApiResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.Callback;
import retrofit2.Response;

import retrofit2.http.Query;

public class RequestManager {
    Context context;
    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }
    public void getRandomRecipes(RandomRecipeResponseListener listener) {
        CallRandomREcipes callRandomREcipes = retrofit.create(CallRandomREcipes.class);
        Call<RandomRecipeApiResponse> call = callRandomREcipes.callRandomRecipe(context.getString(R.string.api_key), "80");
        call.enqueue(new Callback<RandomRecipeApiResponse>() {
                         @Override
                         public void onResponse(Call<RandomRecipeApiResponse> call, Response<RandomRecipeApiResponse> response) {
                             if (!response.isSuccessful()){
                                 listener.didError(response.message());
                                 return;
                             }
                             listener.didfetch(response.body(),response.message());


                         }

                         @Override
                         public void onFailure(Call<RandomRecipeApiResponse> call, Throwable t) {
                             listener.didError(t.getMessage());

                         }
                     }
        );
    }

    private interface CallRandomREcipes{
        @GET("recipes/random")
Call<RandomRecipeApiResponse> callRandomRecipe(

        @Query("apiKey") String apiKey,
        @Query("number") String number

);


    }
}
