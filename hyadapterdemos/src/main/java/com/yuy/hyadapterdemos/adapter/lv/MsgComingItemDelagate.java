package com.yuy.hyadapterdemos.adapter.lv;

import com.yuy.hyadapterdemos.R;
import com.yuy.hyadapterdemos.bean.ChatMessage;
import com.yuy.listview_adapter.base.ItemViewDelegate;
import com.yuy.listview_adapter.base.ItemViewDelegateManager;
import com.yuy.listview_adapter.base.ViewHolder;

/**
 * Coder: yuyang
 * Date: 2019/11/18
 * Description: 接受item
 * Version:
 */
public class MsgComingItemDelagate implements ItemViewDelegate<ChatMessage> {


    @Override
    public int getItemViewLayoutId() {
        return R.layout.main_chat_from_msg;
    }

    @Override
    public boolean isForViewType(ChatMessage item, int position) {
        return item.isComMeg();
    }

    @Override
    public void convert(ViewHolder holder, ChatMessage chatMessage, int position) {

        holder.setText(R.id.chat_from_content, chatMessage.getContent());
        holder.setText(R.id.chat_from_name, chatMessage.getName());
        holder.setImageResource(R.id.chat_from_icon, chatMessage.getIcon());

    }
}
