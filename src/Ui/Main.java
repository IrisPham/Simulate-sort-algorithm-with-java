/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Presenter.AlgorithmPresenter;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.border.Border;
import Manage.ManagerArray;
import Manage.ManagerIJ;
import Manage.ManagerThread;
import Presenter.SimulatorPresenter;
import View.Algorithm;
import View.Simulator;

/**
 *
 * @author Visual Studio
 */
public class Main extends javax.swing.JFrame implements Simulator, Algorithm {

    private JLabel[] lbArray;
    private JLabel[] lbArrayPos;
    private JLabel lbShowI;
    private JLabel lbShowJ;
    private boolean isCheckPause = false;

    public Main() {
        initComponents();
        initComponents2();
    }

    private void initComponents2() {
        getContentPane().setBackground(new Color(255, 255, 255));
    }
    
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

    //QuickSort
    //Chọn key: Ý tưởng
    //Cho một lb thể hiện một cái khóa
    private ArrayList<JLabel> lbKeyQuickSort = new ArrayList<>();
    private int chooserlb = -1;

    private void createJlbleKey() {
        int a = 0;
        while (a < lbKeyQuickSort.size()) {
            lbKeyQuickSort.remove(a);
        }
        chooserlb = -1;
        for (int i = 0; i < 15; i++) {
            //Create JLable
            JLabel lbKey = new JLabel("");
            lbKey.setSize(50, 50);
            //Set JLabel
            lbKey.setSize(50, 50);
            lbKey.setForeground(Color.WHITE);
            lbKey.setBackground(new Color(255, 83, 1));
            Border border = BorderFactory.createLineBorder(new Color(234, 237, 238), 1);
            lbKey.setBorder(border);
            lbKey.setHorizontalAlignment((int) CENTER_ALIGNMENT);
            lbKey.setOpaque(true);
            //set fonts
            lbKey.setFont(new Font("Tahoma", Font.PLAIN, 30));

            lbKeyQuickSort.add(lbKey);
            pnSimulation.add(lbKeyQuickSort.get(i));

        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListRecord = new javax.swing.JList<>();
        lbNameAlgorithm = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tgbShellSort = new javax.swing.JToggleButton();
        tgbInterChangeSort = new javax.swing.JToggleButton();
        tgbSelectionSort = new javax.swing.JToggleButton();
        tgbBubbleSort = new javax.swing.JToggleButton();
        tgbInsertSort = new javax.swing.JToggleButton();
        tgbQuickSort = new javax.swing.JToggleButton();
        pnSimulation = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spNum = new javax.swing.JSpinner();
        btnCreateArray = new javax.swing.JButton();
        btnDeleteArray = new javax.swing.JButton();
        btnSetZero = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnCreateRandom = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnSartAlgorithm = new javax.swing.JButton();
        btnStopAlgorithm = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        rdbIncrease = new javax.swing.JRadioButton();
        rdbDecrease = new javax.swing.JRadioButton();
        btnPauseAlgorithm = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuEdit = new javax.swing.JMenu();
        itemEditBackground = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm mô phỏng thuật toán");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jListRecord.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jListRecord.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "item", "item" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListRecord.setEnabled(false);
        jScrollPane2.setViewportView(jListRecord);

        lbNameAlgorithm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNameAlgorithm.setForeground(new java.awt.Color(0, 122, 255));
        lbNameAlgorithm.setText("Thuật toán sắp xếp");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbNameAlgorithm)))
                .addGap(9, 9, 9))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lbNameAlgorithm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 452, 680, 190));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup3.add(tgbShellSort);
        tgbShellSort.setText("Shell Sort");
        tgbShellSort.setEnabled(false);
        jPanel2.add(tgbShellSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, -1));

        buttonGroup3.add(tgbInterChangeSort);
        tgbInterChangeSort.setText("InterChange Sort");
        tgbInterChangeSort.setEnabled(false);
        jPanel2.add(tgbInterChangeSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 120, -1));

        buttonGroup3.add(tgbSelectionSort);
        tgbSelectionSort.setText("Selection Sort");
        tgbSelectionSort.setEnabled(false);
        jPanel2.add(tgbSelectionSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, -1));

        buttonGroup3.add(tgbBubbleSort);
        tgbBubbleSort.setText("Bubble Sort");
        tgbBubbleSort.setEnabled(false);
        jPanel2.add(tgbBubbleSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, -1));

        buttonGroup3.add(tgbInsertSort);
        tgbInsertSort.setText("Insert Sort");
        tgbInsertSort.setEnabled(false);
        jPanel2.add(tgbInsertSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 120, -1));

        buttonGroup3.add(tgbQuickSort);
        tgbQuickSort.setText("Quick Sort");
        tgbQuickSort.setEnabled(false);
        jPanel2.add(tgbQuickSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 160, 190));

        pnSimulation.setBackground(new java.awt.Color(255, 255, 255));
        pnSimulation.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnSimulation.setEnabled(false);
        pnSimulation.setOpaque(false);
        pnSimulation.setPreferredSize(new java.awt.Dimension(1350, 353));
        pnSimulation.setLayout(null);
        getContentPane().add(pnSimulation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1346, 340));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 122, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KHUNG MÔ PHỎNG THUẬT TOÁN");
        jLabel1.setFocusable(false);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1370, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mophongthuattoansapxep/source/Main/Group 5.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1370, 390));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(0, 122, 255));
        jLabel2.setText("Số phần tử mảng:");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 122, 255));
        jLabel3.setText("Tối đa (15)");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        spNum.setModel(new javax.swing.SpinnerNumberModel(15, 2, 15, 1));
        jPanel5.add(spNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 27, -1, -1));

        btnCreateArray.setText("Tạo mảng");
        btnCreateArray.setBorder(null);
        btnCreateArray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateArrayActionPerformed(evt);
            }
        });
        jPanel5.add(btnCreateArray, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 80, 30));

        btnDeleteArray.setText("Xóa mảng");
        btnDeleteArray.setEnabled(false);
        btnDeleteArray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteArrayActionPerformed(evt);
            }
        });
        jPanel5.add(btnDeleteArray, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 30));

        btnSetZero.setText("Đặt về 0");
        btnSetZero.setEnabled(false);
        btnSetZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetZeroActionPerformed(evt);
            }
        });
        jPanel5.add(btnSetZero, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 80, 30));

        jLabel4.setForeground(new java.awt.Color(0, 122, 255));
        jLabel4.setText("Thêm dữ liệu vào mảng:");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        btnCreateRandom.setText("Ngẫu nhiên");
        btnCreateRandom.setEnabled(false);
        btnCreateRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateRandomActionPerformed(evt);
            }
        });
        jPanel5.add(btnCreateRandom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 30));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 220, 190));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mophongthuattoansapxep/source/Tool/CreateArray/Group 1.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 220, 250));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mophongthuattoansapxep/source/Tool/CreateArray/Group 2.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, -1, 250));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSartAlgorithm.setText("Chạy thuật toán");
        btnSartAlgorithm.setEnabled(false);
        btnSartAlgorithm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSartAlgorithmActionPerformed(evt);
            }
        });
        jPanel3.add(btnSartAlgorithm, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 156, -1));

        btnStopAlgorithm.setText("Dừng");
        btnStopAlgorithm.setEnabled(false);
        btnStopAlgorithm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopAlgorithmActionPerformed(evt);
            }
        });
        jPanel3.add(btnStopAlgorithm, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 156, -1));

        jSlider1.setEnabled(false);
        jSlider1.setOpaque(false);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jPanel3.add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 200, 30));

        buttonGroup2.add(rdbIncrease);
        rdbIncrease.setSelected(true);
        rdbIncrease.setText("Sắp xếp tăng");
        rdbIncrease.setEnabled(false);
        rdbIncrease.setOpaque(false);
        jPanel3.add(rdbIncrease, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        buttonGroup2.add(rdbDecrease);
        rdbDecrease.setText("Sắp xếp giảm");
        rdbDecrease.setEnabled(false);
        rdbDecrease.setOpaque(false);
        jPanel3.add(rdbDecrease, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        btnPauseAlgorithm.setText("Tạm dừng");
        btnPauseAlgorithm.setEnabled(false);
        btnPauseAlgorithm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseAlgorithmActionPerformed(evt);
            }
        });
        jPanel3.add(btnPauseAlgorithm, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 156, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 220, 190));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mophongthuattoansapxep/source/Tool/CreateArray/Group 3.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, -1, 250));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mophongthuattoansapxep/source/Tool/CreateArray/Group 4.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 700, 250));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mophongthuattoansapxep/lib/free-backgrounds/free-backgrounds-1.jpg"))); // NOI18N
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 660));

        menuEdit.setText("Hình nền");

        itemEditBackground.setText("Hình nền");
        itemEditBackground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditBackgroundActionPerformed(evt);
            }
        });
        menuEdit.add(itemEditBackground);

        jMenuBar1.add(menuEdit);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateArrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateArrayActionPerformed
        SimulatorPresenter sp = new SimulatorPresenter(this, this);
        sp.checkCreateArray(ManagerArray.index);
    }//GEN-LAST:event_btnCreateArrayActionPerformed

    private void btnDeleteArrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteArrayActionPerformed
        SimulatorPresenter sp = new SimulatorPresenter(this, this);
        sp.checkDeleteArray();
    }//GEN-LAST:event_btnDeleteArrayActionPerformed

    private void btnSetZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetZeroActionPerformed
        SimulatorPresenter sp = new SimulatorPresenter(this, this);
        sp.checkSetZeroArray();
    }//GEN-LAST:event_btnSetZeroActionPerformed

    private void btnCreateRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateRandomActionPerformed
        SimulatorPresenter sp = new SimulatorPresenter(this, this);
        sp.checkCreateRandom();
    }//GEN-LAST:event_btnCreateRandomActionPerformed

    private void btnSartAlgorithmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSartAlgorithmActionPerformed
        startAlgorithm();
    }//GEN-LAST:event_btnSartAlgorithmActionPerformed

    private void btnStopAlgorithmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopAlgorithmActionPerformed
        stopThread();
    }//GEN-LAST:event_btnStopAlgorithmActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        JSlider souce = (JSlider) evt.getSource();
        if (!souce.getValueIsAdjusting()) {
            ManagerThread.time = souce.getValue();
        }
    }//GEN-LAST:event_jSlider1StateChanged

    private void itemEditBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditBackgroundActionPerformed
        new ChooserBackground(this, true, jLabel5).setVisible(true);
    }//GEN-LAST:event_itemEditBackgroundActionPerformed

    private void btnPauseAlgorithmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseAlgorithmActionPerformed
        pauseThread();
    }//GEN-LAST:event_btnPauseAlgorithmActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
        } catch (Exception e) {
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateArray;
    private javax.swing.JButton btnCreateRandom;
    private javax.swing.JButton btnDeleteArray;
    private javax.swing.JButton btnPauseAlgorithm;
    private javax.swing.JButton btnSartAlgorithm;
    private javax.swing.JButton btnSetZero;
    private javax.swing.JButton btnStopAlgorithm;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JMenuItem itemEditBackground;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListRecord;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel lbNameAlgorithm;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JPanel pnSimulation;
    private javax.swing.JRadioButton rdbDecrease;
    private javax.swing.JRadioButton rdbIncrease;
    private javax.swing.JSpinner spNum;
    private javax.swing.JToggleButton tgbBubbleSort;
    private javax.swing.JToggleButton tgbInsertSort;
    private javax.swing.JToggleButton tgbInterChangeSort;
    private javax.swing.JToggleButton tgbQuickSort;
    private javax.swing.JToggleButton tgbSelectionSort;
    private javax.swing.JToggleButton tgbShellSort;
    // End of variables declaration//GEN-END:variables

    @Override
    public void createArray() {
        initLableIJ();
        ManagerArray.index = (int) spNum.getValue();
        lbArray = new JLabel[ManagerArray.index];
        lbArrayPos = new JLabel[ManagerArray.index];
        ManagerArray.array = new int[ManagerArray.index];
        for (int i = 0; i < ManagerArray.index; i++) {
            //Create list JLabel
            lbArray[i] = new JLabel("0");
            lbArrayPos[i] = new JLabel("" + i);
            //lbArray[i].setIcon(new ImageIcon(getICMinion()));
            pnSimulation.add(lbArray[i]);
            pnSimulation.add(lbArrayPos[i]);

            //Set JLabel
            lbArray[i].setSize(50, 50);
            lbArray[i].setForeground(Color.WHITE);
            lbArray[i].setBackground(new Color(255, 83, 1));
            Border border = BorderFactory.createLineBorder(new Color(234, 237, 238), 1);
            lbArray[i].setBorder(border);
            lbArray[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);
            lbArray[i].setOpaque(true);

            lbArrayPos[i].setSize(50, 50);
            lbArrayPos[i].setForeground(new Color(0, 122, 255));
            lbArrayPos[i].setFont(new Font("Tahoma", Font.PLAIN, 20));
            lbArrayPos[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);

            //set fonts
            lbArray[i].setFont(new Font("Tahoma", Font.PLAIN, 30));

            if (i == 0) {
                lbArray[i].setLocation((pnSimulation.getWidth() / 2 - 50) - (31 * ManagerArray.index), 100);
                lbArrayPos[i].setLocation((pnSimulation.getWidth() / 2 - 50) - (31 * ManagerArray.index), 15);
            } else {
                lbArray[i].setLocation(lbArray[i - 1].getX() + 70, 100);
                lbArrayPos[i].setLocation(lbArray[i - 1].getX() + 70, 15);
            }
        }
    }

    @Override
    public void deleteArray() {
        ManagerThread.curT = -1;
        ManagerThread.threads = new Thread[999];
        for (int i = 0; i < ManagerArray.index; i++) {
            lbArray[i].setText("0");
            lbArray[i].setVisible(false);
            pnSimulation.remove(lbArray[i]);
        }
        pnSimulation.removeAll();
        pnSimulation.validate();
        pnSimulation.repaint();
    }

    @Override
    public void setDefaultArray() {
        ManagerThread.curT = -1;
        ManagerThread.threads = new Thread[999];
        for (int i = 0; i < ManagerArray.index; i++) {
            lbArray[i].setText("0");
            ManagerArray.array[i] = 0;
        }
        pnSimulation.revalidate();
    }

    @Override
    public void randomElementArray() {
        ManagerThread.curT = -1;
        ManagerThread.threads = new Thread[999];
        Random rand = new Random();
        for (int i = 0; i < ManagerArray.index; i++) {
            int ranNum = rand.nextInt(101) + 0;
            lbArray[i].setText(String.valueOf(ranNum));
            lbArray[i].setBackground(new Color(255, 83, 1));
            ManagerArray.array[i] = ranNum;
        }
    }

    @Override
    public void setStateButton(boolean state) {
        if (state) {
            btnCreateRandom.setEnabled(state);
            btnSetZero.setEnabled(state);
            btnDeleteArray.setEnabled(state);
            btnCreateArray.setEnabled(false);
            tgbShellSort.setEnabled(state);
            tgbQuickSort.setEnabled(state);
            tgbInsertSort.setEnabled(state);
            tgbBubbleSort.setEnabled(state);
            tgbSelectionSort.setEnabled(state);
            tgbInterChangeSort.setEnabled(state);
            rdbIncrease.setEnabled(state);
            rdbDecrease.setEnabled(state);
            jSlider1.setEnabled(state);
            btnSartAlgorithm.setEnabled(state);
            btnPauseAlgorithm.setEnabled(state);
            btnStopAlgorithm.setEnabled(state);
            jListRecord.setEnabled(state);
        } else {
            btnCreateRandom.setEnabled(state);
            btnSetZero.setEnabled(state);
            btnDeleteArray.setEnabled(state);
            btnCreateArray.setEnabled(true);
            tgbShellSort.setEnabled(state);
            tgbQuickSort.setEnabled(state);
            tgbInsertSort.setEnabled(state);
            tgbBubbleSort.setEnabled(state);
            tgbSelectionSort.setEnabled(state);
            tgbInterChangeSort.setEnabled(state);
            rdbIncrease.setEnabled(state);
            rdbDecrease.setEnabled(state);
            jSlider1.setEnabled(state);
            btnSartAlgorithm.setEnabled(state);
            btnPauseAlgorithm.setEnabled(state);
            btnStopAlgorithm.setEnabled(state);
            jListRecord.setEnabled(state);
        }
    }

    //Algorithm
    @Override
    public void chooserAlgorithm(String namAlgorithm) {
        lbNameAlgorithm.setText(namAlgorithm);
    }

    @Override
    public void startAlgorithm() {
        ManagerThread.time = 50;
        ManagerIJ.timeIJ = 350;
        AlgorithmPresenter ap = new AlgorithmPresenter(this, jListRecord, lbArray, lbShowI, lbShowJ, this);
        if (tgbShellSort.isSelected()) {
            ap.chooserIncrease(rdbDecrease.isSelected());
            ap.chooserAlgorithm(0);
        }
        if (tgbQuickSort.isSelected()) {
            ap.chooserIncrease(rdbDecrease.isSelected());
            ap.chooserAlgorithm(1);
        }
        if (tgbInsertSort.isSelected()) {
            ap.chooserIncrease(rdbDecrease.isSelected());
            ap.chooserAlgorithm(2);
        }
        if (tgbBubbleSort.isSelected()) {
            ap.chooserIncrease(rdbDecrease.isSelected());
            ap.chooserAlgorithm(3);
        }
        if (tgbSelectionSort.isSelected()) {
            ap.chooserIncrease(rdbDecrease.isSelected());
            ap.chooserAlgorithm(4);
        }
        if (tgbInterChangeSort.isSelected()) {
            AlgorithmPresenter app = new AlgorithmPresenter(this, jListRecord, lbArray, lbShowI, lbShowJ, (int) spNum.getValue(), this);
            app.chooserIncrease(rdbDecrease.isSelected());
            app.chooserAlgorithm(5);
            //createJlbleKey();
            //quickSort(0, array.length - 1);
//            QuickSort qs = new QuickSort(lbArray, lbArrayPos,
//                    ManagerArray.array, ManagerArray.index, lbShowI,
//                    lbShowJ, lbShowI, spNum, pnSimulation);
//            qs.quickSort(0, ManagerArray.array.length - 1);
        }
    }
    @Override
    public void pauseThread() {
        if (isCheckPause) {
            isCheckPause = false;
            btnPauseAlgorithm.setText("Tạm dừng");
            for (int cur = 0; cur <= ManagerThread.curT; cur++) {
                try {
                    ManagerThread.threads[cur].resume();
                } catch (Exception e) {
                    System.out.println("" + e.getMessage());
                }
            }
        } else {
            isCheckPause = true;
            btnPauseAlgorithm.setText("Tiếp tục");
            for (int cur = 0; cur <= ManagerThread.curT; cur++) {
                try {
                    ManagerThread.threads[cur].suspend();
                } catch (Exception e) {
                    System.out.println("" + e.getMessage());
                }
            }
        }

    }

    @Override
    public void stopThread() {
        for (int cur = 0; cur <= ManagerThread.curT; cur++) {
            try {
                ManagerThread.threads[cur].resume();
            } catch (Exception e) {
                System.out.println("" + e.getMessage());
            }
        }
        ManagerThread.time = 0;
        ManagerIJ.timeIJ = 0;
    }

}
