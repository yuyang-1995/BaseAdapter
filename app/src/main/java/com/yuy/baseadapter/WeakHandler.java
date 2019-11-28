package com.yuy.baseadapter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;

public class WeakHandler extends Handler {

    public interface IHandler{
        void handlMsg(Message message);
    }

    //弱引用
    private final WeakReference<IHandler> mRef;

    public WeakHandler(IHandler handler){
        this.mRef =  new WeakReference<>(handler);
    }

    public WeakHandler(Looper looper, IHandler handler) {
        super(looper);
        mRef = new WeakReference<>(handler);
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        IHandler handler = mRef.get();
        if (msg != null && handler != null) {
            handler.handlMsg(msg);
        }

    }
}
