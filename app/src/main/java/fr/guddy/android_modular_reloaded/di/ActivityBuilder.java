package fr.guddy.android_modular_reloaded.di;

import android.app.Activity;
import android.support.annotation.NonNull;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import fr.guddy.android_modular_reloaded.MainActivity;

@Module
public abstract class ActivityBuilder {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(@NonNull final ComponentMainActivity.Builder pBuilder);
}
