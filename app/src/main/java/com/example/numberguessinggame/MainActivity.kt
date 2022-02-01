package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random.Default.nextInt


class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var submitButton: Button
    lateinit var headView: TextView
    var inGame: Boolean = true

    var count = 0
    var random: Int = nextInt(1 ,1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        headView = findViewById(R.id.headView)
        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        submitButton = findViewById(R.id.submitButton)

        textView.text = "Please Enter your guess!"
        headView.text = "Try to guess the number I'm thinking of from 1 - 1000!"
        submitButton.text = "Enter"

        submitButton.setOnClickListener {

            if (inGame) {
                if (editText.text.isEmpty()) {
                Toast.makeText(this, "Number required", Toast.LENGTH_SHORT).show()
                } else {

                    val number: Int = editText.text.toString().toInt()
                          if (number < random) {

                            textView.text = "Hint: It's higher!"
                            editText.text.clear()
                            count++

                          } else if (number > random) {

                            textView.text = "Hint: It's lower!"
                            editText.text.clear()
                            count++

                          } else {
                            headView.text = "Congratulation! you guess $count times before it's correct"
                            textView.text = ""
                            editText.text.clear()
                            submitButton.text = "Play again"
                            inGame = false
                            }
                     }
            } else {
                reset()
            }



    }

}

    private fun reset() {
        random = nextInt(1 ,1000)
        headView.text = "Try to guess the number I'm thinking of from 1 - 1000!"
        textView.text = "Please Enter your guess!"
        editText.text.clear()
        submitButton.text = "Enter"
        count = 0
        inGame = true
    }


}