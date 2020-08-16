package com.app.demo.adapters;

import android.content.Context;
import android.widget.TextView;

import com.app.demo.R;
import com.app.shop.mylibrary.base.CommonAdapter;
import com.app.shop.mylibrary.base.ViewHolder;

import java.util.ArrayList;


/**
 * @anthor : 大海
 * 每天进步一点点
 */


public class NearChildAdapter extends CommonAdapter {

    public NearChildAdapter(Context context, ArrayList datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void setView(ViewHolder holder, Object o, int position) {
        String bean = (String) o;
        TextView textView = holder.getView(R.id.tv_name_item);
        textView.setText(bean);
    }
}
