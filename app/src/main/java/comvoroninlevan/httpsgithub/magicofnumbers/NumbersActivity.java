package comvoroninlevan.httpsgithub.magicofnumbers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Levan on 11.10.2017.
 */

public class NumbersActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        hide();
        
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
        NumberFragmentAdapter fragmentAdapter = new NumberFragmentAdapter(this,
                getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
    }

    private void hide() {
        // Hide UI
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
