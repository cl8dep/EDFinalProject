/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pacosoft.edfinalproject;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AssetsManager {
    
    public static Image loadImageFromAssets(String assetName) throws IOException {
        String currentPath = System.getProperty("user.dir");
        File file = new File(currentPath + "/assets/" + assetName);
        if (file.exists()) {
            return ImageIO.read(file);
        } else
            return null;
    }
}
