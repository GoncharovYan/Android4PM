package com.example.androidlab4pm.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.androidlab4pm.bd.DB
import com.example.androidlab4pm.bd.TodoEntity
import com.example.androidlab4pm.bd.TodoRepository
import com.example.androidlab4pm.data.TodoData
import com.example.androidlab4pm.models.TodoItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {
    //    var todoList = MutableLiveData<MutableList<TodoItem>>()
    var todoList: LiveData<List<TodoEntity>>

    init {
//      todoList.value = TodoData.getTodos()
        todoList = repository.getAllTodo().asLiveData(viewModelScope.coroutineContext)
    }

    fun getListTodo() = repository.getAllTodo().asLiveData(viewModelScope.coroutineContext)

    fun addTodo(todo: TodoEntity) = viewModelScope.launch {
        repository.insertTodo(todo)
    }

//    fun addTodo(todo: TodoItem) {
//        var list = todoList.value
//        list!!.add(todo)
//        todoList.postValue(list!!)
//    }
}