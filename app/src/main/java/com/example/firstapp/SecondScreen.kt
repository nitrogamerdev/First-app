package com.example.firstapp

import android.annotation.SuppressLint
import android.content.Intent
import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        // gettin the reference of element needed

        val backbtn  = findViewById<Button>(R.id.BackButton)
        val userNameText = findViewById<TextView>(R.id.userNameText)

        // setting user text name

        val enteredValue = intent.getStringExtra("enteredValue")
        userNameText.text = "Welcome $enteredValue"

        // setting the onclick listerner to back button
        backbtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}