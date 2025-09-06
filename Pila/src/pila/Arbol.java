/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pila;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Mfviloria
 */
public class Arbol {
    private Nodo raiz;
    
    public void agregar(int dato){
        Nodo nodo = new Nodo(dato);
        if (this.raiz == null){
            this.raiz = nodo;
        }else{
            agregarRecursivo(this.raiz,nodo);
        }
    }
    public void agregarRecursivo(Nodo nodo1, Nodo nodo2){
        if (nodo2.getDato() < nodo1.getDato()){
            if (nodo1.getIzquierda()== null){
                nodo1.setIzquierda(nodo2);
            }else{
                agregarRecursivo(nodo1.getIzquierda(), nodo2);
            }
        }else{
            if (nodo1.getDerecha()== null){
                nodo1.setDerecha(nodo2);
            }else{
                agregarRecursivo(nodo1.getDerecha(), nodo2);
            }
        }
    }
    public void imprimirRecursivo(Nodo nodo, int nivel) {
        if (nodo == null) {
            return;
        }

        this.imprimirRecursivo(nodo.getDerecha(), nivel + 1);
        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
        System.out.println(nodo.getDato());
        this.imprimirRecursivo(nodo.getIzquierda(), nivel + 1);
    }
    public void Preorden(Nodo nodo){
        if (nodo == null){
            return;
        }
        System.out.print(nodo.getDato()+ " ");
        Preorden(nodo.getIzquierda());
        Preorden(nodo.getDerecha());
    }
    
    public void Inorden(Nodo nodo){
        if (nodo==null){
            return;
        }
        Inorden(nodo.getIzquierda());
        
        System.out.print(nodo.getDato() + " ");
        Inorden(nodo.getDerecha());
    }
    
    public void Postorden(Nodo nodo){
        if (nodo == null){
            return;
        }
        Postorden(nodo.getIzquierda());
        Postorden(nodo.getDerecha());
        System.out.print(nodo.getDato() + " ");
    }
    public void inpila(Stack<Nodo> pila, Nodo p){
        pila.push(p);
    }
    public void canpila(Stack<Nodo> pila){
        pila.pop();
    }
    public Nodo cima (Stack<Nodo> pila){
        return pila.peek();
    }
    public void postordenIterativo(Nodo raiz){
        Stack<Nodo> pila = new Stack<>();
        Nodo p = raiz;
        Nodo ultimo = null;
        
        do{
            if (p!= null){
                inpila(pila,p);
                p = p.getIzquierda();
                
            }else{
                p = cima(pila);
                canpila(pila);
                if((p.getDerecha() != null) &&(ultimo!=p.getDerecha())){
                    inpila(pila,p);
                    p = p.getDerecha();
                }else{
                    System.out.print(p.getDato() + " ");
                    ultimo = p;
                    p = null;
                }
            }
        }while (!pila.isEmpty() || p!= null);
    }
    
    public void preordenIterativo(Nodo raiz){
        Nodo p = raiz;
        Stack<Nodo> pila = new Stack();
        do{
            if(p != null){
                System.out.print(p.getDato() + " ");
                inpila(pila, p);             
                p = p.getIzquierda();
            }else{
                p = cima(pila);
                canpila(pila);
                p = p.getDerecha();
            }
        }while(!pila.isEmpty() || p != null);
    }
    
    public void inordenIterativo(Nodo raiz){
        Stack<Nodo> pila = new Stack<>();
        Nodo p = raiz;
        do{
            if (p!=null){
                inpila(pila,p);
                p = p.getIzquierda();
                
            }else{
                p = cima(pila);
                canpila(pila);
                System.out.print(p.getDato() + " ");
                p = p.getDerecha();
            }
        }while(!pila.isEmpty() || p != null);
    }
    
    public static int alturaArbol(Nodo n1) {
        if (n1 == null) {
            return 0;
        }
        return Math.max(alturaArbol(n1.getIzquierda()), alturaArbol(n1.getDerecha())) + 1;
    }
    
    public static int peso(Nodo n1){
        if (n1 == null){
            return 0;
        }
        return 1 + peso(n1.getIzquierda()) + peso(n1.getDerecha());
    }
    
    public int nivel(Nodo n1, int buscar, int nivel){
        if (n1 == null){
            System.out.println("El nodo no se encuentra en el arbol");
            
        }
        if (n1.getDato() == buscar ){
            return nivel;
        } 
        if (buscar < n1.getDato()){
            return nivel(n1.getIzquierda(), buscar, nivel+1);
        } else{
            return nivel(n1.getDerecha(), buscar, nivel+1);
        }
    }
    
