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
 * @author 201800951 <Pablo Gerardo Schaart Calderon>
 */
public class imprimir implements Runnable {

    Lista_DoblementeEnlazada lc;
    String name;
    Thread t;
    JTextArea jText;
    public static volatile boolean flag;
    public static volatile int time;
    public static volatile boolean Suspendido = false;
            
    public imprimir(String thread, Lista_DoblementeEnlazada lc, JTextArea jTextArea1) {
        this.jText = jTextArea1;
        this.lc = lc;
        name = thread;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        time = 10000;
        flag = false;
        t.start();
    }

    /* Codigo para la Lista doble enlazada
    public imprimir(String thread, Lista_DE lde, JTextArea jTextArea1) {
        this.jText = jTextArea1;
        this.lc = lc;
        name = thread;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        t.start();
    }*/
    public void run() {

        try {
            Node current = lc.inicio;
            do { //if statement
                jText.append(current.carnet + "\n");
                Thread.sleep(time);
                current = current.next;
                 if (Suspendido == true) {
                     do {                         
                        Thread.sleep(1); 
                     } while (Suspendido == true);
                  System.out.println("suspendido");  
                } 
               System.out.println("imprimiendo");
            } while (current != lc.inicio && !flag);
        } catch (InterruptedException e) {
            System.out.println(name + "Interrupted");
        }

        System.out.println(name + " exiting.");
    }

    public void stop() {
        flag = true;
    }

    public void aumentar(int x) {
        time = x;
    }
}
