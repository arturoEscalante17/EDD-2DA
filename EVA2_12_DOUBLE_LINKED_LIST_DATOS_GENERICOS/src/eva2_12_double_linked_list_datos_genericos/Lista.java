package eva2_12_double_linked_list_datos_genericos;

public class Lista<T> {

    private Nodo<T> inicio, fin;
    private int tama;

    public Lista() {
        inicio = null;
        fin = null;
        tama = 0;
    }

    public void agregar(T valor) {

        Nodo<T> nuevo = new Nodo<T>(valor);
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            nuevo.setPrevio(fin);
            fin = nuevo;
        }
        tama++;
    }

    public void imprimirInverso() {

        Nodo<T> temp = fin;
        while (temp != null) {
            System.out.print("[" + temp.getValor() + "]");
            temp = temp.getPrevio();
        }
        System.out.println("");
    }

    public void imprimir() {
        Nodo<T> temp = inicio;
        while (temp != null) {
            System.out.print("[" + temp.getValor() + "]");
            temp = temp.getSiguiente();
        }
        System.out.println("");
    }

    public int size() {
        return tama;
    }

    public void clear() {
        inicio = null;
        fin = null;
        tama = 0; //reiniciar el tamaño
    }

    public void insertarEn(T valor, int posicion) throws Exception {
        if (posicion < 0 || posicion > size()) {
            throw new Exception("La posición " + posicion + " no es válida.");
        }

        Nodo<T> nuevo = new Nodo<T>(valor);

        if (posicion == 0) {
            if (inicio == null) {
                inicio = nuevo;
                fin = nuevo;
            } else {
                nuevo.setSiguiente(inicio);
                inicio.setPrevio(nuevo);
                inicio = nuevo;
            }
        } else if (posicion == size()) { 

            fin.setSiguiente(nuevo);
            nuevo.setPrevio(fin);
            fin = nuevo;
        } else {
            Nodo<T> temp = inicio;
            for (int i = 0; i < posicion - 1; i++) {
                temp = temp.getSiguiente();
            }
            nuevo.setSiguiente(temp.getSiguiente());
            nuevo.setPrevio(temp);
            temp.getSiguiente().setPrevio(nuevo);
            temp.setSiguiente(nuevo);
        }
        tama++;
    }

    public void eliminar(int posicion) throws Exception {
        if (inicio == null || posicion < 0 || posicion >= size()) {
            throw new Exception("Posición inválida o lista vacía.");
        }

        if (posicion == 0) {
            inicio = inicio.getSiguiente();
            if (inicio != null) {
                inicio.setPrevio(null);
            } else {
                fin = null;
            }
        } else {
            Nodo<T> temp = inicio;
            for (int i = 0; i < posicion - 1; i++) {
                temp = temp.getSiguiente();
            }
            Nodo<T> nodoAEliminar = temp.getSiguiente();
            temp.setSiguiente(nodoAEliminar.getSiguiente());

            if (nodoAEliminar.getSiguiente() != null) {
                nodoAEliminar.getSiguiente().setPrevio(temp);
            } else {
                fin = temp;
            }
        }
        tama--;
    }

    public int buscar(T valor) {
        if (inicio == null) {
            return -1;
        }

        Nodo<T> temp = inicio;
        int posicion = 0;

        while (temp != null) {

            if (temp.getValor().equals(valor)) {
                System.out.println("Valor " + valor + " esta en la posicion " + posicion);
                return posicion;
            }
            temp = temp.getSiguiente();
            posicion++;
        }

        System.out.println("El valor " + valor + " no existe en la lista.");
        return -1;
    }

    public T buscarEn(int posicion) throws Exception {
        if (inicio == null) {
            throw new Exception("La lista esta vacia");
        }
        if (posicion < 0 || posicion >= tama) {
            throw new Exception("La posicion " + posicion + " no es valida");
        }

        Nodo<T> temp = inicio;
        for (int i = 0; i < posicion; i++) {
            temp = temp.getSiguiente();
        }

        return temp.getValor();
    }
}
