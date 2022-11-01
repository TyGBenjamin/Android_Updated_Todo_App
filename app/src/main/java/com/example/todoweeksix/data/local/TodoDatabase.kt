package com.example.todoweeksix.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoweeksix.data.model.Todo

@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}
