package com.jgc.imageviewer.pager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.jgc.imageviewer.AddressUtils;
import com.jgc.imageviewer.R;

public class ViewPagerImageViewerActivity extends Activity {

    private ViewPager mViewPager = null;
    private ViewPagerAdapter mAdapter = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_viewer_pager);

        mViewPager = (ViewPager) findViewById(R.id.vp_img_viewer);

        List<ImageView> imageViewList = new ArrayList<ImageView>();
        for (int i = 0; i < AddressUtils.getImgAddresses().length; i ++) {
            ImageView imageView = new ImageView(this);
            imageViewList.add(imageView);
        }
        mAdapter = new ViewPagerAdapter(this, imageViewList, AddressUtils.getImgAddresses());
        mViewPager.setAdapter(mAdapter);
    }

}
