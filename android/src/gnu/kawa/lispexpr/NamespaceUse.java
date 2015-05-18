// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.mapping.Namespace;

class NamespaceUse
{

    Namespace imported;
    Namespace importing;
    NamespaceUse nextImported;
    NamespaceUse nextImporting;

    NamespaceUse()
    {
    }
}
