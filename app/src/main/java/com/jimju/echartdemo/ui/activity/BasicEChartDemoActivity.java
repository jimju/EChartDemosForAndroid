package com.jimju.echartdemo.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.jimju.echartdemo.R;
import com.jimju.echartdemo.adapter.BaseEChartActivityAdapter;
import com.jimju.echartdemo.widget.EChartWebView;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicEChartDemoActivity extends AppCompatActivity implements OnItemClickListener {
    protected EChartWebView mWebView;
    protected RecyclerView mRecyclerView;
    protected Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_demos);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mWebView = findViewById(R.id.web_view);
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        BaseEChartActivityAdapter adapter = new BaseEChartActivityAdapter(getRecyclerTitles());
        adapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(adapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public abstract List<String> getRecyclerTitles();

    public List<String> stringArray2List(String... arr){
        List<String> list = new ArrayList<>();
        for (String s:arr){
            list.add(s);
        }
        return list;
    }

}
