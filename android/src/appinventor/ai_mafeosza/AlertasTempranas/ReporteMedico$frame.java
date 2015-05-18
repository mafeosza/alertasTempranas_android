// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package appinventor.ai_mafeosza.AlertasTempranas;

import com.google.appinventor.components.runtime.Component;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;

// Referenced classes of package appinventor.ai_mafeosza.AlertasTempranas:
//            ReporteMedico

public class  extends ModuleBody
{

    ReporteMedico $main;

    public Object apply0(ModuleMethod modulemethod)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply0(modulemethod);

        case 15: // '\017'
            return ReporteMedico.lambda2();

        case 16: // '\020'
            $main.$define();
            return Values.empty;

        case 17: // '\021'
            return ReporteMedico.lambda3();

        case 18: // '\022'
            return ReporteMedico.lambda4();

        case 19: // '\023'
            return ReporteMedico.lambda5();

        case 20: // '\024'
            return ReporteMedico.lambda6();

        case 21: // '\025'
            return ReporteMedico.lambda7();

        case 22: // '\026'
            return ReporteMedico.lambda8();

        case 23: // '\027'
            return ReporteMedico.lambda9();

        case 24: // '\030'
            return ReporteMedico.lambda10();

        case 25: // '\031'
            return $main.enfermedades$BeforePicking();

        case 26: // '\032'
            return ReporteMedico.lambda11();

        case 27: // '\033'
            return ReporteMedico.lambda12();

        case 28: // '\034'
            return ReporteMedico.lambda13();

        case 29: // '\035'
            return ReporteMedico.lambda14();

        case 30: // '\036'
            return ReporteMedico.lambda15();

        case 31: // '\037'
            return ReporteMedico.lambda16();

        case 32: // ' '
            return ReporteMedico.lambda17();

        case 33: // '!'
            return ReporteMedico.lambda18();

        case 34: // '"'
            return ReporteMedico.lambda19();

        case 35: // '#'
            return ReporteMedico.lambda20();

        case 36: // '$'
            return ReporteMedico.lambda21();

        case 37: // '%'
            return ReporteMedico.lambda22();

        case 38: // '&'
            return ReporteMedico.lambda23();

        case 39: // '\''
            return ReporteMedico.lambda24();

        case 40: // '('
            return ReporteMedico.lambda25();

        case 41: // ')'
            return ReporteMedico.lambda26();

        case 42: // '*'
            return ReporteMedico.lambda27();

        case 43: // '+'
            return ReporteMedico.lambda28();

        case 44: // ','
            return ReporteMedico.lambda29();

        case 45: // '-'
            return ReporteMedico.lambda30();

        case 46: // '.'
            return ReporteMedico.lambda31();

        case 47: // '/'
            return ReporteMedico.lambda32();

        case 48: // '0'
            return ReporteMedico.lambda33();

        case 49: // '1'
            return ReporteMedico.lambda34();

        case 50: // '2'
            return ReporteMedico.lambda35();

        case 51: // '3'
            return ReporteMedico.lambda36();

        case 52: // '4'
            return ReporteMedico.lambda37();

        case 53: // '5'
            return ReporteMedico.lambda38();

        case 54: // '6'
            return ReporteMedico.lambda39();

        case 55: // '7'
            return ReporteMedico.lambda40();

        case 56: // '8'
            return ReporteMedico.lambda41();

        case 57: // '9'
            return ReporteMedico.lambda42();

        case 58: // ':'
            return ReporteMedico.lambda43();

        case 59: // ';'
            return ReporteMedico.lambda44();

        case 60: // '<'
            return ReporteMedico.lambda45();

