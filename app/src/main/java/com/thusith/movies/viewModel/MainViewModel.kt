package com.thusith.movies.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.thusith.movies.domain.FilmItemModel
import com.thusith.movies.repository.MainRepository

class MainViewModel:ViewModel() {
    private val repository=MainRepository()

    fun loadUpcoming():LiveData<MutableList<FilmItemModel>> {
        return repository.loadUpcoming()
    }

    fun loadItems():LiveData<MutableList<FilmItemModel>> {
        return repository.loadItems()
    }
}
