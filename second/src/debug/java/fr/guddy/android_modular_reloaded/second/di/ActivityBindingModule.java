package fr.guddy.android_modular_reloaded.second.di;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import fr.guddy.android_modular_reloaded.debugutils.DebugActivity;

@Module(subcomponents = {
        ComponentDebugActivity.class
})
public abstract class ActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(DebugActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> debugActivityInjectorFactory(final ComponentDebugActivity.Builder pBuilder);
}
