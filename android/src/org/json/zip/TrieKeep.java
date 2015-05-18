// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.zip;

import org.json.Kim;

// Referenced classes of package org.json.zip:
//            Keep, JSONzip, PostMortem

class TrieKeep extends Keep
{
    class Node
        implements PostMortem
    {

        private int integer;
        private Node next[];
        private final TrieKeep this$0;

        public Node get(byte byte0)
        {
            return get(byte0 & 0xff);
        }

        public Node get(int i)
        {
            if (next == null)
            {
                return null;
            } else
            {
                return next[i];
            }
        }

        public boolean postMortem(PostMortem postmortem)
        {
            postmortem = (Node)postmortem;
            if (postmortem != null) goto _L2; else goto _L1
_L1:
            JSONzip.log("\nMisalign");
_L6:
            return false;
_L2:
            int i;
            if (integer != ((Node) (postmortem)).integer)
            {
                JSONzip.log("\nInteger " + integer + " <> " + ((Node) (postmortem)).integer);
                return false;
            }
            if (next == null)
            {
                if (((Node) (postmortem)).next == null)
                {
                    return true;
                } else
                {
                    JSONzip.log("\nNext is null " + integer);
                    return false;
                }
            }
            i = 0;
_L7:
            Node node;
            if (i >= 256)
            {
                break MISSING_BLOCK_LABEL_182;
            }
            node = next[i];
            if (node == null) goto _L4; else goto _L3
_L3:
            if (!node.postMortem(((PostMortem) (((Node) (postmortem)).next[i])))) goto _L6; else goto _L5
_L5:
            i++;
              goto _L7
_L4:
            if (((Node) (postmortem)).next[i] == null) goto _L5; else goto _L8
_L8:
            JSONzip.log("\nMisalign " + i);
            return false;
            return true;
        }

        public void set(byte byte0, Node node)
        {
            set(byte0 & 0xff, node);
        }

        public void set(int i, Node node)
        {
            if (next == null)
            {
                next = new Node[256];
            }
            next[i] = node;
        }

        public Node vet(byte byte0)
        {
            return vet(byte0 & 0xff);
        }

        public Node vet(int i)
        {
            Node node1 = get(i);
            Node node = node1;
            if (node1 == null)
            {
                node = new Node();
                set(i, node);
            }
            return node;
        }



/*
        static int access$002(Node node, int i)
        {
            node.integer = i;
            return i;
        }

*/

        public Node()
        {
            this$0 = TrieKeep.this;
            integer = -1;
            next = null;
        }
    }


    private int froms[];
    private Kim kims[];
    private Node root;
    private int thrus[];

    public TrieKeep(int i)
    {
        super(i);
        froms = new int[capacity];
        thrus = new int[capacity];
        kims = new Kim[capacity];
        root = new Node();
    }

    public Kim kim(int i)
    {
        Kim kim1;
label0:
        {
            Kim kim2 = kims[i];
            int j = froms[i];
            int k = thrus[i];
            if (j == 0)
            {
                kim1 = kim2;
                if (k == kim2.length)
                {
                    break label0;
                }
            }
            kim1 = new Kim(kim2, j, k);
            froms[i] = 0;
            thrus[i] = kim1.length;
            kims[i] = kim1;
        }
        return kim1;
    }

    public int length(int i)
    {
        return thrus[i] - froms[i];
    }

    public int match(Kim kim1, int i, int j)
    {
        Node node = root;
        int l = -1;
        int k = i;
        do
        {
label0:
            {
                if (k < j)
                {
                    node = node.get(kim1.get(k));
                    if (node != null)
                    {
                        break label0;
                    }
                }
                return l;
            }
            if (node.integer != -1)
            {
                l = node.integer;
            }
            i++;
            k++;
        } while (true);
    }

