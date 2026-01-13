package com.zmpk.a;

import java.io.IOException;

/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.d();
        } catch (IOException e) {
        }
    }
}
