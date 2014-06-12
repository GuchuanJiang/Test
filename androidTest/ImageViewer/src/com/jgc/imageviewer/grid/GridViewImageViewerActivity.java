package com.jgc.imageviewer.grid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.jgc.imageviewer.AddressUtils;
import com.jgc.imageviewer.R;

public class GridViewImageViewerActivity extends Activity {

    private GridView mGridView = null;
    private GridViewAdapter mAdapter = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_viewer_grid);

        mGridView = (GridView) findViewById(R.id.gv_img);
        mAdapter = new GridViewAdapter(this, AddressUtils.getImgAddresses());
        mGridView.setAdapter(mAdapter);
    }

}
