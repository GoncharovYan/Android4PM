package com.example.androidlab4pm.models

class TodoItem(todoName: String) {
    private val todoName: String

    init {
        this.todoName = todoName
    }

    fun getTodoName(): String {
        return this.todoName
    }
}