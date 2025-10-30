package eva2_5_stack;

public class EVA2_5_STACK {

    public static void main(String[] args) {
        try {
            MyStack pila = new MyStack();
            pila.push(100);
            pila.push(200);
            pila.push(300);
            pila.push(400);
            pila.push(17);
            pila.peek();
            pila.pop();
            System.out.println(pila.peek());
            System.out.println(pila.pop());
            pila.Imprimir();
        } catch (Exception ex) {
            System.getLogger(EVA2_5_STACK.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

}
