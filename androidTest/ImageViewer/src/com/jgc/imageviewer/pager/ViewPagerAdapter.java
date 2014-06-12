package com.jgc.imageviewer.pager;

import java.util.List;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.jgc.imageviewer.ImgDownloadThread;

public class ViewPagerAdapter extends PagerAdapter {

    private List<ImageView> mListViews = null;
    private String[] mUrls = null;
    private Context mContext = null;

    public ViewPagerAdapter(Context context, List<ImageView> viewList) {
        this.mListViews = viewList;
        this.mContext = context;
    }

    public ViewPagerAdapter(Context context, List<ImageView> viewList, String[] urls) {
        this.mListViews = viewList;
        this.mUrls = urls;
        this.mContext = context;
    }

    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView(mListViews.get(arg1));
    }

    @Override
    public void finishUpdate(View arg0) {
    }

    @Override
    public int getCount() {
        return mListViews.size();
    }

    @Override
    public Object instantiateItem(View arg0, int index) {
        ImgDownloadThread imgDownloadThread = new ImgDownloadThread(mContext, mListViews.get(index));
        imgDownloadThread.execute(mUrls);
        ((ViewPager) arg0).addView(mListViews.get(index), 0);
        return mListViews.get(index);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == (arg1);
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(View arg0) {
    }
}
