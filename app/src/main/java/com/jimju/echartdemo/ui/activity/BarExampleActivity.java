package com.jimju.echartdemo.ui.activity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.abel533.echarts.AxisPointer;
import com.github.abel533.echarts.Grid;
import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.axis.AxisLabel;
import com.github.abel533.echarts.axis.AxisLine;
import com.github.abel533.echarts.axis.AxisTick;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.SplitArea;
import com.github.abel533.echarts.axis.SplitLine;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.PointerType;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.code.Symbol;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.data.LineData;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.MarkLine;
import com.github.abel533.echarts.series.MarkPoint;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.LineStyle;
import com.github.abel533.echarts.style.TextStyle;
import com.github.abel533.echarts.style.itemstyle.Emphasis;
import com.github.abel533.echarts.style.itemstyle.Normal;

import java.util.ArrayList;
import java.util.List;

public class BarExampleActivity extends BasicEChartDemoActivity {
    @Override
    public List<String> getRecyclerTitles() {
        return stringArray2List("标准柱状图", "堆栈柱状图", "温度计式图表", "组成瀑布图", "阶梯瀑布图", "多系列层叠",
                "标准柱状图(横向)", "横向堆栈柱状图", "多维条形图", "旋风条形图", "双数值柱状图", "多系列彩虹柱状图");
    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        switch (position) {
            case 0:
                basicBar();
                break;
            case 1:
                stackBar();
                break;
            case 2:
                temperatureBar();
                break;
            case 3:
                livingExpensesBar();
                break;
            case 4:
                stepWaterBar();
                break;
            case 5:
                multiSeriesCascade();
                break;
            case 6:
                horizonationBasicBar();
                break;
            case 7:
                horizonationStackBar();
                break;
            case 8:
                multidimensionalBar();
                break;
            case 9:
                cycloneBar();
                break;
            case 10:
                doubleDataBar();
                break;
            case 11:
                multiTypeBar();
                break;
            case 12:
                barChart();
                break;
        }
    }

    /**
     * 标准柱状图
     */
    private void basicBar() {
        GsonOption option = new GsonOption();
        option.calculable(true);
        option.xAxis(new CategoryAxis().data("1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"));
        option.yAxis(new ValueAxis());
        Bar bar = new Bar();
        bar.name("蒸发量").data(2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3);
        bar.markPoint(new MarkPoint().data(new PointData().type(MarkType.max), new MarkPoint().data(new PointData().type(MarkType.min))));
        bar.markLine(new MarkLine().data(new LineData().type(MarkType.average).name("平均值")));
        Bar bar1 = new Bar().name("降水量").data(2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3);
        bar1.markPoint(new MarkPoint().data(new PointData().name("年最高").value(182.2).xAxis(7f).yAxis(183f).symbolSize(18)
                , new MarkPoint().data(new PointData().name("年最低").value(2.3).xAxis(11f).yAxis(3f))));
        bar1.markLine(new MarkLine().data(new LineData().type(MarkType.average).name("平均值")));
        option.series(bar, bar1);
        mWebView.refreshEchartsWithOption(option.toString());
    }

