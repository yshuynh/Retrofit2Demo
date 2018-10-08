package com.example.huynh.retrofit2demo.Retrofit2;

public class APIUtils {
    public static final String Base_Url = "https://api.github.com/users/";
    public static DataClient getData(){
        return RetrofitClient.getClient(Base_Url).create(DataClient.class);
    }
}
