// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import gnu.lists.LList;
import gnu.mapping.ThreadLocation;
import java.io.IOException;
import java.io.Writer;

public class PrettyWriter extends Writer
{

    private static final int BLOCK_PER_LINE_PREFIX_END = -3;
    private static final int BLOCK_PREFIX_LENGTH = -4;
    private static final int BLOCK_SECTION_COLUMN = -2;
    private static final int BLOCK_SECTION_START_LINE = -6;
    private static final int BLOCK_START_COLUMN = -1;
    private static final int BLOCK_SUFFIX_LENGTH = -5;
    private static final int LOGICAL_BLOCK_LENGTH = 6;
    public static final int NEWLINE_FILL = 70;
    public static final int NEWLINE_LINEAR = 78;
    public static final int NEWLINE_LITERAL = 76;
    public static final int NEWLINE_MANDATORY = 82;
    public static final int NEWLINE_MISER = 77;
    public static final int NEWLINE_SPACE = 83;
    static final int QITEM_BASE_SIZE = 2;
    static final int QITEM_BLOCK_END_SIZE = 2;
    static final int QITEM_BLOCK_END_TYPE = 5;
    static final int QITEM_BLOCK_START_BLOCK_END = 4;
    static final int QITEM_BLOCK_START_PREFIX = 5;
    static final int QITEM_BLOCK_START_SIZE = 7;
    static final int QITEM_BLOCK_START_SUFFIX = 6;
    static final int QITEM_BLOCK_START_TYPE = 4;
    static final int QITEM_INDENTATION_AMOUNT = 3;
    static final char QITEM_INDENTATION_BLOCK = 66;
    static final char QITEM_INDENTATION_CURRENT = 67;
    static final int QITEM_INDENTATION_KIND = 2;
    static final int QITEM_INDENTATION_SIZE = 4;
    static final int QITEM_INDENTATION_TYPE = 3;
    static final int QITEM_NEWLINE_KIND = 4;
    static final int QITEM_NEWLINE_SIZE = 5;
    static final int QITEM_NEWLINE_TYPE = 2;
    static final int QITEM_NOP_TYPE = 0;
    static final int QITEM_POSN = 1;
    static final int QITEM_SECTION_START_DEPTH = 2;
    static final int QITEM_SECTION_START_SECTION_END = 3;
    static final int QITEM_SECTION_START_SIZE = 4;
    static final int QITEM_TAB_COLINC = 4;
    static final int QITEM_TAB_COLNUM = 3;
    static final int QITEM_TAB_FLAGS = 2;
    static final int QITEM_TAB_IS_RELATIVE = 2;
    static final int QITEM_TAB_IS_SECTION = 1;
    static final int QITEM_TAB_SIZE = 5;
    static final int QITEM_TAB_TYPE = 6;
    static final int QITEM_TYPE_AND_SIZE = 0;
    static final int QUEUE_INIT_ALLOC_SIZE = 300;
    public static ThreadLocation indentLoc = new ThreadLocation("indent");
    public static int initialBufferSize = 126;
    public static ThreadLocation lineLengthLoc = new ThreadLocation("line-length");
    public static ThreadLocation miserWidthLoc = new ThreadLocation("miser-width");
    int blockDepth;
    int blocks[];
    public char buffer[];
    public int bufferFillPointer;
    int bufferOffset;
    int bufferStartColumn;
    int currentBlock;
    int lineLength;
    int lineNumber;
    int miserWidth;
    protected Writer out;
    public int pendingBlocksCount;
    char prefix[];
    int prettyPrintingMode;
    int queueInts[];
    int queueSize;
    String queueStrings[];
    int queueTail;
    char suffix[];
    boolean wordEndSeen;

    public PrettyWriter(Writer writer)
    {
        lineLength = 80;
        miserWidth = 40;
        buffer = new char[initialBufferSize];
        blocks = new int[60];
        blockDepth = 6;
        prefix = new char[initialBufferSize];
        suffix = new char[initialBufferSize];
        queueInts = new int[300];
        queueStrings = new String[300];
        currentBlock = -1;
        out = writer;
        prettyPrintingMode = 1;
    }

