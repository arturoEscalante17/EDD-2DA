/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eva2_11_arbol_binario;

/**
 *
 * @author Art
 */
public class Arbol {

    private Nodo raiz;
    private int cont;

    public Arbol() {
        raiz = null;
        int cont = 0;

    }

    public void agregar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            agregarRecursivo(valor, raiz);
        }
    }

    private void agregarRecursivo(int valor, Nodo actual) {
        Nodo nuevo = new Nodo(valor);
        if (valor < actual.getValor()) { // Va a la izquierda
            if (actual.getIzquierda() == null) {
                actual.setIzquierda(nuevo);
            } else {
                agregarRecursivo(valor, actual.getIzquierda());
            }
        } else if (valor > actual.getValor()) { // Va a la derecha
            if (actual.getDerecha() == null) {
                actual.setDerecha(nuevo);
                cont++;
            } else {
                agregarRecursivo(valor, actual.getDerecha());
            }
        }
    }

    public int size() {
        return cont;
    }

    public void ImprimirPreOrder() {
        ImprimirPreOrderRec(raiz);
    }

    public void ImprimirPreOrderRec(Nodo actual) {
        if (actual != null) {
            System.out.print("[ " + actual.getValor() + " ]");//Visita el nodo
            ImprimirPreOrderRec(actual.getIzquierda());//Rec izq
            ImprimirPreOrderRec(actual.getDerecha());//Rec der
        }
    }

    public void ImprimirInOrder() {
        System.out.println("");
        ImprimirInOrderRec(raiz);
    }

    public void ImprimirInOrderRec(Nodo actual) {
        if (actual != null) {
            ImprimirInOrderRec(actual.getIzquierda());//Rec izq
            System.out.print("[ " + actual.getValor() + " ]");//Visita el nodo
            ImprimirInOrderRec(actual.getDerecha());//Rec der
        }
    }
    
     public void ImprimirPostOrder() {
        System.out.println("");
        ImprimirPostOrderRec(raiz);
    }

    public void ImprimirPostOrderRec(Nodo actual) {
        if (actual != null) {
            ImprimirPostOrderRec(actual.getIzquierda());//Rec der
            ImprimirPostOrderRec(actual.getDerecha());//Rec izq
            System.out.print("[ " + actual.getValor() + " ]");//Visita el nodo
            
        }
    }
    

}
