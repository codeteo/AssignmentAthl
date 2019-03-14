package com.assignment.teo.widgets.transitions;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.transition.AutoTransition;
import android.transition.Transition;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class FadeInTransition extends AutoTransition {

    private static final int FADE_IN_DURATION = 200;

    private FadeInTransition() {
        // force callers to call the factory method to instantiate this class
    }

    public static Transition createTransition() {
        AutoTransition transition = new AutoTransition();
        transition.setDuration(FADE_IN_DURATION);
        return transition;
    }
}
