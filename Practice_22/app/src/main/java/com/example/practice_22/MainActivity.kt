package com.example.practice_22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    val stringFormat = DecimalFormat("###,###,###,###.##");
    var billET: EditText? = null
    var tipET: EditText? = null
    var numOfPeopleET: EditText? = null
    var calculateBtn: Button? = null
    var tipAmountTV: TextView? = null
    var totalAmountTV: TextView? = null
    var totalPerPerson: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        billET = findViewById(R.id.billET)
        tipET = findViewById(R.id.tipET)
        numOfPeopleET = findViewById(R.id.noOfPeopleET)
        calculateBtn = findViewById(R.id.button)
        tipAmountTV = findViewById(R.id.tipAmountTV)
        totalAmountTV = findViewById(R.id.totalAmountTV)
        totalPerPerson = findViewById(R.id.totalPerPersonTV)

        calculateBtn!!.setOnClickListener {
            if (TextUtils.isEmpty(billET!!.text.toString()) ||
                TextUtils.isEmpty(tipET!!.text.toString()) ||
                TextUtils.isEmpty(numOfPeopleET!!.text.toString())
            ) {
                Toast.makeText(this, "Please input all fields!!!", Toast.LENGTH_SHORT).show()
            } else {
                var tipTotal =
                    billET!!.text.toString().toDouble() * tipET!!.text.toString().toDouble()/100
                var totalCost = billET!!.text.toString().toDouble() + tipTotal
                var eachPerson = totalCost / numOfPeopleET!!.text.toString().toDouble()

                tipAmountTV!!.setText("$" + stringFormat.format(tipTotal))
                totalAmountTV!!.setText("$" + stringFormat.format(totalCost))
                totalPerPerson!!.setText("$" + stringFormat.format(eachPerson))
            }
        }

    }
}