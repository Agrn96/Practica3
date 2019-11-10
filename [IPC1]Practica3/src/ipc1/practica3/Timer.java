/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.practica3;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author 201612174 <Alberto Gabriel Reyes Ning>
 */
public class Timer implements Runnable {

    imprimir i1;
    String name;
    JLabel tiempo;
    Thread t;
    public static volatile boolean Suspendido = false;

    public Timer(String thread, JLabel tiempo, imprimir i1) {
        this.tiempo = tiempo;
        this.i1 = i1;
        name = thread;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            tiempo.setText(i + "s");
            try {
                Thread.sleep(1000);
                if (Suspendido == true) {
                     do {                         
                        Thread.sleep(1); 
                     } while (Suspendido == true);
                  System.out.println("suspendido");  
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (i1.flag == true) {
                break;
            }
        }
    }

}
