package com.wrecker.network.repositories

import android.util.Log
import com.wrecker.network.api.ApiService
import com.wrecker.network.entities.ResponseEntities
import com.wrecker.network.utils.NetworkStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

const val TAG = "DEBUG_TAG"

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {

    override suspend fun fetchUI(
        url: String
    ): Flow<NetworkStatus<ResponseEntities.UiResponse>> = flow {
        emit(NetworkStatus.Loading)
        try {
            val response = apiService.fetchUi()
            if (response.isSuccessful) {
                val data = response.body() ?: return@flow emit(NetworkStatus.Error(""))
                Log.d(TAG, data.toString())
                return@flow emit(NetworkStatus.Success(data))
            } else emit(NetworkStatus.Error(""))
        } catch (exception: Exception) {
            Log.d(TAG, exception.toString())
        }
    }

    override suspend fun fetchImage(
        url: String
    ): Flow<NetworkStatus<ResponseEntities.ImageResponse>> = flow {
        emit(NetworkStatus.Loading)
        try {
            val response = apiService.fetchImage()
            if (response.isSuccessful) {
                val data = response.body() ?: return@flow emit(NetworkStatus.Error(""))
                Log.d(TAG, data.toString())
                return@flow emit(NetworkStatus.Success(data))
            } else emit(NetworkStatus.Error(""))
        } catch (exception: Exception) {
            Log.d(TAG, exception.toString())
        }
    }


}