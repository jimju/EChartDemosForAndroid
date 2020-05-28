package com.jimju.echartdemo.adapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.jimju.echartdemo.R;
import java.util.List;

public class BaseEChartActivityAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public BaseEChartActivityAdapter(List<String> data) {
        super(R.layout.item_start_activity, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String item) {
        baseViewHolder.setText(R.id.text1,item);
    }

}
