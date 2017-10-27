/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Manage.ManagerArray;
import Manage.ManagerIJ;
import Manage.ManagerThread;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Visual Studio
 */
public class HeapSortModel {

    private final JList jListRecord;
    private final JLabel[] lbArray;
    private final JLabel lbPosI;
    private final JLabel lbPosJ;
    private final ManagerIJ pij;
    private final int n;
    private final int[] h = {155, 205, 260, 320};
    private int[] posLbArray;

    public HeapSortModel(JList jListRecord, JLabel[] lbArray, JLabel lbPosI, JLabel lbPosJ, int n) {
        this.jListRecord = jListRecord;
        this.lbArray = lbArray;
        this.lbPosI = lbPosI;
        this.lbPosJ = lbPosJ;
        this.n = n;
        pij = new ManagerIJ(lbPosI, lbPosJ);
        savePosLbArray();
        HeapSort();
    }

    private void savePosLbArray() {
        posLbArray = new int[ManagerArray.array.length];
        for (int i = 0; i < ManagerArray.array.length; i++) {
            posLbArray[i] = lbArray[i].getX();
        }

    }

    /*
    *Hàm này dùng biến đổi mảng ban đầu thành Heap có căn cứ dựa vào
    *giá trị khóa của các nút
    *First = (n-2)/2
    *Last = n - 1
    *Khi này nút trong r có 3 trường hợp xảy ra cần xét
     */
    void pushDown(int first, int last) {
        int r = first; // 6 //last == 14
        //Neu 6 <= 6
        while (r <= (last - 1) / 2) {
            //Neu a[r] chi co mot con trai
            if (last == 2 * r + 1) {
                /*Nếu khóa của nó lớn hơn con trái thì hoán đổi và kết thúc*/
                if (ManagerArray.array[r] > ManagerArray.array[last]) {
                    SwapinHeap(lbArray[r], lbArray[last]);
                    ManagerArray.swap(r, last);
                }
                r = last;
            } else {
                //Nguoc lai a[r] co con trai va con phai
                /*Neu khóa của nó lớn hơn con trái và khóa con trái không lớn hơn con phải
                thì hoán đổi a[r] với con trái của nó và tiếp tục xét tiếp con trái a[2*r+1]*/
                if (ManagerArray.array[r] > ManagerArray.array[2 * r + 1] && ManagerArray.array[2 * r + 1] <= ManagerArray.array[2 * r + 2]) {
                    SwapinHeap(lbArray[r], lbArray[2 * r + 1]);
                    ManagerArray.swap(r, 2 * r + 1);
                    r = 2 * r + 1;
                } else {
                    /*Nếu a[r] có khóa lớn hơn con phải của nó và và khóa con phải lớn hơn con trái
        thì hoán đổi a[r] với con phải và tiếp tục xét con phải a[2*r+1]*/
                    if (ManagerArray.array[r] > ManagerArray.array[2 * r + 2] && ManagerArray.array[2 * r + 2] < ManagerArray.array[2 * r + 1]) {
                        SwapinHeap(lbArray[r], lbArray[2 * r + 2]);
                        ManagerArray.swap(r, 2 * r + 2);
                        r = 2 * r + 2;
                    } else {
                        r = last;
                    }
                }
            }
        }
    }

    public void HeapSort() {
        int locaDefault = posLbArray[0];
        HeapLocationInit();
        int i;
        //Tạo heap từ cây nhị phân cho trước
        for (i = ((ManagerArray.index - 2) / 2); i >= 0; i--) {
            pushDown(i, ManagerArray.index - 1);
        }
        for (i = ManagerArray.index - 1; i >= 2; i--) {
            SwapHeapEnd(lbArray[0], lbArray[i], locaDefault);
            ManagerArray.swap(0, i);
            locaDefault += 70;
            pushDown(0, i - 1);
        }
        SwapHeapEnd(lbArray[0], lbArray[1], locaDefault);
        ManagerArray.swap(0, 1);
        locaDefault += 70;
        SwapHeapEnd(lbArray[0], null, locaDefault);
        moveLocationDefault();
    }

