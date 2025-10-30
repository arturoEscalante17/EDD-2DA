package eva2_2_lista;

public class Lista {

    private Nodo inicio;
    private Nodo fin;

    public Lista() {
        inicio = null;
        fin = null;
    }

    public void agregar(int valor) { //agregar un nodo
        Nodo nuevo = new Nodo(valor);
        //1. Conocer el estado de la lista.
        //2. Si hay nodos, omvernos al final.
        //Verificar si la lista esta vacia:
        if (inicio == null) { //Lista Vacia
            inicio = nuevo;
            fin = nuevo;
        } else { //hay un millon de nodos.
            //movernos al nodo final de la lista.
            /*Nodo temp = inicio;
            while(temp.getSiguiente() != null){
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevo); //agregando el nodo al final*/
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public void imprimir() {
        Nodo temp = inicio;
        while (temp != null) {
            System.out.print("[" + temp.getValor() + "]");
            temp = temp.getSiguiente();
        }
        System.out.println("");
    }

    public int size() {
        int tama = 0;
        Nodo temp = inicio;
        while (temp != null) {
            tama += 1;
            temp = temp.getSiguiente();
        }
        return tama;
    }

    public void insertarEn(int valor, int posi) {
        //veritifcar el estado de la lista.
        //verificar la posicion
        //no podemos insertar nodos en una lista vacia
        if (inicio == null) {
            throw new RuntimeException("Lista vacía, no se pueden insertar nodos");
        } else {
            int tama = size();
            if (posi >= 0 && posi <= tama) {
                Nodo nuevo = new Nodo(valor);
                if (posi == 0) {
                    nuevo.setSiguiente(inicio);
                    inicio = nuevo;
                } else {
                    // Mover temp al punto anterior
                    Nodo temp = inicio;
                    for (int i = 0; i < posi - 1; i++) {
                        temp = temp.getSiguiente();
                    }
                    nuevo.setSiguiente(temp.getSiguiente());
                    temp.setSiguiente(nuevo);
                    if (temp == fin) {
                        fin = nuevo;
                    }
                }
            } else {
                throw new RuntimeException("Posición incorrecta, no se pueden insertar nodos");
            }
        }
    }

    //O(1)
    public boolean listaVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void vaciarLista() {
        inicio = null;
        fin = null;
    }

    //O(N)
    public void borrarEn(int posi) {
        if (inicio == null) {
            throw new RuntimeException("Lista vacía, no hay nodos para borrar");
        }
        int tama = size();
        if (posi >= 0 && posi < tama) {
            if (posi == 0) {
                if (tama == 1) { //un solo nodo en la lista
                    vaciarLista();
                } else {
                    inicio = inicio.getSiguiente();
                }
            } //Borrar nodo intermedio 
            else {
                Nodo temp = inicio;
                for (int i = 0; i < posi - 1; i++) {
                    temp = temp.getSiguiente();
                }
                // Enlazar temp al nodo siguiente
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                if (posi == (tama - 1)) {
                    fin = temp;
                } //verificar que borramos el ultimo nodo
            }
        } else {
            throw new RuntimeException("Posición incorrecta, no existe el nodo a borrar");
        }
    }

    public int buscar(int valor) {
        int posicion = 0;
        Nodo temp = inicio;

        while (temp != null) {
            if (temp.getValor() == valor) {
                return posicion;
            }

            temp = temp.getSiguiente();
            posicion++;
        }
        return -1;
    }

    public int buscarEn(int posi) {
        if (inicio == null) {
            throw new RuntimeException("Lista vacía, no hay nodos para buscar");
        }
        int tama = size();
        if (posi >= 0 && posi < tama) {
            if (posi == 0) {
                return inicio.getValor();
            } else {
                Nodo temp = inicio;
                for (int i = 0; i < posi; i++) {
                    temp = temp.getSiguiente();
                }
                return temp.getValor();
            }
        } else {
            throw new RuntimeException("Posición incorrecta, no existe el nodo en ese índice");
        }
    }

    public void imprimirInverso() {
        int tama = size();
        for (int posi = tama - 1; posi >= 0; posi--) {
            Nodo temp = inicio;

            for (int i = 0; i < posi; i++) {
                temp = temp.getSiguiente();
            }
            System.out.print("[" + temp.getValor() + "]");
        }
        System.out.println("");
    }
}
