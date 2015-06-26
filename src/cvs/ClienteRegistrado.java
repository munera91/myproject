package cvs;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class ClienteRegistrado extends JFrame {

    JLabel bienvenidousuario;
    JLabel buscarproductosolocales;
    JLabel informaciondeinteres;
    JLabel promociones;
    JLabel mapadelsitio;
    JLabel micuenta;
    JLabel cotizaciones;
    JButton botonatras;
    JButton botonsalir;
    JLabel avatar;
    JLabel espaciopublicitario;
    JLabel labelregistrar;

    public ClienteRegistrado(boolean soyRegistrado) {

        if (soyRegistrado == true) {
            setTitle("Cliente registrado");
        } else {
            setTitle("Invitado");
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel contenidoPanelCR = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(40, 70, 40, 0);
        contenidoPanelCR.setBorder(padding);
        setContentPane(contenidoPanelCR);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setVisible(true);
        setSize(600, 600);
        setLocationRelativeTo(null);
        ImageIcon icono = new ImageIcon("../Ressources/icon.png");
        this.setIconImage(icono.getImage());

        Font fuentearial = new Font("Arial", Font.BOLD, 20);
        Map atributos = fuentearial.getAttributes();
        //atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

        Font arial18 = new Font("Arial", Font.BOLD, 17);
        Map atributos2 = arial18.getAttributes();
        atributos2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

        bienvenidousuario = new JLabel("Bienvenido Usuario");
        //bienvenidousuario.setHorizontalAlignment(JTextField.CENTER);
        bienvenidousuario.setFont(fuentearial.deriveFont(atributos));
        buscarproductosolocales = new JLabel("<HTML><U>Buscar Productos o locales<U></HTML>");
        buscarproductosolocales.setForeground(Color.blue);
        buscarproductosolocales.setFont(arial18.deriveFont(atributos2));
        buscarproductosolocales.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        informaciondeinteres = new JLabel("<HTML><U>Informacion de interes<U></HTML>");
        informaciondeinteres.setForeground(Color.blue);
        //informaciondeinteres.setHorizontalAlignment(JTextField.CENTER);
        informaciondeinteres.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        informaciondeinteres.setFont(arial18.deriveFont(atributos2));
        promociones = new JLabel("<HTML><U>Promociones<U></HTML>");
        promociones.setForeground(Color.blue);
        //promociones.setHorizontalAlignment(JTextField.CENTER);
        promociones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        promociones.setFont(arial18.deriveFont(atributos2));
        mapadelsitio = new JLabel("<HTML><U>Mapa del sitio<U></HTML>");
        mapadelsitio.setForeground(Color.blue);
        mapadelsitio.setFont(arial18.deriveFont(atributos2));
        // mapadelsitio.setHorizontalAlignment(JTextField.CENTER);
        mapadelsitio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        micuenta = new JLabel("<HTML><U>Mi cuenta<U></HTML>");

        micuenta.setFont(arial18.deriveFont(atributos2));
        cotizaciones = new JLabel("<HTML><U>Cotizaciones<U></HTML>");

        //cotizaciones.setHorizontalAlignment(JTextField.CENTER);
        cotizaciones.setFont(arial18.deriveFont(atributos2));
        botonatras = new JButton("Atras");
        botonsalir = new JButton("Salir");
        avatar = new JLabel();
        espaciopublicitario = new JLabel();
        labelregistrar = new JLabel("<HTML><U>Registrarse<U></HTML>");
        labelregistrar.setFont(arial18.deriveFont(atributos2));
        labelregistrar.setForeground(Color.blue);

        avatar.setIcon (new ImageIcon("Ressources/perfil.jpg")); //getclass me da la ruta de la clase y get source pone la imagen a partir de eso
        espaciopublicitario.setIcon(new ImageIcon("Ressources/publicidad.jpg"));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(bienvenidousuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(buscarproductosolocales, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(informaciondeinteres, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(promociones, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(mapadelsitio, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(micuenta, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(cotizaciones, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(avatar, gbc);

        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.gridheight = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(espaciopublicitario, gbc);

        gbc.gridx = 1; //columna
        gbc.gridy = 10; //fila
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 2, 5, 2);
        add(botonatras, gbc);

        gbc.gridx = 2; //columna
        gbc.gridy = 10; //fila
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(botonsalir, gbc);

        gbc.gridx = 0; //columna
        gbc.gridy = 9; //fila
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        if (soyRegistrado == false) {
            add(labelregistrar, gbc);
        }
        
        labelregistrar.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new CrearUsuario(false);
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
        

        botonatras.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginFrame();
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

        botonsalir.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
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

        if (!soyRegistrado) {
//            micuenta.setVisible(false);
            micuenta.setForeground(Color.gray);
            cotizaciones.setForeground(Color.gray);
//            cotizaciones.setVisible(false);
        } else {
            micuenta.setForeground(Color.blue);
            //micuenta.setHorizontalAlignment(JTextField.CENTER);
            micuenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            cotizaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            cotizaciones.setForeground(Color.blue);

            micuenta.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    new CrearUsuario(true);
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
    }

    public static void main(String[] arg) {
        new ClienteRegistrado(true);
    }

}
