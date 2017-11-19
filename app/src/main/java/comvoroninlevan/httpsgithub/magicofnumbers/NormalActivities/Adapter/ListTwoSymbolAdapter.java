package comvoroninlevan.httpsgithub.magicofnumbers.NormalActivities.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import comvoroninlevan.httpsgithub.magicofnumbers.R;

/**
 * Created by Levan on 16.11.2017.
 */

public class ListTwoSymbolAdapter extends ArrayAdapter<Nums> {

    private int mFirstNum;

    public ListTwoSymbolAdapter(Context context, ArrayList<Nums> nums, int firstNum) {
        super(context, 0, nums);
        mFirstNum = firstNum;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_two_symbol, parent, false);
        }

        Nums currentNum = getItem(position);

        ImageView numOne = (ImageView)listItemView.findViewById(R.id.numOne);
        numOne.setImageResource(setDrawableOnImage(mFirstNum));
        ImageView numTwo = (ImageView)listItemView.findViewById(R.id.numTwo);
        numTwo.setImageResource(currentNum.getNum());
        TextView numName = (TextView)listItemView.findViewById(R.id.numName);
        numName.setText(currentNum.getName());
        return listItemView;
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
