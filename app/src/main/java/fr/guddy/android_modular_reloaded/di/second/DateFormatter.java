package fr.guddy.android_modular_reloaded.di.second;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import fr.guddy.android_modular_reloaded.second.IDateFormatter;

public final class DateFormatter implements IDateFormatter {

    //region Constants
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final SimpleDateFormat sSimpleDateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
    //endregion

    //region IDateFormatter
    @Override
    public String format(@NonNull final Date poDate) {
        return sSimpleDateFormat.format(poDate);
    }
    //endregion
}
