package com.jgc.imageviewer;

import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public final class AnimationFactory {

    public static final int LIST_VIEW = 0;
    public static final int GRID_VIEW = 1;

    public static final AnimationSet getAnimationSet(int type) {
        AnimationSet set = null;
        switch(type) {
            case LIST_VIEW:
                set = getListViewAnim();
                break;
            case GRID_VIEW:
                set = getGridViewAnim();
                break;
        }
        return set;
    }

    private static AnimationSet getListViewAnim() {
        AnimationSet set = new AnimationSet(true);
        //translate
        TranslateAnimation tAnim = new TranslateAnimation(-100, 0, 50, 0);
        tAnim.setDuration(300);
        set.addAnimation(tAnim);
        //rotate
        RotateAnimation rAnim = new RotateAnimation(5, 0);
        rAnim.setDuration(300);
        set.addAnimation(rAnim);
        //scale
        ScaleAnimation sAnimation = new ScaleAnimation(0.5f, 1f, 0.5f, 1f, 0.5f, 0.5f);
        sAnimation.setDuration(300);
        set.addAnimation(sAnimation);
        return set;
    }

    private static AnimationSet getGridViewAnim() {
        AnimationSet set = new AnimationSet(true);
        //translate
        TranslateAnimation tAnim = new TranslateAnimation(-100, 0, 50, 0);
        tAnim.setDuration(300);
        set.addAnimation(tAnim);
        //rotate
        RotateAnimation rAnim = new RotateAnimation(5, 0);
        rAnim.setDuration(300);
        set.addAnimation(rAnim);
        //scale
        ScaleAnimation sAnimation = new ScaleAnimation(0.5f, 1f, 0.5f, 1f, 0.5f, 0.5f);
        sAnimation.setDuration(300);
        set.addAnimation(sAnimation);
        return set;
    }
}
