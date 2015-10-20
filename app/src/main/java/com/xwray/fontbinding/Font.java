package com.xwray.fontbinding;

import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class Font {

    public enum TYPEFACE {
        ALEGREYA("Alegreya-Regular.ttf"),
        ALEGREYA_ITALIC("Alegreya-Italic.ttf"),
        ALEGREYA_BOLD("Alegreya-Bold.ttf"),
        ALEGREYA_BOLD_ITALIC("Alegreya-BoldItalic.ttf");

        private String fontName;

        TYPEFACE(String fontName) {
            this.fontName = fontName;
        }
    }

    public static Map<TYPEFACE, Typeface> cache = new HashMap<>(TYPEFACE.values().length);

    public static Typeface get(TYPEFACE type) {
        if (cache.containsKey(type)) return cache.get(type);
        else {
            Typeface typeface = Typeface.createFromAsset(Application.getAppContext().getAssets(), "fonts/" + type.fontName);
            cache.put(type, typeface);
            return typeface;
        }
    }
    public static <T extends Enum<T>> T getEnumFromString(Class<T> c, String string) {
        if( c != null && string != null ) {
            try {
                return Enum.valueOf(c, string.trim().toUpperCase());
            } catch(IllegalArgumentException ex) {}
        }
        return null;
    }

    @BindingAdapter({"bind:font"})
    public static void setFont(TextView textView, String fontName){
        TYPEFACE typeface = getEnumFromString(TYPEFACE.class, fontName);
        textView.setTypeface(get(typeface));
    }
}
