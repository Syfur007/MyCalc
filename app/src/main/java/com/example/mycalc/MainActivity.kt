package com.example.mycalc

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var lastNumeric: Boolean = false
    private var lastDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onDigit(view: View) {
        lastNumeric = true
        findViewById<TextView>(R.id.tvInput).append((view as Button).text)

    }

    fun onClear(view: View) {
        findViewById<TextView>(R.id.tvInput).text = ""
        lastDot = false
        lastNumeric = false
    }

    fun onDecimalPoint(view: View) {
        if(lastNumeric and !lastDot) {
            findViewById<TextView>(R.id.tvInput).append((view as Button).text)
            lastDot = true
        }
    }

    fun onOperator(view: View) {
        if(lastNumeric and !isOperatorAdded()) {
            findViewById<TextView>(R.id.tvInput).append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }

    }

    private fun isOperatorAdded(): Boolean {
        val tvScreen: TextView = findViewById(R.id.tvInput)
        return if (tvScreen.text.startsWith("-")) false
        else {
            tvScreen.text.contains("%") || tvScreen.text.contains("/")
                    || tvScreen.text.contains("X") || tvScreen.text.contains("-")
                    || tvScreen.text.contains("+")
        }
    }
}