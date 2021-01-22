package com.example.arouterdemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.arouterdemo.help.ActivityHelper;
import com.example.arouterdemo.helpk.ActivityHelperK;
import com.example.arouterdemo.ktx.RouterKtx;
import com.example.arouterdemo.page.RouterPage;
import com.example.arouterdemo.utils.MyRouter;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/19
 * desc   :
 */
public class Test {

    public void testKK(FragmentActivity activity){
        ActivityHelper.Companion.init(activity)
                .startActivityForResult("", new ActivityHelper.Callback() {
                    @Override
                    public void onActivityResult(int resultCode, @Nullable Intent data) {

                    }
                });
    }

    public void test(FragmentActivity activity){
        MyRouter.INSTANCE.navigation(new Fragment(), new Intent(), new Function2<Integer, Intent, Unit>() {
            @Override
            public Unit invoke(Integer integer, Intent intent) {
                return null;
            }
        });
        ActivityHelper.Companion.init(null)
                .startActivityForResult("",(resultCode,data) -> {

                });
        ActivityHelper.Companion.init(activity)
                .startActivityForResult("",((resultCode, data) -> {

                }),new Pair<>("1",1));
        RouterKtx.INSTANCE.startActivity("",new Pair<>("1",1));
    }

    public static <T>void listTest(Bundle bundle,List<T> list){
        ArrayList arrayList = new ArrayList(list);
        bundle.putParcelableArrayList(RouterPage.DATA,arrayList);
    }

    public static<T> void listTests2(Bundle bundle,ArrayList<T>list){
        bundle.putSerializable(RouterPage.DATA,list);
    }

    public void kTest(FragmentActivity activity, List list){
        ActivityHelperK.Companion.init(activity)
                .startActivityForResult(RouterPage.AROUTER_B, new Function2<Integer, Intent, Unit>() {
                    @Override
                    public Unit invoke(Integer integer, Intent intent) {
                        return null;
                    }
                },new Pair<>(RouterPage.DATA,list));

    }


}

