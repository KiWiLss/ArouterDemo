package com.example.arouterdemo.utils;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class LogUtils {

    public static final String TAG = "MMM";
    public static boolean isLog = true;

    public static void e(String content) {
        e(content, TAG, "");
    }

    public static void e(Object content) {
        e(content, TAG, "");
    }

    public static void e(Object content, String middle) {
        e(content, TAG, middle);
    }

    public static void e(String content, String middle) {
        e(content, TAG, middle);
    }

    public static void e(String content, String tag, String middle) {
        if (isLog)
            Log.e(tag, middle + " ---- e: " + content);
    }

    public static void e(Object content, String tag, String middle) {
        try {
            if (isLog)
                e(content == null ? "null" : JSON.toJSONString(content), tag, middle);
        } catch (Exception e) {
        }
    }

//    public static void d(Object object) {
//        if (isLog)
//            Logger.d(object);
//    }

//    public static void ee(Object object) {
//        try {
//            if (isLog)
//                Logger.e(object == null ? "null" : JSON.toJSONString(object));
//        } catch (Exception e) {
//
//        }
//    }
//
//    public static void json(String json) {
//        if (isLog) {
//            Logger.json(json);
//        }
//    }
//
//    public static <E> String list2Json(List<E> list) {
//        if (ListUtils.isEmpty(list)) {
//            return null;
//        }
//        try {
//            return JSON.toJSONString(list);
//        } catch (Exception e) {
//
//        }
//        return null;
//    }

    public static <T> List<T> json2List(String json, Class<T> tClass) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        try {
            return JSON.parseArray(json, tClass);
        } catch (Exception e) {

        }
        return null;
    }


}
