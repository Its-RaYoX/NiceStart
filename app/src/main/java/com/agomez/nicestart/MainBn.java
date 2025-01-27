package com.agomez.nicestart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.agomez.nicestart.databinding.ActivityMainBnBinding;
import com.agomez.nicestart.ui.main.PageViewModel;
import com.agomez.nicestart.ui.main.SectionsPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainBn extends AppCompatActivity {

    private ActivityMainBnBinding binding;
    private MenuItem prevMenuItem;
    private SectionsPagerAdapter sectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bn);
        binding = ActivityMainBnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtener el PageViewModel usando ViewModelProvider
        PageViewModel viewModel = new ViewModelProvider(this).get(PageViewModel.class);

        // Crear el adaptador pasando el Context, FragmentManager y el PageViewModel
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), viewModel);

        // Configurar ViewPager
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        // Configurar BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.page1) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Likes clicked.", Toast.LENGTH_SHORT).show();
                    viewPager.setCurrentItem(0);
                } else if (item.getItemId() == R.id.page2) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                    viewPager.setCurrentItem(1);
                } else if (item.getItemId() == R.id.page3) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Browse clicked.", Toast.LENGTH_SHORT).show();
                    viewPager.setCurrentItem(2);
                } else if (item.getItemId() == R.id.page4) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Personal clicked.", Toast.LENGTH_SHORT).show();
                    viewPager.setCurrentItem(3);
                }
                return false;
            }
        });

        // Cambiar el BottomNavigationView cuando se cambia la página del ViewPager
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
