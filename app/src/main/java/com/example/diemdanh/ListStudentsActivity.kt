package com.example.diemdanh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.diemdanh.database.AppDatabase
import com.example.diemdanh.databinding.ActivityListStudentBinding
import com.example.diemdanh.databinding.ItemStudentBinding

import com.example.diemdanh.entities.Status
import com.example.diemdanh.entities.Student
import com.example.diemdanh.entities.adapter.CheckStudentAdapter
import com.example.diemdanh.entities.adapter.LessonDateAdapter



import java.time.LocalDate

class ListStudentsActivity : AppCompatActivity() {
    var check : Int = 0
    private lateinit var binding: ActivityListStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityListStudentBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvDateNow.text = LocalDate.now().toString()
        val listStudent = AppDatabase.getInstance(this).studentDAO().getAllStudentByClassName(intent.getStringExtra("className"))
        binding.lvUsers.adapter = CheckStudentAdapter(listStudent)
        binding.lvUsers.setOnClickListener(object : CheckStudentAdapter.OnItemClickListener,
            View.OnClickListener {


            override fun onClick(v: View?) {
                TODO("Not yet implemented")
            }

            override fun onItemClick(position: Int) {
                check++
                checkStudent()
            }
        })
    }

    fun checkStudent(){
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(this))
        var listStatus = ArrayList<Status>()
        listStatus=AppDatabase.getInstance(this).statusDAO().getAllStatus()
        if (check ==0){
            binding.tvStatus.text = listStatus[0].name
        }else if (check ==1) {
            binding.tvStatus.text = listStatus[1].name //kotlin-android-extensions
        }else if (check ==2) {
            binding.tvStatus.text = listStatus[2].name
            check=0
        }
    }
}