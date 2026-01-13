package com.android.a;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes.dex */
public final class r {
    private String a;
    private byte[] b;
    private s c;

    public r(String str, String str2) {
        this.a = null;
        this.c = null;
        this.a = str;
        this.b = str2.getBytes();
        this.c = new s();
    }

    public final String a() throws IOException {
        byte[] bArrB;
        try {
            this.b = this.c.a(this.b);
            this.b = C0001b.a(this.b);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a.trim()).openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(60000);
            httpURLConnection.setRequestMethod(t.a(C0000a.W));
            httpURLConnection.setRequestProperty(t.a(C0000a.Y), String.valueOf(this.b.length));
            httpURLConnection.setRequestProperty(t.a(C0000a.Z), t.a(C0000a.aa));
            httpURLConnection.setRequestProperty(t.a(C0000a.ab), t.a(C0000a.ac));
            httpURLConnection.setRequestProperty(t.a(C0000a.ad), t.a(C0000a.ae));
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(this.b);
            dataOutputStream.flush();
            dataOutputStream.close();
            if (200 == httpURLConnection.getResponseCode()) {
                byte[] bArr = new byte[2048];
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
                byteArrayOutputStream.close();
                inputStream.close();
                bArrB = this.c.b(C0001b.b(byteArrayOutputStream.toByteArray()));
            } else {
                bArrB = null;
            }
            if (bArrB != null) {
                return new String(bArrB, t.a(C0000a.ae));
            }
        } catch (Exception e) {
            e.toString();
        }
        return null;
    }
}
