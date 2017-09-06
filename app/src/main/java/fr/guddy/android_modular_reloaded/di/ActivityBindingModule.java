package fr.guddy.android_modular_reloaded.di;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import fr.guddy.android_modular_reloaded.MainActivity;

@Module(subcomponents = {
        ComponentMainActivity.class
})
public abstract class ActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> mainActivityInjectorFactory(final ComponentMainActivity.Builder pBuilder);
}
