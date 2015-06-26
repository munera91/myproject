package cvs;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PanelImagen51 extends JPanel {
    
    public void paintComponent(Graphics g) {
        
        
        Dimension tam = getSize();
        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/cvs/panel5-1.jpg")).getImage());
        g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
    
    }
          
 }
