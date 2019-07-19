package com.edy.inspiron.pbm_uas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class AngkaActivity extends AppCompatActivity {
    RecyclerView rvDaftarAngka;
    int[] arrayIconAngka;
    int[] arrayAudioAngka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angka);
        // isi variable
        arrayIconAngka = getResources().getIntArray(R.array.icon_angka);
        arrayAudioAngka = getResources().getIntArray(R.array.audio_angka);

        // hubungkan ke widget
        rvDaftarAngka = findViewById(R.id.rvDaftarAngka);

        // banyak kolom tiap baris
        int numberOfColumns = 3;

        // atur bentuk layout
        rvDaftarAngka.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

        AdapterAngka adapter = new AdapterAngka(this, arrayIconAngka, arrayAudioAngka);
        // atur adapter
        rvDaftarAngka.setAdapter(adapter);
    }
}
