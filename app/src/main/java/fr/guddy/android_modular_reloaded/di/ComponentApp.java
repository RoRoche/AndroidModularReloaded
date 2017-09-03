package fr.guddy.android_modular_reloaded.di;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import fr.guddy.android_modular_reloaded.App;
import fr.guddy.android_modular_reloaded.second.di.ModuleFragmentSecond;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ModuleApp.class,
        ActivityBuilder.class,
        ModuleMainActivity.class,
        ModuleFragmentSecond.class
})
public interface ComponentApp {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(final App pApp);

        Builder moduleApp(final ModuleApp pModuleApp);

        ComponentApp build();
    }

    void inject(final App pApp);
}
