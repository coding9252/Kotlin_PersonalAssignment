package com.android.introduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val strData = intent.getStringExtra("dataFromSignInActivity")
        val edit_data = findViewById<EditText>(R.id.edit_data)
        edit_data.setText(strData)

        val end = findViewById<Button>(R.id.btn_end)
        end.setOnClickListener {
            val intent= Intent(this, SignInActivity::class.java)
            finish()
        }
    }
}