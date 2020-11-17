package com.example.androiddevelopment;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity",getClass().getSimpleName());
        ActivityCollector.addActivity(this);//
    }

    @Override
    protected void onDestroy(){//销毁活动
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
