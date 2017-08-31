package fr.guddy.android_modular_reloaded.di;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.guddy.android_modular_reloaded.App;

@Module
public class ModuleApp {
    //region Field
    private final App mApp;
    //endregion

    //region Constructor
    public ModuleApp(@NonNull final App pApp) {
        mApp = pApp;
    }
    //endregion

    //region Provides
    @Singleton
    @Provides
    public App providesApp() {
        return mApp;
    }
    //endregion
}
