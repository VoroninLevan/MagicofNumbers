package comvoroninlevan.httpsgithub.magicofnumbers.NormalActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import comvoroninlevan.httpsgithub.magicofnumbers.R;

/**
 * Created by Levan on 30.11.2017.
 */

public class ColChooser extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_subtraction);

        ImageView toAddition = (ImageView)findViewById(R.id.toAddition);
        toAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent additionActivity = new Intent(ColChooser.this,
                        ColAdditionActivity.class);
                startActivity(additionActivity);
            }
        });
        ImageView toSubtraction = (ImageView)findViewById(R.id.toSubtraction);
        toSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent subtractionActivity = new Intent(ColChooser.this,
                        ColSubtractionActivity.class);
                startActivity(subtractionActivity);
            }
        });
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
}
