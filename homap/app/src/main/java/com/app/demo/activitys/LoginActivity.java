package com.app.demo.activitys;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.demo.MainActivity;
import com.app.demo.R;
import com.app.demo.beans.UserBean;
import com.app.demo.utils.DataBaseUtil;
import com.app.shop.mylibrary.base.BaseActivity;
import com.app.shop.mylibrary.beans.EventMessage;
import com.app.shop.mylibrary.utils.SharedPreferencesUtil;
import com.app.shop.mylibrary.utils.StringUtil;
import com.app.shop.mylibrary.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.inputName)
    EditText inputName;
    @BindView(R.id.inputpwd)
    EditText inputpwd;
    @BindView(R.id.imgv_return)
    ImageView imgvReturn;
    @BindView(R.id.tv_register)
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        tvTitle.setText("登录");
    }


    @OnClick({R.id.imgv_return, R.id.toLogin, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgv_return:
                onBackPressed();
                break;

            case R.id.toLogin:

                if (StringUtil.isEmpty(inputName.getText().toString())) {
                    ToastUtil.showToast(this, "请输入用户名");
                    return;
                }

                if (StringUtil.isEmpty(inputpwd.getText().toString())) {
                    ToastUtil.showToast(this, "请输入密码");
                    return;
                }

                UserBean userBean = DataBaseUtil.login(inputName.getText().toString(), inputpwd.getText().toString());

                if (userBean != null) { //密码正确
                    SharedPreferencesUtil.saveDataBean(this, userBean, "user");
                    EventBus.getDefault().post(new EventMessage(EventMessage.LOGIN));
                    showActivity(this, MainActivity.class);
                    finish();
                } else {
                    ToastUtil.showToast(this, "登录失败");
                }

                break;

            case R.id.tv_register:
                showActivity(this, RegisterActivity.class);
                break;
        }
    }
}
