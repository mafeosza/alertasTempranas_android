// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.net.URI;

// Referenced classes of package gnu.text:
//            URIPath

class URIStringPath extends URIPath
{

    String uriString;

    public URIStringPath(URI uri, String s)
    {
        super(uri);
        uriString = s;
    }

    public String toURIString()
    {
        return uriString;
    }
}
