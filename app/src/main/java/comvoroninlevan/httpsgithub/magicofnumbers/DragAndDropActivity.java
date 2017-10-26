package comvoroninlevan.httpsgithub.magicofnumbers;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Levan on 21.10.2017.
 */

public class DragAndDropActivity extends AppCompatActivity {

    private ImageView imageOne, imageTwo, imageThree, imageFour;
    private ImageView answerOne, answerTwo, answerThree, answerFour;
    ArrayList<Integer> wrightAnswers;
    int[] imgTest;

    private View.OnDragListener onDragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //v.setBackgroundDrawable(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //v.setBackgroundDrawable(normalShape);
                    break;
                case DragEvent.ACTION_DROP:
                    ClipData.Item item = event.getClipData().getItemAt(0);
                    // Dropped, reassign View to ViewGroup
                    View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    ImageView container = (ImageView) v;
                    container.setImageResource(R.drawable.one);
                    view.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    //v.setBackgroundDrawable(normalShape);
                default:
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_and_drop);

        hide();
        imgTest = new int[2];

        imageOne = (ImageView)findViewById(R.id.imageOne);
        imageOne.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // do nothing
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        //v.setBackgroundDrawable(enterShape);
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        //v.setBackgroundDrawable(normalShape);
                        break;
                    case DragEvent.ACTION_DROP:
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        // Dropped, reassign View to ViewGroup
                        View view = (View) event.getLocalState();
                        ViewGroup owner = (ViewGroup) view.getParent();
                        owner.removeView(view);
                        ImageView container = (ImageView) v;
                        container.setImageResource(R.drawable.one);
                        view.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        //v.setBackgroundDrawable(normalShape);
                    default:
                        break;
                }
                return true;
            }
        });
        imageTwo = (ImageView)findViewById(R.id.imageTwo);
        imageThree = (ImageView)findViewById(R.id.imageThree);
        imageFour = (ImageView)findViewById(R.id.imageFour);

        answerOne = (ImageView)findViewById(R.id.answerOne);
        answerOne.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    imgTest[0] = R.drawable.one;
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                            view);
                    if(Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
                        view.startDragAndDrop(data, shadowBuilder, null, 0);
                    }else{
                        view.startDrag(data, shadowBuilder, null, 0);
                    }
                    view.setVisibility(View.INVISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });

        answerTwo = (ImageView)findViewById(R.id.answerTwo);
        answerThree = (ImageView)findViewById(R.id.answerThree);
        answerFour = (ImageView)findViewById(R.id.answerFour);

        wrightAnswers = new ArrayList<>();
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
        createQuiz();
        createAnswers();
    }

    private ArrayList<Integer> fillArrayList(boolean check){
        // Fill ArrayList<Integer> with values 0-3 if true
        // and 0-9 if false
        if(check){
            ArrayList<Integer> list = new ArrayList<>();
            for(int x = 0; x < 4; x++){
                list.add(x, x);
            }
            return list;
        }else{
            ArrayList<Integer> list = new ArrayList<>();
            for(int x = 0; x < 10; x++){
                list.add(x, x);
            }
            return list;
        }
    }

    private ArrayList<ImageView> fillArrayListView(boolean check){
        // Return ArrayList with quiz imageViews if true
        // and ArrayList with answer imageViews if false
        ArrayList<ImageView> imageViews = new ArrayList<>();
        if(check) {
            imageViews.add(0, imageOne);
            imageViews.add(1, imageTwo);
            imageViews.add(2, imageThree);
            imageViews.add(3, imageFour);
        }else{
            imageViews.add(0, answerOne);
            imageViews.add(1, answerTwo);
            imageViews.add(2, answerThree);
            imageViews.add(3, answerFour);
        }

        return imageViews;
    }

    private void createQuiz(){
        // Sets tags 0,1 to image views
        ArrayList<Integer> imgList = fillArrayList(true);
        int[] tags = new int[]{0,0,1,1};
        Random random = new Random();
        ArrayList<ImageView> imageViews = fillArrayListView(true);
        ImageView view;
        for(int x = 0; x < 4; x++){
            int index = random.nextInt(imgList.size());
            view = imageViews.get(x);
            view.setTag(tags[imgList.get(index)]);
            imgList = removeElement(imgList, index);
        }
        setTagsOnQuizImages(imageViews);
    }

    private ArrayList<Integer> removeElement(ArrayList<Integer> list, int index){
        list.remove(index);
        return list;
    }

    private void setTagsOnQuizImages(ArrayList<ImageView> imageViews){
        //Based on 0,1 tags
        // 0 - set drawable num image in quiz
        // 1 - set drawable question mark in quiz
        // add not shown elements to wrightAnswers
        int[] quiz = fillArrayWrightAnswers();
        int x = 0;
        int y = 0;
        for(ImageView view : imageViews){
            int tag = (Integer)view.getTag();
            if(tag == 1){
                view.setImageResource(R.mipmap.ic_launcher);
                view.setTag(quiz[x]);
                wrightAnswers.add(y, quiz[x]);
                x++;
                y++;
            }else{
                view.setTag(quiz[x]);
                view.setImageResource(setDrawablesOnImages(view));
                x++;
            }
        }
    }

    private int[] fillArrayWrightAnswers(){
        int[] quiz = new int[4];
        Random random = new Random();
        quiz[0] = random.nextInt(7);
        int y = 1;
        for(int x = quiz[0] + 1; x < quiz[0] + 4; x++){
            quiz[y] = x;
            y++;
        }
        return quiz;
    }

    private int setDrawablesOnImages(ImageView view){
        int picker = (Integer)view.getTag();

        switch (picker) {
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

    private void createAnswers(){
        ArrayList<Integer> mixedAnswers = fillArrayListMixedAnswers(wrightAnswers);
        setAnswersDrawables(mixedAnswers);
    }

    private ArrayList<Integer> fillArrayListMixedAnswers(ArrayList<Integer> answers){
        // Create ArrayList with two wright answers and two wrong answers
        Random random = new Random();
        ArrayList<Integer> restWrong = fillArrayList(false);
        restWrong = returnNoWrightAnswers(answers, restWrong);
        for(int x = 2; x < 4; x++){
            int wrongAnswer = restWrong.get(random.nextInt(restWrong.size()));
            answers.add(x, wrongAnswer);
        }
        return answers;
    }

    private ArrayList<Integer> returnNoWrightAnswers(ArrayList<Integer> wrightAnswers,
                                                     ArrayList<Integer> restWrong){
        // Return ArrayList restWrong with no wright answers inside
        ArrayList<Integer> wrightElements = new ArrayList<>();
        int x = 0;
        for(int answer : restWrong){
            if(answer == wrightAnswers.get(0) | answer == wrightAnswers.get(1)){
                wrightElements.add(x, restWrong.get(restWrong.indexOf(answer)));
                x++;
            }
        }
        restWrong.removeAll(wrightElements);
        return restWrong;
    }

    private void setAnswersDrawables(ArrayList<Integer> mixedAnswers){
        // Sets drawables to image views in answer block
        ArrayList<ImageView> imageViews = fillArrayListView(false);
        Random random = new Random();
        for(ImageView view : imageViews){
            int index = random.nextInt(mixedAnswers.size());
            int tag = mixedAnswers.get(index);
            view.setTag(tag);
            mixedAnswers = removeElement(mixedAnswers, index);
            view.setImageResource(setDrawablesOnImages(view));
        }
    }
}
