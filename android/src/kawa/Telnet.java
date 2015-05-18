// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

// Referenced classes of package kawa:
//            TelnetOutputStream, TelnetInputStream

public class Telnet
    implements Runnable
{

    public static final int DO = 253;
    public static final int DONT = 254;
    public static final int ECHO = 1;
    static final int EOF = 236;
    static final int IAC = 255;
    static final int IP = 244;
    static final int LINEMODE = 34;
    static final int NAWS = 31;
    static final int NOP = 241;
    static final int OPTION_NO = 0;
    static final int OPTION_WANTNO = 1;
    static final int OPTION_WANTNO_OPPOSITE = 2;
    static final int OPTION_WANTYES = 3;
    static final int OPTION_WANTYES_OPPOSITE = 4;
    static final int OPTION_YES = 5;
    static final int SB = 250;
    static final int SE = 240;
    public static final int SUPPRESS_GO_AHEAD = 3;
    static final int TM = 6;
    static final int TTYPE = 24;
    public static final int WILL = 251;
    public static final int WONT = 252;
    TelnetInputStream in;
    boolean isServer;
    final byte optionsState[] = new byte[256];
    TelnetOutputStream out;
    final byte preferredLineMode = 3;
    InputStream sin;
    OutputStream sout;
    public byte terminalType[];
    public short windowHeight;
    public short windowWidth;

    public Telnet(Socket socket, boolean flag)
        throws IOException
    {
        sin = socket.getInputStream();
        sout = socket.getOutputStream();
        out = new TelnetOutputStream(sout);
        in = new TelnetInputStream(sin, this);
        isServer = flag;
    }

    public static void main(String args[])
    {
        Object obj;
        int i;
        if (args.length == 0)
        {
            usage();
        }
        obj = args[0];
        i = 23;
        if (args.length > 1)
        {
            i = Integer.parseInt(args[1]);
        }
        byte abyte0[];
        obj = new Telnet(new Socket(((String) (obj)), i), false);
        args = ((Telnet) (obj)).getOutputStream();
        obj = new Thread(((Runnable) (obj)));
        ((Thread) (obj)).setPriority(Thread.currentThread().getPriority() + 1);
        ((Thread) (obj)).start();
        abyte0 = new byte[1024];
_L1:
        i = System.in.read();
        if (i < 0)
        {
            int j;
            try
            {
                ((Thread) (obj)).stop();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String args[])
            {
                System.err.println(args);
            }
            break MISSING_BLOCK_LABEL_167;
        }
        abyte0[0] = (byte)i;
        i = System.in.available();
        j = i;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        j = i;
        if (i > abyte0.length - 1)
        {
            j = abyte0.length - 1;
        }
        j = System.in.read(abyte0, 1, j);
        args.write(abyte0, 0, j + 1);
          goto _L1
    }

    static void usage()
    {
        System.err.println("Usage:  [java] kawa.Telnet HOST [PORT#]");
        System.exit(-1);
    }

    boolean change(int i, int j)
    {
_L2:
        return true;
        if (j == 6 || isServer && j == 31) goto _L2; else goto _L1
_L1:
        if (isServer && i == 251 && j == 34)
        {
            try
            {
                out.writeSubCommand(34, new byte[] {
                    1, 3
                });
            }
            catch (IOException ioexception)
            {
                return true;
            }
            return true;
        }
        if (isServer && i == 251 && j == 24)
        {
            try
            {
                out.writeSubCommand(j, new byte[] {
                    1
                });
            }
            catch (IOException ioexception1)
            {
                return true;
            }
            return true;
        }
        if (isServer || j != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (i == 253)
        {
            return false;
        }
        if (i == 251) goto _L2; else goto _L3
_L3:
        return false;
    }

    public TelnetInputStream getInputStream()
    {
        return in;
    }

    public TelnetOutputStream getOutputStream()
    {
        return out;
    }

    void handle(int i, int j)
        throws IOException
    {
        byte byte1;
        boolean flag;
        char c;
        boolean flag1;
        char c1;
        flag1 = true;
        c = '\376';
        c1 = '\375';
        byte byte2;
        if (i < 253)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((i & 1) == 0)
        {
            flag1 = false;
        }
        byte2 = optionsState[j];
        byte1 = byte2;
        if (flag)
        {
            byte1 = (byte)(byte2 >> 3);
        }
        byte1 >> 3 & 7;
        JVM INSTR tableswitch 0 5: default 100
    //                   0 194
    //                   1 279
    //                   2 284
    //                   3 321
    //                   4 347
    //                   5 144;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L6:
        break MISSING_BLOCK_LABEL_347;
_L1:
        i = byte1;
_L10:
        byte byte0;
        TelnetOutputStream telnetoutputstream;
        if (flag)
        {
            byte0 = (byte)(optionsState[j] & 0xc7 | i << 3);
        } else
        {
            byte0 = (byte)(optionsState[j] & 0xf8 | i);
        }
        optionsState[j] = byte0;
_L9:
        return;
_L7:
        if (flag1) goto _L9; else goto _L8
_L8:
        byte1 = 0;
        change(i, j);
        telnetoutputstream = out;
        if (flag)
        {
            i = 254;
        } else
        {
            i = 252;
        }
        telnetoutputstream.writeCommand(i, j);
        i = byte1;
          goto _L10
_L2:
        if (!flag1) goto _L9; else goto _L11
_L11:
        if (change(i, j))
        {
            byte1 = 5;
            telnetoutputstream = out;
            if (flag)
            {
                i = 253;
            } else
            {
                i = 251;
            }
            telnetoutputstream.writeCommand(i, j);
            i = byte1;
        } else
        {
            telnetoutputstream = out;
            if (!flag)
            {
                c = '\374';
            }
            telnetoutputstream.writeCommand(c, j);
            i = byte1;
        }
          goto _L10
_L3:
        i = 0;
          goto _L10
_L4:
        byte1 = 3;
        telnetoutputstream = out;
        if (flag)
        {
            i = c1;
        } else
        {
            i = 251;
        }
        telnetoutputstream.writeCommand(i, j);
        i = byte1;
          goto _L10
_L5:
        if (flag1)
        {
            byte1 = 5;
            change(i, j);
            i = byte1;
        } else
        {
            i = 0;
        }
          goto _L10
        if (flag1)
        {
            i = 1;
            telnetoutputstream = out;
            if (!flag)
            {
                c = '\374';
            }
            telnetoutputstream.writeCommand(c, j);
        } else
        {
            i = 0;
        }
          goto _L10
    }

    public void request(int i, int j)
        throws IOException
    {
        byte byte1;
        byte byte2;
        boolean flag1;
        flag1 = true;
        boolean flag;
        if (i >= 253)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((i & 1) == 0)
        {
            flag1 = false;
        }
        byte2 = optionsState[j];
        byte1 = byte2;
        if (flag)
        {
            byte1 = (byte)(byte2 >> 3);
        }
        byte2 = byte1;
        byte1 & 7;
        JVM INSTR tableswitch 0 5: default 92
    //                   0 134
    //                   1 174
    //                   2 185
    //                   3 196
    //                   4 208
    //                   5 154;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_208;
_L8:
        byte byte0;
        if (flag)
        {
            byte0 = (byte)(optionsState[j] & 0xc7 | byte1 << 3);
        } else
        {
            byte0 = (byte)(optionsState[j] & 0xf8 | byte1);
        }
        optionsState[j] = byte0;
        return;
_L2:
        if (flag1)
        {
            byte1 = 3;
            out.writeCommand(i, j);
        }
          goto _L8
_L7:
        if (!flag1)
        {
            byte1 = 1;
            out.writeCommand(i, j);
        }
          goto _L8
_L3:
        if (flag1)
        {
            byte1 = 2;
        }
          goto _L8
_L4:
        if (!flag1)
        {
            byte1 = 1;
        }
          goto _L8
_L5:
        byte2 = byte1;
        if (!flag1)
        {
            byte2 = 4;
        }
        byte1 = byte2;
        if (flag1)
        {
            byte1 = 3;
        }
          goto _L8
    }

    public void run()
    {
        TelnetInputStream telnetinputstream;
        byte abyte0[];
        telnetinputstream = getInputStream();
        abyte0 = new byte[1024];
_L1:
        int i = telnetinputstream.read();
        if (i < 0)
        {
            return;
        }
        abyte0[0] = (byte)i;
        int j;
        try
        {
            i = telnetinputstream.available();
        }
        catch (IOException ioexception)
        {
            System.err.println(ioexception);
            System.exit(-1);
            return;
        }
        j = i;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        j = i;
        if (i > abyte0.length - 1)
        {
            j = abyte0.length - 1;
        }
        j = telnetinputstream.read(abyte0, 1, j);
        System.out.write(abyte0, 0, j + 1);
          goto _L1
    }

    public void subCommand(byte abyte0[], int i, int j)
    {
        abyte0[i];
        JVM INSTR lookupswitch 3: default 36
    //                   24: 81
    //                   31: 37
    //                   34: 144;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L3:
        if (j == 5)
        {
            windowWidth = (short)((abyte0[1] << 8) + (abyte0[2] & 0xff));
            windowHeight = (short)((abyte0[3] << 8) + (abyte0[4] & 0xff));
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        byte abyte1[] = new byte[j - 1];
        System.arraycopy(abyte0, 1, abyte1, 0, j - 1);
        terminalType = abyte1;
        System.err.println((new StringBuilder()).append("terminal type: '").append(new String(abyte1)).append("'").toString());
        return;
_L4:
        System.err.println((new StringBuilder()).append("SBCommand LINEMODE ").append(abyte0[1]).append(" len:").append(j).toString());
        if (abyte0[1] == 3)
        {
            i = 2;
            while (i + 2 < j) 
            {
                System.err.println((new StringBuilder()).append("  ").append(abyte0[i]).append(",").append(abyte0[i + 1]).append(",").append(abyte0[i + 2]).toString());
                i += 3;
            }
        }
        if (true) goto _L1; else goto _L5
_L5:
    }
}
