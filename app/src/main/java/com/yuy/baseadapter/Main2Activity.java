package com.yuy.baseadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yuy.recyclerview_adapter.my.RViewAdapter;
import com.yuy.recyclerview_adapter.my.RViewHolder;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mStrings;
    private RVAdapter mRVAdapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initDatas();

        mRVAdapter = new RVAdapter(this, R.layout.item_rv, mStrings);

//        mRVAdapter.setOnClickListener(new RViewAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(Main2Activity.this, "点击了第" + (position + 1) + "个 ItemView", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        mRVAdapter.setOnItemLongClickListener(new RViewAdapter.OnItemLongClickListener() {
//            @Override
//            public void onItemLongClick(View view, int position) {
//                Toast.makeText(Main2Activity.this, "长按了第" + (position + 1) + "个 ItemView", Toast.LENGTH_SHORT).show();
//
//            }
//        });

        mRecyclerView.setAdapter(mRVAdapter);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.addItemDecoration(new DiyDividerItemDecoration());

    }

    private void initDatas() {

        mStrings = new ArrayList<>();

        for (int i = 1; i < 20; i++) {

            mStrings.add("第" + i + "条数据");
        }

        mRecyclerView = findViewById(R.id.id_rv_m2);

    }

    class RVAdapter<String> extends RViewAdapter {


        public RVAdapter(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }


        @Override
        public void convertRv(RViewHolder holder, Object o, final int position) {

            holder.setText(R.id.id_tv_it2, (java.lang.String) o);


            /**
             * 控件设置点击事件
             */
            holder.setOnClickListener(R.id.id_btn_ma2, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "点击了第" + position + "各Button", Toast.LENGTH_SHORT).show();

                }
            });

            holder.setOnLongClickListener(R.id.id_btn_ma2, new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(mContext, "长安了第" + position + "个Button", Toast.LENGTH_SHORT).show();

                    return true;
                }
            });


            /**
             * itemView 设置点击事件
             */
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "点击了第" + (position+1) + "个itemView", Toast.LENGTH_SHORT).show();

                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(mContext, "长按了第" + (position + 1) + "个ItemView", Toast.LENGTH_SHORT).show();
                    return true;
                }
            });


        }
    }

}
