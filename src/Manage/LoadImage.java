/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Visual Studio
 */
public class LoadImage {
    private String URL = "";
    private Image mImage;
    public LoadImage(String url){
        this.URL = url;
    }
    
    public Image getmImage() {
        Image image = null;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResource(URL));
        } catch (IOException e) {
            System.out.println("Không tìm thấy đường dẫn" + e.getMessage());
        }
        return mImage = image;
    }

}
