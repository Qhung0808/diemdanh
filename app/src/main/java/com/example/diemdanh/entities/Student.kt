package com.example.diemdanh.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "student")
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int,
//    var holyName: String,
    var fullName: String,
//    var dateOfBirth : Date,
//    var familyName : String,
//    var sex : String,
    @Embedded(prefix = "classRoom_")
    var classRoom : ClassRoom,
    @Embedded(prefix = "status_")
    var status : Status,



    ) {
    constructor() : this(0, "", ClassRoom(), Status())
}


