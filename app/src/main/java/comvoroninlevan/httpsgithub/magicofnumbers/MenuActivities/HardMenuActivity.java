package comvoroninlevan.httpsgithub.magicofnumbers.MenuActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comvoroninlevan.httpsgithub.magicofnumbers.R;

/**
 * Created by Levan on 18.11.2017.
 */

public class HardMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_menu);

        hide();
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.numbers:
                /*Intent numbersActivity = new Intent(HardMenuActivity.this, NumbersActivity.class);
                startActivity(numbersActivity);*/
                break;
            case R.id.dragAndDrop:
                /*Intent dragAndDropActivity = new Intent(HardMenuActivity.this, DragAndDropActivity.class);
                startActivity(dragAndDropActivity);*/
                break;
            case R.id.choosing:
                /*Intent choosingActivity = new Intent(HardMenuActivity.this, ChoosingActivity.class);
                startActivity(choosingActivity);*/
                break;
        }
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
