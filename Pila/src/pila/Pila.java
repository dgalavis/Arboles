/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pila;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Mfviloria
 */
public class Pila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Stack <Integer> pila = new Stack<>();
        int[] vector = {1,4,3,2};
        
        for (int i : vector) {
            pila.push(i); //Meter elementos a la pila
            System.out.println("El tope es: " + pila.peek());// Muestra el tope de la pila
            
        }
        while (!pila.isEmpty()){
            int e = pila.pop();//Eliminar elementos de la pila
            System.out.println("El elemento eliminado fue: " + e);
            if(!pila.isEmpty()){
                System.out.println("El elemento que esta en el tope es: " + pila.peek());// Muestra el tope de la pila
            }else{
                System.out.println("La pila esta vacía");
            }
        }*/
        Arbol arbol = new Arbol();
        arbol.agregar(8);
        arbol.agregar(3);
        arbol.agregar(1);
        arbol.agregar(20);
        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(7);
        arbol.agregar(25);
        arbol.agregar(-1);
        arbol.agregar(4);
        arbol.agregar(2);
        //arbol.agregar(30);
        
        Arbol arbol2 = new Arbol();
        arbol2.agregar(8);
        arbol2.agregar(3);
        arbol2.agregar(1);
        arbol2.agregar(20);
        arbol2.agregar(10);
        arbol2.agregar(5);
        arbol2.agregar(7);
        arbol2.agregar(25);
        arbol2.agregar(-1);
        arbol2.agregar(4);
        arbol2.agregar(2);
        /*
        
        arbol.imprimirRecursivo(arbol.getRaiz(), 0);
        System.out.println("\n\nPreorden:");
        arbol.Preorden(arbol.getRaiz());
        System.out.println("\n\nInorden:");
        arbol.Inorden(arbol.getRaiz());
        System.out.println("\n\nPosorden:");
        arbol.Postorden(arbol.getRaiz());
        
        System.out.println("\n\nPosorden iterativo:");
        arbol.postordenIterativo(arbol.getRaiz());
        System.out.println("\n\nPreorden iterativo:");
        arbol.preordenIterativo(arbol.getRaiz());
        System.out.println("\n\nInorden iterativo:");
        arbol.inordenIterativo(arbol.getRaiz());
        
        
        int alt = arbol.alturaArbol(arbol.getRaiz());
        System.out.println("\n\nAltura:" + alt);
        
        int p = arbol.peso(arbol.getRaiz());
        System.out.println("Peso:" + p);
        
        int nivel = arbol.nivel(arbol.getRaiz(),8,0);
        System.out.println("Nivel del nodo buscado: " + nivel);
        ArrayList<Nodo> lista = new ArrayList<>();
         int num = arbol.numnodosEnEseNivel(3,arbol.getRaiz(), arbol.getRaiz(), lista);
         System.out.println("Número de nodos en ese nivel: " + num);
         
         System.out.println("Nodos en el nivel ingresado: ");
         ArrayList<Nodo> lista2 = new ArrayList<>();
         for (Nodo nodo : arbol.nodosEnEseNivel(3,arbol.getRaiz(), arbol.getRaiz(), lista2)) {
             System.out.print(nodo.getDato() + " ");
        }
         
        System.out.println("\n¿El arbol es de tipo completo?: "+ arbol.arbolCompleto(arbol.getRaiz(), 0));
        */
        arbol.TreePrinter();
        ArrayList<Nodo> nodo = new ArrayList<>();
        //arbol.equivalentes(arbol.getRaiz(), arbol2.getRaiz(), false,nodo);
    }
    
}
