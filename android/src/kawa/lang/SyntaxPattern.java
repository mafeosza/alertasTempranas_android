// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.lists.Consumer;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.OutPort;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.PrintWriter;
import java.util.Vector;

// Referenced classes of package kawa.lang:
//            Pattern, Translator, PatternScope, SyntaxForm, 
//            Macro, SyntaxForms, SyntaxTemplate

public class SyntaxPattern extends Pattern
    implements Externalizable
{

    static final int MATCH_ANY = 3;
    static final int MATCH_ANY_CAR = 7;
    static final int MATCH_EQUALS = 2;
    static final int MATCH_IGNORE = 24;
    static final int MATCH_LENGTH = 6;
    static final int MATCH_LREPEAT = 5;
    static final int MATCH_MISC = 0;
    static final int MATCH_NIL = 8;
    static final int MATCH_PAIR = 4;
    static final int MATCH_VECTOR = 16;
    static final int MATCH_WIDE = 1;
    Object literals[];
    String program;
    int varCount;

    public SyntaxPattern(Object obj, Object aobj[], Translator translator)
    {
        this(new StringBuffer(), obj, null, aobj, translator);
    }

    public SyntaxPattern(String s, Object aobj[], int i)
    {
        program = s;
        literals = aobj;
        varCount = i;
    }

    SyntaxPattern(StringBuffer stringbuffer, Object obj, SyntaxForm syntaxform, Object aobj[], Translator translator)
    {
        syntaxform = new Vector();
        translate(obj, stringbuffer, aobj, 0, syntaxform, null, '\0', translator);
        program = stringbuffer.toString();
        literals = new Object[syntaxform.size()];
        syntaxform.copyInto(literals);
        varCount = translator.patternScope.pattern_names.size();
    }

    private static void addInt(StringBuffer stringbuffer, int i)
    {
        if (i > 65535)
        {
            addInt(stringbuffer, (i << 13) + 1);
        }
        stringbuffer.append((char)i);
    }

    public static Object[] allocVars(int i, Object aobj[])
    {
        Object aobj1[] = new Object[i];
        if (aobj != null)
        {
            System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj1)), 0, aobj.length);
        }
        return aobj1;
    }

    public static Object[] getLiteralsList(Object obj, SyntaxForm syntaxform, Translator translator)
    {
        Object obj1 = translator.pushPositionOf(obj);
        int j = Translator.listLength(obj);
        int i = j;
        if (j < 0)
        {
            translator.error('e', "missing or malformed literals list");
            i = 0;
        }
        Object aobj[] = new Object[i + 1];
        for (int k = 1; k <= i; k++)
        {
            for (; obj instanceof SyntaxForm; obj = ((SyntaxForm)obj).getDatum()) { }
            Pair pair = (Pair)obj;
            translator.pushPositionOf(pair);
            syntaxform = ((SyntaxForm) (pair.getCar()));
            obj = syntaxform;
            if (obj instanceof SyntaxForm)
            {
                obj = ((SyntaxForm)obj).getDatum();
            }
            if (!(obj instanceof Symbol))
            {
                translator.error('e', (new StringBuilder()).append("non-symbol '").append(obj).append("' in literals list").toString());
            }
            aobj[k] = syntaxform;
            obj = pair.getCdr();
        }

        translator.popPositionOf(obj1);
        return aobj;
    }

    private static int insertInt(int i, StringBuffer stringbuffer, int j)
    {
        int k = i;
        if (j > 65535)
        {
            k = i + insertInt(i, stringbuffer, (j << 13) + 1);
        }
        stringbuffer.insert(k, (char)j);
        return k + 1;
    }

    public static boolean literalIdentifierEq(Object obj, ScopeExp scopeexp, Object obj1, ScopeExp scopeexp1)
    {
        boolean flag1 = true;
        if (obj == obj1 || obj != null && obj1 != null && obj.equals(obj1)) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (scopeexp == scopeexp1) goto _L4; else goto _L3
_L3:
        Declaration declaration;
        ScopeExp scopeexp3;
        Object obj2;
        declaration = null;
        obj2 = null;
        scopeexp3 = scopeexp;
_L10:
        Declaration declaration1;
        ScopeExp scopeexp2;
        declaration1 = declaration;
        scopeexp = obj2;
        scopeexp2 = scopeexp1;
        if (scopeexp3 == null) goto _L6; else goto _L5
_L5:
        declaration1 = declaration;
        scopeexp = obj2;
        scopeexp2 = scopeexp1;
        if (scopeexp3 instanceof ModuleExp) goto _L6; else goto _L7
_L7:
        declaration = scopeexp3.lookup(obj);
        if (declaration == null) goto _L9; else goto _L8
_L8:
        scopeexp2 = scopeexp1;
        scopeexp = obj2;
        declaration1 = declaration;
_L6:
        obj = scopeexp;
        if (scopeexp2 != null)
        {
            obj = scopeexp;
            if (!(scopeexp2 instanceof ModuleExp))
            {
                scopeexp = scopeexp2.lookup(obj1);
                if (scopeexp == null)
                {
                    break MISSING_BLOCK_LABEL_156;
                }
                obj = scopeexp;
            }
        }
        flag = flag1;
        if (declaration1 != obj)
        {
            return false;
        }
          goto _L4
_L9:
        scopeexp3 = scopeexp3.outer;
          goto _L10
        scopeexp2 = scopeexp2.outer;
          goto _L6
    }

    public void disassemble()
    {
        disassemble(((PrintWriter) (OutPort.errDefault())), (Translator)Compilation.getCurrent(), 0, program.length());
    }

    public void disassemble(PrintWriter printwriter, Translator translator)
    {
        disassemble(printwriter, translator, 0, program.length());
    }

    void disassemble(PrintWriter printwriter, Translator translator, int i, int j)
    {
        Vector vector;
        int k;
        Object obj = null;
        vector = obj;
        if (translator != null)
        {
            vector = obj;
            if (translator.patternScope != null)
            {
                vector = translator.patternScope.pattern_names;
            }
        }
        boolean flag = false;
        k = i;
        i = ((flag) ? 1 : 0);
_L13:
        char c;
        int l;
        if (k >= j)
        {
            break MISSING_BLOCK_LABEL_721;
        }
        c = program.charAt(k);
        printwriter.print((new StringBuilder()).append(" ").append(k).append(": ").append(c).toString());
        k++;
        l = c & 7;
        i = i << 13 | c >> 3;
        l;
        JVM INSTR tableswitch 0 7: default 164
    //                   0 629
    //                   1 202
    //                   2 228
    //                   3 293
    //                   4 377
    //                   5 408
    //                   6 567
    //                   7 293;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L5
_L1:
        printwriter.println((new StringBuilder()).append(" - ").append(l).append('/').append(i).toString());
_L9:
        i = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        printwriter.println((new StringBuilder()).append(" - WIDE ").append(i).toString());
        continue; /* Loop/switch isn't completed */
_L4:
        printwriter.print((new StringBuilder()).append(" - EQUALS[").append(i).append("]").toString());
        if (literals != null && i >= 0 && i < literals.length)
        {
            printwriter.print(literals[i]);
        }
        printwriter.println();
          goto _L9
_L5:
        StringBuilder stringbuilder1 = new StringBuilder();
        String s;
        if (l == 3)
        {
            s = " - ANY[";
        } else
        {
            s = " - ANY_CAR[";
        }
        printwriter.print(stringbuilder1.append(s).append(i).append("]").toString());
        if (vector != null && i >= 0 && i < vector.size())
        {
            printwriter.print(vector.elementAt(i));
        }
        printwriter.println();
          goto _L9
_L6:
        printwriter.println((new StringBuilder()).append(" - PAIR[").append(i).append("]").toString());
          goto _L9
_L7:
        printwriter.println((new StringBuilder()).append(" - LREPEAT[").append(i).append("]").toString());
        disassemble(printwriter, translator, k, k + i);
        k += i;
        StringBuilder stringbuilder = (new StringBuilder()).append(" ").append(k).append(": - repeat first var:");
        String s2 = program;
        i = k + 1;
        printwriter.println(stringbuilder.append(s2.charAt(k) >> 3).toString());
        stringbuilder = (new StringBuilder()).append(" ").append(i).append(": - repeast nested vars:");
        s2 = program;
        k = i + 1;
        printwriter.println(stringbuilder.append(s2.charAt(i) >> 3).toString());
          goto _L9
_L8:
        StringBuilder stringbuilder2 = (new StringBuilder()).append(" - LENGTH ").append(i >> 1).append(" pairs. ");
        String s1;
        if ((i & 1) == 0)
        {
            s1 = "pure list";
        } else
        {
            s1 = "impure list";
        }
        printwriter.println(stringbuilder2.append(s1).toString());
          goto _L9
_L2:
        printwriter.print((new StringBuilder()).append("[misc ch:").append(c).append(" n:").append(8).append("]").toString());
        if (c == '\b')
        {
            printwriter.println(" - NIL");
        } else
        {
            if (c != '\020')
            {
                continue; /* Loop/switch isn't completed */
            }
            printwriter.println(" - VECTOR");
        }
          goto _L9
        if (c != '\030') goto _L1; else goto _L10
_L10:
        printwriter.println(" - IGNORE");
          goto _L9
        if (true) goto _L1; else goto _L11
_L11:
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public boolean match(Object obj, Object aobj[], int i)
    {
        return match(obj, aobj, i, 0, null);
    }

    public boolean match(Object obj, Object aobj[], int i, int j, SyntaxForm syntaxform)
    {
        int k;
        boolean flag = false;
        k = j;
        j = ((flag) ? 1 : 0);
_L10:
        int l;
        int i1;
        for (; obj instanceof SyntaxForm; obj = syntaxform.getDatum())
        {
            syntaxform = (SyntaxForm)obj;
        }

        String s = program;
        i1 = k + 1;
        k = s.charAt(k);
        l = j << 13 | k >> 3;
        k & 7;
        JVM INSTR tableswitch 0 8: default 124
    //                   0 168
    //                   1 157
    //                   2 978
    //                   3 1118
    //                   4 369
    //                   5 417
    //                   6 267
    //                   7 124
    //                   8 248;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L1 _L9
_L1:
        disassemble();
        throw new Error((new StringBuilder()).append("unrecognized pattern opcode @pc:").append(i1).toString());
_L3:
        k = i1;
        j = l;
          goto _L10
_L2:
        if (k == 8)
        {
            boolean flag1;
            if (obj == LList.Empty)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            return flag1;
        }
        if (k == 16)
        {
            if (!(obj instanceof FVector))
            {
                return false;
            } else
            {
                return match(LList.makeList((FVector)obj), aobj, i, i1, syntaxform);
            }
        }
        if (k == 24)
        {
            return true;
        } else
        {
            throw new Error("unknwon pattern opcode");
        }
_L9:
        boolean flag2;
        if (obj == LList.Empty)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        return flag2;
_L8:
        Object obj1;
        obj1 = obj;
        j = 0;
_L13:
        for (; obj1 instanceof SyntaxForm; obj1 = ((SyntaxForm)obj1).getDatum()) { }
        if (j != l >> 1) goto _L12; else goto _L11
_L11:
        if ((l & 1) != 0 ? obj1 instanceof Pair : obj1 != LList.Empty)
        {
            return false;
        }
        j = 0;
        k = i1;
          goto _L10
_L12:
        if (obj1 instanceof Pair)
        {
            obj1 = ((Pair)obj1).getCdr();
            j++;
        } else
        {
            return false;
        }
          goto _L13
_L6:
        if (!(obj instanceof Pair))
        {
            return false;
        }
        obj = (Pair)obj;
        if (!match_car(((Pair) (obj)), aobj, i, i1, syntaxform))
        {
            return false;
        }
        k = i1 + l;
        j = 0;
        obj = ((Pair) (obj)).getCdr();
          goto _L10
_L7:
        j = i1 + l;
        Object obj2 = program;
        k = j + 1;
        j = ((String) (obj2)).charAt(j);
        l = j >> 3;
        while ((j & 7) == 1) 
        {
            j = program.charAt(k);
            l = l << 13 | j >> 3;
            k++;
        }
        int i2 = l + i;
        int j1 = program.charAt(k) >> 3;
        l = k + 1;
        k = j;
        for (j = l; (k & 7) == 1; j++)
        {
            k = program.charAt(j);
            j1 = j1 << 13 | k >> 3;
        }

        obj2 = program;
        l = j + 1;
        k = ((String) (obj2)).charAt(j);
        int k1 = 1;
        j = 1;
        int l1;
        if (k == 8)
        {
            l1 = 0;
            k1 = j;
        } else
        {
            l1 = k >> 3;
            j = l;
            l = l1;
            while ((k & 7) == 1) 
            {
                k = program.charAt(j);
                l = l << 13 | k >> 3;
                j++;
            }
            k = k1;
            if ((l & 1) != 0)
            {
                k = 0;
            }
            l1 = l >> 1;
            k1 = k;
            l = j;
        }
        k = Translator.listLength(obj);
        if (k >= 0)
        {
            j = 1;
        } else
        {
            j = 0;
            k = -1 - k;
        }
        if (k < l1 || k1 != 0 && j == 0)
        {
            return false;
        }
        int j2 = k - l1;
        Object aobj1[][] = new Object[j1][];
        for (j = 0; j < j1; j++)
        {
            aobj1[j] = new Object[j2];
        }

        j = 0;
        Object obj5 = syntaxform;
        obj2 = obj;
        while (j < j2) 
        {
            obj = obj5;
            for (; obj2 instanceof SyntaxForm; obj2 = ((SyntaxForm) (obj)).getDatum())
            {
                obj = (SyntaxForm)obj2;
            }

            syntaxform = (Pair)obj2;
            if (!match_car(syntaxform, aobj, i, i1, ((SyntaxForm) (obj))))
            {
                return false;
            }
            obj2 = syntaxform.getCdr();
            for (k = 0; k < j1; k++)
            {
                aobj1[k][j] = aobj[i2 + k];
            }

            j++;
            obj5 = obj;
        }
        for (j = 0; j < j1; j++)
        {
            aobj[i2 + j] = ((Object) (aobj1[j]));
        }

        i1 = 0;
        j = i1;
        obj = obj2;
        k = l;
        syntaxform = ((SyntaxForm) (obj5));
        if (l1 == 0)
        {
            j = i1;
            obj = obj2;
            k = l;
            syntaxform = ((SyntaxForm) (obj5));
            if (k1 != 0)
            {
                return true;
            }
        }
          goto _L10
_L4:
        Object obj3 = literals[l];
        Translator translator = (Translator)Compilation.getCurrent();
        Object obj6;
        if (obj3 instanceof SyntaxForm)
        {
            aobj = (SyntaxForm)obj3;
            obj3 = ((SyntaxForm) (aobj)).getDatum();
            aobj = ((SyntaxForm) (aobj)).getScope();
        } else
        {
            aobj = translator.getCurrentSyntax();
            if (aobj instanceof Macro)
            {
                aobj = ((Macro)aobj).getCapturedScope();
            } else
            {
                aobj = null;
            }
        }
        if (obj instanceof SyntaxForm)
        {
            obj = (SyntaxForm)obj;
            obj6 = ((SyntaxForm) (obj)).getDatum();
            obj = ((SyntaxForm) (obj)).getScope();
        } else
        {
            obj6 = obj;
            if (syntaxform == null)
            {
                obj = translator.currentScope();
            } else
            {
                obj = syntaxform.getScope();
            }
        }
        return literalIdentifierEq(obj3, ((ScopeExp) (aobj)), obj6, ((ScopeExp) (obj)));
_L5:
        Object obj4 = obj;
        if (syntaxform != null)
        {
            obj4 = SyntaxForms.fromDatum(obj, syntaxform);
        }
        aobj[i + l] = obj4;
        return true;
    }

    boolean match_car(Pair pair, Object aobj[], int i, int j, SyntaxForm syntaxform)
    {
        String s = program;
        int k = j + 1;
        char c = s.charAt(j);
        int l = c >> 3;
        while ((c & 7) == 1) 
        {
            c = program.charAt(k);
            l = l << 13 | c >> 3;
            k++;
        }
        if ((c & 7) == 7)
        {
            Pair pair1 = pair;
            if (syntaxform != null)
            {
                pair1 = pair;
                if (!(pair.getCar() instanceof SyntaxForm))
                {
                    pair1 = Translator.makePair(pair, SyntaxForms.fromDatum(pair.getCar(), syntaxform), pair.getCdr());
                }
            }
            aobj[i + l] = pair1;
            return true;
        } else
        {
            return match(pair.getCar(), aobj, i, j, syntaxform);
        }
    }

    public void print(Consumer consumer)
    {
        consumer.write("#<syntax-pattern>");
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        literals = (Object[])(Object[])objectinput.readObject();
        program = (String)objectinput.readObject();
        varCount = objectinput.readInt();
    }

    void translate(Object obj, StringBuffer stringbuffer, Object aobj[], int i, Vector vector, SyntaxForm syntaxform, char c, 
            Translator translator)
    {
        PatternScope patternscope;
        Vector vector1;
        patternscope = translator.patternScope;
        vector1 = patternscope.pattern_names;
_L8:
        SyntaxForm syntaxform2;
        do
        {
label0:
            {
                syntaxform2 = syntaxform;
                if (!(obj instanceof SyntaxForm))
                {
                    break label0;
                }
                syntaxform = (SyntaxForm)obj;
                obj = syntaxform.getDatum();
            }
        } while (true);
        if (!(obj instanceof Pair)) goto _L2; else goto _L1
_L1:
        Object obj4 = translator.pushPositionOf(obj);
        Object obj1;
        Pair pair;
        int i1;
        i1 = stringbuffer.length();
        stringbuffer.append('\004');
        pair = (Pair)obj;
        obj1 = pair.getCdr();
        SyntaxForm syntaxform1 = syntaxform2;
        for (; obj1 instanceof SyntaxForm; obj1 = syntaxform1.getDatum())
        {
            syntaxform1 = (SyntaxForm)obj1;
        }

        boolean flag;
        int l;
        l = 0;
        obj = obj1;
        flag = l;
        syntaxform = syntaxform1;
        if (!(obj1 instanceof Pair))
        {
            break MISSING_BLOCK_LABEL_216;
        }
        obj = obj1;
        flag = l;
        syntaxform = syntaxform1;
        if (!translator.matches(((Pair)obj1).getCar(), "..."))
        {
            break MISSING_BLOCK_LABEL_216;
        }
        l = 1;
        obj1 = ((Pair)obj1).getCdr();
        syntaxform = syntaxform1;
_L3:
        obj = obj1;
        flag = l;
        if (!(obj1 instanceof SyntaxForm))
        {
            break MISSING_BLOCK_LABEL_216;
        }
        syntaxform = (SyntaxForm)obj1;
        obj1 = syntaxform.getDatum();
          goto _L3
        int j1 = vector1.size();
        l = c;
        if (c == 'P')
        {
            l = 0;
        }
        obj1 = pair.getCar();
        char c1;
        int k1;
        int l1;
        if (flag)
        {
            c = i + 1;
        } else
        {
            c = i;
        }
          goto _L4
_L7:
        translate(obj1, stringbuffer, aobj, c, vector, syntaxform2, c1, translator);
        k1 = vector1.size();
        l1 = stringbuffer.length();
        if (flag)
        {
            c = '\005';
        } else
        {
            c = '\004';
        }
        l1 = l1 - i1 - 1 << 3 | c;
        c = i1;
        if (l1 <= 65535)
        {
            break MISSING_BLOCK_LABEL_340;
        }
        c = i1 + insertInt(i1, stringbuffer, (l1 >> 13) + 1);
        stringbuffer.setCharAt(c, (char)l1);
        c = Translator.listLength(obj);
        if (c != '\0') goto _L6; else goto _L5
_L5:
        translator.syntaxError("cyclic pattern list");
        translator.popPositionOf(obj4);
        return;
_L10:
        c1 = 'P';
          goto _L7
_L6:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_468;
        }
        addInt(stringbuffer, j1 << 3);
        addInt(stringbuffer, k1 - j1 << 3);
        if (obj != LList.Empty)
        {
            break MISSING_BLOCK_LABEL_446;
        }
        stringbuffer.append('\b');
        translator.popPositionOf(obj4);
        return;
        if (c >= 0)
        {
            c <<= '\001';
        } else
        {
            c = (-c << 1) - 1;
        }
        addInt(stringbuffer, c << 3 | 6);
        translator.popPositionOf(obj4);
        c = l;
          goto _L8
        obj;
        translator.popPositionOf(obj4);
        throw obj;
_L2:
        if (obj instanceof Symbol)
        {
            int j = aobj.length;
            do
            {
                j--;
                if (j >= 0)
                {
                    syntaxform = translator.currentScope();
                    Object obj2;
                    Object obj3;
                    if (syntaxform2 == null)
                    {
                        obj2 = syntaxform;
                    } else
                    {
                        obj2 = syntaxform2.getScope();
                    }
                    obj3 = aobj[j];
                    if (obj3 instanceof SyntaxForm)
                    {
                        syntaxform = (SyntaxForm)obj3;
                        obj3 = syntaxform.getDatum();
                        syntaxform = syntaxform.getScope();
                    } else
                    if (translator.currentMacroDefinition != null)
                    {
                        syntaxform = translator.currentMacroDefinition.getCapturedScope();
                    }
                    if (literalIdentifierEq(obj, ((ScopeExp) (obj2)), obj3, syntaxform))
                    {
                        c = SyntaxTemplate.indexOf(vector, obj);
                        i = c;
                        if (c < 0)
                        {
                            i = vector.size();
                            vector.addElement(obj);
                        }
                        addInt(stringbuffer, i << 3 | 2);
                        return;
                    }
                } else
                {
                    if (vector1.contains(obj))
                    {
                        translator.syntaxError((new StringBuilder()).append("duplicated pattern variable ").append(obj).toString());
                    }
                    l = vector1.size();
                    vector1.addElement(obj);
                    int k;
                    if (c == 'P')
                    {
                        c = '\001';
                    } else
                    {
                        c = '\0';
                    }
                    if (c != 0)
                    {
                        k = 1;
                    } else
                    {
                        k = 0;
                    }
                    patternscope.patternNesting.append((char)((i << 1) + k));
                    obj = patternscope.addDeclaration(obj);
                    ((Declaration) (obj)).setLocation(translator);
                    translator.push(((Declaration) (obj)));
                    if (c != 0)
                    {
                        i = 7;
                    } else
                    {
                        i = 3;
                    }
                    addInt(stringbuffer, i | l << 3);
                    return;
                }
            } while (true);
        }
        if (obj == LList.Empty)
        {
            stringbuffer.append('\b');
            return;
        }
        if (obj instanceof FVector)
        {
            stringbuffer.append('\020');
            obj = LList.makeList((FVector)obj);
            c = 'V';
            syntaxform = syntaxform2;
        } else
        {
            c = SyntaxTemplate.indexOf(vector, obj);
            i = c;
            if (c < 0)
            {
                i = vector.size();
                vector.addElement(obj);
            }
            addInt(stringbuffer, i << 3 | 2);
            return;
        }
          goto _L8
_L4:
        if (l != 86) goto _L10; else goto _L9
_L9:
        c1 = '\0';
          goto _L7
    }

    public int varCount()
    {
        return varCount;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(program);
        objectoutput.writeObject(((Object) (literals)));
        objectoutput.writeInt(varCount);
    }
}
