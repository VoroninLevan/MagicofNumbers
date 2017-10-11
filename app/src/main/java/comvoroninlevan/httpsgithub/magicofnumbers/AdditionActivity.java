package comvoroninlevan.httpsgithub.magicofnumbers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by Levan on 06.10.2017.
 */

public class AdditionActivity extends AppCompatActivity {


    //TODO
    private int result, first, second, userInput;
    private Animation slide_down, slide_up;
    private ImageView firstNum, secondNum, hintOne, hintTwo, answer, hintDoor;
    //Answer ImgView
    private ImageView one, two, three, four, five, six, seven, eight, nine, zero;
    //Marks
    private ImageView markOne, markTwo, markThree, markFour, markFive;
    private boolean[] markArray;
    private int counter = 0;
    //private Button nextQuiz;
    private ImageButton showHint, nextQuiz;
    private boolean isHintShow = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        hide();
        userInput = -1;
        markArray = new boolean[5];

        //Slide animation
        slide_down = AnimationUtils.loadAnimation(this,
                R.anim.slide_down);
        slide_up = AnimationUtils.loadAnimation(this,
                R.anim.slide_up);

        //Answer ImgViews
        one = (ImageView)findViewById(R.id.one);
        two = (ImageView)findViewById(R.id.two);
        three = (ImageView)findViewById(R.id.three);
        four = (ImageView)findViewById(R.id.four);
        five = (ImageView)findViewById(R.id.five);
        six = (ImageView)findViewById(R.id.six);
        seven = (ImageView)findViewById(R.id.seven);
        eight = (ImageView)findViewById(R.id.eight);
        nine = (ImageView)findViewById(R.id.nine);
        zero = (ImageView)findViewById(R.id.zero);

        //Marks ImgViews
        markOne = (ImageView)findViewById(R.id.firstMark);
        markTwo = (ImageView)findViewById(R.id.secondMark);
        markThree = (ImageView)findViewById(R.id.thirdMark);
        markFour = (ImageView)findViewById(R.id.fourthMark);
        markFive = (ImageView)findViewById(R.id.fifthMark);
        setDefaultMark();

        firstNum = (ImageView)findViewById(R.id.firstNumber);
        secondNum = (ImageView)findViewById(R.id.secondNumber);
        hintOne = (ImageView)findViewById(R.id.hintOne);
        hintOne.setVisibility(View.INVISIBLE);
        hintTwo = (ImageView)findViewById(R.id.hintTwo);
        hintTwo.setVisibility(View.INVISIBLE);
        answer = (ImageView)findViewById(R.id.answer);

        hintDoor = (ImageView)findViewById(R.id.hintDoor);
        hintDoor.setVisibility(View.VISIBLE);

