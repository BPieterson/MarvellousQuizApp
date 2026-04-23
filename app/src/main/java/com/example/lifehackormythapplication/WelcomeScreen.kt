package com.example.lifehackormythapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class WelcomeScreen : AppCompatActivity() {
    lateinit var txtName: EditText
    lateinit var txtSurname: EditText
    lateinit var txtSName: EditText
    lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

        txtName = findViewById(R.id.txtName)
        txtSurname = findViewById(R.id.txtSurname)
        txtSName = findViewById(R.id.txtSName)
        btnStart = findViewById(R.id.btnStart)

        btnStart.setOnClickListener {
               val name = txtName.text.toString()
                val surname = txtSurname.text.toString()
                val sName = txtSName.text.toString()

            if(name.isEmpty() || surname.isEmpty() || sName.isEmpty()){
                Toast.makeText(this, "Please fill all the fields to begin the game", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("name",name)
                intent.putExtra("surname", surname)
                intent.putExtra("sName", sName)
                startActivity(intent)
                finish()
            }
        }
    }
}