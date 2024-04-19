package com.example.androidlab4pm.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.androidlab4pm.R
import com.example.androidlab4pm.adapters.TodoAdapter
import com.example.androidlab4pm.bd.DB
import com.example.androidlab4pm.bd.TodoEntity
import com.example.androidlab4pm.bd.TodoRepository
import com.example.androidlab4pm.models.TodoItem
import com.example.androidlab4pm.viewmodels.TodoViewModel
import com.example.androidlab4pm.viewmodels.TodoViewModelFactory
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.w3c.dom.Text

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Header
        setHeader()

        //Recycler
        //val todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        val todoViewModel = ViewModelProvider(this,
            TodoViewModelFactory(TodoRepository(DB.getDB(this)))
        ).get(TodoViewModel::class.java)

        setTodosList(todoViewModel)

        //Add todos
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        buttonAdd.setOnClickListener {
            val todoText = findViewById<TextInputEditText>(R.id.inputTodo)
            todoViewModel.addTodo(TodoEntity(name=todoText.text.toString()))
        }
    }

    fun setHeader() {
        val textName = findViewById<TextView>(R.id.textName)
        val intent = intent.getStringExtra("name")
        textName.text = intent
    }

    fun setTodosList(todoViewModel: TodoViewModel) {
        val recyclerTodoList = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = TodoAdapter()

        recyclerTodoList.adapter = adapter
        recyclerTodoList.layoutManager = LinearLayoutManager(this)

        todoViewModel.getListTodo().observe(this, Observer {
            it?.let {
                adapter.refreshList(it)
            }
        })
    }
}