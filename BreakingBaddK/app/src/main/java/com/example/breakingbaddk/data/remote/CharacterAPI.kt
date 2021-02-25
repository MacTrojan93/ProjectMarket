package com.example.breakingbaddk.data.remote

import com.example.breakingbaddk.BuildConfig
import com.example.breakingbaddk.data.model.DataCharacter
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterAPI {
    @GET("characters")
    suspend fun getCharacters(@Query("name") name:String): Response<DataCharacter>

    @GET("characters")
    suspend fun getListOfCharacters(): List<DataCharacter>

    companion object{
        private fun buildRetrofit(): Retrofit{
            return Retrofit.Builder()
                .client(OkHttpClient.Builder().apply {
                    connectionPool(ConnectionPool())
                }.build())
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }
        fun getCharacterApi() = buildRetrofit().create(CharacterAPI::class.java)
    }
}