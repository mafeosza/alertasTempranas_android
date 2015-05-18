// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.FString;
import gnu.mapping.CharArrayOutPort;
import gnu.mapping.Procedure1;
import gnu.xml.XMLPrinter;

public class OutputAsXML extends Procedure1
{

    public OutputAsXML()
    {
    }

    public Object apply1(Object obj)
    {
        CharArrayOutPort chararrayoutport = new CharArrayOutPort();
        XMLPrinter xmlprinter = new XMLPrinter(chararrayoutport);
        xmlprinter.writeObject(obj);
        xmlprinter.flush();
        return new FString(chararrayoutport.toCharArray());
    }

    public int numArgs()
    {
        return 4097;
    }
}
