package net.vinsofts.thanghoangngoc.mvpexample.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class Utils {
    public static void hideKeyboard(Context mContext, EditText editText) {
        InputMethodManager im = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        editText.clearFocus();
    }
}
