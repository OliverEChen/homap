package com.app.demo.activitys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.demo.R;
import com.app.demo.adapters.FoodListAdapter;
import com.app.demo.adapters.HotelListAdapter;
import com.app.demo.adapters.ScenicListAdapter;
import com.app.demo.beans.FoodBean;
import com.app.demo.beans.HotelBean;
import com.app.demo.beans.ScenicBean;
import com.app.demo.utils.DataBaseUtil;
import com.app.shop.mylibrary.base.BaseActivity;
import com.app.shop.mylibrary.beans.EventMessage;
import com.app.shop.mylibrary.utils.StringUtil;
import com.app.shop.mylibrary.utils.UserManager;
import com.chad.library.adapter.base.BaseQuickAdapter;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class SearchActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.edt_content)
    EditText edtContent;
    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.rbtn_name)
    RadioButton rbtnName;
    @BindView(R.id.rbtn_location)
    RadioButton rbtnLocation;
    @BindView(R.id.sp_price)
    Spinner spPrice;
    @BindView(R.id.sp_star)
    Spinner spStar;
    private int position;
    int user_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
        ButterKnife.bind(this);
        tvTitle.setText("查询");
        Bundle bundle = getIntent().getExtras();
        position = bundle.getInt("position", 0);
        user_type = UserManager.getUserType(SearchActivity.this);

    }

    private void search() {
        recy.setVisibility(View.VISIBLE);
        String content = edtContent.getText().toString();
        StringBuffer sb = new StringBuffer();
        if (!StringUtil.isEmpty(content)) {
            if (rbtnLocation.isChecked()) {
                sb.append("and location like '%").append(content).append("%'").append(" ");
            } else {
                sb.append("and name like '%").append(content).append("%'").append(" ");
            }
        }

        switch (spPrice.getSelectedItemPosition()) {
            case 1:
                sb.append("and price<50").append(" ");
                break;
            case 2:
                sb.append("and price>=50 and price <100").append(" ");
                break;
            case 3:
                sb.append("and price>=100 and price <300").append(" ");
                break;
            case 4:
                sb.append("and price>=300").append(" ");
                break;
        }

        switch (spStar.getSelectedItemPosition()) {
            case 1:
                sb.append("and star=1").append(" ");
                break;
            case 2:
                sb.append("and star=2").append(" ");
                break;
            case 3:
                sb.append("and star=3").append(" ");
                break;
            case 4:
                sb.append("and star=4").append(" ");
                break;
            case 5:
                sb.append("and star=5").append(" ");
                break;
        }


        View empty_view = LayoutInflater.from(this).inflate(R.layout.view_list_empty, null);
        recy.setLayoutManager(new LinearLayoutManager(this));
        if (position == 2) {
            List<HotelBean> list = DataBaseUtil.searchHotel(sb.toString());

            HotelListAdapter adapter = new HotelListAdapter(R.layout.item_jd_list_message, list, user_type);
            adapter.setEmptyView(empty_view);
            recy.setAdapter(adapter);
            adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int index) {
                    DataSupport.deleteAll(HotelBean.class, "j_id=?", list.get(index).getJ_id());
                    list.remove(index);
                    adapter.notifyDataSetChanged();
                    EventBus.getDefault().post(new EventMessage(EventMessage.Refresh));
                }
            });
        } else if (position == 3) {

            List<FoodBean> list  = DataBaseUtil.searchFood(sb.toString());
            FoodListAdapter adapter = new FoodListAdapter(R.layout.item_jd_list_message, list, user_type);
            adapter.setEmptyView(empty_view);
            recy.setAdapter(adapter);
            adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int index) {
                    DataSupport.deleteAll(FoodBean.class, "f_id=?", list.get(index).getF_id());
                    list.remove(index);
                    adapter.notifyDataSetChanged();
                    EventBus.getDefault().post(new EventMessage(EventMessage.Refresh));
                }
            });
        } else if (position == 4) {
            List<ScenicBean> list = DataBaseUtil.searchScenic(sb.toString());
            ScenicListAdapter adapter = new ScenicListAdapter(R.layout.item_jd_list_message, list, user_type);
            adapter.setEmptyView(empty_view);
            recy.setAdapter(adapter);
            adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int index) {
                    DataSupport.deleteAll(ScenicBean.class, "l_id=?", list.get(index).getL_id());
                    list.remove(index);
                    adapter.notifyDataSetChanged();
                    EventBus.getDefault().post(new EventMessage(EventMessage.Refresh));
                }
            });
        }
    }


    @OnClick({R.id.imgv_return, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgv_return:
                onBackPressed();
                break;

            case R.id.tv_search:
                search();
                break;
        }
    }

    private void setButton() {
        edtContent.setText("");
        recy.setVisibility(View.GONE);

    }
}
