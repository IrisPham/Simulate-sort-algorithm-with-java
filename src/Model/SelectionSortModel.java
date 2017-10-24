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
public class SelectionSortModel {

    private final JList jListRecord;
    private final JLabel[] lbArray;
    private final JLabel lbPosI;
    private final JLabel lbPosJ;
    private ManagerIJ pij;

    public SelectionSortModel(JList jListRecord, JLabel[] lbArray, JLabel lbPosI, JLabel lbPosJ) {
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
        for (i = 0; i <= ManagerArray.array.length - 1; i++) {
            lowKey = ManagerArray.array[i];
            lowIndex = i;
            //Gán vị trí i
            pij.setElementOfI(i, lbArray[i]);
            log.addElementToArray(ManagerArray.array);
            log.recordLog(i);
            //Chọn phần tử nhỏ nhất - tô màu cho nó
            chooserLowKeyOrMaxKey(lbArray[lowIndex], 1);
            for (j = i + 1; j <= ManagerArray.array.length - 1; j++) {
                pij.setElementOfJ(j, lbArray[j]);
                if (ManagerArray.array[j] < lowKey) {
                    //Đổi màu cho lowKey mới và gán màu locate cũ thành màu bt
                    chooserLowKeyOrMaxKey(lbArray[j], 1);
                    chooserLowKeyOrMaxKey(lbArray[lowIndex], 0);
                    //Xong đem 2 thằng đi lên
                    moveSelectionSort(lbArray[lowIndex], lbArray[j], 0);
                    lowKey = ManagerArray.array[j];
                    lowIndex = j;

                } else {
                    //Đem 2 thằng đi xuống
                    moveSelectionSort(lbArray[lowIndex], lbArray[j], 1);
                    //Đem 2 thằng đi lên
                    moveSelectionSort(lbArray[lowIndex], lbArray[j], 0);
                }
            }
            //Sử dụng hàm swap đổi vị trí 2 phần tử mảng
            swapSelectionSort(lbArray[i], lbArray[lowIndex]);
            ManagerArray.swap(i, lowIndex);
        }
    }

    /*
    *Hàm sắp xếp giảm
     */
    public void sortDecrease() {
        int i, j, lowKey, lowIndex;
        //Tạo một đối tượng ghi log
        Loger log = new Loger(jListRecord);
        for (i = 0; i <= ManagerArray.array.length - 1; i++) {
            lowKey = ManagerArray.array[i];
            lowIndex = i;
            //Gán vị trí i
            pij.setElementOfI(i, lbArray[i]);
            log.addElementToArray(ManagerArray.array);
            log.recordLog(i);
            //Chọn phần tử nhỏ nhất - tô màu cho nó
            chooserLowKeyOrMaxKey(lbArray[lowIndex], 1);
            for (j = i + 1; j <= ManagerArray.array.length - 1; j++) {
                pij.setElementOfJ(j, lbArray[j]);
                if (ManagerArray.array[j] > lowKey) {
                    //Đổi màu cho lowKey mới và gán màu locate cũ thành màu bt
                    chooserLowKeyOrMaxKey(lbArray[j], 1);
                    chooserLowKeyOrMaxKey(lbArray[lowIndex], 0);
                    //Xong đem 2 thằng đi lên
                    moveSelectionSort(lbArray[lowIndex], lbArray[j], 0);
                    lowKey = ManagerArray.array[j];
                    lowIndex = j;

                } else {
                    //Đem 2 thằng đi xuống
                    moveSelectionSort(lbArray[lowIndex], lbArray[j], 1);
                    //Đem 2 thằng đi lên
                    moveSelectionSort(lbArray[lowIndex], lbArray[j], 0);
                }
            }
            //Sử dụng hàm swap đổi vị trí 2 phần tử mảng
            swapSelectionSort(lbArray[i], lbArray[lowIndex]);
            ManagerArray.swap(i, lowIndex);
        }
    }

    /*
    *Hàm này dùng để tô màu một lowKey or MaxKey tùy theo trạng thái
     */
    public void chooserLowKeyOrMaxKey(JLabel lb, int state) {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        ManagerThread.threads[cur - 1].join();
                    }
                    if (state == 1) {
                        lb.setBackground(new Color(255, 0, 0));
                        Thread.sleep(100);
                    } else {
                        lb.setBackground(new Color(255, 83, 1));
                        Thread.sleep(100);
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
    *Hàm này dùng di chuyển 2 phần tử mảng đi xuống or đi lên tùy theo trạng thái
     */
    public void moveSelectionSort(JLabel lb, JLabel lb2, int state) {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        ManagerThread.threads[cur - 1].join();
                    }
                    if (state == 1) {
                        //Di chuyen phan tu di xuong
                        while (lb.getY() < 170) {
                            lb.setLocation(lb.getX(), lb.getY() + 2);
                            lb2.setLocation(lb2.getX(), lb2.getY() + 2);
                            Thread.sleep(ManagerThread.time);
                        }
                    } else {
                        //Di chuyển phan tu di len
                        while (lb.getY() > 100) {
                            lb.setLocation(lb.getX(), lb.getY() - 2);
                            lb2.setLocation(lb2.getX(), lb2.getY() - 2);
                            Thread.sleep(ManagerThread.time);
                        }
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
    *Hoán đổi vị trí 2 phần tử mảng
    *Mô tả: 2 phần tử cùng đi xuống, sau đó hoán đổi vị trí cho nhau, di chuyển
    *       lên để trở về vị trí ban đầu
     */
    public static void swapSelectionSort(JLabel lb, JLabel lb2) {
        int x = lb.getX(); // Vị trí xuất phát
        int x2 = lb2.getX(); //Vị trí đích đến
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        ManagerThread.threads[cur - 1].join();
                    }
                    //Di chuyen 2 phần tử được chọn đi xuống
                    while (lb.getY() < 170) {
                        lb.setLocation(lb.getX(), lb.getY() + 2);
                        lb2.setLocation(lb2.getX(), lb2.getY() + 2);
                        Thread.sleep(ManagerThread.time);
                    }
                    //Di chuyển 2 phần tử sang vị trí của nhau                    
                    while (lb.getX() < x2) {
                        lb.setLocation(lb.getX() + 10, lb.getY());
                        lb2.setLocation(lb2.getX() - 10, lb2.getY());
                        Thread.sleep(ManagerThread.time);
                    }
                    //Di chuyển 2 phần tử trở về vị trí ban đầu                    
                    while (lb.getY() > 100) {
                        lb.setLocation(lb.getX(), lb.getY() - 2);
                        lb2.setLocation(lb2.getX(), lb2.getY() - 2);
                        Thread.sleep(ManagerThread.time);
                    }
                    String txtLb1 = lb.getText();
                    lb.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    lb.setBackground(new Color(22, 160, 93));//255, 83, 1
                    //lb2.setBackground(new Color(22, 160, 93)); //33, 150, 243
                    lb.setLocation(x, 100);
                    lb2.setLocation(x2, 100);
                } catch (InterruptedException e) {
                    System.out.println("" + e.getMessage());
                }

            }
        }
        );
        ManagerThread.threads[cur].start();
    }

}
