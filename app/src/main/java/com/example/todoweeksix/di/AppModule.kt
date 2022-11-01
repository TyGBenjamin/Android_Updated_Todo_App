package com.example.todoweeksix.di

import android.content.Context
import androidx.room.Room
import com.example.todoweeksix.data.local.TodoDao
import com.example.todoweeksix.data.local.TodoDatabase
import com.example.todoweeksix.data.repository.RepositoryImpl
import com.example.todoweeksix.repository.Repository
import com.example.todoweeksix.util.DataStoreImpl
import com.example.todoweeksix.util.DataStoreSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun providesRoomDB(@ApplicationContext applicationContext: Context): TodoDao = Room.databaseBuilder(
        applicationContext,
        TodoDatabase::class.java, "todo-database"
    ).build().todoDao()

    @Provides
    fun providesRepo(todoDao:TodoDao) : Repository = RepositoryImpl(todoDao)



//    @Provides
//    @Singleton
//    fun provideDataStore(@ApplicationContext context: Context): DataStoreSource = DataStoreImpl(context)
}

