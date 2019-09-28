package com.myweb.lab7_603020343_4

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
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.*
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
    fun addStudent(v: View){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout, null)
        val mbuilder = AlertDialog.Builder(this)
        mbuilder.setView(mDialogView)
        val mAlertDialog = mbuilder.show()
        mDialogView.btnAdd.setOnClickListener{

            var gen :Int = mDialogView.radio_gd.checkedRadioButtonId;
            var gender :RadioButton = mDialogView.findViewById(gen);

            studentList.add (Student (mDialogView.edt_name.text.toString(),gender.text.toString(), mDialogView.edt_mail.text.toString(),
                mDialogView.edt_salary.text.toString().toInt()))
            recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(applicationContext, "The Student is added successfully",Toast.LENGTH_SHORT).show()
            mAlertDialog.dismiss()
        }
        mDialogView.btnCancel.setOnClickListener(){
            mAlertDialog.dismiss()
        }
    }
        fun testStudentData() {
            studentList.add(Student(name = "New" , gender = "Male" ,email = "New@kkumail.com" ,salary = 22000))

        }

    }
