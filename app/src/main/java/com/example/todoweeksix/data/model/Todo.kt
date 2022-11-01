package com.example.todoweeksix.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class Todo(
@PrimaryKey(autoGenerate = true)
@ColumnInfo
val id: Int = 0,
@ColumnInfo
val todo: String,
@ColumnInfo
var completed: Boolean = false
)
