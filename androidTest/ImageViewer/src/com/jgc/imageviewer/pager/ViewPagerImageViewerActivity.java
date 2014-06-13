package com.jgc.imageviewer.pager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

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

        List<ImageView> imageViewList = new ArrayList<ImageView>();
        for (int i = 0; i < AddressUtils.getImgAddresses().length; i ++) {
            ImageView imageView = new ImageView(this);
            imageViewList.add(imageView);
        }
        mAdapter = new AnimViewPagerAdapter(this, imageViewList, AddressUtils.getImgAddresses());
        mViewPager.setTransitionEffect(TransitionEffect.CubeOut);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setTransitionEffect(TransitionEffect.CubeOut);
    }
}
