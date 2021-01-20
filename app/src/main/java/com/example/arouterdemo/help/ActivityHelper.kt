package com.example.arouterdemo.help

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.arouterdemo.utils.BundleUtils
import java.io.Serializable

class ActivityHelper private constructor(activity: FragmentActivity) {
    private val TAG = "MMM"
    private var mContext: Activity? = null
    private var mRouterFragment: RouterFragment? = null


    init {
        mContext = activity
        mRouterFragment = getRouterFragment(activity)
    }

    companion object {
        fun init(activity: FragmentActivity): ActivityHelper {
            return ActivityHelper(activity)
        }
    }


    private fun getRouterFragment(activity: FragmentActivity): RouterFragment? {
        var routerFragment: RouterFragment? = findRouterFragment(activity)
        if (routerFragment == null) {
            //创建 fragment,加入当前 activity
            routerFragment = RouterFragment.newInstance()
            val sfm = activity.supportFragmentManager
            sfm.beginTransaction().add(routerFragment!!, TAG).commitAllowingStateLoss()
            sfm.executePendingTransactions()
        }
        return routerFragment
    }

    private fun findRouterFragment(activity: FragmentActivity): RouterFragment? {
        //通过 tag 获取 fragment
        return activity.supportFragmentManager.findFragmentByTag(TAG) as RouterFragment?
    }

    //跳转方法
    fun startActivityForResult(
        pageName: String,
        callback: Callback
    ) {
        mRouterFragment?.run {
            startActivityForResult(mContext!!, pageName, callback)
        }
    }

    //跳转方法
    fun startActivityForResult(
        pageName: String,
        bundle: Bundle,
        callback: Callback
    ) {
        mRouterFragment?.run {
            startActivityForResult(mContext!!, pageName, bundle, callback)
        }
    }

    fun startActivityForResult(
        pageName: String,
        callback: Callback,
        vararg params: Pair<String, Any?>
    ) {
        mRouterFragment?.run {
            startActivityForResult(mContext!!, pageName, createBundle(*params), callback)
        }
    }

    private fun createBundle(vararg params: Pair<String, Any?>): Bundle {
        val bundle = Bundle()
        params.forEach {
            when (it.second) {
                is String -> {
                    bundle.putString(it.first, it.second as String)
                }
                is Int -> {
                    bundle.putInt(it.first, it.second as Int)
                }
                is Long -> {
                    bundle.putLong(it.first, it.second as Long)
                }
                is Double -> {
                    bundle.putDouble(it.first, it.second as Double)
                }
                is List<*> -> {
                    BundleUtils.putList(bundle, it.first, it.second as List<*>)
                }
                is Serializable -> {
                    bundle.putSerializable(it.first, it.second as Serializable?)
                }
                else -> {

                }
            }
        }
        return bundle
    }


    interface Callback {
        fun onActivityResult(resultCode: Int, data: Intent?)
    }
}