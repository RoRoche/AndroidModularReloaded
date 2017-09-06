package fr.guddy.android_modular_reloaded.first;

import com.android21buttons.fragmenttestrule.FragmentTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class FragmentFirstTest {
    @Rule
    public FragmentTestRule<?, FragmentFirst> fragmentTestRule =
            FragmentTestRule.create(FragmentFirst.class, true, false);

    @Test
    public void it_displays_prefilled_login_and_clickable_start_button() {
        // given
        final FragmentFirst lFragmentFirst = FragmentFirst.newInstance("TEST_LOGIN");

        // when
        fragmentTestRule.launchFragment(lFragmentFirst);

        // then
        onView(withId(R.id.FragmentFirst_EditText_Login)).check(matches(withText("TEST_LOGIN")));
        onView(withId(R.id.FragmentFirst_Button_Start))
                .check(matches(isClickable()))
                .check(matches(withText(R.string.start)));
    }
}