package com.example.techtile.ui.for_you;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.techtile.Adapters.MyPagerAdapter;
import com.example.techtile.R;
import com.example.techtile.databinding.FragmentForYouBinding;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ForYouFragment extends Fragment
        implements AdapterView.OnItemSelectedListener,
        MyPagerAdapter.PagerClickListener {

    private View root;
    private ViewPager vp;
    private TabLayout layout;
    private ForYouViewModel forYouViewModel;
    private FragmentForYouBinding binding;

    private ForYouFgClickListener mListener;

    // private PageAdapter.Clicked clicked;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        forYouViewModel =
                new ViewModelProvider(this).get(ForYouViewModel.class);

        binding = FragmentForYouBinding.inflate(inflater, container, false);
        root = binding.getRoot();
        return root;
    }

    public static ForYouFragment newInstance() {
        return new ForYouFragment();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI();
        initViewPager();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void initUI() {
        vp = root.findViewById(R.id.viewPager);
        layout = root.findViewById(R.id.tabLayout);
    }

    private void initViewPager() {
        //vp = (ViewPager) findViewById(R.id.viewPager);
        /*final PageAdapter adapter = new PageAdapter(getContext(), getActivity().getSupportFragmentManager(),
                layout.getTabCount(), clicked);*/

        ArrayList<View> arr = new ArrayList<>();
        arr.add(new View(getContext()));
        arr.add(new View(getContext()));
        arr.add(new View(getContext()));

        MyPagerAdapter adapter = new MyPagerAdapter(getContext(), arr, this);
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(layout));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        layout.getTabAt(position).select();
        layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
                //topTw.setText(String.valueOf(tab.getPosition() + 1) + getText(R.string.weekNo));
                // spinner.setSelection(tab.getPosition());
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void pagerItemClicked(int position) {
        if (mListener != null) mListener.onPagerItemClickedListener(position);
    }

    public interface ForYouFgClickListener {

        void onPagerItemClickedListener(int position);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ForYouFgClickListener) {
            mListener = (ForYouFgClickListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement ForYouFragment.ForYouFgClickListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();

        if (mListener != null)
            mListener = null;

    }
}