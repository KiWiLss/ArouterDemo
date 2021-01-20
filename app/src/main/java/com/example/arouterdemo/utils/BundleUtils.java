package com.example.arouterdemo.utils;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/20
 * desc   :
 */
public class BundleUtils {
    public static <T>void putList(Bundle bundle,String key, List<T> list){
        ArrayList arrayList = new ArrayList(list);
        bundle.putParcelableArrayList(key,arrayList);
    }
}

