package com.yuy.hyadapterdemos.adapter.rv;

import android.content.Context;

import com.yuy.hyadapterdemos.bean.ChatMessage;
import com.yuy.recyclerview_adapter.MultiItemTypeAdapter;

import java.util.List;

/**
 * Coder: yuyang
 * Date: 2019/11/19
 * Description:
 * Version:
 */
public class ChatAdapterForRv extends MultiItemTypeAdapter<ChatMessage>
{
    public ChatAdapterForRv(Context context, List<ChatMessage> datas) {
        super(context, datas);

        addItemViewDelegate(new MsgSendItemDelagate());
        addItemViewDelegate(new MsgComingItemDelagate());
    }
}
