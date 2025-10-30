package eva2_7_grafo;
import java.util.*;

public class Grafo {

    private Map<Vertice, List<Vertice>> adj = new HashMap<>();

    public void agregarVertice(Vertice v) {
     
        adj.putIfAbsent(v, new ArrayList<>());
    }

    public void agregarArista(Vertice v1, Vertice v2) {
        
        if (adj.containsKey(v1) && adj.containsKey(v2)) {
            // Conexión bidireccional (grafo no dirigido)
            adj.get(v1).add(v2);
            adj.get(v2).add(v1); 
        }
    }
    
    
    public Map<Vertice, List<Vertice>> getAdjacencyList() {
        return adj;
    }
}
    
