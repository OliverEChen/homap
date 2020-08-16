package com.app.demo.activitys;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.demo.R;
import com.app.demo.adapters.GridAdapter;
import com.app.shop.mylibrary.base.BaseActivity;
import com.app.shop.mylibrary.beans.EventMessage;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class ImageListActivity extends BaseActivity {
    @BindView(R.id.imgv_return)
    ImageView imgvReturn;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.gridview)
    GridView gridview;

    GridAdapter adapter; //适配器
    ArrayList<Integer> list = new ArrayList<>(); //数据源

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);
        ButterKnife.bind(this);

        //模拟数据
        initData();
    }

    private void initData() {
        tvTitle.setText("选取图片");


        adapter = new GridAdapter(this, list, R.layout.item_gridview);
        gridview.setAdapter(adapter);


        //点击事件
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EventBus.getDefault().post(new EventMessage(EventMessage.CHOICE_PIC, list.get(position)));
                finish();
            }
        });


    }

    @OnClick(R.id.imgv_return)
    public void onViewClicked() {
        onBackPressed();
    }
}
