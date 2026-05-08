# Spotify Ad Skipper

Automatically skips ads on Spotify by restarting the app when ads are detected.

## Quick Start

1. Clone this repo
2. Run `bash setup.sh` to download gradle-wrapper.jar
3. Run `./gradlew assembleRelease` to build
4. Install APK on phone
5. Enable in Settings > Accessibility > Spotify Ad Skipper
6. Open Spotify - ads will auto-skip

## How It Works

Uses Android Accessibility Service to monitor Spotify's UI. When an ad is detected (by looking for "Skip Ad" text), it force-stops and restarts Spotify to skip the ad.

## GitHub Build

Push to GitHub and GitHub Actions automatically:
1. Downloads gradle-wrapper.jar
2. Builds the APK
3. Uploads it to Actions artifacts

Download APK from Actions tab.
