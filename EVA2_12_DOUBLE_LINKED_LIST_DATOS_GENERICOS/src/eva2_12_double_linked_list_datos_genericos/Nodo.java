package eva2_12_double_linked_list_datos_genericos;

public class Nodo<T> {

    private T valor;

    private Nodo<T> siguiente;
    private Nodo<T> previo;

    public Nodo() {
        this.siguiente = null;
        this.previo = null;
    }

    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
        this.previo = null;
    }

    public Nodo<T> getPrevio() {
        return previo;
    }

    public void setPrevio(Nodo<T> previo) {
        this.previo = previo;
    }

    public T getValor() {
        return valor;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}
