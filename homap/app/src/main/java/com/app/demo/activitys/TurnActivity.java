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
import com.app.demo.adapters.TurnLinesAdapter;
import com.app.demo.beans.LinesBean;
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

public class TurnActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.edt_start)
    EditText edtStart;
    @BindView(R.id.edt_end)
    EditText edtEnd;
    @BindView(R.id.ll_container)
    LinearLayout llContainer;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.rela_empty)
    RelativeLayout relaEmpty;
    @BindView(R.id.edt_city)
    EditText edtCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn);
        ButterKnife.bind(this);
        tvTitle.setText("换乘查询");
    }


    private void setView(String json) {
        Gson gson = new Gson();
        LinesBean linesBean = gson.fromJson(json, LinesBean.class);
        if (llContainer != null) {
            llContainer.removeAllViews();
        }
        if (linesBean.getStatus().equals("0")) {
            if (linesBean.getResult() != null) {
                for (int i = 0; i < linesBean.getResult().size(); i++) {
                    LinesBean.ResultBean bean = linesBean.getResult().get(i);
                    LayoutInflater inflater = LayoutInflater.from(this);
                    View view = inflater.inflate(R.layout.layout_near, null);
                    TextView tv_title = view.findViewById(R.id.tv_list_item);
                    ScrollListView listView = view.findViewById(R.id.lv_list_near);

                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < bean.getVehicles().size(); j++) {
                        sb.append(bean.getVehicles().get(j) + "、");
                    }
                    String vehicles = "";
                    if (sb.length() > 0) {
                        vehicles = sb.toString().substring(0, sb.length() - 1);
                    }
                    tv_title.setText("方式" + (i + 1) + "-" + vehicles);

                    if (bean.getSteps() != null) {
                        TurnLinesAdapter adapter = new TurnLinesAdapter(this, (ArrayList) bean.getSteps(), R.layout.item_near_child);
                        listView.setAdapter(adapter);
                    }
                    llContainer.addView(view);
                }

                if (linesBean.getResult().size() > 0) {
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
            ToastUtil.showToast(this, linesBean.getMsg());
        }
    }

    @OnClick({R.id.imgv_return, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgv_return:
                onBackPressed();
                break;
            case R.id.tv_search:

                String city = edtCity.getText().toString();

                if (StringUtil.isEmpty(city)) {
                    ToastUtil.showToast(this, "请输入城市");
                    return;
                }

                String start = edtStart.getText().toString();
                String end = edtEnd.getText().toString();
                if (StringUtil.isEmpty(start) || StringUtil.isEmpty(end)) {
                    ToastUtil.showToast(this, "请输入位置");
                    return;
                }

                LinesUtil.GetTurnLine(this, city, start, end, new I_success() {
                    @Override
                    public void doSuccess(String t) throws JSONException {
                        setView(t);
                    }
                });
                break;
        }
    }
}
