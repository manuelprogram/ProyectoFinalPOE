/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROJECT_FINISH;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author PERSONAL
 */
public class Cesta extends Thread{
    JLabel label;
    public Cesta(JLabel label){
       this.label=label;
    }
    
    public void run(){
        try {
            Thread.sleep(3500);
        } catch (InterruptedException ex) {
        }
        label.setVisible(true);
    }
}
