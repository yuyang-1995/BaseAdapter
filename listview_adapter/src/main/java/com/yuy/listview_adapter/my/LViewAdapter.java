package com.yuy.listview_adapter.my;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Coder: yuyang
 * Date: 2019/11/15
 * Description:
 * Version:
 */
public abstract class LViewAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected LayoutInflater mLayoutInflater;
    protected List<T> mDatas;
    protected final int mItemLayoutId;


    public LViewAdapter(Context context, List<T> datas, int itemLayoutId) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
        mDatas = datas;
        this.mItemLayoutId = itemLayoutId;
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
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final LViewHolder usefulViewHolder = getViewHolder(convertView, parent);

        convertLv(usefulViewHolder, getItem(position), position);

        return usefulViewHolder.getConvertView();
    }

    protected abstract void convertLv(LViewHolder viewholder, T item, int position);


    private LViewHolder getViewHolder(View converView, ViewGroup parent) {

        return LViewHolder.getViewHolder(mContext, converView, parent, mItemLayoutId);

    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
