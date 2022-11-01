package com.example.todoweeksix.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoweeksix.data.model.Todo
import com.example.todoweeksix.data.repository.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val repo: RepositoryImpl
) : ViewModel() {
    private val _Todo: MutableStateFlow<List<Todo>> = MutableStateFlow(mutableListOf())
    val Todo = _Todo.asStateFlow()

    init{
        getTodos()
    }

    fun getTodos(){
        viewModelScope.launch {
            repo.getTodos().collectLatest { todo ->
                _Todo.value = todo

            }
        }
    }
    fun insertTodo(todo:Todo){
        viewModelScope.launch {
            repo.insertTodo(todo)
        }
    }
    fun deleteTodo(todo:Todo){
        viewModelScope.launch {
            repo.deleteTodo(todo)
        }
    }
    fun updateTodo(todo:Todo){
        viewModelScope.launch{
            repo.updateTodo(todo)
        }
    }
}
