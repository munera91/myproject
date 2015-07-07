package cvs;

import static cvs.Propietario.propietarios;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

/**
 * Esta clase me permite Crear, Editar, Eliminar y listar locales
 * @version 05/04/2015
 * @author Santiago Llano
 */

public class GestionarLocales extends JFrame {

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
    JList<Local> listaLocales;
    JScrollPane panelScroll;
    
    /**
     * Constructor Gestionar Locales
     * cuenta con dos paneles en el panel izquierdo se visualiza la informacion 
     * agregada en el panel derecho
     */

    public GestionarLocales() {

        setTitle("Gestionar Locales");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        ImageIcon icono = new ImageIcon("../Ressources/icon.png");
        this.setIconImage(icono.getImage());

        Container contentpane = getContentPane();
        contentpane.setLayout(new GridLayout(1, 2));

        panelIzquierdo = new PanelImagen8();
        panelIzquierdo.setLayout(null);

        Border padding = BorderFactory.createEmptyBorder(5, 40, 30, 40);
        panelScroll = new JScrollPane();
        listaLocales = new JList<>();
        panelScroll.setViewportView(listaLocales);
        panelScroll.setBounds(120, 230, 200, 100);
        panelIzquierdo.add(panelScroll);

        botonlistarlocales = new JButton("Listar Locales");
        botonlistarlocales.setBounds(140, 360, 160, 30);
        panelIzquierdo.add(botonlistarlocales);
        botonlistarlocales.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actualizar();
            }
        });

        botoneliminarlocal = new JButton("Eliminar local");
        botoneliminarlocal.setBounds(140, 410, 160, 30);
        panelIzquierdo.add(botoneliminarlocal);
        botoneliminarlocal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Local localSelected = listaLocales.getSelectedValue();
                if (localSelected == null) {
                    JOptionPane.showMessageDialog(null, "No hay nada seleccionado",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Local.locales.borrarNodo(localSelected);
                    actualizar();
                }
            }
        });

        botonatras = new JButton("Atras");
        botonatras.setBounds(140, 460, 160, 30);
        panelIzquierdo.add(botonatras);
        botonatras.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {
                new Menuppaladministracion();

            }
        });

        panelDerecho = new JPanel(new GridLayout(11, 1, 0, 6));
//        Border padding = BorderFactory.createEmptyBorder(1, 10, 30, 40);
        panelDerecho.setBorder(padding);

        crearlocal = new JLabel("Crear o modificar local");
        panelDerecho.add(crearlocal);

        seleccionarlocal = new JLabel("Numero de local");
        panelDerecho.add(seleccionarlocal);
        textoNumeroLocal = new JTextField();
        panelDerecho.add(textoNumeroLocal);

        propietarioactual = new JLabel("Propietario Actual");
        panelDerecho.add(propietarioactual);

        comboPropietarioactual = new JComboBox<>();
        for (int i = 0; i < propietarios.size(); i++) {
            comboPropietarioactual.addItem(propietarios.get(i).info);
        }
        panelDerecho.add(comboPropietarioactual);

        tipodecontrato = new JLabel("Tipo de Contrato");
        panelDerecho.add(tipodecontrato);
        combotipodecontrato = new JComboBox<>();
        combotipodecontrato.addItem("3 Meses");
        combotipodecontrato.addItem("6 Meses");
        combotipodecontrato.addItem("1 año");
        combotipodecontrato.addItem("Indefinido");
        panelDerecho.add(combotipodecontrato);

        nombredelocal = new JLabel("nombre de local");
        panelDerecho.add(nombredelocal);
        textonombredelocal = new JTextField();
        panelDerecho.add(textonombredelocal);

        botonguardar = new JButton("Guardar");
        panelDerecho.add(botonguardar);

        botonsalir = new JButton("Salir");
        panelDerecho.add(botonsalir);

        add(panelIzquierdo);
        add(panelDerecho);

        botonguardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(textoNumeroLocal.getText());
                String nombre = textonombredelocal.getText();
                String tipoContrato = combotipodecontrato.getSelectedItem().toString();
                Propietario propietario = (Propietario) comboPropietarioactual.getSelectedItem();
                boolean esta = false;
                for (int i = 0; i < Local.locales.size(); i++) {
                    if (Local.locales.get(i).info.numerodelocal == num) {
                        esta = true;
                        Local.locales.get(i).info.nombredelocal = nombre; //Editarlo
                        Local.locales.get(i).info.tipocontrato = tipoContrato;
                        propietario.local = Local.locales.get(i).info;
                        break;
                    }

                }

                if (!esta) { //Si no está se agrega
                    Local localNuevo = new Local(num, tipoContrato, nombre);
                    Local.locales.add(localNuevo);
                    propietario.local = localNuevo;

                }
                limpiar();
                actualizar();

               
            }
        });

        listaLocales.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                Local localSeleccionado = listaLocales.getSelectedValue();
                if (localSeleccionado == null) {
                    textoNumeroLocal.setText("");
                    textonombredelocal.setText("");
                    combotipodecontrato.setSelectedIndex(0);
                } else {
                    textoNumeroLocal.setText(Integer.toString(localSeleccionado.numerodelocal));
                    textonombredelocal.setText(localSeleccionado.nombredelocal);
                    for (int i = 0; i < combotipodecontrato.getItemCount(); i++) { //buscar entre los items del combobox 
                        if (((String) combotipodecontrato.getItemAt(i)).equals(localSeleccionado.tipocontrato)) {
                            combotipodecontrato.setSelectedIndex(i);
                            break;
                        }
                    }
                    Propietario propietario = Propietario.getPropietario(localSeleccionado);
                    if (propietario != null) {
                        for (int i = 0; i < comboPropietarioactual.getItemCount(); i++) { //buscar entre los items del combobox 
                            if (((Propietario) comboPropietarioactual.getItemAt(i)).cedula.equals(propietario.cedula)) {
                                comboPropietarioactual.setSelectedIndex(i);
                                break;
                            }
                        }
                    }
                }

               
            }
        });

        botonsalir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    
    //fin Constructor Gestionar Locales
    
    
    /**
     * Este metodo recorre la Lista locales y los agrega para visualizarlos en el JList
     */

    void actualizar() {
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < Local.locales.size(); i++) { //Recorrer todo los locales
            Local local = Local.locales.get(i).info;
            model.addElement(local);
        }
        listaLocales.setModel(model);
    }
    
    /**
     * Este metodo deja en blanco los TextBox
     */

    void limpiar() {
        textoNumeroLocal.setText("");
        textonombredelocal.setText("");
    }

    public static void main(String[] arg) {
        new GestionarLocales();
    }

}
