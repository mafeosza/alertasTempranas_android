// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.google.appinventor.components.runtime:
//            ImagePicker

class this._cls0
    implements Comparator
{

    final ImagePicker this$0;

    public int compare(File file, File file1)
    {
        return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file1.lastModified()));
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((File)obj, (File)obj1);
    }

    ()
    {
        this$0 = ImagePicker.this;
        super();
    }
}
