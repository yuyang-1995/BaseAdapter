package com.yuy.hyadapterdemos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.yuy.hyadapterdemos.adapter.lv.ChatAdapter;
import com.yuy.hyadapterdemos.bean.ChatMessage;

public class MultiItemListViewActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.id_listview_list);
        mListView.setDivider(null);
        mListView.setAdapter(new ChatAdapter(this, ChatMessage.MOCK_DATAS));

    }
}
