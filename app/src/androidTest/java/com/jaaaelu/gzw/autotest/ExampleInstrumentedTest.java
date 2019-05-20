package com.jaaaelu.gzw.autotest;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.accessibility.AccessibilityChecks;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.google.android.apps.common.testing.accessibility.framework.AccessibilityCheck;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = ApplicationProvider.getApplicationContext();

        assertEquals("com.jaaaelu.gzw.autotest", appContext.getPackageName());
    }

    @Test
    public void clickFab() {
        onView(withId(R.id.fab)).perform(click()).check(matches(isDisplayed()));
    }

    @Test
    public void findPlusOneBtn() {
        onView(withId(R.id.plus_one_button));
    }

    @Test
    public void findInput() {
        //  点击和输入 Test
        onView(withId(R.id.et_input)).perform(typeText("Test"), click());
    }


    @Test
    public void matchesText() {
        //  去匹配是否存在对应的文字然后看这个控件是否可见
        onView(withText("Hello World!")).check(matches(isDisplayed()));
    }

    @Test
    public void matchesTextType2() {
        //  对应空间显示的内容是否是指定内容
        onView(withId(R.id.textView)).check(matches(withText("Hello World!")));
    }


    @Test
    public void onViewTest() {
        //  对应空间显示的内容是否是指定内容
        onView(withId(-1)).perform(click());
    }

    @Test
    public void dialog() {
        onView(withId(R.id.fab)).perform(click());

        onView(withText("yes")).inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView())))).perform(click());

        onData(allOf(is(instanceOf(String.class)), is("T3"))).perform(click());

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
