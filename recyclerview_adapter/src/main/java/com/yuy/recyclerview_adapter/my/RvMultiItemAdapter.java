package com.yuy.recyclerview_adapter.my;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

/**
 * Coder: yuyang
 * Date: 2019/11/18
 * Description:
 * Version:
 */
public abstract class RvMultiItemAdapter<T> extends RViewAdapter<T> {

    private RvMultiItemType<T> mTMultiItemType;

    public RvMultiItemAdapter(Context context, int layoutId, List<T> datas, RvMultiItemType<T> multiItemType) {
        super(context, -1, datas);
        mTMultiItemType = multiItemType;
    }


    @Override
    public int getItemViewType(int position) {
        return mTMultiItemType.getItemViewType(position, mDatas.get(position));
    }


    @NonNull
    @Override
    public RViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        int layoutId = mTMultiItemType.getLayoutId(viewType);

        RViewHolder rViewHolder = RViewHolder.getRvHolder(mContext, parent, layoutId);

        return rViewHolder;
    }

}
