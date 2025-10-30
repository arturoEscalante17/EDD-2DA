/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva2_3_double_linked_list;

/**
 *
 * @author arthur
 */
public class EVA2_3_DOUBLE_LINKED_LIST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
    Lista lista = new Lista();
        lista.agregar(100);
        lista.agregar(200);
        lista.agregar(300);
        lista.agregar(400);
        lista.agregar(500);
        System.out.println(" Cantidad de nodos: " + lista.size());
        lista.Imprimir();
        lista.imprimirInverso();
        lista.insertarEn(9999, 3);
        System.out.println(" Cantidad de nodos: " + lista.size());
        lista.Imprimir();
       // lista.imprimirInverso();
        lista.eliminar(3);
         System.out.println(" Cantidad de nodos: " + lista.size());
        lista.Imprimir();
        lista.buscar(100);
        lista.buscarEn(3);
    }
    
}
