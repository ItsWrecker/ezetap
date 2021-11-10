package com.wrecker.network.api

import com.wrecker.network.entities.ResponseEntities
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {


    @GET("mobileapps/android_assignment.json")
    suspend fun fetchUi(): Response<ResponseEntities.UiResponse>

    @GET("mobileapps/android_assignment.json")
    suspend fun fetchImage(): Response<ResponseEntities.ImageResponse>
}