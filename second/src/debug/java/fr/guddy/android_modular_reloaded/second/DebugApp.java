package fr.guddy.android_modular_reloaded.second;

import fr.guddy.android_modular_reloaded.debugutils.AbstractDebugApp;
import fr.guddy.android_modular_reloaded.second.di.DaggerComponentDebugApp;

public class DebugApp extends AbstractDebugApp {

    //region AbstractDebugApp overridden method
    @Override
    protected void buildComponentAndInjectThis() {
        DaggerComponentDebugApp.builder()
                .application(this)
                .build()
                .inject(this);
    }
    //endregion
}
