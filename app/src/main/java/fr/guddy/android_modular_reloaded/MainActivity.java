package fr.guddy.android_modular_reloaded;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import fr.guddy.android_modular_reloaded.first.FragmentFirst;
import fr.guddy.android_modular_reloaded.second.FragmentSecond;

public class MainActivity extends AppCompatActivity implements FragmentFirst.OnFragmentInteractionListener {

    //region Lifecycle
    @Override
    protected void onCreate(final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ActivityMain_ViewGroup_Container, FragmentFirst.newInstance())
                .commit();

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Log.d(MainActivity.class.getSimpleName(), "onBackStackChanged");
            }
        });
    }
    //endregion
    
    //region Overridden methods
    @Override
    public void onBackPressed() {
        final FragmentManager lFragmentManager = getSupportFragmentManager();
        if (lFragmentManager.getBackStackEntryCount() > 0) {
            Log.d(MainActivity.class.getSimpleName(), "popping backstack");
            lFragmentManager.popBackStack();
        } else {
            Log.d(MainActivity.class.getSimpleName(), "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }
    //endregion

    //region FragmentFirst.OnFragmentInteractionListener
    @Override
    public void onClickNext() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ActivityMain_ViewGroup_Container, FragmentSecond.newInstance())
                .addToBackStack(null)
                .commit();
    }
    //endregion
}
