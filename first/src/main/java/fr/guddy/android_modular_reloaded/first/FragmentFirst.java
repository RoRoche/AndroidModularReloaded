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
import fr.guddy.android_modular_reloaded.common.FlowContext;
import fr.guddy.android_modular_reloaded.common.SharedViewModel;

public class FragmentFirst extends Fragment {
    //region Constants
    private static final String ARG_KEY_LOGIN = "LOGIN";
    //endregion

    //region Bound views
    private TextInputEditText mEditTextLogin;
    //endregion

    //region Fields
    private SharedViewModel mSharedViewModel;
    //endregion

    //region Factory
    public static FragmentFirst newInstance() {
        return new FragmentFirst();
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
            mSharedViewModel.putArgString(ARG_KEY_LOGIN, lLogin);
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

    public static void putLogin(@NonNull final FlowContext pFlowContext, final String pLogin) {
        pFlowContext.args().putString(ARG_KEY_LOGIN, pLogin);
    }

    public static String getLogin(@NonNull final FlowContext pFlowContext) {
        return pFlowContext.args().getString(ARG_KEY_LOGIN);
    }
    //endregion
}
