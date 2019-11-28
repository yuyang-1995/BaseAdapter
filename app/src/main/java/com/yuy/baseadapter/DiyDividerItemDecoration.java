package com.yuy.baseadapter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Coder: yuyang
 * Date: 2019/11/18
 * Description:
 * Version:
 */
public class DiyDividerItemDecoration extends RecyclerView.ItemDecoration {


    private Paint mPaint;

    //
    public DiyDividerItemDecoration() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);

    }

    //ItemDecoration类中仅有3个方法，具体如下：

    // 作用：设置ItemView的内嵌偏移长度（inset）
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int itemPosotion = parent.getChildAdapterPosition(view);
        //获得每一个Item 的位置

        //第一个Item 不绘制分割线
        if (itemPosotion != 0) {
            outRect.set(0, 0, 0, 10); // 设置间隔区域为10px,即onDraw()可绘制的区域为10px
        }
    }


    // 作用：在子视图上设置绘制范围，并绘制内容
    // 类似平时自定义View时写onDraw()一样
    // 绘制图层在ItemView以下，所以如果绘制区域与ItemView区域相重叠，会被遮挡
    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {

            //获取每一个Item 的位置
            View child = parent.getChildAt(i);

            int index = parent.getChildAdapterPosition(child);//

            //第一个Item 不绘制
            if (index == 0) {
                continue;
            }

            //获取布局参数
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            //设置矩形分割线的宽度为10px
            int mDivider = 10;

            //根据子视图的位置 & 间隔区域， 设置矩形的两个顶点坐标
            int left = parent.getPaddingLeft();
            int top = child.getBottom() + params.bottomMargin
                    + Math.round(ViewCompat.getTranslationY(child));

            int right = parent.getWidth() - parent.getPaddingRight();

            //绘制分割线的下边界
            int bottom = top + mDivider;

            c.drawRect(left, top, right, bottom, mPaint);

        }
    }


    // 作用：同样是绘制内容，但与onDraw（）的区别是：绘制在图层的最上层
    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

}
