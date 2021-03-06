package com.app.demo.adapters;

import android.content.Context;
import android.widget.ImageView;

import com.app.demo.R;
import com.app.shop.mylibrary.base.CommonAdapter;
import com.app.shop.mylibrary.base.ViewHolder;

import java.util.ArrayList;

/**
 * @anthor : 大海
 */


public class GridAdapter extends CommonAdapter {

    public GridAdapter(Context context, ArrayList datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void setView(ViewHolder holder, Object o, int position) {
        int img = (int) o;
        ImageView imgv_item = holder.getView(R.id.imgv_item);
        imgv_item.setImageResource(img);
    }
}
