package fr.guddy.android_modular_reloaded.common;

import android.arch.lifecycle.ViewModel;

import au.com.ds.ef.EventEnum;

public class SharedViewModel extends ViewModel {

    //region Fields
    private final FlowContext mFlowContext;
    //endregion

    //region Constructor
    public SharedViewModel() {
        mFlowContext = new FlowContext();
    }
    //endregion

    //region Visible API
    public FlowContext getFlowContext() {
        return mFlowContext;
    }

    public void putArgString(final String pKey, final String pValue) {
        mFlowContext.args().putString(pKey, pValue);
    }

    public void safeTrigger(final EventEnum pEvent) {
        mFlowContext.safeTrigger(pEvent);
    }
    //endregion
}
