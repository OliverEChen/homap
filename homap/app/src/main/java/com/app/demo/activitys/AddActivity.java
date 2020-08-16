package com.app.demo.activitys;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.demo.R;
import com.app.demo.beans.FoodBean;
import com.app.demo.beans.HotelBean;
import com.app.demo.beans.ScenicBean;
import com.app.demo.utils.GlideEngine;
import com.app.shop.mylibrary.base.BaseActivity;
import com.app.shop.mylibrary.beans.EventMessage;
import com.app.shop.mylibrary.utils.StringUtil;
import com.app.shop.mylibrary.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.huantansheng.easyphotos.EasyPhotos;
import com.huantansheng.easyphotos.callback.SelectCallback;
import com.huantansheng.easyphotos.models.album.entity.Photo;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class AddActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.edt_title)
    EditText edtTitle;
    @BindView(R.id.edtprice)
    EditText edtprice;
    @BindView(R.id.edtstar)
    EditText edtStar;
    @BindView(R.id.ll_more)
    LinearLayout llMore;
    @BindView(R.id.imgv_pic)
    ImageView imgvPic;
    int position;
    Bundle bundle;
    String pic;
    @BindView(R.id.edtLocation)
    EditText edtLocation;
    int id = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
        bundle = getIntent().getExtras();
        position = bundle.getInt("position");
        if (bundle.containsKey("id")) {
            id = bundle.getInt("id");
        }
        if (position == 2) {
            if (id == -1) {
                tvTitle.setText("添加酒店");
            } else {
                tvTitle.setText("修改酒店");

                HotelBean bean = DataSupport.where("id=?", String.valueOf(id)).findFirst(HotelBean.class);
                edtTitle.setText(bean.getName());
                edtprice.setText(String.valueOf(bean.getPrice()));
                edtStar.setText(bean.getStar());
                edtLocation.setText(bean.getLocation());
                pic = bean.getPic();
                if (TextUtils.isDigitsOnly(pic)) {
                    imgvPic.setImageResource(Integer.parseInt(pic));
                } else {
                    Glide.with(this).load(pic).into(imgvPic);
                }

            }
//            llMore.setVisibility(View.VISIBLE);
        } else if (position == 3) {
            if (id == -1) {
                tvTitle.setText("添加美食");
            } else {
                tvTitle.setText("修改美食");

                FoodBean bean = DataSupport.where("id=?", String.valueOf(id)).findFirst(FoodBean.class);
                edtTitle.setText(bean.getName());
                edtprice.setText(String.valueOf(bean.getPrice()));
                edtStar.setText(bean.getStar());
                edtLocation.setText(bean.getLocation());
                pic = bean.getPic();
                if (TextUtils.isDigitsOnly(pic)) {
                    imgvPic.setImageResource(Integer.parseInt(pic));
                } else {
                    Glide.with(this).load(pic).into(imgvPic);
                }
            }
//            llMore.setVisibility(View.GONE);
        } else if (position == 4) {
            if (id == -1) {
                tvTitle.setText("添加景点");
            } else {
                tvTitle.setText("修改景点");

                ScenicBean bean = DataSupport.where("id=?", String.valueOf(id)).findFirst(ScenicBean.class);
                edtTitle.setText(bean.getName());
                edtprice.setText(String.valueOf(bean.getPrice()));
                edtStar.setText(bean.getStar());
                edtLocation.setText(bean.getLocation());
                pic = bean.getPic();
                if (TextUtils.isDigitsOnly(pic)) {
                    imgvPic.setImageResource(Integer.parseInt(pic));
                } else {
                    Glide.with(this).load(pic).into(imgvPic);
                }
            }
//            llMore.setVisibility(View.GONE);
        }
    }


    @Override
    public void onEvent(EventMessage msg) {
        super.onEvent(msg);
        if (msg.getMessageType() == EventMessage.CHOICE_PIC) {
//            pic = (int) msg.getmObject();
//            imgvPic.setImageResource(pic);
        }
    }

    private void add() {
        String name = edtTitle.getText().toString();
        String price = edtprice.getText().toString();
        String star = edtStar.getText().toString();
        String location = edtLocation.getText().toString();
        if (StringUtil.isEmpty(name) || TextUtils.isEmpty(pic) || StringUtil.isEmpty(location) || StringUtil.isEmpty(price) || StringUtil.isEmpty(star)) {
            ToastUtil.showToast(this, "请完善信息");
            return;
        }

        if (position == 2) {
            HotelBean bean = new HotelBean();
            bean.setJ_id(System.currentTimeMillis() + "");
            bean.setName(name);
            bean.setPic(pic);
            bean.setPrice(Integer.parseInt(price));
            bean.setStar(star);
            bean.setLocation(location);
            if (id == -1) {
                bean.save();
            } else {
                bean.update(id);
            }


        } else if (position == 3) {
            FoodBean bean = new FoodBean();
            bean.setF_id(System.currentTimeMillis() + "");
            bean.setName(name);
            bean.setPic(pic);
            bean.setPrice(Integer.parseInt(price));
            bean.setStar(star);
            bean.setLocation(location);
            bean.save();
            if (id == -1) {
                bean.save();
            } else {
                bean.update(id);
            }

        } else if (position == 4) {
            ScenicBean bean = new ScenicBean();
            bean.setL_id(System.currentTimeMillis() + "");
            bean.setName(name);
            bean.setPic(pic);
            bean.setPrice(Integer.parseInt(price));
            bean.setStar(star);
            bean.setLocation(location);
            bean.save();
            if (id == -1) {
                bean.save();
            } else {
                bean.update(id);
            }
        }


        ToastUtil.showToast(this, "添加成功");
        EventBus.getDefault().post(new EventMessage(EventMessage.Refresh, position));
        onBackPressed();
    }

    @OnClick({R.id.imgv_return, R.id.imgv_pic, R.id.tv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgv_return:
                onBackPressed();
                break;
            case R.id.imgv_pic:
//                showActivity(this, ImageListActivity.class);
                EasyPhotos.createAlbum(this, true, GlideEngine.getInstance())//参数说明：上下文，是否显示相机按钮，[配置Glide为图片加载引擎](https://github.com/HuanTanSheng/EasyPhotos/wiki/12-%E9%85%8D%E7%BD%AEImageEngine%EF%BC%8C%E6%94%AF%E6%8C%81%E6%89%80%E6%9C%89%E5%9B%BE%E7%89%87%E5%8A%A0%E8%BD%BD%E5%BA%93)
                        .setFileProviderAuthority(getPackageName()+".fileProvider")//参数说明：见下方`FileProvider的配置`
                        .start(new SelectCallback() {
                            @Override
                            public void onResult(ArrayList<Photo> photos, ArrayList<String> paths, boolean isOriginal) {

                                pic = paths.get(0);
                                Glide.with(AddActivity.this).load(pic).into(imgvPic);
                            }
                        });
                break;
            case R.id.tv_add:
                add();
                break;
        }
    }
}
