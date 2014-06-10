
package com.example.test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private Bitmap mBitmap = null;
    private ImageView mImageView = null;
    private WebImageDisplayer mDisplayer = null;
    private ViewPager mViewPager = null;
    private List<Bitmap> mBitmapMap = null;

    public static String[] IMAGE_URLS = {
            "http://hiphotos.baidu.com/baidu/pic/item/7d8aebfebf3f9e125c6008d8.jpg",
            "http://image.550990.com/upload/photo/00/15/42/59/154259.jpg",
            "http://info-database.csdn.net/Upload/2014-06-05/20140606php.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.imageView1);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mDisplayer = new WebImageDisplayer();
        mBitmapMap = new ArrayList<Bitmap>();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < IMAGE_URLS.length; i ++) {
                    mBitmap = mDisplayer.getBitMap(IMAGE_URLS[i]);
                    mHandler.sendEmptyMessage(0);
                    mBitmapMap.add(mBitmap);
                }
                mHandler.sendEmptyMessage(1);
                super.run();
            }
        }.start();
    }

    public Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0:
                    mImageView.setImageBitmap(mBitmap);
                    break;
                case 1:
                    initViewPager();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private void initViewPager() {
        List<ImageView> viewList = new ArrayList<ImageView>();
        for (int i = 0; i < mBitmapMap.size(); i ++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(mBitmapMap.get(i));
            viewList.add(imageView);
        }
        mViewPager.setAdapter(new MyPagerAdapter(viewList));
    }

}
