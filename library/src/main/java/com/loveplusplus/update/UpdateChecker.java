package com.loveplusplus.update;

import android.content.Context;
import android.util.Log;

public class UpdateChecker {


    public static void checkForDialog(Context context, String updateUrl) {

        if (context != null) {
            new CheckUpdateTask(context, Constants.TYPE_DIALOG, true, updateUrl).execute();
        } else {
            Log.e(Constants.TAG, "The arg context is null");
        }
    }


    public static void checkForNotification(Context context, String updateUrl) {
        if (context != null) {
            new CheckUpdateTask(context, Constants.TYPE_NOTIFICATION, false, updateUrl).execute();
        } else {
            Log.e(Constants.TAG, "The arg context is null");
        }

    }


}
