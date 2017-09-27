package fr.guddy.android_modular_reloaded.second;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import fr.guddy.android_modular_reloaded.second.di.DaggerComponentApp;

public class App extends MultiDexApplication implements HasActivityInjector {

    //region Injected fields
    @Inject
    public DispatchingAndroidInjector<Activity> dispatchingActivityInjector;
    //endregion

    //region Lifecycle
    @Override
    public void onCreate() {
        super.onCreate();
        DaggerComponentApp.builder()
                .application(this)
                .build()
                .inject(this);
    }
    //endregion

    //region HasActivityInjector
    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
    //endregion
}
