
package com.jgc.imageviewer.list;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.jgc.imageviewer.AddressUtils;
import com.jgc.imageviewer.R;

public class ListImageViewerActivity extends Activity {

    private ListView mListView = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_viewer_list);

        mListView = (ListView) findViewById(R.id.list_view);

        ListViewAdapter adapter = new ListViewAdapter(this, AddressUtils.getImgAddresses());
        mListView.setAdapter(adapter);
    }
}
