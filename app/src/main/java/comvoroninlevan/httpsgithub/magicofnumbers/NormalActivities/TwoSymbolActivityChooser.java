package comvoroninlevan.httpsgithub.magicofnumbers.NormalActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import comvoroninlevan.httpsgithub.magicofnumbers.NormalActivities.Adapter.GridTwoSymbolAdapter;
import comvoroninlevan.httpsgithub.magicofnumbers.NormalActivities.Adapter.Nums;
import comvoroninlevan.httpsgithub.magicofnumbers.R;

/**
 * Created by Levan on 14.11.2017.
 */

public class TwoSymbolActivityChooser extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_symbol);

        hide();

        ArrayList<Nums> item = new ArrayList<>();
        item.add(new Nums(R.drawable.one));
        item.add(new Nums(R.drawable.two));
        item.add(new Nums(R.drawable.three));
        item.add(new Nums(R.drawable.four));
        item.add(new Nums(R.drawable.five));
        item.add(new Nums(R.drawable.six));
        item.add(new Nums(R.drawable.seven));
        item.add(new Nums(R.drawable.eight));
        item.add(new Nums(R.drawable.nine));

        GridTwoSymbolAdapter mAdapter = new GridTwoSymbolAdapter(this, item);

        GridView gridViewMenu = (GridView)findViewById(R.id.gridViewMenu);
        gridViewMenu.setAdapter(mAdapter);

        gridViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentItem = new Intent(TwoSymbolActivityChooser.this, TwoSymbolActivity.class);
                switch (position){
                    case 0:
                        intentItem.putExtra("num", 1);
                        startActivity(intentItem);
                        break;
                    case 1:
                        intentItem.putExtra("num", 2);
                        startActivity(intentItem);
                        break;
                    case 2:
                        intentItem.putExtra("num", 3);
                        startActivity(intentItem);
                        break;
                    case 3:
                        intentItem.putExtra("num", 4);
                        startActivity(intentItem);
                        break;
                    case 4:
                        intentItem.putExtra("num", 5);
                        startActivity(intentItem);
                        break;
                    case 5:
                        intentItem.putExtra("num", 6);
                        startActivity(intentItem);
                        break;
                    case 6:
                        intentItem.putExtra("num", 7);
                        startActivity(intentItem);
                        break;
                    case 7:
                        intentItem.putExtra("num", 8);
                        startActivity(intentItem);
                        break;
                    case 8:
                        intentItem.putExtra("num", 9);
                        startActivity(intentItem);
                        break;
                }
            }
        });
    }

    private void hide() {
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Hide UI
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
