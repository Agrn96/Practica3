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
 */
public class IPC1Practica3 {

    public static void main(String[] args) throws IOException {
        // Nombre de documento
        String fileName = "archivo_entrada.txt";
        Lista_Circular lc = new Lista_Circular();
        //Cambiar por lista doble enlazada
        Lista_Circular ld = new Lista_Circular();
        inicio(fileName, lc, ld);

        //Probando input en el terminal, quitar al finalizar tarea
        lc.display();

        //Abrir GUI
        UI_Area temp = new UI_Area(lc, ld);
        temp.setVisible(true);
    }

    public static void inicio(String fileName, Lista_Circular lc, Lista_Circular ld) throws IOException {
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
