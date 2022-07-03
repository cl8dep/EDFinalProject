/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pacosoft.edfinalproject;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Familia
 */
public class Equipment {

    private int points;
    private Image image;
    private String category;
    private String name;
    private String id;

    Equipment(String id, String name) {
        this.id = id;
        this.name = name;
    }

    Equipment(String id, String name, int points) {
        this.id = id;
        this.name = name;
        this.points = points;
    }

    public void loadImageFromPath(String fileName) throws IOException {
        File file = new File(fileName);
        if (file.exists()) {
            image = ImageIO.read(file);
        } else {
            throw new FileNotFoundException();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Image getImage() {
        return image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    void setImage(Image image) {
        this.image = image;
    }

    public int getPoints() {
        return this.points;
    }

    @Override
    public String toString() {
        return String.format("%s %s", id, name);
    }

    void setImage(String relativeFile) throws IOException {
        this.image = AssetsManager.loadImageFromAssets(relativeFile);
    }

}
