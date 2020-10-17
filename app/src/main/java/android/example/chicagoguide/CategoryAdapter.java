package android.example.chicagoguide;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {



    public CategoryAdapter(FragmentManager fm) {
        super(fm);

    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HotelsFragment();
        } else if (position == 1) {
            return new MuseumFragment();
        } else if (position == 2) {
            return new ParksFragment();
        } else {
            return new RestaurantsFragments();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Hotels";
        } else if (position == 1) {
            return "Museums";
        } else if (position == 2) {
            return "Parks";
        } else {
            return "Restaurants";
        }
    }
}
