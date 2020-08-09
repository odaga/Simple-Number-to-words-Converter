package com.ugtechie.numberandcurrencyconvertor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ugtechie.numberandcurrencyconvertor.fragments.CurrencyConvertorFragment;
import com.ugtechie.numberandcurrencyconvertor.fragments.NumbersToWordsConverterFragment;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                new NumbersToWordsConverterFragment()).commit();
    }

   private BottomNavigationView.OnNavigationItemSelectedListener navListener =
           new BottomNavigationView.OnNavigationItemSelectedListener() {
               @Override
               public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                   Fragment selectedFragment = null;

                   switch (item.getItemId()) {
                       case R.id.number_to_words_converter:
                           selectedFragment = new NumbersToWordsConverterFragment();
                           break;

                       case R.id.currency_converter:
                           selectedFragment = new CurrencyConvertorFragment();
                           break;
                   }
                   getSupportFragmentManager().beginTransaction()
                           .replace(R.id.frame_layout, selectedFragment).commit();
                   return true;
               }
           };
}