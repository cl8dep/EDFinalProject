package com.pacosoft.edfinalproject;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

public class EquipmentTreeNodeRenderer implements TreeCellRenderer {

    private final JLabel label;

    EquipmentTreeNodeRenderer() {
        label = new JLabel();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Equipment equipment = (Equipment) ((DefaultMutableTreeNode) value).getUserObject();

        label.setText( String.format("%s (%s)", equipment.getName(), equipment.getPoints()));

        if (equipment.getImage() != null) {
            Image newImage = resizeImage((BufferedImage)equipment.getImage(), 25);
            label.setIcon(new ImageIcon(newImage));
        }

        return label;
    }
    
    
    private Image resizeImage(BufferedImage source, int size) {
        BufferedImage output = new BufferedImage(size, size, source.getType());
        Graphics2D g = output.createGraphics();
        g.drawImage(source, 0, 0, size, size, null);
        g.dispose();
        return output;
    }

}
