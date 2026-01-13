package com.zmpk.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Message;
import com.good.sunsine.R;
import java.io.IOException;

/* loaded from: classes.dex */
public class g {
    public static boolean a(String[] strArr) {
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(strArr);
            processExec.waitFor();
            if (processExec != null) {
                processExec.destroy();
            }
            return true;
        } catch (IOException e) {
            if (processExec == null) {
                return false;
            }
            processExec.destroy();
            return false;
        } catch (InterruptedException e2) {
            if (processExec == null) {
                return false;
            }
            processExec.destroy();
            return false;
        } catch (Throwable th) {
            if (processExec != null) {
                processExec.destroy();
            }
            throw th;
        }
    }

    public static String[] a(Context context, String str, String str2) {
        Message message = new Message();
        message.what = 4;
        message.obj = context.getString(R.string.clearing_pro, str2);
        com.good.sunsine.a.b.sendMessage(message);
        String str3 = "";
        try {
            str3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.publicSourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return new String[]{"su", "-c", "export CLASSPATH=" + str3 + " && export LD_LIBRARY_PATH=/vendor/lib:/system/lib && exec app_process /data/app " + com.good.sunsine.c.class.getPackage().getName() + "/" + com.good.sunsine.c.class.getSimpleName() + " " + str + " " + str2};
    }
}
