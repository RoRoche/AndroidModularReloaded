package fr.guddy.android_modular_reloaded.second.di;

import dagger.Module;
import dagger.Provides;
import fr.guddy.android_modular_reloaded.second.IDateFormatter;

@Module
public class ModuleDebugActivity {
    //region Provides
    @Provides
    public IDateFormatter providesDateFormatter() {
        return new MockDateFormatter();
    }
    //endregion
}
