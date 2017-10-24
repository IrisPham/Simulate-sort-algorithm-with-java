/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Manage.ManagerArray;
import Manage.ManagerIJ;
import Manage.ManagerThread;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Visual Studio
 */
public class HeapSortModel {

    private JList jListRecord;
    private JLabel[] lbArray;
    private JLabel lbPosI;
    private JLabel lbPosJ;
    private ManagerIJ pij;
    private int n;

    public HeapSortModel(JList jListRecord, JLabel[] lbArray, JLabel lbPosI, JLabel lbPosJ, int n) {
        this.jListRecord = jListRecord;
        this.lbArray = lbArray;
        this.lbPosI = lbPosI;
        this.lbPosJ = lbPosJ;
        this.n = n;
        pij = new ManagerIJ(lbPosI, lbPosJ);
        heapSort(ManagerArray.array, this.n - 1);
    }

    public HeapSortModel() {
        heapSort(ManagerArray.array, this.n - 1);
    }

    /*
    *Hàm khởi tạo cây cho HeapSort
    *
     */
    public void heapSortLocateInit(JLabel lb, int rootPos, int x, int y) {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        ManagerThread.threads[cur - 1].join();
                    }
                    /*
                    *Lấy phần tử đầu tiên đem ra giữa, lên phía trên 55 đơn vị
                     */
                    System.out.println("Nhan lb " + lb.getText());
                    int x1 = lb.getX();
                    System.out.println(" x1 " + x1); //158
                    int y1 = lb.getY();
                    System.out.println(" y2 " + y1); //100
                    System.out.println("x " + x); //1
                    System.out.println("y " + y); //2
                    System.out.println("root pos " + rootPos);
                    if (rootPos == 0) {
                        System.out.println("chay");
                        //Di chuyển node parent đi lên 55
                        while (lb.getY() > 50) {
                            lb.setLocation(lb.getX(), lb.getY() - 2);
                            Thread.sleep(ManagerThread.time);
                        }
                        //Di chuyen ra giua man hinh
                        while (lb.getX() <= lbArray[n / 2].getX()) {
                            lb.setLocation(lb.getX() + 2, lb.getY());
                            Thread.sleep(ManagerThread.time);
                        }
                        //Di chuyen con trai phia duoi nut cha 5 đơn vị
                        //va cach nut cha ve ben trai mot khoang 100
                        while (lbArray[x].getX() <= lb.getX() - 100) {
                            lbArray[x].setLocation(lbArray[x].getX() + 2, lbArray[x].getY());
                            Thread.sleep(ManagerThread.time);
                        }
                        while (lbArray[y].getX() <= lb.getX() + 100) {
                            lbArray[y].setLocation(lbArray[y].getX() + 2, lbArray[y].getY());
                            Thread.sleep(ManagerThread.time);
                        }
                    } else {
                        if (rootPos  == 1) {
                            //Xác định nút node cha tiếp theo
                            //Xong di chuyển 2 phần tử con của nút cha đó
                            //đi ngang qua
                            //Di chuyển con trái, con phải đi ngay qua nút cha, và ngay giữa vị trí nút cha
                            while (lbArray[x].getX() <= lb.getX() - 70) {
                                lbArray[x].setLocation(lbArray[x].getX() + 2, lbArray[x].getY());
                                lbArray[y].setLocation(lbArray[x].getX() + 160, lbArray[y].getY());
                                Thread.sleep(ManagerThread.time);
                            }
                            //Xong di chuyển phía dưới nút cha
                            while (lbArray[x].getY() < 155) {
                                lbArray[x].setLocation(lbArray[x].getX(), lbArray[x].getY() + 2);
                                lbArray[y].setLocation(lbArray[y].getX(), lbArray[y].getY() + 2);
                                Thread.sleep(ManagerThread.time);
                            }
                        } 
                        if(rootPos == 2) {
                            //Xác định nút node cha tiếp theo
                            //Xong di chuyển 2 phần tử con của nút cha đó
                            //đi ngang qua
                            //Di chuyển con trái, con phải đi ngay qua nút cha, và ngay giữa vị trí nút cha
                            while (lbArray[x].getX() <= lb.getX() - 70) {
                                lbArray[x].setLocation(lbArray[x].getX() + 2, lbArray[x].getY());
                                lbArray[y].setLocation(lbArray[x].getX() + 160, lbArray[y].getY());
                                Thread.sleep(ManagerThread.time);
                            }
                            //Xong di chuyển phía dưới nút cha
                            while (lbArray[x].getY() < 155) {
                                lbArray[x].setLocation(lbArray[x].getX(), lbArray[x].getY() + 2);
                                lbArray[y].setLocation(lbArray[y].getX(), lbArray[y].getY() + 2);
                                Thread.sleep(ManagerThread.time);
                            }
                        }

//                        //Di chuyen ra giua man hinh
//                        while (lb.getX() <= lbArray[n/2].getX()) {
//                            lb.setLocation(lb.getX() + 2, lb.getY());
//                            Thread.sleep(ManagerThread.time);
//                        }
//                        //Di chuyen con trai phia duoi nut cha 5 đơn vị
//                        //va cach nut cha ve ben trai mot khoang 100
//                        while (lbArray[x].getX() <= lb.getX() - 100) {
//                            lbArray[x].setLocation(lbArray[x].getX() + 2, lbArray[x].getY());
//                            lbArray[y].setLocation(lbArray[x].getX() + 200, lbArray[y].getY());
//                            Thread.sleep(ManagerThread.time);
//                        }
                    }
//                    if (x1 < x && y1 < y) {
//                        while (lb.getX() < x) {
//                            lb.setLocation(lb.getX() + 10, y1);
//                            Thread.sleep(ManagerThread.time);
//                        }
//                        while (lb.getY() < y) {
//                            lb.setLocation(x, lb.getY() + 10);
//                            Thread.sleep(ManagerThread.time);
//                        }
//                    }
////                    while (lb1.getY() < 160) {
//                        lb1.setLocation(lb1.getX(), lb1.getY() + 2);
//                        lb2.setLocation(lb2.getX(), lb2.getY() + 2);
//                        Thread.sleep(ManagerThread.time);
//                    }
//                    //Lấy 2 phần tử cần so sánh đem xuống dưới
//                    while (lb1.getY() < 160) {
//                        lb1.setLocation(lb1.getX(), lb1.getY() + 2);
//                        lb2.setLocation(lb2.getX(), lb2.getY() + 2);
//                        Thread.sleep(ManagerThread.time);
//                    }
//                    //Xong đem xuống lại vị trí cũ
//                    while (lb1.getY() > 100) {
//                        lb1.setLocation(lb1.getX(), lb1.getY() - 2);
//                        lb2.setLocation(lb2.getX(), lb2.getY() - 2);
//                        Thread.sleep(ManagerThread.time);
//                    }
//                    lb1.setBackground(new Color(255, 83, 1));
//                    lb2.setBackground(new Color(255, 83, 1));
//                    lb1.setLocation(x, 100);
//                    lb2.setLocation(y, 100);
                } catch (InterruptedException e) {
                    System.out.println("" + e.getMessage());
                }

            }
        }
        );
        ManagerThread.threads[cur].start();

    }

    /*
    *– Node gốc ở chỉ số 0
    *– Node cha của node i có chỉ số (i – 1)/2
    *– Các node con của node i (nếu có) có chỉ số [2i + 1] và [2i + 2]
    *– Node cuối cùng có con trong 1 Heap có n phần tử là: [n/2 – 1]
     */
    public void heapfy(int[] array, int n, int pos) {
        //Nếu vị trí nút xét hiện tại chưa phải là nút cuối thì tiếp tục xét
        while (pos <= n / 2 - 1) {
            int childLeft = 2 * pos + 1; // xác định con trái
            int childRight = 2 * pos + 2; // xác định con phải
            //Chỗ này cần xử lí di chuyển
            heapSortLocateInit(lbArray[pos], pos, childLeft, childRight);
            int root = childLeft;
            if (childRight < n && array[childRight] > array[root]) {
                root = childRight;
            }
            if (array[pos] < array[root]) {
                Manage.ManagerArray.swap(n, root);
            }
            pos = root;
        }
    }

    /*
    *– Tất cả các phần tử trên mảng có chỉ số [n/2] đến [n – 1] đều là node lá
    *– Mỗi node lá được xem là Heap có duy nhất 1 phần tử
    *– Thực hiện thao tác Heapify trên các phần tử có chỉ số từ [n/2 – 1] => 0 
    *ta sẽ tạo được 1 Heap có n phần tử
     */
    public void buildHeap(int[] array, int n) {
        for (int i = 0; i <= n / 2 - 1; i++) {
            heapfy(array, n, i);
        }
    }

    /*
    *-B1: Xây dựng Heap
    *=>Sử dụng thao tác Heapify để chuyển đổi mảng bình thường thành Heap
    *-B2: Sắp xếp
    *+ Hoán vị phần tử cuối cùng của Heap với phần tử đầu tiên của Heap
    *+ Loại bỏ phần tử cuối cùng
    *+ Thực hiện thao tác Heapify để điều chỉnh phần tử đầu tiên  
     */
    public void heapSort(int[] array, int n) {
        disPlays();
        buildHeap(array, n);
//        for(int i = n -1 ; i >= 0; i--){
//            ManagerArray.swap(0, i);
//            heapfy(array, n, 0);
//        }
        disPlays();
    }

    public void disPlays() {
        for (int i = 0; i < ManagerArray.array.length; i++) {
            System.out.print(" " + ManagerArray.array[i]);
        }
        System.out.println("\n");
    }
}
