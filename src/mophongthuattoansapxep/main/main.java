/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mophongthuattoansapxep.main;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Visual Studio
 */
public class main extends javax.swing.JFrame {

    private JPanel contentPane;
    private JLabel lbTitle;
    private JPanel pnTool;
    private JPanel pnArray;
    private JPanel pnCode;
    private JPanel pnAlgorithm;
    private JPanel pnControl;
    private JPanel pnLog;
    private JSlider slSpeed;
    private JRadioButton rdIncrease;
    private JRadioButton rdDecrease;
    private JButton btnSort;
    private JButton btnPause;
    private JRadioButton rdInterchangeSort;
    private JRadioButton rdSelectionSort;
    private JRadioButton rdBubbleSort;
    private JRadioButton rdInsertionSort;
    private JRadioButton rdShellSort;
    private JRadioButton rdHeapSort;
    private JRadioButton rdQuickSort;
    private JRadioButton rdMergeSort;
    private JScrollPane pnScroll;
    private DefaultListModel model;
    private JList<String> lsCode;
    private JPanel pnCreateArray;
    private JPanel pnSetValueArray;
    private JButton btnRandom;
    private JButton btnByHand;
    private JButton btnOpenFile;
    private JButton btnReadFile;
    private JLabel lbNum;
    private JSpinner spNum;
    private JButton btnCreateArray;
    private JButton btnDeleteArray;
    private JButton btnSetZero;
    private JLabel lbMaxNum;
    private JPanel pnImitiate;
    private JLabel lbPoint1 = new JLabel();
    private JLabel lbPoint2 = new JLabel();
    private JLabel lbPointM = new JLabel();
    private ButtonGroup grSort;
    private ActionListener eInterchangeSort, eSelectionSort, eBubbleSort, eInsertionSort, eShellSort, eHeapSort, eQuickSort, eMergeSort;
    private JButton btnNewButton;
    private int num;
    private JLabel[] lbArrays;
    private int[] array;

    /**
     * Creates new form main
     */
    public main() {
        initComponents();
        initialzation();
    }

