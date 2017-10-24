/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Visual Studio
 */
public interface Simulator {
    void createArray();
    void deleteArray();
    void setDefaultArray();
    void randomElementArray();
    void setStateButton(boolean state);
    void pauseThread();
    void stopThread();
}
