package com.proprog.tourguide;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;


public class DialogLocationFragment extends DialogFragment {
    private String loc;

    public DialogLocationFragment() {

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("Location")
                .setMessage(loc)
                .setIcon(R.mipmap.ic_launcher)
                .create();
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
