package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;

public class ImageRoute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_route);

        Intent i = getIntent();
        int index = i.getIntExtra("com.example.myapplication.ItemIndex", -1);

        if (index > -1) {
            int pic = getImg(index);
            ImageView img = findViewById(R.id.imageView);
            scaleImg(img, pic);
        }
    }

    private int getImg(int index) {
        switch (index) {
            case 0: return R.drawable.peach;
            case 1: return R.drawable.tomato;
            case 2: return R.drawable.squash;
            default: return -1;
        }
    }

    private void scaleImg(ImageView img, int pic) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        Display screenSize = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        //deterime the size of the passed down image
        int imgWidth = options.outWidth;
        int screenWidth = screenSize.getWidth();
        Log.d("screen width: ", screenWidth + "");

        if (imgWidth > screenWidth) {
            int ratio = Math.round( (float) imgWidth/ (float) screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);
    }

}