package com.jgc.imageviewer.pager;

import android.app.Activity;
import android.os.Bundle;

import com.jgc.imageviewer.AddressUtils;
import com.jgc.imageviewer.R;
import com.jgc.imageviewer.pager.AnimViewPager.TransitionEffect;

public class ViewPagerImageViewerActivity extends Activity {

    private AnimViewPager mViewPager = null;
    private AnimViewPagerAdapter mAdapter = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_viewer_pager);

        mViewPager = (AnimViewPager) findViewById(R.id.vp_img_viewer);

        mAdapter = new AnimViewPagerAdapter(this, AddressUtils.getImgAddresses(), mViewPager);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setTransitionEffect(TransitionEffect.CubeOut);
    }
}
