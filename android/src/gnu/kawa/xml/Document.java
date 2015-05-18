// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.Consumer;
import gnu.lists.XConsumer;
import gnu.mapping.Location;
import gnu.mapping.ThreadLocation;
import gnu.text.Path;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import gnu.xml.NodeTree;
import gnu.xml.XMLParser;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Hashtable;

// Referenced classes of package gnu.kawa.xml:
//            KDocument

public class Document
{
    private static class DocReference extends SoftReference
    {

        static ReferenceQueue queue = new ReferenceQueue();
        Path key;


        public DocReference(Path path, KDocument kdocument)
        {
            super(kdocument, queue);
            key = path;
        }
    }


    private static HashMap cache = new HashMap();
    private static ThreadLocation docMapLocation = new ThreadLocation("document-map");
    public static final Document document = new Document();

    public Document()
    {
    }

    public static void clearLocalCache()
    {
        docMapLocation.getLocation().set(null);
    }

    public static void clearSoftCache()
    {
        cache = new HashMap();
    }

    public static KDocument parse(Object obj)
        throws Throwable
    {
        NodeTree nodetree = new NodeTree();
        parse(obj, ((Consumer) (nodetree)));
        return new KDocument(nodetree, 10);
    }

    public static void parse(Object obj, Consumer consumer)
        throws Throwable
    {
        SourceMessages sourcemessages = new SourceMessages();
        if (consumer instanceof XConsumer)
        {
            ((XConsumer)consumer).beginEntity(obj);
        }
        XMLParser.parse(obj, sourcemessages, consumer);
        if (sourcemessages.seenErrors())
        {
            throw new SyntaxException("document function read invalid XML", sourcemessages);
        }
        if (consumer instanceof XConsumer)
        {
            ((XConsumer)consumer).endEntity();
        }
    }

    public static KDocument parseCached(Path path)
        throws Throwable
    {
        gnu/kawa/xml/Document;
        JVM INSTR monitorenter ;
_L5:
        Object obj = (DocReference)DocReference.queue.poll();
        if (obj != null) goto _L2; else goto _L1
_L1:
        Object obj1;
        gnu.mapping.NamedLocation namedlocation;
        namedlocation = docMapLocation.getLocation();
        obj1 = (Hashtable)namedlocation.get(null);
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        obj = new Hashtable();
        namedlocation.set(obj);
        obj1 = (KDocument)((Hashtable) (obj)).get(path);
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        path = ((Path) (obj1));
_L6:
        gnu/kawa/xml/Document;
        JVM INSTR monitorexit ;
        return path;
_L2:
        cache.remove(((DocReference) (obj)).key);
          goto _L5
        path;
        throw path;
_L4:
        obj1 = (DocReference)cache.get(path);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        obj1 = (KDocument)((DocReference) (obj1)).get();
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        cache.remove(path);
        obj1 = parse(path);
        ((Hashtable) (obj)).put(path, obj1);
        cache.put(path, new DocReference(path, ((KDocument) (obj1))));
        path = ((Path) (obj1));
          goto _L6
        ((Hashtable) (obj)).put(path, obj1);
        path = ((Path) (obj1));
          goto _L6
    }

    public static KDocument parseCached(Object obj)
        throws Throwable
    {
        return parseCached(Path.valueOf(obj));
    }

}
