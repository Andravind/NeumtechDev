package aravind.com.neumtechtest.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import aravind.com.neumtechtest.fragments.ListViewFragment;
import aravind.com.neumtechtest.fragments.MapViewFragment;
import aravind.com.neumtechtest.interfaces.onItemSelectedListener;

public class DashBoardViewPagerAdapter extends FragmentStatePagerAdapter {
    private final int tabCount;
    private final Context mContext;
    private final List<String> mFraStringList = new ArrayList<>();
    private ListViewFragment lstFragment ;
    private MapViewFragment mapFragment;
    private onItemSelectedListener onItemSelectedListener;

    public DashBoardViewPagerAdapter(FragmentManager fm, Context context, int tabCount , onItemSelectedListener onItemSelectedListener) {
        super(fm);
        this.mContext = context;
        this.tabCount = tabCount;
        this.onItemSelectedListener = onItemSelectedListener;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFraStringList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            default:
            case 0:
                if(lstFragment == null) {
                    lstFragment = new ListViewFragment();
                    lstFragment.setListener(onItemSelectedListener);
                }
                return lstFragment;
            case 1:
                if (mapFragment ==null)
                mapFragment = new MapViewFragment();
                return mapFragment;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    public void addFragment(String tabName) {
        mFraStringList.add(tabName);
    }

    public void setListAdaptedValue(int position) {
        if (mapFragment != null)
            mapFragment.setSelectedPosition(position);
    }
}
