package comvoroninlevan.httpsgithub.magicofnumbers.HardActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

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

        //TODO
        /* firstNum -> receive with intent,
        Fill Nums ArrayList
        secondNum -> fill in adapter with Nums
        make method to count multip result -> add to Nums -> fill the field
         */
        ListView listView = (ListView)findViewById(R.id.listView);
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
