package com.yuy.baseadapter.common;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Coder: yuyang
 * Date: 2019/11/16
 * Description:
 * Version:
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected List<T> mDatas;
    protected Context mContext;
    protected final int itemId;



    public CommonAdapter(List<T> datas, Context context, int itemId) {
        mDatas = datas;
        mContext = context;
        this.itemId = itemId;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CommonViewHolder viewHolder = getViewHolder( convertView, parent);

        convert(viewHolder, getItem(position), position);

        return viewHolder.getConvertView();
    }

    protected abstract void convert(CommonViewHolder viewHolder, T item, int position);


    private CommonViewHolder getViewHolder(View convertView, ViewGroup parent) {

        return CommonViewHolder.getViewHolder(mContext, convertView, parent, itemId);

    }
}
