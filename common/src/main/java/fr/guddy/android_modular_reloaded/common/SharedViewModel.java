package fr.guddy.android_modular_reloaded.common;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import au.com.ds.ef.EventEnum;

public class SharedViewModel extends ViewModel {

    //region Fields
    private final MutableLiveData<LiveDataFlowContext> mFlowContextLiveData;
    private FlowContext mFlowContext;
    //endregion

    //region Constructor
    public SharedViewModel() {
        mFlowContextLiveData = new MutableLiveData<>();
        mFlowContext = new FlowContext();
        mFlowContextLiveData.setValue(new LiveDataFlowContext(false, mFlowContext));
    }
    //endregion

    //region Visible API
    public LiveData<LiveDataFlowContext> getFlowContextLiveData() {
        return mFlowContextLiveData;
    }

    public Bundle args() {
        return mFlowContext.args();
    }

    public void safeTrigger(final EventEnum pEvent) {
        final LiveDataFlowContext lValue = mFlowContextLiveData.getValue();
        if(lValue != null) {
            lValue.flowContext.safeTrigger(pEvent);
        }
    }
    //endregion

    //region Visible for testing API
    @VisibleForTesting
    public void setFlowContext(final FlowContext pFlowContext) {
        mFlowContext = pFlowContext;
        mFlowContextLiveData.setValue(new LiveDataFlowContext(true, pFlowContext));
    }
    //endregion

    public static final class LiveDataFlowContext {
        public final boolean forceEnterInitialState;
        public final FlowContext flowContext;

        private LiveDataFlowContext(final boolean pForceEnterInitialState, @NonNull final FlowContext pFlowContext) {
            forceEnterInitialState = pForceEnterInitialState;
            flowContext = pFlowContext;
        }
    }
}
