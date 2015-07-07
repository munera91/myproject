package cvs;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class productos extends JFrame {

    JButton botonbuscar;
    JComboBox<String> comboproductos;
    JTextField textobuscar;
    JLabel labelbuscar;
    JLabel labelfiltrocategoria;
    JButton botonfiltro;
    JTextField prueba;
    JPanel panelproductos;
    JPanel panelbusquedaProductos;
    JScrollPane sc;
    JButton botonmostrartodos;
    JButton botonatras;

    public productos() {
        setTitle("Productos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        panelbusquedaProductos = new PanelImagen52();
        sc = new JScrollPane(panelbusquedaProductos);
        panelbusquedaProductos.setLayout(null);
        sc.setBounds(250, 0, 520, 600);
        add(sc);

        panelproductos = new PanelImagen51();
        panelproductos.setLayout(null);
        panelproductos.setBounds(550, 0, 250, 600);
        add(panelproductos);

        labelbuscar = new JLabel("Que desea Buscar?");
        labelbuscar.setBounds(20, 40, 140, 30);
        panelproductos.add(labelbuscar);

        textobuscar = new JTextField();
        textobuscar.setBounds(20, 80, 150, 30);
        panelproductos.add(textobuscar);

        labelfiltrocategoria = new JLabel("Filtrar por categoria");
        labelfiltrocategoria.setBounds(20, 180, 150, 40);
        panelproductos.add(labelfiltrocategoria);

        comboproductos = new JComboBox<>();
        comboproductos.addItem("Ropa");
        comboproductos.addItem("Tecnologia");
        comboproductos.addItem("Deporte");
        comboproductos.addItem("Hogar");
        comboproductos.addItem("Ocio");
        comboproductos.setBounds(20, 230, 150, 40);
        panelproductos.add(comboproductos);

        botonbuscar = new JButton("Buscar");
        botonbuscar.setBounds(20, 120, 100, 40);
        panelproductos.add(botonbuscar);
        TraerProductos(Producto.Productos);
        botonbuscar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                lista<Producto> productosenc = new lista<>();
                for (int i = 0; i < Producto.Productos.size(); i++) {
                    if (Producto.Productos.get(i).info.nombreproducto.toLowerCase().contains(textobuscar.getText().toLowerCase())
                            || Producto.Productos.get(i).info.descripcionproducto.toLowerCase().contains(textobuscar.getText().toLowerCase())) {
                        productosenc.add(Producto.Productos.get(i).info);

                    }
                }
                if (productosenc.size() == 0) {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado ningun producto",
                            "Informacion", JOptionPane.ERROR_MESSAGE);
                } else {
                    TraerProductos(productosenc);
                }

            }
        });

        botonfiltro = new JButton("Aplicar Filtro");
        botonfiltro.setBounds(20, 290, 120, 40);
        botonfiltro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                lista<Producto> productosenc = new lista<>();
                String categoria = (String) comboproductos.getSelectedItem();
                for (int i = 0; i < Producto.Productos.size(); i++) {
                    if (Producto.Productos.get(i).info.Categoria.equals(categoria)) {
                        productosenc.add(Producto.Productos.get(i).info);

                    }
                }
                if (productosenc.size() == 0) {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado ningun producto",
                            "Informacion", JOptionPane.ERROR_MESSAGE);
                } else {
                    TraerProductos(productosenc);
                }

            }
        });
        panelproductos.add(botonfiltro);

        botonmostrartodos = new JButton("Mostrar Todos");
        botonmostrartodos.setBounds(20, 420, 120, 40);
        botonmostrartodos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                TraerProductos(Producto.Productos);

            }
        });
        panelproductos.add(botonmostrartodos);

        botonatras = new JButton("Atras");
        botonatras.setBounds(20, 480, 80, 40);
        botonatras.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new PrincipalWindow(false);
                dispose();
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
        panelproductos.add(botonatras);
        

    }

    private void TraerProductos(lista<Producto> productos) {
        panelbusquedaProductos.removeAll();

        int i;
        for (i = 0; i < productos.size(); i++) {
            JPanel panelp = new ProductoInfoPanel(productos.get(i).info, null);
            panelp.setBounds(80, i * 150, 400, 150);
            panelbusquedaProductos.add(panelp);

        }
        panelbusquedaProductos.setPreferredSize(new Dimension(500, i * 150 + 150));
        repaint();

    }

}
