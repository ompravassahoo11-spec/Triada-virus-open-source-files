package com.zmpk.a;

import android.content.Context;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes.dex */
class l extends Thread {
    public DataInputStream a;
    private int b;
    private DataOutputStream c;
    private Context d;

    private l(Context context, Process process, DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        this.b = -911;
        this.a = dataInputStream;
        this.c = dataOutputStream;
        this.d = context;
    }

    /* synthetic */ l(Context context, Process process, DataInputStream dataInputStream, DataOutputStream dataOutputStream, l lVar) {
        this(context, process, dataInputStream, dataOutputStream);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws IOException {
        try {
            this.c.writeBytes("echo Started\n");
            this.c.flush();
            while (true) {
                String line = this.a.readLine();
                if (line == null) {
                    throw new EOFException();
                }
                if (!"".equals(line)) {
                    if ("Started".equals(line)) {
                        this.b = 1;
                        return;
                    }
                    i.g = "unkown error occured.";
                }
            }
        } catch (IOException e) {
            this.b = -42;
            if (e.getMessage() != null) {
                i.g = e.getMessage();
            } else {
                i.g = "RootAccess denied?.";
            }
        }
    }
}
