package com.example.arouterdemo.ui.arouter

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.example.arouterdemo.R
import com.example.arouterdemo.help.ActivityHelper
import com.example.arouterdemo.ktx.startActivityForResult
import com.example.arouterdemo.page.RouterPage
import com.example.arouterdemo.utils.LogUtils
import kotlinx.android.synthetic.main.fg_a.*

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/19
 *  desc   :
 */
class ArouterFg: Fragment(R.layout.fg_a) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAFgNo.setOnClickListener {
            ARouter.getInstance().build(RouterPage.AROUTER_B)
                .navigation(activity,23)
        }

        btnAFgHas.setOnClickListener {
            ARouter.getInstance().build(RouterPage.AROUTER_B)
                .navigation(activity,24)
        }
        btnAFgHas2.setOnClickListener {
          ActivityHelper.init(activity!!)
              .startActivityForResult(RouterPage.AROUTER_B,object : ActivityHelper.Callback{
                  override fun onActivityResult(resultCode: Int, data: Intent?) {
                        LogUtils.e(data,"fragment---$resultCode")
                  }

              })
        }

        startActivityForResult(""){resultCode,data ->

        }

    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//       LogUtils.e(data,"MMM", "fg : $resultCode" )
//        LogUtils.e(data?.getStringExtra("key"),"key---$requestCode")
//    }
}