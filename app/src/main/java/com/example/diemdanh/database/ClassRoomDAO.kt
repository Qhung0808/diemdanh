package com.example.diemdanh.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.diemdanh.entities.ClassRoom

@Dao
interface ClassRoomDAO {

    @Insert
    fun insertClassRoom(classRoom: ClassRoom)

    @Query("SELECT * FROM class")
    fun getAllClassRoom(): List<ClassRoom>

    @Query("SELECT * FROM class WHERE id = :id")
    fun getClassRoomById(id: Int): ClassRoom

    @Query("SELECT * FROM class WHERE name = :name")
    fun getClassRoomByName(name: String): ClassRoom


    @Query("SELECT EXISTS(SELECT * FROM class WHERE name = :name)")
    fun existClass(name: String): Boolean

    @Query("DELETE FROM class WHERE id = :id")
    fun deleteClassRoomById(id: Int)

    @Query("DELETE FROM class")
    fun deleteAllClassRoom()




}