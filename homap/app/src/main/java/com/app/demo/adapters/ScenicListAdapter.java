package com.app.demo.adapters;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.app.demo.R;
import com.app.demo.beans.ScenicBean;
import com.app.shop.mylibrary.utils.StringUtil;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


/**
 * @anthor : 大海
 * 每天进步一点点
 */


public class ScenicListAdapter extends BaseQuickAdapter<ScenicBean, ScenicListAdapter.ViewHolder> {
    int user_type;
    public ScenicListAdapter(int layoutResId, @Nullable List<ScenicBean> data, int user_type) {
        super(layoutResId, data);
        this.user_type = user_type;
    }

    @Override
    protected void convert(ViewHolder helper, ScenicBean item) {

        helper.tv_name.setText(StringUtil.getContent(item.getName()));
        helper.tv_price.setText("门票：￥" + item.getPrice()+ "起");
        helper.tv_star.setText("推荐指数：" + item.getStar());
        helper.tv_location_item.setText("位置：" + item.getLocation());
        String pic = item.getPic();
        if (TextUtils.isDigitsOnly(pic)) {
            helper.pic_cover.setImageResource(Integer.parseInt(item.getPic()));
        } else {
            Glide.with(helper.itemView.getContext()).load(item.getPic()).into(helper.pic_cover);
        }
        helper.addOnClickListener(R.id.tv_del_item);
        helper.addOnClickListener(R.id.tv_edit_item);
        if (user_type==0){
            helper.tv_del_item.setVisibility(View.INVISIBLE);
            helper.tv_edit_item.setVisibility(View.INVISIBLE);
        }else {
            helper.tv_del_item.setVisibility(View.VISIBLE);
            helper.tv_edit_item.setVisibility(View.VISIBLE);
        }
    }


    public class ViewHolder extends BaseViewHolder {

        ImageView pic_cover;
        TextView tv_name;
        TextView tv_location_item;
        TextView tv_price;
        TextView tv_star;
        TextView tv_del_item;
        TextView tv_edit_item;

        public ViewHolder(View view) {
            super(view);
            pic_cover = view.findViewById(R.id.imgv_jd_item);
            tv_name = view.findViewById(R.id.tv_list_item);
            tv_location_item = view.findViewById(R.id.tv_location_item);
            tv_price = view.findViewById(R.id.tv_price_item);
            tv_star = view.findViewById(R.id.tv_star_item);
            tv_del_item = view.findViewById(R.id.tv_del_item);
            tv_edit_item = view.findViewById(R.id.tv_edit_item);
        }

    }
}
