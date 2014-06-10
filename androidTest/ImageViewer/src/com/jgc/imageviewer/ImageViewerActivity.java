
package com.jgc.imageviewer;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

public class ImageViewerActivity extends Activity {

    private ListView mListView = null;
    private List<Bitmap> mDataList = new ArrayList<Bitmap>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_viewer_main);

        mListView = (ListView) findViewById(R.id.list_view);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        for(int i = 0; i < 10; i ++) {
            mDataList.add(bitmap);
        }
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, mDataList);
        mListView.setAdapter(adapter);
    }
}
