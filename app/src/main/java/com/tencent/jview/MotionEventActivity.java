package com.tencent.jview;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 打印结果：
 *
 * 2021-04-12 20:55:31.866 3690-3690/com.tencent.jview D/MainActivity: MainActivity->dispatchTouchEvent
 * 2021-04-12 20:55:31.867 3690-3690/com.tencent.jview D/MyViewGourp: MyViewGroup->dispatchTouchEvent
 * 2021-04-12 20:55:31.867 3690-3690/com.tencent.jview D/MyViewGourp: MyViewGroup->onInterceptTouchEvent
 * 2021-04-12 20:55:31.867 3690-3690/com.tencent.jview D/MyView: MyView->dispatchTouchEvent
 * 2021-04-12 20:55:31.867 3690-3690/com.tencent.jview D/MyView: MyView->onTouchEvent
 * 2021-04-12 20:55:31.867 3690-3690/com.tencent.jview D/MyViewGourp: MyViewGroup->onTouchEvent
 * 2021-04-12 20:55:31.868 3690-3690/com.tencent.jview D/MainActivity: MainActivity->onTouchEvent
 * 2021-04-12 20:55:31.893 3690-3690/com.tencent.jview D/MainActivity: MainActivity->dispatchTouchEvent
 * 2021-04-12 20:55:31.893 3690-3690/com.tencent.jview D/MainActivity: MainActivity->onTouchEvent
 * 2021-04-12 20:55:31.935 3690-3690/com.tencent.jview D/MainActivity: MainActivity->dispatchTouchEvent
 * 2021-04-12 20:55:31.936 3690-3690/com.tencent.jview D/MainActivity: MainActivity->onTouchEvent
 *
 * 同一个事件序列，如果子View(ViewGroup)没有处理该事件（没有消费事件），那么后续事件就不会再传递到子View中。
 * MainActivity->dispatchTouchEvent -> MainActivity->onTouchEvent
 */
public class MotionEventActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG,"MainActivity->dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG,"MainActivity->onTouchEvent");
        return super.onTouchEvent(event);
    }
}
