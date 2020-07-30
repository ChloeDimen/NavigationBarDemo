package com.dimen.navigationbardemo;

import android.content.Context;
import android.view.ViewGroup;

/**
 * 文件名：com.dimen.navigationbardemo
 * 描    述：
 * 作    者：Dimen
 * 时    间：2020/7/30
 */
public class NavigationBar extends AbsNavigationBar {
    protected NavigationBar(Builder builder) {
        super(builder);
    }

    /**
     * 导航栏的builder
     */

    public static class Builder extends AbsNavigationBar.Builder<NavigationBar.Builder>{


        public Builder(Context context, int layoutId, ViewGroup parent) {
            super(context, layoutId, parent);
        }

        @Override
        public NavigationBar create() {
            return new NavigationBar(this);
        }
    }
}
