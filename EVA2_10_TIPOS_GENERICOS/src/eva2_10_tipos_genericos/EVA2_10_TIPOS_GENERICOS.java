/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva2_10_tipos_genericos;

/**
 *
 * @author arthur
 */
public class EVA2_10_TIPOS_GENERICOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Nodo<String> nodo = new Nodo<String>();
        nodo.setValor("Juan Perez");

        System.out.println("Valor del nodo: " + nodo.getValor());

    }

    static class Nodo<T> {//Tipo de dato generico al momento de que se declare entre corchetes se pone le tipo de dato

        private T valor;
        private Nodo siguiente;
        private Nodo previo;

        public Nodo() {
            siguiente = null;
            previo = null;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public T getValor() {
            return valor;
        }

        public void setValor(T valor) {
            this.valor = valor;
        }

        public Nodo(T valor) {
            this.valor = valor;
        }

    }

}
