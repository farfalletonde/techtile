package com.example.techtile.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.techtile.R;
import com.example.techtile.viewPagerFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PageAdapter extends PagerAdapter {
  /*  private static final String TAG = "Page Adapter";
    private Context myContext;
    int totalTabs;
    private int weekNo;
    private LayoutInflater layoutInflater;
    private Clicked listener;
    public PageAdapter(Context context, FragmentManager fm, int totalTabs, Clicked listener) {
        super(fm);
        this.weekNo = weekNo;
        this.listener = listener;
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        viewPagerFragment teamFragment = new viewPagerFragment(myContext, position);
        return teamFragment;
    }


    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.9f;
    }
    public Fragment getCountryAt(int position) {
        return getItem(position);
    }

    @Override
    public Object instantiateItem(View collection, final int pos) { //have to make final so we can see it inside of onClick()
        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View page = inflater.inflate(R.layout.fragment_view_pager, null);

        page.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               listener.clickedListener(String.valueOf(getItemPosition(v)));
            }
        });


        ((ViewPager) collection).addView(page, 0);
        return page;
    }
    public interface Clicked{
        public void clickedListener(String pos);
    }
}*/

    private ArrayList<View> arrayList;
    private Context context;

    public PageAdapter() {

    }

    public PageAdapter(ArrayList<View> arraylist, Context context) {
        super();
        this.arrayList = arraylist;
        this.context = context;
    }

    // Return the number of views
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        // When the return is true, the view obtained according to the current position will be displayed
        return view == object;
    }

    // The function of this method is to remove the view corresponding to position from the container,
    // And this removal is done before finishUpdate.
    // This is also mentioned in the instantiateItem method,
    // In other words, at least two actions must be completed before finishUpdate ①Removal of the original view ②Addition of the new view
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(arrayList.get(position));
    }


    private CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public interface CallBack {
        void OnClick(int position);
    }


}

