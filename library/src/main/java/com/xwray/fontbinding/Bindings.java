package com.xwray.fontbinding;

import android.databinding.BindingAdapter;
import android.widget.TextView;

/**
 * Custom bindings for XML attributes using data binding.
 * (http://developer.android.com/tools/data-binding/guide.html)
 */
public class Bindings {

    @BindingAdapter({"bind:font"})
    public static void setFont(TextView textView, String fontName) {
        textView.setTypeface(FontCache.getInstance(textView.getContext()).get(fontName));
    }
}
