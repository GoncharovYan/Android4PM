package com.example.androidlab4pm.bd

class TodoRepository(private val database: DB) {

    suspend fun insertTodo(todoEntity: TodoEntity) {
        database.getTodoDao().insertTodo(todoEntity)
    }

    fun getAllTodo() = database.getTodoDao().getTodos()
}