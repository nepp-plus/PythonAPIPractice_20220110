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

}