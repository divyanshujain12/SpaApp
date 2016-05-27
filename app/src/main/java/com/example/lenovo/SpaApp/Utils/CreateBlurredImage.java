package com.example.lenovo.SpaApp.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * Created by Lenovo on 23-03-2016.
 */
public class CreateBlurredImage extends AsyncTask<Bitmap, Void, Bitmap> {

    ImageView image = null;
    BitmapDrawable drawable = null;
    CommonFunctions commonFunctions;
    String resource;
    LruBitmapCache memoryCache = new LruBitmapCache();

    public CreateBlurredImage(Context context, ImageView imageView, int resource) {
        image = imageView;
        drawable = (BitmapDrawable) context.getResources().getDrawable(resource);
        commonFunctions = new CommonFunctions(context);
        this.resource = String.valueOf(resource);

    }

    @Override
    protected Bitmap doInBackground(Bitmap... bitmaps) {
        Bitmap blurred = memoryCache.getBitmap(resource);

        if (blurred != null)
            return blurred;
        else {
            Bitmap bitmap = drawable.getBitmap();
            blurred = commonFunctions.blurRenderScript(bitmap, 20);//second parametre is radius
            memoryCache.putBitmap(resource, blurred);
        }
        return blurred;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        image.setImageBitmap(bitmap);
    }
}