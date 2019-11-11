/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.practica3;

import UI_Layout.UI_Area;
import java.io.*;

/**
 *
 * @author 201612174
 * @author 201800951 <Pablo Gerardo Schaart Calderon>
 */
public class IPC1Practica3 {

    public static void main(String[] args) throws IOException {
        // Nombre de documento
        Lista_DoblementeEnlazada lc = new Lista_DoblementeEnlazada();
        //Cambiar por lista doble enlazada
        Lista_DoblementeEnlazada ld = new Lista_DoblementeEnlazada();

        //Probando input en el terminal, quitar al finalizar tarea
        lc.display();

        //Abrir GUI
        UI_Area temp = new UI_Area(lc, ld);
        temp.setVisible(true);
    }

    public static void inicio(String fileName, Lista_DoblementeEnlazada lc, Lista_DoblementeEnlazada ld) throws IOException {
        String[] name = null;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                name = linea.split(",");

                //Agregar a las dos listas;
                if (Integer.parseInt(name[0]) % 2 == 1) {
                    lc.add(Integer.parseInt(name[0]), name[1], Boolean.parseBoolean(name[2]));
                } else {//Cambiar por lista doble enlazada
                    ld.add(Integer.parseInt(name[0]), name[1], Boolean.parseBoolean(name[2]));
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println(fileName + " not found");
        }
    }
}
