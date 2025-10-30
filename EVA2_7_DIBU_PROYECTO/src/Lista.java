import java.awt.Point;
import java.io.Serializable;

public class Lista<T> implements Serializable{ // <-- Hacemos la clase genérica
    private Nodo<T> inicio, fin; // <-- Actualizamos los tipos de Nodo
    
    public Lista(){
        inicio = null;
        fin = null;
    }
    
  
    public int size(){
        int tama = 0;
        Nodo<T> temp = inicio;
        while(temp != null){
            tama +=1; 
            temp = temp.getSiguiente();
        }
        return tama;
    }
    

    public void agregar(T valor){ 
        Nodo<T> nuevo = new Nodo<T>(valor); // Creamos un Nodo<T>
        
        if(inicio == null ){ 
            inicio = nuevo;
            fin = nuevo;
        }else{
            fin.setSiguiente(nuevo);
            nuevo.setPrevio(fin);
            fin = nuevo;
        }
    }
    
     public T get(int posi) {
        int tama = size();
        if (inicio == null || posi < 0 || posi >= tama) {
            throw new IndexOutOfBoundsException("Posición incorrecta o lista vacía.");
        }
        
        // Optimización para encontrar el nodo
        Nodo<T> temp;
        if (posi < tama / 2) { // Empieza desde inicio
            temp = inicio;
            for (int i = 0; i < posi; i++) {
                temp = temp.getSiguiente();
            }
        } else { // Empieza desde fin
            temp = fin;
            for (int i = tama - 1; i > posi; i--) {
                temp = temp.getPrevio();
            }
        }
        return temp.getValor();
    }

public void imprimir(){
    Nodo<T> temp = inicio;
    while(temp != null){
        System.out.print("[" + temp.getValor() + "]"); // Imprime el objeto T (Point)
        temp = temp.getSiguiente();
    }
    System.out.println("");
}
}