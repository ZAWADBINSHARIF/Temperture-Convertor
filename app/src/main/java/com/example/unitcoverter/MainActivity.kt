package com.example.unitcoverter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var lastNumber: Boolean = false
    private var isDot: Boolean = false

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner1 = findViewById<Spinner>(R.id.formSpinner)
        spinner2 = findViewById<Spinner>(R.id.toSpinner)

        val operation = arrayOf(UnitVaL.C, UnitVaL.F)
        val operationAdapter =
            ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, operation)

        spinner1.adapter = operationAdapter
        spinner2.adapter = operationAdapter
    }

    fun onDigit(view: View) {
        formText.append((view as Button).text)

        lastNumber = true
    }

    fun onClear(view: View) {
        formText.text = ""
        toText.text = ""
        lastNumber = false
        isDot = false
    }

    fun onCross(view: View) {
        val textEdit = formText.text.toString()
        if (textEdit.isNotEmpty()) {
            formText.text = textEdit.substring(0, textEdit.length - 1)
        }
    }

    fun onDot(view: View) {
        val textEdit = formText.text.toString()
        /*
        * this condition for "."
        * */
        val hasDot = textEdit.any { it == '.' }  /* FormText has any '.' ->  true or false*/

        when {  // when FormText has no '.'
            !hasDot -> {
                lastNumber = true
                isDot = false

                when {
                    (lastNumber && !isDot) -> {
                        when {
                            !textEdit.isNotEmpty() -> formText.append("0")
                        }   // when FormText is Empty if click "." then FormText will show "0."
                        formText.append(btnDot.text)
                        lastNumber = false
                        isDot = true
                    }
                }
            }
            else -> {
                lastNumber = false
                isDot = true
            }
        }

    }

    fun onEqual(view: View) {
        Logic(spinner1, spinner2, formText, toText)
    }
}
