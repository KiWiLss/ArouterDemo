package com.example.arouterdemo.ui.arouter

import android.os.Parcelable
import java.io.Serializable

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/20
 *  desc   :
 */
class RouterBean(var name: String?, var age: Int): Serializable {

    fun isAdult() = age > 18

}