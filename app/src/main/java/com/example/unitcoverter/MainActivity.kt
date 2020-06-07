package com.example.unitcoverter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lastNumberic: Boolean = false
    var isDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View) {
        formText.append((view as Button).text)

        lastNumberic = true
    }

    fun onClear(view: View) {
        formText.text = ""
        lastNumberic = false
        isDot = false
    }

    fun onCross(view: View) {
        val textEdit = formText.text.toString()
        if (textEdit.isNotEmpty()) {
            formText.text = textEdit.substring(0, textEdit.length - 1)
            val pattern = Regex(".")
            lastNumberic = true
            isDot = false
        }
    }

    fun onDot(view: View) {
        if (lastNumberic && !isDot) {
            formText.append(btnDot.text)
            lastNumberic = false
            isDot = true
        }
    }
}
