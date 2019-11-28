package com.yuy.recyclerview_adapter.my;

/**
 * Coder: yuyang
 * Date: 2019/11/18
 * Description:
 * Version:
 */
public interface RvMultiItemType<T> {

    /**
     * 根据itemView 返回layoutId
     * @param itemType
     * @return
     */
    int getLayoutId(int itemType);

    /**
     * 返回
     * @param position
     * @param t
     * @return
     */
    int getItemViewType(int position, T t);

}
