package com.agomez.nicestart;



import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * main class here
 */
public class MainBab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bab);

        // Obtener las referencias al BottomAppBar y FloatingActionButton
        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);
        FloatingActionButton myfab = findViewById(R.id.fab);

        // Click event en el Floating Action Button (FAB)
        myfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainBab.this, "FAB Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Click event en el botón de navegación (Hamburguer menu)
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainBab.this, "Menu clicked", Toast.LENGTH_SHORT).show();
                // Aquí podrías agregar acciones adicionales, como mostrar un BottomSheet
            }
        });

        // Click event en el Bottom App Bar menu item
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.heart) {
                    Toast.makeText(MainBab.this, "Added to favourites", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.search) {
                    Toast.makeText(MainBab.this, "Beginning search", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}
