package com.example.arouterdemo.ui.arouter;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.arouterdemo.R;
import com.example.arouterdemo.page.RouterPage;
import com.example.arouterdemo.utils.LogUtils;

import java.util.ArrayList;

/**
 * @author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/25
 * desc   :
 */
@Route(path = RouterPage.AROUTER_JB)
public class ArouterJBActivity extends AppCompatActivity {

    //获取参数
    @Autowired(name = RouterPage.KEY)
    String mKey;
    @Autowired(name = RouterPage.DATA)
    ArrayList<RouterPage> mData;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jb);

        ARouter.getInstance().inject(this);


        LogUtils.e(mKey);
        LogUtils.e(mData);

         findViewById(R.id.btnJbNo).setOnClickListener(view->{
             setResult(RESULT_OK);
             finish();
         });

        findViewById(R.id.btnJbHas).setOnClickListener(view->{
            Intent intent = new Intent();
            intent.putExtra(RouterPage.KEY,"回调key");
            setResult(RESULT_OK,intent);
            finish();
        });


    }
}

