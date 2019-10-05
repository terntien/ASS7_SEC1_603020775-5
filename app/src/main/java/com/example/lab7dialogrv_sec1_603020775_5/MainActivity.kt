package com.example.Ass7dialogrv_sec1_603020775_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab7dialogrv_sec1_603020775_5.Student
import com.example.lab7dialogrv_sec1_603020775_5.StudentsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.*


class MainActivity : AppCompatActivity() {
    val studentList = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testStudentData()
        recycler_view.adapter = StudentsAdapter(this.studentList,applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.itemAnimator = DefaultItemAnimator()
    }

    fun addStudent(v: View) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout, null)
        val mBuilder = AlertDialog.Builder(this)
            mBuilder.setView(mDialogView)
        val mAlertDialog = mBuilder.show()

        mDialogView.btnAdd.setOnClickListener{
            studentList.add(Student(
                mDialogView.edt_name.text.toString(),
                mDialogView.radioGroup.id.toString(),
                mDialogView.edt_email.text.toString(),
                mDialogView.edt_salary.text.toString()))
            recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(applicationContext, "The student is added successfully", Toast.LENGTH_SHORT).show()
            mAlertDialog.dismiss()
        }

        mDialogView.btnCancel.setOnClickListener() {
            mAlertDialog.dismiss()
        }
    }
    fun testStudentData() {
        studentList.add(Student("Sara","Male", "sara@gmail.com","35000"))
        studentList.add(Student( "Tony","Female", "tony@gmail.com","45000"))
    }
}