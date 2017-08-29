package fr.guddy.android_modular_reloaded.common;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.VisibleForTesting;

import au.com.ds.ef.EventEnum;

public class SharedViewModel extends ViewModel {

    //region Fields
    private final MutableLiveData<FlowContext> mFlowContextLiveData;
    private FlowContext mFlowContext;
    //endregion

    //region Constructor
    public SharedViewModel() {
        mFlowContext = new FlowContext();
        mFlowContextLiveData = new MutableLiveData<>();
        mFlowContextLiveData.setValue(mFlowContext);
    }
    //endregion

    //region Visible API
    public LiveData<FlowContext> getFlowContext() {
        return mFlowContextLiveData;
    }

    public void putArgString(final String pKey, final String pValue) {
        mFlowContext.args().putString(pKey, pValue);
    }

    public void safeTrigger(final EventEnum pEvent) {
        mFlowContext.safeTrigger(pEvent);
    }
    //endregion

    //region Visible for testing API
    @VisibleForTesting
    public void setFlowContext(final FlowContext pFlowContext) {
        mFlowContext = pFlowContext;
        mFlowContextLiveData.setValue(mFlowContext);
    }
    //endregion
}
