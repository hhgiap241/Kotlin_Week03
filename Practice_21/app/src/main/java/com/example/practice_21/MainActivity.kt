package com.example.practice_21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    val usaDf = DecimalFormat("###,###,###,###.##");

    // tinh toi ngay 26/2/2022
    val conversionList = doubleArrayOf(0.74547, 0.88700, 22827.32, 1.0, 116.11)


    var convertBtn: Button? = null
    var inputText: EditText? = null
    var outputText: EditText? = null
    var spinner: Spinner? = null
    var spinner_2: Spinner? = null
    val listOfItem = arrayOf(
        "Bảng Anh (GBP)",
        "Euro (EUR)",
        "Việt Nam Đồng (VND)",
        "Đô la Mỹ (USD)",
        "Yên Nhật (JPY)"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputText = findViewById(R.id.inputText)
        outputText = findViewById(R.id.outputText)
        spinner = findViewById(R.id.spinner)
        spinner_2 = findViewById(R.id.spinner2)
        convertBtn = findViewById(R.id.button)

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOfItem)

        spinner!!.adapter = arrayAdapter
        spinner_2!!.adapter = arrayAdapter
        var fromCurrency: String = ""
        var toCurrency: String = ""
        var firstPos = 0
        var secondPos = 0
        spinner!!.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                fromCurrency = listOfItem[p2]
                firstPos = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        spinner_2!!.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                toCurrency = listOfItem[p2]
                secondPos = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        // handling
        convertBtn!!.setOnClickListener {
            if (TextUtils.isEmpty(inputText!!.text.toString())) { // check if input is empty
                inputText!!.setError("This field can't be empty")
                Toast.makeText(this, "Please input a number first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var value: Double = inputText!!.text.toString().toDouble()
            var result: Double = value * conversionList[secondPos] / conversionList[firstPos]

            outputText!!.setText(usaDf.format(result) + " " + toCurrency)
        }
    }
}