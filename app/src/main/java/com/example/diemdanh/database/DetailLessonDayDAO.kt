package com.example.diemdanh.database

import androidx.room.Dao
import androidx.room.Query
import com.example.diemdanh.entities.DetailLessonDate


@Dao
interface DetailLessonDayDAO {

    @Query("SELECT * FROM detail_lesson_day")
    fun getAllDetailLessonDay(): List<DetailLessonDate>

    @Query("SELECT * FROM detail_lesson_day WHERE id = :id")
    fun getDetailLessonDayById(id: Int): DetailLessonDate

    @Query("SELECT * FROM detail_lesson_day WHERE lesson_day_id = (SELECT id FROM lesson_day WHERE date = :lessonDayDate)")
    fun getDetailLessonDayByDate(lessonDayDate: String): List<DetailLessonDate>


}