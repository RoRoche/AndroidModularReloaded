package fr.guddy.android_modular_reloaded.debugutils;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public abstract class AbstractDebugApp extends MultiDexApplication implements HasActivityInjector {

    //region Injected fields
    @Inject
    public DispatchingAndroidInjector<Activity> dispatchingActivityInjector;
    //endregion

    //region Lifecycle
    @Override
    public void onCreate() {
        super.onCreate();
        buildComponentAndInjectThis();
    }
    //endregion

    //region Method to implement
    protected abstract void buildComponentAndInjectThis();
    //endregion

    //region HasActivityInjector
    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
    //endregion
}
