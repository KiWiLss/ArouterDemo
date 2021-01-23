package com.example.arouterdemo.helpk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.arouterdemo.ktx.BundleKtx

class ActivityHelperK private constructor(activity: FragmentActivity) {
    private val TAG = "MMMK"
    private var mContext: Activity? = null
    private var mRouterFragment: RouterFragmentK? = null


    init {
        mContext = activity
        mRouterFragment = getRouterFragment(activity)
    }

    companion object {
        fun init(activity: FragmentActivity): ActivityHelperK {
            return ActivityHelperK(activity)
        }
    }


    private fun getRouterFragment(activity: FragmentActivity): RouterFragmentK? {
        var routerFragment: RouterFragmentK? = findRouterFragment(activity)
        if (routerFragment == null) {
            //创建 fragment,加入当前 activity
            routerFragment = RouterFragmentK.newInstance()
            val sfm = activity.supportFragmentManager
            sfm.beginTransaction().add(routerFragment!!, TAG).commitAllowingStateLoss()
            sfm.executePendingTransactions()
        }
        return routerFragment
    }

    private fun findRouterFragment(activity: FragmentActivity): RouterFragmentK? {
        //通过 tag 获取 fragment
        return activity.supportFragmentManager.findFragmentByTag(TAG) as RouterFragmentK?
    }

    /**
     * 针对阿里路由跳转
     */
    //跳转方法
    fun startActivityForResult(
        pageName: String,
        callback: ((Int, Intent?) -> Unit)? = null
    ) {
        mRouterFragment?.run {
            startActivityForResult(mContext!!, pageName, callback)
        }
    }

    //跳转方法
    fun startActivityForResult(
        pageName: String,
        bundle: Bundle,
        callback: ((Int, Intent?) -> Unit)?
    ) {
        mRouterFragment?.run {
            startActivityForResult(mContext!!, pageName, bundle, callback)
        }
    }

    fun startActivityForResult(
        pageName: String,
        callback: ((Int, Intent?) -> Unit)?,
        vararg params: Pair<String, Any?>
    ) {
        mRouterFragment?.run {
            startActivityForResult(mContext!!, pageName, BundleKtx.createBundle(*params), callback)
        }
    }

    /**
     * 对Intent跳转
     */
    //跳转方法
    fun startActivityForResult(
        clazz: Class<*>,
        callback: ((Int, Intent?) -> Unit)?
    ) {
        val intent = Intent(mContext, clazz)
        startActivityForResult(intent, callback)
    }

    fun startActivityForResult(intent: Intent, callback: ((Int, Intent?) -> Unit)?) {
        mRouterFragment?.run {
            startActivityForResult(intent, callback)
        }
    }

}


