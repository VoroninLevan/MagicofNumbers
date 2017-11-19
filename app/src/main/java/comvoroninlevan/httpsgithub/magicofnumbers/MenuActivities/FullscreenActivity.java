package comvoroninlevan.httpsgithub.magicofnumbers.MenuActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comvoroninlevan.httpsgithub.magicofnumbers.R;

public class FullscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        hide();

    }

    public void onClick(View view){

        switch (view.getId()){
            case R.id.toEasy:
                Intent easyMenuActivity = new Intent(FullscreenActivity.this, EasyMenuActivity.class);
                startActivity(easyMenuActivity);
                break;
            case R.id.toNormal:
                Intent normalMenuActivity = new Intent(FullscreenActivity.this, NormalMenuActivity.class);
                startActivity(normalMenuActivity);
                break;
            case R.id.toHard:
                //TODO
                //Intent hardMenuActivity = new Intent(FullscreenActivity.this, HardMenuActivity.class);
                //startActivity(hardMenuActivity);
                break;
        }
    }

    private void hide() {
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Hide action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
