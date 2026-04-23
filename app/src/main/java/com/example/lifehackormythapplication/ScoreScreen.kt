package com.example.lifehackormythapplication

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

        tvResult.text = "Correct Answers: $score / $total"
        tvScore.text = "Score: $score"
        tvAnswers.text = "Answers: $answers"
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