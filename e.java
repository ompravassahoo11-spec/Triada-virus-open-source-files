package com.zmpk.a;

import android.content.Context;

/* loaded from: classes.dex */
public class e {
    private static e a;
    private static Context b;
    private static boolean f = false;
    private Boolean c = null;
    private boolean d = false;
    private long e = -1;

    private e() {
    }

    public static synchronized e a(Context context) {
        if (a == null) {
            a = new e();
            b = context;
        }
        return a;
    }

    private boolean b() {
        f = false;
        try {
            i.a(b).a(new f(this, "id")).b();
            return f;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean a() {
        if (!this.d || this.e < 0 || System.currentTimeMillis() - this.e > 600000) {
            this.d = b();
            this.e = System.currentTimeMillis();
        }
        return this.d;
    }
}
