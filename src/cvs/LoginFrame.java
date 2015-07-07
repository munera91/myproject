package cvs;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * Formulario Login Frame, autentica a usuarios, administradores y propietarios de locales. 
 * @author Camilo Munera
 * @version 05/04/2015
 */

public class LoginFrame extends JFrame {

    JLabel labelBienvenido;
    JLabel labelCorreo;
    JLabel labelContrasena;
    JLabel labelRegistrar;
    JTextField textoCorreo;
    JPasswordField textoContrasena;
    JButton botonIngresar;
    JButton botonAtras;

    public LoginFrame() {
        setTitle("Acceso al sistema");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel PLogin = new PanelImagen2();
        Border padding = BorderFactory.createEmptyBorder(60, 280, 60, 280);
        PLogin.setBorder(padding);
        setContentPane(PLogin);
        PLogin.setLayout(new GridLayout(12, 1, 0, 10));
        PLogin.setBounds(100, 100, WIDTH, WIDTH);

        Font fuentearial = new Font("Arial", Font.BOLD, 16);
        Map atributos = fuentearial.getAttributes();

        labelBienvenido = new JLabel("Bienvenido a CVS");
        labelBienvenido.setForeground(Color.WHITE);
        labelBienvenido.setHorizontalAlignment(JTextField.CENTER);
        labelBienvenido.setFont(fuentearial.deriveFont(atributos));
        add(labelBienvenido);

        labelCorreo = new JLabel("* Correo");
        labelCorreo.setHorizontalAlignment(JTextField.CENTER);
        add(labelCorreo);

        textoCorreo = new JTextField();
        add(textoCorreo);

        labelContrasena = new JLabel("* Contraseña");
        labelContrasena.setHorizontalAlignment(JTextField.CENTER);
        add(labelContrasena);

        textoContrasena = new JPasswordField();
        add(textoContrasena);

//        labelRegistrar = new JLabel("<HTML><U>Registrarse<U></HTML>");
//        labelRegistrar.setHorizontalAlignment(JTextField.CENTER);
//        labelRegistrar.setForeground(Color.BLUE);
//        labelRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//para poner mano
//        labelRegistrar.addMouseListener(new MouseListener() {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                new CrearUsuario(false);
//                dispose();
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });
//        add(labelRegistrar);
        
        
        botonIngresar = new JButton("Ingresar");
        add(botonIngresar);
        botonIngresar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ingresar();

            }

        });

        botonAtras = new JButton("Atras");
        add(botonAtras);
        botonAtras.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent ev) {
                new PrincipalWindow(false);

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

        textoContrasena.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    ingresar();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }
    
    /**
     * metodo ingresar verifica si la informacion ingresada es de un administrador
     * propietario de local o usuario y lo redirecciona a la ventana correspondiente
     * segun su rol
     */

    void ingresar() {

        String correo = textoCorreo.getText();
        String pass = textoContrasena.getText();

        if (correo.equals(Administrador.admin.user) && pass.equals(Administrador.admin.password)) {
            new Menuppaladministracion();
            dispose();
        } else if (Usuario.loguearUsuario(correo, pass)) {
            new PrincipalWindow(true);
            dispose();
        } else if (Propietario.loguearpropietario(correo, pass))  {
            new Gestionproductos();
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "No coincide el usuario y la contraseña",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] arg) {
        new PrincipalWindow(false);
    }
}
