package com.yuy.recyclerview_adapter.my;

/**
 * Coder: yuyang
 * Date: 2019/11/18
 * Description:
 * Version:
 */
public interface RvSectionSupport<T> {

    public int sectionHeaderLayoutId();

    public int sectionTitleTextViewId();

    public String getTitle(T t);

}
