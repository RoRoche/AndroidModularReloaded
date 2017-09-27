package fr.guddy.android_modular_reloaded.second;

import com.android21buttons.fragmenttestrule.FragmentTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class FragmentSecondTest {
    @Rule
    public FragmentTestRule<DebugActivity, FragmentSecond> fragmentTestRule =
            new FragmentTestRule<>(DebugActivity.class, FragmentSecond.class, false ,false);

    @Test
    public void it_displays_prefilled_login() {
        // given
        final FragmentSecond lFragmentSecond = FragmentSecond.newInstance("test_login");

        // when
        fragmentTestRule.launchActivity(null);
        fragmentTestRule.launchFragment(lFragmentSecond);

        // then
        onView(withId(R.id.FragmentSecond_TextView_Welcome)).check(
                matches(
                        withText("Hello test_login!\n\ntest_date")
                )
        );
    }
}