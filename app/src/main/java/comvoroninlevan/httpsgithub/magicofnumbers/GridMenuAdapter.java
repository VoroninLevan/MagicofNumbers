package comvoroninlevan.httpsgithub.magicofnumbers;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Levan on 06.10.2017.
 */

public class GridMenuAdapter extends ArrayAdapter<GridMenu>{

    public GridMenuAdapter(Activity context, ArrayList<GridMenu> gridMenu){
        super(context, 0, gridMenu);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.menu_item, parent, false);
        }

        GridMenu currentMenu = getItem(position);

        ImageView menuIcon = (ImageView) listItemView.findViewById(R.id.menu_icon);
        menuIcon.setImageResource(currentMenu.getMenuIcon());
/*
        TextView menuName = (TextView) listItemView.findViewById(R.id.menu_name);
        menuName.setText(currentMenu.getMenuName());
*/
        return listItemView;
    }
}
