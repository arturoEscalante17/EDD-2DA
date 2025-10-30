package eva2_2_lista;

public class EVA2_2_LISTA {

    public static void main(String[] args) {
        long ini, fin, tiempo;
        int[] arreglo = new int[1000000];
        Lista miLista = new Lista();

        /*ini = System.nanoTime();//inicio
        for(int i = 0; i < 1000000; i++){
            arreglo[i] = ((int)(Math.random() * 1000));
        
        }
        for (int i = 0; i < 1000000; i++) {
            miLista.agregar((int)(Math.random() * 1000));
            
        }
        
        fin = System.nanoTime();
        tiempo = fin - ini;
        System.out.println("Tiempo del arreglo:" + tiempo);*/
        //miLista.imprimir();
        miLista.agregar(100);
        miLista.agregar(200);
        miLista.agregar(300);
        miLista.imprimir();
        System.out.println("Número de elementos: " + miLista.size());
        //miLista.insertarEn(999, 2);

        System.out.print("La posición del valor 300 es: ");
        System.out.println(miLista.buscar(300));

        System.out.print("El valor en la posición 2 es: ");
        System.out.println(miLista.buscarEn(2));

        miLista.imprimirInverso();
    }

}