    /*
    *Hàm khởi tạo cây Heap từ một mảng sẵn có, nhưng chưa so sánh về giá trị ở 
    *nút lá so với nút gốc.
     */
    public void HeapLocationInit() {
        int i, j = 0;
        int row = 1;
        int maxirow = 0;
        int[] xi = {648, 448, 848, 348, 548, 748, 948, 293, 403, 493, 603, 693, 803, 893, 1003};
        int[] yi = {50, 105, 160, 215};
        MovetoLocation(lbArray[0], xi[0], yi[0]);
        //I chạy từ 0 đến 14 - 1 = 13 / 2 = 6
        for (i = 0; i <= (ManagerArray.index - 1) / 2; i++) {
            if (i > maxirow) {
                row++;
                maxirow = maxirow * 2 + 2;
            }
            j = 2 * i + 1; // vị trí con trái
            //Nếu vị trí con trái mà nhỏ hơn or bằng vị trí con phải 
            //và j nhỏ hơn chiều dài mảng
            while (j <= i * 2 + 2 && j < ManagerArray.index) {
                if (j == i * 2 + 1) {
                    //vị trí con trái
                    MovetoLocation(lbArray[j], xi[j], yi[row]);
                } else {
                    //vị trí con phải
                    MovetoLocation(lbArray[j], xi[j], yi[row]);
                }
                j++;
            }
        }
    }

