package com.zmpk.a;

import java.util.Locale;

/* loaded from: classes.dex */
class f extends b {
    final /* synthetic */ e a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f(e eVar, String... strArr) {
        super(strArr);
        this.a = eVar;
    }

    @Override // com.zmpk.a.b
    public void a(int i) {
    }

    @Override // com.zmpk.a.b
    public void a(int i, String str) {
        if (str == null || !str.toLowerCase(Locale.CHINA).contains("uid=0")) {
            return;
        }
        e.f = true;
    }
}
