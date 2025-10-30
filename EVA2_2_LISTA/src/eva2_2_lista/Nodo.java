package eva2_2_lista;

public class Nodo {

    private int valor;
    private int fin;
    private Nodo siguiente;
    private Nodo nuevo;

    public Nodo() {
        siguiente = null;//FINAL DE LA LISTA
    }

    public Nodo(int valor) { // FACILITAR PONER VALORES EN LA LISTA
        this.valor = valor;
        this.siguiente = null;

    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
