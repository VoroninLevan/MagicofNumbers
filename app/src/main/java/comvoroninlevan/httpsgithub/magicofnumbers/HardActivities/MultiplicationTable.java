package comvoroninlevan.httpsgithub.magicofnumbers.HardActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import comvoroninlevan.httpsgithub.magicofnumbers.HardActivities.Adapter.MultiplicationTableListAdapter;
import comvoroninlevan.httpsgithub.magicofnumbers.NormalActivities.Adapter.Nums;
import comvoroninlevan.httpsgithub.magicofnumbers.R;

/**
 * Created by Levan on 19.11.2017.
 */

public class MultiplicationTable extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        hide();

        Intent intent = getIntent();
        int firstNum = intent.getIntExtra("firstNum", 0);

        ArrayList<Nums> item = new ArrayList<>();
        for(int num = 1; num < 11; num++){
            int result = firstNum * num;
            item.add(new Nums(num, result));
        }

        MultiplicationTableListAdapter listAdapter =
                new MultiplicationTableListAdapter(this, item, firstNum);

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(listAdapter);
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
