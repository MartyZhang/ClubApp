package martin.hksn.com.hksnapp2015.domain;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import martin.hksn.com.hksnapp2015.R;

public class Fx {

    public static void slide_right(Context ctx, View v) {

        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_right);
        if (a != null) {
            a.reset();
            if (v != null) {
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

    public static void slide_right_disappear(Context ctx, View v) {

        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_right_disappear);
        if (a != null) {
            a.reset();
            if (v != null) {
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

    public static void slide_left(Context ctx, View v) {

        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_left);
        if (a != null) {
            a.reset();
            if (v != null) {
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

    public static void slide_left_disappear(Context ctx, View v) {

        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_left_disappear);
        if (a != null) {
            a.reset();
            if (v != null) {
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

}