    /*
    *Hàm này dùng để khởi tạo cây nhị phân
    *Dựa vào các phần tử mảng
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">    
    public void MovetoLocation(JLabel lb1, int x, int y) {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(() -> {
            try {
                if (cur != 0) {
                    ManagerThread.threads[cur - 1].join();
                }
                lb1.setBackground(new Color(118, 225, 0));
                int x1 = lb1.getX();
                int y1 = lb1.getY();
                //Nếu vị trí đứng nhỏ hơn vị trí cần nơi đến
                if (x1 < x && y1 < y) {
                    while (lb1.getX() < x) {
                        lb1.setLocation(lb1.getX() + 2, y1);
                        Thread.sleep(ManagerThread.time);
                    }
                    while (lb1.getY() < y) {
                        lb1.setLocation(x, lb1.getY() + 2);
                        Thread.sleep(ManagerThread.time);
                    }
                } else if (x1 >= x && y1 < y) {
                    //Nếu vị trí đứng lớn hơn vị trí cần nơi đến nhưng y lớn hơn vị trí nơi đến
                    while (lb1.getX() > x) {
                        lb1.setLocation(lb1.getX() - 2, y1);
                        Thread.sleep(ManagerThread.time);
                    }
                    while (lb1.getY() < y) {
                        lb1.setLocation(x, lb1.getY() + 2);
                        Thread.sleep(ManagerThread.time);
                    }
                } else if (x1 < x && y1 >= y) {
                    //Nếu vị trí đứng lớn hơn vị trí cần nơi đến nhưng y nhỏ hơn vị trí nơi đến
                    while (lb1.getY() > y) {
                        lb1.setLocation(x1, lb1.getY() - 2);
                        Thread.sleep(ManagerThread.time);
                    }
                    while (lb1.getX() < x) {
                        lb1.setLocation(lb1.getX() + 2, y);
                        Thread.sleep(ManagerThread.time);
                    }
                } else if (x1 >= x && y1 >= y) {
                    //Nếu vị trí đứng x và y đều nhỏ hơn nơi đến
                    while (lb1.getY() > y) {
                        lb1.setLocation(x1, lb1.getY() - 2);
                        Thread.sleep(ManagerThread.time);
                    }
                    while (lb1.getX() > x) {
                        lb1.setLocation(lb1.getX() - 2, y);
                        Thread.sleep(ManagerThread.time);
                    }
                }
                lb1.setBackground(new Color(255, 83, 1));
            } catch (InterruptedException e) {
            }
        });
        ManagerThread.threads[cur].start();
    }// </editor-fold>

    /*
    *Hàm này dùng để hoán đổi vị trí trong cây nhị phân
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code"> 
    public void SwapinHeap(JLabel lb1, JLabel lb2) {
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
                    int x1 = lb1.getX();
                    int x2 = lb2.getX();
                    int y1 = lb1.getY();
                    int y2 = lb2.getY();
                    while (lb2.getY() > y1) {
                        if (lb1.getY() > y1 - 50) {
                            lb1.setLocation(lb1.getX(), lb1.getY() - 2);
                        }
                        lb2.setLocation(lb2.getX(), lb2.getY() - 2);
                        Thread.sleep(ManagerThread.time);
                    }
                    if (x2 < x1) {
                        while (lb2.getX() < x1) {
                            lb1.setLocation(lb1.getX() - 2, lb1.getY());
                            lb2.setLocation(lb2.getX() + 2, lb2.getY());
                            Thread.sleep(ManagerThread.time);
                        }
                    } else {
                        while (lb2.getX() > x1) {
                            lb1.setLocation(lb1.getX() + 2, lb1.getY());
                            lb2.setLocation(lb2.getX() - 2, lb2.getY());
                            Thread.sleep(ManagerThread.time);
                        }
                    }
                    while (lb1.getY() < y2) {
                        lb1.setLocation(lb1.getX(), lb1.getY() + 2);
                        Thread.sleep(ManagerThread.time);
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    lb1.setLocation(x1, y1);
                    lb2.setLocation(x2, y2);
                    lb1.setBackground(new Color(255, 83, 1));
                    lb2.setBackground(new Color(255, 83, 1));
                } catch (InterruptedException e) {
                }
            }
        });
        ManagerThread.threads[cur].start();
    }// </editor-fold>

    public void SwapHeapEnd(JLabel lb1, JLabel lb2, int xend) {
        MovetoLocation(lb1, xend, 260);
        if (lb2 != null) {
            MovetoLocation(lb2, 600, 60);
        }
        SwapwithoutMoving(lb1, lb2);
    }

    public void SwapwithoutMoving(JLabel lb1, JLabel lb2) {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        ManagerThread.threads[cur - 1].join();
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    int x = lb1.getX();
                    int y = lb1.getY();
                    lb1.setLocation(lb2.getX(), lb2.getY());
                    lb2.setLocation(x, y);
                } catch (Exception e) {
                }
            }
        });
        ManagerThread.threads[cur].start();
    }

    public void moveLocationDefault() {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        ManagerThread.threads[cur - 1].join();
                    }
                    int lengt = ManagerArray.index - 1;
                    while (lengt >= 0) {
                        while (lbArray[lengt].getY() > 100) {                            
                            lbArray[lengt].setLocation(lbArray[lengt].getX(), lbArray[lengt].getY() - 2);
                            Thread.sleep(ManagerThread.time);
                        }
                        lbArray[lengt].setBackground(new Color(22, 160, 93));
                        lengt--;
                    }
                } catch (Exception e) {
                }
            }
        });
        ManagerThread.threads[cur].start();
    }

    public void setBackgroundMoving(JLabel lb1, JLabel lb2) {
        lb1.setOpaque(true);
        lb2.setOpaque(true);

        lb1.setBackground(Color.ORANGE);
        lb2.setBackground(Color.ORANGE);
    }

    public void setBackgroundDone(JLabel lb1, JLabel lb2) {
        lb1.setOpaque(true);
        lb2.setOpaque(true);

        lb1.setBackground(SystemColor.inactiveCaption);
        lb2.setBackground(SystemColor.inactiveCaption);
    }
}
