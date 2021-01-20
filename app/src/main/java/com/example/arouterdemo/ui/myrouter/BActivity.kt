package com.example.arouterdemo.ui.myrouter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.arouterdemo.R
import kotlinx.android.synthetic.main.activity_b.*

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/19
 *  desc   :
 */
class BActivity: AppCompatActivity(R.layout.activity_b) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val key = intent.getStringExtra("key")
        Log.e("MMM", ":  $key" );


        btnReturn.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        btnPara.setOnClickListener {
            val intent = Intent()
            intent.putExtra("key","返回参数")
            setResult(Activity.RESULT_OK,intent)
            finish()
        }


    }
}