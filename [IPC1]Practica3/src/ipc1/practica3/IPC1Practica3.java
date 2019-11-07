/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.practica3;

import UI_Layout.UI_Area;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author 201612174
 */
public class IPC1Practica3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Nombre de documento
        String fileName = "archivo_entrada.txt";
        inicio(fileName);
    }
    
    public static void inicio(String fileName) throws IOException {
        String[] name = null;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                name = linea.split(",");
                System.out.println(name[0] + " | " + name[1] + " | " + name[2]);            }
        } catch (FileNotFoundException exception) {
            System.out.println(fileName + " not found");

        }

    }
}