    /**
     * 堆栈柱状图
     */
    private void stackBar() {
        GsonOption option = new GsonOption();
        option.legend("直接访问", "邮件营销", "联盟广告", "视频广告", "搜索引擎", "百度", "谷歌", "必应", "其他");
        option.tooltip().trigger(Trigger.axis).axisPointer(new AxisPointer().type(PointerType.shadow));
        option.calculable(true).yAxis(new ValueAxis()).xAxis(new CategoryAxis().data("周一", "周二", "周三", "周四", "周五", "周六", "周日"));
        Bar bar1 = new Bar().name("直接访问").data(320, 332, 301, 334, 390, 330, 320);
        Bar bar2 = new Bar().name("邮件营销").stack("广告").data(120, 132, 101, 134, 90, 230, 210);
        Bar bar3 = new Bar().name("联盟广告").stack("广告").data(220, 182, 191, 234, 290, 330, 310);
        Bar bar4 = new Bar().name("视频广告").stack("广告").data(150, 232, 201, 154, 190, 330, 410);
        ItemStyle itemStyle5 = new ItemStyle().normal(new Normal().lineStyle(new LineStyle().type(LineType.dashed)));
        Bar bar5 = new Bar().name("搜索引擎").data(150, 232, 201, 154, 190, 330, 410);
        bar5.markLine(new MarkLine().itemStyle(itemStyle5).data(new LineData().type(MarkType.min), new LineData().type(MarkType.max)));
        Bar bar6 = new Bar().name("百度").stack("搜索引擎").barWidth(5).data(620, 732, 701, 734, 1090, 1130, 1120);
        Bar bar7 = new Bar().name("谷歌").stack("搜索引擎").data(120, 132, 101, 134, 290, 230, 220);
        Bar bar8 = new Bar().name("必应").stack("搜索引擎").data(60, 72, 71, 74, 190, 130, 11);
        Bar bar9 = new Bar().name("其他").stack("搜索引擎").data(62, 82, 91, 84, 109, 110, 120);
        option.series(bar1, bar2, bar3, bar4, bar5, bar6, bar7, bar8, bar9);
        Log.d("堆栈柱状图", option.toString());
        mWebView.refreshEchartsWithOption(option.toString());
    }

    /**
     * 温度计式图表
     */
    private void temperatureBar() {
        GsonOption option = new GsonOption();
        option.tooltip().trigger(Trigger.axis).axisPointer(new AxisPointer().type(PointerType.shadow));
        option.calculable(true).xAxis(new CategoryAxis().data("Cosco", "CMA", "APL", "OOCL", "Wanhai", "Zim"));
        option.yAxis(new ValueAxis().boundaryGap(0, 0.1));
        Bar bar1 = new Bar().name("Acutal").stack("sum").barCategoryGap("50%").data(260, 200, 220, 120, 100, 80);
        bar1.itemStyle(new ItemStyle().normal(new Normal().color("tomato").barBorderColor("tomato").barBorderWidth(6f).barBorderRadius(0)
                .label(new Label().show(true).position("insideTop"))));
        Bar bar2 = new Bar().name("Forecast").stack("sum").data(40, 80, 50, 80, 80, 70);
        bar2.itemStyle(new ItemStyle().normal(new Normal().color("#fff").barBorderColor("tomato").barBorderWidth(6f).barBorderRadius(0)
                .label(new Label().show(true).position("top").textStyle(new TextStyle().color("tomato")))));
        option.series(bar1, bar2);
        Log.d("温度计式图表", option.toString());
        mWebView.refreshEchartsWithOption(option.toString());
    }

    /**
     * 组成瀑布图
     */
    private void livingExpensesBar() {
        GsonOption option = new GsonOption();
        option.tooltip().trigger(Trigger.axis).axisPointer(new AxisPointer().type(PointerType.shadow));
        option.yAxis(new ValueAxis()).xAxis(new CategoryAxis().splitLine(new SplitLine().show(false)).data("总费用", "房租", "水电费", "交通费", "伙食费", "日用品数"));
        Bar bar = new Bar().name("辅助").stack("总量").data(0, 1700, 1400, 1200, 300, 0);
        bar.itemStyle(new ItemStyle().normal(new Normal().barBorderColor("rgba(0,0,0,0)").color("rgba(0,0,0,0)")).emphasis(new Emphasis()
                .barBorderColor("rgba(0,0,0,0)").color("rgba(0,0,0,0)")));
        Bar bar1 = new Bar().name("生活费").stack("总量").data(2900, 1200, 300, 200, 900, 300);
        bar1.itemStyle().normal().label().show(true).position("inside");
        option.series(bar, bar1);
        Log.d("组成瀑布图", option.toString());
        mWebView.refreshEchartsWithOption(option.toString());
    }

