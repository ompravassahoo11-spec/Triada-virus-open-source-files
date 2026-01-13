package com.zmpk.a;

/* loaded from: classes.dex */
public class c {
    public static String a = "";
    public static final String b = a(a.b);
    public static final String c = a(a.f);
    public static final String d = a(a.g);
    public static final String e = a(a.h);
    public static final String f = com.zmpk.b.e.b(a.a);
    public static final String g = a(a.i);
    public static final String h = a(a.q);
    public static final String i = a(a.c);
    public static final String j = a(a.j);
    public static final String k = a(a.k);
    public static final String l = a(a.l);
    public static final String m = a(a.m);
    public static final String n = a(a.o);
    public static final String o = a(a.p);

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new String(b(bArr));
    }

    public static byte[] b(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] - 1);
        }
        return bArr2;
    }
}
