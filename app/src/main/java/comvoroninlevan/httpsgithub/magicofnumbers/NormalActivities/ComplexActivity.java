package comvoroninlevan.httpsgithub.magicofnumbers.NormalActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

import comvoroninlevan.httpsgithub.magicofnumbers.R;

/**
 * Created by Levan on 03.11.2017.
 */

public class ComplexActivity extends AppCompatActivity {

    private Random random;
    private ImageView leftSign, rightSign, inBracketSign;
    private RelativeLayout leftBlock, rightBlock;
    private ImageView numOneOne, numOneTwo, numTwoOne, numTwoTwo, numThreeOne, numThreeTwo,
            numFourOne, numFourTwo;
    private ImageView answerOne, answerTwo;
    private int level = 10;
    private int numberLeft, resultBracket, numberRight, result, answer;
    private boolean additionLeft, additionBracket, additionRight, leftPart;
    private String leftFlag = "left";
    private String bracketFlag = "bracket";
    private String rightFlag = "right";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex);
        hide();

        random = new Random();

        leftBlock = (RelativeLayout)findViewById(R.id.leftBlock);
        rightBlock = (RelativeLayout)findViewById(R.id.rightBlock);

        inBracketSign = (ImageView)findViewById(R.id.inBracketSign);
        leftSign = (ImageView)findViewById(R.id.leftSign);
        rightSign = (ImageView)findViewById(R.id.rightSign);

        numOneOne = (ImageView)findViewById(R.id.numOneOne);
        numOneTwo = (ImageView)findViewById(R.id.numOneTwo);
        numTwoOne = (ImageView)findViewById(R.id.numTwoOne);
        numTwoTwo = (ImageView)findViewById(R.id.numTwoTwo);
        numThreeOne = (ImageView)findViewById(R.id.numThreeOne);
        numThreeTwo = (ImageView)findViewById(R.id.numThreeTwo);
        numFourOne = (ImageView)findViewById(R.id.numFourOne);
        numFourTwo = (ImageView)findViewById(R.id.numFourTwo);

        answerOne = (ImageView)findViewById(R.id.answerOne);
        answerTwo = (ImageView)findViewById(R.id.answerTwo);

        generateQuiz();
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

    private void generateQuiz(){
        if(exerciseLayout() == 0){
            hideRightPart(true);
            setSignsWithLeft(true);
            setNumbersQuizWithLeft(true);
        }else{
            hideRightPart(false);
            setSignsWithLeft(false);
            setNumbersQuizWithLeft(false);
        }
    }

    private int exerciseLayout(){
        return(random.nextInt(2));
    }

    private void hideRightPart(boolean hide){
        if(hide){
            rightBlock.setVisibility(View.GONE);
            rightSign.setVisibility(View.GONE);
        }else{
            leftBlock.setVisibility(View.GONE);
            leftSign.setVisibility(View.GONE);
        }
    }

    private void setSignsWithLeft(boolean leftPart){
        int bracketSign = returnDrawableSign();
        inBracketSign.setImageResource(bracketSign);
        if(bracketSign == R.drawable.addition){
            additionBracket = true;
        }else{
            additionBracket = false;
        }
        if(leftPart){
            int sign = returnDrawableSign();
            leftSign.setImageResource(sign);
            if(sign == R.drawable.addition){
                additionLeft = true;
            }else{
                additionLeft = false;
            }
        }else{
            int sign = returnDrawableSign();
            rightSign.setImageResource(sign);
            if(sign == R.drawable.addition){
                additionRight = true;
            }else{
                additionRight = false;
            }
        }
    }

    private int returnDrawableSign(){
        if(random.nextInt(2) == 0){
            return R.drawable.addition;
        }else{
            return R.drawable.subtraction;
        }
    }

    private void setNumbersQuizWithLeft(boolean left){
        setNumbersInBracket();
        leftPart = left;
        if(leftPart){
            int[] nums = getRandomNumbers();
            int leftNumber = transFromFromArrayToInt(nums);
            if(!additionLeft){
                if(leftNumber < resultBracket){
                    while (leftNumber < resultBracket){
                        nums = getRandomNumbers();
                        leftNumber = transFromFromArrayToInt(nums);
                    }
                }
            }
            if(nums[1] == -1){
                numOneTwo.setImageResource(setDrawableNum(nums[0]));
                numberLeft = nums[0];
            }else{
                numOneOne.setImageResource(setDrawableNum(nums[0]));
                numOneTwo.setImageResource(setDrawableNum(nums[1]));
                numberLeft = transFromFromArrayToInt(nums);
            }
            setResult();
        }else{
            int[] nums = getRandomNumbers();
            int rightNumber = transFromFromArrayToInt(nums);
            if(!additionRight){
                if(rightNumber > resultBracket){
                    while (rightNumber > resultBracket){
                        nums = getRandomNumbers();
                        rightNumber = transFromFromArrayToInt(nums);
                    }
                }
            }
            if(nums[1] == -1){
                numFourTwo.setImageResource(setDrawableNum(nums[0]));
                numberRight = nums[0];
            }else{
                numFourOne.setImageResource(setDrawableNum(nums[0]));
                numFourTwo.setImageResource(setDrawableNum(nums[1]));
                numberRight = transFromFromArrayToInt(nums);
            }
            setResult();
        }
    }

    private void setNumbersInBracket(){
        int[] numsFirst = getRandomNumbers();
        int numberOneBracket = transFromFromArrayToInt(numsFirst);
        int[] numsSecond = getRandomNumbers();
        int numberTwoBracket = transFromFromArrayToInt(numsSecond);
        if(!additionBracket){
            if(numberOneBracket < numberTwoBracket){
                while (numberOneBracket < numberTwoBracket){
                    numsSecond = getRandomNumbers();
                    numberTwoBracket = transFromFromArrayToInt(numsSecond);
                }
            }
        }

        resultBracket = getResultBracket(numberOneBracket, numberTwoBracket);
        if(numsFirst[1] == -1){
            numTwoTwo.setImageResource(setDrawableNum(numsFirst[0]));
        }else{
            numTwoOne.setImageResource(setDrawableNum(numsFirst[0]));
            numTwoTwo.setImageResource(setDrawableNum(numsFirst[1]));
        }

        if(numsSecond[1] == -1){
            numThreeTwo.setImageResource(setDrawableNum(numsSecond[0]));
        }else{
            numThreeOne.setImageResource(setDrawableNum(numsSecond[0]));
            numThreeTwo.setImageResource(setDrawableNum(numsSecond[1]));
        }
    }

    private int getResultBracket(int numOne, int numTwo){
        if(additionBracket){
            return numOne + numTwo;
        }else{
            return numOne - numTwo;
        }
    }

    private void setResult(){
        if(leftPart){
            if(!additionLeft){
                result = numberLeft - resultBracket;
            }else{
                result = numberLeft + resultBracket;
            }
        }else{
            if(!additionRight){
                result = resultBracket - numberRight;
            }else{
                result = resultBracket + numberRight;
            }
        }
    }

    private int[] getRandomNumbers(){
        int[] nums = new int[2];
        String stringNum = Integer.toString(random.nextInt(level));
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

    private int transFromFromArrayToInt(int[] array){
        String firstNum = String.valueOf(array[0]);
        String secondNum = "";
        if(!(array[1] == -1)){
            secondNum = String.valueOf(array[1]);
        }
        String full = firstNum + secondNum;
        return(Integer.parseInt(full));
    }

    public void setAnswer(View view){
        setDrawablesAnswer(Integer.parseInt(view.getTag().toString()));
    }

    private void setDrawablesAnswer(int tag){
        if(Integer.parseInt(answerOne.getTag().toString()) == -1){
            answerOne.setImageResource(setDrawableNum(tag));
            answerOne.setTag(tag);
            answer = tag;
        }else{
            answerTwo.setImageResource(setDrawableNum(tag));
            answerTwo.setTag(tag);
            answer = getAnswer(answer, tag);
        }
    }

    //TODO
    // NumberFormatException: For input string: "12121211212"
    private int getAnswer(int firstNum, int secondNum){
        String first = String.valueOf(firstNum);
        String second = String.valueOf(secondNum);
        return (Integer.parseInt(first + second));
    }

    public void checkAnswer(View view){
        if(result == answer){
            Toast.makeText(this, "True", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "False", Toast.LENGTH_SHORT).show();
        }
    }
}
