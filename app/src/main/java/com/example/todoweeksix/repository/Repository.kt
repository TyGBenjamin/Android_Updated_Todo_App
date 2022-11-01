package com.example.todoweeksix.repository

import com.example.todoweeksix.data.model.Todo
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getTodos(): Flow<List<Todo>>
    suspend fun deleteTodo(todo: Todo)
    suspend fun insertTodo(todo: Todo)
    suspend fun updateTodo(todo: Todo)

}
