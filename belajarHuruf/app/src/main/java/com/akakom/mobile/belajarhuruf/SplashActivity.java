package com.akakom.mobile.belajarhuruf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.akakom.mobile.belajarhuruf.belajarhuruf.MainActivity;
import com.akakom.mobile.belajarhuruf.kuis.HighestScoreActivity;
import com.akakom.mobile.belajarhuruf.kuis.QuizActivity;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnBelajarHuruf, btnBelajarKuis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        btnBelajarHuruf = findViewById(R.id.btn_belajar_huruf);
        btnBelajarKuis = findViewById(R.id.btn_kuis);

        btnBelajarHuruf.setOnClickListener(this);
        btnBelajarKuis.setOnClickListener(this);

        /*Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // pindah ke main activity
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        }, 1500);*/
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_belajar_huruf:
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.btn_kuis:
                Intent j = new Intent(SplashActivity.this, QuizActivity.class);
                startActivity(j);
                break;
        }
    }
}
