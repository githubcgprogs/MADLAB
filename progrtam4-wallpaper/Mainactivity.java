package com.example.changingwalpaperapplication;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    boolean running;
    int[] ia= new int[]{R.drawable.quote4,R.drawable.lotus, R.drawable.img1,R.drawable.img2,R.drawable.dandelion,
            R.drawable.dreams,R.drawable.blue,R.drawable.book,R.drawable.bouquet};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(!running){
            new Timer().schedule(new myTimer(),0,3000);
            running=true;
        }
    }

    private class myTimer extends TimerTask {

        @Override
        public void run() {
            try {
                WallpaperManager wallpaperManager=WallpaperManager.getInstance(getBaseContext());
                Random random=new Random();
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),ia[random.nextInt(5)]));
            }catch(IOException e) {}
        }
    }
}
