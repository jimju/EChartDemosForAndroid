package com.jimju.echartdemo.ui.activity;
import androidx.annotation.NonNull;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.abel533.echarts.DataRange;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.data.MapData;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Map;
import com.jimju.echartdemo.widget.EChartWebView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Random;

public class MapDemoActivity extends BasicEChartDemoActivity {
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0){
                String option = msg.obj.toString();
                Log.e("TAGO",option);
                mWebView.refreshEchartsWithOption(option);
            }
        }
    };
    @Override
    public List<String> getRecyclerTitles() {
        return stringArray2List("标准地图","标准地图","标准地图(世界)","多地图");
    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        switch (position){
            case 0:
                basicMap();
                break;
            case 1:
                final GsonOption option = mWebView.getAssetOption("json/map/BasicMap.json");
                mWebView.setJsonFromOption(option);
                mWebView.addEchartActionHandler(new EChartWebView.PYEchartAction[]{EChartWebView.PYEchartAction.PYEchartActionClick},
                        new EChartWebView.OnAddEchartActionHandlerResponseResultListener() {
                            @Override
                            public void actionHandlerResponseResult(String result) {
                                try {
                                    JSONObject jsonObject = new JSONObject(result);
                                    String name = jsonObject.getString("name");
                                    ((Map)option.series().get(0)).mapType(name);
                                    Message msg = new Message();
                                    msg.what = 0;
                                    msg.obj = option.toString();
                                    mHandler.sendMessage(msg);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Log.e("TAG",e.toString());
                                }

                            }
                        });
                break;
            case 2:
                mWebView.setJsonFromAsset("json/map/WorldMap.json");
                break;
            case 3:
                final GsonOption option1 = mWebView.getAssetOption("json/map/MultiMap.json");
                mWebView.setJsonFromOption(option1);
                mWebView.addEchartActionHandler(new EChartWebView.PYEchartAction[]{EChartWebView.PYEchartAction.PYEchartActionClick},
                        new EChartWebView.OnAddEchartActionHandlerResponseResultListener() {
                            @Override
                            public void actionHandlerResponseResult(String result) {
                                try {
                                    JSONObject jsonObject = new JSONObject(result);
                                    String name = jsonObject.getString("name");
                                    ((Map)option1.series().get(1)).mapType(name);
                                    Message msg = new Message();
                                    msg.what = 0;
                                    msg.obj = option1.toString();
                                    mHandler.sendMessage(msg);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Log.e("TAG",e.toString());
                                }

                            }
                        });
                break;
        }
    }

    /**
     * 标准地图
     */
    private void basicMap(){
        GsonOption option = new GsonOption();
        option.dataRange(new DataRange().min(0).max(2500).calculable(true).x(X.left).y(Y.bottom)
        .text("高","低"));
        option.legend().orient(Orient.vertical).x(X.left).data("iphone3","iphone4", "iphone5");
        option.roamController().mapTypeControl("china",true).show(true).x(X.right);
        option.series(randomMap("iphone3"),randomMap("iphone4"),randomMap("iphone5"));
        mWebView.setJsonFromOption(option);
    }

    /**
     * 随机的mapseries
     */
    private Map randomMap(String name){
        String[] province = {"北京","上海","重庆","河北","河南","云南","辽宁","黑龙江","湖南","山东",
                "安徽","新疆","黑龙江","江苏","浙江","江西","湖北","广西","甘肃","陕西","内蒙古","河北",
                "吉林","福建","广东","青海","贵州","西藏","四川","宁夏","湖南","台湾","香港","澳门"};
        Map map = new Map();
        for (int i = 0; i < province.length; i++) {
            map.data().add(new MapData(province[i],new Random().nextInt(900) + 100));
        }
        map.name(name).mapType("china").roam(false);
        return map;
    }
}
