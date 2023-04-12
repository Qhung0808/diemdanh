package com.example.diemdanh.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.diemdanh.entities.*


@Database(entities = [Student::class, ClassRoom::class, DetailLessonDate::class,Status ::class,LessonDate::class], version = 1, exportSchema = false )
abstract class AppDatabase : RoomDatabase(){
    abstract fun studentDAO(): StudentDAO
    abstract fun classRoomDAO(): ClassRoomDAO
    abstract fun lessonDayDAO(): LessonDayDAO
    abstract fun statusDAO(): StatusDAO
    abstract fun detailLessonDayDAO(): DetailLessonDayDAO

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(contex : Context): AppDatabase {
            val tempInstance = instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    contex.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                this.instance = instance
                return instance
            }
        }
    }


}