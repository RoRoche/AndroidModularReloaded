package fr.guddy.android_modular_reloaded.second.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import fr.guddy.android_modular_reloaded.debugutils.DebugActivity;

@Subcomponent(modules = {
        ModuleDebugActivity.class,
        ModuleFragmentSecond.class
})
public interface ComponentDebugActivity extends AndroidInjector<DebugActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DebugActivity> {
    }
}
