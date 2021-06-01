package com.tencent.jview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tencent.jview.headerrefreshforrecyclerview.HeaderRefreshActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.motion_event_check).setOnClickListener(this);
        findViewById(R.id.recyclerView_refresh).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.motion_event_check:
                startActivityInternal(MotionEventActivity.class);
                break;
            case R.id.recyclerView_refresh:
                startActivityInternal(HeaderRefreshActivity.class);
                break;
            default:
                break;
        }
    }

    private void startActivityInternal(Class clazz) {
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }
}