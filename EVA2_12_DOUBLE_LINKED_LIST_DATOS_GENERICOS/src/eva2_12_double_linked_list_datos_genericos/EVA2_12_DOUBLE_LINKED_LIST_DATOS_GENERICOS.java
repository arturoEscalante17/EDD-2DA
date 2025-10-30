package eva2_12_double_linked_list_datos_genericos;

public class EVA2_12_DOUBLE_LINKED_LIST_DATOS_GENERICOS {

    public static void main(String[] args) throws Exception {

        System.out.println("INTEGER: ");

        Lista<Integer> lista = new Lista<Integer>();

        lista.agregar(100);
        lista.agregar(200);
        lista.agregar(300);
        lista.agregar(400);
        lista.agregar(500);

        System.out.println("Cantidad de nodos: " + lista.size());

        lista.imprimir();
        lista.imprimirInverso();

        lista.insertarEn(9999, 3);
        System.out.println("Cantidad de nodos: " + lista.size());
        lista.imprimir();

        lista.eliminar(3);
        System.out.println("Cantidad de nodos: " + lista.size());
        lista.imprimir();

        lista.buscar(100);

        Integer valorEncontrado = lista.buscarEn(3);
        System.out.println("El valor en la posicion 3 es: " + valorEncontrado);

        
        
        System.out.println("");
        System.out.println("STRING: ");

        Lista<String> listaNombres = new Lista<String>();
        listaNombres.agregar("Winter");
        listaNombres.agregar("Is");
        listaNombres.agregar("Coming");
        listaNombres.agregar("... ");

        listaNombres.imprimir();
        System.out.println("Cantidad de nodos: " + listaNombres.size());
        listaNombres.imprimir();

        listaNombres.buscar("Winter");

        String val = listaNombres.buscarEn(0);
        System.out.println("El primer valor es: " + val);
    }

}
