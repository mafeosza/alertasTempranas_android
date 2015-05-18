// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.runtime.util.BluetoothReflection;
import com.google.appinventor.components.runtime.util.YailList;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, OnDestroyListener, Deleteable, 
//            ComponentContainer, Form, BluetoothConnectionListener

public abstract class BluetoothConnectionBase extends AndroidNonvisibleComponent
    implements Component, OnDestroyListener, Deleteable
{

    private final List bluetoothConnectionListeners;
    private ByteOrder byteOrder;
    private Object connectedBluetoothSocket;
    private byte delimiter;
    private String encoding;
    private InputStream inputStream;
    protected final String logTag;
    private OutputStream outputStream;
    protected boolean secure;

    protected BluetoothConnectionBase(ComponentContainer componentcontainer, String s)
    {
        this(componentcontainer.$form(), s);
        form.registerForOnDestroy(this);
    }

    private BluetoothConnectionBase(Form form, String s)
    {
        super(form);
        bluetoothConnectionListeners = new ArrayList();
        logTag = s;
        HighByteFirst(false);
        CharacterEncoding("UTF-8");
        DelimiterByte(0);
        Secure(true);
    }

    protected BluetoothConnectionBase(OutputStream outputstream, InputStream inputstream)
    {
        this((Form)null, (String)null);
        connectedBluetoothSocket = "Not Null";
        outputStream = outputstream;
        inputStream = inputstream;
    }

    private void fireAfterConnectEvent()
    {
        for (Iterator iterator = bluetoothConnectionListeners.iterator(); iterator.hasNext(); ((BluetoothConnectionListener)iterator.next()).afterConnect(this)) { }
    }

    private void fireBeforeDisconnectEvent()
    {
        for (Iterator iterator = bluetoothConnectionListeners.iterator(); iterator.hasNext(); ((BluetoothConnectionListener)iterator.next()).beforeDisconnect(this)) { }
    }

    private void prepareToDie()
    {
        if (connectedBluetoothSocket != null)
        {
            Disconnect();
        }
    }

    public boolean Available()
    {
        return BluetoothReflection.getBluetoothAdapter() != null;
    }

    public void BluetoothError(String s, String s1)
    {
    }

    public int BytesAvailableToReceive()
    {
        if (!IsConnected())
        {
            bluetoothError("BytesAvailableToReceive", 515, new Object[0]);
            return 0;
        }
        int i;
        try
        {
            i = inputStream.available();
        }
        catch (IOException ioexception)
        {
            bluetoothError("BytesAvailableToReceive", 517, new Object[] {
                ioexception.getMessage()
            });
            return 0;
        }
        return i;
    }

    public String CharacterEncoding()
    {
        return encoding;
    }

    public void CharacterEncoding(String s)
    {
        try
        {
            "check".getBytes(s);
            encoding = s;
            return;
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            bluetoothError("CharacterEncoding", 519, new Object[] {
                s
            });
        }
    }

    public int DelimiterByte()
    {
        return delimiter;
    }

    public void DelimiterByte(int i)
    {
        byte byte0 = (byte)i;
        int j = i >> 8;
        if (j != 0 && j != -1)
        {
            bluetoothError("DelimiterByte", 511, new Object[] {
                Integer.valueOf(i)
            });
            return;
        } else
        {
            delimiter = byte0;
            return;
        }
    }

    public final void Disconnect()
    {
        if (connectedBluetoothSocket != null)
        {
            fireBeforeDisconnectEvent();
            try
            {
                BluetoothReflection.closeBluetoothSocket(connectedBluetoothSocket);
                Log.i(logTag, "Disconnected from Bluetooth device.");
            }
            catch (IOException ioexception)
            {
                Log.w(logTag, (new StringBuilder()).append("Error while disconnecting: ").append(ioexception.getMessage()).toString());
            }
            connectedBluetoothSocket = null;
        }
        inputStream = null;
        outputStream = null;
    }

    public boolean Enabled()
    {
        Object obj = BluetoothReflection.getBluetoothAdapter();
        return obj != null && BluetoothReflection.isBluetoothEnabled(obj);
    }

    public void HighByteFirst(boolean flag)
    {
        ByteOrder byteorder;
        if (flag)
        {
            byteorder = ByteOrder.BIG_ENDIAN;
        } else
        {
            byteorder = ByteOrder.LITTLE_ENDIAN;
        }
        byteOrder = byteorder;
    }

    public boolean HighByteFirst()
    {
        return byteOrder == ByteOrder.BIG_ENDIAN;
    }

    public final void Initialize()
    {
    }

    public final boolean IsConnected()
    {
        return connectedBluetoothSocket != null;
    }

    public int ReceiveSigned1ByteNumber()
    {
        byte abyte0[] = read("ReceiveSigned1ByteNumber", 1);
        if (abyte0.length != 1)
        {
            return 0;
        } else
        {
            return abyte0[0];
        }
    }

    public int ReceiveSigned2ByteNumber()
    {
        byte abyte0[] = read("ReceiveSigned2ByteNumber", 2);
        if (abyte0.length != 2)
        {
            return 0;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN)
        {
            byte byte0 = abyte0[1];
            return abyte0[0] << 8 | byte0 & 0xff;
        } else
        {
            return abyte0[0] & 0xff | abyte0[1] << 8;
        }
    }

    public long ReceiveSigned4ByteNumber()
    {
        byte abyte0[] = read("ReceiveSigned4ByteNumber", 4);
        if (abyte0.length != 4)
        {
            return 0L;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN)
        {
            return (long)(abyte0[3] & 0xff | (abyte0[2] & 0xff) << 8 | (abyte0[1] & 0xff) << 16 | abyte0[0] << 24);
        } else
        {
            return (long)(abyte0[0] & 0xff | (abyte0[1] & 0xff) << 8 | (abyte0[2] & 0xff) << 16 | abyte0[3] << 24);
        }
    }

    public List ReceiveSignedBytes(int i)
    {
        byte abyte0[] = read("ReceiveSignedBytes", i);
        ArrayList arraylist = new ArrayList();
        for (i = 0; i < abyte0.length; i++)
        {
            arraylist.add(Integer.valueOf(abyte0[i]));
        }

        return arraylist;
    }

    public String ReceiveText(int i)
    {
        byte abyte0[];
        abyte0 = read("ReceiveText", i);
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        return new String(abyte0, 0, abyte0.length - 1, encoding);
        String s = new String(abyte0, encoding);
        return s;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        Log.w(logTag, (new StringBuilder()).append("UnsupportedEncodingException: ").append(unsupportedencodingexception.getMessage()).toString());
        return new String(abyte0);
    }

    public int ReceiveUnsigned1ByteNumber()
    {
        byte abyte0[] = read("ReceiveUnsigned1ByteNumber", 1);
        if (abyte0.length != 1)
        {
            return 0;
        } else
        {
            return abyte0[0] & 0xff;
        }
    }

    public int ReceiveUnsigned2ByteNumber()
    {
        byte abyte0[] = read("ReceiveUnsigned2ByteNumber", 2);
        if (abyte0.length != 2)
        {
            return 0;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN)
        {
            byte byte0 = abyte0[1];
            return (abyte0[0] & 0xff) << 8 | byte0 & 0xff;
        } else
        {
            return abyte0[0] & 0xff | (abyte0[1] & 0xff) << 8;
        }
    }

    public long ReceiveUnsigned4ByteNumber()
    {
        byte abyte0[] = read("ReceiveUnsigned4ByteNumber", 4);
        if (abyte0.length != 4)
        {
            return 0L;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN)
        {
            return (long)abyte0[3] & 255L | ((long)abyte0[2] & 255L) << 8 | ((long)abyte0[1] & 255L) << 16 | ((long)abyte0[0] & 255L) << 24;
        } else
        {
            return (long)abyte0[0] & 255L | ((long)abyte0[1] & 255L) << 8 | ((long)abyte0[2] & 255L) << 16 | ((long)abyte0[3] & 255L) << 24;
        }
    }

    public List ReceiveUnsignedBytes(int i)
    {
        byte abyte0[] = read("ReceiveUnsignedBytes", i);
        ArrayList arraylist = new ArrayList();
        for (i = 0; i < abyte0.length; i++)
        {
            arraylist.add(Integer.valueOf(abyte0[i] & 0xff));
        }

        return arraylist;
    }

    public void Secure(boolean flag)
    {
        secure = flag;
    }

    public boolean Secure()
    {
        return secure;
    }

    public void Send1ByteNumber(String s)
    {
        byte byte0;
        int i;
        try
        {
            i = Integer.decode(s).intValue();
        }
        catch (NumberFormatException numberformatexception)
        {
            bluetoothError("Send1ByteNumber", 510, new Object[] {
                s
            });
            return;
        }
        byte0 = (byte)i;
        i >>= 8;
        if (i != 0 && i != -1)
        {
            bluetoothError("Send1ByteNumber", 511, new Object[] {
                s
            });
            return;
        } else
        {
            write("Send1ByteNumber", byte0);
            return;
        }
    }

    public void Send2ByteNumber(String s)
    {
        Object obj;
        int i;
        try
        {
            i = Integer.decode(s).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bluetoothError("Send2ByteNumber", 510, new Object[] {
                s
            });
            return;
        }
        obj = new byte[2];
        if (byteOrder == ByteOrder.BIG_ENDIAN)
        {
            obj[1] = (byte)(i & 0xff);
            i >>= 8;
            obj[0] = (byte)(i & 0xff);
        } else
        {
            obj[0] = (byte)(i & 0xff);
            i >>= 8;
            obj[1] = (byte)(i & 0xff);
        }
        i >>= 8;
        if (i != 0 && i != -1)
        {
            bluetoothError("Send2ByteNumber", 512, new Object[] {
                s, Integer.valueOf(2)
            });
            return;
        } else
        {
            write("Send2ByteNumber", ((byte []) (obj)));
            return;
        }
    }

    public void Send4ByteNumber(String s)
    {
        Object obj;
        long l;
        try
        {
            l = Long.decode(s).longValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bluetoothError("Send4ByteNumber", 510, new Object[] {
                s
            });
            return;
        }
        obj = new byte[4];
        if (byteOrder == ByteOrder.BIG_ENDIAN)
        {
            obj[3] = (byte)(int)(l & 255L);
            l >>= 8;
            obj[2] = (byte)(int)(l & 255L);
            l >>= 8;
            obj[1] = (byte)(int)(l & 255L);
            l >>= 8;
            obj[0] = (byte)(int)(l & 255L);
        } else
        {
            obj[0] = (byte)(int)(l & 255L);
            l >>= 8;
            obj[1] = (byte)(int)(l & 255L);
            l >>= 8;
            obj[2] = (byte)(int)(l & 255L);
            l >>= 8;
            obj[3] = (byte)(int)(l & 255L);
        }
        l >>= 8;
        if (l != 0L && l != -1L)
        {
            bluetoothError("Send4ByteNumber", 512, new Object[] {
                s, Integer.valueOf(4)
            });
            return;
        } else
        {
            write("Send4ByteNumber", ((byte []) (obj)));
            return;
        }
    }

    public void SendBytes(YailList yaillist)
    {
        yaillist = ((YailList) (yaillist.toArray()));
        byte abyte0[] = new byte[yaillist.length];
        for (int i = 0; i < yaillist.length; i++)
        {
            String s = yaillist[i].toString();
            int j;
            try
            {
                j = Integer.decode(s).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (YailList yaillist)
            {
                bluetoothError("SendBytes", 513, new Object[] {
                    Integer.valueOf(i + 1)
                });
                return;
            }
            abyte0[i] = (byte)(j & 0xff);
            j >>= 8;
            if (j != 0 && j != -1)
            {
                bluetoothError("SendBytes", 514, new Object[] {
                    Integer.valueOf(i + 1)
                });
                return;
            }
        }

        write("SendBytes", abyte0);
    }

    public void SendText(String s)
    {
        byte abyte0[] = s.getBytes(encoding);
        s = abyte0;
_L2:
        write("SendText", s);
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        Log.w(logTag, (new StringBuilder()).append("UnsupportedEncodingException: ").append(unsupportedencodingexception.getMessage()).toString());
        s = s.getBytes();
        if (true) goto _L2; else goto _L1
_L1:
    }

    void addBluetoothConnectionListener(BluetoothConnectionListener bluetoothconnectionlistener)
    {
        bluetoothConnectionListeners.add(bluetoothconnectionlistener);
    }

    protected transient void bluetoothError(String s, int i, Object aobj[])
    {
        form.dispatchErrorOccurredEvent(this, s, i, aobj);
    }

    public void onDelete()
    {
        prepareToDie();
    }

    public void onDestroy()
    {
        prepareToDie();
    }

    protected final byte[] read(String s, int i)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        if (!IsConnected())
        {
            bluetoothError(s, 515, new Object[0]);
            return new byte[0];
        }
        bytearrayoutputstream = new ByteArrayOutputStream();
        if (i < 0) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        int j;
        abyte0 = new byte[i];
        j = 0;
_L7:
        if (j >= i) goto _L4; else goto _L3
_L3:
        int k = inputStream.read(abyte0, j, abyte0.length - j);
        if (k != -1) goto _L6; else goto _L5
_L5:
        try
        {
            bluetoothError(s, 518, new Object[0]);
        }
        catch (IOException ioexception1)
        {
            bluetoothError(s, 517, new Object[] {
                ioexception1.getMessage()
            });
        }
_L4:
        bytearrayoutputstream.write(abyte0, 0, j);
_L8:
        return bytearrayoutputstream.toByteArray();
_L6:
        j += k;
          goto _L7
_L2:
        i = inputStream.read();
        if (i == -1)
        {
            try
            {
                bluetoothError(s, 518, new Object[0]);
            }
            catch (IOException ioexception)
            {
                bluetoothError(s, 517, new Object[] {
                    ioexception.getMessage()
                });
            }
            break; /* Loop/switch isn't completed */
        }
        bytearrayoutputstream.write(i);
        j = delimiter;
        if (i != j) goto _L2; else goto _L8
    }

    void removeBluetoothConnectionListener(BluetoothConnectionListener bluetoothconnectionlistener)
    {
        bluetoothConnectionListeners.remove(bluetoothconnectionlistener);
    }

    protected final void setConnection(Object obj)
        throws IOException
    {
        connectedBluetoothSocket = obj;
        inputStream = new BufferedInputStream(BluetoothReflection.getInputStream(connectedBluetoothSocket));
        outputStream = new BufferedOutputStream(BluetoothReflection.getOutputStream(connectedBluetoothSocket));
        fireAfterConnectEvent();
    }

    protected void write(String s, byte byte0)
    {
        if (!IsConnected())
        {
            bluetoothError(s, 515, new Object[0]);
            return;
        }
        try
        {
            outputStream.write(byte0);
            outputStream.flush();
            return;
        }
        catch (IOException ioexception)
        {
            bluetoothError(s, 516, new Object[] {
                ioexception.getMessage()
            });
        }
    }

    protected void write(String s, byte abyte0[])
    {
        if (!IsConnected())
        {
            bluetoothError(s, 515, new Object[0]);
            return;
        }
        try
        {
            outputStream.write(abyte0);
            outputStream.flush();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            bluetoothError(s, 516, new Object[] {
                abyte0.getMessage()
            });
        }
    }
}
