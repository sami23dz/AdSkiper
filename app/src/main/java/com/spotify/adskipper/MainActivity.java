package com.spotify.adskipper;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.provider.Settings;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView tv = findViewById(R.id.text);
        tv.setText("Spotify Ad Skipper\n\n1. Enable in Accessibility Settings\n2. Open Spotify\n3. Ads will auto-skip");
        
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(v -> startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)));
    }
}
