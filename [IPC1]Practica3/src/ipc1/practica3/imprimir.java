/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.practica3;

import javax.swing.JTextArea;

/**
 *
 * @author 201612174 <Alberto Gabriel Reyes Ning>
 */
public class imprimir implements Runnable {

    String[] att;
    String name;
    Thread t;
    JTextArea jText;

    public imprimir(String thread, String[] att, JTextArea jTextArea1) {
        this.jText = jTextArea1;
        this.att = att;
        name = thread;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        t.start();
    }

    public void run() {
        try {

            for (String a : att) {
                jText.append(a + "\n");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + "Interrupted");
        }
        System.out.println(name + " exiting.");
    }
}
