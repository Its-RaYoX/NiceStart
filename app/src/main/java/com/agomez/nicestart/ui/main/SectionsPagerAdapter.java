package com.agomez.nicestart.ui.main;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import com.agomez.nicestart.fragments.Page1;
import com.agomez.nicestart.fragments.Page2;
import com.agomez.nicestart.fragments.Page3;
import com.agomez.nicestart.fragments.Page4;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;
    private final PageViewModel mViewModel;

    // Constructor modificado para aceptar el ViewModel
    public SectionsPagerAdapter(Context context, FragmentManager fm, PageViewModel viewModel) {
        super(fm);
        mContext = context;
        mViewModel = viewModel; // Aquí se inicializa correctamente el ViewModel
    }

    @Override
    public Fragment getItem(int position) {
        // Sincroniza la selección de fragmento con el ViewModel
        mViewModel.setIndex(position);

        switch (position) {
            case 0:
                return new Page1();
            case 1:
                return new Page2();
            case 2:
                return new Page3();
            case 3:
                return new Page4();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
