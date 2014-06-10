package com.jgc.imageviewer;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ViewPagerAdapter extends BaseAdapter {

    private List<Bitmap> mDataList = new ArrayList<Bitmap>();
    private LayoutInflater mInflater = null;
    private Context mContext = null;

    public ViewPagerAdapter(Context context, List<Bitmap> dataList) {
        this.mDataList = dataList;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int arg0) {
        return mDataList.get(0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.img_1);
            ImgDownloadThread thread = new ImgDownloadThread(holder.img);
            thread.execute();
            convertView.setTag(holder);
        }
        return convertView;
    }

    private class ViewHolder {
        public ImageView img = null;
    }
}
