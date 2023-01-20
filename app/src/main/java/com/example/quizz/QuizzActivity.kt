package com.example.quizz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizzActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition : Int = 0
    private var muserName: String? = null
    private var mcorrectQuestions: Int = 0

    private var progressBar: ProgressBar? = null
    private var textProgress: TextView? = null
    private var textQuestion: TextView? = null
    private var imgView : ImageView? = null


    private var optionOne: TextView? = null
    private var optionTwo: TextView? = null
    private var optionThree: TextView? = null
    private var optionFour: TextView? = null
    private var btnSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)

        progressBar = findViewById(R.id.progress)
        textProgress = findViewById(R.id.txtProgress)
        textQuestion = findViewById(R.id.question)
        imgView = findViewById(R.id.imgsrc)


        muserName = intent.getStringExtra(Constants.USER_NAME, )

        optionOne = findViewById(R.id.optionOne)
        optionTwo = findViewById(R.id.optionTwo)
        optionThree = findViewById(R.id.optionThree)
        optionFour = findViewById(R.id.optionFour)

        btnSubmit = findViewById(R.id.submitBtn)



        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)


        mQuestionList = Constants.getQuestions()
        setQuestion()



    }

    private fun setQuestion() {
        defaultOptionView()

        val question: Questions = mQuestionList!![mCurrentPosition - 1]
        imgView?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        textProgress?.text = "$mCurrentPosition / ${progressBar?.max}"
        textQuestion?.text = question.question

        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour

        if(mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text = "FINISH"
        }else{
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()

        optionOne?.let {
            options.add(0,it)
        }

        optionTwo?.let {
            options.add(1,it)
        }

        optionThree?.let {
            options.add(2,it)
        }

        optionFour?.let {
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_bg_option
            )
        }

    }

    private fun selectedOptionView(tv: TextView, selectedPosition: Int){
        defaultOptionView()

        mSelectedOptionPosition = selectedPosition

        tv.setTextColor(Color.parseColor("#000000"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)

        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_default_bg
        )

    }

    override fun onClick(view: View?){
        when(view?.id){
            R.id.optionOne -> {
                optionOne?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.optionTwo -> {
                optionTwo?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.optionThree -> {
                optionThree?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.optionFour -> {
                optionFour?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.submitBtn -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, muserName)
                            intent.putExtra(Constants.CORRECT_QUESTIONS, mcorrectQuestions)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_bg_option)
                    }else{
                        mcorrectQuestions++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_bg_option)

                    if(mCurrentPosition == mQuestionList!!.size){
                        btnSubmit?.text = "FINISH"
                    }else{
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0


                }

                }
        }
    }

    private fun answerView(answer: Int, drawableView: Int ){
        when(answer){
            1 -> {
                optionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                optionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                optionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                optionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}