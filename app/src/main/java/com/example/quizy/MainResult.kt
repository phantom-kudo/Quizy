package com.example.quizy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        val username = intent.getStringExtra(constant.USER_NAME)
        val outputName = findViewById<TextView>(R.id.tv_username)
        outputName.text = username


//        val totalQuestions = intent.getStringArrayExtra(constant.TOTAL_QUESTION)
//        val correctAnswers = intent.getStringExtra(constant.CORRECT_ANSWER)

        val score = findViewById<TextView>(R.id.tv_score)
        score.text = "Your score is 8 out of 10"

        val btn_finish =findViewById<Button>(R.id.finish_btn)

        btn_finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}