package cvs;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
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

public class eventosdelsitio extends JFrame {

    JPanel panelIzquierdo, panelDerecho;
    JLabel labellistadodelocales;
    JButton botoneliminarlocal;
    JButton botonatras;
    JButton botonlistarlocales;
    JLabel crearlocal;
    JLabel seleccionarlocal;
    JLabel propietarioactual;
    JLabel tipodecontrato;
    JLabel nombredelocal;
    JTextField textoNumeroLocal;
    JComboBox<Propietario> comboPropietarioactual;
    JComboBox<String> combotipodecontrato;
    JTextField textonombredelocal;
    JButton botonguardar;
    JButton botonsalir;
    JScrollPane panelScroll;
    JLabel labelnombreevento;
    JTextField textoevento;
    JDateChooser calendar;
    JButton botonbuscar;
    JLabel labelfecha;
    JLabel labelproximoseventos;
    JLabel labelimagen;
    JButton botoncargar;

    public eventosdelsitio() {
        setTitle("Eventos2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        Container contentpane = getContentPane();
        contentpane.setLayout(new GridLayout(1, 2));

        //panelIzquierdo = new JPanel(new GridLayout(9, 1, 0, 6));
        //Border padding = BorderFactory.createEmptyBorder(5, 40, 30, 40);
        //panelIzquierdo.setBorder(padding);
        JPanel Peventos = new PanelImagen3();
        Peventos.setLayout(null);
        Peventos.setBounds(0, 0, getWidth(), getHeight());
        add(Peventos);
        
         panelDerecho = new JPanel(new GridLayout(11, 1, 0, 6));
//        Border padding = BorderFactory.createEmptyBorder(1, 10, 30, 40);
        // panelDerecho.setBorder(padding);
        

        labelimagen = new JLabel();

        add(panelDerecho);

        Font fuentearial = new Font("Arial", Font.BOLD, 18);
        Map atributos = fuentearial.getAttributes();

        labelnombreevento = new JLabel("Nombre del evento");
        labelnombreevento.setBounds(100, 100, 200, 40);
        labelnombreevento.setFont(fuentearial);
        labelnombreevento.setForeground(Color.white);
        Peventos.add(labelnombreevento);

        textoevento = new JTextField();
        textoevento.setBounds(100, 150, 90, 30);
        Peventos.add(textoevento);

        labelfecha = new JLabel("Fecha del Evento");
        labelfecha.setBounds(100, 200, 160, 40);
        labelfecha.setFont(fuentearial);
        labelfecha.setForeground(Color.WHITE);
        Peventos.add(labelfecha);

        calendar = new JDateChooser();
        calendar.setBounds(100, 250, 120, 40);
        Peventos.add(calendar);

        botoncargar = new JButton("Cargar Imagen");
        botoncargar.setBounds(100, 380, 80, 40);
        botoncargar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selector = new JFileChooser();
                int estado = selector.showOpenDialog(null);
                File archivoelegido = selector.getSelectedFile();
                String ruta = archivoelegido.getPath();
                if (archivoelegido.exists()) {
                    System.out.println("bien");
                } else {
                    System.out.println("no bien");
                }
                if (estado == JFileChooser.APPROVE_OPTION);
                {
                    ImageIcon imagen = new ImageIcon(ruta);
                    JLabel etiqueta = new JLabel(imagen);
                    panelDerecho.add(etiqueta);
                    
                   

                }

            }
        });

        Peventos.add(botoncargar);

        botonbuscar = new JButton("Buscar");
        botonbuscar.setBounds(100, 330, 80, 40);
        Peventos.add(botonbuscar);

        botonatras = new JButton("Atras");
        botonatras.setBounds(230, 330, 80, 40);
        Peventos.add(botonatras);
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

       

    }

    public static void main(String[] arg) {
        new eventosdelsitio();
    }

}