    private void initialzation() {
        setTitle("Mô phỏng thuật toán");
        setBounds(100, 100, 1376, 742);
        setLocationRelativeTo(null);
        //
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.menu);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Thêm tiêu đề
        lbTitle = new JLabel("MÔ PHỎNG CÁC THUẬT TOÁN SĂP XẾP");
        lbTitle.setBackground(SystemColor.menu);
        lbTitle.setBounds(5, 5, 1286, 28);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 23));
        contentPane.add(lbTitle);

        //Panel dữ liệu
        pnArray = new JPanel();
        pnArray.setBackground(SystemColor.menu);
        pnArray.setBorder(new TitledBorder(null, "Dữ liệu", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        //Panel hiển thị code thuật toán
        pnCode = new JPanel();
        pnCode.setBackground(SystemColor.menu);
        pnCode.setBorder(new TitledBorder(null, "Code thuật toán", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        //Panel hiển thị danh sách chọn thuật toán
        pnAlgorithm = new JPanel();
        pnAlgorithm.setBackground(SystemColor.menu);
        pnAlgorithm.setBorder(new TitledBorder(null, "Danh sách thuật toán", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        //Panel điều khiển
        pnControl = new JPanel();
        pnControl.setBackground(SystemColor.menu);
        pnControl.setBorder(new TitledBorder(null, "Khởi chạy thuật toán", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnControl.setLayout(null);

        //Panel Log
        pnLog = new JPanel();
        pnLog.setBackground(SystemColor.menu);
        pnLog.setBorder(new TitledBorder(null, "Bảng ghi thuật toán", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        //Thêm thanh kéo tốc độ vào Panel Control
        slSpeed = new JSlider();
        slSpeed.setOrientation(SwingConstants.VERTICAL);
        slSpeed.setBounds(160, 21, 32, 244);
        slSpeed.setMinimum(1);
        slSpeed.setMaximum(9);
        slSpeed.setValue(5);
        pnControl.add(slSpeed);
        //Thêm một radioButton sắp xếp tăng dần vào Panel Control
        rdIncrease = new JRadioButton("Sắp xếp tăng dần");
        rdIncrease.setBounds(20, 42, 144, 23);
        pnControl.add(rdIncrease);
        //Thêm một radioButton giảm dần vào Panel Control	
        rdDecrease = new JRadioButton("Sắp xếp giảm dần");
        rdDecrease.setBounds(20, 87, 144, 23);
        pnControl.add(rdDecrease);

        btnSort = new JButton("Khởi chạy thuật toán");
        btnSort.setBackground(SystemColor.activeCaption);
        btnSort.setBounds(20, 140, 145, 35);
        btnSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                if (!isSorted()) {
//                    setState(3);
//                    for (int i = 0; i < num; i++) {
//                        lbArrays[i].setForeground(Color.BLUE);
//                    }
//
//                    if (rdInterchangeSort.isSelected()) {
//                        InterchangeSort();
//                    }
//                    if (rdSelectionSort.isSelected()) {
//                        SelectionSort();
//                    }
//                    if (rdBubbleSort.isSelected()) {
//                        BubbleSort();
//                    }
//                    if (rdInsertionSort.isSelected()) {
//                        InsertionSort();
//                    }
//                    if (rdShellSort.isSelected()) {
//                        ShellSort();
//                    }
//                    if (rdHeapSort.isSelected()) {
//                        HeapSort();
//                        threadReLocate();
//                    }
//
//                    if (rdQuickSort.isSelected()) {
//                        QuickSort();
//                    }
//                    if (rdMergeSort.isSelected()) {
//                        MergeSort();
//                    }
//                    waitEnd();
//                }
            }
        });
        pnControl.add(btnSort);

        btnPause = new JButton("Dừng chạy thuật toán");
        btnPause.setBackground(SystemColor.activeCaption);
        btnPause.setBounds(20, 185, 145, 35);
        btnPause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//				deleteArrays();
//				setState(0);
            }
        });
        pnControl.add(btnPause);

        //Thêm các lựa chọn cho danh sách thuật toán
        rdInterchangeSort = new JRadioButton("Interchange Sort");
        rdInterchangeSort.setBounds(24, 44, 149, 23);
        pnAlgorithm.add(rdInterchangeSort);

        rdSelectionSort = new JRadioButton("Selection Sort");
        rdSelectionSort.setBounds(24, 70, 149, 23);
        pnAlgorithm.add(rdSelectionSort);

        rdBubbleSort = new JRadioButton("Bubble Sort");
        rdBubbleSort.setBounds(24, 96, 149, 23);
        pnAlgorithm.add(rdBubbleSort);

        rdInsertionSort = new JRadioButton("Insertion Sort");
        rdInsertionSort.setBounds(24, 122, 149, 23);
        pnAlgorithm.add(rdInsertionSort);

        rdShellSort = new JRadioButton("Shell Sort");
        rdShellSort.setBounds(24, 148, 149, 23);
        pnAlgorithm.add(rdShellSort);

        rdHeapSort = new JRadioButton("Heap Sort");
        rdHeapSort.setBounds(24, 174, 149, 23);
        pnAlgorithm.add(rdHeapSort);

        rdQuickSort = new JRadioButton("Quick Sort");
        rdQuickSort.setBounds(24, 200, 149, 23);
        pnAlgorithm.add(rdQuickSort);

        rdMergeSort = new JRadioButton("Merge Sort");
        rdMergeSort.setBounds(24, 226, 149, 23);
        pnAlgorithm.add(rdMergeSort);
        pnAlgorithm.setLayout(null);

        //Hiển thị code thuật toán
        pnScroll = new JScrollPane();
        pnScroll.setBounds(15, 53, 276, 223); // default 10, 53, 486, 223
        pnCode.add(pnScroll);
        model = new DefaultListModel<>();
        lsCode = new JList<String>(model);
        lsCode.setBorder(new LineBorder(new Color(0, 0, 0)));
        lsCode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsCode.setFont(new Font("Monospaced", Font.BOLD, 14));
        pnScroll.setViewportView(lsCode);

        //Thêm panel khởi tạo mảng vào panel Array
        pnCreateArray = new JPanel();
        pnCreateArray.setBackground(SystemColor.menu);
        pnCreateArray.setBorder(new TitledBorder(null, "Khởi tạo mảng", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        pnSetValueArray = new JPanel();
        pnSetValueArray.setBackground(SystemColor.menu);
        pnSetValueArray.setBorder(new TitledBorder(null, "Thêm dữ liệu vào mảng", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        btnRandom = new JButton("Ngẫu nhiên");
        btnRandom.setBackground(SystemColor.activeCaption);
        btnRandom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // createRandom();
            }
        });
        btnRandom.setBounds(5, 27, 92, 25);

        btnByHand = new JButton("Thủ công");
        btnByHand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                FormInput formInput = new FormInput();
//                formInput.setVisible(true);
//                setState(3);
            }
        });
        btnByHand.setBackground(SystemColor.activeCaption);
        btnByHand.setBounds(105, 27, 90, 25);

        btnOpenFile = new JButton("Mở File");
        btnOpenFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                try {
//                    Desktop desktop = null;
//                    if (Desktop.isDesktopSupported()) {
//                        desktop = Desktop.getDesktop();
//                    }
//                    desktop.open(file);
//                } catch (IOException ioe) {
//                    //file isn't existed
//                    ioe.printStackTrace();
//                }
            }
        });
        btnOpenFile.setBackground(SystemColor.activeCaption);
        btnOpenFile.setBounds(5, 61, 92, 25);

        btnReadFile = new JButton("Đọc File");
        btnReadFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
//                deleteArrays();
//                try {
//                    Scanner in = new Scanner(file);
//                    num = Integer.parseInt(in.nextLine());
//                    array = new int[num];
//                    int pos = 0;
//                    while (in.hasNextLine()) {
//                        array[pos] = Integer.parseInt(in.nextLine());
//                        pos++;
//                    }
//                    in.close();
//                    lbArrays = new JLabel[num];
//
//                    for (int i = 0; i < num; i++) {
//                        //create label, set text "0"
//
//                        lbArrays[i] = new JLabel(String.valueOf(array[i]));
//                        pnImitiate.add(lbArrays[i]);
//
//                        //set size label
//                        lbArrays[i].setSize(50, 50);
//                        lbArrays[i].setOpaque(true);
//                        lbArrays[i].setForeground(Color.BLUE);
//
//                        //set location label
//                        if (i == 0) {
//                            lbArrays[i].setLocation(((int) ((18 - num) * 0.5) * 70) + 100, 150);
//                        } else {
//                            lbArrays[i].setLocation(lbArrays[i - 1].getX() + 70, 150);
//                        }
//
//                        //set fonts
//                        lbArrays[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
//
//                        //set background color
//                        lbArrays[i].setBackground(SystemColor.inactiveCaption);
//
//                        //set text alignment center
//                        lbArrays[i].setHorizontalAlignment(SwingConstants.CENTER);
//                        lbArrays[i].setVerticalAlignment(SwingConstants.CENTER);
//                    }
//                    pnImitiate.setVisible(true);
//                    pnImitiate.validate();
//                    pnImitiate.repaint();
//                    setState(2);
//                } catch (FileNotFoundException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
            }
        });
        btnReadFile.setBackground(SystemColor.activeCaption);
        btnReadFile.setBounds(105, 61, 90, 25);
        pnSetValueArray.setLayout(null);
        pnSetValueArray.add(btnOpenFile);
        pnSetValueArray.add(btnRandom);
        pnSetValueArray.add(btnReadFile);
        pnSetValueArray.add(btnByHand);
        pnArray.setLayout(new BoxLayout(pnArray, BoxLayout.PAGE_AXIS));
        pnArray.add(pnCreateArray);
        pnArray.add(pnSetValueArray);

        //Thêm các thành phần vào panel Khởi tạo mảng
        lbNum = new JLabel("Số phần tử mảng:");
        lbNum.setBounds(10, 27, 139, 20);
        SpinnerModel sm = new SpinnerNumberModel(2, 2, 15, 1);
        spNum = new JSpinner(sm);
        spNum.setBounds(135, 25, 55, 25);
        JFormattedTextField txt = ((JSpinner.NumberEditor) spNum.getEditor()).getTextField();
        ((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
        btnCreateArray = new JButton("Tạo mảng");
        btnCreateArray.setBackground(SystemColor.activeCaption);
        btnCreateArray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                createArrays();
            }
        });
        btnCreateArray.setBounds(100, 59, 90, 25);

        btnDeleteArray = new JButton("Xóa mảng");
        btnDeleteArray.setBackground(SystemColor.activeCaption);
        btnDeleteArray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //deleteArrays();		
                //setState(0);
            }
        });
        btnDeleteArray.setBounds(100, 95, 90, 25);

        btnSetZero = new JButton("Đặt về 0");
        btnSetZero.setBackground(SystemColor.activeCaption);
        btnSetZero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //setZero();
            }
        });
        btnSetZero.setBounds(10, 95, 90, 25);
        pnCreateArray.setLayout(null);
        pnCreateArray.add(lbNum);
        pnCreateArray.add(btnSetZero);
        pnCreateArray.add(btnCreateArray);
        pnCreateArray.add(spNum);
        pnCreateArray.add(btnDeleteArray);

        lbMaxNum = new JLabel("(Tối đa 15)");
        lbMaxNum.setHorizontalAlignment(SwingConstants.CENTER);
        lbMaxNum.setBounds(5, 47, 109, 14);
        pnCreateArray.add(lbMaxNum);

        //Panel quản lí các tool
        pnTool = new JPanel();
        //pnTool.setBounds(5, 415, 1350, 287);
        pnTool.setBounds(5, 35, 1350, 287);
        pnTool.setLayout(new BoxLayout(pnTool, BoxLayout.LINE_AXIS));
        pnTool.add(pnArray);
        pnTool.add(pnCode);
        pnTool.add(pnCode);
        pnTool.add(pnAlgorithm);
        pnTool.add(pnControl);
        pnTool.add(pnLog);
        contentPane.add(pnTool);

        //Phần Panel Chạy Giả lập
        pnImitiate = new JPanel();
        pnImitiate.setBackground(SystemColor.menu);
        pnImitiate.setBorder(new TitledBorder(null, "Khung chạy giả lập", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnImitiate.setBounds(5, 338, 1350, 365);
        contentPane.add(pnImitiate);
        pnImitiate.setLayout(null);
        lbPoint1.setSize(50, 25);
        lbPoint1.setOpaque(true);
        lbPoint1.setLocation(50, 50);
        lbPoint1.setFont(new Font("Helvetica", Font.BOLD, 17));
//        lbPoint1.setBackground(SystemColor.menu);
        lbPoint1.setBackground(Color.pink);
        lbPoint1.setHorizontalAlignment(SwingConstants.CENTER);
        lbPoint1.setVerticalAlignment(SwingConstants.CENTER);
        pnImitiate.add(lbPoint1);
        pnImitiate.add(lbPoint2);
        lbPoint2.setSize(50, 25);
        lbPoint2.setOpaque(true);
        lbPoint2.setLocation(50, 50);
        lbPoint2.setFont(new Font("Helvetica", Font.BOLD, 17));
        //lbPoint2.setBackground(SystemColor.menu);
        lbPoint2.setBackground(Color.BLUE);
        lbPoint2.setHorizontalAlignment(SwingConstants.CENTER);
        lbPoint2.setVerticalAlignment(SwingConstants.CENTER);
        pnImitiate.add(lbPointM);
        lbPointM.setSize(50, 25);
        lbPointM.setOpaque(true);
        lbPointM.setLocation(50, 50);
        lbPointM.setFont(new Font("Helvetica", Font.BOLD, 17));
        //lbPointM.setBackground(SystemColor.menu);
        lbPointM.setBackground(Color.BLUE);
        lbPointM.setHorizontalAlignment(SwingConstants.CENTER);
        lbPointM.setVerticalAlignment(SwingConstants.CENTER);
        grSort = new ButtonGroup();
        grSort.add(rdInterchangeSort);
        grSort.add(rdSelectionSort);
        grSort.add(rdBubbleSort);
        grSort.add(rdInsertionSort);
        grSort.add(rdShellSort);
        grSort.add(rdHeapSort);
        grSort.add(rdQuickSort);
        grSort.add(rdMergeSort);
        rdInterchangeSort.setSelected(true);
        ButtonGroup grDirect = new ButtonGroup();
        grDirect.add(rdDecrease);
        grDirect.add(rdIncrease);
        rdIncrease.setSelected(true);
        lsCode.setSelectedIndex(0);
        lsCode.ensureIndexIsVisible(lsCode.getSelectedIndex());

        /*
		 * event Action Listener all sorts
         */
        eInterchangeSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
//                model.removeAllElements();
//                addInterchangeSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        eSelectionSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
//                model.removeAllElements();
//                addSelectionSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        eBubbleSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
//                model.removeAllElements();
//                addBubbleSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        eInsertionSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
//                model.removeAllElements();
//                addInsertionSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        eShellSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
//                model.removeAllElements();
//                addShellSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        eHeapSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
//                model.removeAllElements();
//                addHeapSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        eQuickSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
//                model.removeAllElements();
//                addQuickSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        eMergeSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
//                model.removeAllElements();
//                addMergeSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        //add ActionListener to radio buttons
        rdInterchangeSort.addActionListener(eInterchangeSort);
        rdSelectionSort.addActionListener(eSelectionSort);
        rdBubbleSort.addActionListener(eBubbleSort);
        rdInsertionSort.addActionListener(eInsertionSort);
        rdShellSort.addActionListener(eShellSort);
        rdHeapSort.addActionListener(eHeapSort);
        rdQuickSort.addActionListener(eQuickSort);
        rdMergeSort.addActionListener(eMergeSort);

//        model.removeAllElements();
//        //addInterchangeSort();
//        lsCode.setSelectedIndex(0);
        btnNewButton = new JButton("Info");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                FormInfo form = new FormInfo();
//                form.setVisible(true);
            }
        });
        btnNewButton.setBackground(SystemColor.activeCaption);
        btnNewButton.setBounds(1294, 5, 61, 31);
        contentPane.add(btnNewButton);

    }

    public void createArrays() {

        //delete previous arrays and set number elements of array
        //deleteArrays();
        num = (Integer) spNum.getValue();

        lbArrays = new JLabel[num];
        array = new int[num];

        for (int i = 0; i < num; i++) {

            //create label, set text "0"
            lbArrays[i] = new JLabel("0");
            array[i] = 0;
            pnImitiate.add(lbArrays[i]);
            lbArrays[i].setText(String.valueOf(array[i]));

            //set size label
            lbArrays[i].setSize(50, 50);
            lbArrays[i].setOpaque(true);
            lbArrays[i].setForeground(Color.blue);

            //set location label
            if (i == 0) {
                lbArrays[i].setLocation(((int) ((18 - num) * 0.5) * 70) + 100, 300);
            } else {
                lbArrays[i].setLocation(lbArrays[i - 1].getX() + 100, 150);
            }

            //set fonts
            lbArrays[i].setFont(new Font("Tahoma", Font.PLAIN, 30));

            //set background color
            lbArrays[i].setBackground(SystemColor.inactiveCaption);
            //set text alignment center
            lbArrays[i].setHorizontalAlignment(SwingConstants.CENTER);
            lbArrays[i].setVerticalAlignment(SwingConstants.CENTER);
        }

        //pnImitiate.add(lbPoint1);
        //pnImitiate.add(lbPoint2);
        //pnImitiate.add(lbPointM);

        pnImitiate.setVisible(true);
        pnImitiate.validate();
        pnImitiate.repaint();
       // setState(1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
