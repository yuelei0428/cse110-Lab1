package edu.ucsd.cse110.helloworld;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import android.app.Activity;
import android.app.PendingIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

//@Config(constants = BuildConfig.class, sdk=21)
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void test1(){
        assertEquals(110,110);
    }

    @Test
    public void testStudentNamesDisplayed(){

        try(ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)){
            scenario.onActivity(activity -> {

                scenario.moveToState(Lifecycle.State.CREATED);

                assertEquals(((TextView)activity.findViewById(R.id.student_name_view)).getVisibility(), View.INVISIBLE);

                final Button button1 = (Button) activity.findViewById(R.id.button);
                button1.performClick();
                assertEquals(((TextView)activity.findViewById(R.id.student_name_view)).getVisibility(), View.VISIBLE);
                assertEquals(((TextView)activity.findViewById(R.id.student_name_view)).getText(), "Sander Valstar");

                final Button button2 = (Button) activity.findViewById(R.id.button2);
                button2.performClick();
                assertEquals(((TextView)activity.findViewById(R.id.student_name_view)).getVisibility(), View.INVISIBLE);

            });
        }


    }
}
