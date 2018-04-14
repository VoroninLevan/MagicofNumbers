package comvoroninlevan.httpsgithub.magicofnumbers.NormalActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

import comvoroninlevan.httpsgithub.magicofnumbers.R;

/**
 * Created by Levan on 30.11.2017.
 */

public class ColSubtractionActivity extends AppCompatActivity {

    private int topNumber, bottomNumber, result;
    private ImageView topNumOne, topNumTwo, bottomNumOne, bottomNumTwo,
            resultNumOne, resultNumTwo, topNumHint;
    private ImageView currentView;

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            currentView = (ImageView)v;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_col_add_sub);

        hide();

        topNumHint = (ImageView)findViewById(R.id.topNumHint);
        topNumHint.setOnClickListener(onClickListener);
        topNumOne = (ImageView)findViewById(R.id.topNumOne);
        topNumTwo = (ImageView)findViewById(R.id.topNumTwo);
        bottomNumOne = (ImageView)findViewById(R.id.bottomNumOne);
        bottomNumTwo = (ImageView)findViewById(R.id.bottomNumTwo);
        resultNumOne = (ImageView)findViewById(R.id.resultNumOne);
        resultNumOne.setOnClickListener(onClickListener);
        resultNumTwo = (ImageView)findViewById(R.id.resultNumTwo);
        resultNumTwo.setOnClickListener(onClickListener);

        ImageView sign =(ImageView)findViewById(R.id.sign);
        sign.setImageResource(R.drawable.subtraction);

        ImageView start = (ImageView)findViewById(R.id.start);
        start.setImageResource(R.drawable.subtraction);
        start.setVisibility(View.INVISIBLE);

        startQuiz();
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

    private void startQuiz(){
        getRandomNumbers();
        getResult();
        setTopNumber();
        setBottomNumber();
    }

    private void getRandomNumbers(){
        // Get random numbers for topNumber and bottomNumber
        // result must be < 100 -> max of bottomNumber = 99 - topNumber
        Random random = new Random();
        topNumber = random.nextInt(100);
        bottomNumber = random.nextInt(topNumber);
    }

    private void getResult(){
        result = topNumber - bottomNumber;
    }

    private int[] returnSeparate(int num){
        int[] nums = new int[2];
        String stringNum = Integer.toString(num);
        String firstPart = stringNum.substring(0,1);
        int firstNumPart;
        int secondNumPart = -1;
        firstNumPart = Integer.parseInt(firstPart);
        nums[0] = firstNumPart;
        nums[1] = secondNumPart;
        if(stringNum.length() > 1){
            String secondPart = stringNum.substring(1);
            secondNumPart = Integer.parseInt(secondPart);
            nums[1] = secondNumPart;
        }
        return nums;
    }

    private void setTopNumber(){
        int[] separateNumber = returnSeparate(topNumber);
        if(separateNumber[1] == -1){
            topNumTwo.setImageResource(setDrawableNum(separateNumber[0]));
        }else{
            topNumOne.setImageResource(setDrawableNum(separateNumber[0]));
            topNumTwo.setImageResource(setDrawableNum(separateNumber[1]));
        }
    }

    private void setBottomNumber(){
        int[] separateNumber = returnSeparate(bottomNumber);
        if(separateNumber[1] == -1){
            bottomNumTwo.setImageResource(setDrawableNum(separateNumber[0]));
        }else{
            bottomNumOne.setImageResource(setDrawableNum(separateNumber[0]));
            bottomNumTwo.setImageResource(setDrawableNum(separateNumber[1]));
        }
    }

    private int setDrawableNum(int x){
        //Set image res based on x
        switch(x){
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

    public void getNumber(View view){
        switch(view.getId()){
            case R.id.one:
                setNumber(1);
                break;
            case R.id.two:
                setNumber(2);
                break;
            case R.id.three:
                setNumber(3);
                break;
            case R.id.four:
                setNumber(4);
                break;
            case R.id.five:
                setNumber(5);
                break;
            case R.id.six:
                setNumber(6);
                break;
            case R.id.seven:
                setNumber(7);
                break;
            case R.id.eight:
                setNumber(8);
                break;
            case R.id.nine:
                setNumber(9);
                break;
            case R.id.zero:
                setNumber(0);
                break;
        }
    }

    private void setNumber(int number){
        if(currentView != null){
            currentView.setImageResource(setDrawableNum(number));
            currentView.setTag(number);
        }
    }

    public void checkAnswer(View view){
        if(getUserInput() == result){
            Toast.makeText(this, "GOOD", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "BAD", Toast.LENGTH_SHORT).show();
        }
    }

    private int getUserInput(){
        //TODO
        String numOne = "";
        String numTwo = "";
        if(resultNumOne.getTag() != null){
            numOne = resultNumOne.getTag().toString();
            numTwo = resultNumTwo.getTag().toString();
            return Integer.parseInt(numOne + numTwo);
        }else{
            numTwo = resultNumTwo.getTag().toString();
            return Integer.parseInt(numTwo);
        }
    }
}
