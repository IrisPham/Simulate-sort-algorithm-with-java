/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Manage.ArrayCompare;
import Manage.ManagerArray;
import Manage.ManagerThread;
import View.Simulator;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.Border;

/**
 *
 * @author Visual Studio
 */
public class CompareAlgorithm extends javax.swing.JFrame implements Simulator {

    private JLabel[] lbArray;
    private JLabel[] lbArray2;
    private JLabel[] lbArrayPos;
    private JLabel lbShowI;
    private JLabel lbShowJ;
    private int tick = 0;

    private void initLableIJ() {
        lbShowI = new JLabel("i");
        lbShowI.setSize(100, 100);
        lbShowI.setForeground(new Color(0, 122, 255));
        lbShowI.setHorizontalAlignment((int) CENTER_ALIGNMENT);

        lbShowJ = new JLabel("j");
        lbShowJ.setSize(100, 100);
        lbShowJ.setForeground(new Color(0, 122, 255));
        lbShowJ.setHorizontalAlignment((int) CENTER_ALIGNMENT);

        lbShowI.setLocation(pnSimulation.getWidth() / 2 - 400, pnSimulation.getHeight() - 40);
        lbShowJ.setLocation(lbShowI.getX() + 200, pnSimulation.getHeight() - 40);

        Font font = new Font("Segoe UI", Font.PLAIN, 35);
        lbShowI.setFont(font);
        lbShowJ.setFont(font);

        pnSimulation.add(lbShowI);
        pnSimulation.add(lbShowJ);
    }

    @Override
    public void createArray() {
        initLableIJ();
        ManagerArray.index = 15;
        lbArray = new JLabel[ManagerArray.index];
        lbArray2 = new JLabel[ManagerArray.index];
        lbArrayPos = new JLabel[ManagerArray.index];
        ManagerArray.array = new int[ManagerArray.index];
        for (int i = 0; i < ManagerArray.index; i++) {
            //Create list JLabel
            lbArray[i] = new JLabel("0");
            lbArrayPos[i] = new JLabel("" + i);
            //lbArray[i].setIcon(new ImageIcon(getICMinion()));
            pnSimulation.add(lbArray[i]);
            pnSimulation.add(lbArrayPos[i]);

            //Create list JLabel
            lbArray2[i] = new JLabel("0");
            //lbArray[i].setIcon(new ImageIcon(getICMinion()));
            pnSimulation.add(lbArray2[i]);

            //Set JLabel
            lbArray[i].setSize(50, 50);
            lbArray[i].setForeground(Color.WHITE);
            lbArray[i].setBackground(new Color(255, 83, 1));
            Border border = BorderFactory.createLineBorder(new Color(234, 237, 238), 1);
            lbArray[i].setBorder(border);
            lbArray[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);
            lbArray[i].setOpaque(true);

            //Set JLabel
            lbArray2[i].setSize(50, 50);
            lbArray2[i].setForeground(Color.WHITE);
            lbArray2[i].setBackground(new Color(255, 83, 1));
            lbArray2[i].setBorder(border);
            lbArray2[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);
            lbArray2[i].setOpaque(true);

            lbArrayPos[i].setSize(50, 50);
            lbArrayPos[i].setForeground(new Color(0, 122, 255));
            lbArrayPos[i].setFont(new Font("Tahoma", Font.PLAIN, 20));
            lbArrayPos[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);

            //set fonts
            lbArray[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
            lbArray2[i].setFont(new Font("Tahoma", Font.PLAIN, 30));

            if (i == 0) {
                lbArray[i].setLocation((pnSimulation.getWidth() / 2 - 50) - (31 * ManagerArray.index), 100);
                lbArray2[i].setLocation((pnSimulation.getWidth() / 2 - 50) - (31 * ManagerArray.index), 240);
                lbArrayPos[i].setLocation((pnSimulation.getWidth() / 2 - 50) - (31 * ManagerArray.index), 15);
            } else {
                lbArray[i].setLocation(lbArray[i - 1].getX() + 70, 100);
                lbArray2[i].setLocation(lbArray[i - 1].getX() + 70, 240);
                lbArrayPos[i].setLocation(lbArray[i - 1].getX() + 70, 15);
            }
        }
    }

    @Override
    public void deleteArray() {

    }

    @Override
    public void setDefaultArray() {

    }

    @Override
    public void randomElementArray() {
        ArrayCompare.curT = -1;
        ArrayCompare.threads = new Thread[999];
        Random rand = new Random();
        for (int i = 0; i < ArrayCompare.length; i++) {
            int ranNum = rand.nextInt(101) + 0;
            lbArray[i].setText(String.valueOf(ranNum));
            lbArray[i].setBackground(new Color(255, 83, 1));
            lbArray2[i].setText(String.valueOf(ranNum));
            lbArray2[i].setBackground(new Color(255, 83, 1));
            ArrayCompare.arr[i] = ranNum;
            ArrayCompare.arr2[i] = ranNum;
        }
    }

    @Override
    public void setStateButton(boolean state) {

    }

    @Override
    public void pauseThread() {

    }

    @Override
    public void stopThread() {

    }

    /**
     * Creates new form CompareAlgorithm
     */
    public CompareAlgorithm() {
        initComponents();
        this.setLocationRelativeTo(null);
        createArray();
        randomElementArray();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnSimulation = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        btnStart = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel8 = new javax.swing.JLabel();
        lbTimerS = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbTimerS1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("So sánh độ phức tạp thuật toán");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 122, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KHUNG MÔ PHỎNG THUẬT TOÁN");
        jLabel1.setFocusable(false);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1370, -1));

