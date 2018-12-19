package usc.ashutosh.com.nearbyevents;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import usc.ashutosh.com.nearbyevents.UIUtils.MainPagerAdapter;

public class EventSearchActivity extends FragmentActivity implements Favourite.OnFragmentInteractionListener, Search.OnFragmentInteractionListener, MainPagerAdapter.PagerAdapterListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_search);
        setSlidingTab();
    }

    private void setSlidingTab() {
        ViewPager viewPager = findViewById(R.id.pager);
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(mainPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onSearchFragmentInteraction(Uri string) {
        // Do stuff
    }

    @Override
    public void onFavouriteFragmentInteraction(Uri string) {
        // Do different stuff
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Search();
            case 1:
                return new Favourite();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return this.getString(R.string.search);
            case 1:
                return this.getString(R.string.favourite);
            default:
                return "not found";
        }
    }
}
