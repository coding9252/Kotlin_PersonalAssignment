package com.android.introduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val et_id = findViewById<EditText>(R.id.et_id)
        val et_pw = findViewById<EditText>(R.id.et_pw)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_signUp = findViewById<Button>(R.id.btn_signUp)

        btn_login.setOnClickListener {

            // EditText의 텍스트를 꺼내올 땐 무조건 toString()으로 형변환을 시켜줘야 한다. (Int 값을 받아오려면 toString() 뒤에 toInt()를 써주자.)
            // trim()은 사용자가 공백을 줬을 때 공백 제거.
            // isEmpty()는 비어있는지 체크. null은 비어있는지 체크하는 것이 아니라, 객체 자체가 null이냐는 것이기 때문에 null로 체크하면 안 됨.
            // if (et_id.text.toString() == "" || et_pw.text.toString() == "")로도 체크 가능. 하지만 ""부분에 null을 주면 안 됨.

            if (et_id.text.toString().trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.toast_msg_idErr), Toast.LENGTH_SHORT).show()
                return@setOnClickListener    // else 안 쓴 경우에 setOnClickListener를 빠져나가기(else 부분을 실행하면 안되기 때문에)
            } else if (et_pw.text.toString().trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.toast_msg_pwErr), Toast.LENGTH_SHORT).show()
//                return@setOnClickListener    // else 안 쓴 경우에 setOnClickListener를 빠져나가기(else 부분을 실행하면 안되기 때문에)
            } else
                Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show()

            val strData = et_id.text.toString()
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("dataFromSignInActivity", strData)
            startActivity(intent)


//            when {
//                et_id.text.toString().trim().isEmpty() -> {
//                    Toast.makeText(this, getString(R.string.toast_msg_idErr), Toast.LENGTH_SHORT).show()
//                }
//                // Toast에 makeText() 명령어로 Toast를 띄운다. 여기에 3가지 인자가 들어간다. (context, text(문구), toast 길이)
//                // context는 토스트를 띄울 바탕을 써준다. 여기에 띄울 것이니 this를 써줌.
//                // text(문구) 부분에는 ""로 string 값을 직접 쓰기도 하지만, 보통 res -> values -> string.xml 파일에 stiring을 정의해놓고 그 id를 가지고 문구를 따오는 방식을 많이 쓴다.
//                // getString() 명령어로 정의해준 stirng을 id로 가져온다.
//                et_pw.text.toString().trim().isEmpty() -> {
//                    Toast.makeText(this, getString(R.string.toast_msg_pwErr), Toast.LENGTH_SHORT).show()
//                }
//
//
//                else -> {
//                    Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show()
//
//                    val strData = et_id.text.toString()
//                    val intent = Intent(this, HomeActivity::class.java)
//                    intent.putExtra("dataFromSignInActivity", strData)
//                    startActivity(intent)
//
//
//                }
        }
        btn_signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}