        showHint = (ImageButton)findViewById(R.id.showHint);
        showHint.setImageResource(R.drawable.lever_up);
        showHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHint();
            }
        });



        nextQuiz = (ImageButton)findViewById(R.id.nextQuiz);
        nextQuiz.setVisibility(View.INVISIBLE);
        nextQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanPrevious();
                generateQuiz();
                nextQuiz.setVisibility(View.INVISIBLE);
            }
        });

        ImageButton backToMainMenu = (ImageButton)findViewById(R.id.backToMainMenu);
        backToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMenu = new Intent(AdditionActivity.this, FullscreenActivity.class);
                startActivity(backToMenu);
            }
        });

        generateQuiz();
    }

    private void hide(){
        // Hide UI
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
    }

    private void setDefaultMark(){
        markOne.setImageResource(R.drawable.none);
        markTwo.setImageResource(R.drawable.none);
        markThree.setImageResource(R.drawable.none);
        markFour.setImageResource(R.drawable.none);
        markFive.setImageResource(R.drawable.none);
    }

    private void generateQuiz(){
        // Generates new Quiz every time when called
        int x, y;
        Random random = new Random();
        x = random.nextInt(6);
        y = random.nextInt(6);

        setImageFirstNumQuiz(x);
        setImageSecondNumQuiz(y);

        first = x;
        second = y;
        result = x + y;
    }

    private void setImageFirstNumQuiz(int x){
        //Set image res into firstNum based on x
        switch(x){
            case 0:
                firstNum.setImageResource(R.drawable.zero);
                break;
            case 1:
                firstNum.setImageResource(R.drawable.one);
                break;
            case 2:
                firstNum.setImageResource(R.drawable.two);
                break;
            case 3:
                firstNum.setImageResource(R.drawable.three);
                break;
            case 4:
                firstNum.setImageResource(R.drawable.four);
                break;
            case 5:
                firstNum.setImageResource(R.drawable.five);
                break;
        }
    }

    private void setImageSecondNumQuiz(int y){
        //Set image res into secondNum based on y
        switch(y){
            case 0:
                secondNum.setImageResource(R.drawable.zero);
                break;
            case 1:
                secondNum.setImageResource(R.drawable.one);
                break;
            case 2:
                secondNum.setImageResource(R.drawable.two);
                break;
            case 3:
                secondNum.setImageResource(R.drawable.three);
                break;
            case 4:
                secondNum.setImageResource(R.drawable.four);
                break;
            case 5:
                secondNum.setImageResource(R.drawable.five);
                break;
        }
    }

    private void checkAnswer(){
        if(userInput != -1){
            if(userInput == result){
                nextQuiz.setVisibility(View.VISIBLE);
                populateMarkArray(true);
            }else{
                nextQuiz.setVisibility(View.VISIBLE);
                populateMarkArray(false);
            }
        }
    }

    private void populateMarkArray(boolean mark){
        markArray[counter] = mark;
        setMark(counter);
        counter ++;
        if(counter == 5){
            counter = 0;
        }
    }

    private void setMark(int counter){
        switch (counter){
            case 0:
                if(markArray[counter]){
                    markOne.setImageResource(R.drawable.pass);
                }else{
                    markOne.setImageResource(R.drawable.fail);
                }
                break;
            case 1:
                if(markArray[counter]){
                    markTwo.setImageResource(R.drawable.pass);
                }else{
                    markTwo.setImageResource(R.drawable.fail);
                }
                break;
            case 2:
                if(markArray[counter]){
                    markThree.setImageResource(R.drawable.pass);
                }else{
                    markThree.setImageResource(R.drawable.fail);
                }
                break;
            case 3:
                if(markArray[counter]){
                    markFour.setImageResource(R.drawable.pass);
                }else{
                    markFour.setImageResource(R.drawable.fail);
                }
                break;
            case 4:
                if(markArray[counter]){
                    markFive.setImageResource(R.drawable.pass);
                }else{
                    markFive.setImageResource(R.drawable.fail);
                }
                break;
        }
    }

    public void setAnswer(View view){
        switch (view.getId()){
            case R.id.one:
                answer.setImageResource(R.drawable.one);
                userInput = 1;
                showAnswer();
                checkAnswer();
                disableAnswers();
                break;
            case R.id.two:
                answer.setImageResource(R.drawable.two);
                userInput = 2;
                showAnswer();
                checkAnswer();
                disableAnswers();
                break;
            case R.id.three:
                answer.setImageResource(R.drawable.three);
                userInput = 3;
                showAnswer();
                checkAnswer();
                disableAnswers();
                break;
            case R.id.four:
                answer.setImageResource(R.drawable.four);
                userInput = 4;
                showAnswer();
                checkAnswer();
                disableAnswers();
                break;
            case R.id.five:
                answer.setImageResource(R.drawable.five);
                userInput = 5;
                showAnswer();
                checkAnswer();
                disableAnswers();
                break;
            case R.id.six:
                answer.setImageResource(R.drawable.six);
                userInput = 6;
                showAnswer();
                checkAnswer();
                disableAnswers();
                break;
            case R.id.seven:
                answer.setImageResource(R.drawable.seven);
                userInput = 7;
                showAnswer();
                checkAnswer();
                disableAnswers();
                break;
            case R.id.eight:
                answer.setImageResource(R.drawable.eight);
                userInput = 8;
                showAnswer();
                checkAnswer();
                disableAnswers();
                break;
            case R.id.nine:
                answer.setImageResource(R.drawable.nine);
                userInput = 9;
                showAnswer();
                checkAnswer();
                disableAnswers();
                break;
            case R.id.zero:
                answer.setImageResource(R.drawable.zero);
                userInput = 0;
                showAnswer();
                checkAnswer();
                disableAnswers();
                break;
        }
    }

    private void showAnswer(){
        //Show response to user
        answer.startAnimation(slide_up);
        answer.setVisibility(View.VISIBLE);
    }

    private void hideAnswer(){
        //Hide answer from user
        answer.startAnimation(slide_down);
        answer.setVisibility(View.INVISIBLE);
    }

    private void disableAnswers(){
        //Disable views with answers
        one.setEnabled(false);
        two.setEnabled(false);
        three.setEnabled(false);
        four.setEnabled(false);
        five.setEnabled(false);
        six.setEnabled(false);
        seven.setEnabled(false);
        eight.setEnabled(false);
        nine.setEnabled(false);
        zero.setEnabled(false);
    }

    private void enableAnswers(){
        //Enable views with answers
        one.setEnabled(true);
        two.setEnabled(true);
        three.setEnabled(true);
        four.setEnabled(true);
        five.setEnabled(true);
        six.setEnabled(true);
        seven.setEnabled(true);
        eight.setEnabled(true);
        nine.setEnabled(true);
        zero.setEnabled(true);
    }

    private void showHint(){
        //Show hint on showHint button click
        //hideHintSign();
        if(!isHintShow){
            isHintShow = true;
            hintDoor.startAnimation(slide_down);
            hintDoor.setVisibility(View.INVISIBLE);
            showHint.setImageResource(R.drawable.lever_down);

            setHintOneImage();
            hintOne.startAnimation(slide_up);
            hintOne.setVisibility(View.VISIBLE);

            setHintTwoImage();
            hintTwo.startAnimation(slide_up);
            hintTwo.setVisibility(View.VISIBLE);
        }
    }

    private void setHintOneImage(){
        switch(first){
            case 0:
                hintOne.setImageResource(R.drawable.apple_hint_zero);
                break;
            case 1:
                hintOne.setImageResource(R.drawable.apple_hint_one);
                break;
            case 2:
                hintOne.setImageResource(R.drawable.apple_hint_two);
                break;
            case 3:
                hintOne.setImageResource(R.drawable.apple_hint_three);
                break;
            case 4:
                hintOne.setImageResource(R.drawable.apple_hint_four);
                break;
            case 5:
                hintOne.setImageResource(R.drawable.apple_hint_five);
                break;
        }
    }

    private void setHintTwoImage(){
        switch(second){
            case 0:
                hintTwo.setImageResource(R.drawable.apple_hint_zero);
                break;
            case 1:
                hintTwo.setImageResource(R.drawable.apple_hint_one);
                break;
            case 2:
                hintTwo.setImageResource(R.drawable.apple_hint_two);
                break;
            case 3:
                hintTwo.setImageResource(R.drawable.apple_hint_three);
                break;
            case 4:
                hintTwo.setImageResource(R.drawable.apple_hint_four);
                break;
            case 5:
                hintTwo.setImageResource(R.drawable.apple_hint_five);
                break;
        }
    }

    private void cleanPrevious(){
        //Clean previous answer, hide hints, nextQuiz(GONE)

        if(hintOne.getVisibility() == View.VISIBLE){
            isHintShow = false;
            showHint.setImageResource(R.drawable.lever_up);
            hintOne.startAnimation(slide_down);
            hintOne.setVisibility(View.INVISIBLE);
            hintTwo.startAnimation(slide_down);
            hintTwo.setVisibility(View.INVISIBLE);
            hintDoor.startAnimation(slide_up);
            hintDoor.setVisibility(View.VISIBLE);
        }

        nextQuiz.setVisibility(View.GONE);
        enableAnswers();
        hideAnswer();
    }
}
