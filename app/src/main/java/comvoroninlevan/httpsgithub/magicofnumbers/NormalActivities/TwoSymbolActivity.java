package comvoroninlevan.httpsgithub.magicofnumbers.NormalActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import comvoroninlevan.httpsgithub.magicofnumbers.NormalActivities.Adapter.ListTwoSymbolAdapter;
import comvoroninlevan.httpsgithub.magicofnumbers.NormalActivities.Adapter.Nums;
import comvoroninlevan.httpsgithub.magicofnumbers.R;

/**
 * Created by Levan on 16.11.2017.
 */

public class TwoSymbolActivity extends AppCompatActivity {

    private ArrayList<Nums> item;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        hide();

        Intent intent = getIntent();
        int firstNum = intent.getIntExtra("num", 0);
        item = new ArrayList<>();
        setDataToNums(firstNum);

        ListTwoSymbolAdapter adapter = new ListTwoSymbolAdapter(this, item, firstNum);

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
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

    private void setDataToNums(int num){
        switch (num){
            case 1:
                item.add(new Nums(R.drawable.zero, getString(R.string.ten)));
                item.add(new Nums(R.drawable.one, getString(R.string.eleven)));
                item.add(new Nums(R.drawable.two, getString(R.string.twelve)));
                item.add(new Nums(R.drawable.three, getString(R.string.thirteen)));
                item.add(new Nums(R.drawable.four, getString(R.string.fourteen)));
                item.add(new Nums(R.drawable.five, getString(R.string.fifteen)));
                item.add(new Nums(R.drawable.six, getString(R.string.sixteen)));
                item.add(new Nums(R.drawable.seven, getString(R.string.seventeen)));
                item.add(new Nums(R.drawable.eight, getString(R.string.eighteen)));
                item.add(new Nums(R.drawable.nine, getString(R.string.nineteen)));
                break;
            case 2:
                item.add(new Nums(R.drawable.zero, getString(R.string.twenty)));
                item.add(new Nums(R.drawable.one, getString(R.string.twenty) + " " +
                        getString(R.string.one)));
                item.add(new Nums(R.drawable.two, getString(R.string.twenty) + " " +
                        getString(R.string.two)));
                item.add(new Nums(R.drawable.three, getString(R.string.twenty) + " " +
                        getString(R.string.three)));
                item.add(new Nums(R.drawable.four, getString(R.string.twenty) + " " +
                        getString(R.string.four)));
                item.add(new Nums(R.drawable.five, getString(R.string.twenty) + " " +
                        getString(R.string.five)));
                item.add(new Nums(R.drawable.six, getString(R.string.twenty) + " " +
                        getString(R.string.six)));
                item.add(new Nums(R.drawable.seven, getString(R.string.twenty) + " " +
                        getString(R.string.seven)));
                item.add(new Nums(R.drawable.eight, getString(R.string.twenty) + " " +
                        getString(R.string.eight)));
                item.add(new Nums(R.drawable.nine, getString(R.string.twenty) + " " +
                        getString(R.string.nine)));
                break;
            case 3:
                item.add(new Nums(R.drawable.zero, getString(R.string.thirty)));
                item.add(new Nums(R.drawable.one, getString(R.string.thirty) + " " +
                        getString(R.string.one)));
                item.add(new Nums(R.drawable.two, getString(R.string.thirty) + " " +
                        getString(R.string.two)));
                item.add(new Nums(R.drawable.three, getString(R.string.thirty) + " " +
                        getString(R.string.three)));
                item.add(new Nums(R.drawable.four, getString(R.string.thirty) + " " +
                        getString(R.string.four)));
                item.add(new Nums(R.drawable.five, getString(R.string.thirty) + " " +
                        getString(R.string.five)));
                item.add(new Nums(R.drawable.six, getString(R.string.thirty) + " " +
                        getString(R.string.six)));
                item.add(new Nums(R.drawable.seven, getString(R.string.thirty) + " " +
                        getString(R.string.seven)));
                item.add(new Nums(R.drawable.eight, getString(R.string.thirty) + " " +
                        getString(R.string.eight)));
                item.add(new Nums(R.drawable.nine, getString(R.string.thirty) + " " +
                        getString(R.string.nine)));
                break;
            case 4:
                item.add(new Nums(R.drawable.zero, getString(R.string.forty)));
                item.add(new Nums(R.drawable.one, getString(R.string.forty) + " " +
                        getString(R.string.one)));
                item.add(new Nums(R.drawable.two, getString(R.string.forty) + " " +
                        getString(R.string.two)));
                item.add(new Nums(R.drawable.three, getString(R.string.forty) + " " +
                        getString(R.string.three)));
                item.add(new Nums(R.drawable.four, getString(R.string.forty) + " " +
                        getString(R.string.four)));
                item.add(new Nums(R.drawable.five, getString(R.string.forty) + " " +
                        getString(R.string.five)));
                item.add(new Nums(R.drawable.six, getString(R.string.forty) + " " +
                        getString(R.string.six)));
                item.add(new Nums(R.drawable.seven, getString(R.string.forty) + " " +
                        getString(R.string.seven)));
                item.add(new Nums(R.drawable.eight, getString(R.string.forty) + " " +
                        getString(R.string.eight)));
                item.add(new Nums(R.drawable.nine, getString(R.string.forty) + " " +
                        getString(R.string.nine)));
                break;
            case 5:
                item.add(new Nums(R.drawable.zero, getString(R.string.fifty)));
                item.add(new Nums(R.drawable.one, getString(R.string.fifty) + " " +
                        getString(R.string.one)));
                item.add(new Nums(R.drawable.two, getString(R.string.fifty) + " " +
                        getString(R.string.two)));
                item.add(new Nums(R.drawable.three, getString(R.string.fifty) + " " +
                        getString(R.string.three)));
                item.add(new Nums(R.drawable.four, getString(R.string.fifty) + " " +
                        getString(R.string.four)));
                item.add(new Nums(R.drawable.five, getString(R.string.fifty) + " " +
                        getString(R.string.five)));
                item.add(new Nums(R.drawable.six, getString(R.string.fifty) + " " +
                        getString(R.string.six)));
                item.add(new Nums(R.drawable.seven, getString(R.string.fifty) + " " +
                        getString(R.string.seven)));
                item.add(new Nums(R.drawable.eight, getString(R.string.fifty) + " " +
                        getString(R.string.eight)));
                item.add(new Nums(R.drawable.nine, getString(R.string.fifty) + " " +
                        getString(R.string.nine)));
                break;
            case 6:
                item.add(new Nums(R.drawable.zero, getString(R.string.sixty)));
                item.add(new Nums(R.drawable.one, getString(R.string.sixty) + " " +
                        getString(R.string.one)));
                item.add(new Nums(R.drawable.two, getString(R.string.sixty) + " " +
                        getString(R.string.two)));
                item.add(new Nums(R.drawable.three, getString(R.string.sixty) + " " +
                        getString(R.string.three)));
                item.add(new Nums(R.drawable.four, getString(R.string.sixty) + " " +
                        getString(R.string.four)));
                item.add(new Nums(R.drawable.five, getString(R.string.sixty) + " " +
                        getString(R.string.five)));
                item.add(new Nums(R.drawable.six, getString(R.string.sixty) + " " +
                        getString(R.string.six)));
                item.add(new Nums(R.drawable.seven, getString(R.string.sixty) + " " +
                        getString(R.string.seven)));
                item.add(new Nums(R.drawable.eight, getString(R.string.sixty) + " " +
                        getString(R.string.eight)));
                item.add(new Nums(R.drawable.nine, getString(R.string.sixty) + " " +
                        getString(R.string.nine)));
                break;
            case 7:
                item.add(new Nums(R.drawable.zero, getString(R.string.seventy)));
                item.add(new Nums(R.drawable.one, getString(R.string.seventy) + " " +
                        getString(R.string.one)));
                item.add(new Nums(R.drawable.two, getString(R.string.seventy) + " " +
                        getString(R.string.two)));
                item.add(new Nums(R.drawable.three, getString(R.string.seventy) + " " +
                        getString(R.string.three)));
                item.add(new Nums(R.drawable.four, getString(R.string.seventy) + " " +
                        getString(R.string.four)));
                item.add(new Nums(R.drawable.five, getString(R.string.seventy) + " " +
                        getString(R.string.five)));
                item.add(new Nums(R.drawable.six, getString(R.string.seventy) + " " +
                        getString(R.string.six)));
                item.add(new Nums(R.drawable.seven, getString(R.string.seventy) + " " +
                        getString(R.string.seven)));
                item.add(new Nums(R.drawable.eight, getString(R.string.seventy) + " " +
                        getString(R.string.eight)));
                item.add(new Nums(R.drawable.nine, getString(R.string.seventy) + " " +
                        getString(R.string.nine)));
                break;
            case 8:
                item.add(new Nums(R.drawable.zero, getString(R.string.eighty)));
                item.add(new Nums(R.drawable.one, getString(R.string.eighty) + " " +
                        getString(R.string.one)));
                item.add(new Nums(R.drawable.two, getString(R.string.eighty) + " " +
                        getString(R.string.two)));
                item.add(new Nums(R.drawable.three, getString(R.string.eighty) + " " +
                        getString(R.string.three)));
                item.add(new Nums(R.drawable.four, getString(R.string.eighty) + " " +
                        getString(R.string.four)));
                item.add(new Nums(R.drawable.five, getString(R.string.eighty) + " " +
                        getString(R.string.five)));
                item.add(new Nums(R.drawable.six, getString(R.string.eighty) + " " +
                        getString(R.string.six)));
                item.add(new Nums(R.drawable.seven, getString(R.string.eighty) + " " +
                        getString(R.string.seven)));
                item.add(new Nums(R.drawable.eight, getString(R.string.eighty) + " " +
                        getString(R.string.eight)));
                item.add(new Nums(R.drawable.nine, getString(R.string.eighty) + " " +
                        getString(R.string.nine)));
                break;
            case 9:
                item.add(new Nums(R.drawable.zero, getString(R.string.ninety)));
                item.add(new Nums(R.drawable.one, getString(R.string.ninety) + " " +
                        getString(R.string.one)));
                item.add(new Nums(R.drawable.two, getString(R.string.ninety) + " " +
                        getString(R.string.two)));
                item.add(new Nums(R.drawable.three, getString(R.string.ninety) + " " +
                        getString(R.string.three)));
                item.add(new Nums(R.drawable.four, getString(R.string.ninety) + " " +
                        getString(R.string.four)));
                item.add(new Nums(R.drawable.five, getString(R.string.ninety) + " " +
                        getString(R.string.five)));
                item.add(new Nums(R.drawable.six, getString(R.string.ninety) + " " +
                        getString(R.string.six)));
                item.add(new Nums(R.drawable.seven, getString(R.string.ninety) + " " +
                        getString(R.string.seven)));
                item.add(new Nums(R.drawable.eight, getString(R.string.ninety) + " " +
                        getString(R.string.eight)));
                item.add(new Nums(R.drawable.nine, getString(R.string.ninety) + " " +
                        getString(R.string.nine)));
                break;
        }
    }
}
