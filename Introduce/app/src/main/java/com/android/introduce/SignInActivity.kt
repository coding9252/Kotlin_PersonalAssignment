package com.android.introduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signIn_btn = findViewById<Button>(R.id.btn_signIn)
        signIn_btn.setOnClickListener {

            val edit_id = findViewById<EditText>(R.id.edit_id)
            val edit_password = findViewById<EditText>(R.id.edit_password)

            if (edit_id.length() == 0 || edit_password.length() == 0) {
                Toast.makeText(this, "아이디/비밀번호를 확인해 주세요.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

                val strData = edit_id.text.toString()               // toString()은 꼭 해줘야 하나요?
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("dataFromSignInActivity", strData)
                startActivity(intent)
            }
        }

        val signUp_btn = findViewById<Button>(R.id.btn_signUp)
        signUp_btn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}