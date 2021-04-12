package com.tencent.jview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * 1. 验证时间传递流程；
 * 2. 验证cancel时间
 * 3. 验证ViewGroup事件拦截
 */
public class MyViewGourp extends FrameLayout {
    private static final String TAG = "MyViewGourp";

    public MyViewGourp(@NonNull Context context) {
        super(context);
    }

    public MyViewGourp(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGourp(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyViewGourp(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "MyViewGroup->dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "MyViewGroup->onInterceptTouchEvent");
        return /*super.onInterceptTouchEvent(ev)*/true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "MyViewGroup->onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG,"MyViewGroup->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG,"MyViewGroup->ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG,"MyViewGroup->ACTION_UP");
                break;
        }
        return /*super.onTouchEvent(event)*/true;
    }
}
