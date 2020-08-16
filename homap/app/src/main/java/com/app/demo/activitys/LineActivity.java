package com.app.demo.activitys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;

import com.app.demo.R;
import com.app.demo.adapters.LineAdapter;
import com.app.demo.adapters.NearChildAdapter;
import com.app.demo.beans.FindLine;
import com.app.demo.beans.NearBean;
import com.app.demo.utils.LinesUtil;
import com.app.shop.mylibrary.base.BaseActivity;
import com.app.shop.mylibrary.http.I_success;
import com.app.shop.mylibrary.utils.StringUtil;
import com.app.shop.mylibrary.utils.ToastUtil;
import com.app.shop.mylibrary.widgts.ScrollListView;
import com.google.gson.Gson;

import org.json.JSONException;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LineActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.edt_city)
    EditText edtCity;
    @BindView(R.id.edt_line)
    EditText edtLine;
    @BindView(R.id.ll_container)
    LinearLayout llContainer;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.rela_empty)
    RelativeLayout relaEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        ButterKnife.bind(this);
        tvTitle.setText("线路查询");
    }


    private void setView(String json) {
        Gson gson = new Gson();
        FindLine nearBean = gson.fromJson(json, FindLine.class);
        if (llContainer != null) {
            llContainer.removeAllViews();
        }
        if (nearBean.getStatus().equals("0")) {
            if (nearBean.getResult() != null) {
                for (int i = 0; i < nearBean.getResult().size(); i++) {
                    FindLine.ResultBean bean = nearBean.getResult().get(i);
                    LayoutInflater inflater = LayoutInflater.from(this);
                    View view = inflater.inflate(R.layout.layout_line, null);
                    TextView tv_title = view.findViewById(R.id.tv_list_item);
                    TextView tv_begin = view.findViewById(R.id.tv_begin_item);
                    TextView tv_end = view.findViewById(R.id.tv_end_item);
                    ScrollListView listView = view.findViewById(R.id.lv_list_line);

                    tv_title.setText("线路：" + bean.getTransitno());
                    tv_begin.setText("起点：" + bean.getStartstation());
                    tv_end.setText("终点：" + bean.getEndstation());
                    if (bean.getList() != null) {
                        LineAdapter adapter = new LineAdapter(this, (ArrayList) bean.getList(), R.layout.item_near_child);
                        listView.setAdapter(adapter);
                    }
                    llContainer.addView(view);
                }

                if (nearBean.getResult().size() > 0) {
                    scrollView.setVisibility(View.VISIBLE);
                    relaEmpty.setVisibility(View.GONE);
                } else {
                    scrollView.setVisibility(View.GONE);
                    relaEmpty.setVisibility(View.VISIBLE);
                }

            } else {
                scrollView.setVisibility(View.GONE);
                relaEmpty.setVisibility(View.VISIBLE);
            }
        } else {
            ToastUtil.showToast(this, nearBean.getMsg());
        }
    }

    @OnClick({R.id.imgv_return, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgv_return:
                onBackPressed();
                break;
            case R.id.tv_search:

                String line = edtLine.getText().toString();
                String city = edtCity.getText().toString();
                if (StringUtil.isEmpty(city) || StringUtil.isEmpty(line)) {
                    ToastUtil.showToast(this, "请输入城市或线路");
                    return;
                }
                LinesUtil.GetLine(this, city, line, new I_success() {
                    @Override
                    public void doSuccess(String t) throws JSONException {
                        setView(t);
                    }
                });
                break;
        }
    }


}
