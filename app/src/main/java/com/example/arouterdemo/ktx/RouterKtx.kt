package com.example.arouterdemo.ktx

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.example.arouterdemo.helpk.ActivityHelperK
import com.example.arouterdemo.ktx.BundleKtx

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
        ARouter.getInstance().build(pageName).with(BundleKtx.createBundle(*params))
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

    fun startActivityForResult(
        activity: Activity?,
        pageName: String?,
        requestCode: Int,
        vararg params: Pair<String, Any?>
    ) {
        ARouter.getInstance().build(pageName).with(BundleKtx.createBundle(*params))
            .navigation(activity, requestCode)
    }
}


/**
 * 跳转相关扩展
 */
//Context路由跳转相关
fun Context.startActivity(pageName: String) {
    RouterKtx.startActivity(pageName)
}

fun Context.startActivity(pageName: String, bundle: Bundle) {
    RouterKtx.startActivity(pageName, bundle)
}

fun Context.startActivity(pageName: String, vararg params: Pair<String, Any?>) {
    RouterKtx.startActivity(pageName, *params)
}

fun Context.startActivityForResult(
    pageName: String,
    callback: (resultCode: Int, data: Intent?) -> Unit
) {
    if (this is Activity) {
        ActivityHelperK.init(this as FragmentActivity)
            .startActivityForResult(pageName, callback)
    }
}

fun Context.startActivityForResult(
    pageName: String,
    bundle: Bundle,
    callback: (resultCode: Int, data: Intent?) -> Unit
) {
    if (this is Activity) {
        ActivityHelperK.init(this as FragmentActivity)
            .startActivityForResult(pageName, bundle, callback)
    }
}


fun Context.startActivityForResult(
    pageName: String,
    callback: ((Int, Intent?) -> Unit)? = null,
    vararg params: Pair<String, Any?>
) {
    if (this is Activity) {
        ActivityHelperK.init(this as FragmentActivity)
            .startActivityForResult(pageName, callback, *params)
    }
}

fun Context.startActivityForResult(clazz: Class<*>, callback: ((Int, Intent?) -> Unit)?) {
    if (this is Activity) {
        ActivityHelperK.init(this as FragmentActivity)
            .startActivityForResult(clazz, callback)
    }
}

fun Context.startActivityForResult(intent: Intent, callback: ((Int, Intent?) -> Unit)?) {
    if (this is Activity) {
        ActivityHelperK.init(this as FragmentActivity)
            .startActivityForResult(intent, callback)
    }
}

//Fragment路由跳转相关
fun Fragment.startActivity(pageName: String) {
    RouterKtx.startActivity(pageName)
}

fun Fragment.startActivity(pageName: String, bundle: Bundle?) {
    RouterKtx.startActivity(pageName, bundle)
}

fun Fragment.startActivity(pageName: String, vararg params: Pair<String, Any?>) {
    RouterKtx.startActivity(pageName, *params)
}

fun Fragment.startActivityForResult(
    pageName: String,
    callback: ((Int, Intent?) -> Unit)?
) {
    this.activity?.run {
        ActivityHelperK.init(this)
            .startActivityForResult(pageName, callback)
    }

}

fun Fragment.startActivityForResult(
    pageName: String,
    bundle: Bundle,
    callback: (resultCode: Int, data: Intent?) -> Unit
) {
    this.activity?.run {
        ActivityHelperK.init(this)
            .startActivityForResult(pageName, bundle, callback)
    }

}


fun Fragment.startActivityForResult(
    pageName: String,
    callback: ((Int, Intent?) -> Unit)?,
    vararg params: Pair<String, Any?>
) {
    this.activity?.run {
        ActivityHelperK.init(this)
            .startActivityForResult(pageName, callback, *params)
    }
}

fun Fragment.startActivityForResult(clazz: Class<*>, callback: ((Int, Intent?) -> Unit)?) {
    this.activity?.run {
        ActivityHelperK.init(this)
            .startActivityForResult(clazz, callback)
    }
}

fun Fragment.startActivityForResult(intent: Intent, callback: ((Int, Intent?) -> Unit)?) {
    this.activity?.run {
        ActivityHelperK.init(this)
            .startActivityForResult(intent, callback)
    }
}

