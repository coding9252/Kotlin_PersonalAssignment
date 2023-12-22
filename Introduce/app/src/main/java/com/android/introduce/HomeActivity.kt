package com.android.introduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val tv_id = findViewById<TextView>(R.id.tv_id)

        if (intent.hasExtra("id")) {    // intent에 hasExtra()로 키가 있는지 확인
            tv_id.text = "아이디 : " + intent.getStringExtra("id")
        }    // 키가 있다면 getStringExtra()로 키를 적어주면 그 키에 해당하는 데이터를 꺼내온다.

        val btn_close = findViewById<Button>(R.id.btn_close)
        btn_close.setOnClickListener {
            finish()
        }
    }
}