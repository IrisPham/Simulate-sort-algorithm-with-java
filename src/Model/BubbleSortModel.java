package Model;

import Manage.Loger;
import Manage.ManagerArray;
import Manage.ManagerThread;
import Manage.SortParent;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Visual Studios
 */
public class BubbleSortModel extends SortParent{
    public BubbleSortModel(JList jListRecord, JLabel[] lbArray, JLabel lbPosI, JLabel lbPosJ,JFrame frame) {
        super(jListRecord, lbArray, lbPosI, lbPosJ,frame);
    }
    /*
    *Hàm sắp xếp tăng
     */
    public void sortIncrease() {
        int i,j;
        //Tạo một đối tượng ghi log
        Loger log = new Loger(jListRecord);
        for(i = 0; i <= ManagerArray.array.length - 2; i++){
            //Gán vị trí i
            pij.setElementOfI(i, lbArray[i]);
            log.addElementToArray(ManagerArray.array);
            log.recordLog(i);
            for(j = ManagerArray.array.length - 1; j >= i + 1; j--){
                //Gán vị trí j
                pij.setElementOfJ(j, lbArray[j]);
                if(ManagerArray.array[j] < ManagerArray.array[j - 1]){
                    swapBubbleSort(lbArray[j-1], lbArray[j]);
                    ManagerArray.swap(j, j-1);
                }
            }
            changeColorElementArray(lbArray[i]);            
        }
        //set màu cho phần tử cuối cùng khi đã duyệt xong mảng
        changeColorElementArray(lbArray[ManagerArray.array.length - 1]);
    }

    /*
    *Hàm sắp xếp giảm
     */
    public void sortDecrease() {
         int i,j;
        //Tạo một đối tượng ghi log
        Loger log = new Loger(jListRecord);
        for(i = 0; i <= ManagerArray.array.length - 2; i++){
            //Gán vị trí i
            pij.setElementOfI(i, lbArray[i]);
            log.addElementToArray(ManagerArray.array);
            log.recordLog(i);
            for(j = ManagerArray.array.length - 1; j >= i + 1; j--){
                //Gán vị trí j
                pij.setElementOfJ(j, lbArray[j]);
                if(ManagerArray.array[j] > ManagerArray.array[j - 1]){
                    swapBubbleSort(lbArray[j-1], lbArray[j]);
                    ManagerArray.swap(j, j-1);
                }
            }
            changeColorElementArray(lbArray[i]);            
        }
        //set màu cho phần tử cuối cùng khi đã duyệt xong mảng
        changeColorElementArray(lbArray[ManagerArray.array.length - 1]);
    }
    
    /*
    *Hàm này dùng để di chuyển 2 Label cần so sánh 
    */
    private void swapBubbleSort(JLabel lb1, JLabel lb2) {
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
    
    /*
    * Hàm này dùng để đổi màu cho phần tử mảng đã đúng vị trí
    */
    private void changeColorElementArray(JLabel lb1) {
        int x = lb1.getX();
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(() -> {
            try {
                if (cur != 0) {
                    ManagerThread.threads[cur - 1].join();
                }
                lb1.setBackground(new Color(22, 160, 93));
                Thread.sleep(ManagerThread.time);
            } catch (InterruptedException e) {
                System.out.println("" + e.getMessage());
            }
        });
        ManagerThread.threads[cur].start();
    }
}
