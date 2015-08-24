package movil.salt.services1.Services;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

/**
 * Created by pc on 24/08/2015.
 */
public class ReproductorService extends Service implements MediaPlayer.OnPreparedListener {

    public static final String URL = "http://emisora.unicauca.edu.co:8000/stream";

    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
             mediaPlayer.setDataSource(URL);
             mediaPlayer.prepareAsync();
             mediaPlayer.setOnPreparedListener(this);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }
}
