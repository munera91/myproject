package cvs;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.Border;

public class Menuppaladministracion extends JFrame {

    JLabel labelBienvenido;
    JLabel labelGestionarlocales;
    JLabel labelAdministrarpropietarios;
    JLabel labelGestionarEvento;
    JLabel labelcambiarpassword;
    JButton botonAtras;

    public Menuppaladministracion() {

        setTitle("Menu Principal Administración");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel contenidoPanelMPA = new PanelImagen4();
        Border padding = BorderFactory.createEmptyBorder(40, 250, 40, 250);
        contenidoPanelMPA.setBorder(padding);
        setContentPane(contenidoPanelMPA);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

        Font fuentearial = new Font("Arial", Font.BOLD, 23);
        Map atributos = fuentearial.getAttributes();
        //atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

        Font arial18 = new Font("Arial", Font.BOLD, 18);
        Map atributos2 = arial18.getAttributes();
        //atributos2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

        labelBienvenido = new JLabel("Bienvenido, Administrador");
        labelBienvenido.setHorizontalAlignment(CENTER);
        labelBienvenido.setFont(fuentearial.deriveFont(atributos));
        labelBienvenido.setBounds(200, 50, 400, 20);
        add(labelBienvenido);

        labelAdministrarpropietarios = new JLabel();
        labelAdministrarpropietarios.setIcon(new ImageIcon(getClass().getResource("/cvs/botonpropietarios.png")));
        labelAdministrarpropietarios.setBounds(100, 150, 257, 152);
        labelAdministrarpropietarios.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new GestionarPropietarios();
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
        add(labelAdministrarpropietarios);

        labelGestionarlocales = new JLabel("Gestionar Locales");
        labelGestionarlocales.setIcon(new ImageIcon(getClass().getResource("/cvs/botonlocales.png")));
        labelGestionarlocales.setBounds(100, 300, 257, 152);
        labelGestionarlocales.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new GestionarLocales();
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
        add(labelGestionarlocales);

        labelGestionarEvento = new JLabel("Gestionar Eventos");
        labelGestionarEvento.setIcon(new ImageIcon(getClass().getResource("/cvs/botoneventos.png")));
        labelGestionarEvento.setBounds(450, 150, 257, 152);
        labelGestionarEvento.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new eventos();
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
        add(labelGestionarEvento);

        labelcambiarpassword = new JLabel();
        labelcambiarpassword.setIcon(new ImageIcon(getClass().getResource("/cvs/password.png")));
        labelcambiarpassword.setHorizontalAlignment(CENTER);
        labelcambiarpassword.setBounds(450, 300, 257, 152);
        add(labelcambiarpassword);

        labelcambiarpassword.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String passA = JOptionPane.showInputDialog("Ingrese la contraseña anterior");
                if (passA.equals(Administrador.admin.password)) {
                    String passN = JOptionPane.showInputDialog("Ingrese la nueva contraseña");
                    String passN1 = JOptionPane.showInputDialog("Repíta la nueva contraseña");
                    if (passN.equals(passN1)) {
                        Administrador.admin.password = passN;
                        JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente",
                                "Aviso", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "No coincide las contraseñas",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña es incorrecta",
                            "Error", JOptionPane.ERROR_MESSAGE);
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

        botonAtras = new JButton("Cerrar Sesión");
        botonAtras.setBounds(330, 500, 150, 30);
        botonAtras.addMouseListener(new MouseListener() {

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
        add(botonAtras);

    }

    public static void main(String[] arg) {
        new Menuppaladministracion();
    }

}
