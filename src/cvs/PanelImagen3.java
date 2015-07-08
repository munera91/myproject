package cvs;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * La clase panel imagen establece el fondo de la ventana productos
 * @author Camilo Munera
 */

public class PanelImagen3 extends JPanel {
    
    public void paintComponent(Graphics g) {
        
        
        Dimension tam = getSize();
        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/cvs/panel3-1.jpg")).getImage());
        g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
    
    }
          
 }
