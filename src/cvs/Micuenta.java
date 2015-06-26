package cvs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Micuenta extends JFrame {

    JLabel labeltipodocumento;
    JLabel labeldocumento;
    JLabel labelapellidos;
    JLabel labelnombre;
    JLabel labeltelefono;
    JLabel labelcelular;
    JLabel labelmail;
    JLabel labelgenero;
    JLabel labelpass;
    JLabel labelconfirmarpass;
    JComboBox<String> comboTipodocumento;
    JTextField textoDocumento;
    JTextField textoApellidos;
    JTextField textoNombre;
    JTextField textoTelefono;
    JTextField textoCelular;
    JTextField textoMail;
    JTextField textoGenero;
    JTextField textoPass;
    JTextField textoConfirmarpass;
    JButton botoncrearusuario;
    JButton botonreestablecer;
    JComboBox combo1;

    public Micuenta() {
        setTitle("Mi Cuenta");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Que hacer cuando se presiona el boton cerrar

        JPanel contenidoPanelMC = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(40, 150, 40, 150);
        contenidoPanelMC.setBorder(padding);
        setContentPane(contenidoPanelMC);

        setLayout(new GridLayout(11, 2, 0, 10));

        labeltipodocumento = new JLabel("Tipo Documento");
        add(labeltipodocumento);

        comboTipodocumento = new JComboBox<>();
        comboTipodocumento.addItem("CC");
        comboTipodocumento.addItem("TI");
        comboTipodocumento.addItem("Pasaporte");
        add(comboTipodocumento);

        labeldocumento = new JLabel("Documento");
        add(labeldocumento);

        textoDocumento = new JTextField();
        add(textoDocumento);

        labelapellidos = new JLabel("Apellidos");
        add(labelapellidos);

        textoApellidos = new JTextField();
        add(textoApellidos);

        labelnombre = new JLabel("Nombre");
        add(labelnombre);

        textoNombre = new JTextField();
        add(textoNombre);

        labeltelefono = new JLabel("Telefono");
        add(labeltelefono);

        textoTelefono = new JTextField();
        add(textoTelefono);

        labelcelular = new JLabel("Celular");
        add(labelcelular);

        textoCelular = new JTextField();
        add(textoCelular);

        labelmail = new JLabel("Correo Electronico");
        add(labelmail);

        textoMail = new JTextField();
        add(textoMail);

        labelgenero = new JLabel("Genero");
        add(labelgenero);

        textoGenero = new JTextField();
        add(textoGenero);

        labelpass = new JLabel("Contraseña");
        add(labelpass);

        textoPass = new JTextField();
        add(textoPass);

        labelconfirmarpass = new JLabel("Confirmar Contraseña");
        add(labelconfirmarpass);

        textoConfirmarpass = new JTextField();
        add(textoConfirmarpass);

        botoncrearusuario = new JButton("Crear Usuario");
        add(botoncrearusuario);
        botoncrearusuario.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String tipoDocumento = (String) comboTipodocumento.getSelectedItem();
                int documento = Integer.parseInt(textoDocumento.getText());
                String apellido = textoApellidos.getText();
                String nombre = textoNombre.getText();
                int telefono = Integer.parseInt(textoTelefono.getText());
                int celular = Integer.parseInt(textoCelular.getText());
                String correo = textoMail.getText();
                String genero = textoGenero.getText();
                String contrasena = textoPass.getText();
                String confirmarpass = textoConfirmarpass.getText();
                if (!contrasena.equals(confirmarpass)) {
                    JOptionPane.showMessageDialog(null, "No coinciden las contraseñas",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Usuario us = new Usuario(tipoDocumento, documento, apellido,
                            nombre, telefono, celular, correo, genero, contrasena);
                    Usuario.usuarios.add(us); //Agregar al array
                    JOptionPane.showMessageDialog(null, "Usuario agregado",
                            "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    new LoginFrame();
                    dispose(); //Me cierro yo
                }
            }
        });

        botonreestablecer = new JButton("Reestablecer");
        add(botonreestablecer);
        botonreestablecer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                comboTipodocumento.setSelectedIndex(0);
                textoDocumento.setText("");
                textoApellidos.setText("");
                textoNombre.setText("");
                textoTelefono.setText("");
                textoCelular.setText("");
                textoMail.setText("");
                textoGenero.setText("");
                textoPass.setText("");
                textoConfirmarpass.setText("");

            }
        });

        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] arg) {
//        new CrearUsuario();
    }

}
