package com.example.kk4.shared.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SampleModel(
    @SerialName("name")
    val name: String,
    @SerialName("test")
    val test: Int
)
