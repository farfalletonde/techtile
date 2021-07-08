package com.example.techtile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.techtile.databinding.ActivityDetailsBinding;
import com.example.techtile.ui.explore.Explore;
import com.example.techtile.ui.for_you.ForYouFragment;
import com.example.techtile.ui.profile.ProfileFragment;
import com.example.techtile.ui.wallet.WalletFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Details extends AppCompatActivity
        implements ForYouFragment.ForYouFgClickListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        navView.setSelectedItemId(R.id.navigation_for_you);

        initialUI();

    }

    private void initialUI() {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        this.getSupportActionBar().hide();
    }

    @Override
    public void onPagerItemClickedListener(int position) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.details_fragment_container, SelectedEventFragment.newInstance())
                .addToBackStack(SelectedEventFragment.TAG)
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFg;

        switch (item.getItemId()) {

            case R.id.navigation_explore:
                selectedFg = Explore.newInstance();
                break;

            case R.id.navigation_wallet:
                selectedFg = WalletFragment.newInstance();
                break;

            case R.id.navigation_profile:
                selectedFg = ProfileFragment.newInstance();
                break;

            default:
                selectedFg = ForYouFragment.newInstance();
                break;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.details_fragment_container, selectedFg)
                .commit();

        return true;
    }

}