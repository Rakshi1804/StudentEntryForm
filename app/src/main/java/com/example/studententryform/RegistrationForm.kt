package com.example.studententryform

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar

class RegistrationForm : AppCompatActivity() {

    lateinit var submit: Button
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

        val submit = findViewById<Button>(R.id.submit)
        submit.setOnClickListener {
            val emailid = findViewById<EditText>(R.id.login_email)
            val email = emailid.text.toString()
            val number = findViewById<EditText>(R.id.phoneno)
            val phone = number.text.toString()
            if (isValidEmail(email) && isValidPhone(phone)) {
                // Email is valid, submit the form
                val toast = Toast.makeText(this, "Form submitted successfully", Toast.LENGTH_SHORT)
                toast.show()
            } else if(!isValidEmail(email)) {
                // Email is invalid, show an error message
                emailid.error = "Invalid email address"
            } else {
                number.error = "Invalid phone number"
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPhone(phone: String): Boolean {
        return phone.length == 10 && android.util.Patterns.PHONE.matcher(phone).matches()

    }
}