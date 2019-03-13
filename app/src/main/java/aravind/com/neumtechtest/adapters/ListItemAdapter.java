package aravind.com.neumtechtest.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import aravind.com.neumtechtest.models.JobInfoModel;
import aravind.com.neumtechtest.R;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ViewHolder> {

    private Context mContext;
    private List<JobInfoModel> lstJobInfoModels;
private onItemSelected mOnItemSelected;

    public ListItemAdapter(Context mContext, List<JobInfoModel> jobInfoModels , onItemSelected onItemSelected) {
        this.mContext = mContext;
        this.lstJobInfoModels = jobInfoModels;
        this.mOnItemSelected = onItemSelected;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_child, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        JobInfoModel model = lstJobInfoModels.get(position);
        viewHolder.mTVDay.setText(model.getWhen());
        viewHolder.mTVHeader.setText(model.getJobName());
        viewHolder.mTVDesc.setText(model.getJobDesc());
        viewHolder.mTVTime.setText(model.getTime());
        viewHolder.mTVDistance.setText(model.getDistance());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemSelected !=null)
                    mOnItemSelected.onItemSelected(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstJobInfoModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTVDay;
        TextView mTVHeader;
        TextView mTVDesc;
        TextView mTVTime;
        TextView mTVDistance;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTVDay = itemView.findViewById(R.id.tv_day);
            mTVHeader = itemView.findViewById(R.id.tv_header);
            mTVDesc = itemView.findViewById(R.id.tv_desc);
            mTVTime = itemView.findViewById(R.id.tv_time);
            mTVDistance = itemView.findViewById(R.id.tv_distance);
        }
    }
    public interface  onItemSelected{
        void onItemSelected(int position);
    }
}
