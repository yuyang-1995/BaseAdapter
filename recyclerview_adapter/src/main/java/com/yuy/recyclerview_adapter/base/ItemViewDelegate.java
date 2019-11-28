package com.yuy.recyclerview_adapter.base;

/**
 * Coder: yuyang
 * Date: 2019/11/18
 * Description:
 * Version:
 */
public interface ItemViewDelegate<T> {

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);

}
