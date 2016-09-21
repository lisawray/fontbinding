package com.xwray.fontbinding;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple font cache that makes a font once when it's first asked for and keeps it for the
 * life of the application.
 *
 * To use it, put your fonts in /assets/fonts.  You can access them in XML by their filename, minus
 * the extension (e.g. "Roboto-BoldItalic" or "roboto-bolditalic" for Roboto-BoldItalic.ttf).
 *
 * To set custom names for fonts other than their filenames, call addFont().
 *
 */
public class FontCache {

    private static final String FONT_DIR = "fonts";
    private static String TAG = "FontCache";
    private static Map<String, Typeface> cache;
    private static Map<String, String> fontMapping;

    private FontCache() {}

    public static Typeface get(Context context, String fontName) {
        if (fontMapping == null) {
            fontMapping = new HashMap<>();
            setupFontMap(context);
        }
        if (cache == null) {
            cache = new HashMap<>();
        }

        String fontFilename = fontMapping.get(fontName);
        if (fontFilename == null) {
            Log.e(TAG, "Couldn't find font " + fontName + ". Maybe you need to call addFont() first?");
            return null;
        }

        if (cache.containsKey(fontFilename)) {
            return cache.get(fontFilename);
        } else {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), FONT_DIR + "/" + fontFilename);
            cache.put(fontFilename, typeface);
            return typeface;
        }
    }

    private static void setupFontMap(Context context) {
        AssetManager am = context.getResources().getAssets();
        String fileList[];
        try {
            fileList = am.list(FONT_DIR);
        } catch (IOException e) {
            Log.e(TAG, "Error loading fonts from assets/fonts.");
            return;
        }

        for (String filename : fileList) {
            String alias = filename.substring(0, filename.lastIndexOf('.'));
            fontMapping.put(alias, filename);
            fontMapping.put(alias.toLowerCase(), filename);
        }
    }

    public void addFont(String name, String fontFilename) {
        fontMapping.put(name, fontFilename);
    }
}
