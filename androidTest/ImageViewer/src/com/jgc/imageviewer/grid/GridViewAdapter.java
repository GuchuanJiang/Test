package com.jgc.imageviewer.grid;

import com.jgc.imageviewer.ImgDownloadThread;
import com.jgc.imageviewer.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridViewAdapter extends BaseAdapter {

    private LayoutInflater mInflater = null;
    private Context mContext = null;
    private String[] mUrls = null;

    public GridViewAdapter(Context context, String[] urls) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mUrls = urls;
    }

    @Override
    public int getCount() {
        return mUrls.length;
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.grid_item, null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.img_grid_item);
            ImgDownloadThread thread = new ImgDownloadThread(mContext, holder.img);
            thread.execute(mUrls[position]);
            convertView.setTag(holder);
        }
        return convertView;
    }

    private class ViewHolder {
        public ImageView img = null;
    }
}
