package com.jimju.echartdemo.ui.activity;



import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * 关系图
 */
public class ForceExamplesActivity extends BasicEChartDemoActivity {
    @Override
    public List<String> getRecyclerTitles() {
        return stringArray2List("标准关系图");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mRecyclerView.setVisibility(View.GONE);
        mWebView.setJsonFromAsset("json/force/TreeForceChart.json");
    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
       /* switch (position) {
            case 0:
                mWebView.setJsonFromAsset("json/force/TreeForceChart.json");
                break;
            case 1:
                mWebView.setJsonFromAsset("json/force/KLine.json");
                break;
        }*/
    }

}
