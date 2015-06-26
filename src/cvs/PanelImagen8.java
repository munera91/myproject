package cvs;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelImagen8 extends JPanel {

    
    
    


    public void paintComponent(Graphics g) {
        
        
        Dimension tam = getSize();
        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/cvs/fondolocales1.jpg")).getImage());
        g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);

    }

}
