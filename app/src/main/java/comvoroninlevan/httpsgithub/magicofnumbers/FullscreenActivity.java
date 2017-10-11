package comvoroninlevan.httpsgithub.magicofnumbers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class FullscreenActivity extends AppCompatActivity {

    private GridMenuAdapter mMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        hide();

        ArrayList<GridMenu> gridMenu = new ArrayList<>();

        gridMenu.add(new GridMenu(R.mipmap.ic_launcher));
        gridMenu.add(new GridMenu(R.mipmap.ic_launcher));
        gridMenu.add(new GridMenu(R.mipmap.ic_launcher));
        gridMenu.add(new GridMenu(R.mipmap.ic_launcher));
        gridMenu.add(new GridMenu(R.mipmap.ic_launcher));
        gridMenu.add(new GridMenu(R.mipmap.ic_launcher));

        mMenuAdapter = new GridMenuAdapter(this, gridMenu);

        GridView gridView = (GridView)findViewById(R.id.gridMenu);
        gridView.setAdapter(mMenuAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        Intent intentAddition = new Intent(FullscreenActivity.this, AdditionActivity.class);
                        startActivity(intentAddition);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
            }
        });
    }

    private void hide() {
        // Hide UI
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
