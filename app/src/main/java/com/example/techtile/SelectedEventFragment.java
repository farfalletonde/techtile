package com.example.techtile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class SelectedEventFragment extends Fragment {

    public static final String TAG = "SelectedEventFragment";

    private View root;
    private TextView event_vip;
    private TextView event_day;
    private TextView event_month;
    private ImageView event_image;
    private TextView event_name;
    private TextView event_rating;
    private TextView event_location;
    private TextView event_desc;

    // TODO: Rename and change types and number of parameters
    public static SelectedEventFragment newInstance() {
        return new SelectedEventFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_selected_event, container, false);
        return root;
    }

    private void initalUI() {
        event_vip = root.findViewById(R.id.vip_only);
        event_day = root.findViewById(R.id.event_day);
        event_month = root.findViewById(R.id.event_month);
        event_image = root.findViewById(R.id.event_image);
        event_name = root.findViewById(R.id.event_name);
        event_rating = root.findViewById(R.id.event_rating);
        event_location = root.findViewById(R.id.event_location);
        event_desc = root.findViewById(R.id.event_desc);
    }

    private void initalitems() {

    }
}