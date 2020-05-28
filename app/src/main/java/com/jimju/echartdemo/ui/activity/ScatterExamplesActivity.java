package com.jimju.echartdemo.ui.activity;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.abel533.echarts.AxisPointer;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.PointerType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.LineData;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.MarkLine;
import com.github.abel533.echarts.series.MarkPoint;
import com.github.abel533.echarts.series.Scatter;
import com.github.abel533.echarts.style.LineStyle;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScatterExamplesActivity extends BasicEChartDemoActivity {
    @Override
    public List<String> getRecyclerTitles() {
        return stringArray2List("标准散点图", "标准气泡图", "大规模散点", "类目坐标散点", "搭配值域散点图", "散点图");
    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        switch (position) {
            case 0:
                basicScatter();
                break;
            case 1:
                basicBubble();
                break;
            case 2:
                mutilScatter();
                break;
            case 3:
                classifyScatter();
                break;
            case 4:
                collocationScatter();
                break;
            case 5:
                theScatter();
                break;
        }
    }


    /**
     * 标准散点图
     */
    private void basicScatter() {
        GsonOption option = new GsonOption();
        option.tooltip().trigger(Trigger.axis).axisPointer(new AxisPointer().type(PointerType.cross).lineStyle(
                new LineStyle().type(LineType.dashed).width(1f)));
        option.legend("女性", "男性");
        option.xAxis(new ValueAxis().scale(true));
        option.yAxis(new ValueAxis().scale(true));
        Scatter ser1 = new Scatter().name("女性");
        float[][] farr1 = {{161.2f, 51.6f}, {167.5f, 59.0f}, {159.5f, 49.2f}, {157.0f, 63.0f}, {155.8f, 53.6f}, {
                170.0f, 59.0f}, {159.1f, 47.6f}, {166.0f, 69.8f}, {176.2f, 66.8f}, {160.2f, 75.2f}, {
                172.5f, 55.2f}, {170.9f, 54.2f}, {172.9f, 62.5f}, {153.4f, 42.0f}, {160.0f, 50.0f}, {
                147.2f, 49.8f}, {168.2f, 49.2f}, {175.0f, 73.2f}, {157.0f, 47.8f}, {167.6f, 68.8f}, {
                159.5f, 50.6f}, {175.0f, 82.5f}, {166.8f, 57.2f}, {176.5f, 87.8f}, {170.2f, 72.8f}, {
                174.0f, 54.5f}, {173.0f, 59.8f}, {179.9f, 67.3f}, {170.5f, 67.8f}, {160.0f, 47.0f}, {
                154.4f, 46.2f}, {162.0f, 55.0f}, {176.5f, 83.0f}, {160.0f, 54.4f}, {152.0f, 45.8f}, {
                162.1f, 53.6f}, {170.0f, 73.2f}, {160.2f, 52.1f}, {161.3f, 67.9f}, {166.4f, 56.6f}, {
                168.9f, 62.3f}, {163.8f, 58.5f}, {167.6f, 54.5f}, {160.0f, 50.2f}, {161.3f, 60.3f}, {
                167.6f, 58.3f}, {165.1f, 56.2f}, {160.0f, 50.2f}, {170.0f, 72.9f}, {157.5f, 59.8f}, {
                167.6f, 61.0f}, {160.7f, 69.1f}, {163.2f, 55.9f}, {152.4f, 46.5f}, {157.5f, 54.3f}, {
                168.3f, 54.8f}, {180.3f, 60.7f}, {165.5f, 60.0f}, {165.0f, 62.0f}, {164.5f, 60.3f}, {
                156.0f, 52.7f}, {160.0f, 74.3f}, {163.0f, 62.0f}, {165.7f, 73.1f}, {161.0f, 80.0f}, {
                162.0f, 54.7f}, {166.0f, 53.2f}, {174.0f, 75.7f}, {172.7f, 61.1f}, {167.6f, 55.7f}, {
                151.1f, 48.7f}, {164.5f, 52.3f}, {163.5f, 50.0f}, {152.0f, 59.3f}, {169.0f, 62.5f}, {
                164.0f, 55.7f}, {161.2f, 54.8f}, {155.0f, 45.9f}, {170.0f, 70.6f}, {176.2f, 67.2f}, {
                170.0f, 69.4f}, {162.5f, 58.2f}, {170.3f, 64.8f}, {164.1f, 71.6f}, {169.5f, 52.8f}, {
                163.2f, 59.8f}, {154.5f, 49.0f}, {159.8f, 50.0f}, {173.2f, 69.2f}, {170.0f, 55.9f}, {
                161.4f, 63.4f}, {169.0f, 58.2f}, {166.2f, 58.6f}, {159.4f, 45.7f}, {162.5f, 52.2f}, {
                159.0f, 48.6f}, {162.8f, 57.8f}, {159.0f, 55.6f}, {179.8f, 66.8f}, {162.9f, 59.4f}, {
                161.0f, 53.6f}, {151.1f, 73.2f}, {168.2f, 53.4f}, {168.9f, 69.0f}, {173.2f, 58.4f}, {
                171.8f, 56.2f}, {178.0f, 70.6f}, {164.3f, 59.8f}, {163.0f, 72.0f}, {168.5f, 65.2f}, {
                166.8f, 56.6f}, {172.7f, 105.2f}, {163.5f, 51.8f}, {169.4f, 63.4f}, {167.8f, 59.0f}, {
                159.5f, 47.6f}, {167.6f, 63.0f}, {161.2f, 55.2f}, {160.0f, 45.0f}, {163.2f, 54.0f}, {
                162.2f, 50.2f}, {161.3f, 60.2f}, {149.5f, 44.8f}, {157.5f, 58.8f}, {163.2f, 56.4f}, {
                172.7f, 62.0f}, {155.0f, 49.2f}, {156.5f, 67.2f}, {164.0f, 53.8f}, {160.9f, 54.4f}, {
                162.8f, 58.0f}, {167.0f, 59.8f}, {160.0f, 54.8f}, {160.0f, 43.2f}, {168.9f, 60.5f}, {
                158.2f, 46.4f}, {156.0f, 64.4f}, {160.0f, 48.8f}, {167.1f, 62.2f}, {158.0f, 55.5f}, {
                167.6f, 57.8f}, {156.0f, 54.6f}, {162.1f, 59.2f}, {173.4f, 52.7f}, {159.8f, 53.2f}, {
                170.5f, 64.5f}, {159.2f, 51.8f}, {157.5f, 56.0f}, {161.3f, 63.6f}, {162.6f, 63.2f}, {
                160.0f, 59.5f}, {168.9f, 56.8f}, {165.1f, 64.1f}, {162.6f, 50.0f}, {165.1f, 72.3f}, {
                166.4f, 55.0f}, {160.0f, 55.9f}, {152.4f, 60.4f}, {170.2f, 69.1f}, {162.6f, 84.5f}, {
                170.2f, 55.9f}, {158.8f, 55.5f}, {172.7f, 69.5f}, {167.6f, 76.4f}, {162.6f, 61.4f}, {
                167.6f, 65.9f}, {156.2f, 58.6f}, {175.2f, 66.8f}, {172.1f, 56.6f}, {162.6f, 58.6f}, {
                160.0f, 55.9f}, {165.1f, 59.1f}, {182.9f, 81.8f}, {166.4f, 70.7f}, {165.1f, 56.8f}, {
                177.8f, 60.0f}, {165.1f, 58.2f}, {175.3f, 72.7f}, {154.9f, 54.1f}, {158.8f, 49.1f}, {
                172.7f, 75.9f}, {168.9f, 55.0f}, {161.3f, 57.3f}, {167.6f, 55.0f}, {165.1f, 65.5f}, {
                175.3f, 65.5f}, {157.5f, 48.6f}, {163.8f, 58.6f}, {167.6f, 63.6f}, {165.1f, 55.2f}, {
                165.1f, 62.7f}, {168.9f, 56.6f}, {162.6f, 53.9f}, {164.5f, 63.2f}, {176.5f, 73.6f}, {
                168.9f, 62.0f}, {175.3f, 63.6f}, {159.4f, 53.2f}, {160.0f, 53.4f}, {170.2f, 55.0f}, {
                162.6f, 70.5f}, {167.6f, 54.5f}, {162.6f, 54.5f}, {160.7f, 55.9f}, {160.0f, 59.0f}, {
                157.5f, 63.6f}, {162.6f, 54.5f}, {152.4f, 47.3f}, {170.2f, 67.7f}, {165.1f, 80.9f}, {
                172.7f, 70.5f}, {165.1f, 60.9f}, {170.2f, 63.6f}, {170.2f, 54.5f}, {170.2f, 59.1f}, {
                161.3f, 70.5f}, {167.6f, 52.7f}, {167.6f, 62.7f}, {165.1f, 86.3f}, {162.6f, 66.4f}, {
                152.4f, 67.3f}, {168.9f, 63.0f}, {170.2f, 73.6f}, {175.2f, 62.3f}, {175.2f, 57.7f}, {
                160.0f, 55.4f}, {165.1f, 104.1f}, {174.0f, 55.5f}, {170.2f, 77.3f}, {160.0f, 80.5f}, {
                167.6f, 64.5f}, {167.6f, 72.3f}, {167.6f, 61.4f}, {154.9f, 58.2f}, {162.6f, 81.8f}, {
                175.3f, 63.6f}, {171.4f, 53.4f}, {157.5f, 54.5f}, {165.1f, 53.6f}, {160.0f, 60.0f}, {
                174.0f, 73.6f}, {162.6f, 61.4f}, {174.0f, 55.5f}, {162.6f, 63.6f}, {161.3f, 60.9f}, {
                156.2f, 60.0f}, {149.9f, 46.8f}, {169.5f, 57.3f}, {160.0f, 64.1f}, {175.3f, 63.6f}, {
                169.5f, 67.3f}, {160.0f, 75.5f}, {172.7f, 68.2f}, {162.6f, 61.4f}, {157.5f, 76.8f}, {
                176.5f, 71.8f}, {164.4f, 55.5f}, {160.7f, 48.6f}, {174.0f, 66.4f}, {163.8f, 67.3f}};
        seriesAddData(ser1, farr1);
        ser1.markPoint(new MarkPoint().data(new PointData().type(MarkType.max).name("最大值"), new PointData().type(MarkType.min).name("最小值")));
        ser1.markLine(new MarkLine().data(new LineData().type(MarkType.average).name("最小值")));

        Scatter ser2 = new Scatter().name("男性");
        float[][] farr2 = {{174.0f, 65.6f}, {175.3f, 71.8f}, {193.5f, 80.7f}, {186.5f, 72.6f}, {187.2f, 78.8f}, {
                181.5f, 74.8f}, {184.0f, 86.4f}, {184.5f, 78.4f}, {175.0f, 62.0f}, {184.0f, 81.6f}, {
                180.0f, 76.6f}, {177.8f, 83.6f}, {192.0f, 90.0f}, {176.0f, 74.6f}, {174.0f, 71.0f}, {
                184.0f, 79.6f}, {192.7f, 93.8f}, {171.5f, 70.0f}, {173.0f, 72.4f}, {176.0f, 85.9f}, {
                176.0f, 78.8f}, {180.5f, 77.8f}, {172.7f, 66.2f}, {176.0f, 86.4f}, {173.5f, 81.8f}, {
                178.0f, 89.6f}, {180.3f, 82.8f}, {180.3f, 76.4f}, {164.5f, 63.2f}, {173.0f, 60.9f}, {
                183.5f, 74.8f}, {175.5f, 70.0f}, {188.0f, 72.4f}, {189.2f, 84.1f}, {172.8f, 69.1f}, {
                170.0f, 59.5f}, {182.0f, 67.2f}, {170.0f, 61.3f}, {177.8f, 68.6f}, {184.2f, 80.1f}, {
                186.7f, 87.8f}, {171.4f, 84.7f}, {172.7f, 73.4f}, {175.3f, 72.1f}, {180.3f, 82.6f}, {
                182.9f, 88.7f}, {188.0f, 84.1f}, {177.2f, 94.1f}, {172.1f, 74.9f}, {167.0f, 59.1f}, {
                169.5f, 75.6f}, {174.0f, 86.2f}, {172.7f, 75.3f}, {182.2f, 87.1f}, {164.1f, 55.2f}, {
                163.0f, 57.0f}, {171.5f, 61.4f}, {184.2f, 76.8f}, {174.0f, 86.8f}, {174.0f, 72.2f}, {
                177.0f, 71.6f}, {186.0f, 84.8f}, {167.0f, 68.2f}, {171.8f, 66.1f}, {182.0f, 72.0f}, {
                167.0f, 64.6f}, {177.8f, 74.8f}, {164.5f, 70.0f}, {192.0f, 101.6f}, {175.5f, 63.2f}, {
                171.2f, 79.1f}, {181.6f, 78.9f}, {167.4f, 67.7f}, {181.1f, 66.0f}, {177.0f, 68.2f}, {
                174.5f, 63.9f}, {177.5f, 72.0f}, {170.5f, 56.8f}, {182.4f, 74.5f}, {197.1f, 90.9f}, {
                180.1f, 93.0f}, {175.5f, 80.9f}, {180.6f, 72.7f}, {184.4f, 68.0f}, {175.5f, 70.9f}, {
                180.6f, 72.5f}, {177.0f, 72.5f}, {177.1f, 83.4f}, {181.6f, 75.5f}, {176.5f, 73.0f}, {
                175.0f, 70.2f}, {174.0f, 73.4f}, {165.1f, 70.5f}, {177.0f, 68.9f}, {192.0f, 102.3f}, {
                176.5f, 68.4f}, {169.4f, 65.9f}, {182.1f, 75.7f}, {179.8f, 84.5f}, {175.3f, 87.7f}, {
                184.9f, 86.4f}, {177.3f, 73.2f}, {167.4f, 53.9f}, {178.1f, 72.0f}, {168.9f, 55.5f}, {
                157.2f, 58.4f}, {180.3f, 83.2f}, {170.2f, 72.7f}, {177.8f, 64.1f}, {172.7f, 72.3f}, {
                165.1f, 65.0f}, {186.7f, 86.4f}, {165.1f, 65.0f}, {174.0f, 88.6f}, {175.3f, 84.1f}, {
                185.4f, 66.8f}, {177.8f, 75.5f}, {180.3f, 93.2f}, {180.3f, 82.7f}, {177.8f, 58.0f}, {
                177.8f, 79.5f}, {177.8f, 78.6f}, {177.8f, 71.8f}, {177.8f, 116.4f}, {163.8f, 72.2f}, {
                188.0f, 83.6f}, {198.1f, 85.5f}, {175.3f, 90.9f}, {166.4f, 85.9f}, {190.5f, 89.1f}, {
                166.4f, 75.0f}, {177.8f, 77.7f}, {179.7f, 86.4f}, {172.7f, 90.9f}, {190.5f, 73.6f}, {
                185.4f, 76.4f}, {168.9f, 69.1f}, {167.6f, 84.5f}, {175.3f, 64.5f}, {170.2f, 69.1f}, {
                190.5f, 108.6f}, {177.8f, 86.4f}, {190.5f, 80.9f}, {177.8f, 87.7f}, {184.2f, 94.5f}, {
                176.5f, 80.2f}, {177.8f, 72.0f}, {180.3f, 71.4f}, {171.4f, 72.7f}, {172.7f, 84.1f}, {
                172.7f, 76.8f}, {177.8f, 63.6f}, {177.8f, 80.9f}, {182.9f, 80.9f}, {170.2f, 85.5f}, {
                167.6f, 68.6f}, {175.3f, 67.7f}, {165.1f, 66.4f}, {185.4f, 102.3f}, {181.6f, 70.5f}, {
                172.7f, 95.9f}, {190.5f, 84.1f}, {179.1f, 87.3f}, {175.3f, 71.8f}, {170.2f, 65.9f}, {
                193.0f, 95.9f}, {171.4f, 91.4f}, {177.8f, 81.8f}, {177.8f, 96.8f}, {167.6f, 69.1f}, {
                167.6f, 82.7f}, {180.3f, 75.5f}, {182.9f, 79.5f}, {176.5f, 73.6f}, {186.7f, 91.8f}, {
                188.0f, 84.1f}, {188.0f, 85.9f}, {177.8f, 81.8f}, {174.0f, 82.5f}, {177.8f, 80.5f}, {
                171.4f, 70.0f}, {185.4f, 81.8f}, {185.4f, 84.1f}, {188.0f, 90.5f}, {188.0f, 91.4f}, {
                182.9f, 89.1f}, {176.5f, 85.0f}, {175.3f, 69.1f}, {175.3f, 73.6f}, {188.0f, 80.5f}, {
                188.0f, 82.7f}, {175.3f, 86.4f}, {170.5f, 67.7f}, {179.1f, 92.7f}, {177.8f, 93.6f}, {
                175.3f, 70.9f}, {182.9f, 75.0f}, {170.8f, 93.2f}, {188.0f, 93.2f}, {180.3f, 77.7f}, {
                177.8f, 61.4f}, {185.4f, 94.1f}, {168.9f, 75.0f}, {185.4f, 83.6f}, {180.3f, 85.5f}, {
                174.0f, 73.9f}, {167.6f, 66.8f}, {182.9f, 87.3f}, {160.0f, 72.3f}, {180.3f, 88.6f}, {
                167.6f, 75.5f}, {186.7f, 101.4f}, {175.3f, 91.1f}, {175.3f, 67.3f}, {175.9f, 77.7f}, {
                175.3f, 81.8f}, {179.1f, 75.5f}, {181.6f, 84.5f}, {177.8f, 76.6f}, {182.9f, 85.0f}, {
                177.8f, 102.5f}, {184.2f, 77.3f}, {179.1f, 71.8f}, {176.5f, 87.9f}, {188.0f, 94.3f}, {
                174.0f, 70.9f}, {167.6f, 64.5f}, {170.2f, 77.3f}, {167.6f, 72.3f}, {188.0f, 87.3f}, {
                174.0f, 80.0f}, {176.5f, 82.3f}, {180.3f, 73.6f}, {167.6f, 74.1f}, {188.0f, 85.9f}, {
                180.3f, 73.2f}, {167.6f, 76.3f}, {183.0f, 65.9f}, {183.0f, 90.9f}, {179.1f, 89.1f}, {
                170.2f, 62.3f}, {177.8f, 82.7f}, {179.1f, 79.1f}, {190.5f, 98.2f}, {177.8f, 84.1f}, {
                180.3f, 83.2f}, {180.3f, 83.2f}};
        seriesAddData(ser2, farr2);
        ser2.markPoint(new MarkPoint().data(new PointData().type(MarkType.max).name("最大值"), new PointData().type(MarkType.min).name("最小值")));
        ser2.markLine(new MarkLine().data(new LineData().type(MarkType.average).name("最小值")));
        option.series(ser1, ser2);
        Log.d("标准散点图", option.toString());
        mWebView.refreshEchartsWithOption(option.toString());
    }

    /**
     * 标准气泡图
     */
    private void basicBubble() {
        GsonOption option = new GsonOption();
        option.tooltip().trigger(Trigger.axis).axisPointer(new AxisPointer().type(PointerType.cross).lineStyle(
                new LineStyle().type(LineType.dashed).width(1f)));
        option.legend("scatter1", "scatter2");
        option.xAxis(new ValueAxis().scale(true).splitNumber(4));
        option.yAxis(new ValueAxis().scale(true).splitNumber(4));
        Scatter ser1 = new Scatter().name("scatter1").symbolSize(new Random().nextInt(10) + 2);
        bubleRandomData(ser1, 100);
        Scatter ser2 = new Scatter().name("scatter2").symbolSize(new Random().nextInt(10) + 2);
        bubleRandomData(ser2, 100);
        option.series(ser1, ser2);
        Log.d("标准气泡图", option.toString());
        mWebView.refreshEchartsWithOption(option.toString());
    }

    /**
     * 大规模散点
     */
    private void mutilScatter() {
        mWebView.setJsonFromAsset("json/scatter/LargeScatter.json");
    }

    /**
     * 类目坐标散点
     */
    private void classifyScatter() {
        mWebView.setJsonFromAsset("json/scatter/ClassifyScatter.json");
    }

    /**
     * 搭配值域散点
     */
    private void collocationScatter() {
        mWebView.setJsonFromAsset("json/scatter/CollocationScatter.json");
    }

    /**
     * 散点图
     */
    private void theScatter() {
        mWebView.setJsonFromAsset("json/scatter/TheScatter.json");
    }

    /**
     * 标准气泡图
     *
     * @param scatter
     * @param size
     */
    private void bubleRandomData(Scatter scatter, int size) {
        ArrayList<List<Float>> flist = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Float> cache = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                float ran = (float) (Math.random() * 100);
                cache.add((ran % 2 == 0 ? 1 : -1) * ran);
            }
            cache.add((float) (Math.random() * 100));
            flist.add(cache);
        }
        scatter.data().addAll(flist);
    }

    /**
     * 大规模散点
     *
     * @param scatter
     * @param size
     */
    private void mutilRandomData(Scatter scatter, int size) {
        ArrayList<List<Float>> flist = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Float> cache = new ArrayList<>();
            float x = (int) (Math.random() * 10000) / 1000f;
            cache.add(x);
            cache.add((float) Math.cos(x));
            flist.add(cache);
        }
        scatter.data().addAll(flist);
    }

    private void seriesAddData(Scatter scatter, float[][] arr) {
        ArrayList<List<Float>> flist = new ArrayList<>();
        for (float[] fa : arr) {
            List<Float> cache = new ArrayList<>();
            for (float f : fa) {
                cache.add(f);
            }
            flist.add(cache);
        }
        scatter.data().addAll(flist);
    }


}
