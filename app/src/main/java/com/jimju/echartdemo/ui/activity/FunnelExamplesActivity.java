package com.jimju.echartdemo.ui.activity;


import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.abel533.echarts.axis.AxisTick;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.SplitLine;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Sort;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Funnel;
import com.github.abel533.echarts.series.K;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 漏斗图
 */
public class FunnelExamplesActivity extends BasicEChartDemoActivity {
    @Override
    public List<String> getRecyclerTitles() {
        return stringArray2List("标准漏斗图", "多漏斗图", "多漏斗图", "多漏斗图","标准漏斗图");
    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        switch (position) {
            case 0:
                String[] arr = {"展现", "点击", "访问", "咨询", "订单"};
                GsonOption option = new GsonOption();
                option.legend().data(Arrays.asList(arr));
                option.calculable(true);
                Funnel funnel = new Funnel();
                funnel.name("漏斗图").width("40%");
                funnel.data().addAll(funnelData(arr));
                Funnel funnel1 = new Funnel();
                funnel1.name("金字塔").width("40%").x("50%").sort(Sort.ascending);
                funnel1.data().addAll(funnelData(arr));
                option.series(funnel,funnel1);
                Log.e("漏斗图", option.toString());
                mWebView.refreshEchartsWithOption(option.toString());
                break;
            case 1:
                mWebView.setJsonFromAsset("json/funnel/MultiFunnel.json");
                break;
            case 2:
                mWebView.setJsonFromAsset("json/funnel/MultiFunnel1.json");
                break;
            case 3:
                mWebView.setJsonFromAsset("json/funnel/MultiFunnel2.json");
                break;
            case 4:
                mWebView.setJsonFromAsset("json/funnel/BasicFunnel.json");
                break;
        }
    }

    private ArrayList<PieData> funnelData(String[] arr) {
        ArrayList<PieData> list = new ArrayList<>();
        for (String s : arr) {
            list.add(new PieData(s, new Random().nextInt(60) + 30));
        }
        return list;
    }


}
