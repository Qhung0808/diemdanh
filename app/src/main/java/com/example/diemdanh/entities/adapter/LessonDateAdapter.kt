package com.example.diemdanh.entities.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.diemdanh.entities.DetailLessonDate
import com.example.diemdanh.entities.LessonDate
import com.example.diemdanh.entities.Status
import com.example.diemdanh.entities.Student

class LessonDateAdapter : BaseAdapter{
    var listData = ArrayList<DetailLessonDate>()
    var layoutInflater : LayoutInflater?= null
    constructor(layoutInflater: LayoutInflater, listDetailLessonDay: ArrayList<DetailLessonDate>){
        this.layoutInflater = layoutInflater
        this.listData = listDetailLessonDay

    }
    fun setListDate (listDetailLessonDay: ArrayList<DetailLessonDate>){
        this.listData = listDetailLessonDay
        notifyDataSetChanged()
    }
    override fun getCount(): Int {
        return listData.size
    }

    override fun getItem(position: Int): Any {
        return listData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("InflateParams")
    override fun getView(position: Int, view: View?, vg: ViewGroup): View {
        val LessonDays = ArrayList<LessonDate>()
        val student = ArrayList<Student>()
        val status = ArrayList<Status>()
        val holder : ViewHolder
        var v = view
        if(v==null){
            holder = ViewHolder()
            v = layoutInflater!!.inflate(com.example.diemdanh.R.layout.item_student, null)
            holder.vLessonDay = v.findViewById(com.example.diemdanh.R.id.tvDateNow)

            holder.vStatus = v.findViewById(com.example.diemdanh.R.id.tvStatus)
            holder.vStudent = v.findViewById(com.example.diemdanh.R.id.tvFullName)
        }else{
            holder = v.tag as ViewHolder
        }
        for (i in 0..LessonDays.size){
            if (listData[position].lessonDate.id == LessonDays[i].id){
                holder.vLessonDay!!.text = LessonDays[i].date.toString()
            }
        }
        for (i in 0..student.size){
            if (listData[position].student.id == student[i].id){
                holder.vStudent!!.text = student[i].fullName
            }
        }
        for (i in 0..status.size){
            if (listData[position].status.id == status[i].id){
                holder.vStatus!!.text = status[i].name
            }
        }
        return v!!



    }
    class ViewHolder{
        var vLessonDay : TextView?= null
        var vStatus : TextView?= null
        var vStudent : TextView?= null
    }


}