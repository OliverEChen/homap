package com.app.demo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.demo.R;
import com.app.demo.activitys.AddActivity;
import com.app.demo.activitys.SearchActivity;
import com.app.demo.adapters.FoodListAdapter;
import com.app.demo.adapters.HotelListAdapter;
import com.app.demo.adapters.ScenicListAdapter;
import com.app.demo.beans.FoodBean;
import com.app.demo.beans.HotelBean;
import com.app.demo.beans.ScenicBean;
import com.app.demo.utils.DataBaseUtil;
import com.app.shop.mylibrary.base.BaseFragment;
import com.app.shop.mylibrary.beans.EventMessage;
import com.app.shop.mylibrary.utils.UserManager;
import com.chad.library.adapter.base.BaseQuickAdapter;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends BaseFragment {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recy)
    RecyclerView recy;

    @BindView(R.id.imgv_return)
    ImageView imgvReturn;
    @BindView(R.id.tv_title_right)
    TextView tvTitleRight;

    int position;
    Bundle bundle;
    List<HotelBean> list_jd = new ArrayList<>();
    List<FoodBean> list_food = new ArrayList<>();
    List<ScenicBean> list_ly = new ArrayList<>();
    HotelListAdapter adapter_jd;
    FoodListAdapter adapter_food;
    ScenicListAdapter adapter_ly;
    View empty;
    int user_type;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        ButterKnife.bind(this, view);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        imgvReturn.setVisibility(View.GONE);

        bundle = getArguments();
        position = bundle.getInt("position");

        empty = LayoutInflater.from(getActivity()).inflate(R.layout.view_list_empty, null);
        initData();
        return view;
    }

    private void initData() {
        user_type = UserManager.getUserType(getActivity());
        if (user_type == 0) {
            tvTitleRight.setVisibility(View.INVISIBLE);
        } else {
            tvTitleRight.setVisibility(View.VISIBLE);
            tvTitleRight.setText("添加");
        }
        if (position == 2) { //酒店
            tvTitle.setText("酒店查询");
            list_jd = DataBaseUtil.getAllHotel();

            adapter_jd = new HotelListAdapter(R.layout.item_jd_list_message, list_jd, user_type);
            recy.setLayoutManager(new LinearLayoutManager(getActivity()));
            recy.setAdapter(adapter_jd);
            adapter_jd.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int index) {

                    if (view.getId() == R.id.tv_del_item) {
                        del(position, index);
                    } else if (view.getId() == R.id.tv_edit_item) {
                        edit(position, index);
                    }
                }
            });
        } else if (position == 3) { //美食
            tvTitle.setText("美食查询");
            list_food = DataBaseUtil.getAllFood();

            adapter_food = new FoodListAdapter(R.layout.item_jd_list_message, list_food, user_type);
            recy.setLayoutManager(new LinearLayoutManager(getActivity()));
            recy.setAdapter(adapter_food);
            adapter_food.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int index) {
                    if (view.getId() == R.id.tv_del_item) {
                        del(position, index);
                    } else if (view.getId() == R.id.tv_edit_item) {
                        edit(position, index);
                    }
                }
            });

        } else if (position == 4) { //旅游
            tvTitle.setText("景点查询");
            list_ly = DataBaseUtil.getAllScenic();

            adapter_ly = new ScenicListAdapter(R.layout.item_jd_list_message, list_ly, user_type);
            recy.setLayoutManager(new LinearLayoutManager(getActivity()));
            recy.setAdapter(adapter_ly);
            adapter_ly.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int index) {
                    if (view.getId() == R.id.tv_del_item) {
                        del(position, index);
                    } else if (view.getId() == R.id.tv_edit_item) {
                        edit(position, index);
                    }
                }
            });
        }
    }

    private void del(int position, int index) {
        if (position == 2) {
            DataSupport.deleteAll(HotelBean.class, "j_id=?", list_jd.get(index).getJ_id());
            list_jd.remove(index);
            adapter_jd.notifyDataSetChanged();
        } else if (position == 3) {
            DataSupport.deleteAll(FoodBean.class, "f_id=?", list_food.get(index).getF_id());
            list_food.remove(index);
            adapter_food.notifyDataSetChanged();
        } else if (position == 4) {
            DataSupport.deleteAll(ScenicBean.class, "l_id=?", list_ly.get(index).getL_id());
            list_ly.remove(index);
            adapter_ly.notifyDataSetChanged();
        }
    }


    private void edit(int position, int index) {
        if (position == 2) {
            bundle.putInt("id", list_jd.get(index).getId());
            skipActivity(getActivity(), AddActivity.class, bundle);
        } else if (position == 3) {
            bundle.putInt("id", list_food.get(index).getId());
            skipActivity(getActivity(), AddActivity.class, bundle);
        } else if (position == 4) {
            bundle.putInt("id", list_ly.get(index).getId());
            skipActivity(getActivity(), AddActivity.class, bundle);
        }
    }


    @Override
    public void onEvent(EventMessage msg) {
        super.onEvent(msg);
        if (msg.getMessageType() == EventMessage.Refresh) {
            initData();
        }
    }

    @OnClick({R.id.tv_title_right, R.id.tv_search, R.id.btn_refresh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_title_right:
                bundle.putInt("id", -1);
                skipActivity(getActivity(), AddActivity.class, bundle);
                break;

            case R.id.tv_search:
                skipActivity(getActivity(), SearchActivity.class, bundle);
                break;

            case R.id.btn_refresh:

                initData();

                break;
        }
    }
}
