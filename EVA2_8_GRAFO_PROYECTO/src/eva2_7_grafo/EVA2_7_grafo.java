package eva2_7_grafo;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class EVA2_7_grafo {


    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("EVA2_7_grafo: Dibujador de Grafos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Añadir el panel de dibujo
            frame.add(new PanelGrafo()); 
            
            frame.pack();
            frame.setLocationRelativeTo(null); 
            frame.setVisible(true);
        });
    }
}