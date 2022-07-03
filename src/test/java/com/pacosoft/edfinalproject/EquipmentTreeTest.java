package com.pacosoft.edfinalproject;

import com.pacosoft.edfinalproject.builders.EquipmentBuilder;
import com.pacosoft.edfinalproject.collections.Stack;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import javax.swing.tree.DefaultMutableTreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EquipmentTreeTest {

    public EquipmentTreeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of testAddNewEquipment method, of class EquipmentTree.
     */
    @Test
    public void testAddNewEquipment() {
        try {
            System.out.println("addNewEquipment");

            Equipment root = new Equipment("root", "root", 10);
            EquipmentTree instance = new EquipmentTree(root);

            Equipment child1 = new Equipment("1", "child1", 10);
            Equipment child2 = new Equipment("2", "child2", 10);
            Equipment child3 = new Equipment("3", "child3", 20);

            instance.addNewEquipment(child1, root);
            instance.addNewEquipment(child2, child1);
            instance.addNewEquipment(child3, child1);

            assertEquals(1, instance.getEquipmentsDiscarded().size());

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of testAddEquipment method, of class EquipmentTree.
     */
    @Test
    public void testAddEquipment() throws Exception {
        System.out.println("addEquipment");
        
        Equipment root = new Equipment("root", "root", 10);
        EquipmentTree instance = new EquipmentTree(root);

        Equipment child1 = new Equipment("1", "child1", 10);
        Equipment child2 = new Equipment("2", "child2", 10);
        Equipment child3 = new Equipment("3", "child3", 20);

        instance.addNewEquipment(child1, root);
        instance.addNewEquipment(child2, child1);
        instance.addEquipment(child3, child2);

        assertEquals(0, instance.getEquipmentsDiscarded().size());
    }

    /**
     * Test of findNode method, of class EquipmentTree.
     */
    @Test
    public void testFindNode() throws Exception {
        System.out.println("findNode");
        Equipment root = new EquipmentBuilder().setId("root").setName("root").createEquipment();
        EquipmentTree instance = new EquipmentTree(root);

        assert (instance.findNode(root) != null);
    }

    /**
     * Test of drawTree method, of class EquipmentTree.
     */
    @Test
    public void testDrawTree() {
        System.out.println("drawTree");
        Graphics graphics = null;
        int x = 0;
        int y = 0;
        int hGap = 0;
        int radius = 0;
        EquipmentTree instance = null;
        //instance.drawTree(graphics, x, y, hGap, radius);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoot method, of class EquipmentTree.
     */
    @Test
    public void testGetRoot() {
        System.out.println("getRoot");
        EquipmentTree instance = null;
        Equipment expResult = null;
        Equipment result = instance.getRoot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buildDrawTree method, of class EquipmentTree.
     */
    @Test
    public void testBuildDrawTree() {
        System.out.println("buildDrawTree");
        DefaultMutableTreeNode parent = null;
        EquipmentTree tree = null;
        EquipmentTree instance = null;
        DefaultMutableTreeNode expResult = null;
        DefaultMutableTreeNode result = instance.buildDrawTree(parent, tree);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of branchMaxAverage method, of class EquipmentTree.
     */
    @Test
    public void testBranchMaxAverage() throws IOException, Exception {
        System.out.println("branchMaxAverage");

        Equipment root = new Equipment("1", "Casco", 100);
        Equipment child2 = new Equipment("2", "Guante", 20);
        Equipment child3 = new Equipment("3", "Guante II", 30);
        Equipment child4 = new Equipment("4", "Yelmo", 50);
        root.setImage("1.png");
        child2.setImage("2.png");
        child3.setImage("3.png");
        child4.setImage("4.png");

        Equipment child2_1 = new Equipment("5", "Escudo", 10);
        child2_1.setImage("5.png");

        Equipment child2_2 = new Equipment("6", "Escudo II", 10);
        child2_2.setImage("6.png");

        EquipmentTree tree = new EquipmentTree(root);
        tree.addEquipment(child2, root);
        tree.addEquipment(child3, root);
        tree.addEquipment(child4, root);

        tree.addEquipment(child2_1, child2);
        tree.addEquipment(child2_2, child2);

        int expResult = 0;
        var list = new HashMap<Integer, Integer>();
        int result = tree.branchMaxAverage(tree, list, null, null);
        assertEquals(expResult, result);
    }

    /**
     * Test of setParent method, of class EquipmentTree.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        EquipmentTree parent = null;
        EquipmentTree instance = null;
        instance.setParent(parent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearEquipments method, of class EquipmentTree.
     */
    @Test
    public void testClearEquipments() {
        System.out.println("clearEquipments");
        EquipmentTree instance = null;
        instance.clearEquipments();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEquipmentsDiscarded method, of class EquipmentTree.
     */
    @Test
    public void testGetEquipmentsDiscarded() {
        System.out.println("getEquipmentsDiscarded");
        EquipmentTree instance = null;
        Stack<Equipment> expResult = null;
        Stack<Equipment> result = instance.getEquipmentsDiscarded();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
