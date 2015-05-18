// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.servlet;

import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleContext;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.text.Path;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Hashtable;

// Referenced classes of package gnu.kawa.servlet:
//            HttpRequestContext, ServletPrinter

public class KawaAutoHandler
{

    static final String MODULE_MAP_ATTRIBUTE = "gnu.kawa.module-map";

    public KawaAutoHandler()
    {
    }

    public static Object getModule(HttpRequestContext httprequestcontext, CallContext callcontext, boolean flag)
        throws Exception
    {
        Object obj;
        Object obj1;
        ModuleContext modulecontext;
        Object obj2;
        Object obj3;
        Object obj4;
        ModuleInfo moduleinfo1;
        ModuleManager modulemanager;
        int i;
        long l;
        obj2 = httprequestcontext.getRequestPath().substring(httprequestcontext.getContextPath().length() - 1);
        obj = (Hashtable)httprequestcontext.getAttribute("gnu.kawa.module-map");
        obj4 = obj;
        if (obj == null)
        {
            obj4 = new Hashtable();
            httprequestcontext.setAttribute("gnu.kawa.module-map", obj4);
        }
        obj = (ModuleContext)httprequestcontext.getAttribute("gnu.kawa.module-context");
        modulecontext = ((ModuleContext) (obj));
        if (obj == null)
        {
            modulecontext = ModuleContext.getContext();
        }
        modulecontext.addFlags(ModuleContext.IN_HTTP_SERVER);
        if (httprequestcontext.getClass().getName().endsWith("KawaServlet$Context"))
        {
            modulecontext.addFlags(ModuleContext.IN_SERVLET);
        }
        moduleinfo1 = (ModuleInfo)((Hashtable) (obj4)).get(obj2);
        l = System.currentTimeMillis();
        modulemanager = modulecontext.getManager();
        if (moduleinfo1 != null && l - moduleinfo1.lastCheckedTime < modulemanager.lastModifiedCacheTime)
        {
            return modulecontext.findInstance(moduleinfo1);
        }
        i = ((String) (obj2)).length();
        if (i == 0 || ((String) (obj2)).charAt(i - 1) == '/')
        {
            obj = null;
        } else
        {
            obj = httprequestcontext.getResourceURL(((String) (obj2)));
        }
        obj1 = obj2;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_383;
        }
        obj3 = obj2;
_L4:
        i = ((String) (obj3)).lastIndexOf('/');
        if (i >= 0) goto _L2; else goto _L1
_L1:
        if (obj == null)
        {
            callcontext = (new StringBuilder()).append("The requested URL ").append(((String) (obj2))).append(" was not found on this server.").append(" res/:").append(httprequestcontext.getResourceURL("/")).append("\r\n").toString().getBytes();
            httprequestcontext.sendResponseHeaders(404, null, callcontext.length);
            httprequestcontext = httprequestcontext.getResponseStream();
            URL url;
            String s2;
            try
            {
                httprequestcontext.write(callcontext);
            }
            // Misplaced declaration of an exception variable
            catch (HttpRequestContext httprequestcontext)
            {
                throw new RuntimeException(httprequestcontext);
            }
            return null;
        }
        break MISSING_BLOCK_LABEL_404;
_L2:
        obj3 = ((String) (obj3)).substring(0, i);
        s2 = (new StringBuilder()).append(((String) (obj3))).append("/+default+").toString();
        url = httprequestcontext.getResourceURL(s2);
        obj1 = s2;
        obj = url;
        if (url == null) goto _L4; else goto _L3
_L3:
        httprequestcontext.setScriptAndLocalPath(((String) (obj2)).substring(1, i + 1), ((String) (obj2)).substring(i + 1));
        obj1 = s2;
        obj = url;
          goto _L1
        httprequestcontext.setScriptAndLocalPath(((String) (obj2)), "");
          goto _L1
        ModuleInfo moduleinfo;
label0:
        {
            String s1 = ((URL) (obj)).toExternalForm();
            if (moduleinfo1 != null)
            {
                moduleinfo = moduleinfo1;
                if (s1.equals(moduleinfo1.getSourceAbsPathname()))
                {
                    break label0;
                }
            }
            moduleinfo = modulemanager.findWithURL(((URL) (obj)));
        }
        if (moduleinfo.checkCurrent(modulemanager, l))
        {
            return modulecontext.findInstance(moduleinfo);
        }
        ((Hashtable) (obj4)).put(obj2, moduleinfo);
        Path path = moduleinfo.getSourceAbsPath();
        Object obj5 = path.openInputStream();
        obj4 = obj5;
        if (!(obj5 instanceof BufferedInputStream))
        {
            obj4 = new BufferedInputStream(((InputStream) (obj5)));
        }
        obj5 = Language.getInstanceFromFilenameExtension(((String) (obj2)));
        if (obj5 != null)
        {
            httprequestcontext.log((new StringBuilder()).append("Compile ").append(((String) (obj2))).append(" - a ").append(((Language) (obj5)).getName()).append(" source file (based on extension)").toString());
            obj1 = obj5;
        } else
        {
            Language language = Language.detect(((InputStream) (obj4)));
            if (language != null)
            {
                httprequestcontext.log((new StringBuilder()).append("Compile ").append(((String) (obj2))).append(" - a ").append(language.getName()).append(" source file (detected from content)").toString());
                obj1 = language;
            } else
            {
                if (obj2 != obj1)
                {
                    callcontext = (new StringBuilder()).append("The requested URL ").append(((String) (obj2))).append(" was not found on this server.").append(" upath=").append(((String) (obj1))).append(".\r\n").toString().getBytes();
                    httprequestcontext.sendResponseHeaders(404, null, callcontext.length);
                    httprequestcontext = httprequestcontext.getResponseStream();
                    try
                    {
                        httprequestcontext.write(callcontext);
                    }
                    // Misplaced declaration of an exception variable
                    catch (HttpRequestContext httprequestcontext)
                    {
                        throw new RuntimeException(httprequestcontext);
                    }
                    return null;
                }
                httprequestcontext.sendResponseHeaders(200, null, path.getContentLength());
                httprequestcontext = httprequestcontext.getResponseStream();
                callcontext = new byte[4096];
                do
                {
                    int j = ((InputStream) (obj4)).read(callcontext);
                    if (j < 0)
                    {
                        ((InputStream) (obj4)).close();
                        httprequestcontext.close();
                        return null;
                    }
                    httprequestcontext.write(callcontext, 0, j);
                } while (true);
            }
        }
        obj2 = new InPort(((InputStream) (obj4)), path);
        Language.setCurrentLanguage(((Language) (obj1)));
        obj4 = new SourceMessages();
        try
        {
            obj1 = ((Language) (obj1)).parse(((InPort) (obj2)), ((SourceMessages) (obj4)), 9, moduleinfo);
        }
        catch (SyntaxException syntaxexception)
        {
            if (syntaxexception.getMessages() != obj4)
            {
                throw syntaxexception;
            }
            syntaxexception = null;
        }
        obj2 = null;
        if (!((SourceMessages) (obj4)).seenErrors())
        {
            ((Compilation) (obj1)).getModule();
            obj2 = (Class)ModuleExp.evalModule1(Environment.getCurrent(), ((Compilation) (obj1)), ((URL) (obj)), null);
        }
        if (((SourceMessages) (obj4)).seenErrors())
        {
            String s = (new StringBuilder()).append("script syntax error:\n").append(((SourceMessages) (obj4)).toString(20)).toString();
            ((ServletPrinter)callcontext.consumer).addHeader("Content-type", "text/plain");
            httprequestcontext.sendResponseHeaders(500, "Syntax errors", -1L);
            callcontext.consumer.write(s);
            moduleinfo.cleanupAfterCompilation();
            return null;
        } else
        {
            moduleinfo.setModuleClass(((Class) (obj2)));
            return modulecontext.findInstance(moduleinfo);
        }
    }

    public static void run(HttpRequestContext httprequestcontext, CallContext callcontext)
        throws Throwable
    {
        boolean flag;
        if (httprequestcontext.getRequestParameter("qexo-save-class") != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        httprequestcontext = ((HttpRequestContext) (getModule(httprequestcontext, callcontext, flag)));
        if (httprequestcontext instanceof ModuleBody)
        {
            ((ModuleBody)httprequestcontext).run(callcontext);
        }
    }
}
