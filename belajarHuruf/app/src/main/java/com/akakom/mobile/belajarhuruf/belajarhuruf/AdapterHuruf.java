package com.akakom.mobile.belajarhuruf.belajarhuruf;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.akakom.mobile.belajarhuruf.R;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;

public class AdapterHuruf extends RecyclerView.Adapter<AdapterHuruf.ViewHolder> {
    Context ctx;
    int[] arrayIconHuruf;
    int[] arrayAudioHuruf;
    boolean isPlaying = false;


    public AdapterHuruf(Context ctx, int[] arrayIconHuruf, int[] arrayAudioHuruf) {
        this.ctx = ctx;
        this.arrayIconHuruf = arrayIconHuruf;
        this.arrayAudioHuruf = arrayAudioHuruf;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewOfList = LayoutInflater.from(ctx).inflate(R.layout.item_huruf, parent, false);

        return new ViewHolder(viewOfList);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        TypedArray imgs = ctx.getResources().obtainTypedArray(R.array.icon_huruf);
        final TypedArray audios = ctx.getResources().obtainTypedArray(R.array.audio_huruf);
        // set icon ke gambar
        holder.ivIconHuruf.setImageResource(imgs.getResourceId(position, -1));


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

                holder.ivIconHuruf.setScaleX(scale);
                holder.ivIconHuruf.setScaleY(scale);
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
                final MediaPlayer mediaPlayer = MediaPlayer.create(ctx, audios.getResourceId(position, -1));
                Log.d("musik", String.valueOf(isPlaying));
                if(isPlaying==false){
                    isPlaying = true;
                    mediaPlayer.start(); // no need to call prepare(); create() does that for you
                }
                Log.d("musik 2", String.valueOf(isPlaying));
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.release();
                        isPlaying = false;
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
        return arrayIconHuruf.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIconHuruf;
        public ViewHolder(View itemView) {
            super(itemView);
            ivIconHuruf = itemView.findViewById(R.id.ivIconHuruf);
        }
    }
}