        case 61: // '='
            return ReporteMedico.lambda46();
        }
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        case 2: // '\002'
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        default:
            return super.apply1(modulemethod, obj);

        case 1: // '\001'
            $main.androidLogForm(obj);
            return Values.empty;

        case 3: // '\003'
            modulemethod = $main;
            Symbol symbol;
            try
            {
                symbol = (Symbol)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "lookup-in-form-environment", 1, obj);
            }
            return modulemethod.lookupInFormEnvironment(symbol);

        case 5: // '\005'
            modulemethod = $main;
            try
            {
                symbol = (Symbol)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "is-bound-in-form-environment", 1, obj);
            }
            if (modulemethod.isBoundInFormEnvironment(symbol))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 10: // '\n'
            $main.addToFormDoAfterCreation(obj);
            return Values.empty;

        case 11: // '\013'
            $main.sendError(obj);
            return Values.empty;

        case 12: // '\f'
            $main.processException(obj);
            return Values.empty;
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        case 4: // '\004'
        case 5: // '\005'
        case 8: // '\b'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 2: // '\002'
            modulemethod = $main;
            Symbol symbol;
            try
            {
                symbol = (Symbol)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "add-to-form-environment", 1, obj);
            }
            modulemethod.addToFormEnvironment(symbol, obj1);
            return Values.empty;

        case 3: // '\003'
            modulemethod = $main;
            try
            {
                symbol = (Symbol)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "lookup-in-form-environment", 1, obj);
            }
            return modulemethod.lookupInFormEnvironment(symbol, obj1);

        case 6: // '\006'
            modulemethod = $main;
            try
            {
                symbol = (Symbol)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "add-to-global-var-environment", 1, obj);
            }
            modulemethod.addToGlobalVarEnvironment(symbol, obj1);
            return Values.empty;

        case 7: // '\007'
            $main.addToEvents(obj, obj1);
            return Values.empty;

        case 9: // '\t'
            $main.addToGlobalVars(obj, obj1);
            return Values.empty;

        case 14: // '\016'
            return $main.lookupHandler(obj, obj1);
        }
    }

    public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply4(modulemethod, obj, obj1, obj2, obj3);

        case 8: // '\b'
            $main.addToComponents(obj, obj1, obj2, obj3);
            return Values.empty;

        case 13: // '\r'
            modulemethod = $main;
            break;
        }
        Component component;
        try
        {
            component = (Component)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "dispatchEvent", 1, obj);
        }
        try
        {
            obj = (String)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "dispatchEvent", 2, obj1);
        }
        try
        {
            obj1 = (String)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "dispatchEvent", 3, obj2);
        }
        try
        {
            obj2 = ((Object) ((Object[])obj3));
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "dispatchEvent", 4, obj3);
        }
        if (modulemethod.dispatchEvent(component, ((String) (obj)), ((String) (obj1)), ((Object []) (obj2))))
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match0(modulemethod, callcontext);

        case 61: // '='
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 60: // '<'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 59: // ';'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 58: // ':'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 57: // '9'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 56: // '8'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 55: // '7'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 54: // '6'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 53: // '5'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 52: // '4'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 51: // '3'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 50: // '2'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 49: // '1'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 48: // '0'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 47: // '/'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 46: // '.'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 45: // '-'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 44: // ','
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 43: // '+'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 42: // '*'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 41: // ')'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 40: // '('
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 39: // '\''
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 38: // '&'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 37: // '%'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 36: // '$'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 35: // '#'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

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

        case 30: // '\036'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 29: // '\035'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 28: // '\034'
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

        case 17: // '\021'
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
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        int i = 0xfff40001;
        modulemethod.selector;
        JVM INSTR tableswitch 1 12: default 72
    //                   1 190
    //                   2 72
    //                   3 166
    //                   4 72
    //                   5 142
    //                   6 72
    //                   7 72
    //                   8 72
    //                   9 72
    //                   10 125
    //                   11 108
    //                   12 84;
           goto _L1 _L2 _L1 _L3 _L1 _L4 _L1 _L1 _L1 _L1 _L5 _L6 _L7
_L1:
        i = super.match1(modulemethod, obj, callcontext);
_L9:
        return i;
_L7:
        if (!(obj instanceof ReporteMedico)) goto _L9; else goto _L8
_L8:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L6:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L5:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L4:
        if (!(obj instanceof Symbol)) goto _L9; else goto _L10
_L10:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L3:
        if (!(obj instanceof Symbol)) goto _L9; else goto _L11
_L11:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L2:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 4: // '\004'
        case 5: // '\005'
        case 8: // '\b'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        default:
            return super.match2(modulemethod, obj, obj1, callcontext);

        case 14: // '\016'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 9: // '\t'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 7: // '\007'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 6: // '\006'
            if (!(obj instanceof Symbol))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 3: // '\003'
            if (!(obj instanceof Symbol))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 2: // '\002'
            break;
        }
        if (!(obj instanceof Symbol))
        {
            return 0xfff40001;
        } else
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
    }

    public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match4(modulemethod, obj, obj1, obj2, obj3, callcontext);

        case 13: // '\r'
            if (!(obj instanceof ReporteMedico))
            {
                return 0xfff40001;
            }
            callcontext.value1 = obj;
            if (!(obj1 instanceof Component))
            {
                return 0xfff40002;
            }
            callcontext.value2 = obj1;
            if (!(obj2 instanceof String))
            {
                return 0xfff40003;
            }
            callcontext.value3 = obj2;
            if (!(obj3 instanceof String))
            {
                return 0xfff40004;
            } else
            {
                callcontext.value4 = obj3;
                callcontext.proc = modulemethod;
                callcontext.pc = 4;
                return 0;
            }

        case 8: // '\b'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.value4 = obj3;
            callcontext.proc = modulemethod;
            callcontext.pc = 4;
            return 0;
        }
    }

    public ()
    {
    }
}
