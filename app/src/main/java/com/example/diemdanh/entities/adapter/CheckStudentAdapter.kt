package com.example.diemdanh.entities.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.diemdanh.R
import com.example.diemdanh.database.AppDatabase
import com.example.diemdanh.databinding.ActivityListStudentBinding
import com.example.diemdanh.databinding.ItemStudentBinding
import com.example.diemdanh.entities.Status
import com.example.diemdanh.entities.Student

class CheckStudentAdapter(val listStudent: ArrayList<Student>) : RecyclerView.Adapter<CheckStudentAdapter.ViewHolder>(){
    inner class ViewHolder( val binding:ItemStudentBinding,listener: OnItemClickListener ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            binding.tvFullName.text = student.fullName
            binding.tvStatus.text = student.status.name
        }
        init {
            binding.root.setOnClickListener {
                onItemClickListener.onItemClick(adapterPosition)
            }
        }

    }

    private lateinit var onItemClickListener: OnItemClickListener
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemStudentBinding.inflate(LayoutInflater.from(parent.context),parent,false),onItemClickListener)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listStudent[position])

        }
    }

