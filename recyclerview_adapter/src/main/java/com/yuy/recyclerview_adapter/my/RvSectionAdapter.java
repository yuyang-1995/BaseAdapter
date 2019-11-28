package com.yuy.recyclerview_adapter.my;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Coder: yuyang
 * Date: 2019/11/18
 * Description:
 * Version:
 */
public abstract class RvSectionAdapter<T> extends RvMultiItemAdapter<T> {

    private RvSectionSupport mSectionSupport;
    private static final int TYPE_SECTION = 0;
    private LinkedHashMap<String, Integer> mSections;

    public RvSectionAdapter(Context context, int layoutId, List<T> datas, RvMultiItemType<T> multiItemType) {
        super(context, layoutId, datas, multiItemType);
    }


    private RvMultiItemType<T> headerItemType = new RvMultiItemType<T>() {
        @Override
        public int getLayoutId(int itemType) {
            if (itemType == TYPE_SECTION)
                return mSectionSupport.sectionHeaderLayoutId();
            else
                return mLayoutId;
        }

        @Override
        public int getItemViewType(int position, T t) {
            return mSections.values().contains(position) ? TYPE_SECTION : 1;
        }
    };


    @Override
    public int getItemViewType(int position) {
        return headerItemType.getItemViewType(position, null);
    }

    RecyclerView.AdapterDataObserver mObserver = new RecyclerView.AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();

        }
    };




}
