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
public class Lista_Circular {

    public Node inicio = null;

    Lista_Circular() {
    }

    public void add(int carnet, String nombre, boolean prioridad) {
        Node newNode = new Node(carnet, nombre, prioridad);
        if (inicio == null) { //Agrega al inicio
            inicio = newNode;
            newNode.next = inicio;
        } else if (inicio.next == inicio) { //Agregar despues del inicio
            inicio.next = newNode;
            newNode.next = inicio;
        } else { //Agregar al ultimo del circulo
            Node current = inicio;
            while (current.next != inicio) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = inicio;
        }
    }

    public void display() {
        Node current = inicio;
        if (inicio == null) {
            System.out.println("Lista esta vacio");
        } else {
            System.out.println("Nodos son ");
            System.out.println("Carnet    | Nombre");
            do {
                System.out.println(current.carnet + " | " + current.nombre);
                current = current.next;
            } while (current != inicio);
            System.out.println();
        }
    }
}
