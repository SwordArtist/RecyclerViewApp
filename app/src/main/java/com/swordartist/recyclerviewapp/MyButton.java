package com.swordartist.recyclerviewapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Custom button that has a position info
 */

public class MyButton extends android.support.v7.widget.AppCompatButton {
    public int position = 0;

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setOnClickListenerCustom(@Nullable OnClickListener l, int position) {
        setOnClickListener(l);
        this.position = position;
    }
}
