package com.dimen.navigationbardemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 文件名：com.dimen.navigationbardemo
 * 描    述：
 * 作    者：Dimen
 * 时    间：2020/7/30
 */
public class DefaultNavigationBar extends AbsNavigationBar<DefaultNavigationBar.Builder> {
    protected DefaultNavigationBar(Builder builder) {
        super(builder);
    }


    @Override
    public void attachNavigationBarParams() {
        super.attachNavigationBarParams();

        TextView leftText = findViewById(R.id.tv_back);
        leftText.setVisibility(getBuilder().mLeftVisible);
    }

    /**
     * 导航栏的builder
     */

    public static class Builder extends AbsNavigationBar.Builder<DefaultNavigationBar.Builder> {

        public int mLeftVisible = View.VISIBLE;

        public Builder(Context context, ViewGroup parent) {
            super(context, R.layout.ui_default_navigation_bar, parent);
        }


        @Override
        public DefaultNavigationBar create() {
            return new DefaultNavigationBar(this);
        }

        public Builder setLeftText(String text) {
            setText(R.id.tv_back, text);
            return this;
        }

        public Builder setLeftOnclickListener(View.OnClickListener clickListener) {

            setOnclickListener(R.id.tv_back, clickListener);
            return this;
        }

        public Builder hideLeftText() {
            mLeftVisible = View.GONE;
            return this;
        }

        public Builder setRightText(String text) {
            setText(R.id.tv_wine, text);
            return this;
        }

        public Builder setRightOnClickListener(View.OnClickListener clickListener) {
            setOnclickListener(R.id.tv_wine, clickListener);
            return this;
        }
    }
}
