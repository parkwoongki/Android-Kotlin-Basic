package com.mobile.textviewtest

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tv1: TextView? = null // 물음표를 붙이면 null 담을 수 있다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1 = findViewById(R.id.tv1)

        /* 동일한 로직 */
        tv1?.text = "문자1"
        tv1?.setText("문자1");

        // 코틀린은 findviewbyid안해도된다.!!
        tv2.text ="asd"
    }
}
