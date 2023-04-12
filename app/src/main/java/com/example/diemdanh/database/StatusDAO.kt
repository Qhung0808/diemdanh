package com.example.diemdanh.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.diemdanh.entities.Status


@Dao
interface StatusDAO {

    @Insert
    fun insertStatus(status: Status)

    @Query("SELECT * FROM status")
    fun getAllStatus(): ArrayList<Status>

    @Query("SELECT * FROM status WHERE id = :id")
    fun getStatusById(id: Int): Status
}