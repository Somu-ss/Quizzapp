package com.example.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterName: EditText = findViewById(R.id.input_field)
        val clickButton: Button = findViewById(R.id.click_button)

        clickButton.setOnClickListener{
            if(enterName.text.isEmpty()){
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this,QuizzActivity::class.java)
                startActivity(intent)

            }

        }


    }
}