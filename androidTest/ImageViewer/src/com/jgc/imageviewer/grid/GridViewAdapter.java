package com.jgc.imageviewer.grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.jgc.imageviewer.AnimationFactory;
import com.jgc.imageviewer.ImgDownloadThread;
import com.jgc.imageviewer.R;

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
        AnimationSet set = AnimationFactory.getAnimationSet(AnimationFactory.GRID_VIEW);
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.grid_item, null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.img_grid_item);
            ImgDownloadThread thread = new ImgDownloadThread(mContext, holder.img);
            thread.execute(mUrls[position]);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        convertView.startAnimation(set);
        return convertView;
    }

    private class ViewHolder {
        public ImageView img = null;
    }
}
