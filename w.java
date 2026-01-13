package com.android.a;

import java.io.File;

/* loaded from: classes.dex */
final class w extends Thread {
    boolean a;
    private x b;
    private /* synthetic */ u c;

    public w(u uVar, x xVar) {
        this.c = uVar;
        this.b = null;
        this.a = false;
        this.b = xVar;
        this.a = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws InterruptedException {
        boolean z = false;
        long jCurrentTimeMillis = System.currentTimeMillis() + 61440;
        while (true) {
            try {
                if (this.a) {
                    z = true;
                }
                File file = new File(String.valueOf(t.a(C0000a.M)) + u.c);
                File file2 = new File(String.valueOf(t.a(C0000a.L)) + u.c);
                if ((file.exists() || file2.exists()) && e.a()) {
                    e.a(u.a, true, false);
                    new z().a(u.a, this.c.m, this.b.a);
                    u.d = true;
                    u.e = true;
                    return;
                }
                if (jCurrentTimeMillis < System.currentTimeMillis() || z) {
                    return;
                } else {
                    Thread.sleep(48L);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
