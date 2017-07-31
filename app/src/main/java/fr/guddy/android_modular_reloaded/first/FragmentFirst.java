package fr.guddy.android_modular_reloaded.first;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.fragmentargs.FragmentArgs;
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs;

import fr.guddy.android_modular_reloaded.R;

@FragmentWithArgs
public class FragmentFirst extends Fragment {

    //region Fields
    private OnFragmentInteractionListener mListener;
    //endregion

    //region Lifecycle
    @Override
    public void onAttach(final Context pContext) {
        super.onAttach(pContext);
        if (pContext instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) pContext;
        } else {
            throw new RuntimeException(String.format("%s must implement %s", pContext.toString(), OnFragmentInteractionListener.class.getSimpleName()));
        }
    }

    @Override
    public void onCreate(@Nullable final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        FragmentArgs.inject(this);
    }

    @Override
    public View onCreateView(final LayoutInflater lInflater,
                             final ViewGroup pContainer,
                             final Bundle pSavedInstanceState) {
        final View lRootView = lInflater.inflate(R.layout.fragment_first, pContainer, false);
        lRootView.findViewById(R.id.FragmentFirst_Button_Next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View pView) {
                mListener.onClickNext();
            }
        });
        return lRootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    //endregion

    //region Callback declaration
    public interface OnFragmentInteractionListener {
        void onClickNext();
    }
    //endregion
}
