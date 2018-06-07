package hari.bounceview;

import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Created by hari on 7/6/18.
 */

public interface BounceViewAnim {

    BounceViewAnim setScaleForPushInAnim(float scaleX, float scaleY);

    BounceViewAnim setScaleForPopOutAnim(float scaleX, float scaleY);

    BounceViewAnim setPushInAnimDuration(int timeInMillis);

    BounceViewAnim setPopOutAnimDuration(int timeInMillis);

    BounceViewAnim setInterpolatorPushIn(AccelerateDecelerateInterpolator interpolatorPushIn);

    BounceViewAnim setInterpolatorPopOut(AccelerateDecelerateInterpolator interpolatorPopOut);

}
