package com.pugs.covidanalyzer;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("v4/min/data.min.json")
    Call<JsonObject> getMinData();
}
