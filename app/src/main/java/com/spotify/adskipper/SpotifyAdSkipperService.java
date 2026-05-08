package com.spotify.adskipper;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.content.Intent;
import android.app.ActivityManager;
import android.content.Context;

public class SpotifyAdSkipperService extends AccessibilityService {
    private static final String SPOTIFY_PACKAGE = "com.spotify.music";
    private boolean adDetected = false;
    private long lastRestart = 0;

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getPackageName() == null) return;
        if (!event.getPackageName().toString().equals(SPOTIFY_PACKAGE)) return;

        String text = event.getText().isEmpty() ? "" : event.getText().get(0).toString().toLowerCase();

        if ((text.contains("skip") || text.contains("ad")) && !adDetected) {
            if (System.currentTimeMillis() - lastRestart > 5000) {
                adDetected = true;
                skipAd();
                lastRestart = System.currentTimeMillis();
            }
        } else {
            adDetected = false;
        }
    }

    private void skipAd() {
        try {
            ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            am.forceStopPackage(SPOTIFY_PACKAGE);
            Thread.sleep(2000);
            Intent intent = getPackageManager().getLaunchIntentForPackage(SPOTIFY_PACKAGE);
            if (intent != null) startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onInterrupt() {}
}
