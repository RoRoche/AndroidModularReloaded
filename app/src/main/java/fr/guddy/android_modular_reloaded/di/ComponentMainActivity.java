package fr.guddy.android_modular_reloaded.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import fr.guddy.android_modular_reloaded.MainActivity;
import fr.guddy.android_modular_reloaded.second.di.ModuleFragmentSecond;

@Subcomponent(modules = {
        ModuleMainActivity.class,
        ModuleFragmentSecond.class
})
public interface ComponentMainActivity extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }
}
