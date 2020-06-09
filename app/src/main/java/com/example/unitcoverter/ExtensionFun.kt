package com.example.unitcoverter

import android.widget.Spinner
import android.widget.TextView

fun Logic(
    spinner1: Spinner,
    spinner2: Spinner,
    formText: TextView,
    toText: TextView
) {
    val spinner_1 = spinner1.selectedItem.toString()
    val spinner_2 = spinner2.selectedItem.toString()
    val formText_Op = formText.text.toString().toFloat()

    when {
        spinner_1 == UnitVaL.C && spinner_2 == UnitVaL.F -> {
            toText.text = "${((formText_Op / 5) * 9) + 32}"
        }
        spinner_1 == UnitVaL.F && spinner_2 == UnitVaL.C -> {
            toText.text = "${((formText_Op - 32) / 9) * 5}"
        }
        spinner_1 == UnitVaL.C && spinner_2 == UnitVaL.C -> {
            toText.text = formText.text
        }
        spinner_1 == UnitVaL.F && spinner_2 == UnitVaL.F -> {
            toText.text = formText.text
        }
    }
}
