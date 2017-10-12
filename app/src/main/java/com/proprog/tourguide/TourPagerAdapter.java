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
        if (position == 0) {
            return new RestaurantFragment();
        } else if (position == 1) {
            return new BankFragment();
        } else if (position == 2) {
            return new MallFragment();
        } else if (position == 3) {
            return new ImportantPlacesFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.restaurant_fragment_title);
        } else if (position == 1) {
            return context.getString(R.string.bank_fragment_title);
        } else if (position == 2) {
            return context.getString(R.string.mall_fragment_title);
        } else {
            return context.getString(R.string.important_places_fragment_title);
        }
    }

    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }
}
