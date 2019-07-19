package com.edy.inspiron.pbm_uas;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;

public class MainActivity extends AppCompatActivity {
    Button btn_huruf;
    Button btn_angka;
    MediaPlayer audioBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Memanggil file my_sound pada folder raw
        audioBackground = MediaPlayer.create(this, R.raw.backg_audio);
        //Set looping ke true untuk mengulang audio jika telah selesai
        audioBackground.setLooping(true);
        //Set volume audio agar berbunyi
        audioBackground.setVolume(1,1);
        //Memulai audio
        audioBackground.start();

        btn_huruf = (Button)findViewById(R.id.btn_huruf);
        btn_huruf.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent ihuruf = new Intent(MainActivity.this, HurufActivity.class);
                startActivity(ihuruf);

            }
        });
        btn_angka = (Button)findViewById(R.id.btn_angka);

        btn_angka.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent iangka = new Intent(MainActivity.this, AngkaActivity.class);
                startActivity(iangka);

            }
        });
    }
}