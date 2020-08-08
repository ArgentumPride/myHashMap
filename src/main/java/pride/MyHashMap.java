package pride;

public class MyHashMap {

    static final int INIT_CAPACITY = 16;
    private int initHash = -1;
    private final MyEntry[] entries;
    private final MyEntry dummy;
    private int size;

    public MyHashMap() {
        dummy = new MyEntry(-1, -1);
        entries = new MyEntry[INIT_CAPACITY];
        for (int i = 0; i < INIT_CAPACITY; i++) {
            this.entries[i] = null;
        }
    }

    public long get(int left) {
        int hashcode = ownHashcode(left);

        while (hashcode != initHash && (entries[hashcode] != null && entries[hashcode].getLeft() != left)) {
            if (initHash == -1)
                initHash = hashcode;
            hashcode = (hashcode + 1) % INIT_CAPACITY;
        }

        if (entries[hashcode] == null || hashcode == initHash)
            return -99L;
        else
            return entries[hashcode].getRight();
    }

    public void put(int left, long right) {
        int hashcode = ownHashcode(left);
        int index = -1;
        while (hashcode != initHash && (entries[hashcode] != null && entries[hashcode].getLeft() != left)) {
            if (initHash == -1)
                initHash = hashcode;
            if (entries[hashcode] == dummy)
                index = hashcode;
            hashcode = (hashcode + 1) % INIT_CAPACITY;
        }

        if ((entries[hashcode] == null || hashcode == initHash) && index != -1) {
            entries[index] = new MyEntry(left, right);
        } else if (initHash != hashcode) {
            if (entries[hashcode] == dummy && entries[hashcode] != null && entries[hashcode].getLeft() == left) {
                entries[hashcode].setRight(right);
            } else {
                entries[hashcode] = new MyEntry(left, right);
            }
        }
    }

    public int size() {
        for (int i = 0; i < INIT_CAPACITY; i++) {
            if (entries[i] != null)
                size++;
        }
        return size;
    }

    public MyEntry[] getEntries() {
        return entries;
    }

    public static class MyEntry {
        private int left;
        private long right;

        public MyEntry(int left, long right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public long getRight() {
            return right;
        }

        public void setRight(long right) {
            this.right = right;
        }
    }

    private int ownHashcode(int left) {
        return left % INIT_CAPACITY;
    }
}
