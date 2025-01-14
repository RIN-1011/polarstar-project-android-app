package com.example.polarstarproject;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

//포그라운드 서비스 리팩토링
public class RefactoringForegroundService {
    private static final String TAG = "RefactoringForegroundService";

    public static boolean isLocationServiceRunning(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager != null) {
            for (ActivityManager.RunningServiceInfo service : activityManager.getRunningServices(Integer.MAX_VALUE)) {
                if (LocationService.class.getName().equals(service.service.getClassName())) {
                    if (service.foreground) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    @SuppressLint("LongLogTag")
    public static void startLocationService(Context context) { //서비스 실행
        if (!isLocationServiceRunning(context)) {
            Intent intent = new Intent(context, LocationService.class);
            intent.setAction(Constants.ACTION_START_LOCATION_SERVICE);
            context.startService(intent);
            Log.w(TAG, "실행");
        }
    }

    @SuppressLint("LongLogTag")
    public static void stopLocationService(Context context) { //서비스 종료
        if (isLocationServiceRunning(context)) {
            Intent intent = new Intent(context, LocationService.class);
            intent.setAction(Constants.ACTION_STOP_LOCATION_SERVICE);
            context.startService(intent);
            Log.w(TAG, "종료");
        }
    }
}
