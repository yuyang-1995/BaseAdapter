package com.yuy.recyclerview_adapter.my;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Coder: yuyang
 * Date: 2019/11/18
 * Description:
 * Version:
 */
public abstract class RViewAdapter<T> extends RecyclerView.Adapter<RViewHolder> {

    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mLayoutInflater;


    public RViewAdapter(Context context, int layoutId, List<T> datas) {
        mContext = context;
        mLayoutId = layoutId;
        mDatas = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RViewHolder rViewHolder = RViewHolder.getRvHolder(mContext, parent, mLayoutId);

        return rViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RViewHolder holder, final int position) {
        convertRv(holder, mDatas.get(position), position);
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public abstract void convertRv(RViewHolder holder, T t, int position);


}
