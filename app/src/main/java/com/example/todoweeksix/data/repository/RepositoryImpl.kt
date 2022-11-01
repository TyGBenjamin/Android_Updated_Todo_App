package com.example.todoweeksix.data.repository

import com.example.todoweeksix.data.local.TodoDao
import com.example.todoweeksix.data.model.Todo
import com.example.todoweeksix.repository.Repository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class RepositoryImpl @Inject constructor(private val todoDao: TodoDao) : Repository {
    override suspend fun getTodos(): Flow<List<Todo>> {
        return todoDao.getTodos()
    }

    override suspend fun deleteTodo(todo: Todo) = withContext(Dispatchers.IO) {
        todoDao.deleteTodo(todo)
    }


    override suspend fun insertTodo(todo: Todo) = withContext(Dispatchers.IO) {
        todoDao.insertTodo(todo)
    }


    override suspend fun updateTodo(todo: Todo) = withContext(Dispatchers.IO) {
        todoDao.updateTodo(todo)
    }
}


