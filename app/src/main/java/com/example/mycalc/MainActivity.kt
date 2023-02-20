package com.example.mycalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var selectedDate: TextView? = null
    private var selectedDateText: TextView? = null
    private var ageInMinutes: TextView? = null
    private var ageInMinutesText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePickerBtn: Button = findViewById(R.id.datePickerButton)
        selectedDate = findViewById(R.id.selectedDate)
        selectedDateText = findViewById(R.id.selectedDateText)
        ageInMinutes = findViewById(R.id.ageInMinute)
        ageInMinutesText = findViewById(R.id.ageInMinuteText)

        datePickerBtn.setOnClickListener {
            datePickerOnclick()
        }
    }

    fun datePickerOnclick() {


        val theCalender = Calendar.getInstance()

        val currentYear = theCalender.get(Calendar.YEAR)
        val currentMonth = theCalender.get(Calendar.MONTH)
        val currentDay = theCalender.get(Calendar.DAY_OF_MONTH)


        DatePickerDialog(this,
            { view, selectedYear, selectedMonth, selectedDay ->

                selectedDate?.text = "$selectedDay/${selectedMonth+1}/$selectedYear"
                selectedDateText?.text = "was entered"
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate?.text as String)
                val selectedDateInMinute = theDate.time / 60000

                val theCurrentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMinute = theCurrentDate.time / 60000

                ageInMinutes?.text = (currentDateInMinute - selectedDateInMinute).toString()
                ageInMinutesText?.text = "minutes lived!"
            }, currentYear, currentMonth, currentDay
        ).show()
//

    }
}