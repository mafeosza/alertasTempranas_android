// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.common;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlEntities
{

    private static final Pattern HTML_ENTITY_PATTERN = Pattern.compile("&(#?[0-9a-zA-Z]+);");
    private static final Map lookup;

    public HtmlEntities()
    {
    }

    public static String decodeHtmlText(String s)
    {
        StringBuilder stringbuilder;
        Matcher matcher;
        int i;
        if (s.length() == 0 || s.indexOf('&') == -1)
        {
            return s;
        }
        stringbuilder = new StringBuilder();
        i = 0;
        matcher = HTML_ENTITY_PATTERN.matcher(s);
_L5:
        if (!matcher.find()) goto _L2; else goto _L1
_L1:
        Character character;
        String s1;
        s1 = matcher.group(1);
        character = null;
        if (!s1.startsWith("#x")) goto _L4; else goto _L3
_L3:
        s1 = s1.substring(2);
        char c;
        System.out.println((new StringBuilder()).append("hex number is ").append(s1).toString());
        c = (char)Integer.parseInt(s1, 16);
        character = Character.valueOf(c);
_L6:
        if (character != null)
        {
            stringbuilder.append(s.substring(i, matcher.start()));
            stringbuilder.append(character);
            i = matcher.end();
        }
          goto _L5
_L4:
        if (!s1.startsWith("#"))
        {
            break MISSING_BLOCK_LABEL_187;
        }
        s1 = s1.substring(1);
        c = (char)Integer.parseInt(s1);
        character = Character.valueOf(c);
          goto _L6
        character = (Character)lookup.get(s1);
          goto _L6
_L2:
        if (i < s.length())
        {
            stringbuilder.append(s.substring(i));
        }
        return stringbuilder.toString();
        NumberFormatException numberformatexception;
        numberformatexception;
          goto _L6
        numberformatexception;
          goto _L6
    }

    public static Character toCharacter(String s)
    {
        return (Character)lookup.get(s);
    }

    static 
    {
        lookup = new HashMap();
        lookup.put("Agrave", Character.valueOf('\300'));
        lookup.put("agrave", Character.valueOf('\340'));
        lookup.put("Aacute", Character.valueOf('\301'));
        lookup.put("aacute", Character.valueOf('\341'));
        lookup.put("Acirc", Character.valueOf('\302'));
        lookup.put("acirc", Character.valueOf('\342'));
        lookup.put("Atilde", Character.valueOf('\303'));
        lookup.put("atilde", Character.valueOf('\343'));
        lookup.put("Auml", Character.valueOf('\304'));
        lookup.put("auml", Character.valueOf('\344'));
        lookup.put("Aring", Character.valueOf('\305'));
        lookup.put("aring", Character.valueOf('\345'));
        lookup.put("AElig", Character.valueOf('\306'));
        lookup.put("aelig", Character.valueOf('\346'));
        lookup.put("Ccedil", Character.valueOf('\307'));
        lookup.put("ccedil", Character.valueOf('\347'));
        lookup.put("Egrave", Character.valueOf('\310'));
        lookup.put("egrave", Character.valueOf('\350'));
        lookup.put("Eacute", Character.valueOf('\311'));
        lookup.put("eacute", Character.valueOf('\351'));
        lookup.put("Ecirc", Character.valueOf('\312'));
        lookup.put("ecirc", Character.valueOf('\352'));
        lookup.put("Euml", Character.valueOf('\313'));
        lookup.put("euml", Character.valueOf('\353'));
        lookup.put("Igrave", Character.valueOf('\314'));
        lookup.put("igrave", Character.valueOf('\354'));
        lookup.put("Iacute", Character.valueOf('\315'));
        lookup.put("iacute", Character.valueOf('\355'));
        lookup.put("Icirc", Character.valueOf('\316'));
        lookup.put("icirc", Character.valueOf('\356'));
        lookup.put("Iuml", Character.valueOf('\317'));
        lookup.put("iuml", Character.valueOf('\357'));
        lookup.put("ETH", Character.valueOf('\320'));
        lookup.put("eth", Character.valueOf('\360'));
        lookup.put("Ntilde", Character.valueOf('\321'));
        lookup.put("ntilde", Character.valueOf('\361'));
        lookup.put("Ograve", Character.valueOf('\322'));
        lookup.put("ograve", Character.valueOf('\362'));
        lookup.put("Oacute", Character.valueOf('\323'));
        lookup.put("oacute", Character.valueOf('\363'));
        lookup.put("Ocirc", Character.valueOf('\324'));
        lookup.put("ocirc", Character.valueOf('\364'));
        lookup.put("Otilde", Character.valueOf('\325'));
        lookup.put("otilde", Character.valueOf('\365'));
        lookup.put("Ouml", Character.valueOf('\326'));
        lookup.put("ouml", Character.valueOf('\366'));
        lookup.put("Oslash", Character.valueOf('\330'));
        lookup.put("oslash", Character.valueOf('\370'));
        lookup.put("Ugrave", Character.valueOf('\331'));
        lookup.put("ugrave", Character.valueOf('\371'));
        lookup.put("Uacute", Character.valueOf('\332'));
        lookup.put("uacute", Character.valueOf('\372'));
        lookup.put("Ucirc", Character.valueOf('\333'));
        lookup.put("ucirc", Character.valueOf('\373'));
        lookup.put("Uuml", Character.valueOf('\334'));
        lookup.put("uuml", Character.valueOf('\374'));
        lookup.put("Yacute", Character.valueOf('\335'));
        lookup.put("yacute", Character.valueOf('\375'));
        lookup.put("THORN", Character.valueOf('\336'));
        lookup.put("thorn", Character.valueOf('\376'));
        lookup.put("szlig", Character.valueOf('\337'));
        lookup.put("yuml", Character.valueOf('\377'));
        lookup.put("Yuml", Character.valueOf('\u0178'));
        lookup.put("OElig", Character.valueOf('\u0152'));
        lookup.put("oelig", Character.valueOf('\u0153'));
        lookup.put("Scaron", Character.valueOf('\u0160'));
        lookup.put("scaron", Character.valueOf('\u0161'));
        lookup.put("Alpha", Character.valueOf('\u0391'));
        lookup.put("Beta", Character.valueOf('\u0392'));
        lookup.put("Gamma", Character.valueOf('\u0393'));
        lookup.put("Delta", Character.valueOf('\u0394'));
        lookup.put("Epsilon", Character.valueOf('\u0395'));
        lookup.put("Zeta", Character.valueOf('\u0396'));
        lookup.put("Eta", Character.valueOf('\u0397'));
        lookup.put("Theta", Character.valueOf('\u0398'));
        lookup.put("Iota", Character.valueOf('\u0399'));
        lookup.put("Kappa", Character.valueOf('\u039A'));
        lookup.put("Lambda", Character.valueOf('\u039B'));
        lookup.put("Mu", Character.valueOf('\u039C'));
        lookup.put("Nu", Character.valueOf('\u039D'));
        lookup.put("Xi", Character.valueOf('\u039E'));
        lookup.put("Omicron", Character.valueOf('\u039F'));
        lookup.put("Pi", Character.valueOf('\u03A0'));
        lookup.put("Rho", Character.valueOf('\u03A1'));
        lookup.put("Sigma", Character.valueOf('\u03A3'));
        lookup.put("Tau", Character.valueOf('\u03A4'));
        lookup.put("Upsilon", Character.valueOf('\u03A5'));
        lookup.put("Phi", Character.valueOf('\u03A6'));
        lookup.put("Chi", Character.valueOf('\u03A7'));
        lookup.put("Psi", Character.valueOf('\u03A8'));
        lookup.put("Omega", Character.valueOf('\u03A9'));
        lookup.put("alpha", Character.valueOf('\u03B1'));
        lookup.put("beta", Character.valueOf('\u03B2'));
        lookup.put("gamma", Character.valueOf('\u03B3'));
        lookup.put("delta", Character.valueOf('\u03B4'));
        lookup.put("epsilon", Character.valueOf('\u03B5'));
        lookup.put("zeta", Character.valueOf('\u03B6'));
        lookup.put("eta", Character.valueOf('\u03B7'));
        lookup.put("theta", Character.valueOf('\u03B8'));
        lookup.put("iota", Character.valueOf('\u03B9'));
        lookup.put("kappa", Character.valueOf('\u03BA'));
        lookup.put("lambda", Character.valueOf('\u03BB'));
        lookup.put("mu", Character.valueOf('\u03BC'));
        lookup.put("nu", Character.valueOf('\u03BD'));
        lookup.put("xi", Character.valueOf('\u03BE'));
        lookup.put("omicron", Character.valueOf('\u03BF'));
        lookup.put("pi", Character.valueOf('\u03C0'));
        lookup.put("rho", Character.valueOf('\u03C1'));
        lookup.put("sigmaf", Character.valueOf('\u03C2'));
        lookup.put("sigma", Character.valueOf('\u03C3'));
        lookup.put("tau", Character.valueOf('\u03C4'));
        lookup.put("upsilon", Character.valueOf('\u03C5'));
        lookup.put("phi", Character.valueOf('\u03C6'));
        lookup.put("chi", Character.valueOf('\u03C7'));
        lookup.put("psi", Character.valueOf('\u03C8'));
        lookup.put("omega", Character.valueOf('\u03C9'));
        lookup.put("thetasym", Character.valueOf('\u03D1'));
        lookup.put("upsih", Character.valueOf('\u03D2'));
        lookup.put("piv", Character.valueOf('\u03D6'));
        lookup.put("iexcl", Character.valueOf('\241'));
        lookup.put("cent", Character.valueOf('\242'));
        lookup.put("pound", Character.valueOf('\243'));
        lookup.put("curren", Character.valueOf('\244'));
        lookup.put("yen", Character.valueOf('\245'));
        lookup.put("brvbar", Character.valueOf('\246'));
        lookup.put("sect", Character.valueOf('\247'));
        lookup.put("uml", Character.valueOf('\250'));
        lookup.put("copy", Character.valueOf('\251'));
        lookup.put("ordf", Character.valueOf('\252'));
        lookup.put("laquo", Character.valueOf('\253'));
        lookup.put("not", Character.valueOf('\254'));
        lookup.put("shy", Character.valueOf('\255'));
        lookup.put("reg", Character.valueOf('\256'));
        lookup.put("macr", Character.valueOf('\257'));
        lookup.put("deg", Character.valueOf('\260'));
        lookup.put("plusmn", Character.valueOf('\261'));
        lookup.put("sup2", Character.valueOf('\262'));
        lookup.put("sup3", Character.valueOf('\263'));
        lookup.put("acute", Character.valueOf('\264'));
        lookup.put("micro", Character.valueOf('\265'));
        lookup.put("para", Character.valueOf('\266'));
        lookup.put("middot", Character.valueOf('\267'));
        lookup.put("cedil", Character.valueOf('\270'));
        lookup.put("sup1", Character.valueOf('\271'));
        lookup.put("ordm", Character.valueOf('\272'));
        lookup.put("raquo", Character.valueOf('\273'));
        lookup.put("frac14", Character.valueOf('\274'));
        lookup.put("frac12", Character.valueOf('\275'));
        lookup.put("frac34", Character.valueOf('\276'));
        lookup.put("iquest", Character.valueOf('\277'));
        lookup.put("times", Character.valueOf('\327'));
        lookup.put("divide", Character.valueOf('\367'));
        lookup.put("fnof", Character.valueOf('\u0192'));
        lookup.put("circ", Character.valueOf('\u02C6'));
        lookup.put("tilde", Character.valueOf('\u02DC'));
        lookup.put("lrm", Character.valueOf('\u200E'));
        lookup.put("rlm", Character.valueOf('\u200F'));
        lookup.put("ndash", Character.valueOf('\u2013'));
        lookup.put("endash", Character.valueOf('\u2013'));
        lookup.put("mdash", Character.valueOf('\u2014'));
        lookup.put("emdash", Character.valueOf('\u2014'));
        lookup.put("lsquo", Character.valueOf('\u2018'));
        lookup.put("rsquo", Character.valueOf('\u2019'));
        lookup.put("sbquo", Character.valueOf('\u201A'));
        lookup.put("ldquo", Character.valueOf('\u201C'));
        lookup.put("rdquo", Character.valueOf('\u201D'));
        lookup.put("bdquo", Character.valueOf('\u201E'));
        lookup.put("dagger", Character.valueOf('\u2020'));
        lookup.put("Dagger", Character.valueOf('\u2021'));
        lookup.put("bull", Character.valueOf('\u2022'));
        lookup.put("hellip", Character.valueOf('\u2026'));
        lookup.put("permil", Character.valueOf('\u2030'));
        lookup.put("prime", Character.valueOf('\u2032'));
        lookup.put("Prime", Character.valueOf('\u2033'));
        lookup.put("lsaquo", Character.valueOf('\u2039'));
        lookup.put("rsaquo", Character.valueOf('\u203A'));
        lookup.put("oline", Character.valueOf('\u203E'));
        lookup.put("frasl", Character.valueOf('\u2044'));
        lookup.put("euro", Character.valueOf('\u20AC'));
        lookup.put("image", Character.valueOf('\u2111'));
        lookup.put("weierp", Character.valueOf('\u2118'));
        lookup.put("real", Character.valueOf('\u211C'));
        lookup.put("trade", Character.valueOf('\u2122'));
        lookup.put("alefsym", Character.valueOf('\u2135'));
        lookup.put("larr", Character.valueOf('\u2190'));
        lookup.put("uarr", Character.valueOf('\u2191'));
        lookup.put("rarr", Character.valueOf('\u2192'));
        lookup.put("darr", Character.valueOf('\u2193'));
        lookup.put("harr", Character.valueOf('\u2194'));
        lookup.put("crarr", Character.valueOf('\u21B5'));
        lookup.put("lArr", Character.valueOf('\u21D0'));
        lookup.put("uArr", Character.valueOf('\u21D1'));
        lookup.put("rArr", Character.valueOf('\u21D2'));
        lookup.put("dArr", Character.valueOf('\u21D3'));
        lookup.put("hArr", Character.valueOf('\u21D4'));
        lookup.put("forall", Character.valueOf('\u2200'));
        lookup.put("part", Character.valueOf('\u2202'));
        lookup.put("exist", Character.valueOf('\u2203'));
        lookup.put("empty", Character.valueOf('\u2205'));
        lookup.put("nabla", Character.valueOf('\u2207'));
        lookup.put("isin", Character.valueOf('\u2208'));
        lookup.put("notin", Character.valueOf('\u2209'));
        lookup.put("ni", Character.valueOf('\u220B'));
        lookup.put("prod", Character.valueOf('\u220F'));
        lookup.put("sum", Character.valueOf('\u2211'));
        lookup.put("minus", Character.valueOf('\u2212'));
        lookup.put("lowast", Character.valueOf('\u2217'));
        lookup.put("radic", Character.valueOf('\u221A'));
        lookup.put("prop", Character.valueOf('\u221D'));
        lookup.put("infin", Character.valueOf('\u221E'));
        lookup.put("ang", Character.valueOf('\u2220'));
        lookup.put("and", Character.valueOf('\u2227'));
        lookup.put("or", Character.valueOf('\u2228'));
        lookup.put("cap", Character.valueOf('\u2229'));
        lookup.put("cup", Character.valueOf('\u222A'));
        lookup.put("int", Character.valueOf('\u222B'));
        lookup.put("there4", Character.valueOf('\u2234'));
        lookup.put("sim", Character.valueOf('\u223C'));
        lookup.put("cong", Character.valueOf('\u2245'));
        lookup.put("asymp", Character.valueOf('\u2248'));
        lookup.put("ne", Character.valueOf('\u2260'));
        lookup.put("equiv", Character.valueOf('\u2261'));
        lookup.put("le", Character.valueOf('\u2264'));
        lookup.put("ge", Character.valueOf('\u2265'));
        lookup.put("sub", Character.valueOf('\u2282'));
        lookup.put("sup", Character.valueOf('\u2283'));
        lookup.put("nsub", Character.valueOf('\u2284'));
        lookup.put("sube", Character.valueOf('\u2286'));
        lookup.put("supe", Character.valueOf('\u2287'));
        lookup.put("oplus", Character.valueOf('\u2295'));
        lookup.put("otimes", Character.valueOf('\u2297'));
        lookup.put("perp", Character.valueOf('\u22A5'));
        lookup.put("sdot", Character.valueOf('\u22C5'));
        lookup.put("lceil", Character.valueOf('\u2308'));
        lookup.put("rceil", Character.valueOf('\u2309'));
        lookup.put("lfloor", Character.valueOf('\u230A'));
        lookup.put("rfloor", Character.valueOf('\u230B'));
        lookup.put("lang", Character.valueOf('\u2329'));
        lookup.put("rang", Character.valueOf('\u232A'));
        lookup.put("loz", Character.valueOf('\u25CA'));
        lookup.put("spades", Character.valueOf('\u2660'));
        lookup.put("clubs", Character.valueOf('\u2663'));
        lookup.put("hearts", Character.valueOf('\u2665'));
        lookup.put("diams", Character.valueOf('\u2666'));
        lookup.put("gt", Character.valueOf('>'));
        lookup.put("GT", Character.valueOf('>'));
        lookup.put("lt", Character.valueOf('<'));
        lookup.put("LT", Character.valueOf('<'));
        lookup.put("quot", Character.valueOf('"'));
        lookup.put("QUOT", Character.valueOf('"'));
        lookup.put("amp", Character.valueOf('&'));
        lookup.put("AMP", Character.valueOf('&'));
        lookup.put("apos", Character.valueOf('\''));
        lookup.put("nbsp", Character.valueOf('\240'));
        lookup.put("ensp", Character.valueOf('\u2002'));
        lookup.put("emsp", Character.valueOf('\u2003'));
        lookup.put("thinsp", Character.valueOf('\u2009'));
        lookup.put("zwnj", Character.valueOf('\u200C'));
        lookup.put("zwj", Character.valueOf('\u200D'));
    }
}
