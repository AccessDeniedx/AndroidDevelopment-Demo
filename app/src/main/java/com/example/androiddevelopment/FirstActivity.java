package com.example.androiddevelopment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Log.d("FirstActivity",this.toString());*/
        Log.d("FirstActivity","Task id is "+ getTaskId());//singleinstance打印当前返回栈的id

        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*//toast小消息
                Toast.makeText(FirstActivity.this ,
                        "You clicked button 1",
                        Toast.LENGTH_SHORT).show();*/
                /*//销毁
                finish();*/

                /*//显式intent
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);*/

                /*//隐式intent
                Intent intent = new Intent("com.example.helloworldactivity.ACTION_START");
                intent.addCategory("com.example.helloworldactivity.MY_CATEGORY");
                startActivity(intent);*/

                /*//隐式intent解析网址
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://music.163.com/#/my/m/music/playlist?id=5079618162"));
                startActivity(intent);*/

                /*//打开打电话界面
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);*/

                /*//传递数据
                String data = "Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);*/

                /*//回传
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);*/

                /*//standard模式
                Intent intent = new Intent(FirstActivity.this,FirstActivity.class);
                startActivity(intent);*/

                /*//singletop、singleTask、singleinstance模式intent启动secondActivity
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);*/

                //一行代码启动活动传参数
                SecondActivity.actionStart(FirstActivity.this,"data1","data2");

            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


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
    protected void onRestart(){//singleTask模式
        super.onRestart();
        Log.d("FirstActivity","onRestart");
    }

}