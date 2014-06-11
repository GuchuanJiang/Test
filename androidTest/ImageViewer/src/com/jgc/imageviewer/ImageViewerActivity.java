
package com.jgc.imageviewer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ImageViewerActivity extends Activity {

    public final static String[] IMAGE_URLS = {
        "http://e.hiphotos.baidu.com/super/whfpf%3D425%2C260%2C50/sign=e8b1a1ec31fa828bd176cea39b227506/faf2b2119313b07e9e0f75e10ed7912396dd8cac.jpg",
        "http://b.hiphotos.baidu.com/super/whfpf%3D425%2C260%2C50/sign=db32a8c7aad3fd1f365cf17a5673112d/b17eca8065380cd7c89a9904a344ad3458828156.jpg",
        "http://a.hiphotos.baidu.com/super/whfpf%3D425%2C260%2C50/sign=1f574f708026cffc697fecf2df3c7ea2/fc1f4134970a304e8d0d9913d3c8a786c9175c2f.jpg",
        "http://c.hiphotos.baidu.com/super/whfpf%3D425%2C260%2C50/sign=e57795f60508283868588f54dea49d33/fd039245d688d43f459caf1b7f1ed21b0ef43b25.jpg",
        "http://e.hiphotos.baidu.com/super/whfpf%3D425%2C260%2C50/sign=c31423e11d30e924cff1cf712a355a34/d788d43f8794a4c2b902d9c20cf41bd5ad6e3931.jpg"
    };

    private ListView mListView = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_viewer_main);

        mListView = (ListView) findViewById(R.id.list_view);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this, IMAGE_URLS);
        mListView.setAdapter(adapter);
    }
}
