package com.example.diemdanh.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.diemdanh.entities.DetailLessonDate


@Dao
interface LessonDayDAO {

    @Query("SELECT * FROM lessonday")
    fun getAllLessonDay(): List<DetailLessonDate>

    @Query("SELECT * FROM lessonday WHERE id = :id")
    fun getLessonDayById(id: Int): DetailLessonDate

    @Query("SELECT * FROM lessonday WHERE classRoom_id = :id")
    fun getAllLessonDayByClassRoom(id: Int): List<DetailLessonDate>

    @Insert
    fun insertLessonDay(lessonDay: DetailLessonDate)

}