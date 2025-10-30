package eva2_3_double_linked_list;

public class Lista {

    private Nodo inicio, fin, previo;
    private int tama;

    public Lista() {
        inicio = null;
        previo = null;
        fin = null;
        tama = 0;

    }

    public void agregar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (inicio == null) {//LISTA VACIA
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
        Nodo temp = fin;
        while (temp != null) {
            System.out.print("[" + temp.getValor() + "]"); //TEMP BRINCA DE OBJETO 1 AL SIGUIENTE OBJETO
            temp = temp.getPrevio();
        }
        System.out.println("");
    }

    public void Imprimir() {
        Nodo temp = inicio;//Temp es una variable temporal
        while (temp != null) {
            System.out.print("[" + temp.getValor() + "]"); //TEMP BRINCA DE OBJETO 1 AL SIGUEINTE OBJETO
            temp = temp.getSiguiente();

        }
        System.out.println("");
    }

    public int size() {
        int cont = 0;
        /*Nodo temp = inicio;
//            cont++;
        while (temp != null) {
            cont++;
            temp = temp.getSiguiente();
        }*/
        return tama;
    }

    public void clear() {
        inicio = null;
        fin = null;
        previo = null;
    }

    public void insertarEn(int valor, int posicion) throws Exception {
        if (posicion < 0 || posicion > size()) { // Usa el nuevo size()
            throw new Exception("La posición " + posicion + " no es válida, tiene que estar entre 0 y " + size());
        }

        Nodo nuevo = new Nodo(valor);

        // Insertar en la primera posicion (0) o lista vacía
        if (posicion == 0) {
            if (inicio == null) { // Si la lista está vacía
                inicio = nuevo;
                fin = nuevo;
            } else { // Insertar al inicio de lista no vacía
                nuevo.setSiguiente(inicio);
                inicio.setPrevio(nuevo);
                inicio = nuevo;
            }
        } else if (posicion == size()) { // Insertar al final (usa el mismo código que 'agregar' pero con el control de errores)
            // Esto ya está cubierto por el else del ciclo while a continuación,
            // pero se podría optimizar llamando a 'agregar' si se permite.

            // Para evitar duplicación, el siguiente bloque lo maneja:
            Nodo temp = fin; // El nodo antes del nuevo nodo será 'fin' si insertamos al final
            temp.setSiguiente(nuevo);
            nuevo.setPrevio(temp);
            fin = nuevo; // Actualizamos 'fin'
        } else { // Insertar en medio
            Nodo temp = inicio;
            int cont = 0;
            while (cont < posicion - 1) { // Avanzamos hasta el nodo ANTES de la posición deseada
                temp = temp.getSiguiente();
                cont++;
            }
            // Conectamos el nuevo nodo
            nuevo.setSiguiente(temp.getSiguiente());
            nuevo.setPrevio(temp);
            temp.getSiguiente().setPrevio(nuevo); // El nodo después de 'temp' debe apuntar al 'nuevo'
            temp.setSiguiente(nuevo);
        }

        // Incrementamos el tamaño después de la inserción exitosa
        tama++;
    }

    public void eliminar(int posicion) throws Exception {
        if (inicio == null || posicion < 0 || posicion >= size()) {
            throw new Exception("Posición inválida o lista vacía.");
        }

        // --- Lógica de Eliminación ---
        if (posicion == 0) { // Caso especial: eliminar el primer nodo
            inicio = inicio.getSiguiente();
            if (inicio != null) {
                inicio.setPrevio(null);
            } else {
                fin = null; // Si la lista queda vacía, actualiza fin
            }
        } else {
            Nodo temp = inicio;
            for (int i = 0; i < posicion - 1; i++) { // Nos movemos hasta el nodo ANTERIOR al que queremos eliminar
                temp = temp.getSiguiente();
            }

            Nodo nodoAEliminar = temp.getSiguiente();
            temp.setSiguiente(nodoAEliminar.getSiguiente()); // Saltamos el nodo a eliminar

            if (nodoAEliminar.getSiguiente() != null) { // Si NO estamos eliminando el último nodo
                nodoAEliminar.getSiguiente().setPrevio(temp); // Actualizamos el puntero `previo` del nodo siguiente
            } else {
                fin = temp; // Si eliminamos el último nodo, actualizamos `fin` al nodo anterior (temp)
            }
        }

        // --- Actualización de Tamaño (El cambio clave) ---
        tama--; // ¡Decrementar el contador del tamaño de la lista!
    }

   public void buscar(int valor) {
    // Si la lista está vacía, no hay nada que buscar.
    if (inicio == null) {
        System.out.println("La lista está vacía.");
        return; // Termina el método aquí.
    }

    Nodo temp = inicio; // Empezamos a buscar desde el inicio.
    boolean encontrado = false; // Una variable para saber si lo encontramos.
    int posicion = 0; // Para indicar en qué posición se encontró.

    // Recorremos la lista mientras no lleguemos al final.
    while (temp != null) {
        if (temp.getValor() == valor) {
            // Si el valor del nodo actual es el que buscamos...
            encontrado = true; // ...marcamos que lo encontramos...
            break; // ...y rompemos el bucle para no seguir buscando.
        }
        temp = temp.getSiguiente(); // Si no es, pasamos al siguiente nodo.
        posicion++;
    }

    // Al final, revisamos si lo encontramos para mostrar el mensaje correcto.
    if (encontrado) {
        System.out.println(" valor " + valor + " esta en la posicion " + posicion);
    } else {
        System.out.println(" El valor " + valor + " no existe en la lista ");
    }
}
    public void buscarEn(int posicion) throws Exception {
        if (inicio == null) {//lo primero es verificar si la lista tiene nodos(no puede regresar un valor que no existe)
            throw new Exception("La lista esta vacia");
        }
        int tama = size();
        if (posicion < 0 || posicion >= tama) {
            throw new Exception("La posicion " + posicion + " no es valida, tiene que estar entre 0 y " + (tama - 1));//Lanza una excepcion de que la posicion no es valida
        }
        Nodo temp = inicio;
        for (int i = 0; i < posicion; i++) {// se recorre la lista hasta llegar a la posición ingresada
            temp = temp.getSiguiente();
        }
        System.out.println("el valor en la posicion " + posicion + " es: " + temp.getValor());

        /*   Nodo temp2 = fin;
        for (int i = 0; i < posicion; i++) {
            temp2 = temp2.getPrevio();
        }
        System.out.println("el valor en la posicion " + posicion + " inversamente es: " + temp2.getValor());*/
//        return temp.getValor();// devuelve el valor del nodo 
    }
}
