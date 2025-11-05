/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva2_11_arbol_binario;

public class EVA2_11_ARBOL_BINARIO {

    public static void main(String[] args) {
        // TODO code application logic here
        Arbol arbol = new Arbol();
        arbol.agregar(13);
        arbol.agregar(10);
        arbol.agregar(18);
        arbol.agregar(2);
        arbol.agregar(11);
        arbol.agregar(17);
        arbol.agregar(20);
        arbol.agregar(16);
        System.out.println("Cantidad de nodos " + arbol.size());
        arbol.ImprimirPreOrder();
        arbol.ImprimirInOrder();
        arbol.ImprimirPostOrder();
    }

}
