import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class LienzoDibujo extends JPanel implements Serializable {
    
    // Referencia a la lista de puntos de tu JFrame principal (Dibu)
    private Lista<Point> puntos; 

    public LienzoDibujo(Lista<Point> puntos) {
        this.puntos = puntos;
            addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            // Acceder al campo de la instancia explícitamente
            LienzoDibujo.this.puntos.agregar(new Point(e.getX(), e.getY()));
            LienzoDibujo.this.repaint();
        }
    });

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpia el fondo
        
        int size = puntos.size();
        if (size < 1) return;

        for (int i = 0; i < size; i++) {
            Point p1 = puntos.get(i);

            g.drawOval(p1.x - 2, p1.y - 2, 5, 5); 

            if (i > 0) {
                Point puntoAnterior = puntos.get(i - 1); 
                g.drawLine(puntoAnterior.x, puntoAnterior.y, p1.x, p1.y);
            }
        }
    }
    public void setPuntos(Lista<Point> puntos) {
    this.puntos = puntos;
}
}