package com.example.arouterdemo.ui.arouter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.arouterdemo.R
import com.example.arouterdemo.help.ActivityHelper
import com.example.arouterdemo.page.RouterKtx
import com.example.arouterdemo.page.RouterPage
import com.example.arouterdemo.utils.LogUtils
import kotlinx.android.synthetic.main.activity_router_b.*

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/20
 *  desc   :
 */
@Route(path = RouterPage.AROUTER_B)
class ArouterBActivity : AppCompatActivity(R.layout.activity_router_b) {

    //    //获取传入参数
    @Autowired(name = RouterPage.KEY)
    @JvmField
    var mKey: String? = null

    //传递一个对象
//    @Autowired(name = RouterPage.DATA)
//    @JvmField var mData: RouterBean? = null
    //传递一个list
    @Autowired(name = RouterPage.DATA)
    @JvmField
    var mData: ArrayList<RouterPage>? = null

    companion object {
        fun startActivity(activity: FragmentActivity, key: String?) {
            RouterKtx.startActivity(RouterPage.AROUTER_B, RouterPage.KEY to key)
        }
        fun startActivityResult(
            activity: FragmentActivity,
            list: List<*>,
            callback: ActivityHelper.Callback
        ) {
            ActivityHelper.init(activity)
                .startActivityForResult(RouterPage.AROUTER_B, callback, RouterPage.DATA to list)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)

        LogUtils.e(mKey)

        LogUtils.e(mData)

        btnRouterBNo.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        btnRouterBPara.setOnClickListener {
            val intent = Intent()
            intent.putExtra("key", "hai")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}