    /**
     * 阶梯瀑布图
     */
    private void stepWaterBar() {
        GsonOption option = new GsonOption();
        option.legend("支出", "收入");
        option.tooltip().trigger(Trigger.axis).axisPointer(new AxisPointer().type(PointerType.shadow));

        option.yAxis(new ValueAxis()).xAxis(new CategoryAxis().splitLine(new SplitLine().show(false))
                .data("11月1日", "11月2日", "11月3日", "11月4日", "11月5日", "11月6日", "11月7日", "11月8日",
                        "11月9日", "11月10日", "11月11日"));
        Bar bar = new Bar().name("辅助").stack("总量").data(0, 1700, 1400, 1200, 300, 0);
        bar.itemStyle(new ItemStyle().normal(new Normal().barBorderColor("rgba(0,0,0,0)").color("rgba(0,0,0,0)")).emphasis(new Emphasis()
                .barBorderColor("rgba(0,0,0,0)").color("rgba(0,0,0,0)")));
        Bar bar1 = new Bar().name("收入").stack("总量").data(900, 345, 393, "-", "-", 135, 178, 286, "-", "-", "-");
        bar1.itemStyle().normal().label().show(true).position("top");
        Bar bar2 = new Bar().name("支出").stack("总量").data("-", "-", "-", 108, 154, "-", "-", "-", 119, 361, 203);
        bar2.itemStyle().normal().label().show(true).position("bottom");
        option.series(bar, bar1, bar2);
        Log.d("阶梯瀑布图", option.toString());
        mWebView.refreshEchartsWithOption(option.toString());
    }

    /**
     * 多系列层叠
     */
    private void multiSeriesCascade() {
        GsonOption option = new GsonOption();
        option.legend("ECharts1 - 2k数据", "ECharts1 - 2w数据", "ECharts1 - 20w数据", "",
                "ECharts2 - 2k数据", "ECharts2 - 2w数据", "ECharts2 - 20w数据").calculable(true);
        option.xAxis(new CategoryAxis().data("Line", "Bar", "Scatter", "K", "Map"),
                new CategoryAxis().data("Line", "Bar", "Scatter", "K", "Map").axisLine(new AxisLine().show(false)).axisTick(new AxisTick().show(false))
                        .axisLabel(new AxisLabel().show(false)).splitArea(new SplitArea().show(false)).splitLine(new SplitLine().show(false)));
        option.yAxis(new ValueAxis().axisLabel(new AxisLabel().formatter("{value} ms")));
        Bar bar1 = new Bar().name("ECharts2 - 2k数据");
        bar1.data(40, 155, 95, 75, 0);
        option.series().add(bar1);
        Bar bar2 = new Bar().name("ECharts2 - 2w数据");
        bar2.data(100, 200, 105, 100, 156);
        option.series().add(bar2);
        Bar bar3 = new Bar().name("ECharts2 - 20w数据");
        bar3.data(906, 911, 908, 778, 0);
        option.series().add(bar3);
        Bar bar4 = new Bar().name("ECharts1 - 2k数据").xAxisIndex(1);
        bar4.data(96, 224, 164, 124, 0);
        option.series().add(bar4);
        Bar bar5 = new Bar().name("ECharts1 - 2w数据").xAxisIndex(1);
        bar5.data(491, 2035, 389, 955, 347);
        option.series().add(bar5);
        Bar bar6 = new Bar().name("ECharts1 - 20w数据").xAxisIndex(1);
        bar6.data(3000, 3000, 2817, 3000, 0);
        option.series().add(bar6);
        Log.d("多系列层叠", option.toString());
        mWebView.refreshEchartsWithOption(option.toString());
    }


