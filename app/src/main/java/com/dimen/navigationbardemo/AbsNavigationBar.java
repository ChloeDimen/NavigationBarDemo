package com.dimen.navigationbardemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件名：com.dimen.navigationbardemo
 * 描    述：这个是导航栏的基类
 * 作    者：Dimen
 * 时    间：2020/7/30
 */
public class AbsNavigationBar<T extends AbsNavigationBar.Builder> implements INavigationBar {
    private T mBuilder;
    private View mNavigationBar;

    protected AbsNavigationBar(T builder) {
        mBuilder = builder;
        createNavigationBar();
    }

    @Override
    public void createNavigationBar() {
        mNavigationBar = LayoutInflater.from(mBuilder.mContext).inflate(mBuilder.mLayoutId, mBuilder.mParent, false);

        attachParent(mNavigationBar, mBuilder.mParent);
        //绑定参数
        attachNavigationBarParams();


    }

    @Override
    public void attachNavigationBarParams() {

        Map<Integer, CharSequence> textMaps = mBuilder.mCharSequenceMap;

        //设置文本
        for (Map.Entry<Integer, CharSequence> entry : textMaps.entrySet()) {
            TextView textView = findViewById(entry.getKey());
            textView.setText(entry.getValue());

        }
        //设置点击事件
        Map<Integer, View.OnClickListener> onClickListenerMaps = mBuilder.mClickListenerMap;
        for (Map.Entry<Integer, View.OnClickListener> entry : onClickListenerMaps.entrySet()) {
            View view= findViewById(entry.getKey());
            view.setOnClickListener(entry.getValue());
        }
    }

    public <T extends View> T findViewById(int viewId) {
        return mNavigationBar.findViewById(viewId);
    }

    //将navigationbar添加到父布局
    @Override
    public void attachParent(View navigationBar, ViewGroup parent) {
        parent.addView(navigationBar, 0);

    }


    public T getBuilder() {
        return mBuilder;
    }

    /**
     * Builder构建类，构建NavigationBar和存储参数
     */

    public static abstract class Builder<T extends Builder> {
        public Context mContext;
        public int mLayoutId;
        public ViewGroup mParent;

        public Map<Integer, CharSequence> mCharSequenceMap;
        public Map<Integer, View.OnClickListener> mClickListenerMap;

        public Builder(Context context, int layoutId, ViewGroup parent) {
            mContext = context;
            mLayoutId = layoutId;
            mParent = parent;
            mCharSequenceMap = new HashMap<>();
            mClickListenerMap = new HashMap<>();


        }


        /**
         * 用来创建NavigationBar
         *
         * @return
         */
        public abstract AbsNavigationBar create();


        public T setText(int viewId, String text) {
            mCharSequenceMap.put(viewId, text);
            return (T) this;
        }

        public T setOnclickListener(int viewId, View.OnClickListener clickListener) {
            mClickListenerMap.put(viewId, clickListener);
            return (T) this;
        }
    }
}
