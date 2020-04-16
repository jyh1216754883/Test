package com.example.zqq.musicservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {

    private MediaPlayer mediaPlayer;
    private int cur = 0;
    int[] list = new int[]{
            R.raw.ningxia,
            R.raw.yanyuan,
            R.raw.suiyueshentou,
            R.raw.nicengshishaonian
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getStringExtra("action");
        if("play".equals(action)){
            playmusic();
        }else if("preview".equals(action)){
            premusic();
        }else if("stop".equals(action)){
            stopmusic();
        }else if("next".equals(action)){
            nextmusic();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void nextmusic() {
        cur = (cur + 1)%list.length;
        if(mediaPlayer != null){
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this,list[cur]);
        mediaPlayer.start();
    }

    private void stopmusic() {
        if(mediaPlayer!=null)
            mediaPlayer.stop();
    }

    private void premusic() {
        cur = (cur - 1)%list.length;
        if(cur < 0){
            cur = list.length - 1;
        }
        if(mediaPlayer != null){
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this,list[cur]);
        mediaPlayer.start();
    }

    private void playmusic() {
        if(mediaPlayer==null){
            mediaPlayer = MediaPlayer.create(this,list[cur]);
        }
        mediaPlayer.start();
    }
}