    /**
     * 标准条形图（横向）
     */
    private void horizonationBasicBar() {
        GsonOption option = new GsonOption();
        option.tooltip(Trigger.axis).legend("2011年", "2012年").calculable(true);
        option.xAxis(new ValueAxis().boundaryGap(0, 0.01));
        option.yAxis(new CategoryAxis().data("巴西", "印尼", "美国", "印度", "中国", "世界人口(万)"));
        option.series(new Bar().name("2011年").data(18203, 23489, 29034, 104970, 131744, 630230),
                new Bar().name("2012年").data(19325, 23438, 31000, 121594, 134141, 681807));
        mWebView.refreshEchartsWithOption(option.toString());
    }

    /**
     * 横向堆栈柱状图
     */
    private void horizonationStackBar() {
        GsonOption option = new GsonOption();
        option.tooltip(Trigger.axis).tooltip().axisPointer(new AxisPointer().type(PointerType.shadow));
        option.legend("直接访问", "邮件营销", "联盟广告", "视频广告", "搜索引擎");
        option.xAxis(new ValueAxis()).yAxis(new CategoryAxis().data("周一", "周二", "周三", "周四", "周五", "周六", "周日"));
        Bar bar1 = new Bar().name("直接访问").stack("总量").data(320, 302, 301, 334, 390, 330, 320);
        bar1.itemStyle(labelItemStyle("insideRight"));
        Bar bar2 = new Bar().name("邮件营销").stack("总量").data(120, 132, 101, 134, 90, 230, 210);
        bar2.itemStyle(labelItemStyle("insideRight"));
        Bar bar3 = new Bar().name("联盟广告").stack("总量").data(220, 182, 191, 234, 290, 330, 310);
        bar3.itemStyle(labelItemStyle("insideRight"));
        Bar bar4 = new Bar().name("视频广告").stack("总量").data(150, 212, 201, 154, 190, 330, 410);
        bar4.itemStyle(labelItemStyle("insideRight"));
        Bar bar5 = new Bar().name("搜索引擎").stack("总量").data(820, 832, 901, 934, 1290, 1330, 1320);
        bar5.itemStyle(labelItemStyle("insideRight"));
        option.series(bar1, bar2, bar3, bar4, bar5);
        mWebView.refreshEchartsWithOption(option.toString());
    }

    /**
     * 多维条形图
     */
    private void multidimensionalBar() {
        GsonOption option = new GsonOption();
        option.tooltip().trigger(Trigger.axis).axisPointer(new AxisPointer().type(PointerType.shadow));
        option.legend().y(55).data("GML", "PYP", "WTC", "ZTW");
        option.grid(new Grid().y(80).y2(30));
        option.xAxis(new ValueAxis().position("top").splitLine(new SplitLine().show(false)).axisLabel(new AxisLabel().show(false)));
        option.yAxis(new CategoryAxis().splitLine(new SplitLine().show(false)).data("重庆", "天津", "上海", "北京"));
        Bar bar1 = new Bar().name("GML").stack("总量");
        bar1.itemStyle(dataStyle()).data(38, 50, 33, 72);
        Bar bar2 = new Bar().name("GML").stack("总量");
        bar2.itemStyle(placeHoledStyle()).data(62, 50, 67, 28);
        Bar bar3 = new Bar().name("PYP").stack("总量");
        bar3.itemStyle(dataStyle()).data(61, 41, 42, 30);
        Bar bar4 = new Bar().name("PYP").stack("总量");
        bar4.itemStyle(placeHoledStyle()).data(39, 59, 58, 70);
        Bar bar5 = new Bar().name("WTC").stack("总量");
        bar5.itemStyle(dataStyle()).data(37, 35, 44, 60);
        Bar bar6 = new Bar().name("WTC").stack("总量");
        bar6.itemStyle(placeHoledStyle()).data(63, 65, 56, 40);
        Bar bar7 = new Bar().name("ZTW").stack("总量");
        bar7.itemStyle(dataStyle()).data(71, 50, 31, 39);
        Bar bar8 = new Bar().name("ZTW").stack("总量");
        bar8.itemStyle(placeHoledStyle()).data(29, 50, 69, 61);
        option.series(bar1, bar2, bar3, bar4, bar5, bar6, bar7, bar8);
        Log.d("多维条形图", option.toString());
        mWebView.refreshEchartsWithOption(option.toString());
    }

