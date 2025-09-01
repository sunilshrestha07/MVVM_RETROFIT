package com.example.crud.data.repository

import com.example.todoapp.data.remote.RetrofitInstance

class DressRepository() {
    val api = RetrofitInstance.api

    suspend fun getDress() = api.getDress()
    suspend fun deleteDress(id: String) = api.deleteDress(id)
}