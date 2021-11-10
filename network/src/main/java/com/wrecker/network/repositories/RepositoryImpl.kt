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
                val data =
                    response.body() ?: return@flow emit(NetworkStatus.Error("Empty Response Error"))
                Log.d(TAG, data.toString())
                return@flow emit(NetworkStatus.Success(data))
            } else emit(NetworkStatus.Error("Server Error"))
        } catch (exception: Exception) {
            return@flow emit(NetworkStatus.Error("Error while getting ui data", cause = exception))
        }
    }

    override suspend fun fetchImage(
        url: String
    ): Flow<NetworkStatus<ResponseEntities.ImageResponse>> = flow {
        emit(NetworkStatus.Loading)
        try {
            val response = apiService.fetchImage()
            if (response.isSuccessful) {
                val data = response.body()
                    ?: return@flow emit(NetworkStatus.Error("Empty response error!"))
                Log.d(TAG, data.toString())
                return@flow emit(NetworkStatus.Success(data))
            } else emit(NetworkStatus.Error("Server error!"))
        } catch (exception: Exception) {
            return@flow emit(
                NetworkStatus.Error(
                    "Error while getting image data",
                    cause = exception
                )
            )
        }
    }


}