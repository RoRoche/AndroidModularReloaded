package fr.guddy.android_modular_reloaded.second;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import fr.guddy.android_modular_reloaded.second.di.ComponentApp;
import fr.guddy.android_modular_reloaded.second.di.DaggerComponentApp;
import fr.guddy.android_modular_reloaded.second.di.ModuleApp;

public class App extends Application implements HasActivityInjector {

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
                .moduleApp(new ModuleApp(this))
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
