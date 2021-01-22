package com.example.arouterdemo.ktx

import android.os.Bundle
import java.io.Serializable
import java.util.*

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/20
 *  desc   :
 */
object BundleKtx {
    fun createBundle(vararg params: Pair<String, Any?>): Bundle{
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
                    putList(
                        bundle,
                        it.first,
                        it.second as ArrayList<*>
                    )
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

    fun <T> putList(bundle: Bundle, key: String, list: ArrayList<T>?) {
        bundle.putSerializable(key, list)
    }


}