package arbolavl;

/**
 *
 * @author coleyf
 */
public class ArbolAVL {

    public static void main(String[] args) {
        // TODO code application logic here
        Arbol arbol = new Arbol();
        int[] valores = {33, 22, 77, 15, 25, 11, 55, 88, 35, 66, 99};
        int[] valores2 = {8, 9, 11, 15, 19, 20, 21, 7, 3, 2, 1, 5, 6, 4, 13, 14, 10, 12, 17, 16, 18};
        int[] valoresEliminar = {88, 99, 22, 33, 11, 15, 35, 66, 77, 55};
        int[] valoresEliminar2 = {21, 14, 9, 10, 19, 5, 16};
        for (int i : valores2) {
            arbol.insertar(i);
            System.out.println("se agrega el valor " + i);
            arbol.TreePrinter();
            System.out.println("\n");
        }
        System.out.println("ÁRBOL TERMINADO");
        
        
        for (int i : valoresEliminar2) {
            arbol.delete(arbol.getRaiz(), i);
            System.out.println("Se eliminó el valor " + i);
            arbol.TreePrinter();
            System.out.println("\n");
        }
        System.out.println("ELIMINACIÓN TERMINADA");
        
    }
    
}
