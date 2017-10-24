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
public class ManagerIJ {

    public static JLabel lbShowI;
    public static JLabel lbShowJ;
    public static int timeIJ = 400;

    public ManagerIJ(JLabel lbShowI, JLabel lbShowJ) {
        this.lbShowI = lbShowI;
        this.lbShowJ = lbShowJ;
    }

    /**
     * set Element for Position I, J in Array
     *
     * @param elementI
     * @param poslbI
     */
    public void setElementOfI(int elementI, JLabel lbPosI) {
        int x = lbPosI.getX() - 25;
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(() -> {
            try {
                if (cur != 0) {
                    ManagerThread.threads[cur - 1].join();
                }
                //Dò i thay đổi màu lb tại vị trí nó đi qua
                lbShowI.setLocation(x, 25);
                lbPosI.setBackground(new Color(0, 122, 255));
                Thread.sleep(timeIJ);
                //Sau khi đổi màu xong thì trả màu về mặc định
                lbPosI.setBackground(new Color(255, 83, 1));
                Thread.sleep(timeIJ);
            } catch (InterruptedException e) {

            }
        });
        ManagerThread.threads[cur].start();
    }

    /**
     * set Element for Position I, J in Array
     *
     * @param elementJ
     * @param lbPosJ
     */
    public void setElementOfJ(int elementJ, JLabel lbPosJ) {
        int x = lbPosJ.getX() - 25;
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        ManagerThread.threads[cur - 1].join();
                    }
                    //Dò j thay đổi màu lb tại vị trí nó đi qua
                    lbShowJ.setLocation(x, 25);
                    lbPosJ.setBackground(new Color(0, 122, 255));
                    Thread.sleep(timeIJ);
                    //Sau khi đổi màu xong thì trả màu về mặc định
                    lbPosJ.setBackground(new Color(255, 83, 1));
                } catch (InterruptedException e) {
                }
            }
        });
        ManagerThread.threads[cur].start();
    }

//    public void setElementMaxMin(int max, int min) {
//        ManagerThread.curT++;
//        int cur = ManagerThread.curT;
//        ManagerThread.threads[cur] = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    if (cur != 0) {
//                        ManagerThread.threads[cur - 1].join();
//                    }
//                    lbMax.setText("Max = " + max);
//                    lbMin.setText("Min = " + min);
//                } catch (InterruptedException e) {
//
//                }
//            }
//        });
//        ManagerThread.threads[cur].start();
//    }
}
