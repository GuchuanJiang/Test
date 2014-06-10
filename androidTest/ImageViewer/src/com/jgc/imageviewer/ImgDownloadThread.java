package com.jgc.imageviewer;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImgDownloadThread extends AsyncTask<Void, Float, Bitmap>{

    private ImageView mImageView =  null;

    public ImgDownloadThread(ImageView imgView) {
        this.mImageView = imgView;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
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
    protected Bitmap doInBackground(Void... arg0) {

        new Thread() {

            @Override
            public void run() {
                try {
                    sleep(200);
                    mImageView.setImageResource(R.drawable.test);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        }.start();

        return null;
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
