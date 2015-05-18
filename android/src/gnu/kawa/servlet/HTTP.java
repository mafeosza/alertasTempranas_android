// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.servlet;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Format;
import gnu.kawa.xml.MakeResponseHeader;
import gnu.mapping.CallContext;
import gnu.mapping.InPort;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.text.URIPath;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

// Referenced classes of package gnu.kawa.servlet:
//            HttpRequestContext

public class HTTP extends ModuleBody
{

    public static final HTTP $instance;
    static final SimpleSymbol Lit0 = (SimpleSymbol)(new SimpleSymbol("Content-Type")).readResolve();
    static final SimpleSymbol Lit1 = (SimpleSymbol)(new SimpleSymbol("Status")).readResolve();
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    public static final ModuleMethod error$Mnresponse;
    public static final ModuleMethod request$MnURI;
    public static final ModuleMethod request$Mnbody$Mnstring;
    public static final ModuleMethod request$Mncontext$Mnpath;
    public static final ModuleMethod request$Mnheader;
    public static final ModuleMethod request$Mnheader$Mnmap;
    public static final ModuleMethod request$Mninput$Mnport;
    public static final ModuleMethod request$Mninput$Mnstream;
    public static final ModuleMethod request$Mnlocal$MnIP$Mnaddress;
    public static final ModuleMethod request$Mnlocal$Mnhost;
    public static final ModuleMethod request$Mnlocal$Mnpath;
    public static final ModuleMethod request$Mnlocal$Mnport;
    public static final ModuleMethod request$Mnlocal$Mnsocket$Mnaddress;
    public static final ModuleMethod request$Mnmethod;
    public static final ModuleMethod request$Mnparameter;
    public static final ModuleMethod request$Mnparameter$Mnmap;
    public static final ModuleMethod request$Mnparameters;
    public static final ModuleMethod request$Mnpath;
    public static final ModuleMethod request$Mnpath$Mntranslated;
    public static final ModuleMethod request$Mnquery$Mnstring;
    public static final ModuleMethod request$Mnremote$MnIP$Mnaddress;
    public static final ModuleMethod request$Mnremote$Mnhost;
    public static final ModuleMethod request$Mnremote$Mnport;
    public static final ModuleMethod request$Mnremote$Mnsocket$Mnaddress;
    public static final ModuleMethod request$Mnscheme;
    public static final ModuleMethod request$Mnscript$Mnpath;
    public static final ModuleMethod request$Mnuri;
    public static final ModuleMethod request$Mnurl;
    public static final ModuleMethod response$Mncontent$Mntype;
    public static final ModuleMethod response$Mnheader;
    public static final ModuleMethod response$Mnstatus;

    public HTTP()
    {
        ModuleInfo.register(this);
    }

    public static Object errorResponse(int i)
    {
        return errorResponse(i, "Error");
    }

    public static Object errorResponse(int i, String s)
    {
        return responseHeader(Lit1, Format.formatToString(0, new Object[] {
            "~d ~a", Integer.valueOf(i), s
        }));
    }

    public static URIPath request$MnURI()
    {
        return URIPath.makeURI(HttpRequestContext.getInstance("request-URI").getRequestURI());
    }

    public static CharSequence requestBodyString()
    {
        return HttpRequestContext.getInstance("request-body-string").getRequestBodyChars();
    }

    public static URIPath requestContextPath()
    {
        return URIPath.makeURI(HttpRequestContext.getInstance("request-context-path").getContextPath());
    }

