package cvs;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * La clase panel imagen establece el fondo del Login
 * @author Camilo Munera
 */

public class PanelImagen2 extends JPanel {
    
    public void paintComponent(Graphics g) {
        
        
        Dimension tam = getSize();
        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/cvs/fondologin.jpg")).getImage());
        g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
    
    }
          
 }
