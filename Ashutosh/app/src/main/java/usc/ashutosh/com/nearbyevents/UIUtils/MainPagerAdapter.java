package usc.ashutosh.com.nearbyevents.UIUtils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private PagerAdapterListner pagerListner;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MainPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        if (context instanceof PagerAdapterListner) {
            pagerListner = (PagerAdapterListner) context;
        }

    }

    @Override
    public Fragment getItem(int position) {
        /*switch (position) {
            case 0:
                return new Search();
            case 1:
                return new Favourite();
        }
        return null;*/
        if (pagerListner != null) {
            return pagerListner.getItem(position);
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        /*return 2;*/                       //TODO remove hardcoding
        if (pagerListner != null) {
            return pagerListner.getCount();
        } else {
            return 2;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        /*switch (position) {
            case 0:
                return "Search";         //TODO remove hardcoding
            case 1:
                return "Favourite";
            default:
                return "not found";
        }*/
        if (pagerListner != null) {
            return pagerListner.getPageTitle(position);
        } else {
            return null;
        }

    }

    public interface PagerAdapterListner {
        Fragment getItem(int position);

        int getCount();

        CharSequence getPageTitle(int position);
    }
}
