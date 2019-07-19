package com.edy.inspiron.pbm_uas;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;

public class AdapterAngka extends RecyclerView.Adapter<AdapterAngka.ViewHolder> {
    Context ctxa;
    int[] arrayIconAngka;
    int[] arrayAudioAngka;



    public AdapterAngka(Context ctxa, int[] arrayIconAngka, int[] arrayAudioAngka) {
        this.ctxa = ctxa;
        this.arrayIconAngka = arrayIconAngka;
        this.arrayAudioAngka = arrayAudioAngka;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewOfList = LayoutInflater.from(ctxa).inflate(R.layout.item_angka, parent, false);

        return new ViewHolder(viewOfList);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        TypedArray imgs = ctxa.getResources().obtainTypedArray(R.array.icon_angka);
        final TypedArray audios = ctxa.getResources().obtainTypedArray(R.array.audio_angka);
        // set icon ke gambar
        holder.ivIconAngka.setImageResource(imgs.getResourceId(position, -1));


        // ANIMASI
        // Create a system to run the physics loop for a set of springs.
        SpringSystem springSystem = SpringSystem.create();
        // Add a spring to the system.
        final Spring spring = springSystem.createSpring();
        // Add a listener to observe the motion of the spring.
        spring.addListener(new SimpleSpringListener(){
            @Override
            public void onSpringUpdate(Spring spring) {
                // You can observe the updates in the spring
                // state by asking its current value in onSpringUpdate.
                float value = (float) spring.getCurrentValue();
                float scale = 1f - (value * 0.5f);

                holder.ivIconAngka.setScaleX(scale);
                holder.ivIconAngka.setScaleY(scale);
            }
        });
        // END ANIMASI

        // event ketika di klik
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // jalankan animasi
                spring.setEndValue(1);
                // class ini untuk memutar audio
                final MediaPlayer mediaPlayer = MediaPlayer.create(ctxa, audios.getResourceId(position, -1));
                mediaPlayer.start(); // no need to call prepare(); create() does that for you
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.release();
                    }
                });

                // delay selama beberapa waktu
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something after 100ms
                        // Set the spring in motion; moving from 0 to 1
                        spring.setEndValue(0); // matikan animasi
                    }
                }, 100); // delay slama 100 ms

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayIconAngka.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIconAngka;
        public ViewHolder(View itemView) {
            super(itemView);
            ivIconAngka = itemView.findViewById(R.id.ivIconAngka);
        }
    }
}
