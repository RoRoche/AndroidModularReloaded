package fr.guddy.android_modular_reloaded.second.di;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import fr.guddy.android_modular_reloaded.second.App;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ModuleDebugActivity.class,
        ActivityBindingModule.class,
})
public interface ComponentApp {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(final App pApp);

        Builder moduleDebugActivity(final ModuleDebugActivity pModuleDebugActivity);

        ComponentApp build();
    }

    void inject(final App pApp);
}
