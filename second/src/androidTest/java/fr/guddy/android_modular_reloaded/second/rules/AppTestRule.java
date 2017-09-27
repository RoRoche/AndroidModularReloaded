package fr.guddy.android_modular_reloaded.second.rules;

import android.support.test.InstrumentationRegistry;

import fr.guddy.android_modular_reloaded.second.DebugApp;
import fr.guddy.android_modular_reloaded.second.di.ComponentDebugApp;
import fr.guddy.android_modular_reloaded.second.di.ModuleDebugActivity;
import it.cosenonjaviste.daggermock.DaggerMockRule;

public class AppTestRule extends DaggerMockRule<ComponentDebugApp> {
    //region Constructor
    public AppTestRule() {
        super(ComponentDebugApp.class, new ModuleDebugActivity());
        customizeBuilder(new BuilderCustomizer<ComponentDebugApp.Builder>() {
            @Override
            public ComponentDebugApp.Builder customize(final ComponentDebugApp.Builder pBuilder) {
                return pBuilder.application(getApp());
            }
        });
        set((final ComponentDebugApp pComponent) ->
            pComponent.inject(getApp())
        );
    }
    //endregion

    //region Inner job
    private static DebugApp getApp() {
        return (DebugApp) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
    }
    //endregion
}
