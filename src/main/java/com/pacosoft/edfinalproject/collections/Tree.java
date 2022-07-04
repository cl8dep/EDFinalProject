package com.pacosoft.edfinalproject.collections;

import java.util.ArrayList;

public class Tree<T> {

    protected T root;
    protected Tree<T> parent;
    private ArrayList<Tree<T>> children;

    public Tree() {
        children = new ArrayList<>();
    }

    public Tree(T root) {
        this();
        this.root = root;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public int numberSubTrees() {
        return children.size();
    }

    public Tree<T> getSubTree(int i) {
        return children.get(i);
    }

    public void addSubTree(Tree<T> subtree) {
        children.add(subtree);
    }

    public int height() {
        if (isLeaf()) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < children.size(); i++) {
            int h = children.get(i).height();
            if (max < h) {
                max = h;
            }
        }
        return max + 1;
    }

    public Tree<T> findNode(T node) throws Exception {
        if (node == null) {
            throw new Exception("Root can't be null");
        }

        if (root.equals(node)) {
            return this;
        }

        for (Tree<T> subTree : children) {
            var temp = subTree.findNode(node);
            if (temp != null) {
                return temp;
            }
        }

        return null;
    }

    public Tree<T> findParent(T node) throws Exception {
        var nodeTemp = findNode(node);
        return nodeTemp.parent;
    }

    public ArrayList<Tree<T>> getChildren() {
        return children;
    }

    public int childrenSize() {
        return children.size();
    }

    public void setParent(Tree<T> parent) {
        this.parent = parent;
    }
    
    public Tree<T> getParent() {
        return this.parent;
    }

    public void addChild(T value) {
        var newTree = new Tree(value);
        newTree.setParent(this);
        children.add(newTree);
    }

    public void addChild(Tree<T> value) {
        value.setParent(this);
        children.add(value);
    }

    public T getRoot() {
        return this.root;
    }

    public void removeChild(Tree<T> childNode) {        
        this.children.remove(childNode);
    }
}
