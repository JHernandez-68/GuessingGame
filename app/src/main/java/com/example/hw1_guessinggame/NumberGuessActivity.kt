package com.example.hw1_guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlin.random.Random

class NumberGuessActivity : AppCompatActivity() {

    var att: Int = 0
    var randomNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_guess)
        att = 0
        randomNumber = Random.nextInt(0, 1000)
    }

    fun restartAttempts(view: View){
        val congrats = findViewById<TextView>(R.id.attempts)
        congrats.isInvisible = true
        att = 0
        randomNumber = Random.nextInt(0, 1000)


    }

    fun searchNumber(view: View){
        val congrats = findViewById<TextView>(R.id.attempts)
        val editText = findViewById<EditText>(R.id.editText)
        val enteredNumber = editText.text.toString().toInt()

            att++
            congrats.isVisible = true
            congrats.text = "Attempts: $att"
            if(enteredNumber < 1) {
                Toast.makeText(this, "The number is out of range", Toast.LENGTH_LONG).show()
            }
            if (randomNumber > enteredNumber) {
                Toast.makeText(this,"The number is greater", Toast.LENGTH_LONG).show()
            } else if (enteredNumber > randomNumber) {
                Toast.makeText(this,"The number is less", Toast.LENGTH_LONG).show()
            } else {
                congrats.text = "You guessed the number $randomNumber with $att attempts"
                editText.isEnabled = false
                view.isEnabled = false
                val reset = findViewById<Button>(R.id.resest)
                reset.isVisible = true

                reset.setOnClickListener { _->
                    reset.isVisible = false
                    congrats.isVisible = false
                    editText.isEnabled = true
                    editText.setText("")
                    view.isEnabled = true
                    att = 0
                    randomNumber = Random.nextInt(0, 1000)

                }

        }
    }

}