package com.example.emergency;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageR extends AppCompatActivity {
    private ImageView imageView;
    private Button play;
    private Button stop;
    private MediaPlayer media;
    private int raw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_r);
        imageView = findViewById(R.id.gallery1);
        play = findViewById(R.id.play);
        stop = findViewById(R.id.stop);
        String name = getIntent().getStringExtra("title");
        int picture = getIntent().getIntExtra("picture", -1);
        raw = getIntent().getIntExtra("sound", -1);
        setTitle(name);
        imageView.setImageResource(picture);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (media == null) {
                    media = MediaPlayer.create(ImageR.this, raw);
                    media.start();
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                media.stop();
                media = null;
            }
        });


    }
}