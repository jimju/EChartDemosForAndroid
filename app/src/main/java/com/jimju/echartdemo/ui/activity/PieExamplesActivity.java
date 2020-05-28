package com.jimju.echartdemo.ui.activity;


import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.abel533.echarts.axis.AxisTick;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.SplitLine;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.K;
import com.github.abel533.echarts.series.Pie;

import java.util.ArrayList;
import java.util.List;

/**
 * 饼状图
 */
public class PieExamplesActivity extends BasicEChartDemoActivity {
    @Override
    public List<String> getRecyclerTitles() {
        return stringArray2List("标准饼状图", "标准环形图", "玫瑰饼状图", "环形进度图", "带时间条");
    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        switch (position) {
            case 0:
                String[] names = {"直接访问", "邮件营销", "联盟广告", "视频广告", "搜索引擎"};
                int[] pieDatas = {335, 310, 234, 135, 1548};
                GsonOption option = new GsonOption();
                option.legend().data("直接访问", "邮件营销", "联盟广告", "视频广告", "搜索引擎").x(X.left).orient(Orient.vertical);
                option.calculable(true);
                Pie pie = new Pie();
                ArrayList<PieData> datas = new ArrayList<>();
                for (int i = 0; i < names.length; i++) {
                    PieData pd = new PieData(names[i], pieDatas[i]);
                    datas.add(pd);
                }
                pie.data().addAll(datas);
                option.series(pie);
                Log.d("饼状图", option.toString());
                mWebView.refreshEchartsWithOption(option.toString());
                break;
            case 1:
                //标准环形图
                mWebView.setJsonFromAsset("json/pie/RingChart.json");
                break;

            case 2:
                //玫瑰饼状图
                mWebView.setJsonFromAsset("json/pie/RosePieChart.json");
                break;

            case 3:
                //环形进度图
                mWebView.setJsonFromAsset("json/pie/RingProgressChart.json");
                break;
            case 4:
                //带时间条
                mWebView.setJsonFromAsset("json/pie/PieWithTime.json");
                break;
        }
    }


}
