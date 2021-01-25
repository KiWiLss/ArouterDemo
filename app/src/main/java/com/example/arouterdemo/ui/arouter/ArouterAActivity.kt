package com.example.arouterdemo.ui.arouter

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.example.arouterdemo.R
import com.example.arouterdemo.Test
import com.example.arouterdemo.help.ActivityHelper
import com.example.arouterdemo.help.ActivityHelper.Companion.init
import com.example.arouterdemo.ktx.RouterKtx
import com.example.arouterdemo.page.RouterPage
import com.example.arouterdemo.utils.LogUtils
import com.example.arouterdemo.ktx.startActivityForResult
import kotlinx.android.synthetic.main.activity_router_a.*
import java.util.*

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/20
 *  desc   :
 */
@Route(path = RouterPage.AROUTER_A)
class ArouterAActivity : AppCompatActivity(R.layout.activity_router_a) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        supportFragmentManager.beginTransaction()
            .add(R.id.flRouterAFg, ArouterFg())
            .commit()

        btnRouterANo.setOnClickListener {
            val bean = RouterBean("alice", 20)
            ARouter.getInstance()
                .build(RouterPage.AROUTER_B)
                //.withSerializable(RouterPage.DATA,bean)
                .navigation()
        }

        btnRouterAHas.setOnClickListener {
            val bean = RouterBean("alice", 20)
            val bean2 = RouterBean("hh", 2)
            val list = listOf<RouterBean>(bean, bean2)
            val bundle = Bundle()
            Test.listTest(bundle, list)
            bundle.putString(RouterPage.KEY, "hello word")
            bundle.putInt(RouterPage.ID, 123)
            ARouter.getInstance()
                .build(RouterPage.AROUTER_B)
                .with(bundle)
                .navigation()
        }

        //拦截
        btnRouterAHas2.setOnClickListener {
            //拦截后会执行 onFound   onInterrupt
            //不拦截会执行 onFound  onArrival
            ARouter.getInstance().build(RouterPage.AROUTER_B)
                .navigation(this, object : NavigationCallback {
                    override fun onLost(postcard: Postcard?) {//迷失
                        LogUtils.e("onLost")
                    }

                    override fun onFound(postcard: Postcard?) {//发现
                        LogUtils.e("onFound")
                    }

                    override fun onInterrupt(postcard: Postcard?) {//中断
                        LogUtils.e("onInterrupt")
                    }

                    override fun onArrival(postcard: Postcard?) {//到达
                        LogUtils.e("onArrival")
                    }

                })
        }
        //回调
        btnRouterAHas3.setOnClickListener {
            RouterKtx.startActivity(RouterPage.AROUTER_B, RouterPage.KEY to "234")
        }
        //接口回调
        btnRouterAHas4.setOnClickListener {
            ActivityHelper.init(this)
                .startActivityForResult(RouterPage.AROUTER_B, object : ActivityHelper.Callback {
                    override fun onActivityResult(resultCode: Int, data: Intent?) {
                        LogUtils.e(data, "result--$resultCode")
                    }
                })
        }
        btnRouterAHas5.setOnClickListener {
            //传list数据
            val list = arrayListOf(RouterBean("a1", 11), RouterBean("a2", 31))
//            ActivityHelper.init(this)
//                .startActivityForResult(RouterPage.AROUTER_B,object : ActivityHelper.Callback{
//                    override fun onActivityResult(resultCode: Int, data: Intent?) {
//                            LogUtils.e(data?.getStringExtra("key"))
//                    }
//                }, RouterPage.DATA to list)
            //从b调用函数直接跳转
//            ArouterBActivity.startActivity(this,"234")
            //从b调起带回调
            ArouterBActivity.startActivityForResult(
                this,
                list,
                object : ActivityHelper.Callback {
                    override fun onActivityResult(resultCode: Int, data: Intent?) {
                        LogUtils.e(data?.getStringExtra("key"))
                    }
                })
        }
        btnRouterAHas6.setOnClickListener {
            val list = arrayListOf(RouterBean("a1", 11), RouterBean("a2", 31))
//            ActivityHelperK.init(this)
//                .startActivityForResult(RouterPage.AROUTER_B){result,data ->
//                    LogUtils.e(data?.getStringExtra("key"))
//                }
//            ActivityHelperK.init(this)
//                .startActivityForResult(RouterPage.AROUTER_B,{result,data ->
//                    LogUtils.e(data?.getStringExtra("key"))
//                },RouterPage.DATA to list)

            ArouterBActivity.startActivityForResult(this,list){reulstCode, data ->
                LogUtils.e(data?.getStringExtra("key"))
            }
        }

//        ArouterBActivity.test(object : ActivityHelper.Callback{
//            override fun onActivityResult(resultCode: Int, data: Intent?) {
//
//            }
//
//        })

//        ActivityHelper.init(this)
//            .startActivityForResult(RouterPage.AROUTER_B,object :ActivityHelper.Callback{
//                override fun onActivityResult(resultCode: Int, data: Intent?) {
//
//                }
//
//            })

    }

    fun testKK(activity: FragmentActivity?) {
        init(activity!!)
            .startActivityForResult(
                "",
                object : ActivityHelper.Callback {
                    override fun onActivityResult(resultCode: Int, data: Intent?) {

                    }
                })


        startActivityForResult(RouterPage.AROUTER_B){
            resultCode, data ->

        }


    }

    fun testList() {
        val bundle = Bundle()
        val list = ArrayList<Any>() //这个arraylist是可以直接在bundle里传的，所以我们可以借用一下它的功能

//        list.add(list2) //这个list2才是你真正想要传过去的list。我们把它放在arraylis中，借助它传过去
//
//        bundle.putParcelableArrayList("list", list)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        LogUtils.e(data?.getStringExtra("key"),"key")
        LogUtils.e(data, "onActivityResult--data:")
//        LogUtils.e(resultCode,"onActivityResult--resultCode: $requestCode")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            supportFragmentManager.fragments.forEach {
                it.onActivityResult(requestCode, resultCode, data)
            }
        }
    }
}