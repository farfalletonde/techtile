package com.example.techtile;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.techtile.databinding.FragmentViewPagerBinding;

public class viewPagerFragment extends Fragment {

    private Context c;
    private int position;


    public  viewPagerFragment(Context c , int position) {
        this.c = c;
        this.position = position;
    }


    public static viewPagerFragment newInstance(Context c , int position) {
        viewPagerFragment fragment = new viewPagerFragment(c,position);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

}