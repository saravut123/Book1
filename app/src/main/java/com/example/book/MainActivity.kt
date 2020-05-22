package com.example.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var save: Button? = null
    private var SHOW: Button? = null
    private var COST: Button? = null
    private var ID: EditText? = null
    private var DAY: EditText? = null
    private var MONTH: EditText? = null
    private var YEAR: EditText? = null
    private var TIME: EditText? = null
    private var MONEYINTO: EditText? = null
    private var MONEYOUT: EditText? = null
    private var DETAILS: EditText? = null
    private var databaseHelper: DatabaseHelper? = null
    private var tvname: TextView? = null
    private var Value: TextView? = null
    private var resetBtn: Button? = null
    private var arrayList: ArrayList<String>? = null
    private var Sumlist: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        databaseHelper = DatabaseHelper(this)
        tvname = findViewById(R.id.tvname) as TextView
        Value = findViewById(R.id.value) as TextView
        save = findViewById(R.id.save) as Button
        SHOW = findViewById(R.id.SHOW) as Button
        ID = findViewById(R.id.ID) as EditText
        DAY = findViewById(R.id.DAY) as EditText
        MONTH = findViewById(R.id.MONTH) as EditText
        YEAR = findViewById(R.id.YEAR) as EditText
        TIME = findViewById(R.id.TIME) as EditText
        MONEYINTO = findViewById(R.id.MONEYINTO) as EditText
        MONEYOUT = findViewById(R.id.MONEYOUT) as EditText
        DETAILS = findViewById(R.id.DETAILS) as EditText
        resetBtn = findViewById(R.id.resetBtn) as Button
        COST = findViewById(R.id.cost) as Button

        save!!.setOnClickListener {
            databaseHelper!!.addGradeDetail( ID !!.text.toString(), DAY!!.text.toString(), MONTH!!.text.toString(),
                YEAR!!.text.toString(), TIME!!.text.toString(), MONEYINTO!!.text.toString(), MONEYOUT!!.text.toString(), DETAILS!!.text.toString())
            ID!!.setText("")
            DAY!!.setText("")
            MONTH!!.setText("")
            YEAR!!.setText("")
            TIME!!.setText("")
            MONEYINTO!!.setText("")
            MONEYOUT !!.setText("")
            DETAILS!!.setText("")

            Toast.makeText(this@MainActivity, "Stored Successfully!", Toast.LENGTH_SHORT).show()
        }


        SHOW!!.setOnClickListener {
            arrayList = databaseHelper!!.allSubjectList
            tvname!!.text = ""
            var ord = 1
            for (i in arrayList!!.indices) {
                tvname!!.text = tvname!!.text.toString() + (ord++) + ". " + arrayList!![i] + "\n"
            }
        }

        resetBtn!!.setOnClickListener {
            databaseHelper!!.resetDatabase()
        }
    }
}