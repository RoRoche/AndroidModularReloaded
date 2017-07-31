package fr.guddy.android_modular_reloaded.second;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fernandocejas.arrow.checks.Preconditions;
import com.hannesdorfmann.fragmentargs.FragmentArgs;
import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs;

import java.util.Date;

import javax.inject.Inject;

import au.com.ds.ef.StateEnum;
import dagger.android.support.AndroidSupportInjection;
import fr.guddy.android_modular_reloaded.R;

@FragmentWithArgs
public class FragmentSecond extends Fragment {

    //region Args
    @Arg
    public String login;
    //endregion

    //region Injected fields
    @Inject
    public IDateFormatter dateFormatter;
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
        FragmentArgs.inject(this);
    }

    @Override
    public View onCreateView(final LayoutInflater pInflater,
                             final ViewGroup pContainer,
                             final Bundle pSavedInstanceState) {
        final View lRootView = pInflater.inflate(R.layout.fragment_second, pContainer, false);
        final TextView lTextViewWelcome = lRootView.findViewById(R.id.FragmentSecond_TextView_Welcome);
        lTextViewWelcome.setText(getString(R.string.hello_fragment_second, login, dateFormatter.format(new Date())));
        return lRootView;
    }
    //endregion

    //region FSM
    public enum States implements StateEnum {
        SHOWING_WELCOME
    }
    //endregion
}
