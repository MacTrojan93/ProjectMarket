package com.example.breakingbaddk.data.repository

import com.example.breakingbaddk.data.model.DataCharacter
import com.example.breakingbaddk.data.remote.CharacterAPI
import retrofit2.Response

class CharacterRepositoryImpl(val characterRemote: CharacterAPI) : CharacterRepository{

    override suspend fun getCharacterByName(inputName: String): Response<DataCharacter> {
        return characterRemote.getCharacters(inputName)
    }

    override suspend fun getCharacters(): List<DataCharacter> {
        return characterRemote.getListOfCharacters()
    }
}