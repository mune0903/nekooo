package com.mune0903.nuko.data.api

import com.mune0903.nuko.core.entity.Cat
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CatService {

    @Headers("x-api-key: apiKey")
    @GET("images/search")
    suspend fun fetchCats(@Query("limit") limit: Int, @Query("page") page: Int): Response<List<Cat>>
}