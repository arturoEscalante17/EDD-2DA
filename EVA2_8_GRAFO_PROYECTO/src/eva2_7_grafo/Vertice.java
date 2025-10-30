package eva2_7_grafo;

public class Vertice {
    private final String nombre;
    private final int x;
    private final int y; 

    public Vertice(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }
    
 
    public String getNombre() {
        return nombre;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
    

