# Baesa Chatroom Android
This is Android source code, NOT a compiled APK. It opens https://www.hscommunities.site.je/?tab=groups in a WebView and uses the website's existing login/session. It supports uploads through Android's file chooser.

## Build without a PC
Upload the project contents to a GitHub repository and run Actions > Build Android APK > Run workflow. Download the generated artifact, unzip it and install app-debug.apk on Android. The debug build is for testing/direct sharing only, not Play Store release. The workflow has not been run or verified here.

## Important limitations
The website may redirect to a home/login page. The app cannot guarantee a chatroom-only interface without updating the server's PHP pages. No background push notifications, sound alerts, or BUZZ changes are implemented in this Android wrapper; those require website/server integration. Test website accessibility and Android navigation before distributing.
