package com.jimju.echartdemo.ui.activity;


import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.abel533.echarts.data.GradientColor;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Heatmap;

import java.util.ArrayList;
import java.util.List;

/**
 * 热力图
 */
public class HeatMapExamplesActivity extends BasicEChartDemoActivity {
    @Override
    public List<String> getRecyclerTitles() {
        return stringArray2List("热力图", "热力图", "热力图(配合地图)");
    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        switch (position) {
            case 0:
                GsonOption option = new GsonOption();
                Heatmap heatmap = new Heatmap();

                heatmap.valueScale(2d).gradientColors(new GradientColor(0.4, "green"), new GradientColor(0.5, "yellow"),
                        new GradientColor(0.8, "orange"), new GradientColor(1d, "red"));
                heatmap.data().addAll(heatData());
                option.series(heatmap);
                Log.d("热力图", option.toString());
                mWebView.refreshEchartsWithOption(option.toString());
                break;
            case 1:
                mWebView.setJsonFromAsset("json/heatmap/Heatmap.json");
                break;
            case 2:
                mWebView.setJsonFromAsset("json/heatmap/Heatmap1.json");
                break;
        }
    }

    private ArrayList<ArrayList<Float>> heatData() {
        ArrayList<ArrayList<Float>> flist = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ArrayList<Float> cache = new ArrayList<>();
            cache.add((float) (100 + Math.random() * 600));
            cache.add((float) (150 + Math.random() * 50));
            cache.add((float) (Math.random()));
            flist.add(cache);
        }
        return flist;
    }


}
