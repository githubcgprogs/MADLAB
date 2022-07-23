package com.example.wallpaperchanges;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    boolean running;
    int[] ia = new int[]{R.drawable.img3, R.drawable.img1,R.drawable.img2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!running)
            new Timer().schedule(new MyTimer(), 0, 1000);
        running = true;
    }

    private class MyTimer extends TimerTask {
        @Override
        public void run() {
            try {
                WallpaperManager wallpaperManager;
                wallpaperManager = WallpaperManager.getInstance(getBaseContext());
                Random random = new Random();
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(), ia[random.nextInt(3)]));
            } catch (IOException ignored) {


            }
        }
    }
}
