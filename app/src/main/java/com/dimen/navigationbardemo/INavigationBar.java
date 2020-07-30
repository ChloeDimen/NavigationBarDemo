package com.dimen.navigationbardemo;

import android.view.View;
import android.view.ViewGroup;

/**
 * 文件名：com.dimen.navigationbardemo
 * 描    述：头部规范
 * 作    者：Dimen
 * 时    间：2020/7/30
 */
public interface INavigationBar {
    void createNavigationBar();

    //绑定参数
    void attachNavigationBarParams();

    //将navigationbar添加到父布局
    void attachParent(View navigationBar, ViewGroup parent);


}
