package com.example.androidlab4pm.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidlab4pm.bd.TodoRepository
import java.lang.IllegalArgumentException

class TodoViewModelFactory(private val todoRepository: TodoRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(TodoViewModel::class.java)) {
            return TodoViewModel(todoRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}