package fr.guddy.android_modular_reloaded.second;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.guddy.android_modular_reloaded.R;

public class FragmentSecond extends Fragment {

    //region Factory
    public FragmentSecond() {
        // Required empty public constructor
    }

    public static FragmentSecond newInstance() {
        final FragmentSecond lFragment = new FragmentSecond();
        final Bundle lArgs = new Bundle();
        lFragment.setArguments(lArgs);
        return lFragment;
    }
    //endregion

    //region Lifecycle
    @Override
    public View onCreateView(final LayoutInflater pInflater,
                             final ViewGroup pContainer,
                             final Bundle pSavedInstanceState) {
        return pInflater.inflate(R.layout.fragment_second, pContainer, false);
    }
    //endregion

}
