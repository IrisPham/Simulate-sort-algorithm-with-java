/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage;


import java.awt.Color;
import javax.swing.JLabel;
import Manage.ManagerThread;

/**
 *
 * @author Visual Studio
 */
public class HightLightPosition {

    private JLabel[] lbArray;

    public HightLightPosition(JLabel[] lbArray) {
        this.lbArray = lbArray;
    }

    /**
     * set HightLight for Position I, J in Array
     */
    public void setHightLightPos(int position, boolean isChangeColor) {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        ManagerThread.threads[cur - 1].join();
                    }
                    if (isChangeColor) {
                        lbArray[position].setBackground(new Color(101, 31, 255));
                        Thread.sleep(ManagerThread.time);
                    } else {
                        lbArray[position].setBackground(new Color(101, 31, 255));
                        Thread.sleep(500);
                        lbArray[position].setBackground(new Color(255, 83, 1));
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {

                }
            }
        });
        ManagerThread.threads[cur].start();
    }

}
