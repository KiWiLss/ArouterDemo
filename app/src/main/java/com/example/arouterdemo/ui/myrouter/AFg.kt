package com.example.arouterdemo.ui.myrouter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.arouterdemo.R
import com.example.arouterdemo.utils.MyRouter
import kotlinx.android.synthetic.main.fg_a.*

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/19
 *  desc   :
 */
class AFg: Fragment(R.layout.fg_a) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAFgNo.setOnClickListener {
            val intent = Intent(context, BActivity::class.java)
            MyRouter.navigation(this,intent){ resultcode, data ->
                Log.e("MMM", ": $resultcode" )
            }
        }

        btnAFgHas.setOnClickListener {
            val intent = Intent(context, BActivity::class.java)
            intent.putExtra("key","value")
            MyRouter.navigation(this,intent){ resultcode, data ->
                Log.e("MMM", ": $resultcode + data= ${data?.getStringExtra("key")}" )
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("MMM", "fg : $resultCode" )
    }
}