package com.example.lifehackormythapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreScreen : AppCompatActivity() {
    lateinit var tvResult: TextView
    lateinit var tvScore: TextView
    lateinit var tvAnswers: TextView
    lateinit var tvRep: TextView
    lateinit var btnClose: Button
    lateinit var btnHome: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_screen)

        tvResult = findViewById(R.id.tvResult)
        tvAnswers = findViewById(R.id.tvAnswers)
        tvRep = findViewById(R.id.tvRep)
        tvScore = findViewById(R.id.tvScore)
        btnClose = findViewById(R.id.btnClose)
        btnHome = findViewById(R.id.btnHome)


        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)
        val answers = intent.getStringExtra("answers")
        val name = intent.getStringExtra("name")
        val surname = intent.getStringExtra("surname")
        val sName = intent.getStringExtra("sName")

        // Displaying the result message based on the score achieved by the user
        if(score == total){
            tvAnswers.text = "Answers: $answers \nCongratulations! You got all the answers correct! You are a Marvel superfan!🦸"
        }else{
            if(score == 8){
                tvAnswers.text = "Answers: $answers \nGreat job! You know your Marvel trivia well. Keep it up!"
            }else{
                if(score == 5 || score == 6 || score == 7){
                    tvAnswers.text = "Answers: $answers \nNot bad! You have a good knowledge of Marvel trivia, but there's still room for improvement. Keep learning and exploring the Marvel universe!"
                }else{
                    if(score < 5){
                        tvAnswers.text = "Answers: $answers \nDon't worry! Marvel trivia can be tricky, and it's all about having fun. " +
                                "Keep exploring the Marvel universe, and you'll get better with time." + "REMEMBER!! to top up your Marvel knowledge," +
                                " maybe try again and see if you can improve your score!"
                    }
                }
            }
        }

        tvResult.text = "Correct Answers: $score / $total"
        tvScore.text = "Score: $score"
        tvRep.text = "User: $name $surname \t$sName"


        btnClose.setOnClickListener {
            finish()
        }

        btnHome.setOnClickListener {
            val intent = Intent(this, WelcomeScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}