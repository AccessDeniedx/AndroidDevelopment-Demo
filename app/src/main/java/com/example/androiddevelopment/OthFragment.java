package com.example.androiddevelopment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyPermission;

import androidx.annotation.NonNull;

public class OthFragment extends Fragment {

    private ProgressBar progressBar;
    private ProgressBar progressBarH;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.other_fragment, container, false);
        Log.d("FirstActivity", "Task id is " + getActivity().getTaskId());//singleinstance打印当前返回栈的id

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //销毁
        Button finish_button = (Button) getActivity().findViewById(R.id.finish_button);
        finish_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        //显式intent
        Button explicit_button = (Button) getActivity().findViewById(R.id.explicitIntent_button);
        explicit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
            }
        });

        //隐式intent
        Button implicit_button = (Button) getActivity().findViewById(R.id.implicitIntent_button);
        implicit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.androiddevelopment.ACTION_START");
                intent.addCategory("com.example.androiddevelopment.MY_CATEGORY");
                startActivity(intent);
            }
        });

        //intenturl
        Button intenturl_button = (Button) getActivity().findViewById(R.id.intenturl_button);
        intenturl_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        });

        //打开打电话界面
        Button call_button = (Button) getActivity().findViewById(R.id.call_button);
        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        //传递数据+显式
        Button transdata_button = (Button) getActivity().findViewById(R.id.trans_button);
        transdata_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Hello SecondActivity";
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);
            }
        });

        //回传数据
        Button anti_transdata_button = (Button) getActivity().findViewById(R.id.anti_trans_button);
        anti_transdata_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                getActivity().startActivityForResult(intent, 1);
            }
        });

        //生命周期
        Button startNormalActivity = (Button) getActivity().findViewById(R.id.normal_button);
        Button startDialogAcitvity = (Button) getActivity().findViewById(R.id.dialog_button);
        startNormalActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(),NormalActivity.class);
                startActivity(intent);
            }
        });
        startDialogAcitvity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(),DialogActivity.class);
                startActivity(intent);
            }
        });

        //活动启动模式
        Button standard_button = (Button) getActivity().findViewById(R.id.standard_button);
        standard_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(),FragmentTabActivity.class);
                startActivity(intent);
            }
        });

        //singletop
        Button singletop_button = (Button) getActivity().findViewById(R.id.singletop_button);
        singletop_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(),SecondActivity.class);
                startActivity(intent);
            }
        });

        //singleinstance
        Button singleinstance_button = (Button) getActivity().findViewById(R.id.singleinstance_button);
        singleinstance_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(),SecondActivity.class);
                startActivity(intent);
            }
        });

        //启动活动最佳实践
        Button bestpractice_button = (Button) getActivity().findViewById(R.id.bestpractice_button);
        bestpractice_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //一行代码启动活动传参数
                SecondActivity.actionStart(getActivity(),"data1","data2");
            }
        });

        //圆形进度条
        progressBar = (ProgressBar) getActivity().findViewById(R.id.progress_bar);
        Button progressbar_button = (Button) getActivity().findViewById(R.id.progress_button);
        progressbar_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //点击切换圆形进度条是否可见
                if(progressBar.getVisibility() == View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                } else{
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        //水平进度条
        progressBarH = (ProgressBar) getActivity().findViewById(R.id.progress_barhori);
        Button progressbarho_button = (Button) getActivity().findViewById(R.id.progresshoriz_button);
        progressbarho_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //点击水平进度条前进10
                int progress = progressBarH.getProgress();
                progress = progress + 10;
                progressBarH.setProgress(progress);
            }
        });

        //AlertDialog
        Button alertdg_button = (Button) getActivity().findViewById(R.id.alert_button);
        alertdg_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //提示对话框
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something important.");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });

        //ProgressDialog
        Button Progdg_button = (Button) getActivity().findViewById(R.id.progressdialog_button);
        Progdg_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //进度条对话框
                ProgressDialog progressDialog = new ProgressDialog(getActivity());
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading……");
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
        });

        //碎片实践 新闻
        Button news_button = (Button) getActivity().findViewById(R.id.news_button);
        news_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), News_activity.class);
                startActivity(intent);
            }
        });

    }

}
