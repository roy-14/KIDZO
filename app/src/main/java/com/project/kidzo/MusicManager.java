package com.project.kidzo;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class MusicManager implements MediaPlayer.OnPreparedListener {

    static MediaPlayer mPlayer;
    Context context;
    private int mySoundId;
    String TAG = "MusicManager";


    public MusicManager(Context ctx, int musicID) {
        context = ctx;
        mySoundId = musicID;
    }

    public void play() {
        mPlayer = MediaPlayer.create(context, mySoundId);
        mPlayer.setOnPreparedListener(this);
        Log.d(TAG, "play: "+ "music started");
    }

    public void stop() {
        mPlayer.stop();
        mPlayer.release();
        Log.d(TAG, "stop: "+ "music stopped");
    }

    @Override
    public void onPrepared(MediaPlayer player) {
        mPlayer.setLooping(true);
        mPlayer.setVolume(0.1f, 0.1f);
        player.start();
    }
}
