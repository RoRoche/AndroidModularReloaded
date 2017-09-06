package fr.guddy.android_modular_reloaded.di;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import fr.guddy.android_modular_reloaded.App;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ModuleApp.class,
        ModuleMainActivity.class,
        ActivityBindingModule.class,
})
public interface ComponentApp {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(final App pApp);

        Builder moduleApp(final ModuleApp pModuleApp);

        Builder moduleMainActivity(final ModuleMainActivity pModuleMainActivity);

        ComponentApp build();
    }

    void inject(final App pApp);
}
