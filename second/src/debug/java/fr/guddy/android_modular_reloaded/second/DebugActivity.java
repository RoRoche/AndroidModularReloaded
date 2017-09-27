package fr.guddy.android_modular_reloaded.second;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class DebugActivity extends LifecycleActivity implements HasSupportFragmentInjector {

    //region Injected fields
    @Inject
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector;
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(final Bundle pSavedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(pSavedInstanceState);
    }
    //endregion

    //region HasSupportFragmentInjector
    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return supportFragmentInjector;
    }
    //endregion
}
