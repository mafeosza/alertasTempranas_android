// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.InPort;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.text.Path;
import gnu.text.SyntaxException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class require extends Syntax
{

    private static final String SLIB_PREFIX = "gnu.kawa.slib.";
    static Hashtable featureMap = new Hashtable();
    public static final require require;

    public require()
    {
    }

    public static Object find(String s)
    {
        return ModuleManager.getInstance().findWithClassName(s).getInstance();
    }

    public static boolean importDefinitions(String s, ModuleInfo moduleinfo, Procedure procedure, Vector vector, ScopeExp scopeexp, Compilation compilation)
    {
        Object obj = ModuleManager.getInstance();
        if ((moduleinfo.getState() & 1) != 0 || moduleinfo.getCompilation() != null || moduleinfo.checkCurrent(((ModuleManager) (obj)), System.currentTimeMillis()))
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj = compilation.getMessages();
        Language language = Language.getDefaultLanguage();
        InPort inport;
        int i;
        try
        {
            inport = InPort.openFile(moduleinfo.getSourceAbsPath());
            moduleinfo.clearClass();
            moduleinfo.setClassName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            compilation.error('e', (new StringBuilder()).append("not found: ").append(s.getMessage()).toString());
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            compilation.error('e', (new StringBuilder()).append("caught ").append(s).toString());
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if (s.getMessages() != obj)
            {
                throw new RuntimeException((new StringBuilder()).append("confussing syntax error: ").append(s).toString());
            } else
            {
                return false;
            }
        }
        i = 8;
        if (compilation.immediate)
        {
            i = 8 | 1;
        }
        s = language.parse(inport, ((gnu.text.SourceMessages) (obj)), i, moduleinfo);
        moduleinfo.setClassName(s.getModule().classFor(s).getName());
        Object obj1;
        Declaration declaration;
        Object obj2;
        Field field;
        ApplyExp applyexp;
        ClassType classtype;
        Vector vector1;
        String s1;
        Language language1;
        int l;
        int j1;
        boolean flag1;
        boolean flag2;
        if (compilation.minfo != null && compilation.getState() < 4)
        {
            compilation.minfo.addDependency(moduleinfo);
            if (!moduleinfo.loadEager(12) && moduleinfo.getState() < 6)
            {
                compilation.pushPendingImport(moduleinfo, scopeexp, vector.size());
                return true;
            }
        }
        classtype = moduleinfo.getClassType();
        s1 = classtype.getName();
        flag2 = compilation.sharedModuleDefs();
        if (moduleinfo.getState() < 6)
        {
            flag1 = moduleinfo.getCompilation().makeRunnable();
        } else
        {
            flag1 = classtype.isSubtype(Compilation.typeRunnable);
        }
        s = null;
        applyexp = Invoke.makeInvokeStatic(ClassType.make("kawa.standard.require"), "find", new Expression[] {
            new QuoteExp(s1)
        });
        obj1 = null;
        language1 = compilation.getLanguage();
        applyexp.setLine(compilation);
        j1 = vector.size();
        moduleinfo = moduleinfo.setupModuleExp();
        vector1 = new Vector();
        declaration = moduleinfo.firstDecl();
        if (declaration == null)
        {
            break MISSING_BLOCK_LABEL_1149;
        }
        if (!declaration.isPrivate())
        {
            break; /* Loop/switch isn't completed */
        }
        field = obj1;
        l = j1;
        obj2 = s;
_L7:
        declaration = declaration.nextDecl();
        s = ((String) (obj2));
        j1 = l;
        obj1 = field;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_383;
_L1:
        Object obj3;
        moduleinfo = (Symbol)declaration.getSymbol();
        obj3 = moduleinfo;
        if (procedure == null)
        {
            break MISSING_BLOCK_LABEL_542;
        }
        try
        {
            moduleinfo = ((ModuleInfo) (procedure.apply1(moduleinfo)));
        }
        // Misplaced declaration of an exception variable
        catch (ModuleInfo moduleinfo) { }
        obj2 = s;
        l = j1;
        field = obj1;
        if (moduleinfo != null)
        {
label0:
            {
                if (moduleinfo instanceof Symbol)
                {
                    break label0;
                }
                compilation.error('e', (new StringBuilder()).append("internal error - import name mapper returned non-symbol: ").append(moduleinfo.getClass().getName()).toString());
                obj2 = s;
                l = j1;
                field = obj1;
            }
        }
          goto _L3
        obj3 = (Symbol)moduleinfo;
        int j;
        boolean flag3;
label1:
        {
            flag3 = declaration.getFlag(2048L);
            moduleinfo = s;
            j = j1;
            if (!flag3)
            {
                moduleinfo = s;
                j = j1;
                if (s == null)
                {
                    moduleinfo = new Declaration(SimpleSymbol.valueOf((new StringBuilder()).append(s1.replace('.', '$')).append("$instance").toString()), classtype);
                    moduleinfo.setPrivate(true);
                    moduleinfo.setFlag(0x40004000L);
                    scopeexp.addDeclaration(moduleinfo);
                    moduleinfo.noteValue(applyexp);
                    s = new SetExp(moduleinfo, applyexp);
                    s.setLine(compilation);
                    s.setDefining(true);
                    vector.addElement(s);
                    j = vector.size();
                    moduleinfo.setFlag(0x20000000L);
                    if (flag1)
                    {
                        moduleinfo.setSimple(false);
                    }
                    moduleinfo.setFlag(8192L);
                }
            }
            if (declaration.field == null || !declaration.field.getName().equals("$instance"))
            {
                break label1;
            }
            field = declaration.field;
            obj2 = moduleinfo;
            l = j;
        }
          goto _L3
        Declaration declaration2;
        boolean flag;
        if (declaration.field != null && declaration.field.getName().endsWith("$instance"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        declaration2 = scopeexp.lookup(obj3, language1, language1.getNamespaceOf(declaration));
        if (!flag) goto _L5; else goto _L4
_L4:
        obj2 = moduleinfo;
        l = j;
        field = obj1;
        if (declaration2 != null) goto _L3; else goto _L6
_L6:
        s = scopeexp.addDeclaration(obj3);
        s.setFlag(0x40004000L);
        s.setType(declaration.getType());
        s.setFlag(8192L);
_L10:
        s.setLocation(compilation);
        obj2 = new ReferenceExp(declaration);
        ((ReferenceExp) (obj2)).setContextDecl(moduleinfo);
        if (!flag)
        {
            ((ReferenceExp) (obj2)).setDontDereference(true);
            if (!flag2)
            {
                s.setPrivate(true);
            }
        }
        s.setFlag(16384L);
        if (declaration.getFlag(32768L))
        {
            s.setFlag(32768L);
        }
        if (declaration.isProcedureDecl())
        {
            s.setProcedureDecl(true);
        }
        if (flag3)
        {
            s.setFlag(2048L);
        }
        obj3 = new SetExp(s, ((Expression) (obj2)));
        s.setFlag(0x20000000L);
        ((SetExp) (obj3)).setDefining(true);
        if (flag)
        {
            vector.insertElementAt(obj3, j);
            j++;
        } else
        {
            vector.addElement(obj3);
        }
        vector1.add(s);
        vector1.add(declaration);
        s.noteValue(((Expression) (obj2)));
        s.setFlag(0x20000L);
        compilation.push(s);
        obj2 = moduleinfo;
        l = j;
        field = obj1;
_L3:
        if (true) goto _L7; else goto _L5
_L5:
        if (declaration2 == null || declaration2.getFlag(512L))
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = moduleinfo;
        l = j;
        field = obj1;
        if (Declaration.followAliases(declaration2) == Declaration.followAliases(declaration)) goto _L9; else goto _L8
_L9:
        break; /* Loop/switch isn't completed */
_L8:
        if (declaration2 != null && declaration2.getFlag(0x10200L))
        {
            declaration2.setFlag(false, 0x10200L);
            s = declaration2;
        } else
        {
            obj2 = scopeexp.addDeclaration(obj3);
            s = ((String) (obj2));
            if (declaration2 != null)
            {
                ScopeExp.duplicateDeclarationError(declaration2, ((Declaration) (obj2)), compilation);
                s = ((String) (obj2));
            }
        }
        s.setAlias(true);
        s.setIndirectBinding(true);
          goto _L10
        int i1 = vector1.size();
        for (int k = 0; k < i1; k += 2)
        {
            procedure = (Declaration)vector1.elementAt(k);
            Declaration declaration1 = (Declaration)vector1.elementAt(k + 1);
            moduleinfo = declaration1.getValue();
            if (!declaration1.isIndirectBinding() || !(moduleinfo instanceof ReferenceExp))
            {
                continue;
            }
            procedure = (ReferenceExp)procedure.getValue();
            moduleinfo = ((ReferenceExp)moduleinfo).getBinding();
            procedure.setBinding(moduleinfo);
            if (moduleinfo.needsContext())
            {
                moduleinfo = scopeexp.lookup(SimpleSymbol.valueOf((new StringBuilder()).append(((Declaration) (moduleinfo)).field.getDeclaringClass().getName().replace('.', '$')).append("$instance").toString()));
                moduleinfo.setFlag(1024L);
                procedure.setContextDecl(moduleinfo);
            }
        }

        if (!flag1) goto _L12; else goto _L11
_L11:
        moduleinfo = Compilation.typeRunnable.getDeclaredMethod("run", 0);
        if (s == null) goto _L14; else goto _L13
_L13:
        s = new ReferenceExp(s);
_L16:
        s = new ApplyExp(moduleinfo, new Expression[] {
            s
        });
        s.setLine(compilation);
        vector.addElement(s);
_L12:
        return true;
_L14:
        s = applyexp;
        if (obj1 != null)
        {
            s = new QuoteExp(classtype);
            procedure = new QuoteExp("$instance");
            s = new ApplyExp(SlotGet.staticField, new Expression[] {
                s, procedure
            });
        }
        if (true) goto _L16; else goto _L15
_L15:
    }

    public static ModuleInfo lookupModuleFromSourcePath(String s, ScopeExp scopeexp)
    {
        ModuleManager modulemanager = ModuleManager.getInstance();
        String s1 = scopeexp.getFileName();
        scopeexp = s;
        if (s1 != null)
        {
            scopeexp = Path.valueOf(s1).resolve(s).toString();
        }
        return modulemanager.findWithSourcePath(scopeexp);
    }

    static void map(String s, String s1)
    {
        featureMap.put(s, s1);
    }

    public static String mapFeature(String s)
    {
        return (String)featureMap.get(s);
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        return null;
    }

    public boolean scanForDefinitions(Pair pair, Vector vector, ScopeExp scopeexp, Translator translator)
    {
        Object obj;
        Object obj1;
        Object obj2;
        if (translator.getState() == 1)
        {
            translator.setState(2);
            translator.pendingForm = pair;
            return true;
        }
        obj1 = (Pair)pair.getCdr();
        obj2 = ((Pair) (obj1)).getCar();
        obj = null;
        if (!(obj2 instanceof Pair)) goto _L2; else goto _L1
_L1:
        pair = (Pair)obj2;
        if (!translator.matches(pair.getCar(), "quote")) goto _L2; else goto _L3
_L3:
label0:
        {
            pair = ((Pair) (pair.getCdr()));
            if (pair instanceof Pair)
            {
                pair = (Pair)pair;
                if (pair.getCdr() == LList.Empty && (pair.getCar() instanceof Symbol))
                {
                    break label0;
                }
            }
            translator.error('e', "invalid quoted symbol for 'require'");
            return false;
        }
        obj = mapFeature(pair.getCar().toString());
        if (obj == null)
        {
            translator.error('e', (new StringBuilder()).append("unknown feature name '").append(pair.getCar()).append("' for 'require'").toString());
            return false;
        }
        pair = ClassType.make((String)obj);
_L5:
        if (!(pair instanceof ClassType))
        {
            translator.error('e', "invalid specifier for 'require'");
            return false;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (obj2 instanceof CharSequence)
        {
            pair = obj2.toString();
            obj = lookupModuleFromSourcePath(pair, scopeexp);
            if (obj == null)
            {
                translator.error('e', (new StringBuilder()).append("malformed URL: ").append(pair).toString());
                return false;
            } else
            {
                return importDefinitions(null, ((ModuleInfo) (obj)), null, vector, scopeexp, translator);
            }
        }
        pair = ((Pair) (obj));
        if (obj2 instanceof Symbol)
        {
            pair = ((Pair) (obj));
            if (!translator.selfEvaluatingSymbol(obj2))
            {
                Type type = translator.getLanguage().getTypeFor(translator.rewrite(obj2, false));
                pair = type;
                if (type instanceof ClassType)
                {
                    pair = type;
                    if (((Pair) (obj1)).getCdr() instanceof Pair)
                    {
                        obj1 = ((Pair)((Pair) (obj1)).getCdr()).getCar();
                        pair = type;
                        if (obj1 instanceof CharSequence)
                        {
                            pair = obj1.toString();
                            obj1 = lookupModuleFromSourcePath(pair, scopeexp);
                            if (obj1 == null)
                            {
                                translator.error('e', (new StringBuilder()).append("malformed URL: ").append(pair).toString());
                                return false;
                            } else
                            {
                                return importDefinitions(type.getName(), ((ModuleInfo) (obj1)), null, vector, scopeexp, translator);
                            }
                        }
                    }
                }
            }
        }
        if (true) goto _L5; else goto _L4
_L4:
        ModuleInfo moduleinfo;
        try
        {
            moduleinfo = ModuleInfo.find((ClassType)pair);
        }
        // Misplaced declaration of an exception variable
        catch (Vector vector)
        {
            translator.error('e', (new StringBuilder()).append("unknown class ").append(pair.getName()).toString());
            return false;
        }
        importDefinitions(null, moduleinfo, null, vector, scopeexp, translator);
        return true;
    }

    static 
    {
        require = new require();
        require.setName("require");
        map("generic-write", "gnu.kawa.slib.genwrite");
        map("pretty-print", "gnu.kawa.slib.pp");
        map("pprint-file", "gnu.kawa.slib.ppfile");
        map("printf", "gnu.kawa.slib.printf");
        map("xml", "gnu.kawa.slib.XML");
        map("readtable", "gnu.kawa.slib.readtable");
        map("srfi-10", "gnu.kawa.slib.readtable");
        map("http", "gnu.kawa.servlet.HTTP");
        map("servlets", "gnu.kawa.servlet.servlets");
        map("srfi-1", "gnu.kawa.slib.srfi1");
        map("list-lib", "gnu.kawa.slib.srfi1");
        map("srfi-2", "gnu.kawa.slib.srfi2");
        map("and-let*", "gnu.kawa.slib.srfi2");
        map("srfi-13", "gnu.kawa.slib.srfi13");
        map("string-lib", "gnu.kawa.slib.srfi13");
        map("srfi-34", "gnu.kawa.slib.srfi34");
        map("srfi-35", "gnu.kawa.slib.conditions");
        map("condition", "gnu.kawa.slib.conditions");
        map("conditions", "gnu.kawa.slib.conditions");
        map("srfi-37", "gnu.kawa.slib.srfi37");
        map("args-fold", "gnu.kawa.slib.srfi37");
        map("srfi-64", "gnu.kawa.slib.testing");
        map("testing", "gnu.kawa.slib.testing");
        map("srfi-69", "gnu.kawa.slib.srfi69");
        map("hash-table", "gnu.kawa.slib.srfi69");
        map("basic-hash-tables", "gnu.kawa.slib.srfi69");
        map("srfi-95", "kawa.lib.srfi95");
        map("sorting-and-merging", "kawa.lib.srfi95");
        map("regex", "kawa.lib.kawa.regex");
        map("pregexp", "gnu.kawa.slib.pregexp");
        map("gui", "gnu.kawa.slib.gui");
        map("swing-gui", "gnu.kawa.slib.swing");
        map("android-defs", "gnu.kawa.android.defs");
        map("syntax-utils", "gnu.kawa.slib.syntaxutils");
    }
}
