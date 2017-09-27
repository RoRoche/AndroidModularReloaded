package fr.guddy.android_modular_reloaded.second.di;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import fr.guddy.android_modular_reloaded.second.DebugApp;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ModuleDebugActivity.class,
        ActivityBindingModule.class,
})
public interface ComponentDebugApp {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(final DebugApp pDebugApp);

        Builder moduleDebugActivity(final ModuleDebugActivity pModuleDebugActivity);

        ComponentDebugApp build();
    }

    void inject(final DebugApp pApp);
}
