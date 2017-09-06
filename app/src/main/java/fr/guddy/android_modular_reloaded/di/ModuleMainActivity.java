package fr.guddy.android_modular_reloaded.di;

import dagger.Module;
import dagger.Provides;
import fr.guddy.android_modular_reloaded.di.second.DateFormatter;
import fr.guddy.android_modular_reloaded.second.IDateFormatter;

@Module
public class ModuleMainActivity {
    //region Provides
    @Provides
    public IDateFormatter providesDateFormatter() {
        return new DateFormatter();
    }
    //endregion
}
