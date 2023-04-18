package com.example.firstapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // referring to the elements

        val boloTextView = findViewById<TextView>(R.id.tvtextview)
        val inputField = findViewById<EditText>(R.id.tvInput)
        val submitButton = findViewById<Button>(R.id.btnSubmit)
        val nextScreenBtn = findViewById<Button>(R.id.btnNext)

        var enteredValue = "" // this variable needs to be global

        // setting onClick listener to submit button

        submitButton.setOnClickListener {
            enteredValue = inputField.text.toString()

            if (enteredValue != "") {
                boloTextView.text = "Oky tum $enteredValue ho"
                inputField.text.clear()
                nextScreenBtn.visibility = VISIBLE
            } else {
                boloTextView.text = "neeche dheko neeche"
                Toast.makeText(applicationContext, "Gawarch.. prh ky likha h", Toast.LENGTH_SHORT).show()
                nextScreenBtn.visibility = INVISIBLE
            }
        }

        // setting onclick listener to next screen button

        nextScreenBtn.setOnClickListener {
            val intent = Intent(this, SecondScreen::class.java)
            intent.putExtra("enteredValue", enteredValue)
            startActivity(intent)
        }
    }


}
