/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Visual Studio
 */
public class ManagerArray{
    public static int[] array;
    public static int index;
    public static JLabel[] lbArray;
    
    public static void swap(int i, int lowIndex) {
        int temp;
        temp = array[i];
        array[i] = array[lowIndex];
        array[lowIndex] = temp;
    }
    
    public static void swap(JLabel lb1, JLabel lb2) {
        int x = lb1.getX();
        int y = lb2.getX();
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        ManagerThread.threads[cur - 1].join();
                    }
                    lb1.setBackground(new Color(118, 225, 0));
                    lb2.setBackground(new Color(118, 225, 0));
                    while (lb1.getY() > 50) {
                        lb1.setLocation(lb1.getX(), lb1.getY() - 2);
                        lb2.setLocation(lb2.getX(), lb2.getY() + 2);
                        //lbPointM.setLocation(x2, lbPointM.getY() + 10)
                        Thread.sleep(ManagerThread.time);
                    }
                    while (lb1.getX() < y) {
                        lb1.setLocation(lb1.getX() + 10, lb1.getY());
                        lb2.setLocation(lb2.getX() - 10, lb2.getY());
                        //lbPointM.setLocation(lb2.getX(), 250);
                        Thread.sleep(ManagerThread.time);
                    }
                    while (lb1.getY() < 100) {
                        lb1.setLocation(lb1.getX(), lb1.getY() + 10);
                        lb2.setLocation(lb2.getX(), lb2.getY() - 10);
                        //lbPointM.setLocation(x1, lbPointM.getY() - 10);
                        Thread.sleep(ManagerThread.time);
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    lb1.setBackground(new Color(255, 83, 1));
                    lb2.setBackground(new Color(255, 83, 1));
                    lb1.setLocation(x, 100);
                    lb2.setLocation(y, 100);
                } catch (InterruptedException e) {
                    System.out.println("" + e.getMessage());
                }

            }
        }
        );
        ManagerThread.threads[cur].start();
    }

}
