package cvs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * en esta clase se crea el mini panel visualizado en la pestaña productos, se crea
 * un panel por cada producto
 * @author Camilo Munera
 */

public class ProductoInfoPanel extends JPanel {

    public ProductoInfoPanel(Producto p, Gestionproductos gp) {

        setLayout(null);
        Font fuentearial = new Font("Arial", Font.BOLD, 18);
        Map atributos = fuentearial.getAttributes();

        this.setOpaque(false);

        JLabel avatar = new JLabel();
        avatar.setIcon(new ImageIcon(p.foto));
        //avatar.setIcon(new ImageIcon(getClass().getResource("/cvs/product.png"))); 
        add(avatar);
        avatar.setBounds(35, 15, 120, 120);

        JLabel labelNombre = new JLabel(p.nombreproducto);
        labelNombre.setFont(fuentearial);
        labelNombre.setForeground(Color.white);
        add(labelNombre);
        labelNombre.setBounds(170, 20, 250, 20);

        JLabel labelDescripcion = new JLabel(p.descripcionproducto);
        add(labelDescripcion);
        labelDescripcion.setBounds(170, 50, 180, 20);

        JLabel precio = new JLabel("Precio");
        precio.setFont(fuentearial);
        precio.setForeground(Color.white);
        add(precio);
        precio.setBounds(170, 75, 90, 20);

        JLabel labelprecio = new JLabel(p.precioproducto);
        add(labelprecio);
        labelprecio.setBounds(170, 95, 90, 20);

        
        
        
        JLabel labeleditar = new JLabel("Editar");
        add(labeleditar);
        labeleditar.setBounds(300, 110, 60, 20);
        labeleditar.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gp.textoproducto.setText(p.nombreproducto);
                gp.textodescripcion.setText(p.descripcionproducto);
                gp.textoprecioproducto.setText(p.precioproducto);
                gp.comboCategoria.setSelectedItem(p.Categoria);
                gp.botoncargar.setText("Cambiar Foto");
                gp.botonguardar.setText("Guardar Cambios");
                gp.productoEdicion = p;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }
    
    /**
     * establece el fondo de pantalla
     * @param g redimensiona la imagen al tamaño de la pantalla
     */

    public void paintComponent(Graphics g) {

        Dimension tam = getSize();
        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/cvs/panelsitoeventos.png")).getImage());
        g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);

    }
}
