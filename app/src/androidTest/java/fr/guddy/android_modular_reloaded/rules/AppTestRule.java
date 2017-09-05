package fr.guddy.android_modular_reloaded.rules;

import android.support.test.InstrumentationRegistry;

import fr.guddy.android_modular_reloaded.App;
import fr.guddy.android_modular_reloaded.di.ComponentApp;
import fr.guddy.android_modular_reloaded.di.ModuleApp;
import it.cosenonjaviste.daggermock.DaggerMockRule;

public class AppTestRule extends DaggerMockRule<ComponentApp> {
    //region Constructor
    public AppTestRule() {
        super(ComponentApp.class, new ModuleApp(getApp()));
        set((final ComponentApp pComponent) -> {
            getApp().setComponentApp(pComponent);
        });
    }
    //endregion

    //region Inner job
    private static App getApp() {
        return (App) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
    }
    //endregion
}
