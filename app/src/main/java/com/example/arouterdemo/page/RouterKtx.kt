package com.example.arouterdemo.page

import android.app.Activity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.example.arouterdemo.utils.BundleUtils
import java.io.Serializable

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/20
 *  desc   :
 */
object RouterKtx {
    fun startActivity(pageName: String?) {
        ARouter.getInstance().build(pageName)
            .navigation()
    }

    fun startActivity(pageName: String?, bundle: Bundle?) {
        ARouter.getInstance().build(pageName).with(bundle)
            .navigation()
    }

    fun startActivity(pageName: String, vararg params: Pair<String, Any?>) {
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
        ARouter.getInstance().build(pageName).with(bundle)
            .navigation()
    }

    fun startActivityForResult(
        activity: Activity?,
        pageName: String?,
        requestCode: Int
    ) {
        ARouter.getInstance().build(pageName)
            .navigation(activity, requestCode)
    }

    fun startActivityForResult(
        activity: Activity?,
        pageName: String?,
        bundle: Bundle?,
        requestCode: Int
    ) {
        ARouter.getInstance().build(pageName).with(bundle)
            .navigation(activity, requestCode)
    }

    fun startActivityForResultParams(
        activity: Activity?,
        pageName: String?,
        requestCode: Int,
        vararg params: Pair<String, Any?>
    ) {
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
        ARouter.getInstance().build(pageName).with(bundle)
            .navigation(activity, requestCode)
    }




}

