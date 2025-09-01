package com.example.crud.UI.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crud.data.model.Dress
import com.example.crud.data.repository.DressRepository
import com.example.todoapp.data.remote.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class DressViewModel: ViewModel() {
    private val repo = DressRepository()
    private val _dressList = MutableStateFlow<List<Dress>>(emptyList())
    val dress: StateFlow<List<Dress>> = _dressList

    init {
        getDress()
    }

    fun getDress() {
        viewModelScope.launch {
            try {
                val response = repo.getDress()
                if (response.isSuccessful) {
                    _dressList.value = response.body() ?: emptyList()
                }else{
                    Log.d("DressElse", "The response is not successful")
                }
            }catch (ex: Exception){
                Log.d("DressException", "The exception is ${ex.message}")

            }
        }
    }
}