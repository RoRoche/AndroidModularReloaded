package fr.guddy.android_modular_reloaded.first;

import android.os.Bundle;
import android.support.annotation.NonNull;

public final class FragmentFirstOutput {
    //region Constants
    private static final String ARG_KEY_LOGIN = "LOGIN";
    //endregion

    //region Exposed fields
    public final String login;
    //endregion

    //region Constructors
    public FragmentFirstOutput(@NonNull final String pLogin) {
        login = pLogin;
    }

    public FragmentFirstOutput(@NonNull final Bundle pArgs) {
        this(pArgs.getString(ARG_KEY_LOGIN, ""));
    }
    //endregion

    //region Description
    public void putArgs(@NonNull final Bundle pArgs) {
        pArgs.putString(ARG_KEY_LOGIN, login);
    }
    //endregion
}
