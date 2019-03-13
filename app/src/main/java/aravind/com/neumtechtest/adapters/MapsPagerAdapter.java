package aravind.com.neumtechtest.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import aravind.com.neumtechtest.R;
import aravind.com.neumtechtest.models.JobInfoModel;

public class MapsPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<JobInfoModel> lstJobInfoModels;

    public MapsPagerAdapter(Context mContext, List<JobInfoModel> jobInfoModels) {
        this.mContext = mContext;
        this.lstJobInfoModels = jobInfoModels;
    }

    @Override
    public int getCount() {
        return lstJobInfoModels.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_child, container, false);
        TextView mTVDay = view.findViewById(R.id.tv_day);
        TextView mTVHeader = view.findViewById(R.id.tv_header);
        TextView mTVDesc = view.findViewById(R.id.tv_desc);
        TextView mTVTime = view.findViewById(R.id.tv_time);
        TextView mTVDistance = view.findViewById(R.id.tv_distance);

        JobInfoModel model = lstJobInfoModels.get(position);
        mTVDay.setText(model.getWhen());
        mTVHeader.setText(model.getJobName());
        mTVDesc.setText(model.getJobDesc());
        mTVTime.setText(model.getTime());
        mTVDistance.setText(model.getDistance());
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

/*
    @Override
    public float getPageWidth(int position) {
        return 0.93f;
    }
*/

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
