package com.app.demo.activitys;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;

import com.app.demo.R;
import com.app.demo.adapters.NearChildAdapter;
import com.app.demo.beans.NearBean;
import com.app.demo.utils.LinesUtil;
import com.app.shop.mylibrary.base.BaseActivity;
import com.app.shop.mylibrary.http.HttpHelp;
import com.app.shop.mylibrary.http.I_success;
import com.app.shop.mylibrary.utils.StringUtil;
import com.app.shop.mylibrary.utils.ToastUtil;
import com.app.shop.mylibrary.widgts.LoadingDialog;
import com.app.shop.mylibrary.widgts.ScrollListView;
import com.google.gson.Gson;

import org.json.JSONException;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NearActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.edt_city)
    EditText edtCity;
    @BindView(R.id.edt_address)
    EditText edtAddress;
    @BindView(R.id.ll_container)
    LinearLayout llContainer;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.rela_empty)
    RelativeLayout relaEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near);
        ButterKnife.bind(this);
        tvTitle.setText("附近站点查询");
    }


    private void setView(String json) {
        Gson gson = new Gson();
        NearBean nearBean = gson.fromJson(json, NearBean.class);
        if (llContainer != null) {
            llContainer.removeAllViews();
        }
        if (nearBean.getStatus().equals("0")) {
            if (nearBean.getResult() != null) {
                for (int i = 0; i < nearBean.getResult().size(); i++) {
                    NearBean.ResultBean bean = nearBean.getResult().get(i);
                    LayoutInflater inflater = LayoutInflater.from(this);
                    View view = inflater.inflate(R.layout.layout_near, null);
                    TextView tv_title = view.findViewById(R.id.tv_list_item);
                    ScrollListView listView = view.findViewById(R.id.lv_list_near);

                    tv_title.setText(bean.getStation() + "-" + bean.getDistance() + "米");
                    if (bean.getLines() != null) {
                        NearChildAdapter adapter = new NearChildAdapter(this, (ArrayList) bean.getLines(), R.layout.item_near_child);
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

                String address = edtAddress.getText().toString();
                String city = edtCity.getText().toString();
                if (StringUtil.isEmpty(city) || StringUtil.isEmpty(address)) {
                    ToastUtil.showToast(this, "请输入城市或地点");
                    return;
                }
                LinesUtil.GetNearStation(this, city, address, new I_success() {
                    @Override
                    public void doSuccess(String t) throws JSONException {
                        setView(t);
                    }
                });
                break;
        }
    }


}
