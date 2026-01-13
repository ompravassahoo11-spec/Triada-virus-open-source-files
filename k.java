package com.zmpk.a;

import java.io.IOException;

/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ i a;

    k(i iVar) {
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() throws NumberFormatException {
        try {
            this.a.e();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }
}
