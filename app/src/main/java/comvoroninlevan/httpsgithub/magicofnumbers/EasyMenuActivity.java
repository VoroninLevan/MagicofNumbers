package comvoroninlevan.httpsgithub.magicofnumbers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Levan on 14.10.2017.
 */

public class EasyMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_menu);

        hide();

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.numbers:
                Intent numbersActivity = new Intent(EasyMenuActivity.this, NumbersActivity.class);
                startActivity(numbersActivity);
                break;
            case R.id.tracing:
                //TODO
                //Intent tracingActivity = new Intent(EasyMenuActivity.this, TracingActivity.class);
                //startActivity(tracingActivity);
                break;
            case R.id.choosing:
                //TODO
                //Intent choosingActivity = new Intent(EasyMenuActivity.this, ChoosingActivity.class);
                //startActivity(choosingActivity);
                break;
        }
    }

    private void hide() {
        // Hide UI
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

}
