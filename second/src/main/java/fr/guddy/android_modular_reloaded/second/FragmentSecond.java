package fr.guddy.android_modular_reloaded.second;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fernandocejas.arrow.checks.Preconditions;

import java.util.Date;

import javax.inject.Inject;

import au.com.ds.ef.StateEnum;
import dagger.android.support.AndroidSupportInjection;

public class FragmentSecond extends Fragment {

    //region Constants for args
    private static final String ARG_LOGIN = "login";
    //endregion

    //region Args
    private String mLogin;
    //endregion

    //region Injected fields
    @Inject
    public IDateFormatter dateFormatter;
    //endregion

    //region Factory
    public static FragmentSecond newInstance(@NonNull final String pLogin) {
        final FragmentSecond lFragment = new FragmentSecond();
        final Bundle lArgs = new Bundle();
        lArgs.putString(ARG_LOGIN, pLogin);
        lFragment.setArguments(lArgs);
        return lFragment;
    }
    //endregion

    //region Lifecycle
    @Override
    public void onAttach(final Context pContext) {
        AndroidSupportInjection.inject(this);
        super.onAttach(pContext);
        Preconditions.checkNotNull(dateFormatter, "Field dateFormatter is null, did you miss to inject it with your dependency injection mechanism?");
    }

    @Override
    public void onCreate(@Nullable final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        if (getArguments() != null) {
            mLogin = getArguments().getString(ARG_LOGIN);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater pInflater,
                             final ViewGroup pContainer,
                             final Bundle pSavedInstanceState) {
        final View lRootView = pInflater.inflate(R.layout.fragment_second, pContainer, false);
        final TextView lTextViewWelcome = lRootView.findViewById(R.id.FragmentSecond_TextView_Welcome);
        lTextViewWelcome.setText(getString(R.string.hello_fragment_second, mLogin, dateFormatter.format(new Date())));
        return lRootView;
    }
    //endregion

    //region FSM
    public enum States implements StateEnum {
        SHOWING_WELCOME
    }
    //endregion
}