    public static String requestHeader(Object obj)
    {
        HttpRequestContext httprequestcontext = HttpRequestContext.getInstance("request-header");
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = obj.toString();
        }
        return httprequestcontext.getRequestHeader(((String) (obj)));
    }

    public static Map requestHeaderMap()
    {
        return HttpRequestContext.getInstance("request-header-map").getRequestHeaders();
    }

    public static InPort requestInputPort()
    {
        return HttpRequestContext.getInstance("request-input-port").getRequestPort();
    }

    public static InputStream requestInputStream()
    {
        return HttpRequestContext.getInstance("request-input-stream").getRequestStream();
    }

    public static String requestLocal$MnIPAddress()
    {
        return HttpRequestContext.getInstance("request-local-IP-address").getLocalIPAddress();
    }

    public static InetAddress requestLocalHost()
    {
        return HttpRequestContext.getInstance("request-local-host").getLocalHost();
    }

    public static URIPath requestLocalPath()
    {
        return URIPath.makeURI(HttpRequestContext.getInstance("request-local-path").getLocalPath());
    }

    public static int requestLocalPort()
    {
        return HttpRequestContext.getInstance("request-local-port").getLocalPort();
    }

    public static InetSocketAddress requestLocalSocketAddress()
    {
        return HttpRequestContext.getInstance("request-local-socket-address").getLocalSocketAddress();
    }

    public static String requestMethod()
    {
        return HttpRequestContext.getInstance("request-method").getRequestMethod();
    }

    public static String requestParameter(String s)
    {
        return requestParameter(s, null);
    }

    public static String requestParameter(String s, Object obj)
    {
        s = HttpRequestContext.getInstance("request-parameter").getRequestParameter(s);
        if (s == null)
        {
            if (obj == null)
            {
                return null;
            } else
            {
                return obj.toString();
            }
        } else
        {
            return s;
        }
    }

    public static Map requestParameterMap()
    {
        return HttpRequestContext.getInstance("request-parameter-map").getRequestParameters();
    }

    public static Object requestParameters(String s)
    {
        s = ((String) (HttpRequestContext.getInstance("request-parameters").getRequestParameters().get(s)));
        List list;
        try
        {
            list = (List)s;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "plist", -2, s);
        }
        return Values.make(list);
    }

    public static String requestPath()
    {
        URIPath uripath = URIPath.makeURI(HttpRequestContext.getInstance("request-path").getRequestPath());
        if (uripath == null)
        {
            return null;
        } else
        {
            return uripath.toString();
        }
    }

    public static String requestPathTranslated()
    {
        return HttpRequestContext.getInstance("request-path-translated").getPathTranslated();
    }

    public static Object requestQueryString()
    {
        String s = HttpRequestContext.getInstance("request-query-string").getQueryString();
        Object obj = s;
        if (s == null)
        {
            obj = Boolean.FALSE;
        }
        return obj;
    }

    public static String requestRemote$MnIPAddress()
    {
        return HttpRequestContext.getInstance("request-remote-IP-address").getRemoteIPAddress();
    }

    public static InetAddress requestRemoteHost()
    {
        return HttpRequestContext.getInstance("request-remote-host").getRemoteHost();
    }

    public static int requestRemotePort()
    {
        return HttpRequestContext.getInstance("request-remote-port").getRemotePort();
    }

    public static InetSocketAddress requestRemoteSocketAddress()
    {
        return HttpRequestContext.getInstance("request-remote-socket-address").getRemoteSocketAddress();
    }

    public static String requestScheme()
    {
        return HttpRequestContext.getInstance("request-scheme").getRequestScheme();
    }

    public static URIPath requestScriptPath()
    {
        return URIPath.makeURI(HttpRequestContext.getInstance("request-script-path").getScriptPath());
    }

    public static String requestUri()
    {
        return requestPath();
    }

    public static StringBuffer requestUrl()
    {
        return HttpRequestContext.getInstance("request-path").getRequestURLBuffer();
    }

    public static Object responseContentType(Object obj)
    {
        return responseHeader(Lit0, obj);
    }

    public static Object responseHeader(Object obj, Object obj1)
    {
        return MakeResponseHeader.makeResponseHeader.apply2(obj, obj1);
    }

    public static Object responseStatus(int i)
    {
        return responseStatus(i, null);
    }

    public static Object responseStatus(int i, String s)
    {
        SimpleSymbol simplesymbol = Lit1;
        String s1;
        if (s == null)
        {
            s1 = "~d ";
        } else
        {
            s1 = "~d ~a";
        }
        return responseHeader(simplesymbol, Format.formatToString(0, new Object[] {
            s1, Integer.valueOf(i), s
        }));
    }

    public Object apply0(ModuleMethod modulemethod)
    {
        switch (modulemethod.selector)
        {
        case 17: // '\021'
        case 28: // '\034'
        case 29: // '\035'
        case 30: // '\036'
        default:
            return super.apply0(modulemethod);

        case 7: // '\007'
            return requestMethod();

        case 8: // '\b'
            return requestScheme();

        case 9: // '\t'
            return requestLocalSocketAddress();

        case 10: // '\n'
            return requestLocal$MnIPAddress();

        case 11: // '\013'
            return Integer.valueOf(requestLocalPort());

        case 12: // '\f'
            return requestLocalHost();

        case 13: // '\r'
            return requestRemoteSocketAddress();

        case 14: // '\016'
            return requestRemote$MnIPAddress();

        case 15: // '\017'
            return Integer.valueOf(requestRemotePort());

        case 16: // '\020'
            return requestRemoteHost();

        case 18: // '\022'
            return requestHeaderMap();

        case 19: // '\023'
            return request$MnURI();

        case 20: // '\024'
            return requestContextPath();

        case 21: // '\025'
            return requestScriptPath();

        case 22: // '\026'
            return requestLocalPath();

        case 23: // '\027'
            return requestPath();

        case 24: // '\030'
            return requestUri();

        case 25: // '\031'
            return requestUrl();

        case 26: // '\032'
            return requestPathTranslated();

        case 27: // '\033'
            return requestQueryString();

        case 31: // '\037'
            return requestParameterMap();

        case 32: // ' '
            return requestBodyString();

        case 33: // '!'
            return requestInputStream();

        case 34: // '"'
            return requestInputPort();
        }
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        Object obj2 = null;
        Object obj1 = null;
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 2: // '\002'
            return responseContentType(obj);

        case 3: // '\003'
            int i;
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "response-status", 1, obj);
            }
            return responseStatus(i);

        case 5: // '\005'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "error-response", 1, obj);
            }
            return errorResponse(i);

        case 17: // '\021'
            return requestHeader(obj);

        case 28: // '\034'
            if (obj == null)
            {
                modulemethod = obj1;
            } else
            {
                modulemethod = obj.toString();
            }
            return requestParameter(modulemethod);

        case 30: // '\036'
            break;
        }
        if (obj == null)
        {
            modulemethod = obj2;
        } else
        {
            modulemethod = obj.toString();
        }
        return requestParameters(modulemethod);
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        Object obj3 = null;
        Object obj2 = null;
        switch (modulemethod.selector)
        {
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 1: // '\001'
            return responseHeader(obj, obj1);

        case 3: // '\003'
            int i;
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "response-status", 1, obj);
            }
            if (obj1 == null)
            {
                modulemethod = null;
            } else
            {
                modulemethod = obj1.toString();
            }
            return responseStatus(i, modulemethod);

        case 5: // '\005'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "error-response", 1, obj);
            }
            if (obj1 == null)
            {
                modulemethod = obj2;
            } else
            {
                modulemethod = obj1.toString();
            }
            return errorResponse(i, modulemethod);

        case 28: // '\034'
            break;
        }
        if (obj == null)
        {
            modulemethod = obj3;
        } else
        {
            modulemethod = obj.toString();
        }
        return requestParameter(modulemethod, obj1);
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 17: // '\021'
        case 28: // '\034'
        case 29: // '\035'
        case 30: // '\036'
        default:
            return super.match0(modulemethod, callcontext);

        case 34: // '"'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 33: // '!'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 32: // ' '
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 31: // '\037'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 27: // '\033'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 26: // '\032'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 25: // '\031'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 24: // '\030'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 23: // '\027'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 22: // '\026'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 21: // '\025'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 20: // '\024'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 19: // '\023'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 18: // '\022'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 16: // '\020'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 15: // '\017'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 14: // '\016'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 13: // '\r'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 12: // '\f'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 11: // '\013'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 10: // '\n'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 9: // '\t'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 8: // '\b'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 7: // '\007'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 30: // '\036'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 28: // '\034'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 17: // '\021'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 5: // '\005'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 3: // '\003'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 2: // '\002'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match2(modulemethod, obj, obj1, callcontext);

        case 28: // '\034'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 5: // '\005'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 3: // '\003'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 1: // '\001'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit32 = (SimpleSymbol)(new SimpleSymbol("request-input-port")).readResolve();
        Lit31 = (SimpleSymbol)(new SimpleSymbol("request-input-stream")).readResolve();
        Lit30 = (SimpleSymbol)(new SimpleSymbol("request-body-string")).readResolve();
        Lit29 = (SimpleSymbol)(new SimpleSymbol("request-parameter-map")).readResolve();
        Lit28 = (SimpleSymbol)(new SimpleSymbol("request-parameters")).readResolve();
        Lit27 = (SimpleSymbol)(new SimpleSymbol("request-parameter")).readResolve();
        Lit26 = (SimpleSymbol)(new SimpleSymbol("request-query-string")).readResolve();
        Lit25 = (SimpleSymbol)(new SimpleSymbol("request-path-translated")).readResolve();
        Lit24 = (SimpleSymbol)(new SimpleSymbol("request-url")).readResolve();
        Lit23 = (SimpleSymbol)(new SimpleSymbol("request-uri")).readResolve();
        Lit22 = (SimpleSymbol)(new SimpleSymbol("request-path")).readResolve();
        Lit21 = (SimpleSymbol)(new SimpleSymbol("request-local-path")).readResolve();
        Lit20 = (SimpleSymbol)(new SimpleSymbol("request-script-path")).readResolve();
        Lit19 = (SimpleSymbol)(new SimpleSymbol("request-context-path")).readResolve();
        Lit18 = (SimpleSymbol)(new SimpleSymbol("request-URI")).readResolve();
        Lit17 = (SimpleSymbol)(new SimpleSymbol("request-header-map")).readResolve();
        Lit16 = (SimpleSymbol)(new SimpleSymbol("request-header")).readResolve();
        Lit15 = (SimpleSymbol)(new SimpleSymbol("request-remote-host")).readResolve();
        Lit14 = (SimpleSymbol)(new SimpleSymbol("request-remote-port")).readResolve();
        Lit13 = (SimpleSymbol)(new SimpleSymbol("request-remote-IP-address")).readResolve();
        Lit12 = (SimpleSymbol)(new SimpleSymbol("request-remote-socket-address")).readResolve();
        Lit11 = (SimpleSymbol)(new SimpleSymbol("request-local-host")).readResolve();
        Lit10 = (SimpleSymbol)(new SimpleSymbol("request-local-port")).readResolve();
        Lit9 = (SimpleSymbol)(new SimpleSymbol("request-local-IP-address")).readResolve();
        Lit8 = (SimpleSymbol)(new SimpleSymbol("request-local-socket-address")).readResolve();
        Lit7 = (SimpleSymbol)(new SimpleSymbol("request-scheme")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("request-method")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("error-response")).readResolve();
        Lit4 = (SimpleSymbol)(new SimpleSymbol("response-status")).readResolve();
        Lit3 = (SimpleSymbol)(new SimpleSymbol("response-content-type")).readResolve();
        Lit2 = (SimpleSymbol)(new SimpleSymbol("response-header")).readResolve();
        $instance = new HTTP();
        HTTP http = $instance;
        response$Mnheader = new ModuleMethod(http, 1, Lit2, 8194);
        response$Mncontent$Mntype = new ModuleMethod(http, 2, Lit3, 4097);
        response$Mnstatus = new ModuleMethod(http, 3, Lit4, 8193);
        error$Mnresponse = new ModuleMethod(http, 5, Lit5, 8193);
        request$Mnmethod = new ModuleMethod(http, 7, Lit6, 0);
        request$Mnscheme = new ModuleMethod(http, 8, Lit7, 0);
        request$Mnlocal$Mnsocket$Mnaddress = new ModuleMethod(http, 9, Lit8, 0);
        request$Mnlocal$MnIP$Mnaddress = new ModuleMethod(http, 10, Lit9, 0);
        request$Mnlocal$Mnport = new ModuleMethod(http, 11, Lit10, 0);
        request$Mnlocal$Mnhost = new ModuleMethod(http, 12, Lit11, 0);
        request$Mnremote$Mnsocket$Mnaddress = new ModuleMethod(http, 13, Lit12, 0);
        request$Mnremote$MnIP$Mnaddress = new ModuleMethod(http, 14, Lit13, 0);
        request$Mnremote$Mnport = new ModuleMethod(http, 15, Lit14, 0);
        request$Mnremote$Mnhost = new ModuleMethod(http, 16, Lit15, 0);
        request$Mnheader = new ModuleMethod(http, 17, Lit16, 4097);
        request$Mnheader$Mnmap = new ModuleMethod(http, 18, Lit17, 0);
        request$MnURI = new ModuleMethod(http, 19, Lit18, 0);
        request$Mncontext$Mnpath = new ModuleMethod(http, 20, Lit19, 0);
        request$Mnscript$Mnpath = new ModuleMethod(http, 21, Lit20, 0);
        request$Mnlocal$Mnpath = new ModuleMethod(http, 22, Lit21, 0);
        request$Mnpath = new ModuleMethod(http, 23, Lit22, 0);
        request$Mnuri = new ModuleMethod(http, 24, Lit23, 0);
        request$Mnurl = new ModuleMethod(http, 25, Lit24, 0);
        request$Mnpath$Mntranslated = new ModuleMethod(http, 26, Lit25, 0);
        request$Mnquery$Mnstring = new ModuleMethod(http, 27, Lit26, 0);
        request$Mnparameter = new ModuleMethod(http, 28, Lit27, 8193);
        request$Mnparameters = new ModuleMethod(http, 30, Lit28, 4097);
        request$Mnparameter$Mnmap = new ModuleMethod(http, 31, Lit29, 0);
        request$Mnbody$Mnstring = new ModuleMethod(http, 32, Lit30, 0);
        request$Mninput$Mnstream = new ModuleMethod(http, 33, Lit31, 0);
        request$Mninput$Mnport = new ModuleMethod(http, 34, Lit32, 0);
        $instance.run();
    }
}
