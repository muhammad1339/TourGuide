package com.proprog.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
public class BankFragment extends Fragment {

    private ArrayList<Place> places;

    public BankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //prepare string resources in string array to fill the list
        String[] banks = getActivity().getResources().getStringArray(R.array.banks);
        String[] banksDesc = getActivity().getResources().getStringArray(R.array.bank_desc);
        String[] banksLoc = getActivity().getResources().getStringArray(R.array.bank_location);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.place_list, container, false);

        places = new ArrayList<>();
        Place place;
        for (int i = 0; i < banks.length; i++) {
            place = new Place(banks[i], banksDesc[i], banksLoc[i]);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(loc)
                        .setIcon(R.mipmap.ic_launcher)
                        .setTitle("LOCATION");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        return view;
    }

}
