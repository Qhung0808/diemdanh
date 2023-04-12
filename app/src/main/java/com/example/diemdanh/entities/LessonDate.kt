package com.example.diemdanh.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "lesson_day")
data class LessonDate(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val date: Date,


)
