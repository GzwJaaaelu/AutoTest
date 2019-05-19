package com.jaaaelu.gzw.autotest;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.FailureHandler;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.setFailureHandler;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasSibling;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MoreDataInstrumentedTest {

    @Rule
    public ActivityTestRule<MoreDataActivity> activityTestRule = new ActivityTestRule<>(MoreDataActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = ApplicationProvider.getApplicationContext();

        assertEquals("com.jaaaelu.gzw.autotest", appContext.getPackageName());
    }

    @Test
    public void findText() {
        onView(withId(android.R.id.text1));
    }

    @Test
    public void clickSpinner() {
        onView(withId(R.id.rl_show_more_string)).perform(click());
    }

    @Test
    public void notShowSpinner() {
        onView(withId(R.id.rl_show_more_string)).check(matches(not(isDisplayed())));
    }

    @Test
    public void doesNotExistTest() {
        //  自己处理异常情况
        setFailureHandler(new FailureHandler() {
            public void handle(Throwable error, Matcher<View> viewMatcher) {
                Log.d("Handel", "handle -> " + error.getMessage());
            }
        });
        onView(withId(R.id.rl_show_more_data)).check(doesNotExist());
    }

    @Test
    public void clickSpinnerT2() {
        // 选择 T3
        onData(allOf(is(instanceOf(String.class)), is("T3"))).perform(click());
    }

//    @Test
//    public void contains() {
//        // 是否包含 T2
//        onView(withId(R.id.rl_show_more_string)).check(matches(withText(containsString("T1"))));
//    }

    @Test
    public void sib() {
        onView(allOf(withText("7"), hasSibling(withText("Text -> 1")))).perform(click());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
