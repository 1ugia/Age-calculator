package com.practice.dobtimecal

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate : TextView? = null //imports it in, will not initialise it until onCreate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button = findViewById(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate) // assigning the value - initialising the textView

        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }

    }

    fun clickDatePicker(){

        val myCalendar = Calendar.getInstance()

        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this, {
                view,
                selectedYear,
                selectedMonth,
                selectedDayOfMonth ->

                Toast.makeText(
                    this,
                    "Year: $selectedYear, Month: ${selectedMonth+1}" +
                            ", Day: $selectedDayOfMonth",
                    Toast.LENGTH_LONG
                ).show()

                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

                tvSelectedDate?.text = selectedDate

            }, year, month, day
        ).show()

    }
}