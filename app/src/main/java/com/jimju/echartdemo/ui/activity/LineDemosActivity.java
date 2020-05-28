package com.jimju.echartdemo.ui.activity;

import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.Tooltip;
import com.github.abel533.echarts.axis.Axis;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.AxisType;
import com.github.abel533.echarts.code.PointerType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.style.ItemStyle;
import java.util.List;

/**
 *来源：https://echarts.apache.org/
 */
public class LineDemosActivity extends BasicEChartDemoActivity {

    @Override
    public List<String> getRecyclerTitles() {
        return stringArray2List("Basic Line Chart", "Basic area chart", "Smoothed Line Chart", "Stacked area chart", "Stacked Line Chart",
                "Line Easing Visualizing", "Line Gradient", "Line Chart in Cartesian Coordinate System", "Line with Marklines", "Step Line", "Line Style and Item Style", "Line Y Category", "Mixed Line and Bar", "Linear Regression");
    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        switch (position) {
            case 0:
                demo1();
                break;
            case 1:
                demo2();
                break;

            case 2:
                demo3();
                break;

            case 3:
                demo4();
                break;

            case 4:
                demo5();
                break;
            default:
                Toast.makeText(this, "点击了" + position, Toast.LENGTH_LONG).show();
        }
    }

    public void demo1() {
        GsonOption option = new GsonOption();
        Axis xAxis = new CategoryAxis();
        xAxis.data("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        Axis yAxis = new ValueAxis();
        yAxis.setType(AxisType.value);
        option.xAxis(xAxis);
        option.yAxis(yAxis);
        Line line = new Line();
        line.data(820, 932, 901, 934, 1290, 1330, 1320);
        option.series(line);
        Log.e("Basic Line Chart", option.toString());
        mWebView.setJsonFromOption(option);
    }

    public void demo2() {
        GsonOption option = new GsonOption();
        Axis xAxis = new CategoryAxis();
        xAxis.boundaryGap(false);
        xAxis.data("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        Axis yAxis = new ValueAxis();
        yAxis.setType(AxisType.value);
        option.xAxis(xAxis);
        option.yAxis(yAxis);
        Line line = new Line();
        line.data(820, 932, 901, 934, 1290, 1330, 1320);
        line.itemStyle().normal().areaStyle().setType("defalut");
        option.series(line);
        Log.e("Basic area chart", option.toString());
        mWebView.setJsonFromOption(option);
    }

    public void demo3() {
        GsonOption option = new GsonOption();
        Axis xAxis = new CategoryAxis();
        xAxis.boundaryGap(false);
        xAxis.data("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        Axis yAxis = new ValueAxis();
        yAxis.setType(AxisType.value);
        option.xAxis(xAxis);
        option.yAxis(yAxis);
        Line line = new Line();
        line.data(820, 932, 901, 934, 1290, 1330, 1320);
        line.smooth(true);
        option.series(line);
        Log.i("Smoothed Line Chart", option.toString());
        mWebView.setJsonFromOption(option);
    }

    public void demo4() {
        GsonOption option = new GsonOption();
//        option.title("堆叠区域图");
        Tooltip tooltip = option.tooltip();
        tooltip.trigger(Trigger.axis);
        tooltip.axisPointer().type(PointerType.cross).label(new Label().backgroundColor("#6a7985"));

        Axis xAxis = new CategoryAxis();
        xAxis.data("周一", "周二", "周三", "周四", "周五", "周六", "周日");
        Axis yAxis = new ValueAxis();
        yAxis.setType(AxisType.value);
        option.xAxis(xAxis);
        option.yAxis(yAxis);
        String[] names = {"邮件营销", "联盟广告", "视频广告", "直接访问", "搜索引擎"};
        int[][] datas = {{120, 132, 101, 134, 90, 230, 210}, {220, 182, 191, 234, 290, 330, 310}, {150, 232, 201, 154, 190, 330, 410},
                {320, 332, 301, 334, 390, 330, 320}, {820, 932, 901, 934, 1290, 1330, 1320}};
        for (int i = 0; i < names.length; i++) {
            Line line1 = new Line();
            line1.stack("总量");
            line1.name(names[i]);
            Log.e("TAB", datas[i].toString());
            List list = line1.data();
            for (int d : datas[i]) {
                list.add(d);
            }
//            line1.data(120, 132, 101, 134, 90, 230, 210);
            line1.itemStyle().normal().areaStyle().setType("defalut");
            if (names.length - 1 == i) {
                ItemStyle itemStyle = new ItemStyle();
                itemStyle.normal().label().show(true).position("top");
                line1.label(itemStyle);
            }
            option.series().add(line1);
        }
        option.legend().data("邮件营销", "联盟广告", "视频广告", "直接访问", "搜索引擎");
        Log.i("Stacked area chart", option.toString());
        mWebView.setJsonFromOption(option);

    }


    public void demo5() {
        GsonOption option = new GsonOption();
//        option.title("堆叠区域图");
        Tooltip tooltip = option.tooltip();
        tooltip.trigger(Trigger.axis);
        tooltip.axisPointer().type(PointerType.cross).label(new Label().backgroundColor("#6a7985"));

        Axis xAxis = new CategoryAxis();
        xAxis.data("周一", "周二", "周三", "周四", "周五", "周六", "周日");
        Axis yAxis = new ValueAxis();
        yAxis.setType(AxisType.value);
        option.xAxis(xAxis);
        option.yAxis(yAxis);
        String[] names = {"邮件营销", "联盟广告", "视频广告", "直接访问", "搜索引擎"};
        int[][] datas = {{120, 132, 101, 134, 90, 230, 210}, {220, 182, 191, 234, 290, 330, 310}, {150, 232, 201, 154, 190, 330, 410},
                {320, 332, 301, 334, 390, 330, 320}, {820, 932, 901, 934, 1290, 1330, 1320}};
        for (int i = 0; i < names.length; i++) {
            Line line1 = new Line();
            line1.stack("总量");
            line1.name(names[i]);
            Log.e("TAB", datas[i].toString());
            List list = line1.data();
            for (int d : datas[i]) {
                list.add(d);
            }

            if (names.length - 1 == i) {
                ItemStyle itemStyle = new ItemStyle();
                itemStyle.normal().label().show(true).position("top");
                line1.label(itemStyle);
            }
            option.series().add(line1);
        }
        option.legend().data("邮件营销", "联盟广告", "视频广告", "直接访问", "搜索引擎");
        Log.i("Stacked Line Chart", option.toString());
        mWebView.setJsonFromOption(option);

    }


}
