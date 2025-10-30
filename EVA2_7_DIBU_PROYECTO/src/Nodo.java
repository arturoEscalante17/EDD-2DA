import java.io.Serializable;

public class Nodo<T> implements Serializable {
    
   private T valor; // <-- Cambiamos 'int valor' por 'T valor'
    private Nodo<T> siguiente;
    private Nodo<T> previo;
    
    public Nodo() {
        siguiente = null;
        previo = null;
    }
    
    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
        this.previo = null;
    }
    
    // Getters y Setters actualizados para usar T y Nodo<T>
    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getPrevio() {
        return previo;
    }

    public void setPrevio(Nodo<T> previo) {
        this.previo = previo;
    }
}