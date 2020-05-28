package com.jimju.echartdemo.ui.activity;


import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.abel533.echarts.axis.AxisTick;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.SplitLine;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.K;

import java.util.ArrayList;
import java.util.List;

/**
 * K线图
 */
public class ChordExamplesActivity extends BasicEChartDemoActivity {
    @Override
    public List<String> getRecyclerTitles() {
        return stringArray2List("标准和弦图", "多系列和弦图", "标准和弦图","非缎带和弦图","和弦图");
    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        switch (position) {
            case 0:
                //标准和弦图
                mWebView.setJsonFromAsset("json/chord/BasicChordChart.json");
                break;

            case 1:
//                多系列和弦图
                mWebView.setJsonFromAsset("json/chord/MultiChordChart.json");
                break;
            case 2:
                //标准和弦图
                mWebView.setJsonFromAsset("json/chord/BasicChordChart1.json");
                break;
            case 3:
                //非缎带和弦图
                mWebView.setJsonFromAsset("json/chord/NonRibbonChord.json");
                break;
            case 4:
                //和弦图
                mWebView.setJsonFromAsset("json/chord/ChordChart.json");
                break;

        }
    }


}
