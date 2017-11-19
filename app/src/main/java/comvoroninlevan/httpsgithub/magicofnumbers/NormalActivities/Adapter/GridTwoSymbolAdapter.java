package comvoroninlevan.httpsgithub.magicofnumbers.NormalActivities.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import comvoroninlevan.httpsgithub.magicofnumbers.R;

/**
 * Created by Levan on 06.10.2017.
 */

public class GridTwoSymbolAdapter extends ArrayAdapter<Nums>{

    public GridTwoSymbolAdapter(Activity context, ArrayList<Nums> menuItem){
        super(context, 0, menuItem);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.menu_iten_two_symbol, parent, false);
        }

        Nums currentItem = getItem(position);

        ImageView numOne = (ImageView) listItemView.findViewById(R.id.imageMenuOne);
        numOne.setImageResource(currentItem.getNum());
        ImageView numTwo = (ImageView) listItemView.findViewById(R.id.imageMenuTwo);
        numTwo.setImageResource(R.drawable.zero);

        return listItemView;
    }
}
