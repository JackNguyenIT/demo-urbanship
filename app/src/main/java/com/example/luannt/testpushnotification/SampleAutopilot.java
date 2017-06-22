package com.example.luannt.testpushnotification;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Autopilot;
import com.urbanairship.UAirship;

/**
 * Created by LUAN NT on 6/8/2017.
 */

public class SampleAutopilot extends Autopilot {

    private static final String NO_BACKUP_PREFERENCES = "com.urbanairship.sample.no_backup";

    private static final String FIRST_RUN_KEY = "first_run";

    @Override
    public void onAirshipReady(UAirship airship) {
        SharedPreferences preferences = UAirship.getApplicationContext().getSharedPreferences(NO_BACKUP_PREFERENCES, Context.MODE_PRIVATE);

        boolean isFirstRun = preferences.getBoolean(FIRST_RUN_KEY, true);
        if (isFirstRun) {
            preferences.edit().putBoolean(FIRST_RUN_KEY, false).apply();

            // Enable user notifications on first run
            airship.getPushManager().setUserNotificationsEnabled(true);
        }
        Log.d("Jack", "onAirshipReady() called with: airship = [" + airship + "]");
    }

    @Nullable
    @Override
    public AirshipConfigOptions createAirshipConfigOptions(@NonNull Context context) {


         // Optionally, customize your config at runtime:
             AirshipConfigOptions options = new AirshipConfigOptions.Builder()
                    .setInProduction(false)
                    .setDevelopmentAppKey("yA6anbToQ8WbFgwlaCJlDQ")
                     .setDevelopmentAppSecret("lRRbbsfcTtqyYFLLd8aAdA")
                     .setProductionAppKey("yA6anbToQ8WbFgwlaCJlDQ")
                     .setProductionAppSecret("lRRbbsfcTtqyYFLLd8aAdA")
                     .setGcmSender("697963772072")
                    .setNotificationAccentColor(ContextCompat.getColor(context, R.color.colorAccent))
                    .setNotificationIcon(R.mipmap.ic_launcher)
                    .build();
            return options;

//        return super.createAirshipConfigOptions(context);
    }


}
