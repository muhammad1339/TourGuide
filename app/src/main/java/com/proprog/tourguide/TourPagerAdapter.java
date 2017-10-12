package com.proprog.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by mohamedAHMED on 2017-10-09.
 */

public class TourPagerAdapter extends FragmentPagerAdapter {

    Context context;

    public TourPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MallFragment();
            case 1:
                return new RestaurantFragment();
            case 2:
                return new BankFragment();
            default:
                return new ImportantPlacesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.restaurant_fragment_title);
            case 1:
                return context.getString(R.string.bank_fragment_title);
            case 2:
                return context.getString(R.string.mall_fragment_title);
            default:
                return context.getString(R.string.important_places_fragment_title);
        }
    }

    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }
}
