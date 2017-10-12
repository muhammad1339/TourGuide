package com.proprog.tourguide;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by mohamedAHMED on 2017-10-11.
 */

public class PlaceListAdapter extends ArrayAdapter<Place> {
    Context context;

    public PlaceListAdapter(@NonNull Context context, ArrayList<Place> places) {
        super(context, 0, places);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View placeItemView = convertView;
        if (placeItemView == null) {
            placeItemView = LayoutInflater.from(context).inflate(R.layout.place_item, parent, false);
        }
        ImageView placeImage = placeItemView.findViewById(R.id.place_image);
        TextView placeNameText = placeItemView.findViewById(R.id.place_name_text);
        TextView placeDescText = placeItemView.findViewById(R.id.place_desc_text);
        Place place = getItem(position);
        int img_src_id;
        if (place != null) {
            placeNameText.setText(place.getPlaceName());
            placeDescText.setText(place.getPlaceDesc());
            img_src_id = place.getPlaceImage();
            Log.v("",""+img_src_id);
            if (img_src_id > 0) {
                placeImage.setImageResource(img_src_id);
            } else {
                placeImage.setVisibility(View.GONE);
            }
        }
        return placeItemView;
    }
}
