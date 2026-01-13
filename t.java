package com.android.a;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* loaded from: classes.dex */
public final class t {
    private static boolean a = false;

    public static int a(Context context, boolean z) {
        h hVar = new h();
        if (a || a(context)) {
            if (a) {
            }
            return -1;
        }
        if (!hVar.a(context, true)) {
            return 1;
        }
        a = true;
        return 0;
    }

    public static String a() {
        return Environment.getExternalStorageState().equals("mounted") ? String.valueOf(Environment.getExternalStorageDirectory().getPath()) + File.separator : "";
    }

    public static String a(byte[] bArr) {
        return new String(new s().b(bArr));
    }

    public static HashMap a(String str) {
        HashMap map = new HashMap();
        if (str == null) {
            return map;
        }
        int iIndexOf = str.indexOf(a(C0000a.J));
        boolean z = false;
        int i = 0;
        while (i >= 0) {
            if (iIndexOf < 0) {
                z = true;
                iIndexOf = str.length();
            }
            String strSubstring = str.substring(i, iIndexOf);
            int iIndexOf2 = strSubstring.indexOf(a(C0000a.cv));
            if (iIndexOf2 > 0) {
                String strSubstring2 = strSubstring.substring(0, iIndexOf2);
                String strSubstring3 = strSubstring.substring(iIndexOf2 + 1, strSubstring.length());
                if (!TextUtils.isEmpty(strSubstring3)) {
                    map.put(strSubstring2, e(strSubstring3));
                }
            }
            i = iIndexOf + 1;
            iIndexOf = str.indexOf(a(C0000a.J), i);
            if (z) {
                break;
            }
        }
        return map;
    }

