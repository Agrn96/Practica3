/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.practica3;

/**
 *
 * @author 201612174 <Alberto Gabriel Reyes Ning>
 */
public class Node { //Guardar informacion del usuario
    public int carnet;
    public String nombre;
    public boolean prioridad;
    public Node next = null;
    public Node anterior = null;

    public Node(int carnet, String nombre, boolean prioridad) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.prioridad = prioridad;
    }
}
