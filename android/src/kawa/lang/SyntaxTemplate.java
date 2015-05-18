// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.expr.Compilation;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.IdentityHashMap;
import java.util.Vector;

// Referenced classes of package kawa.lang:
//            Translator, PatternScope, SyntaxForm, SyntaxForms, 
//            TemplateScope

public class SyntaxTemplate
    implements Externalizable
{

    static final int BUILD_CONS = 1;
    static final int BUILD_DOTS = 5;
    static final int BUILD_LIST1 = 8;
    static final int BUILD_LITERAL = 4;
    static final int BUILD_MISC = 0;
    static final int BUILD_NIL = 16;
    static final int BUILD_SYNTAX = 24;
    static final int BUILD_VAR = 2;
    static final int BUILD_VAR_CAR = 3;
    static final int BUILD_VECTOR = 40;
    static final int BUILD_WIDE = 7;
    static final String dots3 = "...";
    Object literal_values[];
    int max_nesting;
    String patternNesting;
    String template_program;

    protected SyntaxTemplate()
    {
    }

    public SyntaxTemplate(Object obj, SyntaxForm syntaxform, Translator translator)
    {
        Object obj1;
        Vector vector;
        if (translator == null || translator.patternScope == null)
        {
            obj1 = "";
        } else
        {
            obj1 = translator.patternScope.patternNesting.toString();
        }
        patternNesting = ((String) (obj1));
        obj1 = new StringBuffer();
        vector = new Vector();
        convert_template(obj, syntaxform, ((StringBuffer) (obj1)), 0, vector, new IdentityHashMap(), false, translator);
        template_program = ((StringBuffer) (obj1)).toString();
        literal_values = new Object[vector.size()];
        vector.copyInto(literal_values);
    }

    public SyntaxTemplate(String s, String s1, Object aobj[], int i)
    {
        patternNesting = s;
        template_program = s1;
        literal_values = aobj;
        max_nesting = i;
    }

    private int get_count(Object obj, int i, int ai[])
    {
        for (int j = 0; j < i; j++)
        {
            obj = ((Object[])(Object[])obj)[ai[j]];
        }

        return ((Object[])(Object[])obj).length;
    }

    static int indexOf(Vector vector, Object obj)
    {
        int j = vector.size();
        for (int i = 0; i < j; i++)
        {
            if (vector.elementAt(i) == obj)
            {
                return i;
            }
        }

        return -1;
    }

    public int convert_template(Object obj, SyntaxForm syntaxform, StringBuffer stringbuffer, int i, Vector vector, Object obj1, boolean flag, 
            Translator translator)
    {
        for (; obj instanceof SyntaxForm; obj = syntaxform.getDatum())
        {
            syntaxform = (SyntaxForm)obj;
        }

        if (!(obj instanceof Pair) && !(obj instanceof FVector)) goto _L2; else goto _L1
_L1:
        Object obj2 = (IdentityHashMap)obj1;
        if (!((IdentityHashMap) (obj2)).containsKey(obj)) goto _L4; else goto _L3
_L3:
        translator.syntaxError("self-referential (cyclic) syntax template");
        i = -2;
_L10:
        return i;
_L4:
        ((IdentityHashMap) (obj2)).put(obj, obj);
_L2:
        Object obj3;
        int k;
        int k1;
        if (!(obj instanceof Pair))
        {
            break MISSING_BLOCK_LABEL_546;
        }
        obj2 = (Pair)obj;
        k = -2;
        k1 = stringbuffer.length();
        obj3 = ((Pair) (obj2)).getCar();
        if (!translator.matches(obj3, "...")) goto _L6; else goto _L5
_L5:
        Object obj4 = Translator.stripSyntax(((Pair) (obj2)).getCdr());
        if (!(obj4 instanceof Pair)) goto _L6; else goto _L7
_L7:
        obj4 = (Pair)obj4;
        if (((Pair) (obj4)).getCar() != "..." || ((Pair) (obj4)).getCdr() != LList.Empty) goto _L6; else goto _L8
_L8:
        syntaxform = "...";
_L11:
        int j = indexOf(vector, syntaxform);
        i = j;
        if (j < 0)
        {
            i = vector.size();
            vector.addElement(syntaxform);
        }
        if (syntaxform instanceof Symbol)
        {
            translator.noteAccess(syntaxform, translator.currentScope());
        }
        if (!(syntaxform instanceof SyntaxForm) && syntaxform != "...")
        {
            stringbuffer.append('\030');
        }
        stringbuffer.append((char)(i * 8 + 4));
        Pair pair;
        int l;
        int i1;
        int j1;
        int l1;
        int i2;
        if (syntaxform == "...")
        {
            i = -1;
        } else
        {
            i = -2;
        }
        return i;
_L6:
        l1 = vector.size();
        stringbuffer.append('\b');
        j = 0;
        obj2 = ((Pair) (obj2)).getCdr();
label0:
        do
        {
label1:
            {
                if (obj2 instanceof Pair)
                {
                    pair = (Pair)obj2;
                    if (translator.matches(pair.getCar(), "..."))
                    {
                        break label1;
                    }
                }
                i1 = convert_template(obj3, syntaxform, stringbuffer, i + j, vector, obj1, false, translator);
                if (obj2 != LList.Empty)
                {
                    stringbuffer.setCharAt(k1, (char)((stringbuffer.length() - k1 - 1 << 3) + 1));
                    k = convert_template(obj2, syntaxform, stringbuffer, i, vector, obj1, flag, translator);
                }
                if (j > 0)
                {
                    if (i1 < 0)
                    {
                        translator.syntaxError("... follows template with no suitably-nested pattern variable");
                    }
                    l = j;
                    do
                    {
                        j1 = l - 1;
                        if (j1 < 0)
                        {
                            break;
                        }
                        stringbuffer.setCharAt(k1 + j1 + 1, (char)((i1 << 3) + 5));
                        i2 = i + j;
                        l = j1;
                        if (i2 >= max_nesting)
                        {
                            max_nesting = i2;
                            l = j1;
                        }
                    } while (true);
                }
                break label0;
            }
            j++;
            obj2 = pair.getCdr();
            stringbuffer.append('\005');
        } while (true);
        i = i1;
        if (i1 >= 0) goto _L10; else goto _L9
_L9:
        if (k >= 0)
        {
            return k;
        }
        if (i1 == -1 || k == -1)
        {
            return -1;
        }
        if (flag)
        {
            return -2;
        }
        vector.setSize(l1);
        stringbuffer.setLength(k1);
        syntaxform = ((SyntaxForm) (obj));
          goto _L11
        if (obj instanceof FVector)
        {
            stringbuffer.append('(');
            return convert_template(LList.makeList((FVector)obj), syntaxform, stringbuffer, i, vector, obj1, true, translator);
        }
        if (obj == LList.Empty)
        {
            stringbuffer.append('\020');
            return -2;
        }
        syntaxform = ((SyntaxForm) (obj));
        if (obj instanceof Symbol)
        {
            syntaxform = ((SyntaxForm) (obj));
            if (translator != null)
            {
                syntaxform = ((SyntaxForm) (obj));
                if (translator.patternScope != null)
                {
                    k = indexOf(translator.patternScope.pattern_names, obj);
                    syntaxform = ((SyntaxForm) (obj));
                    if (k >= 0)
                    {
                        l = patternNesting.charAt(k);
                        if ((l & '\001') != 0)
                        {
                            j = 3;
                        } else
                        {
                            j = 2;
                        }
                        l >>= 1;
                        if (l > i)
                        {
                            translator.syntaxError((new StringBuilder()).append("inconsistent ... nesting of ").append(obj).toString());
                        }
                        stringbuffer.append((char)(k * 8 + j));
                        if (l == i)
                        {
                            i = k;
                        } else
                        {
                            i = -1;
                        }
                        return i;
                    }
                }
            }
        }
          goto _L11
    }

    Object execute(int i, Object aobj[], int j, int ai[], Translator translator, TemplateScope templatescope)
    {
        char c = template_program.charAt(i);
        int k = i;
        String s;
        for (i = c; (i & 7) == 7; i = i - 7 << 13 | s.charAt(k))
        {
            s = template_program;
            k++;
        }

        if (i == 8)
        {
            aobj = executeToList(k + 1, aobj, j, ai, translator, templatescope);
        } else
        {
            if (i == 16)
            {
                return LList.Empty;
            }
            if (i == 24)
            {
                ai = ((int []) (execute(k + 1, aobj, j, ai, translator, templatescope)));
                aobj = ai;
                if (ai != LList.Empty)
                {
                    return SyntaxForms.makeForm(ai, templatescope);
                }
            } else
            {
                if ((i & 7) == 1)
                {
                    Pair pair1 = null;
                    Object obj1 = null;
                    Object obj;
                    Pair pair;
                    int l;
                    char c1;
                    do
                    {
                        k++;
                        Object obj2 = executeToList(k, aobj, j, ai, translator, templatescope);
                        if (pair1 == null)
                        {
                            obj = obj2;
                            pair = pair1;
                        } else
                        {
                            pair1.setCdrBackdoor(obj2);
                            pair = pair1;
                            obj = obj1;
                        }
                        for (; obj2 instanceof Pair; obj2 = pair.getCdr())
                        {
                            pair = (Pair)obj2;
                        }

                        l = k + (i >> 3);
                        c1 = template_program.charAt(l);
                        i = c1;
                        pair1 = pair;
                        obj1 = obj;
                        k = l;
                    } while ((c1 & 7) == 1);
                    aobj = ((Object []) (execute(l, aobj, j, ai, translator, templatescope)));
                    if (pair != null)
                    {
                        pair.setCdrBackdoor(((Object) (aobj)));
                        aobj = ((Object []) (obj));
                    }
                    return ((Object) (aobj));
                }
                if (i == 40)
                {
                    return new FVector((LList)execute(k + 1, aobj, j, ai, translator, templatescope));
                }
                if ((i & 7) == 4)
                {
                    return literal_values[i >> 3];
                }
                if ((i & 6) == 2)
                {
                    ai = ((int []) (get_var(i >> 3, aobj, ai)));
                    aobj = ai;
                    if ((i & 7) == 3)
                    {
                        aobj = ((Object []) (((Pair)ai).getCar()));
                    }
                    return ((Object) (aobj));
                } else
                {
                    throw new Error((new StringBuilder()).append("unknown template code: ").append(i).append(" at ").append(k).toString());
                }
            }
        }
        return ((Object) (aobj));
    }

    public Object execute(Object aobj[], TemplateScope templatescope)
    {
        return execute(0, aobj, 0, new int[max_nesting], (Translator)Compilation.getCurrent(), templatescope);
    }

    public Object execute(Object aobj[], Translator translator, TemplateScope templatescope)
    {
        return execute(0, aobj, 0, new int[max_nesting], translator, templatescope);
    }

    LList executeToList(int i, Object aobj[], int j, int ai[], Translator translator, TemplateScope templatescope)
    {
        int k;
        int l;
        l = template_program.charAt(i);
        k = i;
        String s;
        for (; (l & 7) == 7; l = l - 7 << 13 | s.charAt(k))
        {
            s = template_program;
            k++;
        }

        if ((l & 7) != 3) goto _L2; else goto _L1
_L1:
        Object obj;
        aobj = (Pair)get_var(l >> 3, aobj, ai);
        obj = Translator.makePair(((Pair) (aobj)), ((Pair) (aobj)).getCar(), LList.Empty);
_L4:
        return ((LList) (obj));
_L2:
label0:
        {
            if ((l & 7) != 5)
            {
                break label0;
            }
            l = get_count(aobj[l >> 3], j, ai);
            LList llist = LList.Empty;
            Pair pair = null;
            i = 0;
            do
            {
                obj = llist;
                if (i >= l)
                {
                    break;
                }
                ai[j] = i;
                obj = executeToList(k + 1, aobj, j + 1, ai, translator, templatescope);
                if (pair == null)
                {
                    llist = ((LList) (obj));
                } else
                {
                    pair.setCdrBackdoor(obj);
                }
                for (; obj instanceof Pair; obj = (LList)pair.getCdr())
                {
                    pair = (Pair)obj;
                }

                i++;
            } while (true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        return new Pair(execute(i, aobj, j, ai, translator, templatescope), LList.Empty);
    }

    Object get_var(int i, Object aobj[], int ai[])
    {
        aobj = ((Object []) (aobj[i]));
        Object aobj1[] = aobj;
        if (i < patternNesting.length())
        {
            char c = patternNesting.charAt(i);
            i = 0;
            do
            {
                aobj1 = aobj;
                if (i >= c >> 1)
                {
                    break;
                }
                aobj = ((Object []) (((Object[])(Object[])aobj)[ai[i]]));
                i++;
            } while (true);
        }
        return ((Object) (aobj1));
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        patternNesting = (String)objectinput.readObject();
        template_program = (String)objectinput.readObject();
        literal_values = (Object[])(Object[])objectinput.readObject();
        max_nesting = objectinput.readInt();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(patternNesting);
        objectoutput.writeObject(template_program);
        objectoutput.writeObject(((Object) (literal_values)));
        objectoutput.writeInt(max_nesting);
    }
}
