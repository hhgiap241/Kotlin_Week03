package com.example.practice_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {
    var radioBtn: RadioButton? = null
    var radioGroup: RadioGroup? = null
    var checkBox_1: CheckBox? = null
    var checkBox_2: CheckBox? = null

    var payBtn: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radioGroup)
        checkBox_1 = findViewById(R.id.checkBox)
        checkBox_2 = findViewById(R.id.checkBox2)
        payBtn = findViewById(R.id.button)

        payBtn?.setOnClickListener {
            var radioID: Int = radioGroup!!.checkedRadioButtonId
            radioBtn = findViewById(radioID)
            var valueList = ArrayList<String>()
            if (radioID !== -1)
                valueList.add(radioBtn!!.text.toString())

            if (checkBox_1!!.isChecked()) {
                valueList.add("Cream")
            }
            if (checkBox_2!!.isChecked()) {
                valueList.add("Sugar")
            }
            Toast.makeText(this, "You choose: " + printList(valueList), Toast.LENGTH_SHORT).show()
        }
    }

    fun printList(valueList: ArrayList<String>): String {
        var string = ""
        if (valueList.size === 0)
            return "Nothing"
        else if (valueList.size === 1)
            return valueList[0]
        else if (valueList.size === 2)
            return valueList[0] + " and " + valueList[1]

        for (i in 0 until valueList.size - 2) {
            string += valueList.get(i)
            string += ", "
        }
        string += valueList[valueList.size - 2]
        string += " and "
        string += valueList[valueList.size - 1]
        return string
    }
}