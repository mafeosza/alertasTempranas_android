// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.YailList;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.appinventor.components.runtime:
//            LegoMindstormsNxtBase, Form, ComponentContainer

public class NxtDirectCommands extends LegoMindstormsNxtBase
{

    public NxtDirectCommands(ComponentContainer componentcontainer)
    {
        super(componentcontainer, "NxtDirectCommands");
    }

    private void closeHandle(String s, int i)
    {
        byte abyte0[] = new byte[3];
        abyte0[0] = 1;
        abyte0[1] = -124;
        copyUBYTEValueToBytes(i, abyte0, 2);
        evaluateStatus(s, sendCommandAndReceiveReturnPackage(s, abyte0), abyte0[1]);
    }

    private byte[] getOutputState(String s, int i)
    {
        byte abyte0[] = new byte[3];
        abyte0[0] = 0;
        abyte0[1] = 6;
        copyUBYTEValueToBytes(i, abyte0, 2);
        byte abyte1[] = sendCommandAndReceiveReturnPackage(s, abyte0);
        if (evaluateStatus(s, abyte1, abyte0[1]))
        {
            if (abyte1.length == 25)
            {
                return abyte1;
            }
            Log.w(logTag, (new StringBuilder()).append(s).append(": unexpected return package length ").append(abyte1.length).append(" (expected 25)").toString());
        }
        return null;
    }

    private Integer openWrite(String s, String s1, long l)
    {
        byte abyte0[] = new byte[26];
        abyte0[0] = 1;
        abyte0[1] = -127;
        copyStringValueToBytes(s1, abyte0, 2, 19);
        copyULONGValueToBytes(l, abyte0, 22);
        s1 = sendCommandAndReceiveReturnPackage(s, abyte0);
        if (evaluateStatus(s, s1, abyte0[1]))
        {
            if (s1.length == 4)
            {
                return Integer.valueOf(getUBYTEValueFromBytes(s1, 3));
            }
            Log.w(logTag, (new StringBuilder()).append(s).append(": unexpected return package length ").append(s1.length).append(" (expected 4)").toString());
        }
        return null;
    }

    private Integer openWriteLinear(String s, String s1, long l)
    {
        byte abyte0[] = new byte[26];
        abyte0[0] = 1;
        abyte0[1] = -119;
        copyStringValueToBytes(s1, abyte0, 2, 19);
        copyULONGValueToBytes(l, abyte0, 22);
        s1 = sendCommandAndReceiveReturnPackage(s, abyte0);
        if (evaluateStatus(s, s1, abyte0[1]))
        {
            if (s1.length == 4)
            {
                return Integer.valueOf(getUBYTEValueFromBytes(s1, 3));
            }
            Log.w(logTag, (new StringBuilder()).append(s).append(": unexpected return package length ").append(s1.length).append(" (expected 4)").toString());
        }
        return null;
    }

    private int writeChunk(String s, int i, byte abyte0[], int j)
        throws IOException
    {
        int k = 0;
        if (j > 32)
        {
            throw new IllegalArgumentException("length must be <= 32");
        }
        byte abyte1[] = new byte[j + 3];
        abyte1[0] = 1;
        abyte1[1] = -125;
        copyUBYTEValueToBytes(i, abyte1, 2);
        System.arraycopy(abyte0, 0, abyte1, 3, j);
        abyte0 = sendCommandAndReceiveReturnPackage(s, abyte1);
        i = k;
        if (evaluateStatus(s, abyte0, abyte1[1]))
        {
            if (abyte0.length == 6)
            {
                k = getUWORDValueFromBytes(abyte0, 4);
                i = k;
                if (k != j)
                {
                    Log.e(logTag, (new StringBuilder()).append(s).append(": only ").append(k).append(" bytes were written ").append("(expected ").append(j).append(")").toString());
                    throw new IOException("Unable to write file on robot");
                }
            } else
            {
                Log.w(logTag, (new StringBuilder()).append(s).append(": unexpected return package length ").append(abyte0.length).append(" (expected 6)").toString());
                i = k;
            }
        }
        return i;
    }

