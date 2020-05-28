package com.jimju.echartdemo.ui.activity;


import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.abel533.echarts.axis.AxisTick;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.SplitLine;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Gauge;
import com.github.abel533.echarts.series.K;
import com.github.abel533.echarts.series.gauge.Detail;

import java.util.ArrayList;
import java.util.List;

/**
 * 仪表盘
 */
public class GaugeExamplesActivity extends BasicEChartDemoActivity {
    @Override
    public List<String> getRecyclerTitles() {
        return stringArray2List("标准仪表图", "标准仪表图", "标准仪表图", "多仪表图", "多仪表图", "仪表图");
    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        switch (position) {
            case 0:
                GsonOption option = new GsonOption();
                Gauge gauge = new Gauge();
                PieData gauData = new PieData("完成率", 50);
                gauge.data(gauData).name("业务指标").detail(new Detail().formatter("{value}%"));
                option.series(gauge);
                Log.d("仪表盘", option.toString());
                mWebView.refreshEchartsWithOption(option.toString());
                break;
            case 1:
                mWebView.setJsonFromAsset("json/gauge/BasicGauge.json");
                break;
            case 2:
                mWebView.setJsonFromAsset("json/gauge/BasicGauge1.json");
                break;
            case 3:
                mWebView.setJsonFromAsset("json/gauge/MultiGauge.json");
                break;
            case 4:
                mWebView.setJsonFromAsset("json/gauge/MultiGauge1.json");
                break;
            case 5:
                mWebView.setJsonFromAsset("json/gauge/Gauge.json");
                break;
        }
    }


}