    public ArrayList<Nodo> nodosEnEseNivel(int nivel, Nodo n, Nodo raiz, ArrayList<Nodo> num){
        if (n == null){
            return num;
        }
        if(this.nivel (raiz, n.getDato(), 0) == nivel){
            //System.out.print(n.getDato() + " ");
             num.add(n);
        }else{
            nodosEnEseNivel(nivel, n.getIzquierda(), raiz, num);
            nodosEnEseNivel(nivel, n.getDerecha(), raiz, num);
        }
        return num;
    }
    public int numnodosEnEseNivel(int nivel, Nodo n, Nodo raiz, ArrayList<Nodo> num){
        if (n == null){
            return num.size();
        }
        
        if(this.nivel (raiz, n.getDato(), 0) == nivel){
            
            num.add(n);
        }else{
            numnodosEnEseNivel(nivel, n.getIzquierda(), raiz, num);
            numnodosEnEseNivel(nivel, n.getDerecha(), raiz, num);
        }
        return num.size();
    }
            
    public boolean arbolCompleto(Nodo raiz, int nivel){
        boolean es =  false;
            while (nivel < this.alturaArbol(raiz)-1){
                ArrayList<Nodo> num = new ArrayList<>();
                if(Math.pow(2,nivel) == this.numnodosEnEseNivel(nivel, raiz, raiz, num)){
                    es = true;
                }else{
                    return false;
                }
                nivel++;
            }
            
            if (this.eshoja(raiz) == true){
                return true;
            }else{
                return false;
            }
        }
    
    public boolean eshoja(Nodo n){
        boolean hueco = false, alineIzq = false;
        ArrayList<Nodo> num = new ArrayList<>();
        ArrayList<Nodo> num2 = this.nodosEnEseNivel(this.alturaArbol(n)-2 , n, n, num);
        // Buscando por huecos
        for (Nodo nodo : num2) {
            if(nodo.getIzquierda() != null && nodo.getDerecha() != null){
                if (hueco == true){
                    alineIzq = false;
                    return false;
                }else{
                    alineIzq = true;
                }
            }else{
                if (nodo.getIzquierda() == null && nodo.getDerecha() != null){
                    return false;
                }
                //System.out.println("NULL");
                 hueco = true;
            }    
             
        }
        return alineIzq;
    }
    public static int getcol(int h) {
           if (h == 1) {
               return 1;
           }
           return getcol(h - 1) + getcol(h - 1) + 1;
       }

       public static void printTree(int[][] M, Nodo root, int col, int row, int height) {
           if (root == null) {
               return;
           }
           M[row][col] = root.getDato();
           printTree(M, root.getIzquierda(), col - (int) Math.pow(2, height - 2), row + 1, height - 1);
           printTree(M, root.getDerecha(), col + (int) Math.pow(2, height - 2), row + 1, height - 1);
       }

       public void TreePrinter() {
           int h = alturaArbol(this.raiz);
           int col = getcol(h);
           int[][] M = new int[h][col];
           printTree(M, this.raiz, col / 2, 0, h);
           for (int i = 0; i < h; i++) {
               for (int j = 0; j < col; j++) {
                   if (M[i][j] == 0) {
                       System.out.print("  ");
                   } else {
                       System.out.print(M[i][j] + " ");
                   }
               }
               System.out.println();
           }
       }
       
       public void equivalentes(Nodo arbol1, Nodo arbol2, boolean es, ArrayList<Nodo> nodo){
           if(arbol1 == null && arbol2 == null && this.peso(arbol1) == nodo.size()){
               System.out.println("True");
               return;
           }
           if(arbol1 == null && arbol2 == null && this.peso(arbol1) != nodo.size() ){
               nodo.add(arbol2);
               System.out.println("Nodo");
               equivalentes(arbol1.getIzquierda(), arbol2.getIzquierda(),es, nodo);
               equivalentes(arbol1.getDerecha(), arbol2.getDerecha(), es,nodo);
           } else if(arbol1.getDato() == arbol2.getDato()){
               nodo.add(arbol2);
               System.out.println("Nodo");
               equivalentes(arbol1.getIzquierda(), arbol2.getIzquierda(),es, nodo);
               equivalentes(arbol1.getDerecha(), arbol2.getDerecha(), es,nodo);
           }else{
               System.out.println("False");
           }
           
       }

       public Nodo getRaiz() {
           return raiz;
       }
}
