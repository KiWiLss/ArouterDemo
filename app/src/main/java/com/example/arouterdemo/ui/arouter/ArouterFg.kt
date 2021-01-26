package com.example.arouterdemo.ui.arouter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.example.arouterdemo.R
import com.example.arouterdemo.help.ActivityHelper
import com.example.arouterdemo.helpk.ActivityHelperK
import com.example.arouterdemo.ktx.BundleKtx
import com.example.arouterdemo.ktx.RouterKtx
import com.example.arouterdemo.ktx.startActivity
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
    lateinit var mActivity: FragmentActivity
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mActivity = activity!!

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
//
//        ActivityHelperK.init(activity!!)
//            .startActivityForResult(RouterPage.AROUTER_B){resultCode,data ->
//
//            }
//
//        //示例demo
//        val bean = RouterBean("alice", 20)
//        val bean2 = RouterBean("hh", 2)
//        val list = arrayListOf<RouterBean>(bean, bean2)
//        val bundle = Bundle()
//        bundle.putString(RouterPage.KEY, "hai")
//        BundleKtx.putList(bundle, RouterPage.DATA, list)
//        //无参跳转
//        RouterKtx.startActivity(RouterPage.AROUTER_B)
//        RouterKtx.startActivityForResult(mActivity, RouterPage.AROUTER_B, 9)
//        startActivity(RouterPage.AROUTER_B)    //扩展函数
//        //带参bundle跳转
//        RouterKtx.startActivity(RouterPage.AROUTER_B, bundle)
//        RouterKtx.startActivityForResult(mActivity, RouterPage.AROUTER_B, bundle, 99)
//        startActivity(RouterPage.AROUTER_B, bundle)    //扩展函数
//        //带参pair跳转
//        RouterKtx.startActivity(
//            RouterPage.AROUTER_B,
//            RouterPage.KEY to "hai",
//            RouterPage.DATA to list
//        )
//        RouterKtx.startActivityForResult(
//            mActivity,
//            RouterPage.AROUTER_B,
//            88,
//            RouterPage.KEY to "hai",
//            RouterPage.DATA to list
//        )
//        startActivity(
//            RouterPage.AROUTER_B,
//            RouterPage.KEY to "hai",
//            RouterPage.DATA to list
//        )    //扩展函数
//        //回调跳转优化
//        //原生跳转优化
//        ActivityHelperK.init(mActivity)
//            .startActivityForResult(ArouterBActivity::class.java) { resultCode, data ->
//
//            }
//        //扩展函数
//        startActivityForResult(ArouterBActivity::class.java) { resultCode, data ->
//
//        }
//        //原生带参
//        val intent = Intent(mActivity, ArouterBActivity::class.java)
//        intent.putExtra(RouterPage.KEY, "hai")
//        intent.putExtra(RouterPage.DATA, list)
//        ActivityHelperK.init(mActivity)
//            .startActivityForResult(intent) { resultCode, data ->
//
//            }
//        //扩展函数
//        startActivityForResult(intent) { resultCode, data ->
//
//        }
//        //路由跳转
//        ActivityHelperK.init(mActivity)
//            .startActivityForResult(RouterPage.AROUTER_B) { resultCode, data ->
//
//            }
//        //扩展函数
//        startActivityForResult(RouterPage.AROUTER_B) { resultCode, data ->
//
//        }
//        //路由bundle传值跳转
//        ActivityHelperK.init(mActivity)
//            .startActivityForResult(RouterPage.AROUTER_B, bundle) { resultCode, data ->
//
//            }
//        //扩展函数
//        startActivityForResult(RouterPage.AROUTER_B, bundle) { resultCode, data ->
//
//        }
//        //路由pair传值跳转
//        ActivityHelperK.init(mActivity)
//            .startActivityForResult(RouterPage.AROUTER_B, { resultCode, data ->
//
//            }, RouterPage.KEY to "hai", RouterPage.DATA to list)
//        //扩展函数
//        startActivityForResult(RouterPage.AROUTER_B, { resultCode, data ->
//
//        }, RouterPage.KEY to "hai", RouterPage.DATA to list)

    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//       LogUtils.e(data,"MMM", "fg : $resultCode" )
//        LogUtils.e(data?.getStringExtra("key"),"key---$requestCode")
//    }
}