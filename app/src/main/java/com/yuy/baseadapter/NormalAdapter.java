package com.yuy.baseadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.yuy.baseadapter.common.CommonViewHolder;

import java.util.ArrayList;

/**
 * Coder: yuyang
 * Date: 2019/11/15
 * Description:
 * Version:
 */
public class NormalAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> mStrings;


    public NormalAdapter(Context context, ArrayList<String> strings) {
        mContext = context;
        mStrings = strings;

    }


    @Override
    public int getCount() {
        return mStrings.size();
    }

    @Override
    public Object getItem(int position) {
        return mStrings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        CommonViewHolder viewHolder = CommonViewHolder.getViewHolder(mContext, convertView, parent, R.layout.item_lv);

        TextView textView = viewHolder.getView(R.id.id_tv_it);
        Button button = viewHolder.getView(R.id.id_btn_ma);

        textView.setText(mStrings.get(position));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return viewHolder.getConvertView();



//        LViewHolder viewHolder = null;
//
//        if (convertView == null) {
//            viewHolder = new LViewHolder();
//            convertView = mLayoutInflater.inflate(R.layout.item_lv, parent, false);
//            viewHolder.mTextView = convertView.findViewById(R.id.id_tv_it);
//            viewHolder.mButton = convertView.findViewById(R.id.id_btn_ma);
//
//            convertView.setTag(viewHolder);
//
//        }else {
//
//            viewHolder = (LViewHolder) convertView.getTag();
//        }
//
//        viewHolder.mTextView.setText(mStrings.get(position));
//
//        viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "点击了第" + position + "个TextView",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        viewHolder.mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(mContext, Main2Activity.class);
//                mContext.startActivity(intent);
//
//                Toast.makeText(mContext, "点击了第" + position + "个Button",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        return convertView;
    }

//    private class LViewHolder{
//
//        TextView mTextView;
//        Button mButton;
//    }



}
