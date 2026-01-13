package com.zmpk.a;

import android.content.Context;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
class i {
    private static int f = 10000;
    private static String g = "";
    private static i h = null;
    private static i i = null;
    private final Process a;
    private final DataInputStream b;
    private final DataOutputStream c;
    private final List d = new ArrayList();
    private boolean e = false;
    private Runnable j = new j(this);
    private Runnable k = new k(this);

    private i(Context context, String str) throws TimeoutException, d {
        this.a = new ProcessBuilder(str).redirectErrorStream(true).start();
        this.b = new DataInputStream(this.a.getInputStream());
        this.c = new DataOutputStream(this.a.getOutputStream());
        l lVar = new l(context, this.a, this.b, this.c, null);
        lVar.start();
        try {
            lVar.join(f);
            if (lVar.b == -911) {
                this.a.destroy();
                throw new TimeoutException(g);
            }
            if (lVar.b == -42) {
                this.a.destroy();
                throw new d("Root Access Denied");
            }
            new Thread(this.j, "Shell Input").start();
            new Thread(this.k, "Shell Output").start();
        } catch (InterruptedException e) {
            lVar.interrupt();
            Thread.currentThread().interrupt();
            throw new TimeoutException();
        }
    }

    static i a(Context context) {
        return a(context, f);
    }

    private static i a(Context context, int i2) throws IOException {
        f = i2;
        if (h == null) {
            int i3 = 0;
            while (h == null) {
                try {
                    h = new i(context, "su");
                } catch (IOException e) {
                    int i4 = i3 + 1;
                    if (i3 >= 5) {
                        throw e;
                    }
                    i3 = i4;
                }
            }
        }
        return h;
    }

    static void a() {
        c();
        b();
    }

    private static void b() {
        if (i == null) {
            return;
        }
        i.f();
    }

    private static void c() {
        if (h == null) {
            return;
        }
        h.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() throws IOException {
        DataOutputStream dataOutputStream;
        int i2 = 0;
        while (true) {
            try {
                synchronized (this.d) {
                    while (!this.e && i2 >= this.d.size()) {
                        this.d.wait();
                    }
                    dataOutputStream = this.c;
                }
                if (i2 < this.d.size()) {
                    ((b) this.d.get(i2)).a(dataOutputStream);
                    dataOutputStream.write(("\necho F*D^W@#FGF " + i2 + " $?\n").getBytes());
                    dataOutputStream.flush();
                    i2++;
                } else if (this.e) {
                    dataOutputStream.write("\nexit 0\n".getBytes());
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() throws InterruptedException, IOException, NumberFormatException {
        int i2;
        int i3 = 0;
        b bVar = null;
        while (true) {
            String line = this.b.readLine();
            if (line == null) {
                break;
            }
            if (bVar == null) {
                if (i3 < this.d.size()) {
                    bVar = (b) this.d.get(i3);
                } else if (this.e) {
                    break;
                }
            }
            int iIndexOf = line.indexOf("F*D^W@#FGF");
            if (iIndexOf > 0) {
                bVar.a(bVar.a(), line.substring(0, iIndexOf));
            }
            if (iIndexOf >= 0) {
                String strSubstring = line.substring(iIndexOf);
                String[] strArrSplit = strSubstring.split(" ");
                if (strArrSplit.length >= 2 && strArrSplit[1] != null) {
                    try {
                        i2 = Integer.parseInt(strArrSplit[1]);
                    } catch (NumberFormatException e) {
                        i2 = 0;
                    }
                    int i4 = -1;
                    try {
                        i4 = Integer.parseInt(strArrSplit[2]);
                    } catch (NumberFormatException e2) {
                    }
                    if (i2 == i3) {
                        bVar.b(i4);
                        i3++;
                        bVar = null;
                    }
                }
                line = strSubstring;
            }
            bVar.a(bVar.a(), line);
        }
        this.a.waitFor();
        this.a.destroy();
        while (i3 < this.d.size()) {
            if (bVar == null) {
                bVar = (b) this.d.get(i3);
            }
            bVar.a("Unexpected Termination.");
            i3++;
            bVar = null;
        }
    }

    private void f() {
        if (this == h) {
            h = null;
        }
        if (this == i) {
            i = null;
        }
        synchronized (this.d) {
            this.e = true;
            this.d.notifyAll();
        }
    }

    b a(b bVar) {
        if (this.e) {
            throw new IllegalStateException("Unable to add commands to a closed shell");
        }
        synchronized (this.d) {
            this.d.add(bVar);
            this.d.notifyAll();
        }
        return bVar;
    }
}
