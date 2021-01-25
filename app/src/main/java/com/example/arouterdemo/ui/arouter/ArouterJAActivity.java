package com.example.arouterdemo.ui.arouter;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.arouterdemo.R;
import com.example.arouterdemo.ktx.RouterKtx;
import com.example.arouterdemo.page.RouterPage;
import com.example.arouterdemo.utils.LogUtils;

import java.util.ArrayList;

/**
 * @author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/25
 * desc   :
 */
@Route(path = RouterPage.AROUTER_JA)
public class ArouterJAActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouterj);

        ArrayList<RouterBean> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            RouterBean bean = new RouterBean("hello -- " + i, i);
            list.add(bean);
        }
        //java使用
         findViewById(R.id.btnRouterANo).setOnClickListener(view -> {
            //无回调路由跳转
             //无参跳转
//             RouterKtx.INSTANCE.startActivity(RouterPage.AROUTER_JB);
             //带参跳转
             //使用bundle传值
//             Bundle bundle = new Bundle();
//             bundle.putString(RouterPage.KEY,"key");
//             BundleKtx.INSTANCE.putList(bundle,RouterPage.DATA,list);
//             RouterKtx.INSTANCE.startActivity(RouterPage.AROUTER_JB,bundle);
             //使用Pair传值
//             RouterKtx.INSTANCE.startActivity(RouterPage.AROUTER_JB,new Pair<>(RouterPage.KEY,"key"),new Pair<>(RouterPage.DATA,list));
             //回调跳转
             RouterKtx.INSTANCE.startActivityForResult(this,RouterPage.AROUTER_JB,9);
            //扩展函数
//             RouterKtxKt.startActivity(this,RouterPage.AROUTER_JB);

//             ActivityHelper.Companion.init(this)
//                     .startActivityForResult(ArouterBActivity.class,((resultCode, data) -> {
//
//                     }));

         });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        LogUtils.e(requestCode + "----onActivityResult-----" + resultCode);
        LogUtils.e(data);
        if (data != null){
            LogUtils.e(data.getStringExtra(RouterPage.KEY),"----onActivityResult-----");
        }

    }
}

