package cvs;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Gestionproductos extends JFrame {

    JPanel panelIzquierdo, panelDerecho, panelproducto1, panelproducto2, panelproducto3;
    JButton botonatras;
    JButton botonguardar;
    JButton botonsalir;
    JScrollPane panelScroll;
    JLabel labelproducto;
    JTextField textoproducto;
    JLabel labeldescripcionproducto;
    JLabel labelimagen;
    JButton botoncargar;
    JTextField textodescripcion;
    JLabel labeldescripcionproducto1;
    String rutafoto;
    JLabel labelprecioproducto;
    JTextField textoprecioproducto;
    JComboBox<String> comboCategoria;
    JLabel labelcategoria;
    JLabel nombrepropietario;
    Producto productoEdicion = null;
    JLabel labelbienvenido;
    JLabel labelcerrarsesion;

    public Gestionproductos() {
        setTitle("Gestion de Productos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        Container contentpane = getContentPane();
//        contentpane.setLayout(new GridLayout(1, 2));
        contentpane.setLayout(null);

        //panelIzquierdo = new JPanel(new GridLayout(9, 1, 0, 6));
        //Border padding = BorderFactory.createEmptyBorder(5, 40, 30, 40);
        //panelIzquierdo.setBorder(padding);
        JPanel Pgestionproductos = new PanelImagen3();
        Pgestionproductos.setLayout(null);
        Pgestionproductos.setBounds(0, 0, 400, 600);
        add(Pgestionproductos);

        panelDerecho = new PanelImagen31();
        panelDerecho.setBounds(400, 0, 400, 600);
        panelDerecho.setLayout(null);
        add(panelDerecho);

        System.out.println(Pgestionproductos.getHeight());

        Font fuentearial = new Font("Arial", Font.BOLD, 18);
        Map atributos = fuentearial.getAttributes();
        
        Font fuentearialpeque = new Font("Arial", Font.PLAIN, 16);
        Map atributos2 = fuentearialpeque.getAttributes();
        
        labelbienvenido = new JLabel("Bienvenido");
        labelbienvenido.setFont(fuentearial);
        labelbienvenido.setForeground(Color.WHITE);
        labelbienvenido.setBounds(10, 10, 150, 30);
        Pgestionproductos.add(labelbienvenido);
        
        
        nombrepropietario =new JLabel(Propietario.propietariologueado.nombre);
        nombrepropietario.setFont(fuentearial);
        nombrepropietario.setForeground(Color.WHITE);
        nombrepropietario.setBounds(10, 30, 150, 30);
        Pgestionproductos.add(nombrepropietario);
        
        labelcerrarsesion= new JLabel("<HTML><U>Cerrar Sesion<U></HTML>");
        labelcerrarsesion.setFont(fuentearialpeque.deriveFont(atributos2));
        labelcerrarsesion.setForeground(Color.WHITE);
        labelcerrarsesion.setBounds(10, 40, 150, 40);
        labelcerrarsesion.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "La Sesion ha finalizado",
                            "Informacion", JOptionPane.INFORMATION_MESSAGE);
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
        Pgestionproductos.add(labelcerrarsesion);
        

        labelproducto = new JLabel("Nombre del Producto");
        labelproducto.setBounds(70, 80, 200, 40);
        labelproducto.setFont(fuentearial);
        labelproducto.setForeground(Color.white);
        Pgestionproductos.add(labelproducto);

        textoproducto = new JTextField();
        textoproducto.setBounds(70, 120, 190, 30);
        Pgestionproductos.add(textoproducto);

        labeldescripcionproducto = new JLabel("Descripcion del Producto");
        labeldescripcionproducto.setBounds(70, 150, 230, 40);
        labeldescripcionproducto.setFont(fuentearial);
        labeldescripcionproducto.setForeground(Color.WHITE);
        Pgestionproductos.add(labeldescripcionproducto);

        textodescripcion = new JTextField();
        textodescripcion.setBounds(70, 185, 190, 100);
        Pgestionproductos.add(textodescripcion);

        labelcategoria = new JLabel("Categoria");
        labelcategoria.setBounds(70, 280, 230, 40);
        labelcategoria.setFont(fuentearial);
        labelcategoria.setForeground(Color.WHITE);
        Pgestionproductos.add(labelcategoria);

        comboCategoria = new JComboBox<>();
        comboCategoria.addItem("Ropa");
        comboCategoria.addItem("Tecnologia");
        comboCategoria.addItem("Deporte");
        comboCategoria.addItem("Hogar");
        comboCategoria.addItem("Ocio");
        comboCategoria.setBounds(70, 320, 190, 40);
        Pgestionproductos.add(comboCategoria);

        labelprecioproducto = new JLabel("Precio");
        labelprecioproducto.setBounds(70, 360, 190, 40);
        labelprecioproducto.setFont(fuentearial);
        labelprecioproducto.setForeground(Color.WHITE);
        Pgestionproductos.add(labelprecioproducto);

        textoprecioproducto = new JTextField("$ ");
        textoprecioproducto.setBounds(70, 400, 140, 30);
        Pgestionproductos.add(textoprecioproducto);

        botoncargar = new JButton("Cargar Foto");
        botoncargar.setBounds(70, 445, 130, 40);
        botoncargar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selector = new JFileChooser();
                int estado = selector.showOpenDialog(null);
                File archivoelegido = selector.getSelectedFile();
                rutafoto = archivoelegido.getPath();
                if (archivoelegido.exists()) {
                    System.out.println("bien");
                } else {
                    System.out.println("no bien");
                }
//                if (estado == JFileChooser.APPROVE_OPTION);
//                {
//                    ImageIcon imagen = new ImageIcon(rutafoto);
//                    JLabel etiqueta = new JLabel(imagen);
//                    panelproducto1.add(etiqueta);
//
//                }

            }
        });

        Pgestionproductos.add(botoncargar);

        botonatras = new JButton("Atras");
        botonatras.setBounds(70, 500, 80, 40);
        Pgestionproductos.add(botonatras);
        botonatras.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new PrincipalWindow(true);
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

        botonguardar = new JButton("Crear Producto");
        botonguardar.setBounds(160, 500, 140, 40);
        Pgestionproductos.add(botonguardar);
        botonguardar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String nombreproducto = textoproducto.getText();
                String descripproducto = textodescripcion.getText();
                String precioproducto = textoprecioproducto.getText();
                String categoriaproducto = (String) comboCategoria.getSelectedItem();
                if (productoEdicion == null) {
                    Producto Pd = new Producto(rutafoto, nombreproducto, descripproducto, categoriaproducto, precioproducto);
                    Producto.Productos.add(Pd);
                    JOptionPane.showMessageDialog(null, "Producto Agregado Correctamente",
                            "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    productoEdicion.nombreproducto = nombreproducto;
                    productoEdicion.descripcionproducto = descripproducto;
                    productoEdicion.precioproducto = precioproducto;
                    productoEdicion.Categoria = categoriaproducto;
                    JOptionPane.showMessageDialog(null, "Producto Editado Correctamente",
                            "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
                pegarProductos();
                borrartodo();
                productoEdicion = null;
            }
        });

        //En el evento boton guardar, guardarlo en l arrrelo  y llamar a pegarProductos();
        panelDerecho.setLayout(null);
        System.out.println(Producto.Productos.size());
        pegarProductos();
    }

    void pegarProductos() {
        panelDerecho.removeAll();
        ArrayList<Producto> productos = Producto.Productos;
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(productos.get(i).nombreproducto);
            JPanel panel = new ProductoInfoPanel(productos.get(i), this);
            panelDerecho.add(panel);
            panel.setBounds(0, i * 150, panelDerecho.getWidth(), 150);
            
        }

    }

    void borrartodo() {
        textoproducto.setText("");
        textodescripcion.setText("");
        textoprecioproducto.setText("$ ");
    }

    void editar() {
        textoproducto.setText("");
        textodescripcion.setText("");
        textoprecioproducto.setText("$ ");
        comboCategoria.setSelectedIndex(0);
    }

    public static void main(String[] arg) {
        new Gestionproductos();
    }

}
