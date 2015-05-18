// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json;

import java.util.HashMap;

// Referenced classes of package org.json:
//            JSONTokener, XML, JSONException

public class XMLTokener extends JSONTokener
{

    public static final HashMap entity;

    public XMLTokener(String s)
    {
        super(s);
    }

    public String nextCDATA()
        throws JSONException
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i;
        do
        {
            char c = next();
            if (end())
            {
                throw syntaxError("Unclosed CDATA");
            }
            stringbuffer.append(c);
            i = stringbuffer.length() - 3;
        } while (i < 0 || stringbuffer.charAt(i) != ']' || stringbuffer.charAt(i + 1) != ']' || stringbuffer.charAt(i + 2) != '>');
        stringbuffer.setLength(i);
        return stringbuffer.toString();
    }

    public Object nextContent()
        throws JSONException
    {
        char c;
        do
        {
            c = next();
        } while (Character.isWhitespace(c));
        if (c == 0)
        {
            return null;
        }
        if (c == '<')
        {
            return XML.LT;
        }
        StringBuffer stringbuffer = new StringBuffer();
        do
        {
            if (c == '<' || c == 0)
            {
                back();
                return stringbuffer.toString().trim();
            }
            if (c == '&')
            {
                stringbuffer.append(nextEntity(c));
            } else
            {
                stringbuffer.append(c);
            }
            c = next();
        } while (true);
    }

    public Object nextEntity(char c)
        throws JSONException
    {
        Object obj = new StringBuffer();
        char c1;
        do
        {
            c1 = next();
            if (!Character.isLetterOrDigit(c1) && c1 != '#')
            {
                break;
            }
            ((StringBuffer) (obj)).append(Character.toLowerCase(c1));
        } while (true);
        if (c1 == ';')
        {
            obj = ((StringBuffer) (obj)).toString();
            Object obj1 = entity.get(obj);
            if (obj1 != null)
            {
                return obj1;
            } else
            {
                return "" + c + obj + ";";
            }
        } else
        {
            throw syntaxError("Missing ';' in XML entity: &" + obj);
        }
    }

    public Object nextMeta()
        throws JSONException
    {
        char c;
        do
        {
            c = next();
        } while (Character.isWhitespace(c));
        c;
        JVM INSTR lookupswitch 9: default 96
    //                   0: 112
    //                   33: 135
    //                   34: 143
    //                   39: 143
    //                   47: 127
    //                   60: 119
    //                   61: 131
    //                   62: 123
    //                   63: 139;
           goto _L1 _L2 _L3 _L4 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        c = next();
        if (Character.isWhitespace(c))
        {
            return Boolean.TRUE;
        }
        break; /* Loop/switch isn't completed */
_L2:
        throw syntaxError("Misshaped meta tag");
_L6:
        return XML.LT;
_L8:
        return XML.GT;
_L5:
        return XML.SLASH;
_L7:
        return XML.EQ;
_L3:
        return XML.BANG;
_L9:
        return XML.QUEST;
_L4:
        char c1;
        do
        {
            c1 = next();
            if (c1 == 0)
            {
                throw syntaxError("Unterminated string");
            }
        } while (c1 != c);
        return Boolean.TRUE;
        switch (c)
        {
        case 0: // '\0'
        case 33: // '!'
        case 34: // '"'
        case 39: // '\''
        case 47: // '/'
        case 60: // '<'
        case 61: // '='
        case 62: // '>'
        case 63: // '?'
            back();
            return Boolean.TRUE;
        }
        if (true) goto _L1; else goto _L10
_L10:
    }

    public Object nextToken()
        throws JSONException
    {
        char c;
        do
        {
            c = next();
        } while (Character.isWhitespace(c));
        switch (c)
        {
        default:
            StringBuffer stringbuffer = new StringBuffer();
            do
            {
                stringbuffer.append(c);
                c = next();
                char c1;
                if (Character.isWhitespace(c))
                {
                    return stringbuffer.toString();
                }
                switch (c)
                {
                case 0: // '\0'
                    return stringbuffer.toString();

                case 33: // '!'
                case 47: // '/'
                case 61: // '='
                case 62: // '>'
                case 63: // '?'
                case 91: // '['
                case 93: // ']'
                    back();
                    return stringbuffer.toString();

                case 34: // '"'
                case 39: // '\''
                case 60: // '<'
                    throw syntaxError("Bad character in a name");
                }
            } while (true);

        case 0: // '\0'
            throw syntaxError("Misshaped element");

        case 60: // '<'
            throw syntaxError("Misplaced '<'");

        case 62: // '>'
            return XML.GT;

        case 47: // '/'
            return XML.SLASH;

        case 61: // '='
            return XML.EQ;

        case 33: // '!'
            return XML.BANG;

        case 63: // '?'
            return XML.QUEST;

        case 34: // '"'
        case 39: // '\''
            stringbuffer = new StringBuffer();
            do
            {
                c1 = next();
                if (c1 == 0)
                {
                    throw syntaxError("Unterminated string");
                }
                if (c1 == c)
                {
                    return stringbuffer.toString();
                }
                if (c1 == '&')
                {
                    stringbuffer.append(nextEntity(c1));
                } else
                {
                    stringbuffer.append(c1);
                }
            } while (true);
        }
    }

    public boolean skipPast(String s)
        throws JSONException
    {
        char c1;
        char ac[];
        int i;
        int k1;
        boolean flag = false;
        k1 = s.length();
        ac = new char[k1];
        int j = 0;
        do
        {
            i = ((flag) ? 1 : 0);
            if (j >= k1)
            {
                break;
            }
            char c = next();
            if (c == 0)
            {
                return false;
            }
            ac[j] = c;
            j++;
        } while (true);
_L3:
        int l = i;
        boolean flag2 = true;
        int i1 = 0;
label0:
        do
        {
label1:
            {
                boolean flag1 = flag2;
                if (i1 < k1)
                {
                    if (ac[l] == s.charAt(i1))
                    {
                        break label1;
                    }
                    flag1 = false;
                }
                if (flag1)
                {
                    return true;
                }
                break label0;
            }
            int j1 = l + 1;
            l = j1;
            if (j1 >= k1)
            {
                l = j1 - k1;
            }
            i1++;
        } while (true);
        c1 = next();
        if (c1 == 0)
        {
            return false;
        }
        if (true) goto _L2; else goto _L1
_L2:
        ac[i] = c1;
        int k = i + 1;
        i = k;
        if (k >= k1)
        {
            i = k - k1;
        }
        if (true) goto _L3; else goto _L1
_L1:
    }

    static 
    {
        entity = new HashMap(8);
        entity.put("amp", XML.AMP);
        entity.put("apos", XML.APOS);
        entity.put("gt", XML.GT);
        entity.put("lt", XML.LT);
        entity.put("quot", XML.QUOT);
    }
}
