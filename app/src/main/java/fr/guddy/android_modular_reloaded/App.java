package fr.guddy.android_modular_reloaded;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import fr.guddy.android_modular_reloaded.di.DaggerComponentApp;
import fr.guddy.android_modular_reloaded.di.ModuleApp;

public class App extends Application implements HasActivityInjector {
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
                .setModuleApp(new ModuleApp(this))
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
