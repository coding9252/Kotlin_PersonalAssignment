package com.android.introduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val et_id = findViewById<EditText>(R.id.et_id)
        val et_pw = findViewById<EditText>(R.id.et_pw)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_signUp = findViewById<Button>(R.id.btn_signUp)

        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val user_id = it.data?.getStringExtra("id") ?: ""    // 없으면 null 값
                    val user_pw = it.data?.getStringExtra("pw") ?: ""
                    et_id.setText(user_id)
                    et_pw.setText(user_pw)
                }
            }

        btn_login.setOnClickListener {
            if (et_id.text.toString().trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.toast_msg_idErr), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (et_pw.text.toString().trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.toast_msg_pwErr), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }  // 입력 안 된 부분이 있을 때 뒷부분이 실행되면 안 되고, setOnClickListener를 빠져나가야 하기 떄문에 return 해줘서 뒷부분이 실행되지 않게 한다.
            Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show()

            // 위 if문들이 false로 실행 안 되면 여기로 넘어옴.
            val intent =
                Intent(this, HomeActivity::class.java)    // 현재 액티비티(this)에서 HomeActivity 호출
            intent.putExtra(
                "id",
                et_id.text.toString()
            )                   // putExtra로 아이디 넘(키값, 내용)
            startActivity(intent)


//            이렇게 해도 되나요??
//            when {
//                et_id.text.toString().trim().isEmpty() -> {
//                    Toast.makeText(this, getString(R.string.toast_msg_idErr), Toast.LENGTH_SHORT).show()
//                }
//
//                et_pw.text.toString().trim().isEmpty() -> {
//                    Toast.makeText(this, getString(R.string.toast_msg_pwErr), Toast.LENGTH_SHORT).show()
//                }
//
//                else -> {
//                    Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show()
//
//                    val strData = et_id.text.toString()
//                    val intent = Intent(this, HomeActivity::class.java)
//                    intent.putExtra("dataFromSignInActivity", strData)
//                    startActivity(intent)
//                }
//
//            }

        }
        btn_signUp.setOnClickListener {
//                val intent = Intent(this, SignUpActivity::class.java)
//                startActivity(intent)

            val intent = Intent(this, SignUpActivity::class.java)    // SignUpActivity야 답장 보내줘.
            activityResultLauncher.launch(intent)                                  // 답장 오면 activityResultLauncher가 실행 됨.
        }
    }
}