    public PrettyWriter(Writer writer, int i)
    {
        boolean flag = true;
        super();
        lineLength = 80;
        miserWidth = 40;
        buffer = new char[initialBufferSize];
        blocks = new int[60];
        blockDepth = 6;
        prefix = new char[initialBufferSize];
        suffix = new char[initialBufferSize];
        queueInts = new int[300];
        queueStrings = new String[300];
        currentBlock = -1;
        out = writer;
        lineLength = i;
        if (i > 1)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        prettyPrintingMode = i;
    }

    public PrettyWriter(Writer writer, boolean flag)
    {
        lineLength = 80;
        miserWidth = 40;
        buffer = new char[initialBufferSize];
        blocks = new int[60];
        blockDepth = 6;
        prefix = new char[initialBufferSize];
        suffix = new char[initialBufferSize];
        queueInts = new int[300];
        queueStrings = new String[300];
        currentBlock = -1;
        out = writer;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        prettyPrintingMode = i;
    }

    private static int enoughSpace(int i, int j)
    {
        int k = i * 2;
        i += j * 5 >> 2;
        if (k > i)
        {
            return k;
        } else
        {
            return i;
        }
    }

    private int getPerLinePrefixEnd()
    {
        return blocks[blockDepth - 3];
    }

    private int getPrefixLength()
    {
        return blocks[blockDepth - 4];
    }

    private int getQueueSize(int i)
    {
        return queueInts[i] >> 16;
    }

    private int getQueueType(int i)
    {
        return queueInts[i] & 0xff;
    }

    private int getSectionColumn()
    {
        return blocks[blockDepth - 2];
    }

    private int getSectionStartLine()
    {
        return blocks[blockDepth - 6];
    }

    private int getStartColumn()
    {
        return blocks[blockDepth - 1];
    }

    private int getSuffixLength()
    {
        return blocks[blockDepth - 5];
    }

    private int indexPosn(int i)
    {
        return bufferOffset + i;
    }

    private int posnColumn(int i)
    {
        return indexColumn(posnIndex(i));
    }

    private int posnIndex(int i)
    {
        return i - bufferOffset;
    }

    private void pushLogicalBlock(int i, int j, int k, int l, int i1)
    {
        int j1 = blockDepth + 6;
        if (j1 >= blocks.length)
        {
            int ai[] = new int[blocks.length * 2];
            System.arraycopy(blocks, 0, ai, 0, blockDepth);
            blocks = ai;
        }
        blockDepth = j1;
        blocks[blockDepth - 1] = i;
        blocks[blockDepth - 2] = i;
        blocks[blockDepth - 3] = j;
        blocks[blockDepth - 4] = k;
        blocks[blockDepth - 5] = l;
        blocks[blockDepth - 6] = i1;
    }

    public void addIndentation(int i, boolean flag)
    {
        if (prettyPrintingMode > 0)
        {
            char c;
            if (flag)
            {
                c = 'C';
            } else
            {
                c = 'B';
            }
            enqueueIndent(c, i);
        }
    }

    public void clearBuffer()
    {
        bufferStartColumn = 0;
        bufferFillPointer = 0;
        lineNumber = 0;
        bufferOffset = 0;
        blockDepth = 6;
        queueTail = 0;
        queueSize = 0;
        pendingBlocksCount = 0;
    }

    public void clearWordEnd()
    {
        wordEndSeen = false;
    }

    public void close()
        throws IOException
    {
        if (out != null)
        {
            forcePrettyOutput();
            out.close();
            out = null;
        }
        buffer = null;
    }

    public void closeThis()
        throws IOException
    {
        if (out != null)
        {
            forcePrettyOutput();
            out = null;
        }
        buffer = null;
    }

