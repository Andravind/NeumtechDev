package aravind.com.neumtechtest.activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.Objects;

import aravind.com.neumtechtest.interfaces.onItemSelectedListener;
import aravind.com.neumtechtest.utilities.CommonUtilities;
import aravind.com.neumtechtest.adapters.DashBoardViewPagerAdapter;
import aravind.com.neumtechtest.R;
import aravind.com.neumtechtest.constants.Singleton;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Context mContext;
    private DashBoardViewPagerAdapter mDashBoardViewPagerAdapter;
    private Singleton singleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        singleton = Singleton.getInstance();
        toolbar = findViewById(R.id.toolbar);
        ImageView mIVMenu = findViewById(R.id.iv_menu);
        mIVMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, PlumbingActivity.class));
            }
        });
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);
        singleton.setJobInfoModels(CommonUtilities.getListofJobLocations());
        String[] mDashboardTabNames = mContext.getResources().getStringArray(R.array.dash_items);
        viewPager.setOffscreenPageLimit(mDashboardTabNames.length);
        mDashBoardViewPagerAdapter = new DashBoardViewPagerAdapter(getSupportFragmentManager(), mContext, mDashboardTabNames.length, new onItemSelectedListener() {
            @Override
            public void onItemSelectedLister(int position) {
                viewPager.setCurrentItem(1);
                mDashBoardViewPagerAdapter.setListAdaptedValue(position);
            }
        });
        for (String tabName : mDashboardTabNames)
            mDashBoardViewPagerAdapter.addFragment(tabName);
        viewPager.setAdapter(mDashBoardViewPagerAdapter);
    }
}
