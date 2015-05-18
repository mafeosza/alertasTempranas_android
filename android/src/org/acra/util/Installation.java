// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.util;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;
import org.acra.ACRA;

public class Installation
{

    private static final String INSTALLATION = "ACRA-INSTALLATION";
    private static String sID;

    public Installation()
    {
    }

    public static String id(Context context)
    {
        org/acra/util/Installation;
        JVM INSTR monitorenter ;
        File file;
        if (sID != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        file = new File(context.getFilesDir(), "ACRA-INSTALLATION");
        if (!file.exists())
        {
            writeInstallationFile(file);
        }
        sID = readInstallationFile(file);
        context = sID;
_L2:
        org/acra/util/Installation;
        JVM INSTR monitorexit ;
        return context;
        Object obj;
        obj;
        Log.w(ACRA.LOG_TAG, (new StringBuilder()).append("Couldn't retrieve InstallationId for ").append(context.getPackageName()).toString(), ((Throwable) (obj)));
        context = "Couldn't retrieve InstallationId";
        continue; /* Loop/switch isn't completed */
        obj;
        Log.w(ACRA.LOG_TAG, (new StringBuilder()).append("Couldn't retrieve InstallationId for ").append(context.getPackageName()).toString(), ((Throwable) (obj)));
        context = "Couldn't retrieve InstallationId";
        if (true) goto _L2; else goto _L1
_L1:
        context;
        throw context;
    }

    private static String readInstallationFile(File file)
        throws IOException
    {
        byte abyte0[];
        file = new RandomAccessFile(file, "r");
        abyte0 = new byte[(int)file.length()];
        file.readFully(abyte0);
        file.close();
        return new String(abyte0);
        Exception exception;
        exception;
        file.close();
        throw exception;
    }

    private static void writeInstallationFile(File file)
        throws IOException
    {
        file = new FileOutputStream(file);
        file.write(UUID.randomUUID().toString().getBytes());
        file.close();
        return;
        Exception exception;
        exception;
        file.close();
        throw exception;
    }
}