    public void DeleteFile(String s)
    {
        if (!checkBluetooth("DeleteFile"))
        {
            return;
        }
        if (s.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "DeleteFile", 406, new Object[0]);
            return;
        } else
        {
            byte abyte0[] = new byte[22];
            abyte0[0] = 1;
            abyte0[1] = -123;
            copyStringValueToBytes(s, abyte0, 2, 19);
            evaluateStatus("DeleteFile", sendCommandAndReceiveReturnPackage("DeleteFile", abyte0), abyte0[1]);
            return;
        }
    }

    public void DownloadFile(String s, String s1)
    {
        if (!checkBluetooth("DownloadFile"))
        {
            return;
        }
        if (s.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "DownloadFile", 414, new Object[0]);
            return;
        }
        if (s1.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "DownloadFile", 415, new Object[0]);
            return;
        }
        File file = MediaUtil.copyMediaToTempFile(form, s);
        BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(file), 1024);
        long l1;
        l1 = file.length();
        if (!s1.endsWith(".rxe") && !s1.endsWith(".ric"))
        {
            break MISSING_BLOCK_LABEL_164;
        }
        s = openWriteLinear("DownloadFile", s1, l1);
_L1:
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        bufferedinputstream.close();
        try
        {
            file.delete();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            form.dispatchErrorOccurredEvent(this, "DownloadFile", 416, new Object[] {
                s.getMessage()
            });
        }
        return;
        s = openWrite("DownloadFile", s1, l1);
          goto _L1
        s1 = new byte[32];
        long l = 0L;
_L3:
        if (l >= l1)
        {
            break; /* Loop/switch isn't completed */
        }
        int i;
        i = (int)Math.min(32L, l1 - l);
        bufferedinputstream.read(s1, 0, i);
        i = writeChunk("DownloadFile", s.intValue(), s1, i);
        l += i;
        if (true) goto _L3; else goto _L2
