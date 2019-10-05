package com.example.lab7dialogrv_sec1_603020775_5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.Ass7dialogrv_sec1_603020775_5.R
import kotlinx.android.synthetic.main.std_item_layout.view.*

class StudentsAdapter(val items : List<Student>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate(R.layout.std_item_layout, parent, false)
        return ViewHolder(view_item)
    }
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName?.text = "Name : " + items[position].name
        holder.tvGender?.text = "Gender :" + items[position].gender
        holder.tvEmail?.text = "E-mail : " + items[position].email
        holder.tvSalary?.text = "Salary : " + items[position].salary.toString()
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvName = view.tv_name
    val tvGender = view.tv_gender
    val tvEmail = view.tv_email
    val tvSalary = view.tv_salary
}