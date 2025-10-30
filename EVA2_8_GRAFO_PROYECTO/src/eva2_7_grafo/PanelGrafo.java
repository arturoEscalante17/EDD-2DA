package eva2_7_grafo;

import javax.swing.*;
import java.awt.*;    
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;

public class PanelGrafo extends JPanel {
    
    private Grafo grafo = new Grafo();
    private int contadorVertices = 0;
    private Vertice verticeSeleccionado = null; 
    private final int RADIO_VERTICE = 18;

    public PanelGrafo() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.LIGHT_GRAY);
        addMouseListener(new AdaptadorRaton());
    }

 
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1. DIBUJAR ARISTAS
        g2d.setColor(Color.DARK_GRAY);
        g2d.setStroke(new BasicStroke(2));

        for (Vertice v1 : grafo.getAdjacencyList().keySet()) {
            for (Vertice v2 : grafo.getAdjacencyList().get(v1)) {
                g2d.drawLine(v1.getX(), v1.getY(), v2.getX(), v2.getY());
            }
        }

        // 2. DIBUJAR VÉRTICES
        for (Vertice v : grafo.getAdjacencyList().keySet()) {
            // Colores
            if (v == verticeSeleccionado) {
                g2d.setColor(Color.GREEN); // Resaltar
            } else {
                g2d.setColor(Color.RED);
            }

            // Dibujar círculo
            g2d.fillOval(v.getX() - RADIO_VERTICE, v.getY() - RADIO_VERTICE, 2 * RADIO_VERTICE, 2 * RADIO_VERTICE);

            // Dibujar etiqueta
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, 14));
            g2d.drawString(v.getNombre(), v.getX() - 5, v.getY() + 5);
        }
    }

  //MOUSE
    private class AdaptadorRaton extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            Vertice verticeClickeado = obtenerVerticeEnCoordenadas(x, y);

            if (verticeClickeado == null) {
                // CLIC EN VACÍO: Agregar nuevo vértice
                char nombre = (char) ('A' + contadorVertices++);
                Vertice nuevo = new Vertice(String.valueOf(nombre), x, y);
                grafo.agregarVertice(nuevo);
                verticeSeleccionado = null;
                
            } else {
                // CLIC EN VÉRTICE EXISTENTE: Conexión
                if (verticeSeleccionado == null) {
                    verticeSeleccionado = verticeClickeado; // Primer vértice
                } else if (verticeSeleccionado == verticeClickeado) {
                    verticeSeleccionado = null; // Deseleccionar
                } else {
                    grafo.agregarArista(verticeSeleccionado, verticeClickeado); // Conectar
                    verticeSeleccionado = null; // Reiniciar
                }
            }
            repaint(); 
        }
    }

    
    private Vertice obtenerVerticeEnCoordenadas(int clickX, int clickY) {
        for (Vertice v : grafo.getAdjacencyList().keySet()) {
            double distancia = Math.sqrt(Math.pow(v.getX() - clickX, 2) + Math.pow(v.getY() - clickY, 2));
            if (distancia <= RADIO_VERTICE) {
                return v;
            }
        }
        return null;
    }
}

