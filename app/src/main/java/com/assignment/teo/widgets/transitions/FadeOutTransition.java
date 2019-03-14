package com.assignment.teo.widgets.transitions;

import android.support.transition.Transition;
import android.support.transition.AutoTransition;

//@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class FadeOutTransition extends AutoTransition {

    private FadeOutTransition() {
        // force callers to call the factory method to instantiate this class
    }

    private static final int FADE_OUT_DURATION = 250;

    /**
     * Creates a AutoTransition that calls the {@linkplain TransitionListener#onTransitionEnd(Transition)}
     * of the passing Listener when complete
     */
    public static Transition withAction(TransitionListener finishingAction) {
        AutoTransition transition = new AutoTransition();
        transition.setDuration(FADE_OUT_DURATION);
        transition.addListener(finishingAction);
        return transition;
    }

}