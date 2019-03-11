package aravind.com.neumtechtest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class DashBoardViewPagerAdapter extends FragmentStatePagerAdapter {
    private final int tabCount;
    private final Context mContext;
    private final List<String> mFraStringList = new ArrayList<>();
    private ListViewFragment lstFragment ;
    private MapViewFragment mapFragment;

    public DashBoardViewPagerAdapter(FragmentManager fm, Context context, int tabCount) {
        super(fm);
        this.mContext = context;
        this.tabCount = tabCount;
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
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    public void addFragment(String tabName) {
        mFraStringList.add(tabName);
    }
}