    public static void a(String str, String str2, boolean z) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str), false);
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static long b() throws IOException {
        long j;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(a(C0000a.af)), 8192);
            j = Integer.parseInt(bufferedReader.readLine().replaceAll("\\D", ""), 10);
            bufferedReader.close();
        } catch (Exception e) {
            j = 0;
        }
        return j / 1024;
    }

    public static String b(Context context) {
        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        return deviceId != null ? deviceId : "";
    }

    public static String b(String str) {
        String[] strArr = {a(new byte[]{103, 114, 48, 47, 96, 110, 122, 108, 125, 120, 98, 102, 42, 103, 111, 108, 59, 61, 50, 49, 37}), a(new byte[]{103, 114, 51, 47, 96, 110, 122, 108, 125, 120, 98, 102, 42, 103, 111, 108, 59, 61, 50, 49, 37}), a(new byte[]{103, 114, 50, 47, 96, 110, 122, 108, 125, 120, 98, 102, 42, 103, 111, 108, 59, 61, 50, 49, 37}), a(new byte[]{103, 114, 53, 47, 96, 110, 122, 108, 125, 120, 98, 102, 42, 103, 111, 108, 59, 61, 50, 49, 37}), a(new byte[]{103, 114, 48, 47, 119, 119, 123, 124, 106, 110, 123, 96, 118, 42, 99, 110, 108, 63, 58, 57, 45, 55}), a(new byte[]{103, 114, 51, 47, 119, 119, 123, 124, 106, 110, 123, 96, 118, 42, 99, 110, 108, 63, 58, 57, 45, 55}), a(new byte[]{103, 114, 50, 47, 119, 119, 123, 124, 106, 110, 123, 96, 118, 42, 99, 110, 108, 63, 58, 57, 45, 55}), a(new byte[]{103, 114, 53, 47, 119, 119, 123, 124, 106, 110, 123, 96, 118, 42, 99, 110, 108, 63, 58, 57, 45, 55})};
        return String.valueOf(String.valueOf(a(C0000a.aG)) + strArr[Math.abs(new Random().nextInt() % strArr.length)] + a(new byte[]{43, 111, 113, 111, 108, 122, 96, 58})) + str;
    }

    public static String c() {
        return Build.VERSION.RELEASE;
    }

    public static String c(Context context) {
        String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        return subscriberId != null ? subscriberId : "";
    }

    public static String c(String str) {
        String[] strArr = {a(new byte[]{116, 104, 48, 47, 96, 110, 122, 108, 125, 120, 98, 102, 42, 103, 111, 108, 59, 61, 50, 49, 37}), a(new byte[]{116, 104, 51, 47, 96, 110, 122, 108, 125, 120, 98, 102, 42, 103, 111, 108, 59, 61, 50, 49, 37}), a(new byte[]{116, 104, 50, 47, 96, 110, 122, 108, 125, 120, 98, 102, 42, 103, 111, 108, 59, 61, 50, 49, 37}), a(new byte[]{116, 104, 53, 47, 96, 110, 122, 108, 125, 120, 98, 102, 42, 103, 111, 108, 59, 61, 50, 49, 37}), a(new byte[]{116, 104, 48, 47, 119, 119, 123, 124, 106, 110, 123, 96, 118, 42, 99, 110, 108, 63, 58, 57, 45, 55}), a(new byte[]{116, 104, 51, 47, 119, 119, 123, 124, 106, 110, 123, 96, 118, 42, 99, 110, 108, 63, 58, 57, 45, 55}), a(new byte[]{116, 104, 50, 47, 119, 119, 123, 124, 106, 110, 123, 96, 118, 42, 99, 110, 108, 63, 58, 57, 45, 55}), a(new byte[]{116, 104, 53, 47, 119, 119, 123, 124, 106, 110, 123, 96, 118, 42, 99, 110, 108, 63, 58, 57, 45, 55})};
        return String.valueOf(String.valueOf(a(C0000a.aG)) + strArr[Math.abs(new Random().nextInt() % strArr.length)] + a(new byte[]{43, 111, 113, 111, 108, 122, 96, 58})) + str;
    }

    public static long d(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return (memoryInfo.availMem / 1024) / 1024;
    }

    public static String d() {
        return Build.MODEL;
    }

    private static String d(String str) throws IOException {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return new String(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String e() {
        Calendar calendar = Calendar.getInstance();
        String strValueOf = String.valueOf(0);
        try {
            return String.format(a(C0000a.dz), Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
        } catch (Exception e) {
            e.printStackTrace();
            return strValueOf;
        }
    }

    public static String e(Context context) {
        return String.valueOf(context.getFilesDir().getAbsolutePath()) + File.separator;
    }

    private static String e(String str) {
        char cCharAt;
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length() && ((cCharAt = sb.charAt(i)) == '\n' || cCharAt == '\r'); i++) {
            sb.setCharAt(i, ' ');
        }
        for (int length = sb.length() - 1; length >= 0; length--) {
            char cCharAt2 = sb.charAt(length);
            if (cCharAt2 != '\n' && cCharAt2 != '\r') {
                break;
            }
            sb.setCharAt(length, ' ');
        }
        return sb.toString().trim();
    }

    public static ArrayList f(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(512);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= runningServices.size()) {
                return arrayList;
            }
            arrayList.add(runningServices.get(i2).service.getPackageName());
            i = i2 + 1;
        }
    }

    public static HashMap f() {
        String strA = a(C0000a.ag);
        HashMap map = new HashMap();
        File file = new File(strA);
        return !file.exists() ? map : a(d(file.getAbsolutePath()));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String g() {
        /*
            r3 = 0
            java.lang.String r1 = java.lang.String.valueOf(r3)
            java.io.File r4 = new java.io.File
            byte[] r0 = com.android.a.C0000a.O
            java.lang.String r0 = a(r0)
            r4.<init>(r0)
            java.lang.String[] r5 = r4.list()
            if (r5 != 0) goto L17
        L16:
            return r1
        L17:
            r2 = r3
        L18:
            int r0 = r5.length
            if (r2 >= r0) goto L16
            r0 = r5[r2]
            byte[] r6 = com.android.a.C0000a.h
            java.lang.String r6 = a(r6)
            int r6 = r0.indexOf(r6)
            if (r6 < 0) goto L6b
            java.io.File r6 = new java.io.File
            r6.<init>(r4, r0)
            long r7 = r6.length()
            r9 = 0
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L6b
            long r6 = r6.length()
            r8 = 6
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto L48
            r0 = 1
            java.lang.String r1 = java.lang.String.valueOf(r0)
            goto L16
        L48:
            byte[] r6 = com.android.a.C0000a.h
            java.lang.String r6 = a(r6)
            int r6 = r6.length()
            java.lang.String r0 = r0.substring(r6)
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 != 0) goto L6b
            java.lang.String r6 = java.lang.String.valueOf(r3)
            boolean r6 = r0.equals(r6)
            if (r6 != 0) goto L6b
        L66:
            int r1 = r2 + 1
            r2 = r1
            r1 = r0
            goto L18
        L6b:
            r0 = r1
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.a.t.g():java.lang.String");
    }

    public static List g(Context context) {
        return context.getPackageManager().getInstalledPackages(0);
    }

    public static boolean h(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED && activeNetworkInfo.getTypeName().toLowerCase(Locale.CHINA).equals(a(C0000a.at));
    }
}
