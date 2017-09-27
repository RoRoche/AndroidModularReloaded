package fr.guddy.android_modular_reloaded.second.di;

import android.support.annotation.NonNull;

import java.util.Date;

import fr.guddy.android_modular_reloaded.second.IDateFormatter;

public class MockDateFormatter implements IDateFormatter {
    @Override
    public String format(@NonNull final Date poDate) {
        return "test_date";
    }
}
