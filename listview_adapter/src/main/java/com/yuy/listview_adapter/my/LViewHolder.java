package com.yuy.listview_adapter.my;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Coder: yuyang
 * Date: 2019/11/15
 * Description:
 * Version:
 */
public class LViewHolder {

    //使用SparseArray<View> 用于存储与之对应的convertView的所有的控件，当需要拿这些控件时，通过getView(id)进行获取；
    private final SparseArray<View> mViews;

    private View mConvertView;

    private LViewHolder(Context context, ViewGroup parent, int layoutId) {
        mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    /**
     * 获取一个ViewHolder 对象
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param
     * @return
     */
    public static LViewHolder getViewHolder(Context context, View convertView, ViewGroup parent
            , int layoutId){

        if (convertView == null) {
            //convertView 为空
            return new LViewHolder(context, parent, layoutId);
        }

        return (LViewHolder) convertView.getTag();
    }


    /**
     * 通过控件的id 获取对应的控件，
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        //
        View view = mViews.get(viewId);

        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }

        return (T) view;
    }

    /**
     * 获取convertview
     * @return
     */
    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 设置TextView 文本
     * @param viewId
     * @param text
     * @return
     */
    public LViewHolder setText(int viewId, String text) {
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    /**
     * 设置ImageView 图片
     * @param viewId
     * @param drawableId
     * @return
     */
    public LViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    /**
     * 设置ImageView 图片
     * @param viewId
     * @param bm
     * @return
     */
    public LViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 控件的事件
     */
    public LViewHolder setOnClickListener(int viewId, View.OnClickListener onClickListener) {
        View view = getView(viewId);
        view.setOnClickListener(onClickListener);
        return this;
    }

    public LViewHolder setOnTouchListener(int viewId,
                                          View.OnTouchListener listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    public LViewHolder setOnLongClickListener(int viewId,
                                              View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }



}
