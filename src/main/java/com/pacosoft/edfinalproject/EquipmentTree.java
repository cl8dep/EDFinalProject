package com.pacosoft.edfinalproject;

import com.pacosoft.edfinalproject.collections.LinkedList;
import com.pacosoft.edfinalproject.collections.Queue;
import com.pacosoft.edfinalproject.collections.Stack;
import com.pacosoft.edfinalproject.collections.Tree;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.swing.tree.DefaultMutableTreeNode;

public class EquipmentTree extends Tree<Equipment> {

    private Stack<Equipment> equipmentsDiscarded;
    private Queue<Equipment> equipmentsToAdd;

    EquipmentTree(Equipment root) {
        super(root);
        equipmentsDiscarded = new Stack<>();
        equipmentsToAdd = new Queue<>();
    }

    public void addNewEquipment(Equipment value, Equipment father) throws Exception {
        if (father == null) {
            throw new Exception("Father is null");
        }

        var parentOfNode = findNode(father);
        if (parentOfNode == null || parentOfNode.childrenSize() >= 5 || value.getPoints() > computeBranchAverage(parentOfNode)) {
            this.equipmentsDiscarded.push(value);
        } else {
            parentOfNode.addChild(value);
        }
    }

    public void addEquipment(Equipment value, Equipment child) throws Exception {
        if (child == null) {
            throw new Exception("Children is null");
        }

        var childNode = findNode(child);
        var childParent = childNode.getParent();

        if (childParent != null) {

            childParent.removeChild(childNode);

            var intermediateTree = new EquipmentTree(value);
            intermediateTree.addChild(childNode);

            childParent.addChild(intermediateTree);
        } else {
            equipmentsDiscarded.push(value);
        }
    }

    public void drawTree(Graphics graphics, int x, int y, int radius) {
        graphics.setColor(Color.red);
        //graphics.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);

        BufferedImage rootImage = (BufferedImage) root.getImage();

        graphics.drawImage(rootImage, x - 30, y, null);
        graphics.drawString(root.getCategory(), x, y + 65);
    }

    public void setParent(EquipmentTree parent) {
        this.parent = parent;
    }

    public void clearEquipments() {
        this.equipmentsDiscarded.clear();
    }

    public Stack<Equipment> getEquipmentsDiscarded() {
        return this.equipmentsDiscarded;
    }

    public DefaultMutableTreeNode buildDrawTree(DefaultMutableTreeNode parent, Tree<Equipment> tree) {
        DefaultMutableTreeNode top;
        if (parent == null) {
            top = new DefaultMutableTreeNode(root);
        } else {
            top = parent;
        }

        for (var subTree : tree.getChildren()) {
            DefaultMutableTreeNode subTreeNode = new DefaultMutableTreeNode(subTree.getRoot());
            top.add(subTreeNode);
            buildDrawTree(subTreeNode, subTree);
        }

        return top;
    }

    public int branchMaxAverage(EquipmentTree treeP, HashMap<Integer, Integer> map, Integer keyP, Integer levelP) {
        int result = 0;
        int level = levelP == null ? 1 : levelP;
        int key = keyP == null ? 1 : keyP;
        var tree = treeP == null ? this : treeP;

        if (map.get(key) == null) {
            map.put(key, 0);
        }

        map.put(key, tree.getRoot().getPoints() + map.get(key));

        System.out.println(String.format("%s %s", tree.getRoot().getId(), tree.getRoot().getName()));

        /* if (!tree.hasSubEquipments()) {
            map.put(key, map.get(key) / level);
            level = 1;
        }*/
        for (var subTree : tree.getChildren()) {
            result += branchMaxAverage((EquipmentTree)subTree, map, key, level + 1);
            key++;
        }

        return result;
    }

    private int computeBranchAverage(Tree<Equipment> parentOfNode) {
        int sum = 0, counter = 0;
        var cursor = parentOfNode;
        do {
            sum += cursor.getRoot().getPoints();
            counter++;
            cursor = cursor.getParent();
        } while (cursor != null);

        return sum / counter;
    }

}
