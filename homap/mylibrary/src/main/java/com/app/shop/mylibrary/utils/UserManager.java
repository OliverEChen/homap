package com.app.shop.mylibrary.utils;

import android.content.Context;

/**
 * @anthor : 大海
 * 每天进步一点点
 * @time :   2019/12/26
 * @description :
 */


public class UserManager {


    /**
     * 判断用户是否登录
     *
     * @return
     */
    public static boolean isLogin(Context context) {

        int userId = SharedPreferencesUtil.getData(context, "user", "id", -1);

        return userId != -1;

    }


    public static String getUserName(Context context) {
        return SharedPreferencesUtil.getData(context, "user", "name", "");

    }


    public static int getUserHeadImg(Context context) {
        return SharedPreferencesUtil.getData(context, "user", "photo", 0);

    }


    public static int getUserType(Context context) {
        return SharedPreferencesUtil.getData(context, "user", "type", 0);

    }


    public static int getUserId(Context context) {
        return SharedPreferencesUtil.getData(context, "user", "id", -1);

    }


    public static String getMobile(Context context) {
        return SharedPreferencesUtil.getData(context, "user", "phone", "");

    }


}
