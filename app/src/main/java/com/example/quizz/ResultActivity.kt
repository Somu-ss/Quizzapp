package com.example.quizz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var user_View: TextView = findViewById(R.id.username)
        var score_View: TextView = findViewById(R.id.score)
        var btnFinish: Button = findViewById(R.id.btn_Finish)


        user_View.text = intent.getStringExtra(Constants.USER_NAME)

        var totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        var correctQuestions = intent.getIntExtra(Constants.CORRECT_QUESTIONS,0)


        score_View.text = "Your Score is $correctQuestions out of $totalQuestions"

        btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}