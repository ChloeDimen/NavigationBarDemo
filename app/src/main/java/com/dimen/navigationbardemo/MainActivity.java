package com.dimen.navigationbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewGroup viewById = findViewById(R.id.view_root);
       /* NavigationBar navigationBar = new NavigationBar.Builder(this, R.layout.ui_navigation_bar, viewById)
                .setText(R.id.tv_back, "返回")
                .setOnclickListener(R.id.tv_back, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                })


                .create();*/
        DefaultNavigationBar navigationBar = new DefaultNavigationBar.Builder(this, viewById)
                .setLeftText( "返回")

                //.hideLeftText()
                .setLeftOnclickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                })
                .setRightText("我的啊")
                .setRightOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"sssss",Toast.LENGTH_SHORT).show();
                    }
                })

                .create();

    }
}
