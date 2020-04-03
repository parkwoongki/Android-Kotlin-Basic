package com.mobile.edittexttest

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. EditText의 문자열을 TextView로 가져오기
        btn1.setOnClickListener { view ->
            tv1.text = et1.text
        }

        // 2. 문자열을 세팅할 때는 setText를 사용한다.
        btn2.setOnClickListener { view ->
            et1.setText("문자열")
        }

        // 3. 이너 클래스 리스너를 이용해서 setOnEditorActionListener를 사용하는 방법
        var listener = EnterListener()
        et1.setOnEditorActionListener(listener)

        // 4. 람다식을 이용해서 setOnEditorActionListener를 사용하는 방법
        et1.setOnEditorActionListener { textView, i, keyEvent ->
            tv1.text = et1.text
            true // 람다식에서는 반환값을 이렇게.. return을 쓰지 않는다. 중요!!
        }

        // 5. 이너 클래스 리스너를 이용해서 Editwatcher를 사용하는 방법
        var watcher = Editwatcher()
        et1.addTextChangedListener(watcher)

        // 6. 람다식을 이용해서 Editwatcher를 사용하는 방법
        et1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                tv1.text = p0
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

        })
    }

    // 3. 이너 클래스 리스너를 이용해서 setOnEditorActionListener를 사용하는 방법
    inner class EnterListener : TextView.OnEditorActionListener {
        override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
            tv1.text = et1.text

            // 키보드 안내리겠다 하면
            return true
            // 키도브 내리겠다고 하면
            return false
        }
    }

    // 5. 이너 클래스 리스너를 이용해서 Editwatcher를 사용하는 방법
    inner class Editwatcher : TextWatcher {
        // 문자열이 바뀌기 전
        override fun afterTextChanged(p0: Editable?) {

        }

        // 문자열이 바뀌었을 때, 주로 이걸 사용한다.
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            // p0는 에디트 텍스트에 들어온 문자열이다.
            tv1.text = p0
        }

        // 문자열이 바뀐 후
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

    }
}
