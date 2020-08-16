package com.app.demo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.app.demo.MainActivity;
import com.app.demo.R;
import com.app.demo.activitys.LineActivity;
import com.app.demo.activitys.LoginActivity;
import com.app.demo.activitys.NearActivity;
import com.app.demo.activitys.SelfActivity;
import com.app.demo.activitys.TurnActivity;
import com.app.shop.mylibrary.base.BaseFragment;
import com.app.shop.mylibrary.utils.UserManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusFragment extends BaseFragment {

    @BindView(R.id.banner)
    Banner banner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        ButterKnife.bind(this, view);
        initBanner();
        return view;
    }

    @OnClick({R.id.tv_shishi, R.id.tv_huancheng, R.id.tv_line})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_shishi:
                skipActivity(getActivity(), NearActivity.class);
                break;
            case R.id.tv_huancheng:
                skipActivity(getActivity(), TurnActivity.class);
                break;

            case R.id.tv_line:
                skipActivity(getActivity(), LineActivity.class);
                break;
        }
    }

    /**
     * 轮播图
     */
    private void initBanner() {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new FresscoImageLoader());
        //设置banner动画效果
//        banner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置允许手势滑动
        banner.setViewPagerIsScroll(true);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);

        List list_banner = new ArrayList();
        list_banner.add(R.mipmap.pic_1);
        list_banner.add(R.mipmap.pic_2);
        list_banner.add(R.mipmap.pic_3);

        banner.setImages(list_banner);

        //banner设置方法全部调用完毕时最后调用
        banner.start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });
    }


    public class FresscoImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            int url = (int) path;
            imageView.setImageResource(url);
        }

        //提供createImageView 方法，方便fresco自定义ImageView
        @Override
        public ImageView createImageView(Context context) {

            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) getLayoutInflater().inflate(R.layout.layout_banner_imageview, null);
//            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
            return simpleDraweeView;
        }
    }
}
