/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Manage.ManagerArray;
import Manage.ManagerIJ;
import Manage.ManagerThread;
import Manage.SortParent;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Visual Studio
 */
public class ShellSortModel extends SortParent {

    public ShellSortModel(JList jListRecord, JLabel[] lbArray, JLabel lbPosI,
            JLabel lbPosJ, JFrame frame) {
        super(jListRecord, lbArray, lbPosI, lbPosJ, frame);
    }

    /*
    *Hàm sắp xếp tăng
     */
    public void sortIncrease() {
        int interval = 1;
        int pos1, pos2;
        int temp = 0;
        interval = ManagerArray.array.length / 2;
        while (interval > 0) {
            for (pos1 = 0; pos1 < ManagerArray.array.length; pos1++) {
                //set position i
                pij.setElementOfI(pos1, lbArray[pos1]);
                temp = ManagerArray.array[pos1];
                pos2 = pos1;
                while (pos2 >= interval && ManagerArray.array[pos2 - interval] > temp) {
                    //set position j
                    pij.setElementOfJ(pos2, lbArray[pos2 - interval]);
                    ManagerArray.swap(pos2, pos2 - interval);
                    swapShellSort(lbArray[pos2 - interval], lbArray[pos2]);
                    pos2 = pos2 - interval;
                }
            }
            interval = interval / 2;
        }
    }

    /*
    *Hàm sắp xếp giảm
     */
    public void sortDecrease() {
        int interval = 1;
        int pos1, pos2;
        int temp = 0;
        interval = ManagerArray.array.length / 2;
        while (interval > 0) {
            for (pos1 = 0; pos1 < ManagerArray.array.length; pos1++) {
                //set position i
                pij.setElementOfI(pos1, lbArray[pos1]);
                temp = ManagerArray.array[pos1];
                pos2 = pos1;
                while (pos2 >= interval && ManagerArray.array[pos2 - interval] < temp) {
                    //set position j
                    pij.setElementOfJ(pos2, lbArray[pos2 - interval]);
                    ManagerArray.swap(pos2, pos2 - interval);
                    swapShellSort(lbArray[pos2 - interval], lbArray[pos2]);
                    pos2 = pos2 - interval;
                }
            }
            interval = interval / 2;
        }
    }

    private void swapShellSort(JLabel lb1, JLabel lb2) {
        int x = lb1.getX();
        int y = lb2.getX();
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(() -> {
            try {
                if (cur != 0) {
                    ManagerThread.threads[cur - 1].join();
                }
                lb1.setBackground(new Color(118, 225, 0));
                lb2.setBackground(new Color(118, 225, 0));
                //Lấy 2 phần tử cần so sánh đem xuống dưới
                while (lb1.getY() < 160) {
                    lb1.setLocation(lb1.getX(), lb1.getY() + 2);
                    lb2.setLocation(lb2.getX(), lb2.getY() + 2);
                    Thread.sleep(ManagerThread.time);
                }
                //Xong hoán đổi 2 vị trí đó cho nhau
                while (lb1.getX() < y) {
                    lb1.setLocation(lb1.getX() + 10, lb1.getY());
                    lb2.setLocation(lb2.getX() - 10, lb2.getY());
                    Thread.sleep(ManagerThread.time);
                }
                //Xong đem xuống lại vị trí cũ
                while (lb1.getY() > 100) {
                    lb1.setLocation(lb1.getX(), lb1.getY() - 2);
                    lb2.setLocation(lb2.getX(), lb2.getY() - 2);
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
        });
        ManagerThread.threads[cur].start();
    }

}
