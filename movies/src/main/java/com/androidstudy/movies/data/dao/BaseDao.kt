package com.androidstudy.movies.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update

interface BaseDao<T> {

    @Insert(onConflict = REPLACE)
    fun insert(item: T)

    @Insert(onConflict = REPLACE)
    fun insert(vararg items: T)

    @Insert(onConflict = REPLACE)
    fun insert(items: List<T>)

    @Update(onConflict = REPLACE)
    fun update(item: T)

    @Delete
    fun delete(item: T)
}