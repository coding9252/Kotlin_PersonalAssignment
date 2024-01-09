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

        val et_name = findViewById<EditText>(R.id.et_name)
        val et_id = findViewById<EditText>(R.id.et_id)
        val et_pw = findViewById<EditText>(R.id.et_pw)
        val btn_signUp = findViewById<Button>(R.id.btn_signUpOk)
        val btn = findViewById<Button>(R.id.btn_signUpOk)

        btn_signUp.setOnClickListener {
            if (et_name.text.toString().trim().isEmpty() || et_id.text.toString().trim().isEmpty() || et_pw.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, SignInActivity::class.java).apply {
                putExtra("id", et_id.text.toString())
                putExtra("pw", et_pw.text.toString())
            }
            setResult(RESULT_OK, intent)    // 한 번 더 확인하는 것. RESULT_OK 말고 다른 값을 줘도 된다.

            if (!isFinishing) finish()
        }
    }
}