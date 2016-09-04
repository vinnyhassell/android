package com.example.vinny.myapplication;

import android.content.Context;
import android.widget.Button;

/**
 * Created by Vinny on 01/09/2016.
 */
public class CustomButton extends Button {

    boolean clicked = false;

    public CustomButton(Context context) {
        super(context);
    }

    public boolean getClicked()
    {
        return clicked;
    }

    public void setClicked(boolean clicked)
    {
        clicked = clicked;
    }

}