        pnSimulation.setBackground(new java.awt.Color(255, 255, 255));
        pnSimulation.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnSimulation.setEnabled(false);
        pnSimulation.setOpaque(false);
        pnSimulation.setPreferredSize(new java.awt.Dimension(1350, 353));
        pnSimulation.setLayout(null);
        getContentPane().add(pnSimulation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1346, 340));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mophongthuattoansapxep/source/Main/Group 5.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1370, 390));

        jLabel2.setText("Chọn thuật toán 1:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Shell Sort", "Quick Sort", "Insert Sort", "Heap Sort", "Bubble Sort", "Selection Sort", "InterChange Sort" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 130, -1));

        jLabel3.setText("Chọn thuật toán 2 :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Shell Sort", "Quick Sort", "Insert Sort", "Heap Sort", "Bubble Sort", "Selection Sort", "InterChange Sort" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 140, -1));

        btnStart.setText("Bắt đầu so sánh");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        getContentPane().add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));

        jLabel4.setText("1:00");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 10, -1, -1));

        jLabel5.setText("1:00");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 30, -1, -1));

        jLabel6.setText("Thời gian thuật toán 1:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, -1, -1));

        jLabel7.setText("Thời gian thuật toán 2:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 30, -1, -1));
        getContentPane().add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        jLabel8.setText("Thời gian hiện tại:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));

        lbTimerS.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbTimerS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTimerS.setText("00");
        getContentPane().add(lbTimerS, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 40, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText(":");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, -1, -1));

        lbTimerS1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbTimerS1.setText("00");
        getContentPane().add(lbTimerS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, 40, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        ArrayCompare.threads = new Thread[999];
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                SimpleDateFormat df = new SimpleDateFormat("mm:ss");
//                Date now = new Date();
//                String s = df.format(now);
//                lbTimerS.setText(s);
                Calendar cal = Calendar.getInstance();
//                hour.setValue(cal.get(Calendar.HOUR_OF_DAY));
//                min.setValue(cal.get(Calendar.MINUTE));
//                second.setValue(cal.get(Calendar.SECOND));

                if (tick % 2 == 1) {
//                    seperator[0].setText(" ");
//                    seperator[1].setText(" ");
//                } else {
//                    seperator[0].setText(":");
//                    seperator[1].setText(":");
                }
                tick++;
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }//GEN-LAST:event_btnStartActionPerformed

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
            java.util.logging.Logger.getLogger(CompareAlgorithm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompareAlgorithm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompareAlgorithm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompareAlgorithm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompareAlgorithm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel lbTimerS;
    private javax.swing.JLabel lbTimerS1;
    private javax.swing.JPanel pnSimulation;
    // End of variables declaration//GEN-END:variables
}
