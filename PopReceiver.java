package com.android.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.a.a.a.b;

/* loaded from: classes.dex */
public class PopReceiver extends BroadcastReceiver {
    /* JADX WARN: Removed duplicated region for block: B:61:0x020f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(android.content.Context r11, android.content.Intent r12) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.system.PopReceiver.a(android.content.Context, android.content.Intent):void");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws NumberFormatException {
        context.startService(new Intent(context, (Class<?>) UpdateService.class));
        if (intent.getAction().equals(b.af)) {
            a(context, intent);
        }
    }
}
