/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Manage.Loger;
import Manage.ManagerArray;
import static Manage.ManagerArray.array;
import static Manage.ManagerArray.swap;
import Manage.ManagerThread;
import Manage.SortParent;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author Visual Studio
 */
public class QuickSortModel extends SortParent {

    private final JPanel pnSimulation;

    public QuickSortModel(JList jListRecord, JLabel[] lbArray, JLabel lbPosI, JLabel lbPosJ, JFrame frame, JPanel pnSimmulation) {
        super(jListRecord, lbArray, lbPosI, lbPosJ, frame);
        this.pnSimulation = pnSimmulation;
        Manage.ManagerIJ.lbShowI.setText("Left");
        Manage.ManagerIJ.lbShowJ.setText("Right");
    }

    /*
    *Hàm sắp xếp tăng
     */
    public void sortIncrease() {
        quickSort1(0, array.length - 1);
    }

    /*
    *Hàm sắp xếp giảm
     */
    public void sortDecrease() {
        System.out.println("Sap xem giam");
        quickSort2(0, array.length - 1);
    }

    private int findPivot1(int i, int j) {
        int firstKey;
        int k;
        k = i + 1;
        firstKey = array[i];
        while ((k <= j) && array[k] == firstKey) {
            k++;
        }
        if (k > j) {
            return -1;
        }
        if (array[k] > array[i]) {
            return k;
        }
        return i;
    }

    private int partition1(int i, int j, int pivot) {
        int L, R;
        L = i;
        R = j;
        while (L <= R) {
            while (array[L] < pivot) {
                //Gán vị trí i
                pij.setElementOfI(L, lbArray[L]);
                L++;
            }
            while (array[R] >= pivot) {
                pij.setElementOfJ(R, lbArray[R]);
                R--;
            }
            if (L < R) {
                swap(L, R);
                swap(lbArray[L], lbArray[R]);
            }
        }
        return L;
    }

    public void quickSort1(int i, int j) {
        int pivot, pivotIndex, k;
        pivotIndex = findPivot1(i, j);
        if (pivotIndex != -1) {
            pivot = array[pivotIndex];
            //changeColorPivot(lbArray[pivotIndex],1);
            k = partition1(i, j, pivot);
            quickSort1(i, k - 1);
            quickSort1(k, j);
        }
    }

    private int findPivot2(int i, int j) {
        int firstKey;
        int k;
        k = i + 1;
        firstKey = array[i];
        while ((k <= j) && array[k] == firstKey) {
            k++;
        }
        if (k < j) {
            return -1;
        }
        if (array[k] < array[i]) {
            return k;
        }
        return i;
    }

    private int partition2(int i, int j, int pivot) {
        int L, R;
        L = i;
        R = j;
        while (L <= R) {
            while (array[L] >= pivot) {
                //Gán vị trí i
                pij.setElementOfI(L, lbArray[L]);
                L++;
            }
            while (array[R] < pivot) {
                pij.setElementOfJ(R, lbArray[R]);
                R--;
            }
            if (L < R) {
                swap(L, R);
                swap(lbArray[L], lbArray[R]);
            }
        }
        return L;
    }

    public void quickSort2(int i, int j) {
        int pivot, pivotIndex, k;
        pivotIndex = findPivot1(i, j);
        if (pivotIndex != -1) {
            pivot = array[pivotIndex];
            //changeColorPivot(lbArray[pivotIndex],1);
            k = partition1(i, j, pivot);
            quickSort1(i, k - 1);
            quickSort1(k, j);
        }
    }

    private void createArray() {
//        //deleteArray();
//        index = (int) spNum.getValue();
//        lbArray = new JLabel[index];
//        lbArrayPos = new JLabel[index];
//        array = new int[index];
//        for (int i = 0; i < index; i++) {
//            //Create list JLabel
//            lbArray[i] = new JLabel("0");
//            lbArrayPos[i] = new JLabel("" + i);
//            //lbArray[i].setIcon(new ImageIcon(getICMinion()));
//            pnSimulation.add(lbArray[i]);
//            pnSimulation.add(lbArrayPos[i]);
//
//            //Set JLabel
//            lbArray[i].setSize(50, 50);
//            lbArray[i].setForeground(Color.WHITE);
//            lbArray[i].setBackground(new Color(255, 83, 1));
//            Border border = BorderFactory.createLineBorder(new Color(234, 237, 238), 1);
//            lbArray[i].setBorder(border);
//            lbArray[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);
//            lbArray[i].setOpaque(true);
//
//            lbArrayPos[i].setSize(50, 50);
//            lbArrayPos[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);
//
//            //set fonts
//            lbArray[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
//
//            if (i == 0) {
//                lbArray[i].setLocation((pnSimulation.getWidth() / 2 - 50) - (31 * index), 175);
//                lbArrayPos[i].setLocation((pnSimulation.getWidth() / 2 - 50) - (31 * index),
//                        pnSimulation.getHeight() - 40);
//            } else {
//                lbArray[i].setLocation(lbArray[i - 1].getX() + 70, 175);
//                lbArrayPos[i].setLocation(lbArray[i - 1].getX() + 70, pnSimulation.getHeight() - 40);
//            }
//        }
    }

    private void changeColorPivot(JLabel lb, int state) {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(() -> {
            try {
                if (cur != 0) {
                    ManagerThread.threads[cur - 1].join();
                }
                if (state == 1) {
                    lb.setBackground(new Color(22, 160, 93));
                    Thread.sleep(ManagerThread.time);
                } else {
                    lb.setBackground(new Color(255, 83, 1));
                    Thread.sleep(ManagerThread.time);
                }

            } catch (InterruptedException e) {
                System.out.println("" + e.getMessage());
            }
        });
        ManagerThread.threads[cur].start();
    }

    /*
    *Hàm này dùng để di chuyển 2 Label cần so sánh 
     */
    private void swapQuickSort(JLabel lb1, JLabel lb2) {
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
                    lb1.setBackground(new Color(255, 83, 1));
                    lb2.setBackground(new Color(255, 83, 1));
                    lb1.setLocation(x, 100);
                    lb2.setLocation(y, 100);
                } catch (InterruptedException e) {
                    System.out.println("" + e.getMessage());
                }
            }
        });
        ManagerThread.threads[cur].start();
    }
}
