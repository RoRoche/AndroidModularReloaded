package fr.guddy.android_modular_reloaded;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import fr.guddy.android_modular_reloaded.first.FragmentFirst;
import fr.guddy.android_modular_reloaded.first.FragmentFirstBuilder;
import fr.guddy.android_modular_reloaded.second.FragmentSecondBuilder;

public class MainActivity extends AppCompatActivity implements FragmentFirst.OnFragmentInteractionListener {

    //region Lifecycle
    @Override
    protected void onCreate(final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ActivityMain_ViewGroup_Container, new FragmentFirstBuilder().build())
                .commit();
    }
    //endregion

    //region Overridden methods
    @Override
    public void onBackPressed() {
        final FragmentManager lFragmentManager = getSupportFragmentManager();
        if (lFragmentManager.getBackStackEntryCount() > 0) {
            lFragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
    //endregion

    //region FragmentFirst.OnFragmentInteractionListener
    @Override
    public void onClickNext() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ActivityMain_ViewGroup_Container, new FragmentSecondBuilder().build())
                .addToBackStack(null)
                .commit();
    }
    //endregion
}
