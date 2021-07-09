package com.example.quizy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

    }

    fun start_quizzy(view: View) {
        val nameInput = findViewById<EditText>(R.id.et_name)
        if(nameInput.text.toString().isEmpty()) {
            Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show()
        } else{
            val intent = Intent(this,QuizQuestionApp::class.java)
            intent.putExtra(constant.USER_NAME,nameInput.text.toString())
            startActivity(intent)
            finish()
        }

    }
}