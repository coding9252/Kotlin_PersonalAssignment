package com.android.introduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signUp_Btn = findViewById<Button>(R.id.btn_signUp2)
        val edit_name = findViewById<EditText>(R.id.edit_name)
        val edit_id2 = findViewById<EditText>(R.id.edit_id2)
        val edit_password2 = findViewById<EditText>(R.id.edit_password2)

        signUp_Btn.setOnClickListener {
            if (edit_name.length() == 0 || edit_id2.length() == 0 || edit_password2.length() == 0) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SignInActivity::class.java)
                finish()
            }
        }
    }
}