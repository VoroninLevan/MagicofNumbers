package comvoroninlevan.httpsgithub.magicofnumbers.HardActivities.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import comvoroninlevan.httpsgithub.magicofnumbers.NormalActivities.Adapter.Nums;
import comvoroninlevan.httpsgithub.magicofnumbers.R;

/**
 * Created by Levan on 19.11.2017.
 */

public class MultiplicationTableListAdapter extends ArrayAdapter<Nums> {

    private int mFirstNum;

    public MultiplicationTableListAdapter(Context context, ArrayList<Nums> nums, int firstNum) {
        super(context, 0, nums);
        mFirstNum = firstNum;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_multiplication_table, parent, false);
        }

        Nums currentNum = getItem(position);

        ImageView firstNumber = (ImageView)listItemView.findViewById(R.id.firstNumber);
        firstNumber.setImageResource(setDrawableOnImage(mFirstNum));

        int num = currentNum.getNum();
        ImageView secondNumberOne = (ImageView)listItemView.findViewById(R.id.secondNumberOne);
        ImageView secondNumberTwo = (ImageView)listItemView.findViewById(R.id.secondNumberTwo);
        if(num < 10){
            secondNumberOne.setImageResource(setDrawableOnImage(num));
            secondNumberTwo.setVisibility(View.GONE);
        }else{
            secondNumberOne.setImageResource(setDrawableOnImage(getSeparateNumber(num, true)));
            secondNumberTwo.setVisibility(View.VISIBLE);
            secondNumberTwo.setImageResource(setDrawableOnImage(getSeparateNumber(num, false)));
        }
        int result = currentNum.getResult();
        ImageView resultOne = (ImageView)listItemView.findViewById(R.id.resultOne);
        ImageView resultTwo = (ImageView)listItemView.findViewById(R.id.resultTwo);
        if(result < 10){
            resultOne.setImageResource(setDrawableOnImage(result));
            resultTwo.setVisibility(View.GONE);
        }else{
            resultOne.setImageResource(setDrawableOnImage(getSeparateNumber(result, true)));
            resultTwo.setVisibility(View.VISIBLE);
            resultTwo.setImageResource(setDrawableOnImage(getSeparateNumber(result, false)));
        }
        return listItemView;
    }

    private int getSeparateNumber(int num, boolean left){
        /**
         * Example: num=10, left=true.
         * num convert -> String full separate
         * if(left) -> char needed= full index(0) else index(1)
         * return numeric value from char needed
         */
        String full = Integer.toString(num);
        if(left){
            char needed = full.charAt(0);
            return Character.getNumericValue(needed);
        }else{
            char needed = full.charAt(1);
            return Character.getNumericValue(needed);
        }
    }

    private int setDrawableOnImage(int picker){
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
}
