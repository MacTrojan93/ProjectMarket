package com.example.breakingbaddk.data.repository

import com.example.breakingbaddk.data.model.DataCharacter
import retrofit2.Response

interface CharacterRepository {

    suspend fun getCharacterByName(inputName: String): Response<DataCharacter>
    suspend fun getCharacters(): List<DataCharacter>
}