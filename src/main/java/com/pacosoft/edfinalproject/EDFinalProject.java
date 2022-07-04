package com.pacosoft.edfinalproject;

import java.io.IOException;
import javax.swing.tree.DefaultMutableTreeNode;

public class EDFinalProject {

    MainFrame mainFrame;
    EquipmentTree tree;

    public EDFinalProject() {
        mainFrame = new MainFrame(this);
        mainFrame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        try {
            EDFinalProject app = new EDFinalProject();
            app.run();
        } catch (Exception e) {
        }
    }

    private void run() throws IOException, Exception {
        buildTree();
        mainFrame.setVisible(true);
    }

    public DefaultMutableTreeNode draw() {
        return tree.buildDrawTree(null, tree);
    }

    private void buildTree() {
        try {
            Equipment root = new Equipment("1", "Casco", 100);
            root.setImage("1.png");

            Equipment child2 = new Equipment("2", "Guante", 20);
            child2.setImage("2.png");
            Equipment child3 = new Equipment("3", "Guante II", 30);
            child3.setImage("3.png");
            Equipment child4 = new Equipment("4", "Yelmo", 50);

            child4.setImage("4.png");

            Equipment child2_1 = new Equipment("5", "Escudo", 10);
            child2_1.setImage("5.png");

            tree = new EquipmentTree(root);
            tree.addNewEquipment(child2, root);
            tree.addNewEquipment(child3, root);
            tree.addNewEquipment(child4, root);

            tree.addNewEquipment(child2_1, child2);

            System.out.println(tree.ObtenerMejorSet());
            System.out.println(tree.ObtenerSetBalanceado());
            
            // System.out.println(tree.branchAverage(child2_1, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
