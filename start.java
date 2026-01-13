package com.android.xb.start;

import android.content.Context;
import com.android.a.e;
import java.io.IOException;

/* loaded from: classes.dex */
public class start {
    private static boolean isStartRun = false;
    public static Context realContext;
    public static Thread thread;

    public static void init(final Context context) {
        if (thread == null || !isStartRun) {
            Thread thread2 = new Thread() { // from class: com.android.xb.start.start.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws IllegalAccessException, InterruptedException, IOException, IllegalArgumentException {
                    if (start.isStartRun) {
                        return;
                    }
                    start.isStartRun = true;
                    start.realContext = context;
                    e.c(context);
                    start.isStartRun = false;
                    start.thread = null;
                }
            };
            thread = thread2;
            thread2.start();
        }
    }

    public static void setInterface(SuccessInterface successInterface) {
        e.a(successInterface);
    }
}
