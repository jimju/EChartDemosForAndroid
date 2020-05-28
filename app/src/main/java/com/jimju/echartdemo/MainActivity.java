package com.jimju.echartdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.github.abel533.echarts.Radar;
import com.github.abel533.echarts.series.Gauge;
import com.github.abel533.echarts.series.Pie;
import com.jimju.echartdemo.adapter.StartActivityAdapter;
import com.jimju.echartdemo.bean.StartActivityItem;
import com.jimju.echartdemo.ui.activity.BarExampleActivity;
import com.jimju.echartdemo.ui.activity.ChordExamplesActivity;
import com.jimju.echartdemo.ui.activity.ForceExamplesActivity;
import com.jimju.echartdemo.ui.activity.FunnelExamplesActivity;
import com.jimju.echartdemo.ui.activity.GaugeExamplesActivity;
import com.jimju.echartdemo.ui.activity.HeatMapExamplesActivity;
import com.jimju.echartdemo.ui.activity.KLineExamplesActivity;
import com.jimju.echartdemo.ui.activity.LineDemosActivity;
import com.jimju.echartdemo.ui.activity.LineExamplesActivity;
import com.jimju.echartdemo.ui.activity.MapDemoActivity;
import com.jimju.echartdemo.ui.activity.MixExamplesActivity;
import com.jimju.echartdemo.ui.activity.OtherExamplesActivity;
import com.jimju.echartdemo.ui.activity.PieExamplesActivity;
import com.jimju.echartdemo.ui.activity.RadarExamplesActivity;
import com.jimju.echartdemo.ui.activity.ScatterExamplesActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
   /*     webView = findViewById(R.id.web_view);
        webView.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportZoom(false);
        webSettings.setDisplayZoomControls(false);
//        webView.addJavascriptInterface(new TEChartWebView.WebAppEChartInterface(getContext()), "Android");
        webView.loadUrl("file:///android_asset/EChart/EChart.html");
        webView.loadUrl("loadEcharts()");*/
        recyclerView = findViewById(R.id.recyclerview);
        List<StartActivityItem> items = new ArrayList<>();
        items.add(new StartActivityItem("折线图", LineExamplesActivity.class));
        items.add(new StartActivityItem("柱状图", BarExampleActivity.class));
        items.add(new StartActivityItem("散点图", ScatterExamplesActivity.class));
        items.add(new StartActivityItem("K线图", KLineExamplesActivity.class));
        items.add(new StartActivityItem("饼状图", PieExamplesActivity.class));
        items.add(new StartActivityItem("雷达图", RadarExamplesActivity.class));
        items.add(new StartActivityItem("和弦图", ChordExamplesActivity.class));
        items.add(new StartActivityItem("关系图", ForceExamplesActivity.class));
        items.add(new StartActivityItem("地图样式", MapDemoActivity.class));
        items.add(new StartActivityItem("仪表盘", GaugeExamplesActivity.class));
        items.add(new StartActivityItem("漏斗图", FunnelExamplesActivity.class));
        items.add(new StartActivityItem("热力图", HeatMapExamplesActivity.class));
        items.add(new StartActivityItem("其它", OtherExamplesActivity.class));
        items.add(new StartActivityItem("混合图", MixExamplesActivity.class));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new StartActivityAdapter(items));
    }
}
