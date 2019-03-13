package aravind.com.neumtechtest;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Context mContext;
    private DashBoardViewPagerAdapter mDashBoardViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        Objects.requireNonNull(getSupportActionBar()).setTitle("NeumtechTest");
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);
        List<JobInfoModel> lstJobInfo = new ArrayList<>();
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        lstJobInfo.add(new JobInfoModel("Lorem Ipsum", "Lorem Ipsum", 12.972442, 77.580643, "bvnbsdvhsbdv"));
        String[] mDashboardTabNames = mContext.getResources().getStringArray(R.array.dash_items);
        viewPager.setOffscreenPageLimit(mDashboardTabNames.length);
        mDashBoardViewPagerAdapter = new DashBoardViewPagerAdapter(getSupportFragmentManager(), mContext, mDashboardTabNames.length);
        for (String tabName : mDashboardTabNames)
            mDashBoardViewPagerAdapter.addFragment(tabName);
        viewPager.setAdapter(mDashBoardViewPagerAdapter);
    }
}
