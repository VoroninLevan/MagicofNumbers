package comvoroninlevan.httpsgithub.magicofnumbers;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import comvoroninlevan.httpsgithub.magicofnumbers.NumberFragments.EightFragment;
import comvoroninlevan.httpsgithub.magicofnumbers.NumberFragments.FiveFragment;
import comvoroninlevan.httpsgithub.magicofnumbers.NumberFragments.FourFragment;
import comvoroninlevan.httpsgithub.magicofnumbers.NumberFragments.NineFragment;
import comvoroninlevan.httpsgithub.magicofnumbers.NumberFragments.OneFragment;
import comvoroninlevan.httpsgithub.magicofnumbers.NumberFragments.SevenFragment;
import comvoroninlevan.httpsgithub.magicofnumbers.NumberFragments.SixFragment;
import comvoroninlevan.httpsgithub.magicofnumbers.NumberFragments.ThreeFragment;
import comvoroninlevan.httpsgithub.magicofnumbers.NumberFragments.TwoFragment;
import comvoroninlevan.httpsgithub.magicofnumbers.NumberFragments.ZeroFragment;

/**
 * Created by Levan on 14.10.2017.
 */

public class NumberFragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public NumberFragmentAdapter(Context context, FragmentManager fragmentManager){
        super(fragmentManager);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new OneFragment();
            case 1:
                return new TwoFragment();
            case 2:
                return new ThreeFragment();
            case 3:
                return new FourFragment();
            case 4:
                return new FiveFragment();
            case 5:
                return new SixFragment();
            case 6:
                return new SevenFragment();
            case 7:
                return new EightFragment();
            case 8:
                return new NineFragment();
            default:
                return new ZeroFragment();
        }
    }

    @Override
    public int getCount() {
        return 10;
    }
}
