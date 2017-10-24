/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.BubbleSortModel;
import Model.InsertSortModel;
import Model.InterChangeSortModel;
import Model.QuickSortModel;
import Model.SelectionSortModel;
import Model.ShellSortModel;
import View.Algorithm;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Visual Studio
 */
public class AlgorithmPresenter implements AlgorithmPresenterIm {

    private final Algorithm mAlgorithm;
    private final JList jListRecord;
    private final JLabel[] lbArray;
    private final JLabel lbPosI;
    private final JLabel lbPosJ;
    private final JFrame frame;
    private boolean isCheckIncrease = false;
    private int n;

    public AlgorithmPresenter(Algorithm mAlgorithm, JList jListRecord, JLabel[] lbArray, JLabel lbPosI, JLabel lbPosJ,JFrame frame) {
        this.mAlgorithm = mAlgorithm;
        this.jListRecord = jListRecord;
        this.lbArray = lbArray;
        this.lbPosI = lbPosI;
        this.lbPosJ = lbPosJ;
        this.frame = frame;
    }

    public AlgorithmPresenter(Algorithm mAlgorithm, JList jListRecord, JLabel[] lbArray, JLabel lbPosI, JLabel lbPosJ, int n,JFrame frame) {
        this.mAlgorithm = mAlgorithm;
        this.jListRecord = jListRecord;
        this.lbArray = lbArray;
        this.lbPosI = lbPosI;
        this.lbPosJ = lbPosJ;
        this.frame = frame;
        this.n = n;
    }

    @Override
    public void chooserAlgorithm(int seri) {
        switch (seri) {
            case 0:
                //Shell Sort
                mAlgorithm.chooserAlgorithm("Thuật toán sắp xếp Shell Sort");
                ShellSortModel ssm = new ShellSortModel(jListRecord, lbArray, lbPosI, lbPosJ,frame);
                //Kiểm tra sắp xếp tăng or giảm
                if(isCheckIncrease){
                    //System.out.println("Sort Giam");
                    ssm.sortDecrease();
                }else{
                    //System.out.println("Sort Tang");
                    ssm.sortIncrease();
                }
                break;
            case 1:
                //Quick Sort
                mAlgorithm.chooserAlgorithm("Thuật toán sắp xếp Quick Sort");
                QuickSortModel qsm = new QuickSortModel(jListRecord, lbArray, lbPosI, lbPosJ, frame,null);
                //Kiểm tra sắp xếp tăng or giảm
                if(isCheckIncrease){
                    //System.out.println("Sort Giam");
                    qsm.sortDecrease();
                }else{
                    //System.out.println("Sort Tang");
                    qsm.sortIncrease();
                }
                break;
            case 2:
                //Insert Sort
                mAlgorithm.chooserAlgorithm("Thuật toán sắp xếp Insert Sort");
                InsertSortModel ism = new InsertSortModel(jListRecord, lbArray, lbPosI, lbPosJ,frame);
                //Kiểm tra sắp xếp tăng or giảm
                if(isCheckIncrease){
                    //System.out.println("Sort Giam");
                    ism.sortDecrease();
                }else{
                    //System.out.println("Sort Tang");
                    ism.sortIncrease();
                }
                break;
            case 3:
                //Bubble Sort
                mAlgorithm.chooserAlgorithm("Thuật toán sắp xếp Bubble Sort");
                BubbleSortModel bsm = new BubbleSortModel(jListRecord, lbArray, lbPosI, lbPosJ,frame);
                //Kiểm tra sắp xếp tăng or giảm
                if (isCheckIncrease) {
                    //System.out.println("Sort Giam");
                    bsm.sortDecrease();
                } else {
                    //System.out.println("Sort Tang");
                    bsm.sortIncrease();
                }
                break;
            case 4:
                //Selection Sort
                mAlgorithm.chooserAlgorithm("Thuật toán sắp xếp Selection Sort");
                SelectionSortModel slm = new SelectionSortModel(jListRecord, lbArray, lbPosI, lbPosJ);
                //Kiểm tra sắp xếp tăng or giảm
                if (isCheckIncrease) {
                    System.out.println("Sort Giam");
                    slm.sortDecrease();
                } else {
                    System.out.println("Sort Tang");
                    slm.sortIncrease();
                }
                break;
            case 5:
                //InterChange Sort
                mAlgorithm.chooserAlgorithm("Thuật toán sắp xếp InterChange Sort");
                //Gọi tới InterChangeModel
                InterChangeSortModel itm = new InterChangeSortModel(jListRecord, lbArray, lbPosI, lbPosJ);
                //Kiểm tra sắp xếp tăng or giảm
                if (isCheckIncrease) {
                    //System.out.println("Sort Giam");
                    itm.sortDecrease();
                } else {
                    // System.out.println("Sort Tang");
                    itm.sortIncrease();
                }
                //HeapSortModel hm = new HeapSortModel(jListRecord, lbArray, lbPosI, lbPosJ,n);
                break;
        }
    }

    @Override
    public void chooserIncrease(boolean state) {
        isCheckIncrease = state;
    }
}
