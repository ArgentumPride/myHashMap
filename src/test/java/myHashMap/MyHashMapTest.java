package myHashMap;

import org.junit.jupiter.api.Test;
import pride.MyHashMap;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MyHashMapTest {

    @Test
    void putMethodTest() {
        MyHashMap hashMap = new MyHashMap();
        MyHashMap emptyMap = new MyHashMap();
        hashMap.put(1, 10);
        hashMap.put(2, 20);
        assertFalse(Arrays.equals(hashMap.getEntries(), emptyMap.getEntries()));
    }

    @Test
    void sizeMethodTest() {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 10);
        hashMap.put(2, 20);
        hashMap.put(2, 40);
        assertEquals(2, hashMap.size());
    }

    @Test
    void getMethodTest() {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 10);
        hashMap.put(2, 20);
        assertEquals(10, hashMap.get(1));
        assertEquals(20, hashMap.get(2));
    }

    @Test
    void rewriteEntryWithSameKeyTest() {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 10);
        hashMap.put(2, 20);
        hashMap.put(1, 20);
        assertEquals(20, hashMap.get(1));
    }

}
