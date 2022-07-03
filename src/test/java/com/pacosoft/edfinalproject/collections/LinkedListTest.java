package com.pacosoft.edfinalproject.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LinkedListTest {

    public LinkedListTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of iterator method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testIteratorEmpty() {
        System.out.println("iterator");
        LinkedList instance = new LinkedList();

        int count = 0;
        for (Object item : instance) {
            count++;
        }
        assertEquals(instance.size(), count);

        instance.add(1);
        instance.add(2);

        count = 0;
        for (Object item : instance) {
            count++;
        }
        assertEquals(instance.size(), count);
    }

    /**
     * Test of size method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testSize() {
        System.out.println("size");
        LinkedList instance = new LinkedList();
        instance.add(1);

        assertEquals(1, instance.size());
    }

    /**
     * Test of isEmpty method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        LinkedList instance = new LinkedList();

        assertEquals(true, instance.isEmpty());

        instance.add(1);

        assertEquals(false, instance.isEmpty());
    }

    /**
     * Test of contains method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testContains() {
        System.out.println("contains");
        Object o = null;
        LinkedList instance = new LinkedList();
        instance.add(1);
        instance.add(2);
        instance.add(3);

        assertEquals(true, instance.contains(2));

        assertEquals(false, instance.contains(4));
    }

    /**
     * Test of toArray method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testToArray_0args() {
        System.out.println("toArray");
        LinkedList instance = new LinkedList();

        assertEquals(0, instance.toArray().length);

        instance.add(1);

        assertEquals(1, instance.toArray().length);
    }

    /**
     * Test of toArray method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testToArray_GenericType() {
        System.out.println("toArray");
        Object[] a = null;
        LinkedList instance = new LinkedList();
        Object[] expResult = null;
        Object[] result = instance.toArray(a);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testAdd_GenericType() {
        System.out.println("add");
        Object e = null;
        LinkedList instance = new LinkedList();
        boolean expResult = false;
        boolean result = instance.add(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testRemove_Object() {
        System.out.println("remove");
        
        LinkedList<String> instance = new LinkedList();
        instance.add("1");
        instance.add("2");
        instance.add("3");

        
        boolean result1 = instance.remove("1");
        assertEquals(true, result1);
        
         boolean result2 = instance.remove("3");
        assertEquals(true, result2);
    }

    /**
     * Test of containsAll method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testContainsAll() {
        System.out.println("containsAll");
        Collection c = null;
        LinkedList instance = new LinkedList();
        boolean expResult = false;
        boolean result = instance.containsAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testAddAll_Collection() {
        System.out.println("addAll");
        Collection c = null;
        LinkedList instance = new LinkedList();
        boolean expResult = false;
        boolean result = instance.addAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testAddAll_int_Collection() {
        System.out.println("addAll");
        int index = 0;
        Collection c = null;
        LinkedList instance = new LinkedList();
        boolean expResult = false;
        boolean result = instance.addAll(index, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAll method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        Collection c = null;
        LinkedList instance = new LinkedList();
        boolean expResult = false;
        boolean result = instance.removeAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retainAll method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testRetainAll() {
        System.out.println("retainAll");
        Collection c = null;
        LinkedList instance = new LinkedList();
        boolean expResult = false;
        boolean result = instance.retainAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testClear() {
        System.out.println("clear");
        LinkedList instance = new LinkedList();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        LinkedList instance = new LinkedList();
        Object expResult = null;
        Object result = instance.get(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testSet() {
        System.out.println("set");
        int index = 0;
        Object element = null;
        LinkedList instance = new LinkedList();
        Object expResult = null;
        Object result = instance.set(index, element);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testAdd_int_GenericType() {
        System.out.println("add");
        int index = 0;
        Object element = null;
        LinkedList instance = new LinkedList();
        instance.add(index, element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testRemove_int() {
        System.out.println("remove");
        int index = 0;
        LinkedList instance = new LinkedList();
        Object expResult = null;
        Object result = instance.remove(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indexOf method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Object o = null;
        LinkedList instance = new LinkedList();
        int expResult = 0;
        int result = instance.indexOf(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lastIndexOf method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testLastIndexOf() {
        System.out.println("lastIndexOf");
        Object o = null;
        LinkedList instance = new LinkedList();
        int expResult = 0;
        int result = instance.lastIndexOf(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listIterator method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testListIterator_0args() {
        System.out.println("listIterator");
        LinkedList instance = new LinkedList();
        ListIterator expResult = null;
        ListIterator result = instance.listIterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listIterator method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testListIterator_int() {
        System.out.println("listIterator");
        int index = 0;
        LinkedList instance = new LinkedList();
        ListIterator expResult = null;
        ListIterator result = instance.listIterator(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subList method, of class LinkedList.
     */
    @org.junit.jupiter.api.Test
    public void testSubList() {
        System.out.println("subList");
        int fromIndex = 0;
        int toIndex = 0;
        LinkedList instance = new LinkedList();
        List expResult = null;
        List result = instance.subList(fromIndex, toIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class LinkedList.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        LinkedList instance = new LinkedList();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
