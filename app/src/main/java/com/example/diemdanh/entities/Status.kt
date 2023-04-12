package com.example.diemdanh.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "status")
data class Status (
    @PrimaryKey(autoGenerate = true) var id: Int,
    var name: String,

    ){
    constructor() : this(0, "")
    constructor(name: String) : this(0, name)
}