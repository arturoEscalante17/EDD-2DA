package eva2_4_queue;

public class EVA2_4_QUEUE {

    public static void main(String[] args) {
        MyQueue cola = new MyQueue();
        cola.push(100);
        cola.push(200);
        cola.push(300);
        cola.push(400);

        try {
            System.out.println(cola.peek());
            System.out.println(cola.pop());
            cola.Imprimir();
        } catch (Exception e) {
            // si la lista esta vacía
            System.out.println("Error: " + e.getMessage());
        }
    }

}
