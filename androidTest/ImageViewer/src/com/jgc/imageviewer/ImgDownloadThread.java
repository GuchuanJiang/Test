package com.jgc.imageviewer;

import java.lang.ref.WeakReference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImgDownloadThread extends AsyncTask<String, Float, WeakReference<Bitmap>>{

    private ImageView mImageView =  null;
    private Context mContext = null;

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
    protected WeakReference<Bitmap> doInBackground(String... arg0) {

        WeakReference<Bitmap> bitmapReference = null;
        Bitmap bitmap = null;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.test);
        bitmapReference = new WeakReference<Bitmap>(bitmap);
        return bitmapReference;
    }

//  HttpGet get = new HttpGet("http://www.baidu.com");
//  HttpClient client = new DefaultHttpClient();
//  try {
//      HttpResponse  response = client.execute(get);
//      HttpEntity entity = response.getEntity();
//      InputStream inputStream = entity.getContent();
//      Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//  } catch (ClientProtocolException e) {
//      e.printStackTrace();
//  } catch (IOException e) {
//      e.printStackTrace();
//  }
}
