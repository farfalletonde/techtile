package com.example.techtile.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.techtile.R;

import java.util.ArrayList;

public class MyPagerAdapter extends PagerAdapter {

    private ArrayList<View> arrayList;
    private Context context;
    private PagerClickListener pagerClickListener;

    public MyPagerAdapter(@NonNull Context context,
                          ArrayList<View> arrayList,
                          @NonNull PagerClickListener pagerClickListener) {
        this.arrayList = arrayList;
        this.context = context;
        this.pagerClickListener = pagerClickListener;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View page = LayoutInflater.from(context)
                .inflate(R.layout.fragment_view_pager, container, false);

        page.setOnClickListener(v -> {
            if (pagerClickListener != null) pagerClickListener.pagerItemClicked(position);
        });

        ((ViewPager) container).addView(page);
        return page;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.9f;
    }

    public interface PagerClickListener {
        void pagerItemClicked(int position);
    }
}
