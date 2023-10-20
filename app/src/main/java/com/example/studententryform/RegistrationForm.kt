package com.example.studententryform

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TextView
import java.util.Calendar

class RegistrationForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_form)

        //Take date from calender and display it
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val calendarIcon = findViewById<ImageView>(R.id.calendarIcon)
        val dateTextView = findViewById<TextView>(R.id.dateTextView)
        calendarIcon.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${month + 1}/$year"
                // Set the selected date in the TextView
                dateTextView.text = selectedDate
            }, year, month, dayOfMonth)
            datePickerDialog.show()
        }
    }
}