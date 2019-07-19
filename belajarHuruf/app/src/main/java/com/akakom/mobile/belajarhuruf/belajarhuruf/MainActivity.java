package com.akakom.mobile.belajarhuruf.belajarhuruf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.akakom.mobile.belajarhuruf.R;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvDaftarHuruf;
    int[] arrayIconHuruf;
    int[] arrayAudioHuruf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // isi variable
        arrayIconHuruf = getResources().getIntArray(R.array.icon_huruf);
        arrayAudioHuruf = getResources().getIntArray(R.array.audio_huruf);

        // hubungkan ke widget
        rvDaftarHuruf = findViewById(R.id.rvDaftarHuruf);

        // banyak kolom tiap baris
        int numberOfColumns = 3;

        // atur bentuk layout
        rvDaftarHuruf.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

        AdapterHuruf adapter = new AdapterHuruf(this, arrayIconHuruf, arrayAudioHuruf);
        // atur adapter
        rvDaftarHuruf.setAdapter(adapter);
    }
}
