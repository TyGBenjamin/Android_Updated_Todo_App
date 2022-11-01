package com.example.todoweeksix.domain

import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoweeksix.data.model.Todo
import com.rave.todoweeksix.databinding.ItemListBinding

class TodoAdapter(
    private val insertTodo: (Todo) -> Unit,
    private val todos: List<Todo> = emptyList()
    //    private val todos: MutableList<Todo> = mutableListOf()

) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    inner class TodoViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun applyTodo(todo: Todo) = with(binding) {
            submittedTodo.text = todo.todo
            checkbox.isChecked = todo.completed
            checkbox.setOnCheckedChangeListener { _, completed ->
                insertTodo(
                    Todo(
                        id = todo.id,
                        todo = todo.todo,
                        completed = completed
                    )
                )
                toggleStrikeThrough(tvTodo = submittedTodo, completed)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)

    }
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        Log.d("TODOLOG", "onBindViewHolder: $todos ARE HERE ")
        val todo = todos[position]
        holder.applyTodo(todo)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    private fun toggleStrikeThrough(tvTodo: TextView, completed: Boolean) {
        if (completed) {
            tvTodo.paintFlags = tvTodo.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodo.paintFlags = tvTodo.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}
