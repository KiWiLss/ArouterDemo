package com.example.arouterdemo.utils

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import java.util.concurrent.atomic.AtomicInteger


object MyRouter {

    private var requestCode = AtomicInteger(1)

    fun navigation(fragmentActivity: FragmentActivity, intent: Intent, callback: (Int, Intent?) -> Unit) {
        val code = requestCode.getAndIncrement()
        val emptyFragment = EmptyFragment()
        emptyFragment.callback=callback
        emptyFragment.requestCode= code
        fragmentActivity.supportFragmentManager.beginTransaction().add(emptyFragment, "$code").commit()
        fragmentActivity.startActivityFromFragment(emptyFragment, intent, code)
    }

    fun navigation(fragment: Fragment, intent: Intent, callback: (Int, Intent?) -> Unit) {
        val code = requestCode.getAndIncrement()
        val emptyFragment = EmptyFragment()
        emptyFragment.callback=callback
        emptyFragment.requestCode= code
        fragment.activity?.startActivityFromFragment(emptyFragment, intent, code)
    }

}


class EmptyFragment: Fragment() {

    @SuppressLint("SupportAnnotationUsage")
    @androidx.annotation.IntRange(to = 0xFFFF)
    var requestCode: Int = -1
    var callback: ((Int, Intent?) -> Unit)? = null


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("MMM", ":  $requestCode + $resultCode")
        if (this.requestCode == requestCode) {
            callback?.invoke(resultCode, data)
        }
        activity?.supportFragmentManager?.beginTransaction()?.remove(this@EmptyFragment)?.commit()
    }
}

