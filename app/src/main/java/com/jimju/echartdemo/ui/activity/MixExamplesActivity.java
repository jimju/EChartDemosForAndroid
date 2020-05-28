package com.jimju.echartdemo.ui.activity;

import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * 组合图
 */
public class MixExamplesActivity extends BasicEChartDemoActivity {
    @Override
    public List<String> getRecyclerTitles() {
        return stringArray2List("线柱组合", "线柱组合", "组合图","线点组合","折线K");
    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        switch (position) {
            case 0:
                mWebView.setJsonFromAsset("json/mix/LineAndBar.json");
                break;
            case 1:
                mWebView.setJsonFromAsset("json/mix/LineAndBar1.json");
                break;
            case 2:
                mWebView.setJsonFromAsset("json/mix/LineBarPie.json");
                break;
            case 3:
                mWebView.setJsonFromAsset("json/mix/LineAndScatter.json");
                break;

            case 4:
                mWebView.setJsonFromAsset("json/mix/KAndLine.json");
                break;
        }
    }


}
