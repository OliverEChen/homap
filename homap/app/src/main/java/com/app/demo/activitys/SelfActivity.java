package com.app.demo.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.app.demo.R;
import com.app.demo.utils.DataBaseUtil;
import com.app.shop.mylibrary.base.BaseActivity;
import com.app.shop.mylibrary.beans.EventMessage;
import com.app.shop.mylibrary.utils.SharedPreferencesUtil;
import com.app.shop.mylibrary.utils.ToastUtil;
import com.app.shop.mylibrary.utils.UserManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class SelfActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.edt_mobile)
    TextView edtMobile;
    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.tv_title_right)
    TextView tvRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self);
        ButterKnife.bind(this);
        tvTitle.setText("个人信息");
        tvRight.setVisibility(View.VISIBLE);
        tvRight.setText("修改");
        setData();

    }

    private void setData() {

        edtMobile.setText(UserManager.getMobile(this));
        edtName.setText(UserManager.getUserName(this));
    }


    @OnClick({R.id.imgv_return, R.id.tv_title_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgv_return:
                onBackPressed();
                break;

            case R.id.tv_title_right:

                boolean result = DataBaseUtil.updateUser(UserManager.getUserId(this), edtName.getText().toString());

                if (result) {
                    SharedPreferencesUtil.saveData(this, "user", "name", edtName.getText().toString());

                    ToastUtil.showToast(this, "修改成功");
                    EventBus.getDefault().post(new EventMessage(EventMessage.Refresh));
                    onBackPressed();
                } else {
                    ToastUtil.showToast(this, "修改失败");
                }


                break;
        }
    }
}
