package com.example.diemdanh.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "class")
data class ClassRoom(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var name: String,
) {
    constructor() : this(0, "")
    constructor(name: String) : this(0, name)
}
