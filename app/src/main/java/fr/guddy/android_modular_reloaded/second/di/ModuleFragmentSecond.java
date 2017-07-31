package fr.guddy.android_modular_reloaded.second.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import fr.guddy.android_modular_reloaded.second.FragmentSecond;

@Module
public abstract class ModuleFragmentSecond {
    @ContributesAndroidInjector
    abstract FragmentSecond bindFragmentSecond();
}
