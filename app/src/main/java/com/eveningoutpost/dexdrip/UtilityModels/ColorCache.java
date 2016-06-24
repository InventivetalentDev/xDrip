package com.eveningoutpost.dexdrip.UtilityModels;

import android.util.Log;

import com.eveningoutpost.dexdrip.Home;
import com.eveningoutpost.dexdrip.Models.UserError;

import java.util.EnumMap;

/**
 * Created by jamorham on 11/03/2016.
 */

public class ColorCache {

    //  map of colors
    private static final EnumMap<X, Integer> the_cache = new EnumMap<>(X.class);
    private static final String TAG = "jamorham colorcache";
    private static final boolean debug = false;

    public static void invalidateCache() {
        the_cache.clear();
        if (debug) Log.i(TAG, "Cache cleared");
    }

    public static int getCol(X color) {
        if (!the_cache.containsKey(color)) {
            the_cache.put(color, Home.getPreferencesInt(color.internalName, 0xABCDEF));
            if (debug)
                UserError.Log.d(TAG, "Setting cache for color: " + color.internalName + " / " + Home.getPreferencesInt(color.internalName, 1234));
        }
        return the_cache.get(color);
    }

    public enum X {

        color_high_values("color_high_values"),
        color_inrange_values("color_inrange_values"),
        color_low_values("color_low_values"),
        color_filtered("color_filtered"),
        color_treatment("color_treatment"),
        color_treatment_dark("color_treatment_dark"),
        color_predictive("color_predictive"),
        color_predictive_dark("color_predictive_dark"),
        color_average1_line("color_average1_line"),
        color_average2_line("color_average2_line"),
        color_target_line("color_target_line"),
        color_calibration_dot_background("color_calibration_dot_background"),
        color_calibration_dot_foreground("color_calibration_dot_foreground"),
        color_treatment_dot_background("color_treatment_dot_background"),
        color_treatment_dot_foreground("color_treatment_dot_foreground"),
        color_home_chart_background("color_home_chart_background"),
        color_notification_chart_background("color_notification_chart_background"),
        color_widget_chart_background("color_widget_chart_background");

        String internalName;

        X(String name) {
            this.internalName = name;
        }
    }
}