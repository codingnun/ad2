package com.example.mediaplayer;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button b1,b2,b3;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MediaPlayer m=new MediaPlayer();
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        m.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String apath="android.resource://"+getPackageName()+"/raw/example";

        //String online="C:\\Users\\User\\Desktop\\document\\audio.mp3";
        Uri ad=Uri.parse(apath);
        //Uri adonline=Uri.parse(online);
        try {
            m.setDataSource(this,ad);
            m.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.pause();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.pause();
                m.seekTo(0);
            }
        });

    }
}