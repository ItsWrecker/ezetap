package com.wrecker.network.entities

sealed class ResponseEntities {
    data class UiResponse(
        val `logo-url`: String? = null,
        val `heading-text`: String? = null,
        val uidata: List<UiData>
    )

    data class UiData(
        val uitype: String? = null,
        val key: String? = null,
        val value: String? = null,
        val hint: String? = null
    )


    data class ImageResponse(
        val `logo-url`: String? = null
    )
}
