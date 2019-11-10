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
public class Lista_DoblementeEnlazada {

    public Node inicio = null;

    Lista_DoblementeEnlazada() {
    }

    public void add(int carnet, String nombre, boolean prioridad) {
        Node newNode = new Node(carnet, nombre, prioridad);
        if (inicio == null) { //Agrega al inicio
            inicio = newNode;
        } else if (inicio.next == inicio) { //Agregar despues del inicio
            inicio.next = newNode;
            newNode.anterior = inicio;
        } else { //Agregar al ultimo del circulo
            Node current = inicio;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.anterior = current;
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
