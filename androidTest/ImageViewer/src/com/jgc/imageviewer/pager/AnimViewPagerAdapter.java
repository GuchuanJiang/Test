package com.jgc.imageviewer.pager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

import com.jgc.imageviewer.ImgDownloadThread;

public class AnimViewPagerAdapter extends PagerAdapter {

    private String[] mUrls = null;
    private Context mContext = null;
    private AnimViewPager mViewPager = null;

    public AnimViewPagerAdapter(Context context) {
        this.mContext = context;
    }

    public AnimViewPagerAdapter(Context context, String[] urls) {
        this.mUrls = urls;
        this.mContext = context;
    }

    public AnimViewPagerAdapter(Context context, String[] urls, AnimViewPager viewPager) {
        this.mUrls = urls;
        this.mContext = context;
        this.mViewPager = viewPager;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView imageView = new ImageView(mContext);
        ImgDownloadThread imgDownloadThread = new ImgDownloadThread(mContext, imageView);
        imgDownloadThread.execute(mUrls);
        ((ViewPager) container).addView(imageView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        mViewPager.setObjectForPosition(imageView, position);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object obj) {
        container.removeView(mViewPager.findViewFromObject(position));
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
