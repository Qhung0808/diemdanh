package com.example.diemdanh

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.diemdanh.database.AppDatabase
import com.example.diemdanh.database.ClassRoomDAO
import com.example.diemdanh.databinding.ActivityCreateClassBinding
import com.example.diemdanh.entities.ClassRoom


class CreateClassActivity :AppCompatActivity() {
    val classRoomDAO: ClassRoomDAO = AppDatabase.getInstance(this).classRoomDAO()
    val classRoomList = classRoomDAO.getAllClassRoom()
    private lateinit var binding: ActivityCreateClassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCreateClassBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnCreateClass.setOnClickListener {
            createClass()
            pushClassName()
        }
    }
    fun createClass(){
        if (binding.etClassName.text.toString().isEmpty()) {
            binding.etClassName.error = "Please enter class name"
            return
        }
        for (i in classRoomList) {
            if (i.name == binding.etClassName.text.toString()) {
                binding.etClassName.error = "Class name already exists"
                return
            }
        }
        val classRoom = ClassRoom(name = binding.etClassName.text.toString())
        classRoomDAO.insertClassRoom(classRoom)
        Toast.makeText(this, "Create class successfully", Toast.LENGTH_SHORT).show()
    }
    fun pushClassName(){
        val className = binding.etClassName.text.toString()
        val bundle = Bundle()
        bundle.putString("className", className)
        val intent = Intent(this, ListStudentsActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }


}