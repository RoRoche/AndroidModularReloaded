package fr.guddy.android_modular_reloaded.second.di;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import fr.guddy.android_modular_reloaded.second.FragmentSecond;

@Module(subcomponents = {
        ComponentFragmentSecond.class
})
public abstract class ModuleFragmentSecond {
    @Binds
    @IntoMap
    @FragmentKey(FragmentSecond.class)
    abstract AndroidInjector.Factory<? extends Fragment> fragmentSecondInjectorFactory(final ComponentFragmentSecond.Builder pBuilder);
}
