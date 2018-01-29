package com.example.shad.shad2018_practical3;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class ButtonBehavior extends CoordinatorLayout.Behavior<Button> {

    ButtonBehavior(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(final CoordinatorLayout parent, final Button child, final View dependency) {
        //возвращать true только тогда, когда мы хотим отреагировать на происходящие в разметке изменения
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(final CoordinatorLayout parent, final Button child, final View dependency) {
        //onDependentViewChanged вызывается всякий раз, когда с виджетом происходят изменения,
        // приводящие к тому, что нужно пересчитать положение на экране.
        float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
        child.setTranslationY(translationY);
        return true;
    }

    @Override
    public void onDependentViewRemoved(final CoordinatorLayout parent, final Button child, final View dependency) {
        ViewCompat.animate(child).translationY(0).start();
    }
}
