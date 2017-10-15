package comvoroninlevan.httpsgithub.magicofnumbers;

import android.media.MediaPlayer;

/**
 * Created by Levan on 15.10.2017.
 */

public class MediaPlayerSingleton {

    public static volatile MediaPlayerSingleton instance = null;
    public MediaPlayerSingleton() {}
    public MediaPlayer mediaPlayer = new MediaPlayer();

    public static MediaPlayerSingleton getInstance() {
        if (instance == null) {
            synchronized (MediaPlayerSingleton.class) {
                if (instance == null) {
                    instance = new MediaPlayerSingleton();
                }
            }
        }
        return instance;
    }
}
