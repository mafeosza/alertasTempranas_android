// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.xml.Document;
import gnu.kawa.xml.KAttr;
import gnu.kawa.xml.KComment;
import gnu.kawa.xml.KDocument;
import gnu.kawa.xml.KElement;
import gnu.kawa.xml.KProcessingInstruction;
import gnu.kawa.xml.OutputAsXML;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;

public class XML extends ModuleBody
{

    public static final XML $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    public static OutputAsXML as$Mnxml;
    public static final ModuleMethod attribute$Mnname;
    public static final Class comment = gnu/kawa/xml/KComment;
    public static final ModuleMethod element$Mnname;
    public static final ModuleMethod parse$Mnxml$Mnfrom$Mnurl;
    public static final Class processing$Mninstruction = gnu/kawa/xml/KProcessingInstruction;

    public XML()
    {
        ModuleInfo.register(this);
    }

    public static Symbol attributeName(KAttr kattr)
    {
        return kattr.getNodeSymbol();
    }

    public static Symbol elementName(KElement kelement)
    {
        return kelement.getNodeSymbol();
    }

    public static KDocument parseXmlFromUrl(Object obj)
    {
        return Document.parse(obj);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 1: // '\001'
            return parseXmlFromUrl(obj);

        case 2: // '\002'
            try
            {
                modulemethod = (KElement)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "element-name", 1, obj);
            }
            return elementName(modulemethod);

        case 3: // '\003'
            break;
        }
        try
        {
            modulemethod = (KAttr)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "attribute-name", 1, obj);
        }
        return attributeName(modulemethod);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        int i = 0xfff40001;
        modulemethod.selector;
        JVM INSTR tableswitch 1 3: default 36
    //                   1 96
    //                   2 72
    //                   3 48;
           goto _L1 _L2 _L3 _L4
_L1:
        i = super.match1(modulemethod, obj, callcontext);
_L6:
        return i;
_L4:
        if (!(obj instanceof KAttr)) goto _L6; else goto _L5
_L5:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L3:
        if (!(obj instanceof KElement)) goto _L6; else goto _L7
_L7:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L2:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
        as$Mnxml = new OutputAsXML();
    }

    static 
    {
        Lit2 = (SimpleSymbol)(new SimpleSymbol("attribute-name")).readResolve();
        Lit1 = (SimpleSymbol)(new SimpleSymbol("element-name")).readResolve();
        Lit0 = (SimpleSymbol)(new SimpleSymbol("parse-xml-from-url")).readResolve();
        $instance = new XML();
        XML xml = $instance;
        parse$Mnxml$Mnfrom$Mnurl = new ModuleMethod(xml, 1, Lit0, 4097);
        element$Mnname = new ModuleMethod(xml, 2, Lit1, 4097);
        attribute$Mnname = new ModuleMethod(xml, 3, Lit2, 4097);
        $instance.run();
    }
}
