package com.example.androiddevelopment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class FragmentTabActivity extends AppCompatActivity implements View.OnClickListener {
    public String[] btnTitles = new String[]{"通讯录","消息", "新闻","其他"};// 按钮标题
    public List<Fragment> contextFragments = new ArrayList<>();// 用来存放Fragments的集合
    public LinearLayout linearLayout;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab);
        Log.d("FirstActivity",this.toString());

        init();// 初始化控件
    }

    /**
     * 初始化控件
     */
    private void init() {
        // 初始化按钮
        initButton();

        // 初始化Fragment
        initFragment();
    }

    /**
     * 初始化按钮控件
     */
    public void initButton() {
        // 获取存放按钮的LinearLayout
        linearLayout = findViewById(R.id.buttonLayout);

        // 遍历按钮标题数组，动态添加按钮
        for (String btnStr: btnTitles) {

            Button btn = new Button(this);
            btn.setText(btnStr);
            btn.setTag(btnStr);// 存放Tag,值为按钮标题文本

            // 设置按钮样式
            btn.setBackgroundColor(Color.WHITE);
            LinearLayout.LayoutParams btnLayoutParams =
                    new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);

            // 添加点击事件
            btn.setOnClickListener(this);

            // 将按钮加入LinearLayout
            linearLayout.addView(btn, btnLayoutParams);
    }
    }

    /**
     * 初始化Fragment
     */
    public void initFragment() {
        // 获取FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // 开始事务管理
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // 添加按钮对应的Fragment
        FruitFragment fruitFragment = new FruitFragment();
        MsgFragment msgFragment = new MsgFragment();
        OthFragment othFragment = new OthFragment();

        // 将ContextFragment添加到contextFrameLayout，并设置tag为按钮的标题
        // （这里的Tag和按钮的Tag是一样的，按钮点击事件中用按钮的Tag查找Fragment）
        transaction.add(R.id.contextFrameLayout, fruitFragment, "通讯录");
        transaction.add(R.id.contextFrameLayout,msgFragment,"消息");
        transaction.add(R.id.contextFrameLayout,othFragment,"其他");

        // 将contextFragment加入Fragment集合中
        contextFragments.add(fruitFragment);
        contextFragments.add(msgFragment);
        contextFragments.add(othFragment);

        /*// 设置ContextFragment中文本的值，这里用Bundle传值
        Bundle bundle = new Bundle();
        bundle.putString("textValue", btnStr);
        contextFragment.setArguments(bundle);*/

        // 提交事务
        transaction.commit();

        // 显示第一个Fragment,隐藏其它的Fragment
        showFragment(btnTitles[0]);
    }

    /**
     * 显示指定的Fragment
     * @param tag
     */
    public void showFragment(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // 遍历contextFragments
        for (Fragment fragment: contextFragments) {
            if (fragment.getTag().equals(tag)) {// tag一样，显示Fragment
                transaction.show(fragment);
            } else {// 隐藏Fragment
                transaction.hide(fragment);
            }
        }
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        // 显示相应的Fragment
        showFragment(view.getTag().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",
                        Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("FirstActivity","onRestart");
    }
}
