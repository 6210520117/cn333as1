package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var submitButton: Button
    lateinit var resetButton: Button

    var random: Int = nextInt(1, 1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        submitButton = findViewById(R.id.submitButton)
        resetButton = findViewById(R.id.resetButton)

        textView.text = "Please Enter your guess!"

        submitButton.setOnClickListener{

            val number: Int = editText.text.toString().toInt()

            if (number < random) {

                textView.text = "Hint: It's higher!"
                editText.text.clear()

            } else if (number > random) {

                textView.text = "Hint: It's lower!"
                editText.text.clear()

            } else {

                textView.text = "Congratulation!"
                editText.text.clear()

            }

        }

    fun reset() {
        random = nextInt(1 ,1000)
        textView.text = "Your Guess"
        editText.text.clear()

    }

    }
}