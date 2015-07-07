package cvs;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase me permite crear propietarios
 * @version 27/03/2015
 * @author Santiago Llano
 */

public class GestionarPropietarios extends JFrame {

    private JScrollPane panelArriba;
    private JPanel panelAbajo;
    private JLabel labelagregaroeditarprop;
    private JTextField textoagregarpropietario;
    private JLabel labelcedula;
    private JTextField textocedula;
    private JLabel labelcelular;
    private JTextField textocelular;
    private JTextField textopass;
    private JButton botonguardar;
    private JButton botoneditar;
    private JButton botoneliminar;
    private JButton botonactualizar;
    private JButton botonatras;
    private JButton botonsalir;
    private JTable tabla;

    public GestionarPropietarios() {
        setTitle("Gestionar Propietarios");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        ImageIcon icono = new ImageIcon("../Ressources/icon.png");
        this.setIconImage(icono.getImage());

        Container contentpane = getContentPane();
        contentpane.setLayout(new GridLayout(2, 1));
        
        panelAbajo = new PanelImagen7();
        panelAbajo.setLayout(null);
        panelAbajo.setBackground(Color.BLUE);
        add(panelAbajo);

        panelArriba = new JScrollPane();
        tabla = new JTable();
        
        panelArriba.setViewportView(tabla);// sirve como punto de vista de la tabla
        
        panelArriba.setBackground(Color.red);
        

        add(panelArriba);

        panelArriba.setBackground(Color.red);

        

        labelagregaroeditarprop = new JLabel("Agregar o Editar Propietario");
        labelagregaroeditarprop.setBounds(20, 20, 200, 30);
        panelAbajo.add(labelagregaroeditarprop);
        textoagregarpropietario = new JTextField();
        textoagregarpropietario.setBounds(20, 50, 150, 30);
        panelAbajo.add(textoagregarpropietario);
        labelcedula = new JLabel("Cedula");
        labelcedula.setBounds(20, 80, 150, 30);
        panelAbajo.add(labelcedula);
        textocedula = new JTextField();
        textocedula.setBounds(20, 110, 150, 30);
        panelAbajo.add(textocedula);
        labelcelular = new JLabel("Celular");
        labelcelular.setBounds(20, 140, 150, 30);
        panelAbajo.add(labelcelular);
        textocelular = new JTextField();
        textocelular.setBounds(20, 170, 150, 30);
        textopass= new JTextField("1234");
        panelAbajo.add(textocelular);
        botonguardar = new JButton("Guardar");
        botonguardar.setBounds(200, 50, 100, 30);
        panelAbajo.add(botonguardar);
        botoneditar = new JButton("editar");
        botoneditar.setBounds(200, 110, 100, 30);
        panelAbajo.add(botoneditar);
        botoneliminar = new JButton("eliminar");
        botoneliminar.setBounds(200, 170, 100, 30);
        panelAbajo.add(botoneliminar);
        
        botonactualizar = new JButton("Actualizar");
        botonactualizar.setBounds(200, 220, 100, 30);
        panelAbajo.add(botonactualizar);
        
        botonatras = new JButton("Atras");
        botonatras.setBounds(20, 220, 80, 30);
        panelAbajo.add(botonatras);
        
        botonsalir = new JButton("Salir");
        botonsalir.setBounds(110, 220, 80, 30);
        panelAbajo.add(botonsalir);

        botonatras.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent ev) {
                new Menuppaladministracion();

            }

            @Override
            public void mousePressed(MouseEvent ev) {

            }

            @Override
            public void mouseReleased(MouseEvent ev) {

            }

            @Override
            public void mouseEntered(MouseEvent ev) {

            }

            @Override
            public void mouseExited(MouseEvent ev) {

            }
        });

        botonactualizar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actualizar();
            }
        });

        botonguardar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String nombre = textoagregarpropietario.getText();
                String cedula = textocedula.getText();
                long celular = Long.parseLong(textocelular.getText());
                String Pass = textopass.getText();

                Propietario PR = new Propietario(cedula, nombre, celular, null, Pass);
                Propietario.propietarios.add(PR);
                JOptionPane.showMessageDialog(null, "Propietario Agregado Correctamente",
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
                borrartodo();
                actualizar();
            }
        });
        botoneditar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textoagregarpropietario.getText();
                String cedula = textocedula.getText();
                long celular = Long.parseLong(textocelular.getText());
                
                for (int i = 0; i < Propietario.propietarios.size(); i++) {
                    if(Propietario.propietarios.get(i).info.cedula.equals(cedula)) {
                        Propietario.propietarios.get(i).info.nombre = nombre;
                        Propietario.propietarios.get(i).info.celular = celular;
                        actualizar();
                        break;
                    }
                }
            }
        }); 

        botoneliminar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabla.getSelectedRow() < 0) {
                    JOptionPane.showMessageDialog(null, "No hay nada seleccionado",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int indice = tabla.getSelectedRow();
                    Propietario.propietarios.borrar(indice);
                    actualizar();
                    borrartodo();
                }
            }
        });

        actualizar();

        botonsalir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                /*JOptionPane.showConfirmDialog(null, "Esta seguro que desea salir?",
                 "Confirmacion", JOptionPane.QUESTION_MESSAGE);*/
                new LoginFrame();
                dispose();

            }
        });

        tabla.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (tabla.getSelectedRow() >= 0) {
                    textocedula.setText(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
                    textoagregarpropietario.setText(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
                    textocelular.setText(tabla.getValueAt(tabla.getSelectedRow(), 4).toString());
                }
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

    void actualizar() {
        String[] encabezados = new String[]{"Cedula", "Nombre", "# local", "tel. local", "celular"};
        String[][] datos = new String[Propietario.propietarios.size()][5];
        for (int i = 0; i < Propietario.propietarios.size(); i++) { //Recorrer todo lso propietarios
            Propietario prop = Propietario.propietarios.get(i).info;
            if (prop.local != null) { //Si tiene local
                datos[i] = new String[]{prop.cedula,
                    prop.nombre,
                    Integer.toString(prop.local.numerodelocal),
                    prop.local.nombredelocal,
                    Long.toString(prop.celular)};
            } else { //Si no tiene local
                datos[i] = new String[]{prop.cedula,
                    prop.nombre, "", "", Long.toString(prop.celular)};
            }
        }
        tabla.setModel(new DefaultTableModel(datos, encabezados));
    }

    private void borrartodo() {
        textoagregarpropietario.setText("");
        textocedula.setText("");
        textocelular.setText("");
    }

    public static void main(String[] arg) {
        new GestionarPropietarios();
    }

}
