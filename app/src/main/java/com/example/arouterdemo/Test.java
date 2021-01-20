package com.example.arouterdemo;

import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.arouterdemo.utils.MyRouter;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/19
 * desc   :
 */
public class Test {

    public void test(){
        MyRouter.INSTANCE.navigation(new Fragment(), new Intent(), new Function2<Integer, Intent, Unit>() {
            @Override
            public Unit invoke(Integer integer, Intent intent) {
                return null;
            }
        });
    }
}

