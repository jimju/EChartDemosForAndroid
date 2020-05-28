package com.jimju.echartdemo.adapter;

import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.jimju.echartdemo.R;
import com.jimju.echartdemo.bean.StartActivityItem;

import java.util.List;

public class StartActivityAdapter extends BaseQuickAdapter<StartActivityItem, BaseViewHolder> {
    public StartActivityAdapter(final List<StartActivityItem> data) {
        super(R.layout.item_start_activity, data);
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                StartActivityItem item = data.get(position);
                Intent i = new Intent(getContext(),item.clazz);
                getContext().startActivity(i);
            }
        });
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, StartActivityItem item) {
        baseViewHolder.setText(R.id.text1,item.title);
    }

}
