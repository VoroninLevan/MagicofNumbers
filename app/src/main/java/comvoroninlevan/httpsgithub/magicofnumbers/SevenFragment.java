package comvoroninlevan.httpsgithub.magicofnumbers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Levan on 15.10.2017.
 */

public class SevenFragment extends Fragment {

    public SevenFragment() {}

    private MediaPlayerSingleton mediaPlayer = MediaPlayerSingleton.getInstance();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_one_to_zero, container, false);

        ImageView numberImg = (ImageView)rootView.findViewById(R.id.numberImg);
        numberImg.setImageResource(R.drawable.seven);
        numberImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio();
            }
        });

        return rootView;
    }

    private void playAudio(){
        releaseMediaPlayer();
        mediaPlayer.mediaPlayer = mediaPlayer.mediaPlayer.create(getActivity(), R.raw.seven);
        mediaPlayer.mediaPlayer.start();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer.mediaPlayer != null) {
            mediaPlayer.mediaPlayer.release();
            mediaPlayer.mediaPlayer = null;
        }
    }
}
