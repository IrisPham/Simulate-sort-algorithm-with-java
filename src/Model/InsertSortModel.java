/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Manage.Loger;
import Manage.ManagerArray;
import Manage.ManagerThread;
import Manage.SortParent;
import Ui.DialogSuccess;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Visual Studio
 */
public class InsertSortModel extends SortParent{
    public InsertSortModel(JList jListRecord, JLabel[] lbArray, JLabel lbPosI, JLabel lbPosJ,JFrame frame) {
        super(jListRecord, lbArray, lbPosI, lbPosJ,frame);
    }

    /*
    *Hàm sắp xếp tăng
     */
    public void sortIncrease() {
        int i, j;
        Loger log = new Loger(jListRecord);
        for (i = 0; i < ManagerArray.array.length; i++) {
            //set position i
            pij.setElementOfI(i, lbArray[i]);
            //Ghi log sau mỗi lần lặp
            log.addElementToArray(ManagerArray.array);
            log.recordLog(i);
            j = i;
            if (j > 0) {
                moveUpAndDown(lbArray[j], 1);
                int point = lbArray[j].getX();
                int x = lbArray[j].getX();
                int y = 170;
                while (j > 0 && ManagerArray.array[j] < ManagerArray.array[j - 1]) {
                    //set position j
                    pij.setElementOfJ(j, lbArray[j]);
                    int pointTemp = lbArray[j - 1].getX();
                    ManagerArray.swap(j, j - 1);
                    moveRight(lbArray[j - 1], point, y, j, j - 1, x);
                    point = pointTemp;
                    j--;
                }
                swapElementLbArray(lbArray[j], point);
            }
        }
        onSortSuccess();
    }

    /*
    *Hàm sắp xếp giảm
     */
    public void sortDecrease() {
        Loger log = new Loger(jListRecord);
        int i, j;
        for (i = 0; i < ManagerArray.array.length; i++) {
            //set position i
            pij.setElementOfI(i, lbArray[i]);
            //Ghi log sau mỗi lần lặp
            log.addElementToArray(ManagerArray.array);
            log.recordLog(i);
            j = i;
            if (j > 0) {
                moveUpAndDown(lbArray[j], 1);
                int point = lbArray[j].getX();
                int x = lbArray[j].getX();
                int y = 170;
                while (j > 0 && ManagerArray.array[j] > ManagerArray.array[j - 1]) {
                    //set position j
                    pij.setElementOfJ(j, lbArray[j]);
                    int pointTemp = lbArray[j - 1].getX();
                    ManagerArray.swap(j, j - 1);
                    moveRight(lbArray[j - 1], point, y, j, j - 1, x);
                    point = pointTemp;
                    j--;
                }
                swapElementLbArray(lbArray[j], point);
            }
        }
        onSortSuccess();
    }

    /*
    *Hàm này dùng để mang phần tử được so sánh về vị trí cũ
     */
    private void swapElementLbArray(JLabel lb1, int point) {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        ManagerThread.threads[cur - 1].join();
                    }
                    //Di chuyển lb cần đổi về vị trí bên trái đẩy về vị trí cũ
                    while (lb1.getX() > point) {
                        lb1.setLocation(lb1.getX() - 10, lb1.getY());
                        Thread.sleep(ManagerThread.time);
                    }
                    //Đẩy lb về vị trí cũ
                    while (lb1.getY() > 100) {
                        lb1.setLocation(lb1.getX(), lb1.getY() - 2);
                        Thread.sleep(ManagerThread.time);
                    }
                } catch (InterruptedException e) {
                    System.out.println("" + e.getMessage());
                }
            }
        }
        );
        ManagerThread.threads[cur].start();
    }

    /*
    *Hàm này dùng để so sánh phần tử
    *Mang phần tử cần so sánh lên or xuống tùy theo trạng thái so sánh
     */
    private void moveUpAndDown(JLabel lb, int state) {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(() -> {
            try {
                if (cur != 0) {
                    ManagerThread.threads[cur - 1].join();
                }
                if (state == 1) {
                    while (lb.getY() < 170) {
                        lb.setLocation(lb.getX(), lb.getY() + 2);
                        Thread.sleep(ManagerThread.time);
                    }
                } else {
                    while (lb.getY() > 100) {
                        lb.setLocation(lb.getX(), lb.getY() - 2);
                        Thread.sleep(ManagerThread.time);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("" + e.getMessage());
            }
        });
        ManagerThread.threads[cur].start();
    }

    /*
    *Hàm này dùng để di chuyển các phần tử sang vị trí bên phải khi so sánh
    *Vừa di chuyển sang phải vừa trao đổi vị trí với lbArray được so sánh
    *Nhằm đồng bộ giữa chỉ số mảng rawData với chỉ số mảng của lbArray
     */
    private void moveRight(JLabel lb1, int point, int y, int j, int j2, int x) {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(() -> {
            try {
                if (cur != 0) {
                    ManagerThread.threads[cur - 1].join();
                }
                while (lb1.getX() < point) {
                    lb1.setLocation(lb1.getX() + 2, 100);
                    Thread.sleep(ManagerThread.time);
                }
                Point point3 = lb1.getLocation();//3
                String txtLb1 = lbArray[j].getText();
                lbArray[j].setText(lbArray[j - 1].getText());
                lbArray[j - 1].setText(txtLb1);
                lbArray[j].setLocation(point3);
                lbArray[j - 1].setLocation(x, y);
            } catch (InterruptedException e) {
                System.out.println("" + e.getMessage());
            }
        });
        ManagerThread.threads[cur].start();
    }
    
    //Hàm dùng để gán màu cho mảng đã sắp xếp thành công
    private void onSortSuccess() {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(() -> {
            try {
                if (cur != 0) {
                    ManagerThread.threads[cur - 1].join();
                }
                for(int i = 0; i < lbArray.length; i++){
                    lbArray[i].setBackground(new Color(22, 160, 93));
                }
                DialogSuccess n = new DialogSuccess(frame, true);
                n.setVisible(true);
            } catch (InterruptedException e) {
                System.out.println("" + e.getMessage());
            }
        });
        ManagerThread.threads[cur].start();
    }
}
