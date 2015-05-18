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
//            Pautas

public class  extends ModuleBody
{

    Pautas $main;

    public Object apply0(ModuleMethod modulemethod)
    {
        switch (modulemethod.selector)
        {
        case 22: // '\026'
        case 23: // '\027'
        case 26: // '\032'
        case 27: // '\033'
        case 36: // '$'
        case 37: // '%'
        default:
            return super.apply0(modulemethod);

        case 17: // '\021'
            return Pautas.lambda2();

        case 18: // '\022'
            $main.$define();
            return Values.empty;

        case 19: // '\023'
            return Pautas.lambda3();

        case 20: // '\024'
            return Pautas.lambda4();

        case 21: // '\025'
            return Pautas.lambda5();

        case 24: // '\030'
            return Pautas.lambda7();

        case 25: // '\031'
            return Pautas.lambda9();

        case 28: // '\034'
            return Pautas.lambda11();

        case 29: // '\035'
            return Pautas.lambda13();

        case 30: // '\036'
            return Pautas.lambda14();

        case 31: // '\037'
            return Pautas.lambda15();

        case 32: // ' '
            return Pautas.lambda16();

        case 33: // '!'
            return Pautas.lambda17();

        case 34: // '"'
            return Pautas.lambda18();

        case 35: // '#'
            return Pautas.lambda19();

        case 38: // '&'
            return Pautas.lambda22();

        case 39: // '\''
            return Pautas.lambda25();

        case 40: // '('
            return Pautas.lambda26();

        case 41: // ')'
            return Pautas.lambda27();

        case 42: // '*'
            return Pautas.lambda28();

        case 43: // '+'
            return $main.Pautas$Initialize();

        case 44: // ','
            return Pautas.lambda29();

        case 45: // '-'
            return Pautas.lambda30();

        case 46: // '.'
            return Pautas.lambda31();

        case 47: // '/'
            return Pautas.lambda32();

        case 48: // '0'
            return Pautas.lambda33();

        case 49: // '1'
            return Pautas.lambda34();

        case 50: // '2'
            return Pautas.lambda35();

        case 51: // '3'
            return Pautas.lambda36();

        case 52: // '4'
            return Pautas.lambda37();

        case 53: // '5'
            return Pautas.lambda38();

        case 54: // '6'
            return $main.reportarEnfermedad$Click();
        }
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 3: // '\003'
            $main.androidLogForm(obj);
            return Values.empty;

        case 5: // '\005'
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

        case 7: // '\007'
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

        case 12: // '\f'
            $main.addToFormDoAfterCreation(obj);
            return Values.empty;

        case 13: // '\r'
            $main.sendError(obj);
            return Values.empty;

        case 14: // '\016'
            $main.processException(obj);
            return Values.empty;

        case 22: // '\026'
            return Pautas.lambda6(obj);

        case 23: // '\027'
            return Pautas.lambda8(obj);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        case 6: // '\006'
        case 7: // '\007'
        case 10: // '\n'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 4: // '\004'
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

        case 5: // '\005'
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

        case 8: // '\b'
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

        case 9: // '\t'
            $main.addToEvents(obj, obj1);
            return Values.empty;

        case 11: // '\013'
            $main.addToGlobalVars(obj, obj1);
            return Values.empty;

        case 16: // '\020'
            return $main.lookupHandler(obj, obj1);
        }
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply3(modulemethod, obj, obj1, obj2);

        case 26: // '\032'
            return Pautas.lambda10(obj, obj1, obj2);

        case 27: // '\033'
            return Pautas.lambda12(obj, obj1, obj2);

        case 36: // '$'
            return Pautas.lambda20(obj, obj1, obj2);

        case 37: // '%'
            return Pautas.lambda23(obj, obj1, obj2);
        }
    }

    public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply4(modulemethod, obj, obj1, obj2, obj3);

        case 10: // '\n'
            $main.addToComponents(obj, obj1, obj2, obj3);
            return Values.empty;

        case 15: // '\017'
            modulemethod = $main;
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

        case 55: // '7'
            return $main.Web1$GotText(obj, obj1, obj2, obj3);
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 22: // '\026'
        case 23: // '\027'
        case 26: // '\032'
        case 27: // '\033'
        case 36: // '$'
        case 37: // '%'
        default:
            return super.match0(modulemethod, callcontext);

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

        case 25: // '\031'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 24: // '\030'
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
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 23: // '\027'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 22: // '\026'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 14: // '\016'
            if (!(obj instanceof Pautas))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 13: // '\r'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 12: // '\f'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 7: // '\007'
            if (!(obj instanceof Symbol))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 5: // '\005'
            if (!(obj instanceof Symbol))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 3: // '\003'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 6: // '\006'
        case 7: // '\007'
        case 10: // '\n'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        default:
            return super.match2(modulemethod, obj, obj1, callcontext);

        case 16: // '\020'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 11: // '\013'
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

        case 8: // '\b'
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

        case 5: // '\005'
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

        case 4: // '\004'
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

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match3(modulemethod, obj, obj1, obj2, callcontext);

        case 37: // '%'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 36: // '$'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 27: // '\033'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 26: // '\032'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
    }

    public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match4(modulemethod, obj, obj1, obj2, obj3, callcontext);

        case 55: // '7'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.value4 = obj3;
            callcontext.proc = modulemethod;
            callcontext.pc = 4;
            return 0;

        case 15: // '\017'
            if (!(obj instanceof Pautas))
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

        case 10: // '\n'
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
