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
    public static void main(String[] args) {
        // Nombre de documento
        String fileName = "numeros.txt";
        
        //String para guardar informacion del documento
        String[] att = null;
        
        //Guardando informacion del documento en un String Array
        try {
            FileReader inputFile = new FileReader(fileName);
            try {
                Scanner parser = new Scanner(inputFile);
                while (parser.hasNextLine()) {
                    //Delimitador ","
                    String line = parser.nextLine();
                    att = line.split(",");
                }

            } finally {
                //Cerrar documento
                inputFile.close();
            }
            //Errors
        } catch (FileNotFoundException exception) {
            System.out.println(fileName + " not found");
        } catch (IOException exception) {
            System.out.println("Unexpected I/O error occured.");
        }
        
        UI_Area temp = new UI_Area(att);
        temp.setVisible(true);
        //Verificacion que el String esta initializado.
        for (int i = 0; i < att.length; i++) {
            System.out.println(att[i] + " ");
        }

        
    }
}