    /**
     * 旋风条形图
     */
    private void cycloneBar() {
        GsonOption option = new GsonOption();
        option.tooltip().trigger(Trigger.axis).axisPointer(new AxisPointer().type(PointerType.shadow));
        option.legend("利润", "支出", "收入").calculable(true);
        option.xAxis(new ValueAxis());
        option.yAxis(new CategoryAxis().axisTick(new AxisTick().show(false))
                .data("周一", "周二", "周三", "周四", "周五", "周六", "周日"));
        Bar ser0 = new Bar().name("利润");
        ser0.data(200, 170, 240, 244, 200, 220, 210);
        ser0.itemStyle(new ItemStyle().normal(new Normal().label(new Label().show(true).position("insideLeft"))));
        Bar ser1 = new Bar().name("收入").stack("总量");
        ser1.data(320, 302, 341, 374, 390, 450, 420);
        ser1.itemStyle(new ItemStyle().normal(new Normal().label(new Label().show(true))));
        Bar ser2 = new Bar().name("支出").stack("总量");
        ser2.data(-120, -132, -101, -134, -190, -230, -210);
        ser2.itemStyle(new ItemStyle().normal(new Normal().label(new Label().show(true).position("left"))));
        option.series(ser0, ser1, ser2);
        Log.d("旋风条形图", option.toString());
        mWebView.refreshEchartsWithOption(option.toString());
    }

    /**
     * 双数值柱状图
     */
    private void doubleDataBar() {
        GsonOption option = new GsonOption();
        option.tooltip().trigger(Trigger.axis);
        option.legend("数据1", "数据2");
        option.calculable(true);
        option.xAxis(new ValueAxis());
        option.yAxis(new ValueAxis().axisLine(new AxisLine().lineStyle(new LineStyle().color("#dc143c"))));
        Bar ser0 = new Bar().name("数据1");
        float[][] farr1 = {{1.5f, 10}, {5, 7}, {8, 8}, {12, 6}, {11, 12}, {16, 9}, {14, 6}, {17, 4}, {19, 9}};
        ArrayList<List<Float>> flist = new ArrayList<>();
        for (float[] fa : farr1) {
            List<Float> cache = new ArrayList<>();
            for (float f : fa) {
                cache.add(f);
            }
            flist.add(cache);
        }
        ser0.data().addAll(flist);
        ser0.markPoint(new MarkPoint().data(
                new PointData().type(MarkType.max).name("最大值").symbol(Symbol.emptyCircle).itemStyle(new ItemStyle().normal(new Normal().color("#dc143c").label(new Label().position(Position.top)))),
                new PointData().type(MarkType.max).name("最小值").symbol(Symbol.emptyCircle).itemStyle(new ItemStyle().normal(new Normal().color("#dc143c").label(new Label().position(Position.bottom)))),
                new PointData().type(MarkType.max).name("最大值").valueIndex(0).symbol(Symbol.emptyCircle).itemStyle(new ItemStyle().normal(new Normal().color("#1e90ff").label(new Label().position(Position.right)))),
                new PointData().type(MarkType.max).name("最大值").valueIndex(0).symbol(Symbol.emptyCircle).itemStyle(new ItemStyle().normal(new Normal().color("#1e90ff").label(new Label().position(Position.left))))));
        ser0.markLine(new MarkLine().data(
                //纵轴 默认
                new LineData().type(MarkType.max).name("最大值").itemStyle(new ItemStyle().normal(new Normal().color("#dc143c"))),
                new LineData().type(MarkType.min).name("最小值").itemStyle(new ItemStyle().normal(new Normal().color("#dc143c"))),
                new LineData().type(MarkType.average).name("平均值").itemStyle(new ItemStyle().normal(new Normal().color("#dc143c"))),
                //横轴
                new LineData().type(MarkType.max).valueIndex(0).name("最大值").itemStyle(new ItemStyle().normal(new Normal().color("#1e90ff"))),
                new LineData().type(MarkType.min).valueIndex(0).name("最小值").itemStyle(new ItemStyle().normal(new Normal().color("#1e90ff"))),
                new LineData().type(MarkType.average).valueIndex(0).name("平均值").itemStyle(new ItemStyle().normal(new Normal().color("#1e90ff")))
        ));
        Bar ser1 = new Bar().name("数据2");
        float[][] farr2 = {{1, 2}, {2, 3}, {4, 4}, {7, 5}, {11, 11}, {18, 15}};
        ArrayList<List<Float>> flist1 = new ArrayList<>();
        for (float[] fa : farr2) {
            List<Float> cache = new ArrayList<>();
            for (float f : fa) {
                cache.add(f);
            }
            flist1.add(cache);
        }
        ser1.barHeight(10f);
        ser1.data().addAll(flist1);
        option.series(ser0, ser1);
        Log.d("双数值柱状图", option.toString());
        mWebView.refreshEchartsWithOption(option.toString());
    }

