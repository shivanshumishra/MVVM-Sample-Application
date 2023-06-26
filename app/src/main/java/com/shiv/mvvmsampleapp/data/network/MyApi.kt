package com.shiv.mvvmsampleapp.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("/endpoint/for/login")
    fun userLogin(
        @Field("email") email:String,
        @Field("password") password:String
    ) : Call<ResponseBody>

    companion object {
        operator fun invoke() : MyApi {
            return Retrofit.Builder()
                .baseUrl("https://apibaseurl.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}