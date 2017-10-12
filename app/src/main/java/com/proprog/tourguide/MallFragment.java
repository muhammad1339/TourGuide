package com.proprog.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MallFragment extends Fragment {

    ArrayList<Place> places;

    public MallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //prepare string resources in string array to fill the list
        String[] malls = getActivity().getResources().getStringArray(R.array.malls);
        String[] mallsDesc = getActivity().getResources().getStringArray(R.array.mall_desc);
        String[] mallsLoc = getActivity().getResources().getStringArray(R.array.mall_location);
        int[] imgSrc = {R.drawable.mall_braun, R.drawable.mall_dots,
                R.drawable.mall_vanity, R.drawable.mall_family,
                R.drawable.mall_agyad, R.drawable.mall_btech, R.drawable.mall_activ};
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.place_list, container, false);

        places = new ArrayList<>();
        Place place;
        for (int i = 0; i < malls.length; i++) {
            place = new Place(malls[i], mallsDesc[i], mallsLoc[i], imgSrc[i]);
            places.add(place);
            Log.v("", place.toString());
        }
        ListView placeListView = view.findViewById(R.id.place_list_view);
        PlaceListAdapter adapter = new PlaceListAdapter(getActivity().getApplicationContext(), places);
        placeListView.setAdapter(adapter);
        placeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Place clickedPlace = places.get(position);
                String loc = clickedPlace.getPlaceLoc();
                DialogLocationFragment locationFragment = new DialogLocationFragment();
                locationFragment.setLoc(loc);
                locationFragment.show(getActivity().getSupportFragmentManager(), "");
            }
        });
        return view;
    }

}
