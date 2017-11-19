package comvoroninlevan.httpsgithub.magicofnumbers.EasyActivities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

import comvoroninlevan.httpsgithub.magicofnumbers.MediaPlayerSingleton;
import comvoroninlevan.httpsgithub.magicofnumbers.MenuActivities.EasyMenuActivity;
import comvoroninlevan.httpsgithub.magicofnumbers.R;

/**
 * Created by Levan on 15.10.2017.
 */

public class ChoosingActivity extends AppCompatActivity {

    private ImageView answerOne, answerTwo, answerThree, answerFour;
    private int answer;
    private ImageButton nextQuiz;
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

        nextQuiz = (ImageButton)findViewById(R.id.nextQuiz);
        nextQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewQuiz();
                activateClickOnImg();
                nextQuizHide();
                setTransparentBackground();
            }
        });
        nextQuizHide();

        ImageButton backToEasyMenu = (ImageButton)findViewById(R.id.backToEasyMenu);
        backToEasyMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMenu = new Intent(ChoosingActivity.this, EasyMenuActivity.class);
                startActivity(backToMenu);
            }
        });

        generateNewQuiz();
    }

    private void hide() {
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Hide action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
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

    private void generateNewQuiz(){
        // From here new quiz starts to generate
        ArrayList<Integer> idList = fillArrayList();
        Random random = new Random();
        createImgIdList(idList, random);

    }

    private ArrayList<Integer> fillArrayList(){
        // Fill ArrayList<Integer> with values 0-9
        ArrayList<Integer> list = new ArrayList<>();
        for(int x = 0; x < 10; x++){
            list.add(x, x);
        }
        return list;
    }

    private void createImgIdList(ArrayList<Integer> intList, Random random){
        // Create ArrayList<Integer> to store images resource ids
        ArrayList<Integer> imgIdList = new ArrayList<>();
        for(int x = 0; x < 4; x++){
            int index = random.nextInt(intList.size());
            imgIdList.add(x, getDrawableId(intList.get(index)));
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

    private int getDrawableId(int picker){
        // Get resource id of images 0-9
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
                    setTag(answerOne, x);
                    break;
                case 1:
                    answerTwo.setImageResource(imgIdList.get(x));
                    setTag(answerTwo, x);
                    break;
                case 2:
                    answerThree.setImageResource(imgIdList.get(x));
                    setTag(answerThree, x);
                    break;
                case 3:
                    answerFour.setImageResource(imgIdList.get(x));
                    setTag(answerFour, x);
                    break;
            }
        }

        setAudio(answer);
    }

    private void setTag(View view, int x){
        // Set tag to ImageView to mark the wright answer
        if(x == 0){
            view.setTag(1);
        }else{
            view.setTag(0);
        }
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
        // Check user input and grade the answer
        int tag = (Integer)v.getTag();
        if(tag == 1){
            v.setBackgroundResource(R.color.wrightAnswer);
            deactivateClickOnImg();
            nextQuizShow();
        }else{
            v.setBackgroundResource(R.color.wrongAnswer);
            deactivateClickOnImg();
            nextQuizShow();
        }
    }

    private void deactivateClickOnImg(){
        // Deactivate click event on Img views
        answerOne.setEnabled(false);
        answerTwo.setEnabled(false);
        answerThree.setEnabled(false);
        answerFour.setEnabled(false);
    }

    private void activateClickOnImg(){
        // Deactivate click event on Img views
        answerOne.setEnabled(true);
        answerTwo.setEnabled(true);
        answerThree.setEnabled(true);
        answerFour.setEnabled(true);
    }

    private void nextQuizHide(){
        nextQuiz.setVisibility(View.INVISIBLE);
    }

    private void nextQuizShow(){
        nextQuiz.setVisibility(View.VISIBLE);
    }

    private void setTransparentBackground(){
        answerOne.setBackgroundColor(Color.TRANSPARENT);
        answerTwo.setBackgroundColor(Color.TRANSPARENT);
        answerThree.setBackgroundColor(Color.TRANSPARENT);
        answerFour.setBackgroundColor(Color.TRANSPARENT);
    }
}
