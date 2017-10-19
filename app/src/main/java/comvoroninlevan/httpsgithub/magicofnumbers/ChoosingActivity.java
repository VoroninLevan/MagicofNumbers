package comvoroninlevan.httpsgithub.magicofnumbers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Levan on 15.10.2017.
 */

public class ChoosingActivity extends AppCompatActivity {

    private ImageView answerOne, answerTwo, answerThree, answerFour;
    private int answer;
    private MediaPlayerSingleton mediaPlayer = MediaPlayerSingleton.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing);

        hide();

        answerOne = (ImageView)findViewById(R.id.answerOne);
        answerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(v);
            }
        });
        answerTwo = (ImageView)findViewById(R.id.answerTwo);
        answerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(v);
            }
        });
        answerThree = (ImageView)findViewById(R.id.answerThree);
        answerThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(v);
            }
        });
        answerFour = (ImageView)findViewById(R.id.answerFour);
        answerFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(v);
            }
        });

        generateNewQuiz();
    }

    private void setAudio(int answer){
        switch (answer){
            case 0:
                playAudio(R.raw.zero);
                break;
            case 1:
                playAudio(R.raw.one);
                break;
            case 2:
                playAudio(R.raw.two);
                break;
            case 3:
                playAudio(R.raw.three);
                break;
            case 4:
                playAudio(R.raw.four);
                break;
            case 5:
                playAudio(R.raw.five);
                break;
            case 6:
                playAudio(R.raw.six);
                break;
            case 7:
                playAudio(R.raw.seven);
                break;
            case 8:
                playAudio(R.raw.eight);
                break;
            case 9:
                playAudio(R.raw.nine);
                break;
        }
    }


    private void hide() {
        // Hide UI
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private void generateNewQuiz(){
        ArrayList<Integer> idList = fillArray();
        Random random = new Random();
        createImgIdList(idList, random);

    }

    private ArrayList<Integer> fillArray(){
        ArrayList<Integer> list = new ArrayList<>();
        for(int x = 0; x < 10; x++){
            list.add(x, x);
        }
        return list;
    }

    private void createImgIdList(ArrayList<Integer> intList, Random random){
        ArrayList<Integer> imgIdList = new ArrayList<>();
        for(int x = 0; x < 4; x++){
            int index = random.nextInt(intList.size());
            imgIdList.add(x, getResId(intList.get(index)));
            if(x == 0){
                answer = intList.get(index);
            }
            intList = removeElement(intList, index);
        }
        setOptionsRandomly(imgIdList);
    }

    private ArrayList<Integer> removeElement(ArrayList<Integer> list, int index){
        list.remove(index);
        return list;
    }

    private int getResId(int picker){
        switch (picker){
            case 0:
                return R.drawable.zero;
            case 1:
                return R.drawable.one;
            case 2:
                return R.drawable.two;
            case 3:
                return R.drawable.three;
            case 4:
                return R.drawable.four;
            case 5:
                return R.drawable.five;
            case 6:
                return R.drawable.six;
            case 7:
                return R.drawable.seven;
            case 8:
                return R.drawable.eight;
            default:
                return R.drawable.nine;
        }
    }

    private void setOptionsRandomly(ArrayList<Integer> imgIdList){
        ArrayList<Integer> placeList = returnPlaceList();
        Random random = new Random();
        for(int x = 0; x < 4; x++){
            int index = random.nextInt(placeList.size());
            int place = placeList.get(index);
            placeList = removeElement(placeList, index);

            switch (place){
                case 0:
                    answerOne.setImageResource(imgIdList.get(x));
                    if(x == 0){
                        answerOne.setTag(1);
                    }else{
                        answerOne.setTag(0);
                    }
                    break;
                case 1:
                    answerTwo.setImageResource(imgIdList.get(x));
                    if(x == 0){
                        answerTwo.setTag(1);
                    }else{
                        answerTwo.setTag(0);
                    }
                    break;
                case 2:
                    answerThree.setImageResource(imgIdList.get(x));
                    if(x == 0){
                        answerThree.setTag(1);
                    }else{
                        answerThree.setTag(0);
                    }
                    break;
                case 3:
                    answerFour.setImageResource(imgIdList.get(x));
                    if(x == 0){
                        answerFour.setTag(1);
                    }else{
                        answerFour.setTag(0);
                    }
                    break;
            }
        }

        setAudio(answer);
    }

    private ArrayList<Integer> returnPlaceList(){
        ArrayList<Integer> placeList = new ArrayList<>();
        for(int x = 0; x < 4; x++){
            placeList.add(x, x);
        }
        return placeList;
    }

    private void playAudio(int rawId){
        releaseMediaPlayer();
        mediaPlayer.mediaPlayer = mediaPlayer.mediaPlayer.create(this, rawId);
        mediaPlayer.mediaPlayer.start();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer.mediaPlayer != null) {
            mediaPlayer.mediaPlayer.release();
            mediaPlayer.mediaPlayer = null;
        }
    }

    private void checkAnswer(View v){
        int tag = (Integer)v.getTag();
        if(tag == 1){
            v.setBackgroundResource(R.color.wrightAnswer);
        }else{
            v.setBackgroundResource(R.color.wrongAnswer);
        }
    }
}
