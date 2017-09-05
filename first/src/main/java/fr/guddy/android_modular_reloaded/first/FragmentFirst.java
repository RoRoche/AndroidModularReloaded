package fr.guddy.android_modular_reloaded.first;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import au.com.ds.ef.EventEnum;
import au.com.ds.ef.StateEnum;
import fr.guddy.android_modular_reloaded.common.SharedViewModel;

public class FragmentFirst extends Fragment {
    //region Constants
    private static final String ARG_KEY_PRE_FILLED_LOGIN = "PRE_FILLED_LOGIN";
    //endregion

    //region Bound views
    private TextInputEditText mEditTextLogin;
    //endregion

    //region Fields
    private SharedViewModel mSharedViewModel;
    //endregion

    //region Factory
    public static FragmentFirst newInstance(@NonNull final String pPrefilledLogin) {
        final FragmentFirst lFragmentFirst = new FragmentFirst();

        final Bundle lArgs = new Bundle();
        lArgs.putString(ARG_KEY_PRE_FILLED_LOGIN, pPrefilledLogin);
        lFragmentFirst.setArguments(lArgs);

        return lFragmentFirst;
    }

    public static FragmentFirst newInstance() {
        return newInstance("");
    }
    //endregion

    //region Lifecycle
    @Override
    public void onCreate(@Nullable final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        mSharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
    }

    @Override
    public View onCreateView(final LayoutInflater lInflater,
                             final ViewGroup pContainer,
                             final Bundle pSavedInstanceState) {
        final View lRootView = lInflater.inflate(R.layout.fragment_first, pContainer, false);
        mEditTextLogin = lRootView.findViewById(R.id.FragmentFirst_EditText_Login);
        mEditTextLogin.setText(getArguments().getString(ARG_KEY_PRE_FILLED_LOGIN));
        lRootView.findViewById(R.id.FragmentFirst_Button_Start).setOnClickListener((final View poView) -> onClickButtonStart());
        return lRootView;
    }
    //endregion

    //region User interaction
    private void onClickButtonStart() {
        final String lLogin = mEditTextLogin.getText().toString();
        if (TextUtils.isEmpty(lLogin)) {
            mEditTextLogin.setError(getString(R.string.login_error));
        } else {
            new FragmentFirstOutput(lLogin).putArgs(mSharedViewModel.args());
            mSharedViewModel.safeTrigger(Events.loginProvided);
        }
    }
    //endregion

    //region FSM
    public enum States implements StateEnum {
        WAITING_LOGIN
    }

    public enum Events implements EventEnum {
        loginProvided
    }
    //endregion
}
