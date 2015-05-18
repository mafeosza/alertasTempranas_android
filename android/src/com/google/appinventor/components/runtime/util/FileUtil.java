// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.os.Environment;
import com.google.appinventor.components.runtime.errors.RuntimeError;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;

public class FileUtil
{
    public static class FileException extends RuntimeError
    {

        private final int msgNumber;

        public int getErrorMessageNumber()
        {
            return msgNumber;
        }

        public FileException(int i)
        {
            msgNumber = i;
        }
    }


    private static final String DIRECTORY_DOWNLOADS = "Downloads";
    private static final String DIRECTORY_PICTURES = "Pictures";
    private static final String DIRECTORY_RECORDINGS = "Recordings";
    private static final String DOCUMENT_DIRECTORY = "My Documents/";
    private static final String FILENAME_PREFIX = "app_inventor_";

    private FileUtil()
    {
    }

    public static void checkExternalStorageWriteable()
        throws FileException
    {
        String s = Environment.getExternalStorageState();
        if ("mounted".equals(s))
        {
            return;
        }
        if ("mounted_ro".equals(s))
        {
            throw new FileException(704);
        } else
        {
            throw new FileException(705);
        }
    }

    private static void copy(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        outputstream = new BufferedOutputStream(outputstream, 4096);
        inputstream = new BufferedInputStream(inputstream, 4096);
        do
        {
            int i = inputstream.read();
            if (i == -1)
            {
                outputstream.flush();
                return;
            }
            outputstream.write(i);
        } while (true);
    }

    public static String copyFile(String s, String s1)
        throws IOException
    {
        s = new FileInputStream(s);
        s1 = writeStreamToFile(s, s1);
        s.close();
        return s1;
        s1;
        s.close();
        throw s1;
    }

    public static String downloadUrlToFile(String s, String s1)
        throws IOException
    {
        s = (new URL(s)).openStream();
        s1 = writeStreamToFile(s, s1);
        s.close();
        return s1;
        s1;
        s.close();
        throw s1;
    }

    public static File getDownloadFile(String s)
        throws IOException, FileException
    {
        return getFile("Downloads", s);
    }

    public static File getExternalFile(String s)
        throws IOException, FileException
    {
        checkExternalStorageWriteable();
        s = new File(Environment.getExternalStorageDirectory(), s);
        File file = s.getParentFile();
        if (!file.exists() && !file.mkdirs())
        {
            throw new IOException((new StringBuilder()).append("Unable to create directory ").append(file.getAbsolutePath()).toString());
        }
        if (s.exists() && !s.delete())
        {
            throw new IOException((new StringBuilder()).append("Cannot overwrite existing file ").append(s.getAbsolutePath()).toString());
        } else
        {
            return s;
        }
    }

    private static File getFile(String s, String s1)
        throws IOException, FileException
    {
        return getExternalFile((new StringBuilder()).append("My Documents/").append(s).append("/").append("app_inventor_").append(System.currentTimeMillis()).append(".").append(s1).toString());
    }

    public static String getFileUrl(String s)
    {
        return (new File(s)).toURI().toString();
    }

    public static File getPictureFile(String s)
        throws IOException, FileException
    {
        return getFile("Pictures", s);
    }

    public static File getRecordingFile(String s)
        throws IOException, FileException
    {
        return getFile("Recordings", s);
    }

    public static byte[] readFile(String s)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();
        s = new FileInputStream(s);
        copy(s, bytearrayoutputstream);
        s.close();
        return bytearrayoutputstream.toByteArray();
        Exception exception;
        exception;
        s.close();
        throw exception;
    }

    public static String writeFile(byte abyte0[], String s)
        throws IOException
    {
        abyte0 = new ByteArrayInputStream(abyte0);
        s = writeStreamToFile(abyte0, s);
        abyte0.close();
        return s;
        s;
        abyte0.close();
        throw s;
    }

    public static String writeStreamToFile(InputStream inputstream, String s)
        throws IOException
    {
        File file;
        file = new File(s);
        file.getParentFile().mkdirs();
        s = new FileOutputStream(file);
        copy(inputstream, s);
        inputstream = file.toURI().toString();
        s.flush();
        s.close();
        return inputstream;
        inputstream;
        s.flush();
        s.close();
        throw inputstream;
    }
}
