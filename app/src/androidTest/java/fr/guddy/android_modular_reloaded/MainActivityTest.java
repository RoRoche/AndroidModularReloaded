package fr.guddy.android_modular_reloaded;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class, true, true);

    @Test
    public void when_typing_a_login_and_clicking_on_start_it_displays_the_filled_login() {
        // given
        onView(withId(R.id.FragmentFirst_EditText_Login)).perform(typeText("test_test")).perform(closeSoftKeyboard());

        // when
        onView(withId(R.id.FragmentFirst_Button_Start)).perform(click());

        // then
        onView(withId(R.id.FragmentSecond_TextView_Welcome)).check(matches(withText(containsString("test_test"))));
    }
}
