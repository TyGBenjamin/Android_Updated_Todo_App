package com.example.todoweeksix.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todoweeksix.data.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query( "SELECT * FROM todos")
    fun getTodos(): Flow<List<Todo>>

    @Update
    fun updateTodo(todo:Todo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo( todo: Todo)

    @Delete
    fun deleteTodo(todo: Todo)
}
