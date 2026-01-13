package com.android.a;

import android.content.Context;
import com.shuame.rootgenius.sdk.JniRoot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class z implements Serializable {
    private static final String a = t.a(C0000a.cn);
    private static final long serialVersionUID = -7764865813035142873L;

    private void a(String str) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private static void a(String str, String str2) throws IOException {
        try {
            if (!new File(str).exists()) {
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    fileInputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(Context context, JniRoot.RootParam rootParam, String str) throws InterruptedException, IOException {
        int i = rootParam.androidSdkVer;
        int i2 = rootParam.rootgeniusVer;
        String str2 = rootParam.androidVer;
        String str3 = rootParam.buildDescription;
        String str4 = rootParam.coreVer;
        String str5 = rootParam.macAddr;
        String str6 = rootParam.productId;
        String str7 = rootParam.serial;
        String str8 = rootParam.soluParam;
        String str9 = rootParam.tempDir;
        e.a(t.a(C0000a.co), false);
        File file = new File(String.valueOf(t.a()) + File.separator + a);
        file.mkdirs();
        a(String.valueOf(file.getAbsolutePath()) + File.separator + t.a(C0000a.a));
        File file2 = new File(String.valueOf(t.a(C0000a.cb)) + a);
        file2.mkdirs();
        e.a(String.valueOf(t.a(C0000a.cp)) + file2.getAbsolutePath(), false);
        a(String.valueOf(file2.getAbsolutePath()) + File.separator + t.a(C0000a.a));
        e.a(String.valueOf(t.a(C0000a.cp)) + file2.getAbsolutePath() + File.separator + t.a(new byte[]{116, 112, 113, 113, 100, 112, 104, 120, 41, 111, 109}), false);
        String str10 = String.valueOf(u.b) + t.a(C0000a.bZ) + File.separator + t.a(C0000a.cl);
        a(str10, String.valueOf(file.getAbsolutePath()) + File.separator + t.a(C0000a.cl));
        a(str10, String.valueOf(file2.getAbsolutePath()) + File.separator + t.a(C0000a.cl));
        e.a(String.valueOf(t.a(C0000a.cp)) + file2.getAbsolutePath() + File.separator + t.a(C0000a.cl), false);
        File file3 = new File(String.valueOf(context.getDir(t.a(C0000a.A), 0).getAbsolutePath()) + File.separator + t.a(C0000a.G));
        a(file3.getAbsolutePath(), String.valueOf(file.getAbsolutePath()) + File.separator + t.a(C0000a.cq));
        a(file3.getAbsolutePath(), String.valueOf(file2.getAbsolutePath()) + File.separator + t.a(C0000a.cq));
        e.a(String.valueOf(t.a(C0000a.cp)) + file2.getAbsolutePath() + File.separator + t.a(C0000a.cq), false);
        File file4 = new File(String.valueOf(file.getAbsolutePath()) + File.separator + t.a(C0000a.cf));
        File file5 = new File(String.valueOf(file2.getAbsolutePath()) + File.separator + t.a(C0000a.cf));
        file4.mkdirs();
        file5.mkdirs();
        e.a(String.valueOf(t.a(C0000a.cp)) + file5.getAbsolutePath(), false);
        for (File file6 : new File(rootParam.soluWorkDir).listFiles()) {
            a(file6.getAbsolutePath(), String.valueOf(file4.getAbsolutePath()) + File.separator + file6.getName());
            a(file6.getAbsolutePath(), String.valueOf(file5.getAbsolutePath()) + File.separator + file6.getName());
            e.a(String.valueOf(t.a(C0000a.cp)) + file5.getAbsolutePath() + File.separator + file6.getName(), false);
        }
        e.a(t.a(C0000a.cr), false);
    }
}
