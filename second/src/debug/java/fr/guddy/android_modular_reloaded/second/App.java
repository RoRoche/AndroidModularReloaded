package fr.guddy.android_modular_reloaded.second;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import fr.guddy.android_modular_reloaded.second.di.ComponentApp;
import fr.guddy.android_modular_reloaded.second.di.DaggerComponentApp;

public class App extends MultiDexApplication implements HasActivityInjector {

    //region Injected fields
    @Inject
    public DispatchingAndroidInjector<Activity> dispatchingActivityInjector;
    //endregion

    //region Fields
    private ComponentApp mComponentApp;
    //endregion

    //region Lifecycle
    @Override
    public void onCreate() {
        super.onCreate();
        buildComponent();
        mComponentApp.inject(this);
    }
    //endregion

    //region DI setup
    private void buildComponent() {
        mComponentApp = DaggerComponentApp.builder()
                .application(this)
                .build();
    }
    //endregion

    //region HasActivityInjector
    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
    //endregion
}
