package eva2_1_ejemplo;

public class EVA2_1_EJEMPLO {

    public static void main(String[] args) {
        // TODO code application logic here
        Ejemplo miObj = new Ejemplo();
        miObj.valor = 100;
        miObj.sig = new Ejemplo();
        miObj.sig.valor = 200;
        miObj.sig.sig = new Ejemplo();
        miObj.sig.sig.valor = 300;
        miObj.sig.sig.sig = new Ejemplo();
        miObj.sig.sig.sig.valor = 400;
        miObj.sig.sig.sig.sig = null;

        System.out.print("[" + miObj.valor + "]");
        System.out.print("[" + miObj.sig.valor + "]");
        System.out.print("[" + miObj.sig.sig.valor + "]"); 
        System.out.print("[" + miObj.sig.sig.sig.valor + "]"); 

        Ejemplo temp = miObj;
        while (temp != null) {
            temp = temp.sig;
            System.out.print("[" + temp.valor + "]");
            temp = temp.sig;
        }
    }

}

class Ejemplo {

    public int valor;
    public Ejemplo sig;
}
