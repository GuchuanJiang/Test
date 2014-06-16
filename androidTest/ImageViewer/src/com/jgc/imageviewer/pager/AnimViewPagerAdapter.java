package com.jgc.imageviewer.pager;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jgc.imageviewer.ImgDownloadThread;

public class AnimViewPagerAdapter extends PagerAdapter {

    private List<ImageView> mListViews = null;
    private String[] mUrls = null;
    private Context mContext = null;
    private AnimViewPager mViewPager = null;

    public AnimViewPagerAdapter(Context context, List<ImageView> viewList) {
        this.mListViews = viewList;
        this.mContext = context;
    }

    public AnimViewPagerAdapter(Context context, List<ImageView> viewList, String[] urls) {
        this.mListViews = viewList;
        this.mUrls = urls;
        this.mContext = context;
    }

    public AnimViewPagerAdapter(Context context, List<ImageView> viewList, String[] urls, AnimViewPager viewPager) {
        this.mListViews = viewList;
        this.mUrls = urls;
        this.mContext = context;
        this.mViewPager = viewPager;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImgDownloadThread imgDownloadThread = new ImgDownloadThread(mContext, mListViews.get(position));
        imgDownloadThread.execute(mUrls);
        ((ViewPager) container).addView(mListViews.get(position), 0);
        mViewPager.setObjectForPosition(mListViews.get(position), position);
        return mListViews.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object obj) {
        container.removeView(mListViews.get(position));
    }

    @Override
    public int getCount() {
        return mUrls.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        if (view instanceof OutlineContainer) {
            return ((OutlineContainer) view).getChildAt(0) == obj;
        } else {
            return view == obj;
        }
    }
}
