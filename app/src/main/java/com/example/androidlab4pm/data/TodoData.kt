package com.example.androidlab4pm.data

import com.example.androidlab4pm.models.TodoItem

object TodoData {
    fun getTodos() = mutableListOf<TodoItem>(
        TodoItem("Полить кота"),
        TodoItem("Помыть цветы"),
        TodoItem("Помочь маме"),
    )

    fun getTodosFromBd() {

    }
}