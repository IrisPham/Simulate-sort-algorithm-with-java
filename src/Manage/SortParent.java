/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage;

import Manage.ManagerIJ;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Visual Studio
 */
public abstract class SortParent {
    protected final JList jListRecord;
    protected final JLabel[] lbArray;
    protected final JLabel lbPosI;
    protected final JLabel lbPosJ;
    protected final ManagerIJ pij;
    protected final JFrame frame;
    
    public SortParent(JList jListRecord, JLabel[] lbArray, JLabel lbPosI, JLabel lbPosJ,JFrame frame) {
        this.jListRecord = jListRecord;
        this.lbArray = lbArray;
        this.lbPosI = lbPosI;
        this.lbPosJ = lbPosJ;
        this.frame = frame;
        pij = new ManagerIJ(lbPosI, lbPosJ);
    }
}
