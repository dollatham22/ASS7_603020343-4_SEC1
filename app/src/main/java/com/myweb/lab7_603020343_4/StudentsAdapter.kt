package com.myweb.lab7_603020343_4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.std_item_layout.view.*

class StudentsAdapter (val items : List<Student>, val context: Context ) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate(R.layout.std_item_layout, parent, false)
        return ViewHolder(view_item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvname?.text = "Name : " + items[position].name
        holder.tvgen?.text = "Gender : " + items[position].gender
        holder.tvemail?.text = "Email : " + items[position].email
        holder.tvsalary?.text = "Salary : " + items[position].salary.toString()

    }
}
class ViewHolder (view : View) : RecyclerView.ViewHolder(view){
    val tvname  = view.tv_name
    val tvgen = view.tv_gen
    val  tvemail = view.tv_email
    val tvsalary = view.tv_salary
}
