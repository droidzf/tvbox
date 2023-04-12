package com.github.tvbox.osc.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class IDM {
    public static void Download(Activity activity, String url) {
        Intent intent = new Intent("android.intent.action.MAIN");
        if (AppManager.isPackageInstalled("idm.internet.download.manager.adm.lite", activity.getPackageManager()))
            intent.setClassName("idm.internet.download.manager.adm.lite", "idm.internet.download.manager.Downloader");
        else if (AppManager.isPackageInstalled("idm.internet.download.manager.plus", activity.getPackageManager()))
            intent.setClassName("idm.internet.download.manager.plus", "idm.internet.download.manager.Downloader");
        else if (AppManager.isPackageInstalled("idm.internet.download.manager", activity.getPackageManager()))
            intent.setClassName("idm.internet.download.manager", "idm.internet.download.manager.Downloader");
        else {
            Toast.makeText(activity, "没有安装1DM+", Toast.LENGTH_SHORT).show();
            return;
        }
        intent.setData(Uri.parse(url));
        activity.startActivity(intent);
    }
}
