/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Manage.ManagerArray.array;
import static Manage.ManagerArray.swap;
import static Manage.ManagerIJ.lbShowI;
import static Manage.ManagerIJ.timeIJ;
import Manage.ManagerThread;
import Manage.SortParent;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
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
    private JLabel lbPivot;
    private boolean isCheckL = false;
    private boolean isCheckR = false;

    public QuickSortModel(JList jListRecord, JLabel[] lbArray, JLabel lbPosI, JLabel lbPosJ, JFrame frame, JPanel pnSimmulation) {
        super(jListRecord, lbArray, lbPosI, lbPosJ, frame);
        this.pnSimulation = pnSimmulation;
        addLbPivot();
    }

    /*
    *Hàm sắp xếp tăng
     */
    public void sortIncrease(int i, int j) {
        int pivot, pivotIndex, k;
        pivotIndex = findPivot(i, j);
        if (pivotIndex != -1) {
            pivot = array[pivotIndex];
            //setElementOfI(lbArray[pivotIndex]);
            k = partition(i, j, pivot);
            sortIncrease(i, k - 1);
            sortIncrease(k, j);
        }
    }

    /*
    *Hàm sắp xếp giảm
     */
    public void sortDecrease(int i, int j) {
        System.out.println("Sap xep giam");
        int pivot, pivotIndex, k;
        pivotIndex = findPivot(i, j);
        if (pivotIndex != -1) {
            pivot = array[pivotIndex];
            //setElementOfI(lbArray[pivotIndex]);
            k = partition1(i, j, pivot);
            sortDecrease(i, k - 1);
            sortDecrease(k, j);
        }
    }

    private int findPivot(int i, int j) {
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
            showPivot(lbArray[k]);
            return k;
        }
        showPivot(lbArray[i]);
        return i;
    }


    /*
    *
     */
    private int partition(int i, int j, int pivot) {
        int L, R;
        L = i;
        R = j;
        while (L <= R) {
            while (array[L] < pivot) {
                //Gán vị trí i
                L++;
                setElementOfL(lbPosI, L);
            }
            while (array[R] >= pivot) {
                R--;
                setElementOfR(lbPosJ, R);
            }
            if (L < R) {
                swap(L, R);
                swap(lbArray[L], lbArray[R]);
            }
        }
        //setPointPartition(lbArray[L]);
        //System.out.println(lbArray[L].getText());
        showPartition(lbArray[L]);
        return L;
    }

    /*
    *
     */
    private int partition1(int i, int j, int pivot) {
        int L, R;
        L = i;
        setElementOfL(lbPosI, L);
        R = j;
        setElementOfR(lbPosJ, R);
        while (L <= R) {
            while (array[L] >= pivot) {
                //Gán vị trí i
                setElementOfL(lbPosI, L);
                L++;
            }
            while (array[R] < pivot) {
                setElementOfR(lbPosJ, R);
                R--;
            }
            if (L < R) {
                swap(L, R);
                swap(lbArray[L], lbArray[R]);
            }
        }
        //setPointPartition(lbArray[L]);
        //System.out.println(lbArray[L].getText());
        showPartition(lbArray[L]);
        return L;
    }

    private void showPivot(JLabel lb) {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(() -> {
            try {
                if (cur != 0) {
                    ManagerThread.threads[cur - 1].join();
                }
                lb.setBackground(new Color(41, 98, 255));
                lbPivot.setLocation(lb.getX() - 25, 25);
                Thread.sleep(ManagerThread.time);
            } catch (InterruptedException e) {
                System.out.println("" + e.getMessage());
            }
        });
        ManagerThread.threads[cur].start();
    }

    private void showPartition(JLabel lb) {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(() -> {
            try {
                if (cur != 0) {
                    ManagerThread.threads[cur - 1].join();
                }
                lb.setBackground(new Color(158, 158, 158));
                Thread.sleep(ManagerThread.time);
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

    private void addLbPivot() {
        Manage.ManagerIJ.lbShowI.setText("L");
        Manage.ManagerIJ.lbShowJ.setText("R");
        lbPivot = new JLabel("Pi");
        lbPivot.setSize(100, 100);
        lbPivot.setForeground(new Color(0, 122, 255));
        lbPivot.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        lbPivot.setLocation(pnSimulation.getWidth() / 2 - 400, pnSimulation.getHeight() - 40);

        Font font = new Font("Segoe UI", Font.PLAIN, 35);
        lbPivot.setFont(font);

        pnSimulation.add(lbPivot);
    }

    public void setElementOfL(JLabel lbL, int pos) {
        int x = lbArray[pos].getX() - 25;
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(() -> {
            try {
                if (cur != 0) {
                    ManagerThread.threads[cur - 1].join();
                }
                //Dò i thay đổi màu lb tại vị trí nó đi qua
                lbPosI.setLocation(x, 25);
                Thread.sleep(timeIJ);
            } catch (InterruptedException e) {

            }
        });
        ManagerThread.threads[cur].start();
    }

    public void setElementOfR(JLabel lbR, int pos) {
        int x = lbArray[pos].getX() - 25;
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(() -> {
            try {
                if (cur != 0) {
                    ManagerThread.threads[cur - 1].join();
                }
                //Dò i thay đổi màu lb tại vị trí nó đi qua
                lbPosJ.setLocation(x, 25);
                Thread.sleep(timeIJ);
            } catch (InterruptedException e) {

            }
        });
        ManagerThread.threads[cur].start();
    }
}