_L2:
        closeHandle("DownloadFile", s.intValue());
        bufferedinputstream.close();
        file.delete();
        return;
        s1;
        closeHandle("DownloadFile", s.intValue());
        throw s1;
        s;
        bufferedinputstream.close();
        throw s;
        s;
        file.delete();
        throw s;
    }

    public int GetBatteryLevel()
    {
        if (checkBluetooth("GetBatteryLevel"))
        {
            byte abyte0[] = new byte[2];
            abyte0[0] = 0;
            abyte0[1] = 11;
            byte abyte1[] = sendCommandAndReceiveReturnPackage("GetBatteryLevel", abyte0);
            if (evaluateStatus("GetBatteryLevel", abyte1, abyte0[1]))
            {
                if (abyte1.length == 5)
                {
                    return getUWORDValueFromBytes(abyte1, 3);
                } else
                {
                    Log.w(logTag, (new StringBuilder()).append("GetBatteryLevel: unexpected return package length ").append(abyte1.length).append(" (expected 5)").toString());
                    return 0;
                }
            }
        }
        return 0;
    }

    public String GetBrickName()
    {
        if (!checkBluetooth("GetBrickName"))
        {
            return "";
        }
        byte abyte0[] = new byte[2];
        abyte0[0] = 1;
        abyte0[1] = -101;
        byte abyte1[] = sendCommandAndReceiveReturnPackage("GetBrickName", abyte0);
        if (evaluateStatus("GetBrickName", abyte1, abyte0[1]))
        {
            return getStringValueFromBytes(abyte1, 3);
        } else
        {
            return "";
        }
    }

    public String GetCurrentProgramName()
    {
        if (!checkBluetooth("GetCurrentProgramName"))
        {
            return "";
        }
        byte abyte0[] = new byte[2];
        abyte0[0] = 0;
        abyte0[1] = 17;
        byte abyte1[] = sendCommandAndReceiveReturnPackage("GetCurrentProgramName", abyte0);
        int i = getStatus("GetCurrentProgramName", abyte1, abyte0[1]);
        if (i == 0)
        {
            return getStringValueFromBytes(abyte1, 3);
        }
        if (i == 236)
        {
            return "";
        } else
        {
            evaluateStatus("GetCurrentProgramName", abyte1, abyte0[1]);
            return "";
        }
    }

    public List GetFirmwareVersion()
    {
        if (!checkBluetooth("GetFirmwareVersion"))
        {
            return new ArrayList();
        }
        byte abyte1[] = new byte[2];
        abyte1[0] = 1;
        abyte1[1] = -120;
        byte abyte0[] = sendCommandAndReceiveReturnPackage("GetFirmwareVersion", abyte1);
        if (evaluateStatus("GetFirmwareVersion", abyte0, abyte1[1]))
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add((new StringBuilder()).append(abyte0[6]).append(".").append(abyte0[5]).toString());
            arraylist.add((new StringBuilder()).append(abyte0[4]).append(".").append(abyte0[3]).toString());
            return arraylist;
        } else
        {
            return new ArrayList();
        }
    }

    public List GetInputValues(String s)
    {
        if (!checkBluetooth("GetInputValues"))
        {
            return new ArrayList();
        }
        int i;
        try
        {
            i = convertSensorPortLetterToNumber(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            form.dispatchErrorOccurredEvent(this, "GetInputValues", 408, new Object[] {
                s
            });
            return new ArrayList();
        }
        s = getInputValues("GetInputValues", i);
        if (s != null)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(Boolean.valueOf(getBooleanValueFromBytes(s, 4)));
            arraylist.add(Boolean.valueOf(getBooleanValueFromBytes(s, 5)));
            arraylist.add(Integer.valueOf(getUBYTEValueFromBytes(s, 6)));
            arraylist.add(Integer.valueOf(getUBYTEValueFromBytes(s, 7)));
            arraylist.add(Integer.valueOf(getUWORDValueFromBytes(s, 8)));
            arraylist.add(Integer.valueOf(getUWORDValueFromBytes(s, 10)));
            arraylist.add(Integer.valueOf(getSWORDValueFromBytes(s, 12)));
            arraylist.add(Integer.valueOf(getSWORDValueFromBytes(s, 14)));
            return arraylist;
        } else
        {
            return new ArrayList();
        }
    }

    public List GetOutputState(String s)
    {
        if (!checkBluetooth("GetOutputState"))
        {
            return new ArrayList();
        }
        int i;
        try
        {
            i = convertMotorPortLetterToNumber(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            form.dispatchErrorOccurredEvent(this, "GetOutputState", 407, new Object[] {
                s
            });
            return new ArrayList();
        }
        s = getOutputState("GetOutputState", i);
        if (s != null)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(Integer.valueOf(getSBYTEValueFromBytes(s, 4)));
            arraylist.add(Integer.valueOf(getUBYTEValueFromBytes(s, 5)));
            arraylist.add(Integer.valueOf(getUBYTEValueFromBytes(s, 6)));
            arraylist.add(Integer.valueOf(getSBYTEValueFromBytes(s, 7)));
            arraylist.add(Integer.valueOf(getUBYTEValueFromBytes(s, 8)));
            arraylist.add(Long.valueOf(getULONGValueFromBytes(s, 9)));
            arraylist.add(Integer.valueOf(getSLONGValueFromBytes(s, 13)));
            arraylist.add(Integer.valueOf(getSLONGValueFromBytes(s, 17)));
            arraylist.add(Integer.valueOf(getSLONGValueFromBytes(s, 21)));
            return arraylist;
        } else
        {
            return new ArrayList();
        }
    }

    public long KeepAlive()
    {
        if (checkBluetooth("KeepAlive"))
        {
            byte abyte0[] = new byte[2];
            abyte0[0] = 0;
            abyte0[1] = 13;
            byte abyte1[] = sendCommandAndReceiveReturnPackage("KeepAlive", abyte0);
            if (evaluateStatus("KeepAlive", abyte1, abyte0[1]))
            {
                if (abyte1.length == 7)
                {
                    return getULONGValueFromBytes(abyte1, 3);
                } else
                {
                    Log.w(logTag, (new StringBuilder()).append("KeepAlive: unexpected return package length ").append(abyte1.length).append(" (expected 7)").toString());
                    return 0L;
                }
            }
        }
        return 0L;
    }

    public List ListFiles(String s)
    {
        if (checkBluetooth("ListFiles")) goto _L2; else goto _L1
_L1:
        s = new ArrayList();
_L4:
        return s;
_L2:
        ArrayList arraylist = new ArrayList();
        String s1 = s;
        if (s.length() == 0)
        {
            s1 = "*.*";
        }
        s = new byte[22];
        s[0] = 1;
        s[1] = -122;
        copyStringValueToBytes(s1, s, 2, 19);
        byte abyte0[] = sendCommandAndReceiveReturnPackage("ListFiles", s);
        int i = getStatus("ListFiles", abyte0, s[1]);
        do
        {
            s = arraylist;
            if (i != 0)
            {
                continue;
            }
            i = getUBYTEValueFromBytes(abyte0, 3);
            arraylist.add(getStringValueFromBytes(abyte0, 4));
            s = new byte[3];
            s[0] = 1;
            s[1] = -121;
            copyUBYTEValueToBytes(i, s, 2);
            abyte0 = sendCommandAndReceiveReturnPackage("ListFiles", s);
            i = getStatus("ListFiles", abyte0, s[1]);
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int LsGetStatus(String s)
    {
        if (!checkBluetooth("LsGetStatus"))
        {
            return 0;
        }
        int i;
        try
        {
            i = convertSensorPortLetterToNumber(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            form.dispatchErrorOccurredEvent(this, "LsGetStatus", 408, new Object[] {
                s
            });
            return 0;
        }
        return lsGetStatus("LsGetStatus", i);
    }

    public List LsRead(String s)
    {
        if (checkBluetooth("LsRead")) goto _L2; else goto _L1
_L1:
        s = new ArrayList();
_L4:
        return s;
_L2:
label0:
        {
            ArrayList arraylist;
            byte abyte0[];
            int i;
            int j;
            try
            {
                i = convertSensorPortLetterToNumber(s);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                form.dispatchErrorOccurredEvent(this, "LsRead", 408, new Object[] {
                    s
                });
                return new ArrayList();
            }
            abyte0 = lsRead("LsRead", i);
            if (abyte0 == null)
            {
                break label0;
            }
            arraylist = new ArrayList();
            j = getUBYTEValueFromBytes(abyte0, 3);
            i = 0;
            do
            {
                s = arraylist;
                if (i >= j)
                {
                    break;
                }
                arraylist.add(Integer.valueOf(abyte0[i + 4] & 0xff));
                i++;
            } while (true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        return new ArrayList();
    }

    public void LsWrite(String s, YailList yaillist, int i)
    {
        if (!checkBluetooth("LsWrite"))
        {
            return;
        }
        int k;
        try
        {
            k = convertSensorPortLetterToNumber(s);
        }
        // Misplaced declaration of an exception variable
        catch (YailList yaillist)
        {
            form.dispatchErrorOccurredEvent(this, "LsWrite", 408, new Object[] {
                s
            });
            return;
        }
        if (yaillist.size() > 16)
        {
            form.dispatchErrorOccurredEvent(this, "LsWrite", 411, new Object[0]);
            return;
        }
        s = ((String) (yaillist.toArray()));
        yaillist = new byte[s.length];
        for (int j = 0; j < s.length; j++)
        {
            String s1 = s[j].toString();
            int l;
            try
            {
                l = Integer.decode(s1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                form.dispatchErrorOccurredEvent(this, "LsWrite", 412, new Object[] {
                    Integer.valueOf(j + 1)
                });
                return;
            }
            yaillist[j] = (byte)(l & 0xff);
            l >>= 8;
            if (l != 0 && l != -1)
            {
                form.dispatchErrorOccurredEvent(this, "LsWrite", 413, new Object[] {
                    Integer.valueOf(j + 1)
                });
                return;
            }
        }

        lsWrite("LsWrite", k, yaillist, i);
    }

    public String MessageRead(int i)
    {
        if (!checkBluetooth("MessageRead"))
        {
            return "";
        }
        if (i < 1 || i > 10)
        {
            form.dispatchErrorOccurredEvent(this, "MessageRead", 409, new Object[] {
                Integer.valueOf(i)
            });
            return "";
        }
        i--;
        byte abyte0[] = new byte[5];
        abyte0[0] = 0;
        abyte0[1] = 19;
        copyUBYTEValueToBytes(0, abyte0, 2);
        copyUBYTEValueToBytes(i, abyte0, 3);
        copyBooleanValueToBytes(true, abyte0, 4);
        byte abyte1[] = sendCommandAndReceiveReturnPackage("MessageRead", abyte0);
        if (evaluateStatus("MessageRead", abyte1, abyte0[1]))
        {
            if (abyte1.length == 64)
            {
                int j = getUBYTEValueFromBytes(abyte1, 3);
                if (j != i)
                {
                    Log.w(logTag, (new StringBuilder()).append("MessageRead: unexpected return mailbox: ").append(j).append(" (expected ").append(i).append(")").toString());
                }
                return getStringValueFromBytes(abyte1, 5, getUBYTEValueFromBytes(abyte1, 4) - 1);
            }
            Log.w(logTag, (new StringBuilder()).append("MessageRead: unexpected return package length ").append(abyte1.length).append(" (expected 64)").toString());
        }
        return "";
    }

    public void MessageWrite(int i, String s)
    {
        if (!checkBluetooth("MessageWrite"))
        {
            return;
        }
        if (i < 1 || i > 10)
        {
            form.dispatchErrorOccurredEvent(this, "MessageWrite", 409, new Object[] {
                Integer.valueOf(i)
            });
            return;
        }
        int j = s.length();
        if (j > 58)
        {
            form.dispatchErrorOccurredEvent(this, "MessageWrite", 410, new Object[0]);
            return;
        } else
        {
            byte abyte0[] = new byte[j + 4 + 1];
            abyte0[0] = -128;
            abyte0[1] = 9;
            copyUBYTEValueToBytes(i - 1, abyte0, 2);
            copyUBYTEValueToBytes(j + 1, abyte0, 3);
            copyStringValueToBytes(s, abyte0, 4, j);
            sendCommand("MessageWrite", abyte0);
            return;
        }
    }

    public void PlaySoundFile(String s)
    {
        if (!checkBluetooth("PlaySoundFile"))
        {
            return;
        }
        if (s.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "PlaySoundFile", 406, new Object[0]);
            return;
        }
        String s1 = s;
        if (s.indexOf(".") == -1)
        {
            s1 = (new StringBuilder()).append(s).append(".rso").toString();
        }
        s = new byte[23];
        s[0] = -128;
        s[1] = 2;
        copyBooleanValueToBytes(false, s, 2);
        copyStringValueToBytes(s1, s, 3, 19);
        sendCommand("PlaySoundFile", s);
    }

    public void PlayTone(int i, int j)
    {
        if (!checkBluetooth("PlayTone"))
        {
            return;
        }
        int k = i;
        if (i < 200)
        {
            Log.w(logTag, (new StringBuilder()).append("frequencyHz ").append(i).append(" is invalid, using 200.").toString());
            k = 200;
        }
        i = k;
        if (k > 14000)
        {
            Log.w(logTag, (new StringBuilder()).append("frequencyHz ").append(k).append(" is invalid, using 14000.").toString());
            i = 14000;
        }
        byte abyte0[] = new byte[6];
        abyte0[0] = -128;
        abyte0[1] = 3;
        copyUWORDValueToBytes(i, abyte0, 2);
        copyUWORDValueToBytes(j, abyte0, 4);
        sendCommand("PlayTone", abyte0);
    }

    public void ResetInputScaledValue(String s)
    {
        if (!checkBluetooth("ResetInputScaledValue"))
        {
            return;
        }
        int i;
        try
        {
            i = convertSensorPortLetterToNumber(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            form.dispatchErrorOccurredEvent(this, "ResetInputScaledValue", 408, new Object[] {
                s
            });
            return;
        }
        resetInputScaledValue("ResetInputScaledValue", i);
        s = new byte[3];
        s[0] = -128;
        s[1] = 8;
        copyUBYTEValueToBytes(i, s, 2);
        sendCommand("ResetInputScaledValue", s);
    }

    public void ResetMotorPosition(String s, boolean flag)
    {
        if (!checkBluetooth("ResetMotorPosition"))
        {
            return;
        }
        int i;
        try
        {
            i = convertMotorPortLetterToNumber(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            form.dispatchErrorOccurredEvent(this, "ResetMotorPosition", 407, new Object[] {
                s
            });
            return;
        }
        s = new byte[4];
        s[0] = -128;
        s[1] = 10;
        copyUBYTEValueToBytes(i, s, 2);
        copyBooleanValueToBytes(flag, s, 3);
        sendCommand("ResetMotorPosition", s);
    }

    public void SetBrickName(String s)
    {
        if (!checkBluetooth("SetBrickName"))
        {
            return;
        } else
        {
            byte abyte0[] = new byte[18];
            abyte0[0] = 1;
            abyte0[1] = -104;
            copyStringValueToBytes(s, abyte0, 2, 15);
            evaluateStatus("SetBrickName", sendCommandAndReceiveReturnPackage("SetBrickName", abyte0), abyte0[1]);
            return;
        }
    }

    public void SetInputMode(String s, int i, int j)
    {
        if (!checkBluetooth("SetInputMode"))
        {
            return;
        }
        int k;
        try
        {
            k = convertSensorPortLetterToNumber(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            form.dispatchErrorOccurredEvent(this, "SetInputMode", 408, new Object[] {
                s
            });
            return;
        }
        setInputMode("SetInputMode", k, i, j);
    }

    public void SetOutputState(String s, int i, int j, int k, int l, int i1, long l1)
    {
        if (!checkBluetooth("SetOutputState"))
        {
            return;
        }
        int j1;
        try
        {
            j1 = convertMotorPortLetterToNumber(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            form.dispatchErrorOccurredEvent(this, "SetOutputState", 407, new Object[] {
                s
            });
            return;
        }
        setOutputState("SetOutputState", j1, i, j, k, sanitizeTurnRatio(l), i1, l1);
    }

    public void StartProgram(String s)
    {
        if (!checkBluetooth("StartProgram"))
        {
            return;
        }
        if (s.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "StartProgram", 405, new Object[0]);
            return;
        }
        String s1 = s;
        if (s.indexOf(".") == -1)
        {
            s1 = (new StringBuilder()).append(s).append(".rxe").toString();
        }
        s = new byte[22];
        s[0] = -128;
        s[1] = 0;
        copyStringValueToBytes(s1, s, 2, 19);
        sendCommand("StartProgram", s);
    }

    public void StopProgram()
    {
        if (!checkBluetooth("StopProgram"))
        {
            return;
        } else
        {
            sendCommand("StopProgram", new byte[] {
                -128, 1
            });
            return;
        }
    }

    public void StopSoundPlayback()
    {
        if (!checkBluetooth("StopSoundPlayback"))
        {
            return;
        } else
        {
            sendCommand("StopSoundPlayback", new byte[] {
                -128, 12
            });
            return;
        }
    }
}