    public boolean postMortem(PostMortem postmortem)
    {
        boolean flag = true;
        postmortem = (TrieKeep)postmortem;
        if (length != ((TrieKeep) (postmortem)).length)
        {
            JSONzip.log("\nLength " + length + " <> " + ((TrieKeep) (postmortem)).length);
        } else
        {
            if (capacity != ((TrieKeep) (postmortem)).capacity)
            {
                JSONzip.log("\nCapacity " + capacity + " <> " + ((TrieKeep) (postmortem)).capacity);
                return false;
            }
            for (int i = 0; i < length; i++)
            {
                Kim kim1 = kim(i);
                Kim kim2 = postmortem.kim(i);
                if (!kim1.equals(kim2))
                {
                    JSONzip.log("\n[" + i + "] " + kim1 + " <> " + kim2);
                    flag = false;
                }
            }

            if (flag && root.postMortem(((TrieKeep) (postmortem)).root))
            {
                return true;
            }
        }
        return false;
    }

    public void registerMany(Kim kim1)
    {
        int i;
        int l;
        int l1;
        l1 = kim1.length;
        int j = capacity - length;
        i = j;
        if (j > 40)
        {
            i = 40;
        }
        j = 0;
        l = i;
        i = j;
_L10:
        if (i >= l1 - 2) goto _L2; else goto _L1
_L1:
        Node node;
        int k;
        int k1;
        int i1 = l1 - i;
        k = i1;
        if (i1 > 10)
        {
            k = 10;
        }
        node = root;
        k1 = i;
_L8:
        if (k1 >= k + i) goto _L4; else goto _L3
_L3:
        int j1;
        node = node.vet(kim1.get(k1));
        j1 = l;
        if (node.integer != -1) goto _L6; else goto _L5
_L5:
        j1 = l;
        if (k1 - i < 2) goto _L6; else goto _L7
_L7:
        node.integer = length;
        uses[length] = 1L;
        kims[length] = kim1;
        froms[length] = i;
        thrus[length] = k1 + 1;
        length = length + 1;
        l--;
        j1 = l;
        if (l > 0) goto _L6; else goto _L2
_L2:
        return;
_L6:
        k1++;
        l = j1;
          goto _L8
_L4:
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public int registerOne(Kim kim1, int i, int j)
    {
        byte byte0 = -1;
        int k = byte0;
        if (length < capacity)
        {
            Node node = root;
            for (k = i; k < j; k++)
            {
                node = node.vet(kim1.get(k));
            }

            k = byte0;
            if (node.integer == -1)
            {
                k = length;
                node.integer = k;
                uses[k] = 1L;
                kims[k] = kim1;
                froms[k] = i;
                thrus[k] = j;
                length = length + 1;
            }
        }
        return k;
    }

    public void registerOne(Kim kim1)
    {
        int i = registerOne(kim1, 0, kim1.length);
        if (i != -1)
        {
            kims[i] = kim1;
        }
    }

    public void reserve()
    {
        if (capacity - length < 40)
        {
            int j = 0;
            int i = 0;
            root = new Node();
            while (j < capacity) 
            {
                int k = i;
                if (uses[j] > 1L)
                {
                    Kim kim1 = kims[j];
                    int l = thrus[j];
                    Node node = root;
                    for (k = froms[j]; k < l; k++)
                    {
                        node = node.vet(kim1.get(k));
                    }

                    node.integer = i;
                    uses[i] = age(uses[j]);
                    froms[i] = froms[j];
                    thrus[i] = l;
                    kims[i] = kim1;
                    k = i + 1;
                }
                j++;
                i = k;
            }
            j = i;
            if (capacity - i < 40)
            {
                power = 0;
                root = new Node();
                j = 0;
            }
            length = j;
            for (; j < capacity; j++)
            {
                uses[j] = 0L;
                kims[j] = null;
                froms[j] = 0;
                thrus[j] = 0;
            }

        }
    }

    public Object value(int i)
    {
        return kim(i);
    }
}
