package com.example.androidlab4pm.bd

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        TodoEntity::class
    ]
)
abstract class DB : RoomDatabase() {

    abstract fun getTodoDao(): TodoDao

    companion object {
        private fun createDB(context: Context): DB {
            return Room.databaseBuilder(context, DB::class.java, "tasks_db")
                .build()
        }

        @Volatile
        private var INSTANCE: DB? = null

        fun getDB(context: Context): DB {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = createDB(context)
                }
            }
            return INSTANCE!!
        }
    }
}