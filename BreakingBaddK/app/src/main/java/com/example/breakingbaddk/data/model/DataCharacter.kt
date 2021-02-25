package com.example.breakingbaddk.data.model

import com.squareup.moshi.Json


data class DataCharacter(
    @Json(name = "char_id")
    val _id: Int,
    val name: String,
    val birthday: String,
    val occupation: List<String>,
    val status: String,
    val nickname: String,
    @Json(name = "appearance")
    val season: String,
    @Json(name = "img")
    val image: String
)