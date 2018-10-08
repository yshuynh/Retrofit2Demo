package com.example.huynh.retrofit2demo.Retrofit2;

import com.example.huynh.retrofit2demo.User;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DataClient {

    @GET("{user}")
    Call<User> listRepos(@Path("user") String user);
}
