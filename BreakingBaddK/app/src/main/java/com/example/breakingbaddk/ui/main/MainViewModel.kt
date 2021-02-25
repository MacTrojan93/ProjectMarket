package com.example.breakingbaddk.ui.main

import android.util.Log
import androidx.lifecycle.*
import com.example.breakingbaddk.data.model.DataCharacter
import com.example.breakingbaddk.data.remote.CharacterAPI
import com.example.breakingbaddk.data.repository.CharacterRepository
import com.example.breakingbaddk.data.repository.CharacterRepositoryImpl
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

private const val TAG = "MainViewModel"
class MainViewModel( val repo: CharacterRepository) : ViewModel() {
    private val mutableDataSet: MutableLiveData<List<DataCharacter>> = MutableLiveData()

    fun getListOfCharacters(): LiveData<List<DataCharacter>>{
        return mutableDataSet
    }

    class MainViewModelFactory: ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            val api = CharacterAPI.getCharacterApi()
            val repoImpl = CharacterRepositoryImpl(api)
            return MainViewModel(repoImpl) as T
        }
    }


    fun updateDataCharacters() {
        viewModelScope.launch {
            val response = repo.getCharacters()
            mutableDataSet.value = response
            Log.d(TAG, "updateDataCharacters: $response")
        }
    }


}