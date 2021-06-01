package com.tencent.jview.headerrefreshforrecyclerview;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.tencent.jview.R;
import com.tencent.jview.headerrefreshforrecyclerview.adapter.RefreshHeaderAdapter;
import com.tencent.jview.headerrefreshforrecyclerview.interfaces.OnRefreshListener;
import com.tencent.jview.headerrefreshforrecyclerview.view.RefreshHeaderRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HeaderRefreshActivity extends AppCompatActivity {
    private List<String> mStringList = new ArrayList<>();
    private RefreshHeaderRecyclerView mRecyclerView;
    private RefreshHeaderAdapter mAdapter;
    private static final int FINISH = 1;

    @SuppressLint("HandlerLeak")
    private  Handler sHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == FINISH) {
                Toast.makeText(HeaderRefreshActivity.this,"刷新完成！",Toast.LENGTH_SHORT).show();
                mRecyclerView.refreshComplete();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_refresh);
        initData();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new RefreshHeaderAdapter(mStringList, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestData();//模拟数据的请求

            }
        });
    }

    private void requestData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HeaderRefreshActivity.this.toString();
                try {
                    Thread.sleep(1500);
                    Message message = Message.obtain();
                    message.what = FINISH;
                    sHandler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private void initData() {
        for (int i = 0; i < 15; i++) {
            mStringList.add("");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sHandler.removeCallbacks(null);
    }
}
