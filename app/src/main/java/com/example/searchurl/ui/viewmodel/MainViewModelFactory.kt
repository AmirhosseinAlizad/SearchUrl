package com.example.searchurl.ui.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.searchurl.data.repository.PostsRepository

class MainViewModelFactory(application: Application, private val repository: PostsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostsViewModel(repository) as T
    }
}