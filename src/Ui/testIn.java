/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Manage.ManagerArray;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author Visual Studio
 */
public class testIn extends javax.swing.JFrame {

    int[] a = {45, 42, 47, 48, 49, 10};
    JLabel[] lbArray;
    JLabel lbA;
    Thread[] threads = new Thread[500];
    int curT = -1;
    int time = 30;
    int curPos = 0;

    public testIn() {
        initComponents();
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        addLb();
        thuattoan();
        lbA = new JLabel();
        jPanel1.add(lbA);
    }

    private void addLb() {
        //deleteArray();
        lbArray = new JLabel[a.length];
        for (int i = 0; i < a.length; i++) {
            //Create list JLabel
            lbArray[i] = new JLabel(String.valueOf(a[i]));
            //lbArray[i].setIcon(new ImageIcon(getICMinion()));
            jPanel1.add(lbArray[i]);

            //Set JLabel
            lbArray[i].setSize(50, 50);
            lbArray[i].setForeground(Color.WHITE);
            lbArray[i].setBackground(new Color(255, 83, 1));
            Border border = BorderFactory.createLineBorder(new Color(234, 237, 238), 1);
            lbArray[i].setBorder(border);
            lbArray[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);
            lbArray[i].setOpaque(true);

            //set fonts
            lbArray[i].setFont(new Font("Tahoma", Font.PLAIN, 30));

            if (i == 0) {
                lbArray[i].setLocation((jPanel1.getWidth() / 2 - 50) - (31 * ManagerArray.index), 100);
            } else {
                lbArray[i].setLocation(lbArray[i - 1].getX() + 70, 100);
            }
        }
    }

    private void addlbAo(String value, int state, Point point) {
        if (state == 1) {
            lbA.setVisible(true);
        } else {
            lbA.setVisible(false);
        }
        lbA.setText(value);
        //Set JLabel
        lbA.setSize(50, 50);
        lbA.setForeground(Color.WHITE);
        lbA.setBackground(new Color(255, 83, 1));
        Border border = BorderFactory.createLineBorder(new Color(234, 237, 238), 1);
        lbA.setBorder(border);
        lbA.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        lbA.setOpaque(true);

        //set fonts
        lbA.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lbA.setLocation(point);

    }

    private void swap(int x, int y) {
        int temp;
        temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private void showA() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println("\n");
    }

    private void showB() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + lbArray[i].getText());
        }
        System.out.println("\n");
    }

    private void thuattoan() {
        int i, j;
        System.out.println("Trước khi swap");
        showA();
        showB();
        for (i = 0; i < a.length; i++) {
            j = i;
            if (j > 0) {
//                //Đem phần tử cần so sánh xuống
                moveUpAndDown(lbArray[j], 1);
                int point = lbArray[j].getX();
                int x = lbArray[j].getX();
                int y = 170;
                boolean isCheck = false;
                while (j > 0 && a[j] < a[j - 1]) {
                    swap(j, j - 1);
                    int pointTemp = lbArray[j - 1].getX();
                   // moveRight(lbArray[j - 1], point, y, j, j - 1, x);
                    point = pointTemp;
                    if (j == 1) {
                        isCheck = true;
                    }
                    j--;
                }
                if (isCheck) {
                    //swap(lbArray[j], point);
                } else {
                    isCheck = false;
                    moveUpAndDown(lbArray[j], 0);
                }
            }
        }
        System.out.println("Sau khi swap");
        showA();
        swape();
    }

    
    
    private void swape() {
        curT++;
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    showB();
                } catch (InterruptedException e) {
                    System.out.println("" + e.getMessage());
                }
            }
        }
        );
        threads[cur].start();
    }
    private void moveUpAndDown(JLabel lb, int state) {
        curT++;
        int cur = curT;
        threads[cur] = new Thread(() -> {
            try {
                if (cur != 0) {
                    threads[cur - 1].join();
                }
                if (state == 1) {
                    while (lb.getY() < 170) {
                        lb.setLocation(lb.getX(), lb.getY() + 2);
                        Thread.sleep(time);
                    }
                } else {
                    while (lb.getY() > 100) {
                        lb.setLocation(lb.getX(), lb.getY() - 2);
                        Thread.sleep(time);
                    }
                }
                Thread.sleep(time);
            } catch (InterruptedException e) {
                System.out.println("" + e.getMessage());
            }
        });
        threads[cur].start();
    }

   

    private void changePosLbArray(Point pointT, int j, Point point3, int j2) {
        curT++;
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }

//                    String txtLb1 = lb1.getText();
//                    lb1.setText(lb2.getText());
//                    lb2.setText(txtLb1);
                    // lb1.setBackground(new Color(255, 83, 1));
                    //lb2.setBackground(new Color(255, 83, 1));
                } catch (InterruptedException e) {
                    System.out.println("" + e.getMessage());
                }
            }
        }
        );
        threads[cur].start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(testIn.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testIn.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testIn.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testIn.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
