package com.neppplus.apipractice_20220106.api

import com.neppplus.pythonapipractice_20220110.models.BasicResponse
import retrofit2.Call
import retrofit2.http.*

interface APIList {

    @GET("/login_test")
    fun getRequestLogin(
        @Query("login_id") id: String,
        @Query("pw") pw: String,
    ) : Call<BasicResponse>

    @GET("/sign_up")
    fun getRequestSignUp(
        @Query("email") email: String,
        @Query("pw") pw: String,
        @Query("nick") nick: String,
    ) : Call<BasicResponse>


    @GET("/add_contact")
    fun getRequestAddContact(
        @Query("user_id") userId: Int,
        @Query("name") name: String,
        @Query("phone") phone: String,
        @Query("memo") memo: String,
    ) : Call<BasicResponse>

}