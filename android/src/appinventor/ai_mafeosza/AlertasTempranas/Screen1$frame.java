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
//            Screen1

public class  extends ModuleBody
{

    Screen1 $main;

    public Object apply0(ModuleMethod modulemethod)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply0(modulemethod);

        case 15: // '\017'
            return Screen1.lambda2();

        case 16: // '\020'
            $main.$define();
            return Values.empty;

        case 17: // '\021'
            return Screen1.lambda3();

        case 18: // '\022'
            return Screen1.lambda4();

        case 19: // '\023'
            return Screen1.lambda5();

        case 20: // '\024'
            return Screen1.lambda6();

        case 21: // '\025'
            return Screen1.lambda7();

        case 22: // '\026'
            return Screen1.lambda8();

        case 23: // '\027'
            return Screen1.lambda9();

        case 24: // '\030'
            return Screen1.lambda10();

        case 25: // '\031'
            return Screen1.lambda11();

        case 26: // '\032'
            return Screen1.lambda12();

        case 27: // '\033'
            return Screen1.lambda13();

        case 28: // '\034'
            return Screen1.lambda14();

        case 29: // '\035'
            return Screen1.lambda15();

        case 30: // '\036'
            return $main.ReporteCiudadano$Click();

        case 31: // '\037'
            return Screen1.lambda16();

        case 32: // ' '
            return Screen1.lambda17();

        case 33: // '!'
            return Screen1.lambda18();

        case 34: // '"'
            return Screen1.lambda19();

        case 35: // '#'
            return $main.BotonIniciaSesion$Click();
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
        if (!(obj instanceof Screen1)) goto _L9; else goto _L8
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
            if (!(obj instanceof Screen1))
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
