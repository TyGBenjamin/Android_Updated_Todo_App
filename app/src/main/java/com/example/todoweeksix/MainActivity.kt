package com.example.todoweeksix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.todoweeksix.data.model.Todo
import com.example.todoweeksix.domain.TodoAdapter
import com.example.todoweeksix.domain.TodoViewModel
import com.rave.todoweeksix.R
import com.rave.todoweeksix.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val todoAdapter by lazy { TodoAdapter(viewModel::insertTodo) }

    //    private lateinit var adapter: TodoAdapter
    val viewModel: TodoViewModel by viewModels()

    //    val _binding: ActivityMainBinding? = null
//    val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        lifecycleScope.launch {
//            todoList = viewModel.Todo.collectLatest {}
            viewModel.Todo.collectLatest { it ->
//                todoList = mutableListOf(it)
//                binding.rvTodo.adapter = todoAdapter
                binding.rvView.adapter = TodoAdapter(viewModel::insertTodo,it)
            }
        }

        binding.btnAdd.setOnClickListener() {
            println("Add button clicked")
            lifecycleScope.launch {
                val addTodo = binding.tvEditText.text.toString()
                if (addTodo.isNotEmpty()) {
                    val newTodo = Todo(todo = addTodo)
                    viewModel.insertTodo(newTodo)
                }
            }
        }

        binding.btnDelete.setOnClickListener() {
            println("Delete button clicked")
            lifecycleScope.launch {
                viewModel.Todo.value.forEach { Todo ->
                    if (Todo.completed){
                        viewModel.deleteTodo(Todo)
                    }
                }
            }
        }
    }
}


