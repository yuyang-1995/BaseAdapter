package com.yuy.hyadapterdemos.adapter.lv;

import android.content.Context;

import com.yuy.hyadapterdemos.bean.ChatMessage;
import com.yuy.listview_adapter.base.MultiItemTypeAdapter;

import java.util.List;

/**
 * Coder: yuyang
 * Date: 2019/11/18
 * Description:
 * Version:
 */
public class ChatAdapter extends MultiItemTypeAdapter<ChatMessage> {
    public ChatAdapter(Context context, List<ChatMessage> datas) {
        super(context, datas);

        addItemViewDelegate(new MsgSendItemDelagate());
        addItemViewDelegate(new MsgComingItemDelagate());

    }
}
