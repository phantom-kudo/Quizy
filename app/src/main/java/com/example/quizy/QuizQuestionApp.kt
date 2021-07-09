package com.example.quizy

import android.app.Instrumentation
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionApp : AppCompatActivity(), View.OnClickListener{

    private var mCurrentPosition:Int =1
    private var mQuestionList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName:String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question_app)

        mUserName = intent.getStringExtra(constant.USER_NAME)


        mQuestionList=constant.getQuestions()
        setQuestion()


        var quizOptionOne = findViewById<TextView>(R.id.tv_option_one)
        quizOptionOne.setOnClickListener(this)
        var quizOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        quizOptionTwo.setOnClickListener(this)
        var quizOptionThree = findViewById<TextView>(R.id.tv_option_three)
        quizOptionThree.setOnClickListener(this)
        var quizOptionFour = findViewById<TextView>(R.id.tv_option_four)
        quizOptionFour.setOnClickListener(this)
        var submitButton = findViewById<Button>(R.id.tv_submit_button)
        submitButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var quizOptionOne = findViewById<TextView>(R.id.tv_option_one)
        var quizOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        var quizOptionThree = findViewById<TextView>(R.id.tv_option_three)
        var quizOptionFour= findViewById<TextView>(R.id.tv_option_four)
        var submitButton = findViewById<Button>(R.id.tv_submit_button)
        when(v?.id){
            R.id.tv_option_one -> {
                selectedOptionView(quizOptionOne,1)
            }

            R.id.tv_option_two -> {
                selectedOptionView(quizOptionTwo,2)
            }

            R.id.tv_option_three -> {
                selectedOptionView(quizOptionThree,3)
            }

            R.id.tv_option_four -> {
                selectedOptionView(quizOptionFour,4)
            }
            R.id.tv_submit_button -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, MainResult::class.java)
                            intent.putExtra(constant.USER_NAME, mUserName)
                            intent.putExtra(constant.CORRECT_ANSWER, mCorrectAnswers)
                            intent.putExtra(constant.TOTAL_QUESTION, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_background_bg)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_background_bg)
                    if (mCurrentPosition == mQuestionList!!.size) {
                        submitButton.text = "FINISH"
                    } else {
                        submitButton.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }



    private fun setQuestion() {
        val submitButton = findViewById<Button>(R.id.tv_submit_button)
        val question = mQuestionList!![mCurrentPosition-1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionList!!.size) {
            submitButton.text="FINISH"
        }else {
            submitButton.text="SUBMIT"
        }
        var Bar = findViewById<ProgressBar>(R.id.progressBar)
        Bar.progress = mCurrentPosition
        var barTv = findViewById<TextView>(R.id.tv_progress)
        barTv.text = "$mCurrentPosition" + "/" + Bar.getMax()
        var quizQuestion = findViewById<TextView>(R.id.tv_question)
        quizQuestion.text = question!!.question
        var quizImage = findViewById<ImageView>(R.id.iv_image)
        quizImage.setImageResource(question.image)
        var quizOptionOne = findViewById<TextView>(R.id.tv_option_one)
        quizOptionOne.text = question.optionOne
        var quizOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        quizOptionTwo.text = question.optionTwo
        var quizOptionThree = findViewById<TextView>(R.id.tv_option_three)
        quizOptionThree.text  = question.optionThree
        var quizOptionFour = findViewById<TextView>(R.id.tv_option_four)
        quizOptionFour.text = question.optionFour
    }


    private fun selectedOptionView(tv:TextView,selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_background_bg
        )
    }



    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        var quizOptionOne = findViewById<TextView>(R.id.tv_option_one)
        options.add(0,quizOptionOne)
        var quizOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        options.add(1,quizOptionTwo)
        var quizOptionThree = findViewById<TextView>(R.id.tv_option_three)
        options.add(2,quizOptionThree)
        var quizOptionfour= findViewById<TextView>(R.id.tv_option_four)
        options.add(3,quizOptionfour)

        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_background_bg
            )
        }
    }


    private fun answerView(answer: Int, drawableView: Int) {
        var quizOptionOne = findViewById<TextView>(R.id.tv_option_one)
        var quizOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        var quizOptionThree = findViewById<TextView>(R.id.tv_option_three)
        var quizOptionfour= findViewById<TextView>(R.id.tv_option_four)
         when(answer){
             1 -> {
                 quizOptionOne.background=ContextCompat.getDrawable(
                     this,drawableView
                 )
             }
             2-> {
                 quizOptionTwo.background=ContextCompat.getDrawable(
                     this,drawableView
                 )
             }
             3 -> {
                 quizOptionThree.background=ContextCompat.getDrawable(
                     this,drawableView
                 )
             }
             4 -> {
                 quizOptionfour.background=ContextCompat.getDrawable(
                     this,drawableView
                 )
             }
         }
    }
}