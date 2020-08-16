package com.app.demo.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.app.demo.R;
import com.app.demo.activitys.LoginActivity;
import com.app.demo.activitys.PassWordResetActivity;
import com.app.demo.activitys.SelfActivity;
import com.app.demo.utils.GlideEngine;
import com.app.shop.mylibrary.base.BaseFragment;
import com.app.shop.mylibrary.beans.EventMessage;
import com.app.shop.mylibrary.utils.DialogUtil;
import com.app.shop.mylibrary.utils.SharedPreferencesUtil;
import com.app.shop.mylibrary.utils.UserManager;
import com.app.shop.mylibrary.widgts.CustomDialog;
import com.bumptech.glide.Glide;
import com.huantansheng.easyphotos.EasyPhotos;
import com.huantansheng.easyphotos.callback.SelectCallback;
import com.huantansheng.easyphotos.models.album.entity.Photo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {
    @BindView(R.id.tv_username_mine)
    TextView tvUsernameMine;

    @BindView(R.id.rela_self)
    RelativeLayout rela_self;
    @BindView(R.id.rela_pwd_reset)
    RelativeLayout rela_pwd_reset;
    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;


    private String dialog_title = "退出登录";
    private String dialog_content = "是否确定退出登录？";
    private CustomDialog customDialog;
    int user_type;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_5, container, false);
        ButterKnife.bind(this, view);
        registerEventBus();
        setSelfView();
        return view;
    }

    private void setSelfView() {
        user_type = UserManager.getUserType(getActivity());
        if (user_type == 0) {
            tvUsernameMine.setText(UserManager.getUserName(getActivity()));
            rela_self.setVisibility(View.VISIBLE);
            rela_pwd_reset.setVisibility(View.VISIBLE);
        } else {
            tvUsernameMine.setText("管理员");
            rela_self.setVisibility(View.GONE);
            rela_pwd_reset.setVisibility(View.GONE);
        }


        int userId = SharedPreferencesUtil.getData(getActivity(), "user", "id", -1);
        String avatar = SharedPreferencesUtil.get(getActivity(), "avatar_" + userId, "").toString();
        if (!TextUtils.isEmpty(avatar)) {
            Glide.with(getActivity()).load(avatar).into(ivAvatar);
        }
    }

    @Override
    public void onEvent(EventMessage msg) {
        super.onEvent(msg);

        if (msg.getMessageType() == EventMessage.Refresh) {
            setSelfView();
        }
    }


    @OnClick({R.id.rela_self, R.id.rela_pwd_reset, R.id.rela_logout, R.id.iv_avatar})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.rela_self: //个人信息
                skipActivity(getActivity(), SelfActivity.class);
                break;

            case R.id.rela_pwd_reset:
                skipActivity(getActivity(), PassWordResetActivity.class);
                break;

            case R.id.rela_logout:
                Logout();
                break;

            case R.id.iv_avatar:
//                showActivity(this, ImageListActivity.class);
                EasyPhotos.createAlbum(this, true, GlideEngine.getInstance())//参数说明：上下文，是否显示相机按钮，[配置Glide为图片加载引擎](https://github.com/HuanTanSheng/EasyPhotos/wiki/12-%E9%85%8D%E7%BD%AEImageEngine%EF%BC%8C%E6%94%AF%E6%8C%81%E6%89%80%E6%9C%89%E5%9B%BE%E7%89%87%E5%8A%A0%E8%BD%BD%E5%BA%93)
                        .setFileProviderAuthority(getActivity().getPackageName() + ".fileProvider")//参数说明：见下方`FileProvider的配置`
                        .start(new SelectCallback() {
                            @Override
                            public void onResult(ArrayList<Photo> photos, ArrayList<String> paths, boolean isOriginal) {

                                String avatar = paths.get(0);
                                Glide.with(getActivity()).load(avatar).into(ivAvatar);

                                int userId = SharedPreferencesUtil.getData(getActivity(), "user", "id", -1);
                                SharedPreferencesUtil.put(getActivity(), "avatar_" + userId, avatar);
                            }
                        });
                break;
        }
    }

    private void Logout() {
        customDialog = DialogUtil.showDialog(getActivity(), customDialog, 2, dialog_title, dialog_content, "取消", "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                SharedPreferencesUtil.removeAll(getContext(), "user");
                skipActivity(getActivity(), LoginActivity.class);
                getActivity().finish();
            }
        });

        if (customDialog != null && !customDialog.isShowing()) {
            customDialog.show();
        }


        customDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                customDialog = null;
            }
        });
    }

}
