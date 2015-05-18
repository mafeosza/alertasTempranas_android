// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.servlet;

import gnu.mapping.InPort;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

// Referenced classes of package gnu.kawa.servlet:
//            ServletPrinter

public abstract class HttpRequestContext
{

    public static final int HTTP_NOT_FOUND = 404;
    public static final int HTTP_OK = 200;
    static final int STATUS_SENT = -999;
    public static int importServletDefinitions;
    protected static final ThreadLocal instance = new ThreadLocal();
    ServletPrinter consumer;
    String localPath;
    String scriptPath;
    public int statusCode;
    public String statusReasonPhrase;

    public HttpRequestContext()
    {
        statusCode = 200;
        statusReasonPhrase = null;
        scriptPath = "";
        localPath = "";
    }

    public static HttpRequestContext getInstance()
    {
        HttpRequestContext httprequestcontext = (HttpRequestContext)instance.get();
        if (httprequestcontext == null)
        {
            throw new UnsupportedOperationException("can only be called by http-server");
        } else
        {
            return httprequestcontext;
        }
    }

    public static HttpRequestContext getInstance(String s)
    {
        HttpRequestContext httprequestcontext = (HttpRequestContext)instance.get();
        if (httprequestcontext == null)
        {
            throw new UnsupportedOperationException((new StringBuilder()).append(s).append(" can only be called within http-server").toString());
        } else
        {
            return httprequestcontext;
        }
    }

    public static void setInstance(HttpRequestContext httprequestcontext)
    {
        instance.set(httprequestcontext);
    }

    public abstract Object getAttribute(String s);

    public ServletPrinter getConsumer()
        throws IOException
    {
        if (consumer == null)
        {
            consumer = new ServletPrinter(this, 8192);
        }
        return consumer;
    }

    public abstract String getContextPath();

    public InetAddress getLocalHost()
    {
        InetAddress inetaddress;
        try
        {
            inetaddress = InetAddress.getLocalHost();
        }
        catch (Throwable throwable)
        {
            throw new RuntimeException(throwable);
        }
        return inetaddress;
    }

    public String getLocalIPAddress()
    {
        return getLocalHost().getHostAddress();
    }

    public String getLocalPath()
    {
        return localPath;
    }

    public abstract int getLocalPort();

    public InetSocketAddress getLocalSocketAddress()
    {
        return new InetSocketAddress(getLocalHost(), getLocalPort());
    }

    public abstract String getPathTranslated();

    public abstract String getQueryString();

    public abstract InetAddress getRemoteHost();

    public abstract String getRemoteIPAddress();

    public abstract int getRemotePort();

    public InetSocketAddress getRemoteSocketAddress()
    {
        return new InetSocketAddress(getRemoteHost(), getRemotePort());
    }

    public String getRequestBodyChars()
        throws IOException
    {
        InputStreamReader inputstreamreader = new InputStreamReader(getRequestStream());
        int k = 1024;
        char ac[] = new char[1024];
        int i = 0;
        do
        {
            int l = k - i;
            char ac1[] = ac;
            int j = k;
            if (l <= 0)
            {
                ac1 = new char[k * 2];
                System.arraycopy(ac, 0, ac1, 0, k);
                j = k + k;
            }
            k = inputstreamreader.read(ac1, i, l);
            if (k < 0)
            {
                inputstreamreader.close();
                return new String(ac1, 0, i);
            }
            i += k;
            ac = ac1;
            k = j;
        } while (true);
    }

    public abstract String getRequestHeader(String s);

    public abstract List getRequestHeaders(String s);

    public abstract Map getRequestHeaders();

    public abstract String getRequestMethod();

    public String getRequestParameter(String s)
    {
        s = (List)getRequestParameters().get(s);
        if (s == null || s.isEmpty())
        {
            return null;
        } else
        {
            return (String)s.get(0);
        }
    }

    public abstract Map getRequestParameters();

    public String getRequestPath()
    {
        return getRequestURI().getPath();
    }

    public InPort getRequestPort()
    {
        return new InPort(getRequestStream());
    }

    public String getRequestScheme()
    {
        return "http";
    }

    public abstract InputStream getRequestStream();

    public abstract URI getRequestURI();

    public StringBuffer getRequestURLBuffer()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(getRequestScheme());
        stringbuffer.append("://");
        String s = getRequestHeader("Host");
        if (s != null)
        {
            stringbuffer.append(s);
        } else
        {
            stringbuffer.append(getLocalIPAddress());
            stringbuffer.append(':');
            stringbuffer.append(getLocalPort());
        }
        stringbuffer.append(getRequestPath());
        return stringbuffer;
    }

    public abstract URL getResourceURL(String s);

    public abstract OutputStream getResponseStream();

    public String getScriptPath()
    {
        return scriptPath;
    }

    public abstract void log(String s);

    public abstract void log(String s, Throwable throwable);

    protected String normalizeToContext(String s)
    {
        String s1;
        if (s.length() > 0 && s.charAt(0) == '/')
        {
            s = s.substring(1);
        } else
        {
            s = (new StringBuilder()).append(getScriptPath()).append(s).toString();
        }
        s1 = s;
        if (s.indexOf("..") >= 0)
        {
            s = URI.create(s).normalize().toString();
            s1 = s;
            if (s.startsWith("../"))
            {
                return null;
            }
        }
        return s1;
    }

    public abstract boolean reset(boolean flag);

    public void sendNotFound(String s)
        throws IOException
    {
        s = (new StringBuilder()).append("The requested URL ").append(s).append(" was not found on this server.\r\n").toString().getBytes();
        sendResponseHeaders(404, null, s.length);
        OutputStream outputstream = getResponseStream();
        try
        {
            outputstream.write(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
    }

    public abstract void sendResponseHeaders(int i, String s, long l)
        throws IOException;

    public abstract void setAttribute(String s, Object obj);

    public void setContentType(String s)
    {
        setResponseHeader("Content-Type", s);
    }

    public abstract void setResponseHeader(String s, String s1);

    public void setScriptAndLocalPath(String s, String s1)
    {
        scriptPath = s;
        localPath = s1;
    }

}
