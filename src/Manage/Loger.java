/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Visual Studio
 */
public class Loger {

    private JList logJList;
    private final DefaultListModel  listModel;
    private final ArrayList<ArrayList<Integer>> listArray;

    public Loger(JList logJList) {
        this.logJList = logJList;

        listModel = new DefaultListModel();
        listArray = new ArrayList<>();
        setListWithModel();
    }

    public JList getLogJList() {
        return logJList;
    }

    public void setLogJList(JList logJList) {
        this.logJList = logJList;
    }

    private void setListWithModel() {
        logJList.setModel(listModel);
    }
    
    private void setHightLight(int position){
        logJList.setSelectedIndex(position);
        /*
        *EventQueue là một lớp độc lập nền tảng xếp hàng các sự kiện
        */
        EventQueue.invokeLater(() -> {
            logJList.ensureIndexIsVisible( logJList.getModel().getSize() -1 );
        });
    }
    public void addElementToArray(int[] array) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            temp.add(array[i]);
        }
        listArray.add(new ArrayList<Integer>(temp));
    }
    
    public void recordLog(int i) {
        ManagerThread.curT++;
        int cur = ManagerThread.curT;
        ManagerThread.threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        ManagerThread.threads[cur - 1].join();
                    }
                    if (i < 0) {
                        String s1 = "Khoi tao: ";
                        String s2 = null;
                        int length = listArray.get(i).size();
                        for (int x = 0; x < length; x++) {
                            s2 = String.valueOf(listArray.get(i).get(x) + " ");
                            s1 = s1.concat(s2);
                        }
                        listModel.addElement(s1);
                        setHightLight(i);
                    } else {
                        String s1 = "Bước: " + i + " :";
                        String s2 = null;
                        int length = listArray.get(i).size();
                        for (int x = 0; x < length; x++) {
                            s2 = String.valueOf(listArray.get(i).get(x) + " ");
                            s1 = s1.concat(s2);
                        }
                        listModel.addElement(s1);
                        setHightLight(i);
                    }
                    Thread.sleep(ManagerThread.time);
                } catch (InterruptedException e) {

                }
            }
        });
        ManagerThread.threads[cur].start();
    }
}