    /**
     * 多系列彩虹柱状图
     */
    private void multiTypeBar() {
        String[] colorList = {"#ff7f50", "#87cefa", "#da70d6", "#32cd32", "#6495ed",
                "#ff69b4", "#ba55d3", "#cd5c5c", "#ffa500", "#40e0d0"};
        GsonOption option = new GsonOption();
        option.tooltip().trigger(Trigger.axis).axisPointer(new AxisPointer().type(PointerType.shadow));
        option.legend().x(X.left).data("2010", "2011", "2012", "2013");
        option.grid(new Grid().y(80).x2(40).y2(40));
        option.xAxis(new CategoryAxis().data("食品", "衣着", "居住", "家庭设备及用品", "医疗保健", "交通和通信", "文教娱乐服务", "其他"));
        option.yAxis(new ValueAxis());
        Bar ser0 = new Bar().name("2010");
        ser0.data(4804.7, 1444.3, 1332.1, 908, 871.8, 1983.7, 1627.6, 499.2);
        Bar ser1 = new Bar().name("2011");
        ser1.data(5506.3, 1674.7, 1405, 1023.2, 969, 2149.7, 1851.7, 581.3);
        Bar ser2 = new Bar().name("2012");
        ser2.data(6040.9, 1823.4, 1484.3, 1116.1, 1063.7, 2455.5, 2033.5, 657.1);
        Bar ser3 = new Bar().name("2013");
        ser3.data(6311.9, 1902, 1745.1, 1215.1, 1118.3, 2736.9, 2294, 699.4);
        option.series(ser0, ser1, ser2, ser3);
        Log.d("多系列彩虹柱状图", option.toString());
        mWebView.refreshEchartsWithOption(option.toString());
    }

    /**
     * 柱状图
     */
    private void barChart() {
        mWebView.setJsonFromAsset("json/SimpleBarOption.txt");
    }

    private ItemStyle labelItemStyle(String position) {
        ItemStyle itemStyle = new ItemStyle();
        itemStyle.normal().label(new Label().show(true));
        if (!TextUtils.isEmpty(position)) {
            itemStyle.normal().label().position(position);
        }
        return itemStyle;
    }

    private ItemStyle placeHoledStyle() {
        ItemStyle itemStyle = new ItemStyle();
        itemStyle.normal().barBorderColor("rgba(0,0,0,0)").color("rgba(0,0,0,0)");
        itemStyle.emphasis().barBorderColor("rgba(0,0,0,0)").color("rgba(0,0,0,0)");
        return itemStyle;
    }

    private ItemStyle dataStyle() {
        ItemStyle itemStyle = new ItemStyle();
        itemStyle.normal().label(new Label().show(true).position("insideLeft")).formatter("{c}%");
        return itemStyle;
    }
}
