package com.wrecker.network.repositories

import com.wrecker.network.entities.ResponseEntities
import com.wrecker.network.utils.NetworkStatus
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun fetchUI(url: String): Flow<NetworkStatus<ResponseEntities.UiResponse>>

    suspend fun fetchImage(url: String): Flow<NetworkStatus<ResponseEntities.ImageResponse>>
}