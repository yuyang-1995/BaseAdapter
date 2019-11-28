package com.yuy.baseadapter.common;

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
 * Date: 2019/11/16
 * Description:
 * Version:
 */
public class CommonViewHolder {

    private final SparseArray<View> mViews;
    private View convertView;
    private Context mContext;

    private CommonViewHolder(Context context, ViewGroup parent, int layoutId) {
        mViews = new SparseArray<>();
        mContext = context;
        convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        convertView.setTag(this);
    }


    public static CommonViewHolder getViewHolder(Context context, View convertView, ViewGroup parent, int layoutId) {

        if (convertView == null) {

            return new CommonViewHolder(context, parent, layoutId);
        }else {
           return (CommonViewHolder) convertView.getTag();

        }
    }



    public   <T extends View> T getView(int viewId) {

        View view = mViews.get(viewId);

        if (view == null) {
            view = convertView.findViewById(viewId);
            mViews.put(viewId, view);
        }

        return (T) view;
    }


    public View getConvertView() {
        return convertView;
    }


    //设置文本
    public CommonViewHolder setText(int viewId, String text) {

        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    //设置图片
    public CommonViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    //
    public CommonViewHolder setImageBitmap(int viewId, Bitmap bm)
    {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }





}
