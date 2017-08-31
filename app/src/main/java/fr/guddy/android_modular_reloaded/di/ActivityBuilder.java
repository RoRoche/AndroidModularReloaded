package fr.guddy.android_modular_reloaded.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import fr.guddy.android_modular_reloaded.MainActivity;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = ModuleMainActivity.class)
    abstract MainActivity bindMainActivity();
}
