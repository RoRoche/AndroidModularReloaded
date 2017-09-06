package fr.guddy.android_modular_reloaded.second.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import fr.guddy.android_modular_reloaded.second.FragmentSecond;

@Subcomponent
public interface ComponentFragmentSecond extends AndroidInjector<FragmentSecond> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<FragmentSecond> {
    }
}