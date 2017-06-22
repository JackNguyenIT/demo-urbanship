package com.example.luannt.testpushnotification;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.urbanairship.UAirship;
import com.urbanairship.google.PlayServicesUtils;

/**
 * Created by LUAN NT on 6/8/2017.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UAirship.shared().getPushManager().setUserNotificationsEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Handle any Google Play services errors
        if (PlayServicesUtils.isGooglePlayStoreAvailable(this)) {
            PlayServicesUtils.handleAnyPlayServicesError(this);
        }
    }
}
