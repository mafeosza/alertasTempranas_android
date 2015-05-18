// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.FileUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, ComponentContainer, ReplForm, 
//            Form, EventDispatcher

public class File extends AndroidNonvisibleComponent
    implements Component
{

    private static final String LOG_TAG = "FileComponent";
    public static final String NO_ASSETS = "No_Assets";
    private final int BUFFER_LENGTH = 4096;
    private final Activity activity;
    private boolean isRepl;

    public File(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        isRepl = false;
        if (form instanceof ReplForm)
        {
            isRepl = true;
        }
        activity = componentcontainer.$context();
    }

    private String AbsoluteFileName(String s)
    {
        if (s.startsWith("/"))
        {
            return (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append(s).toString();
        }
        java.io.File file = activity.getFilesDir();
        if (isRepl)
        {
            java.io.File file1 = new java.io.File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/AppInventor/data/").toString());
            file = file1;
            if (!file1.exists())
            {
                file1.mkdirs();
                file = file1;
            }
        }
        return (new StringBuilder()).append(file.getPath()).append("/").append(s).toString();
    }

    private void AsyncRead(InputStream inputstream, String s)
    {
        final Object text;
        Object obj;
        Object obj1;
        obj = null;
        text = null;
        obj1 = null;
        inputstream = new InputStreamReader(inputstream);
        text = new StringWriter();
        obj = new char[4096];
_L3:
        int i = inputstream.read(((char []) (obj)), 0, 4096);
        if (i <= 0) goto _L2; else goto _L1
_L1:
        ((StringWriter) (text)).write(((char []) (obj)), 0, i);
          goto _L3
        obj;
_L10:
        text = inputstream;
        Log.e("FileComponent", "FileNotFoundException", ((Throwable) (obj)));
        text = inputstream;
        form.dispatchErrorOccurredEvent(this, "ReadFrom", 2101, new Object[] {
            s
        });
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        inputstream.close();
_L5:
        return;
_L2:
        text = normalizeNewLines(((StringWriter) (text)).toString());
        activity.runOnUiThread(new Runnable() {

            final File this$0;
            final String val$text;

            public void run()
            {
                GotText(text);
            }

            
            {
                this$0 = File.this;
                text = s;
                super();
            }
        });
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                return;
            }
        } else
        {
            return;
        }
        text;
        inputstream = ((InputStream) (obj));
        obj = text;
_L8:
        text = inputstream;
        Log.e("FileComponent", "IOException", ((Throwable) (obj)));
        text = inputstream;
        form.dispatchErrorOccurredEvent(this, "ReadFrom", 2102, new Object[] {
            s
        });
        if (inputstream == null) goto _L5; else goto _L4
_L4:
        try
        {
            inputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return;
        }
        inputstream;
_L7:
        if (text != null)
        {
            try
            {
                ((InputStreamReader) (text)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        throw inputstream;
        inputstream;
        return;
        s;
        text = inputstream;
        inputstream = s;
        if (true) goto _L7; else goto _L6
_L6:
        obj;
          goto _L8
        obj;
        inputstream = obj1;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private void Write(final String filename, final String text, final boolean append)
    {
        if (filename.startsWith("//"))
        {
            if (append)
            {
                form.dispatchErrorOccurredEvent(this, "AppendTo", 2106, new Object[] {
                    filename
                });
                return;
            } else
            {
                form.dispatchErrorOccurredEvent(this, "SaveFile", 2106, new Object[] {
                    filename
                });
                return;
            }
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                final File this$0;
                final boolean val$append;
                final String val$filename;
                final String val$text;

                public void run()
                {
                    String s = AbsoluteFileName(filename);
                    Object obj = new java.io.File(s);
                    if (!((java.io.File) (obj)).exists())
                    {
                        try
                        {
                            ((java.io.File) (obj)).createNewFile();
                        }
                        catch (IOException ioexception)
                        {
                            if (append)
                            {
                                form.dispatchErrorOccurredEvent(File.this, "AppendTo", 2103, new Object[] {
                                    s
                                });
                                return;
                            } else
                            {
                                form.dispatchErrorOccurredEvent(File.this, "SaveFile", 2103, new Object[] {
                                    s
                                });
                                return;
                            }
                        }
                    }
                    try
                    {
                        obj = new FileOutputStream(((java.io.File) (obj)), append);
                        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(((java.io.OutputStream) (obj)));
                        outputstreamwriter.write(text);
                        outputstreamwriter.flush();
                        outputstreamwriter.close();
                        ((FileOutputStream) (obj)).close();
                        return;
                    }
                    catch (IOException ioexception1) { }
                    if (append)
                    {
                        form.dispatchErrorOccurredEvent(File.this, "AppendTo", 2104, new Object[] {
                            s
                        });
                        return;
                    } else
                    {
                        form.dispatchErrorOccurredEvent(File.this, "SaveFile", 2104, new Object[] {
                            s
                        });
                        return;
                    }
                }

            
            {
                this$0 = File.this;
                filename = s;
                append = flag;
                text = s1;
                super();
            }
            });
            return;
        }
    }

    private String normalizeNewLines(String s)
    {
        return s.replaceAll("\r\n", "\n");
    }

    public void AppendToFile(String s, String s1)
    {
        if (s1.startsWith("/"))
        {
            FileUtil.checkExternalStorageWriteable();
        }
        Write(s1, s, true);
    }

    public void Delete(String s)
    {
        if (s.startsWith("//"))
        {
            form.dispatchErrorOccurredEvent(this, "DeleteFile", 2105, new Object[] {
                s
            });
            return;
        } else
        {
            (new java.io.File(AbsoluteFileName(s))).delete();
            return;
        }
    }

    public void GotText(String s)
    {
        EventDispatcher.dispatchEvent(this, "GotText", new Object[] {
            s
        });
    }

    public void ReadFrom(final String fileName)
    {
        if (!fileName.startsWith("//"))
        {
            break MISSING_BLOCK_LABEL_85;
        }
        if (!isRepl) goto _L2; else goto _L1
_L1:
        final Object asyncInputStream = new FileInputStream((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/AppInventor/assets/").append(fileName).toString());
_L3:
        AsynchUtil.runAsynchronously(new Runnable() {

            final File this$0;
            final InputStream val$asyncInputStream;
            final String val$fileName;

            public void run()
            {
                AsyncRead(asyncInputStream, fileName);
            }

            
            {
                this$0 = File.this;
                asyncInputStream = inputstream;
                fileName = s;
                super();
            }
        });
        return;
_L2:
        try
        {
            asyncInputStream = form.getAssets().open(fileName.substring(2));
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            Log.e("FileComponent", "FileNotFoundException", filenotfoundexception);
            form.dispatchErrorOccurredEvent(this, "ReadFrom", 2101, new Object[] {
                fileName
            });
            return;
        }
        catch (IOException ioexception)
        {
            Log.e("FileComponent", "IOException", ioexception);
            form.dispatchErrorOccurredEvent(this, "ReadFrom", 2101, new Object[] {
                fileName
            });
            return;
        }
          goto _L3
        asyncInputStream = AbsoluteFileName(fileName);
        Log.d("FileComponent", (new StringBuilder()).append("filepath = ").append(((String) (asyncInputStream))).toString());
        asyncInputStream = new FileInputStream(((String) (asyncInputStream)));
          goto _L3
    }

    public void SaveFile(String s, String s1)
    {
        if (s1.startsWith("/"))
        {
            FileUtil.checkExternalStorageWriteable();
        }
        Write(s1, s, false);
    }


}
