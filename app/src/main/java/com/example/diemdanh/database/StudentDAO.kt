package com.example.diemdanh.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.diemdanh.entities.Student


@Dao
interface StudentDAO {
    @Insert
    fun insertStudent(student: Student)

    @Query("SELECT * FROM student")
    fun getAllStudent(): ArrayList<Student>

    @Query("SELECT * FROM student WHERE id = :id")
    fun getStudentById(id: Int): Student

    //getadllstudentbyclassroom
    @Query("SELECT * FROM student WHERE classRoom_id = :id")
    fun getAllStudentByClassRoom(id: Int): List<Student>
    //getaddstudentbynameclassroom
    @Query("SELECT * FROM student WHERE fullName LIKE :name")
    fun getAllStudentByClassName(name: String?): ArrayList<Student>



}