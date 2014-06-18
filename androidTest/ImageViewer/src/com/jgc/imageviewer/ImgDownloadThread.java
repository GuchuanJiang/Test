package com.jgc.imageviewer;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImgDownloadThread extends AsyncTask<String, Float, WeakReference<Bitmap>>{

    @SuppressWarnings("unused")
    private Context mContext = null;
    private ImageView mImageView =  null;

    public ImgDownloadThread(ImageView imgView) {
        this.mImageView = imgView;
    }

    public ImgDownloadThread(Context context, ImageView imgView) {
        this.mContext = context;
        this.mImageView = imgView;
    }

    @Override
    protected void onPostExecute(WeakReference<Bitmap> result) {
        super.onPostExecute(result);
        mImageView.setImageBitmap(result.get());
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Float... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected WeakReference<Bitmap> doInBackground(String... url) {

        WeakReference<Bitmap> bitmapReference = null;
        Bitmap bitmap = null;
        HttpGet get = new HttpGet(url[0]);
        HttpClient client = new DefaultHttpClient();
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bitmapReference = new WeakReference<Bitmap>(bitmap);
        return bitmapReference;
    }
}
