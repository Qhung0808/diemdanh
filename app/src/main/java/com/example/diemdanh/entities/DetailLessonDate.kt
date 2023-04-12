package com.example.diemdanh.entities

import android.widget.ListAdapter
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "detail_lesson_day")
data class DetailLessonDate (
    @PrimaryKey(autoGenerate = true) val id: Int,

    @Embedded(prefix = "lesson_day_")
    val lessonDate : LessonDate,
    @Embedded(prefix = "student_")
    val student : Student,
    @Embedded(prefix = "status_")
    val status : Status,

    )