package com.android.a;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
final class v implements FileFilter {
    private v(u uVar) {
    }

    /* synthetic */ v(u uVar, byte b) {
        this(uVar);
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return Pattern.matches(t.a(C0000a.cm), file.getName());
    }
}
