package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     Fragment fragment1=new WechatFragment();
     Fragment fragment2=new Wechat2Fragment();
     Fragment fragment3=new Wechat3Fragment();
     Fragment fragment4=new Wechat4Fragment();

    private FragmentManager fragmentManager;

    LinearLayout LinearLayout1;
    LinearLayout LinearLayout2;
    LinearLayout LinearLayout3;
    LinearLayout LinearLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout1=findViewById(R.id.LinearLayout1);
        LinearLayout2=findViewById(R.id.LinearLayout2);
        LinearLayout3=findViewById(R.id.LinearLayout3);
        LinearLayout4=findViewById(R.id.LinearLayout4);

        LinearLayout1.setOnClickListener(this);
        LinearLayout2.setOnClickListener(this);
        LinearLayout3.setOnClickListener(this);
        LinearLayout4.setOnClickListener(this);


        initFragment();


    }

    protected void initFragment() {
        fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.id_content,fragment1);
        transaction.add(R.id.id_content,fragment2);
        transaction.add(R.id.id_content,fragment3);
        transaction.add(R.id.id_content,fragment4);
        transaction.commit();
    }

    protected void hideFragment(FragmentTransaction transaction) {

        transaction.hide(fragment1);
        transaction.hide(fragment2);
        transaction.hide(fragment3);
        transaction.hide(fragment4);

    }


    @Override
    public void onClick(View v) {
        if (v == LinearLayout1) {
            showfragment(fragment1);
        } else if (v == LinearLayout2) {
            showfragment(fragment2);
        } else if (v==LinearLayout3) {
            showfragment(fragment3);
        } else if (v==LinearLayout4) {
            showfragment(fragment4);
        }

    }
    private void showfragment(Fragment i) {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragment(transaction);
        transaction.show(i);
        transaction.commit();
    }
}