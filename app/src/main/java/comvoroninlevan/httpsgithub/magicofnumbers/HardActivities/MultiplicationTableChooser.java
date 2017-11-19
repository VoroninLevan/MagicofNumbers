package comvoroninlevan.httpsgithub.magicofnumbers.HardActivities;

import android.content.Intent;
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
        Intent toMultiplicationTable;
        switch (view.getId()){
            case R.id.multiplOne:
                toMultiplicationTable = new Intent(MultiplicationTableChooser.this, MultiplicationTable.class);
                toMultiplicationTable.putExtra("firstNum", 1);
                startActivity(toMultiplicationTable);
                break;
            case R.id.multiplTwo:
                toMultiplicationTable = new Intent(MultiplicationTableChooser.this, MultiplicationTable.class);
                toMultiplicationTable.putExtra("firstNum", 2);
                startActivity(toMultiplicationTable);
                break;
            case R.id.multiplThree:
                toMultiplicationTable = new Intent(MultiplicationTableChooser.this, MultiplicationTable.class);
                toMultiplicationTable.putExtra("firstNum", 3);
                startActivity(toMultiplicationTable);
                break;
            case R.id.multiplFour:
                toMultiplicationTable = new Intent(MultiplicationTableChooser.this, MultiplicationTable.class);
                toMultiplicationTable.putExtra("firstNum", 4);
                startActivity(toMultiplicationTable);
                break;
            case R.id.multiplFive:
                toMultiplicationTable = new Intent(MultiplicationTableChooser.this, MultiplicationTable.class);
                toMultiplicationTable.putExtra("firstNum", 5);
                startActivity(toMultiplicationTable);
                break;
            case R.id.multiplSix:
                toMultiplicationTable = new Intent(MultiplicationTableChooser.this, MultiplicationTable.class);
                toMultiplicationTable.putExtra("firstNum", 6);
                startActivity(toMultiplicationTable);
                break;
            case R.id.multiplSeven:
                toMultiplicationTable = new Intent(MultiplicationTableChooser.this, MultiplicationTable.class);
                toMultiplicationTable.putExtra("firstNum", 7);
                startActivity(toMultiplicationTable);
                break;
            case R.id.multiplEight:
                toMultiplicationTable = new Intent(MultiplicationTableChooser.this, MultiplicationTable.class);
                toMultiplicationTable.putExtra("firstNum", 8);
                startActivity(toMultiplicationTable);
                break;
            case R.id.multiplNine:
                toMultiplicationTable = new Intent(MultiplicationTableChooser.this, MultiplicationTable.class);
                toMultiplicationTable.putExtra("firstNum", 9);
                startActivity(toMultiplicationTable);
                break;

        }
    }
}
