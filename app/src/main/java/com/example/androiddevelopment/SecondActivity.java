package com.example.androiddevelopment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Log.d("SecondActivity:",this.toString());
        Log.d("SecondActivity", "Task id is " + getTaskId());

        Intent intent = getIntent();
        if (intent.getStringExtra("extra_data") != null) {
            String data = intent.getStringExtra("extra_data");
            Log.d("SecondActivity", data);
        }

        Button databack_button = (Button) findViewById(R.id.data_back);
        databack_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //回传数据
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello FirstActivity");
                setResult(RESULT_OK, intent);
                finish();

            }
        });

        Button singletop = (Button) findViewById(R.id.singletop_button);
        singletop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //singletop模式
                Intent intent = new Intent(SecondActivity.this, FragmentTabActivity.class);
                startActivity(intent);
            }
        });

        Button singleinstance = (Button) findViewById(R.id.singleinstance_button);
        singleinstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //singleinstance模式
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello FirstActivity");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity", "onDestroy");
    }

}
