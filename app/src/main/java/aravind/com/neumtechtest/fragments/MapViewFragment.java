package aravind.com.neumtechtest.fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import aravind.com.neumtechtest.R;
import aravind.com.neumtechtest.adapters.MapsPagerAdapter;
import aravind.com.neumtechtest.constants.Singleton;
import aravind.com.neumtechtest.models.JobInfoModel;

public class MapViewFragment extends Fragment {
    private Context mContext;
    MapView mapView;
    GoogleMap map;
    ViewPager viewPager;
    private List<JobInfoModel> lstJobInfoModel;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        lstJobInfoModel = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.map_view_fragment, container, false);
        mapView = rootView.findViewById(R.id.map);
        viewPager = rootView.findViewById(R.id.mapsPager);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        lstJobInfoModel = Singleton.getInstance().getJobInfoModels();
        try {
            MapsInitializer.initialize(Objects.requireNonNull(getActivity()).getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                map = mMap;

                // For showing a move to my location button
                if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                map.setMyLocationEnabled(true);

                JobInfoModel model = lstJobInfoModel.get(0);
                addMarker(model);
                // For dropping a marker at a point on the Map
            }
        });

        MapsPagerAdapter mapsPagerAdapter = new MapsPagerAdapter(mContext, Singleton.getInstance().getJobInfoModels());
        int pagerPadding = 40;
        viewPager.setClipToPadding(false);
        viewPager.setPadding(pagerPadding, 0, pagerPadding + pagerPadding, 0);
        viewPager.setAdapter(mapsPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
               /* if (position > -1 && lstJobInfoModel.size() > position) {
                    JobInfoModel model = lstJobInfoModel.get(position);
                    addMarker(model);
                }*/
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
        return rootView;
    }

    private void addMarker(JobInfoModel model) {
        LatLng sydney = new LatLng(model.getLatitude(), model.getLongitude());
        map.addMarker(new MarkerOptions().position(sydney).title(model.getJobName()).snippet(model.getJobDesc())).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.loc));
        // For zooming automatically to the location of the marker
        CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    public void setSelectedPosition(int position) {
        if (lstJobInfoModel != null && lstJobInfoModel.size() > position) {
            JobInfoModel model = lstJobInfoModel.get(position);
            addMarker(model);
            viewPager.setCurrentItem(position);
        }
    }
}
