package com.royal.service;

import com.royal.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("/api/signup")
    Call<Object> signup(@Body UserModel userModel);
}
