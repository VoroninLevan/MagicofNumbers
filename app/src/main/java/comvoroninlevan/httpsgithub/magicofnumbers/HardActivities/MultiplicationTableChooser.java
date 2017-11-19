package comvoroninlevan.httpsgithub.magicofnumbers.HardActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comvoroninlevan.httpsgithub.magicofnumbers.R;

/**
 * Created by Levan on 19.11.2017.
 */

public class MultiplicationTableChooser extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_chooser);

        hide();
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

    public void chooser(View view){
        switch (view.getId()){
            case R.id.multiplOne:
                break;
            case R.id.multiplTwo:
                break;
            case R.id.multiplThree:
                break;
            case R.id.multiplFour:
                break;
            case R.id.multiplFive:
                break;
            case R.id.multiplSix:
                break;
            case R.id.multiplSeven:
                break;
            case R.id.multiplEight:
                break;
            case R.id.multiplNine:
                break;

        }
    }
}
