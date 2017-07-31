package fr.guddy.android_modular_reloaded.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.guddy.android_modular_reloaded.di.second.DateFormatter;
import fr.guddy.android_modular_reloaded.second.IDateFormatter;

@Module
public class ModuleMainActivity {
    //region Provides
    @Singleton
    @Provides
    public IDateFormatter providesDateFormatter() {
        return new DateFormatter();
    }
    //endregion
}
