package com.yuy.listview_adapter.base;

/**
 * Coder: yuyang
 * Date: 2019/11/18
 * Description: itemview 多类型
 * Version:
 */
public interface ItemViewDelegate<T> {

    //获取itemview 布局id
    public abstract int getItemViewLayoutId();

    //
    public abstract boolean isForViewType(T item, int position);

    //
    public abstract void convert(ViewHolder holder, T t, int position);

}
