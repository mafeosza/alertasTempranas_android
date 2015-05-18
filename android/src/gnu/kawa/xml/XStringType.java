// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.xml.TextUtils;
import gnu.xml.XName;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package gnu.kawa.xml:
//            XDataType, XString

public class XStringType extends XDataType
{

    public static final XStringType ENTITYType;
    public static final XStringType IDREFType;
    public static final XStringType IDType;
    public static final XStringType NCNameType;
    public static final XStringType NMTOKENType;
    public static final XStringType NameType;
    static ClassType XStringType = ClassType.make("gnu.kawa.xml.XString");
    public static final XStringType languageType;
    public static final XStringType normalizedStringType;
    public static final XStringType tokenType;
    Pattern pattern;

    public XStringType(String s, XDataType xdatatype, int i, String s1)
    {
        super(s, XStringType, i);
        baseType = xdatatype;
        if (s1 != null)
        {
            pattern = Pattern.compile(s1);
        }
    }

    public static XString makeNCName(String s)
    {
        return (XString)NCNameType.valueOf(s);
    }

    public Object cast(Object obj)
    {
        if (obj instanceof XString)
        {
            XString xstring = (XString)obj;
            if (xstring.getStringType() == this)
            {
                return xstring;
            }
        }
        return valueOf((String)stringType.cast(obj));
    }

    public boolean isInstance(Object obj)
    {
        if (obj instanceof XString)
        {
            obj = ((XString)obj).getStringType();
            while (obj != null) 
            {
                if (obj == this)
                {
                    return true;
                }
                obj = ((XDataType) (obj)).baseType;
            }
        }
        return false;
    }

    public String matches(String s)
    {
        boolean flag;
        switch (typeCode)
        {
        case 41: // ')'
        default:
            if (pattern == null || pattern.matcher(s).matches())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            break;

        case 39: // '\''
        case 40: // '('
            break MISSING_BLOCK_LABEL_85;

        case 42: // '*'
            break MISSING_BLOCK_LABEL_136;

        case 43: // '+'
            break MISSING_BLOCK_LABEL_120;

        case 44: // ','
        case 45: // '-'
        case 46: // '.'
        case 47: // '/'
            break MISSING_BLOCK_LABEL_128;
        }
        if (flag)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append("not a valid XML ").append(getName()).toString();
        }
        if (typeCode != 39)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (s == TextUtils.replaceWhitespace(s, flag))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        break MISSING_BLOCK_LABEL_79;
        flag = XName.isName(s);
        break MISSING_BLOCK_LABEL_79;
        flag = XName.isNCName(s);
        break MISSING_BLOCK_LABEL_79;
        flag = XName.isNmToken(s);
        break MISSING_BLOCK_LABEL_79;
    }

    public Object valueOf(String s)
    {
        boolean flag;
        if (this != normalizedStringType)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s = TextUtils.replaceWhitespace(s, flag);
        if (matches(s) != null)
        {
            throw new ClassCastException((new StringBuilder()).append("cannot cast ").append(s).append(" to ").append(name).toString());
        } else
        {
            return new XString(s, this);
        }
    }

    static 
    {
        normalizedStringType = new XStringType("normalizedString", stringType, 39, null);
        tokenType = new XStringType("token", normalizedStringType, 40, null);
        languageType = new XStringType("language", tokenType, 41, "[a-zA-Z]{1,8}(-[a-zA-Z0-9]{1,8})*");
        NMTOKENType = new XStringType("NMTOKEN", tokenType, 42, "\\c+");
        NameType = new XStringType("Name", tokenType, 43, null);
        NCNameType = new XStringType("NCName", NameType, 44, null);
        IDType = new XStringType("ID", NCNameType, 45, null);
        IDREFType = new XStringType("IDREF", NCNameType, 46, null);
        ENTITYType = new XStringType("ENTITY", NCNameType, 47, null);
    }
}
