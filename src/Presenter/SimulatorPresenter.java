/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Ui.Main;
import View.Simulator;

/**
 *
 * @author Visual Studio
 */
public class SimulatorPresenter implements SimulatorPresenterIm {

    private final Main main;
    private final Simulator mSimulator;

    public SimulatorPresenter(Main main, Simulator mSimulator) {
        this.main = main;
        this.mSimulator = mSimulator;
    }

    @Override
    public void checkCreateArray(int size) {
        if (size >= 2 || size <= 15) {
            mSimulator.createArray();
            mSimulator.setStateButton(true);
        } else {
            //Thông báo lỗi
        }
    }
    
    @Override
    public void checkDeleteArray(){
        mSimulator.deleteArray();
        mSimulator.setStateButton(false);
    }

    @Override
    public void checkSetZeroArray() {
        mSimulator.setDefaultArray();
    }

    @Override
    public void checkCreateRandom() {
        mSimulator.randomElementArray();
    }

}
