package aravind.com.neumtechtest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import aravind.com.neumtechtest.R;
import aravind.com.neumtechtest.constants.Singleton;
import aravind.com.neumtechtest.adapters.ListItemAdapter;
import aravind.com.neumtechtest.interfaces.onItemSelectedListener;

public class ListViewFragment extends Fragment {

    private Context mContext;
    private RecyclerView recyclerView;
    private ListItemAdapter mLstAdapter;
    private onItemSelectedListener onItemSelectedListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_main, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mLstAdapter = new ListItemAdapter(mContext, Singleton.getInstance().getJobInfoModels(), new ListItemAdapter.onItemSelected() {
            @Override
            public void onItemSelected(int position) {
                if (onItemSelectedListener != null)
                    onItemSelectedListener.onItemSelectedLister(position);

            }
        });
        recyclerView.setAdapter(mLstAdapter);
        return rootView;
    }

    public void setListener(onItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }
}
