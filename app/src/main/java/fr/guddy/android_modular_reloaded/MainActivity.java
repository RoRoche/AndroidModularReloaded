package fr.guddy.android_modular_reloaded;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

import au.com.ds.ef.EasyFlow;
import au.com.ds.ef.EventEnum;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import fr.guddy.android_modular_reloaded.common.FlowContext;
import fr.guddy.android_modular_reloaded.common.SharedViewModel;
import fr.guddy.android_modular_reloaded.common.UiThreadExecutor;
import fr.guddy.android_modular_reloaded.first.FragmentFirst;
import fr.guddy.android_modular_reloaded.second.FragmentSecond;

import static au.com.ds.ef.FlowBuilder.from;
import static au.com.ds.ef.FlowBuilder.on;

public class MainActivity
        extends LifecycleActivity
        implements HasSupportFragmentInjector {

    //region Injected fields
    @Inject
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector;
    //endregion

    //region Fields
    private SharedViewModel mSharedViewModel;
    private EasyFlow<FlowContext> mFlow;
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(final Bundle pSavedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_main);
        mSharedViewModel = ViewModelProviders.of(this).get(SharedViewModel.class);

        mFlow =
                from(FragmentFirst.States.WAITING_LOGIN).transit(
                        on(FragmentFirst.Events.loginProvided).to(FragmentSecond.States.SHOWING_WELCOME).transit(
                                on(Events.backPressed).to(FragmentFirst.States.WAITING_LOGIN)
                        )
                );

        mFlow.executor(new UiThreadExecutor());

        mFlow.whenEnter(FragmentFirst.States.WAITING_LOGIN, (@NonNull final FlowContext poContext) -> {
            final FragmentManager lFragmentManager = getSupportFragmentManager();
            if (lFragmentManager.findFragmentById(R.id.ActivityMain_ViewGroup_Container) == null) {
                lFragmentManager.beginTransaction()
                        .replace(R.id.ActivityMain_ViewGroup_Container, FragmentFirst.newInstance())
                        .commit();
            }
        });

        mFlow.whenEnter(FragmentSecond.States.SHOWING_WELCOME, (@NonNull final FlowContext poContext) -> {
            final String lLogin = FragmentFirst.getLogin(poContext);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.ActivityMain_ViewGroup_Container, FragmentSecond.newInstance(lLogin))
                    .addToBackStack(null)
                    .commit();
        });

        mFlow.whenLeave(FragmentSecond.States.SHOWING_WELCOME, (@NonNull final FlowContext poContext) -> poContext.args().clear());

        mSharedViewModel.getFlowContextLiveData()
                .observe(
                        this,
                        (@NonNull final SharedViewModel.LiveDataFlowContext pLiveDataFlowContext) ->
                                mFlow.start(pLiveDataFlowContext.forceEnterInitialState, pLiveDataFlowContext.flowContext)
                );
    }
    //endregion

    //region Overridden methods
    @Override
    public void onBackPressed() {
        final FragmentManager lFragmentManager = getSupportFragmentManager();
        if (lFragmentManager.getBackStackEntryCount() > 0) {
            mSharedViewModel.safeTrigger(Events.backPressed);
            lFragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
    //endregion

    //region HasSupportFragmentInjector
    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return supportFragmentInjector;
    }
    //endregion

    //region FSM
    private enum Events implements EventEnum {
        backPressed
    }
    //endregion
}
