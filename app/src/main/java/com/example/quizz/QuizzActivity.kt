package com.example.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizzActivity : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var textProgress: TextView? = null
    private var textQuestion: TextView? = null
    private var imgView : ImageView? = null

    private var optionOne: TextView? = null
    private var optionTwo: TextView? = null
    private var optionThree: TextView? = null
    private var optionFour: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)

        progressBar = findViewById(R.id.progress)
        textProgress = findViewById(R.id.txtProgress)
        textQuestion = findViewById(R.id.question)
        imgView = findViewById(R.id.imgsrc)

        optionOne = findViewById(R.id.optionOne)
        optionTwo = findViewById(R.id.optionTwo)
        optionThree = findViewById(R.id.optionThree)
        optionFour = findViewById(R.id.optionFour)



        val questionList = Constants.getQuestions()
        Log.i("QuestionList is", "${questionList.size}")

        for(i in questionList){
            Log.e("Questions", i.question)

        }
        var currentPosition = 1
        val question : Questions = questionList[currentPosition - 1]
        imgView?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        textProgress?.text = "$currentPosition / ${progressBar?.max}"
        textQuestion?.text = question.question

        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour


    }
}