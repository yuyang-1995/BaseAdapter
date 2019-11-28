package com.yuy.recyclerview_adapter.my;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Coder: yuyang
 * Date: 2019/11/18
 * Description: 通用的RecyclerView ViewHolder
 * Version:
 */
public class RViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mConvertView;

    private RViewHolder( @NonNull View itemView) {
        super(itemView);
        mViews = new SparseArray<View>();
        mConvertView = itemView;
    }


    public static RViewHolder getRvHolder(Context context,  ViewGroup parent, int layoutId) {

        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);

        RViewHolder holder = new RViewHolder(itemView);

        return holder;
    }


    /**
     * 获取itemView控件
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {

        View view = mViews.get(viewId);

        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }

        return (T) view;
    }

    //设置控件资源
    public RViewHolder setText(int viewId, String text) {
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    public RViewHolder setImageResource(int viewId, int resId) {

        ImageView imageView = getView(viewId);
        imageView.setImageResource(resId);
        return this;
    }


    public RViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }


    //设置控件事件
    public RViewHolder setOnClickListener(int viewId, View.OnClickListener onClickListener) {
        View view = getView(viewId);
        view.setOnClickListener(onClickListener);
        return this;
    }

    public RViewHolder setOnTouchListener(int viewId,
                                          View.OnTouchListener listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    public RViewHolder setOnLongClickListener(int viewId,
                                              View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }

}
