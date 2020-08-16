package com.app.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.app.demo.activitys.LoginActivity;
import com.app.demo.fragments.BusFragment;
import com.app.demo.fragments.ListFragment;
import com.app.demo.fragments.MineFragment;
import com.app.shop.mylibrary.base.BaseActivity;
import com.app.shop.mylibrary.base.BaseFragment;
import com.app.shop.mylibrary.beans.EventMessage;
import com.app.shop.mylibrary.utils.UserManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.txt_1)
    TextView txt1;
    @BindView(R.id.txt_2)
    TextView txt2;
    @BindView(R.id.txt_3)
    TextView txt3;
    @BindView(R.id.txt_4)
    TextView txt4;
    @BindView(R.id.txt_5)
    TextView txt5;

    Fragment mFragment;
    BaseFragment fragment1, fragment2, fragment3, fragment4, fragment5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSwipeEnabled(false);
        initData();

    }

    private void initFragment() {
        mFragment = new Fragment();
        if (fragment1 == null) {
            fragment1 = new BusFragment();
        }
        txt1.setSelected(true);
        txt2.setSelected(false);
        txt3.setSelected(false);
        txt4.setSelected(false);
        txt5.setSelected(false);
        switchContent(mFragment, fragment1);
    }


    /**
     * 更换fragment
     *
     * @param from
     * @param to
     */
    public void switchContent(Fragment from, Fragment to) {
        if (mFragment != to) {
            mFragment = to;
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (!to.isAdded()) {    // 先判断是否被add过
                transaction.hide(from).add(R.id.fragment_container, to).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(from).show(to).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
            }
        }
    }

    @Override
    public void onEvent(EventMessage msg) {
        super.onEvent(msg);
        if (msg.getMessageType() == EventMessage.LOGOUT) {
            finish();
        }
    }


    private void initData() {
        if (UserManager.isLogin(this)) {
            initFragment();
        } else {
            showActivity(this, LoginActivity.class);
            finish();
        }
    }

    @OnClick({R.id.txt_1, R.id.txt_2, R.id.txt_3, R.id.txt_4, R.id.txt_5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_1:
                checkPosition(1);
                break;
            case R.id.txt_2:
                checkPosition(2);
                break;
            case R.id.txt_3:
                checkPosition(3);
                break;
            case R.id.txt_4:
                checkPosition(4);
                break;
            case R.id.txt_5:
                checkPosition(5);
                break;
        }
    }

    private void checkPosition(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        if (position == 1) {
            if (fragment1 == null) {
                fragment1 = new BusFragment();
            }
            txt1.setSelected(true);
            txt2.setSelected(false);
            txt3.setSelected(false);
            txt4.setSelected(false);
            txt5.setSelected(false);
            switchContent(mFragment, fragment1);
        } else if (position == 2) {
            if (fragment2 == null) {
                fragment2 = new ListFragment();
                fragment2.setArguments(bundle);
            }
            txt1.setSelected(false);
            txt2.setSelected(true);
            txt3.setSelected(false);
            txt4.setSelected(false);
            txt5.setSelected(false);
            switchContent(mFragment, fragment2);
        } else if (position == 3) {
            if (fragment3 == null) {
                fragment3 = new ListFragment();
                fragment3.setArguments(bundle);
            }
            txt1.setSelected(false);
            txt2.setSelected(false);
            txt3.setSelected(true);
            txt4.setSelected(false);
            txt5.setSelected(false);
            switchContent(mFragment, fragment3);
        } else if (position == 4) {
            if (fragment4 == null) {
                fragment4 = new ListFragment();
                fragment4.setArguments(bundle);
            }
            txt1.setSelected(false);
            txt2.setSelected(false);
            txt3.setSelected(false);
            txt4.setSelected(true);
            txt5.setSelected(false);
            switchContent(mFragment, fragment4);
        } else if (position == 5) {
            if (fragment5 == null) {
                fragment5 = new MineFragment();
            }
            txt1.setSelected(false);
            txt2.setSelected(false);
            txt3.setSelected(false);
            txt4.setSelected(false);
            txt5.setSelected(true);
            switchContent(mFragment, fragment5);
        }

    }
}
