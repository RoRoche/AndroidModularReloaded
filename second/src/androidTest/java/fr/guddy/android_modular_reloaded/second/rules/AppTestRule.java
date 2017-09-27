package fr.guddy.android_modular_reloaded.second.rules;

import android.support.test.InstrumentationRegistry;

import fr.guddy.android_modular_reloaded.second.App;
import fr.guddy.android_modular_reloaded.second.di.ComponentApp;
import fr.guddy.android_modular_reloaded.second.di.ModuleApp;
import fr.guddy.android_modular_reloaded.second.di.ModuleDebugActivity;
import it.cosenonjaviste.daggermock.DaggerMockRule;

public class AppTestRule extends DaggerMockRule<ComponentApp> {
    //region Constructor
    public AppTestRule() {
        super(ComponentApp.class, new ModuleApp(getApp()), new ModuleDebugActivity());
        customizeBuilder(new BuilderCustomizer<ComponentApp.Builder>() {
            @Override
            public ComponentApp.Builder customize(final ComponentApp.Builder pBuilder) {
                return pBuilder.application(getApp());
            }
        });
        set((final ComponentApp pComponent) ->
            pComponent.inject(getApp())
        );
    }
    //endregion

    //region Inner job
    private static App getApp() {
        return (App) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
    }
    //endregion
}
