package com.example.arouterdemo.ui.myrouter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.arouterdemo.R
import com.example.arouterdemo.utils.MyRouter
import kotlinx.android.synthetic.main.activity_a.*

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/19
 *  desc   :
 */
class AActivity: AppCompatActivity(R.layout.activity_a) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .add(R.id.flAFg, AFg())
            .commit()


        btnNo.setOnClickListener {
            val intent = Intent(this, BActivity::class.java)
            MyRouter.navigation(this,intent){resultcode,data ->
                Log.e("MMM", ": $resultcode" )
            }
        }

        btnHas.setOnClickListener {
            val intent = Intent(this, BActivity::class.java)
            intent.putExtra("key","value")
            MyRouter.navigation(this,intent){resultcode,data ->
                Log.e("MMM", ": $resultcode + data= ${data?.getStringExtra("key")}" )
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("MMM", "a : $resultCode" )
    }
}