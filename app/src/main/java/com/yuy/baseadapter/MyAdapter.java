package com.yuy.baseadapter;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yuy.baseadapter.common.CommonAdapter;
import com.yuy.baseadapter.common.CommonViewHolder;

import java.util.List;

/**
 * Coder: yuyang
 * Date: 2019/11/16
 * Description:
 * Version:
 */
public class MyAdapter extends CommonAdapter<String> {


    public MyAdapter(List<String> datas, Context context, int itemId) {
        super(datas, context, itemId);
    }

    @Override
    protected void convert(CommonViewHolder viewHolder, String item, int position) {
        TextView textView = viewHolder.getView(R.id.id_tv_it);
        Button button = viewHolder.getView(R.id.id_btn_ma);

        textView.setText(item);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



}
