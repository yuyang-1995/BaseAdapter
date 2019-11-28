package com.yuy.baseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.yuy.listview_adapter.my.LViewAdapter;
import com.yuy.listview_adapter.my.LViewHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mStrings;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();

        //itemView 长按事件
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "长按了第" + (position+1) + "个 ItemView",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                startActivity(intent);

                return true;
            }
        });


        mListView.setAdapter(new LViewAdapter<String>( getApplicationContext(),mStrings, R.layout.item_lv) {
            @Override
            protected void convertLv(LViewHolder viewholder, String item, final int position) {

               viewholder.setOnClickListener(R.id.id_btn_ma, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "点击了第" + (position+1) + "个 Button", Toast.LENGTH_SHORT).show();
                    }
                });

                viewholder.setOnLongClickListener(R.id.id_btn_ma, new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Toast.makeText(MainActivity.this, "长按了第" +  (position+1) + "个 Button", Toast.LENGTH_SHORT).show();
                        return true;
                    }

                });

                viewholder.setText(R.id.id_tv_it, item);
            }
        });

        //itemView 点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "点击了第" + position + "个 ItemView",Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void initDatas() {

        mStrings = new ArrayList<>();

        for (int i = 1; i < 19; i++) {

            mStrings.add("第" + i + "条数据");

        }

        mListView = findViewById(R.id.id_lv_ma);
    }



}
