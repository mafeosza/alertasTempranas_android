// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.PrintStream;
import java.io.PrintWriter;

// Referenced classes of package gnu.text:
//            SourceLocator, SourceError

public class SourceMessages
    implements SourceLocator
{

    public static boolean debugStackTraceOnError = false;
    public static boolean debugStackTraceOnWarning = false;
    int current_column;
    String current_filename;
    int current_line;
    private int errorCount;
    SourceError firstError;
    SourceError lastError;
    SourceError lastPrevFilename;
    SourceLocator locator;
    public boolean sortMessages;

    public SourceMessages()
    {
        errorCount = 0;
        lastPrevFilename = null;
    }

    public boolean checkErrors(PrintStream printstream, int i)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (firstError != null)
        {
            printAll(printstream, i);
            lastError = null;
            firstError = null;
            i = errorCount;
            errorCount = 0;
            flag = flag1;
            if (i > 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean checkErrors(PrintWriter printwriter, int i)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (firstError != null)
        {
            printAll(printwriter, i);
            lastError = null;
            firstError = null;
            i = errorCount;
            errorCount = 0;
            flag = flag1;
            if (i > 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public void clear()
    {
        lastError = null;
        firstError = null;
        errorCount = 0;
    }

    public void clearErrors()
    {
        errorCount = 0;
    }

    public void error(char c, SourceLocator sourcelocator, String s)
    {
        error(new SourceError(c, sourcelocator, s));
    }

    public void error(char c, SourceLocator sourcelocator, String s, String s1)
    {
        sourcelocator = new SourceError(c, sourcelocator, s);
        sourcelocator.code = s1;
        error(((SourceError) (sourcelocator)));
    }

    public void error(char c, String s)
    {
        error(new SourceError(c, current_filename, current_line, current_column, s));
    }

    public void error(char c, String s, int i, int j, String s1)
    {
        error(new SourceError(c, s, i, j, s1));
    }

    public void error(char c, String s, int i, int j, String s1, String s2)
    {
        s = new SourceError(c, s, i, j, s1);
        s.code = s2;
        error(((SourceError) (s)));
    }

    public void error(char c, String s, String s1)
    {
        s = new SourceError(c, current_filename, current_line, current_column, s);
        s.code = s1;
        error(((SourceError) (s)));
    }

    public void error(char c, String s, Throwable throwable)
    {
        s = new SourceError(c, current_filename, current_line, current_column, s);
        s.fakeException = throwable;
        error(((SourceError) (s)));
    }

    public void error(SourceError sourceerror)
    {
        SourceError sourceerror1;
        SourceError sourceerror3;
        if (sourceerror.severity == 'f')
        {
            errorCount = 1000;
        } else
        if (sourceerror.severity != 'w')
        {
            errorCount = errorCount + 1;
        }
        if (debugStackTraceOnError && (sourceerror.severity == 'e' || sourceerror.severity == 'f') || debugStackTraceOnWarning && sourceerror.severity == 'w')
        {
            sourceerror.fakeException = new Throwable();
        }
        if (lastError != null && lastError.filename != null && !lastError.filename.equals(sourceerror.filename))
        {
            lastPrevFilename = lastError;
        }
        sourceerror1 = lastPrevFilename;
        if (sortMessages && sourceerror.severity != 'f') goto _L2; else goto _L1
_L1:
        sourceerror3 = lastError;
_L4:
        SourceError sourceerror2;
        if (sourceerror3 == null)
        {
            sourceerror.next = firstError;
            firstError = sourceerror;
        } else
        {
            sourceerror.next = sourceerror3.next;
            sourceerror3.next = sourceerror;
        }
        if (sourceerror3 == lastError)
        {
            lastError = sourceerror;
        }
        return;
_L6:
        sourceerror1 = sourceerror2;
_L2:
        if (sourceerror1 == null)
        {
            sourceerror2 = firstError;
        } else
        {
            sourceerror2 = sourceerror1.next;
        }
        sourceerror3 = sourceerror1;
        if (sourceerror2 == null) goto _L4; else goto _L3
_L3:
        if (sourceerror.line == 0 || sourceerror2.line == 0) goto _L6; else goto _L5
_L5:
        sourceerror3 = sourceerror1;
        if (sourceerror.line < sourceerror2.line) goto _L4; else goto _L7
_L7:
        if (sourceerror.line != sourceerror2.line || sourceerror.column == 0 || sourceerror2.column == 0 || sourceerror.column >= sourceerror2.column) goto _L6; else goto _L8
_L8:
        sourceerror3 = sourceerror1;
          goto _L4
    }

    public final int getColumnNumber()
    {
        if (locator == null)
        {
            return current_column;
        } else
        {
            return locator.getColumnNumber();
        }
    }

    public int getErrorCount()
    {
        return errorCount;
    }

    public SourceError getErrors()
    {
        return firstError;
    }

    public final String getFileName()
    {
        return current_filename;
    }

    public final int getLineNumber()
    {
        if (locator == null)
        {
            return current_line;
        } else
        {
            return locator.getLineNumber();
        }
    }

    public String getPublicId()
    {
        if (locator == null)
        {
            return null;
        } else
        {
            return locator.getPublicId();
        }
    }

    public String getSystemId()
    {
        if (locator == null)
        {
            return current_filename;
        } else
        {
            return locator.getSystemId();
        }
    }

    public boolean isStableSourceLocation()
    {
        return false;
    }

    public void printAll(PrintStream printstream, int i)
    {
        SourceError sourceerror = firstError;
        do
        {
            if (sourceerror == null)
            {
                break;
            }
            i--;
            if (i < 0)
            {
                break;
            }
            sourceerror.println(printstream);
            sourceerror = sourceerror.next;
        } while (true);
    }

    public void printAll(PrintWriter printwriter, int i)
    {
        SourceError sourceerror = firstError;
        do
        {
            if (sourceerror == null)
            {
                break;
            }
            i--;
            if (i < 0)
            {
                break;
            }
            sourceerror.println(printwriter);
            sourceerror = sourceerror.next;
        } while (true);
    }

    public boolean seenErrors()
    {
        return errorCount > 0;
    }

    public boolean seenErrorsOrWarnings()
    {
        return firstError != null;
    }

    public void setColumn(int i)
    {
        current_column = i;
    }

    public void setFile(String s)
    {
        current_filename = s;
    }

    public void setLine(int i)
    {
        current_line = i;
    }

    public void setLine(String s, int i, int j)
    {
        current_filename = s;
        current_line = i;
        current_column = j;
    }

    public final void setLocation(SourceLocator sourcelocator)
    {
        locator = null;
        current_line = sourcelocator.getLineNumber();
        current_column = sourcelocator.getColumnNumber();
        current_filename = sourcelocator.getFileName();
    }

    public final void setSourceLocator(SourceLocator sourcelocator)
    {
        SourceLocator sourcelocator1 = sourcelocator;
        if (sourcelocator == this)
        {
            sourcelocator1 = null;
        }
        locator = sourcelocator1;
    }

    public final SourceLocator swapSourceLocator(SourceLocator sourcelocator)
    {
        SourceLocator sourcelocator1 = locator;
        locator = sourcelocator;
        return sourcelocator1;
    }

    public String toString(int i)
    {
        if (firstError == null)
        {
            return null;
        }
        StringBuffer stringbuffer = new StringBuffer();
        SourceError sourceerror = firstError;
        do
        {
            if (sourceerror == null)
            {
                break;
            }
            i--;
            if (i < 0)
            {
                break;
            }
            stringbuffer.append(sourceerror);
            stringbuffer.append('\n');
            sourceerror = sourceerror.next;
        } while (true);
        return stringbuffer.toString();
    }

}
