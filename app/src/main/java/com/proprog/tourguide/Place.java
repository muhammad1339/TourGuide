package com.proprog.tourguide;

/**
 * Created by mohamedAHMED on 2017-10-11.
 */

public class Place {
    private String placeName;
    private String placeDesc;
    private String placeLoc;
    private int placeImage;

    public Place(String placeName, String placeDesc, String placeLoc) {
        this.placeName = placeName;
        this.placeDesc = placeDesc;
        this.placeLoc = placeLoc;
    }

    public Place(String placeName, String placeDesc, String placeLoc, int placeImage) {
        this.placeName = placeName;
        this.placeDesc = placeDesc;
        this.placeLoc = placeLoc;
        this.placeImage = placeImage;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceDesc() {
        return placeDesc;
    }

    public int getPlaceImage() {
        return placeImage;
    }

    public String getPlaceLoc() {
        return placeLoc;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeName='" + placeName + '\'' +
                ", placeDesc='" + placeDesc + '\'' +
                ", placeImage=" + placeImage +
                '}';
    }
}