    int computeTabSize(int i, int j, int k)
    {
        int j1 = 0;
        int i1 = queueInts[i + 2];
        int l;
        boolean flag;
        if ((i1 & 1) != 0)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if ((i1 & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (l != 0)
        {
            j1 = j;
        }
        j = queueInts[i + 3];
        l = queueInts[i + 4];
        if (flag)
        {
            i = j;
            if (l > 1)
            {
                k = (k + j) % l;
                i = j;
                if (k != 0)
                {
                    i = j + k;
                }
            }
            return i;
        }
        if (k <= j + j1)
        {
            return (k + j1) - k;
        } else
        {
            return l - (k - j1) % l;
        }
    }

    public void endLogicalBlock()
    {
        int j2 = enqueue(5, 2);
        pendingBlocksCount = pendingBlocksCount - 1;
        if (currentBlock < 0)
        {
            int i = blocks[blockDepth - 5];
            int i1 = blocks[blockDepth - 6 - 5];
            if (i > i1)
            {
                write(suffix, suffix.length - i, i - i1);
            }
            currentBlock = -1;
            return;
        }
        int i2 = currentBlock;
        int k2 = queueInts[i2 + 4];
        String s;
        int j;
        int j1;
        if (k2 == 0)
        {
            currentBlock = -1;
        } else
        {
            int k1 = queueTail - i2;
            int k = k1;
            if (k1 > 0)
            {
                k = k1 - queueInts.length;
            }
            if (k2 < k)
            {
                currentBlock = -1;
            } else
            {
                int l1 = k2 + i2;
                int l = l1;
                if (l1 < 0)
                {
                    l = l1 + queueInts.length;
                }
                currentBlock = l;
            }
        }
        s = queueStrings[i2 + 6];
        if (s != null)
        {
            write(s);
        }
        j1 = j2 - i2;
        j = j1;
        if (j1 < 0)
        {
            j = j1 + queueInts.length;
        }
        queueInts[i2 + 4] = j;
    }

    public void endLogicalBlock(String s)
    {
        if (prettyPrintingMode > 0)
        {
            endLogicalBlock();
        } else
        if (s != null)
        {
            write(s);
            return;
        }
    }

    public int enqueue(int i, int j)
    {
        int k = queueInts.length;
        int l = k - queueTail - queueSize;
        if (l > 0 && j > l)
        {
            enqueue(0, l);
        }
        if (queueSize + j > k)
        {
            l = enoughSpace(k, j);
            int ai[] = new int[l];
            String as[] = new String[l];
            int i1 = (queueTail + queueSize) - k;
            if (i1 > 0)
            {
                System.arraycopy(queueInts, 0, ai, 0, i1);
                System.arraycopy(queueStrings, 0, as, 0, i1);
            }
            i1 = k - queueTail;
            k = l - k;
            System.arraycopy(queueInts, queueTail, ai, queueTail + k, i1);
            System.arraycopy(queueStrings, queueTail, as, queueTail + k, i1);
            queueInts = ai;
            queueStrings = as;
            if (currentBlock >= queueTail)
            {
                currentBlock = currentBlock + k;
            }
            queueTail = queueTail + k;
        }
        l = queueTail + queueSize;
        k = l;
        if (l >= queueInts.length)
        {
            k = l - queueInts.length;
        }
        queueInts[k + 0] = j << 16 | i;
        if (j > 1)
        {
            queueInts[k + 1] = indexPosn(bufferFillPointer);
        }
        queueSize = queueSize + j;
        return k;
    }

    public int enqueueIndent(char c, int i)
    {
        int j = enqueue(3, 4);
        queueInts[j + 2] = c;
        queueInts[j + 3] = i;
        return j;
    }

    public void enqueueNewline(int i)
    {
        wordEndSeen = false;
        int j1 = pendingBlocksCount;
        int k1 = enqueue(2, 5);
        queueInts[k1 + 4] = i;
        queueInts[k1 + 2] = pendingBlocksCount;
        queueInts[k1 + 3] = 0;
        int j = queueTail;
        int k = queueSize;
        do
        {
label0:
            {
                int l;
                if (k > 0)
                {
                    l = j;
                    if (j == queueInts.length)
                    {
                        l = 0;
                    }
                    if (l != k1)
                    {
                        break label0;
                    }
                }
                int i1;
                boolean flag;
                if (i == 76 || i == 82)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                maybeOutput(flag, false);
                return;
            }
            j = getQueueType(l);
            if ((j == 2 || j == 4) && queueInts[l + 3] == 0 && j1 <= queueInts[l + 2])
            {
                i1 = k1 - l;
                j = i1;
                if (i1 < 0)
                {
                    j = i1 + queueInts.length;
                }
                queueInts[l + 3] = j;
            }
            j = getQueueSize(l);
            k -= j;
            j = l + j;
        } while (true);
    }

    int enqueueTab(int i, int j, int k)
    {
        int l = enqueue(6, 5);
        queueInts[l + 2] = i;
        queueInts[l + 3] = j;
        queueInts[l + 4] = k;
        return l;
    }

    int ensureSpaceInBuffer(int i)
    {
        char ac[] = buffer;
        int k = ac.length;
        int j = bufferFillPointer;
        int l = k - j;
        if (l > 0)
        {
            return l;
        }
        if (prettyPrintingMode > 0 && j > lineLength)
        {
            if (!maybeOutput(false, false))
            {
                outputPartialLine();
            }
            return ensureSpaceInBuffer(i);
        }
        k = enoughSpace(k, i);
        char ac1[] = new char[k];
        buffer = ac1;
        i = j;
        do
        {
            i--;
            if (i >= 0)
            {
                ac1[i] = ac[i];
            } else
            {
                return k - j;
            }
        } while (true);
    }

    void expandTabs(int i)
    {
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l2;
        k = 0;
        j = 0;
        k1 = bufferStartColumn;
        j1 = getSectionColumn();
        l = queueTail;
        i1 = queueSize;
        l2 = pendingBlocksCount * 6;
_L11:
        if (i1 <= 0) goto _L2; else goto _L1
_L1:
        int l1;
        l1 = l;
        if (l == queueInts.length)
        {
            l1 = 0;
        }
        if (l1 != i) goto _L3; else goto _L2
_L2:
        char ac[];
        char ac1[];
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_518;
        }
        l = bufferFillPointer;
        i1 = l + j;
        ac1 = buffer;
        ac = ac1;
        j1 = ac1.length;
        i = l;
        if (i1 > j1)
        {
            ac = new char[enoughSpace(l, j)];
            buffer = ac;
        }
        bufferFillPointer = i1;
        bufferOffset = bufferOffset - j;
_L9:
        k--;
        if (k < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        l = blocks[k * 2 + l2];
        i1 = blocks[k * 2 + l2 + 1];
        j1 = l + j;
        System.arraycopy(ac1, l, ac, j1, i - l);
        for (i = j1 - i1; i < j1; i++)
        {
            ac[i] = ' ';
        }

          goto _L4
_L3:
        if (getQueueType(l1) != 6) goto _L6; else goto _L5
_L5:
        int i2;
        int j2;
        int k2;
        int j3 = posnIndex(queueInts[l1 + 1]);
        int i3 = computeTabSize(l1, j1, k1 + j3);
        k2 = j;
        j2 = k1;
        l = k;
        i2 = j1;
        if (i3 != 0)
        {
            if (k * 2 + l2 + 1 >= blocks.length)
            {
                ac = new int[blocks.length * 2];
                System.arraycopy(blocks, 0, ac, 0, blocks.length);
                blocks = ac;
            }
            blocks[k * 2 + l2] = j3;
            blocks[k * 2 + l2 + 1] = i3;
            l = k + 1;
            k2 = j + i3;
            j2 = k1 + i3;
            i2 = j1;
        }
_L7:
        j = getQueueSize(l1);
        i1 -= j;
        j1 = l1 + j;
        j = k2;
        k1 = j2;
        k = l;
        l = j1;
        j1 = i2;
        continue; /* Loop/switch isn't completed */
_L6:
        if (l1 != 2)
        {
            k2 = j;
            j2 = k1;
            l = k;
            i2 = j1;
            if (l1 != 4)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        i2 = k1 + posnIndex(queueInts[l1 + 1]);
        k2 = j;
        j2 = k1;
        l = k;
        if (true) goto _L7; else goto _L4
_L4:
        j -= i1;
        i = l;
        if (true) goto _L9; else goto _L8
_L8:
        if (ac != ac1)
        {
            System.arraycopy(ac1, 0, ac, 0, i);
        }
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    int fitsOnLine(int i, boolean flag)
    {
        byte byte0 = -1;
        int k = lineLength;
        int j = k;
        if (!printReadably())
        {
            j = k;
            if (getMaxLines() == lineNumber)
            {
                j = k - 3 - getSuffixLength();
            }
        }
        if (i >= 0)
        {
            k = byte0;
            if (posnColumn(queueInts[i + 1]) <= j)
            {
                k = 1;
            }
        } else
        {
            k = byte0;
            if (!flag)
            {
                k = byte0;
                if (indexColumn(bufferFillPointer) <= j)
                {
                    return 0;
                }
            }
        }
        return k;
    }

    public void flush()
    {
        if (out == null)
        {
            return;
        }
        try
        {
            forcePrettyOutput();
            out.flush();
            return;
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException(ioexception.toString());
        }
    }

    public void forcePrettyOutput()
        throws IOException
    {
        maybeOutput(false, true);
        if (bufferFillPointer > 0)
        {
            outputPartialLine();
        }
        expandTabs(-1);
        bufferStartColumn = getColumnNumber();
        out.write(buffer, 0, bufferFillPointer);
        bufferFillPointer = 0;
        queueSize = 0;
    }

    public int getColumnNumber()
    {
        int i = bufferFillPointer;
        int j;
        char c;
        do
        {
            j = i - 1;
            if (j < 0)
            {
                return bufferStartColumn + bufferFillPointer;
            }
            c = buffer[j];
            if (c == '\n')
            {
                break;
            }
            i = j;
        } while (c != '\r');
        return bufferFillPointer - (j + 1);
    }

    int getMaxLines()
    {
        return -1;
    }

    protected int getMiserWidth()
    {
        return miserWidth;
    }

    public int getPrettyPrintingMode()
    {
        return prettyPrintingMode;
    }

    int indexColumn(int i)
    {
        int j;
        int k;
        int l;
        int i1;
        int l1;
        i1 = bufferStartColumn;
        l = getSectionColumn();
        l1 = indexPosn(i);
        j = queueTail;
        k = queueSize;
_L2:
        int j1;
        int k1;
        int i2;
label0:
        {
label1:
            {
                if (k > 0)
                {
                    j1 = j;
                    if (j >= queueInts.length)
                    {
                        j1 = 0;
                    }
                    i2 = getQueueType(j1);
                    j = i1;
                    k1 = l;
                    if (i2 == 0)
                    {
                        break label0;
                    }
                    j = queueInts[j1 + 1];
                    if (j < l1)
                    {
                        break label1;
                    }
                }
                return i1 + i;
            }
            if (i2 != 6)
            {
                break; /* Loop/switch isn't completed */
            }
            j = i1 + computeTabSize(j1, l, posnIndex(j) + i1);
            k1 = l;
        }
_L5:
        l = getQueueSize(j1);
        k -= l;
        l = j1 + l;
        i1 = j;
        j = l;
        l = k1;
        if (true) goto _L2; else goto _L1
_L1:
        if (i2 == 2) goto _L4; else goto _L3
_L3:
        j = i1;
        k1 = l;
        if (i2 != 4) goto _L5; else goto _L4
_L4:
        k1 = i1 + posnIndex(queueInts[j1 + 1]);
        j = i1;
          goto _L5
    }

    boolean isMisering()
    {
        int i = getMiserWidth();
        return i > 0 && lineLength - getStartColumn() <= i;
    }

    public boolean isPrettyPrinting()
    {
        return prettyPrintingMode > 0;
    }

    public void lineAbbreviationHappened()
    {
    }

    boolean maybeOutput(boolean flag, boolean flag1)
    {
        boolean flag3 = false;
_L8:
        int j;
        if (queueSize <= 0)
        {
            break MISSING_BLOCK_LABEL_661;
        }
        if (queueTail >= queueInts.length)
        {
            queueTail = 0;
        }
        j = queueTail;
        getQueueType(j);
        JVM INSTR tableswitch 2 6: default 72
    //                   2 117
    //                   3 347
    //                   4 438
    //                   5 629
    //                   6 644;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_644;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        int i;
        boolean flag4;
        flag4 = flag3;
        i = j;
_L13:
        j = getQueueSize(queueTail);
        queueSize = queueSize - j;
        queueTail = i + j;
        flag3 = flag4;
        if (true) goto _L8; else goto _L7
_L7:
        int k = -1;
        queueInts[j + 4];
        JVM INSTR lookupswitch 3: default 164
    //                   70: 222
    //                   77: 213
    //                   83: 246;
           goto _L9 _L10 _L11 _L12
_L12:
        break MISSING_BLOCK_LABEL_246;
_L9:
        boolean flag2 = true;
_L14:
        i = j;
        flag4 = flag3;
        if (flag2)
        {
            flag4 = true;
            if (!flag1 || k != 0)
            {
                break MISSING_BLOCK_LABEL_334;
            }
            try
            {
                outputPartialLine();
            }
            catch (IOException ioexception)
            {
                throw new RuntimeException(ioexception);
            }
            i = j;
        }
          goto _L13
_L11:
        flag2 = isMisering();
          goto _L14
_L10:
        if (!isMisering() && lineNumber <= getSectionStartLine())
        {
            break MISSING_BLOCK_LABEL_246;
        }
        flag2 = true;
          goto _L14
        i = queueInts[j + 3];
        if (i == 0)
        {
            i = -1;
        } else
        {
            k = i + j;
            i = k;
            if (k >= queueInts.length)
            {
                i = k - queueInts.length;
            }
        }
        k = fitsOnLine(i, flag);
        if (k > 0)
        {
            flag2 = false;
        } else
        {
            if (k >= 0 && !flag1)
            {
                break MISSING_BLOCK_LABEL_661;
            }
            flag2 = true;
        }
          goto _L14
        outputLine(j);
        i = j;
          goto _L13
_L3:
        i = j;
        flag4 = flag3;
        if (!isMisering())
        {
            i = queueInts[j + 2];
            int l = queueInts[j + 3];
            if (i == 66)
            {
                i = l + getStartColumn();
            } else
            {
                i = l + posnColumn(queueInts[j + 1]);
            }
            setIndentation(i);
            i = j;
            flag4 = flag3;
        }
          goto _L13
_L4:
        i = queueInts[j + 3];
        int j1;
        if (i > 0)
        {
            i = (i + j) % queueInts.length;
        } else
        {
            i = -1;
        }
        i = fitsOnLine(i, flag);
        if (i > 0)
        {
            int i1 = queueInts[j + 4];
            i = (i1 + j) % queueInts.length;
            expandTabs(i);
            queueTail = i;
            queueSize = queueSize - i1;
        } else
        {
            if (i >= 0 && !flag1)
            {
                break MISSING_BLOCK_LABEL_661;
            }
            String s = queueStrings[j + 5];
            String s1 = queueStrings[j + 6];
            reallyStartLogicalBlock(posnColumn(queueInts[j + 1]), s, s1);
            i = j;
        }
        j1 = i;
        i = j1;
        flag4 = flag3;
        if (currentBlock == j)
        {
            currentBlock = -1;
            i = j1;
            flag4 = flag3;
        }
          goto _L13
_L5:
        reallyEndLogicalBlock();
        i = j;
        flag4 = flag3;
          goto _L13
        expandTabs(j);
        i = j;
        flag4 = flag3;
          goto _L13
        return flag3;
    }

    void outputLine(int i)
        throws IOException
    {
        char ac1[];
        int j;
        ac1 = buffer;
        char ac[];
        boolean flag;
        int k;
        int i1;
        int j1;
        int k1;
        int l1;
        if (queueInts[i + 4] == 76)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = posnIndex(queueInts[i + 1]);
        if (!flag) goto _L2; else goto _L1
_L1:
        i = j;
_L3:
        out.write(ac1, 0, i);
        k = lineNumber + 1;
        if (!printReadably())
        {
            i = getMaxLines();
            if (i > 0 && k >= i)
            {
                out.write(" ..");
                i = getSuffixLength();
                if (i != 0)
                {
                    ac = suffix;
                    i1 = ac.length;
                    out.write(ac, i1 - i, i);
                }
                lineAbbreviationHappened();
            }
        }
        lineNumber = k;
        out.write(10);
        bufferStartColumn = 0;
        i1 = bufferFillPointer;
        int l;
        if (flag)
        {
            i = getPerLinePrefixEnd();
        } else
        {
            i = getPrefixLength();
        }
        j1 = j - i;
        k1 = i1 - j1;
        ac = ac1;
        l1 = ac1.length;
        if (k1 > l1)
        {
            ac = new char[enoughSpace(l1, k1 - l1)];
            buffer = ac;
        }
        System.arraycopy(ac1, j, ac, i, i1 - j);
        System.arraycopy(prefix, 0, ac, 0, i);
        bufferFillPointer = k1;
        bufferOffset = bufferOffset + j1;
        if (!flag)
        {
            blocks[blockDepth - 2] = i;
            blocks[blockDepth - 6] = k;
        }
        return;
_L2:
        i = j;
_L5:
label0:
        {
            l = i - 1;
            if (l >= 0)
            {
                break label0;
            }
            i = 0;
        }
          goto _L3
        i = l;
        if (ac1[l] == ' ') goto _L5; else goto _L4
_L4:
        i = l + 1;
          goto _L3
    }

    void outputPartialLine()
    {
        int i;
        for (i = queueTail; queueSize > 0 && getQueueType(i) == 0;)
        {
            int j = getQueueSize(i);
            queueSize = queueSize - j;
            j = i + j;
            i = j;
            if (j == queueInts.length)
            {
                i = 0;
            }
            queueTail = i;
        }

        int k = bufferFillPointer;
        if (queueSize > 0)
        {
            i = posnIndex(queueInts[i + 1]);
        } else
        {
            i = k;
        }
        k -= i;
        if (i <= 0)
        {
            throw new Error("outputPartialLine called when nothing can be output.");
        }
        try
        {
            out.write(buffer, 0, i);
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException(ioexception);
        }
        bufferFillPointer = i;
        bufferStartColumn = getColumnNumber();
        System.arraycopy(buffer, i, buffer, 0, k);
        bufferFillPointer = k;
        bufferOffset = bufferOffset + i;
    }

    boolean printReadably()
    {
        return true;
    }

    void reallyEndLogicalBlock()
    {
        int i = getPrefixLength();
        blockDepth = blockDepth - 6;
        int j = getPrefixLength();
        if (j > i)
        {
            for (; i < j; i++)
            {
                prefix[i] = ' ';
            }

        }
    }

    void reallyStartLogicalBlock(int i, String s, String s1)
    {
        int j = getPerLinePrefixEnd();
        int j1 = getPrefixLength();
        int i1 = getSuffixLength();
        pushLogicalBlock(i, j, j1, i1, lineNumber);
        setIndentation(i);
        if (s != null)
        {
            blocks[blockDepth - 3] = i;
            int k = s.length();
            s.getChars(0, k, suffix, i - k);
        }
        if (s1 != null)
        {
            s = suffix;
            int l = s.length;
            int k1 = s1.length();
            int l1 = i1 + k1;
            i = l;
            if (l1 > l)
            {
                i = enoughSpace(l, k1);
                suffix = new char[i];
                System.arraycopy(s, l - i1, suffix, i - i1, i1);
            }
            s1.getChars(0, k1, s, i - l1);
            blocks[blockDepth - 5] = l1;
        }
    }

    public void setColumnNumber(int i)
    {
        bufferStartColumn = bufferStartColumn + (i - getColumnNumber());
    }

    public void setIndentation(int i)
    {
        char ac[] = prefix;
        int i1 = ac.length;
        int k = getPrefixLength();
        int l = getPerLinePrefixEnd();
        int j = i;
        if (l > i)
        {
            j = l;
        }
        if (j > i1)
        {
            ac = new char[enoughSpace(i1, j - i1)];
            System.arraycopy(prefix, 0, ac, 0, k);
            prefix = ac;
        }
        if (j > k)
        {
            for (i = k; i < j; i++)
            {
                ac[i] = ' ';
            }

        }
        blocks[blockDepth - 4] = j;
    }

    public void setPrettyPrinting(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        prettyPrintingMode = i;
    }

    public void setPrettyPrintingMode(int i)
    {
        prettyPrintingMode = i;
    }

    public void startLogicalBlock(String s, boolean flag, String s1)
    {
        int i;
        int k;
        if (queueSize == 0 && bufferFillPointer == 0)
        {
            Object obj = lineLengthLoc.get(null);
            if (obj == null)
            {
                lineLength = 80;
            } else
            {
                lineLength = Integer.parseInt(obj.toString());
            }
            obj = miserWidthLoc.get(null);
            if (obj == null || obj == Boolean.FALSE || obj == LList.Empty)
            {
                miserWidth = -1;
            } else
            {
                miserWidth = Integer.parseInt(obj.toString());
            }
            indentLoc.get(null);
        }
        if (s != null)
        {
            write(s);
        }
        if (prettyPrintingMode == 0)
        {
            return;
        }
        k = enqueue(4, 7);
        queueInts[k + 2] = pendingBlocksCount;
        String as[] = queueStrings;
        if (!flag)
        {
            s = null;
        }
        as[k + 5] = s;
        queueStrings[k + 6] = s1;
        pendingBlocksCount = pendingBlocksCount + 1;
        i = currentBlock;
        if (i >= 0) goto _L2; else goto _L1
_L1:
        i = 0;
_L4:
        queueInts[k + 4] = i;
        queueInts[k + 3] = 0;
        currentBlock = k;
        return;
_L2:
        int j = i - k;
        i = j;
        if (j > 0)
        {
            i = j - queueInts.length;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void write(int i)
    {
        wordEndSeen = false;
        if (i == 10 && prettyPrintingMode > 0)
        {
            enqueueNewline(76);
        } else
        {
            ensureSpaceInBuffer(1);
            int j = bufferFillPointer;
            buffer[j] = (char)i;
            bufferFillPointer = j + 1;
            if (i == 32 && prettyPrintingMode > 1 && currentBlock < 0)
            {
                enqueueNewline(83);
                return;
            }
        }
    }

    public void write(String s)
    {
        write(s, 0, s.length());
    }

    public void write(String s, int i, int j)
    {
        wordEndSeen = false;
        int k = j;
        j = i;
        do
        {
            if (k <= 0)
            {
                break;
            }
            int l = k;
            int i1 = ensureSpaceInBuffer(k);
            i = l;
            if (l > i1)
            {
                i = i1;
            }
            i1 = bufferFillPointer;
            l = k - i;
            k = i1;
            do
            {
                int j1 = i - 1;
                if (j1 < 0)
                {
                    break;
                }
                char c = s.charAt(j);
                if (c == '\n' && prettyPrintingMode > 0)
                {
                    bufferFillPointer = k;
                    enqueueNewline(76);
                    i = bufferFillPointer;
                } else
                {
                    char ac[] = buffer;
                    int k1 = k + 1;
                    ac[k] = c;
                    i = k1;
                    if (c == ' ')
                    {
                        i = k1;
                        if (prettyPrintingMode > 1)
                        {
                            i = k1;
                            if (currentBlock < 0)
                            {
                                bufferFillPointer = k1;
                                enqueueNewline(83);
                                i = bufferFillPointer;
                            }
                        }
                    }
                }
                k = i;
                j++;
                i = j1;
            } while (true);
            bufferFillPointer = k;
            k = l;
        } while (true);
    }

    public void write(char ac[])
    {
        write(ac, 0, ac.length);
    }

    public void write(char ac[], int i, int j)
    {
        int k1;
        wordEndSeen = false;
        k1 = i + j;
_L5:
        if (j <= 0) goto _L2; else goto _L1
_L1:
        int i1 = i;
_L6:
        int k;
        int l;
        l = i;
        k = j;
        if (i1 >= k1) goto _L4; else goto _L3
_L3:
label0:
        {
            if (prettyPrintingMode <= 0)
            {
                break label0;
            }
            k = ac[i1];
            if (k != 10 && (k != 32 || currentBlock >= 0))
            {
                break label0;
            }
            write(ac, i, i1 - i);
            write(k);
            i = i1 + 1;
            j = k1 - i;
        }
          goto _L5
        i1++;
          goto _L6
_L7:
        k = j;
        l = i;
_L4:
        j = ensureSpaceInBuffer(k);
        int j1;
        int l1;
        if (j >= k)
        {
            j = k;
        }
        j1 = bufferFillPointer;
        l1 = j1 + j;
        for (i = l; j1 < l1; i++)
        {
            buffer[j1] = ac[i];
            j1++;
        }

        bufferFillPointer = l1;
        j = k - j;
        if (j != 0) goto _L7; else goto _L5
_L2:
    }

    public final void writeBreak(int i)
    {
        if (prettyPrintingMode > 0)
        {
            enqueueNewline(i);
        }
    }

    public void writeWordEnd()
    {
        wordEndSeen = true;
    }

    public void writeWordStart()
    {
        if (wordEndSeen)
        {
            write(32);
        }
        wordEndSeen = false;
    }

}
