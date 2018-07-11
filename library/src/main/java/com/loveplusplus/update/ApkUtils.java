package com.loveplusplus.update;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.util.Log;

import java.io.File;
import java.io.IOException;

/**
 * @author feicien (ithcheng@gmail.com)
 * @since 2018-04-07 16:49
 */
public class ApkUtils {


    public static void installAPk(Context context, File apkFile) {

        Intent installAPKIntent = getApkInStallIntent(context, apkFile);
        context.startActivity(installAPKIntent);

    }


    public static Intent getApkInStallIntent(Context context, File apkFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + ".update.provider", apkFile);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
        } else {
            Uri uri = getApkUri(apkFile);
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
        }
        return intent;
    }


    private static Uri getApkUri(File apkFile) {
        Log.d(Constants.TAG, apkFile.toString());

        //If the SDCard write permission is not set, or there is no SDCard, the apk file is saved in memory and needs to be granted permission to install.
        try {
            String[] command = {"chmod", "777", apkFile.toString()};
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
        } catch (IOException ignored) {
        }
        Uri uri = Uri.fromFile(apkFile);
        Log.d(Constants.TAG, uri.toString());
        return uri;
    }

}
