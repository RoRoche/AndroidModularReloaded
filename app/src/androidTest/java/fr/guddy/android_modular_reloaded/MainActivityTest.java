package fr.guddy.android_modular_reloaded;

import android.arch.lifecycle.ViewModelProviders;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.concurrent.CountDownLatch;

import fr.guddy.android_modular_reloaded.common.FlowContext;
import fr.guddy.android_modular_reloaded.common.SharedViewModel;
import fr.guddy.android_modular_reloaded.first.FragmentFirstOutput;
import fr.guddy.android_modular_reloaded.rules.AppTestRule;
import fr.guddy.android_modular_reloaded.second.FragmentSecond;
import fr.guddy.android_modular_reloaded.second.IDateFormatter;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    //region Rules
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class, false, false);
    @Rule
    public AppTestRule mRule = new AppTestRule();
    //endregion

    //region Mocks
    @Mock
    public IDateFormatter mDateFormatter;
    //endregion

    //region Test methods
    @Test
    public void when_typing_a_login_and_clicking_on_start_it_displays_the_filled_login() {
        // given
        when(mDateFormatter.format(any())).thenReturn("test_date");
        activityRule.launchActivity(null);

        // when
        onView(withId(R.id.FragmentFirst_EditText_Login))
                .perform(typeText("test_login"))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.FragmentFirst_Button_Start))
                .perform(click());

        // then
        onView(withId(R.id.FragmentSecond_TextView_Welcome)).check(
                matches(
                        withText("Hello test_login!\n\ntest_date")
                )
        );
    }

    @Test
    public void when_going_directly_to_second_state_with_filled_login_it_displays_this_login() throws InterruptedException {
        // given
        when(mDateFormatter.format(any())).thenReturn("test_date");
        activityRule.launchActivity(null);
        final SharedViewModel lSharedViewModel = ViewModelProviders.of(activityRule.getActivity()).get(SharedViewModel.class);
        final FlowContext lFlowContext = new FlowContext();
        new FragmentFirstOutput("test_login").putArgs(lFlowContext.args());
        lFlowContext.setState(FragmentSecond.States.SHOWING_WELCOME);

        // when
        whenSettingFlowContext(lSharedViewModel, lFlowContext);

        // then
        onView(withId(R.id.FragmentSecond_TextView_Welcome)).check(
                matches(
                        withText("Hello test_login!\n\ntest_date")
                )
        );
    }
    //endregion

    //region Inner job
    private void whenSettingFlowContext(final SharedViewModel pSharedViewModel, final FlowContext pFlowContext) throws InterruptedException {
        final CountDownLatch lCountDownLatch = new CountDownLatch(1);
        activityRule.getActivity().runOnUiThread(() -> {
            pSharedViewModel.setFlowContext(pFlowContext);
            lCountDownLatch.countDown();
        });
        lCountDownLatch.await();
    }
    //endregion
}
