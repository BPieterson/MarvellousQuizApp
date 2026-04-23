package com.example.lifehackormythapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var tvQuestions: TextView
    lateinit var tvUName : TextView
    lateinit var iPics : ImageView
    lateinit var rgOptions: RadioGroup
    lateinit var options1: RadioButton
    lateinit var options2: RadioButton
    lateinit var btnNext: Button

    var currentQuestion = 0
    var score = 0

    //Questions that would be asked in a form of an array
    val questions = arrayOf(
        "What is the Punisher's full name?",
        "Where is the home of the Black Panther?",
        "How many forms does Bruce Banner/ The Hulk have?",
        "Who is this?", // The question for Brit
        "What was the chemical compound that made Steve Rogers, Captain America?",
        "Who is H.E.R.B.I.E?",
        "How many suits does Iron Man have?",
        "Who is he?", // The question for M a picture would be shown here
        "Who killed Spider-Man in The Amazing Spider-Man #294?",
        "Who is Captain America's best friend?",
        "How did Peter Parker get his powers?"

    )

    //Options that the user would use to answer the questions
    val options = arrayOf(
        arrayOf("Frank Castle", "Richard Hughes"),
        arrayOf("Wakanda", "Congo"),
        arrayOf("30", "20"),
        arrayOf("Captain Britain(Brian Braddock)", "London-star"),
        arrayOf("Super-Soldier serum", "XT142-C"),
        arrayOf("Fantastic 4 Ai Family Robot", "Tony Stark Assistant"),
        arrayOf("110", "85"),
        arrayOf("Mephisto", "Morlun"),
        arrayOf("Kraven The Hunter", "Morlun"),
        arrayOf("Bucky Barnes(Winter Soldier)", "Tony Stark (Iron Man)"),
        arrayOf("Bitten by a radioactive spider", "A magical spell")
    )

    //Images that will be used with the questions, they would be stored in the drawable folder
    val images = arrayOf(
        R.drawable.punisher,
        R.drawable.bp,
        R.drawable.hulk,
        R.drawable.cap_b,
        R.drawable.capa,
        R.drawable.herb,
        R.drawable.im,
        R.drawable.mor,
        R.drawable.spiderl,
        R.drawable.winter,
        R.drawable.spider
    )

    val correctAnswers = arrayOf(0,0,1,0,0,1,1,0,0,0,0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvQuestions = findViewById(R.id.tvQuestions)
        tvUName = findViewById(R.id.tvUName)
        iPics = findViewById(R.id.Ipics)
        rgOptions = findViewById(R.id.rgOptions)
        options1 = findViewById(R.id.Option1)
        options2 = findViewById(R.id.Option2)
        btnNext = findViewById(R.id.btnNext)

        //The username that would be displayed on the screen
        val sName = intent.getStringExtra("sName")
        tvUName.text = sName

        iPics.setImageResource(images[currentQuestion])
        tvQuestions.text = questions[currentQuestion]
        options1.text = options[currentQuestion][0]
        options2.text = options[currentQuestion][1]


        btnNext.setOnClickListener {

            val optionId = rgOptions.checkedRadioButtonId

            val answerIndex = when (optionId) {
                R.id.Option1 -> 0
                R.id.Option2 -> 1
                else ->  -1
            }

            if (answerIndex == correctAnswers[currentQuestion]){
                score ++
            }

            currentQuestion++

            if(currentQuestion < questions.size){
                iPics.setImageResource(images[currentQuestion])
                tvQuestions.text = questions[currentQuestion]
                options1.text = options[currentQuestion][0]
                options2.text = options[currentQuestion][1]
                rgOptions.clearCheck()
            }else{
                val intent = Intent(this, ScoreScreen::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                intent.putExtra("answers", correctAnswers.joinToString())
                intent.putExtra("name", getIntent().getStringExtra("name"))
                intent.putExtra("surname", getIntent().getStringExtra("surname"))
                intent.putExtra("sName", getIntent().getStringExtra("sName"))
                startActivity(intent)
                finish()
            }

        }

    }
}