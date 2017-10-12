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

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.resource;
import static android.R.attr.theme;

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
        ViewHolder holder;
        if (placeItemView == null) {
            placeItemView = LayoutInflater.from(context).inflate(R.layout.place_item, parent, false);
            holder = new ViewHolder(placeItemView);
            placeItemView.setTag(holder);
        } else {
            holder = (ViewHolder) placeItemView.getTag();
        }
        Log.v("", holder.toString());
        Place place = getItem(position);
        int img_src_id;
        if (place != null) {
            holder.placeNameText.setText(place.getPlaceName());
            holder.placeDescText.setText(place.getPlaceDesc());
            img_src_id = place.getPlaceImage();
            if (img_src_id > 0) {
                holder.placeImage.setImageResource(img_src_id);
            } else {
                holder.placeImage.setVisibility(View.GONE);
            }
        }
        return placeItemView;
    }

    static class ViewHolder {
        @BindView(R.id.place_image)
        ImageView placeImage;
        @BindView(R.id.place_name_text)
        TextView placeNameText;
        @BindView(R.id.place_desc_text)
        TextView placeDescText;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        @Override
        public String toString() {
            return "ViewHolder{" +
                    "placeImage=" + placeImage +
                    ", placeNameText=" + placeNameText +
                    ", placeDescText=" + placeDescText +
                    '}';
        }
    }
}
