package com.example.androidlab4pm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidlab4pm.R
import com.example.androidlab4pm.bd.TodoEntity
import com.example.androidlab4pm.models.TodoItem

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoHolder>() {

    private var todos: List<TodoEntity> = ArrayList()

    class TodoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(todo: TodoEntity) = with(itemView) {
            val todoName = findViewById<TextView>(R.id.textTodo)
            todoName.text = todo.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        return TodoHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.todo_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        holder.bind(todos[position])
    }

    override fun getItemCount() = todos.size

    fun refreshList(todos: List<TodoEntity>) {
        this.todos = todos
        notifyDataSetChanged()
    }
}


//class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoHolder>() {
//
//    private var todos: List<TodoItem> = ArrayList()
//
//    class TodoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        fun bind(todo: TodoItem) = with(itemView) {
//            val todoName = findViewById<TextView>(R.id.textTodo)
//            todoName.text = todo.getTodoName()
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
//        return TodoHolder(
//            LayoutInflater.from(parent.context)
//                .inflate(R.layout.todo_item, parent, false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
//        holder.bind(todos[position])
//    }
//
//    override fun getItemCount() = todos.size
//
//    fun refreshList(todos: List<TodoItem>) {
//        this.todos = todos
//        notifyDataSetChanged()
//    }
//}
