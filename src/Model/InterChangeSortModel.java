/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Manage.Loger;
import Manage.ManagerArray;
import Manage.ManagerIJ;
import Manage.ManagerThread;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Visual Studio
 */
public class InterChangeSortModel {

    private final JList jListRecord;
    private final JLabel[] lbArray;
    private final JLabel lbPosI;
    private final JLabel lbPosJ;
    private ManagerIJ pij;

    public InterChangeSortModel(JList jListRecord, JLabel[] lbArray, JLabel lbPosI, JLabel lbPosJ) {
        this.jListRecord = jListRecord;
        this.lbArray = lbArray;
        this.lbPosI = lbPosI;
        this.lbPosJ = lbPosJ;
        pij = new ManagerIJ(lbPosI, lbPosJ);
    }

    /*
    *Hàm sắp xếp tăng
     */
    public void sortIncrease() {
        int i, j, lowKey, lowIndex;
        //Tạo một đối tượng ghi log
        Loger log = new Loger(jListRecord);
        for (i = 0; i < ManagerArray.array.length; i++) {
            //Gán vị trí i
            pij.setElementOfI(i, lbArray[i]);
            log.addElementToArray(ManagerArray.array);
            log.recordLog(i);
            for (j = i + 1; j < ManagerArray.array.length; j++) {
                //Gán vị trí j
                pij.setElementOfJ(j, lbArray[j]);
                if (ManagerArray.array[j] < ManagerArray.array[i]) {
                    ManagerArray.swap(i, j);
                    swap2(lbArray[i], lbArray[j]);
                } else {
                    swap1(lbArray[i], lbArray[j]);
                }
            }
            if (i == (ManagerArray.array.length - 1)) {
                //set màu cho phần tử cuối cùng khi đã duyệt xong mảng
                changeColorElementArrayLast(lbArray[ManagerArray.array.length - 1]);
            }
        }
    }

    /*
    *Hàm sắp xếp giảm
     */
    public void sortDecrease() {
        int i, j, lowKey, lowIndex;
        Loger log = new Loger(jListRecord);
        for (i = 0; i < ManagerArray.array.length; i++) {
            //set position i
            pij.setElementOfI(i, lbArray[i]);
            //Ghi log sau mỗi lần lặp
            log.addElementToArray(ManagerArray.array);
            log.recordLog(i);
            for (j = i + 1; j < ManagerArray.array.length; j++) {
                //set position j
                pij.setElementOfJ(j, lbArray[j]);
                if (ManagerArray.array[j] > ManagerArray.array[i]) {
                    ManagerArray.swap(i, j);
                    swap2(lbArray[i], lbArray[j]);
                } else {
                    swap1(lbArray[i], lbArray[j]);
                }
            }
            if (i == (ManagerArray.array.length - 1)) {
                //set màu cho phần tử cuối cùng khi đã duyệt xong mảng
                changeColorElementArrayLast(lbArray[ManagerArray.array.length - 1]);
            }
        }
    }

    /*
    * Hàm này dùng để di chuyển 2 Lable cần so sánh
    * Nhưng chưa so sánh về giá trị 
     */
    private void swap1(JLabel lb1, JLabel lb2) {
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
                    //Gán màu mới cho 2 Lable được chọn
                    lb1.setBackground(new Color(118, 225, 0));
                    lb2.setBackground(new Color(118, 225, 0));
                    //Lấy 2 phần tử cần so sánh đem xuống dưới
                    while (lb1.getY() < 160) {
                        lb1.setLocation(lb1.getX(), lb1.getY() + 2);
                        lb2.setLocation(lb2.getX(), lb2.getY() + 2);
                        Thread.sleep(ManagerThread.time);
                    }
                    //Xong đem xuống lại vị trí cũ
                    while (lb1.getY() > 100) {
                        lb1.setLocation(lb1.getX(), lb1.getY() - 2);
                        lb2.setLocation(lb2.getX(), lb2.getY() - 2);
                        Thread.sleep(ManagerThread.time);
                    }
                    lb1.setBackground(new Color(22, 160, 93));
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

    /*
    *Hàm này dùng để di chuyển 2 Label cần so sánh 
    *Nhưng đã so sánh về giá trị max min
     */
    private void swap2(JLabel lb1, JLabel lb2) {
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
                    //Gán màu mới cho 2 Lable được chọn
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
                    //b.setBackground(new Color(22, 160, 93));
                    lb1.setBackground(new Color(22, 160, 93));
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
    
    /*
    *Hàm này dùng để đổi màu phần tử mảng ở vị trí cuối cùng
    */
     private void changeColorElementArrayLast(JLabel lb1) {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        ManagerThread.threads[cur - 1].join();
                    }
                    lb1.setBackground(new Color(22, 160, 93));
                } catch (InterruptedException e) {
                    System.out.println("" + e.getMessage());
                }
            }
        }
        );
        ManagerThread.threads[cur].start();
    }
}
