package com.app.demo.adapters;

import android.content.Context;
import android.widget.TextView;

import com.app.demo.R;
import com.app.demo.beans.FindLine;
import com.app.shop.mylibrary.base.CommonAdapter;
import com.app.shop.mylibrary.base.ViewHolder;

import java.util.ArrayList;


/**
 * @anthor : 大海
 * 每天进步一点点
 */


public class LineAdapter extends CommonAdapter {

    public LineAdapter(Context context, ArrayList datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void setView(ViewHolder holder, Object o, int position) {
        FindLine.ResultBean.ListBean bean = (FindLine.ResultBean.ListBean) o;
        TextView textView = holder.getView(R.id.tv_name_item);
        textView.setText(bean.getSequenceno() + "、" + bean.getStation());
    }
}
