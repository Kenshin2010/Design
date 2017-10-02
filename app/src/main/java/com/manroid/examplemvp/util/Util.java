package com.manroid.examplemvp.util;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.manroid.examplemvp.App;

/**
 * Created by manro on 29/09/2017.
 */

public class Util {
    public static String getStringByid(int id) {
        return App.getContext().getResources().getString(id);
    }

    public static String convertColorToHex(Drawable drawable) {

        return String.format("#%06x",  (((ColorDrawable)drawable).getColor() & 0x00FFFFFF));
    }
}