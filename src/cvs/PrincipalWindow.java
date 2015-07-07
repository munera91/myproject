package cvs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * ventana de acceso principal al sistema
 * @author Camilo Munera
 * @version 05/04/2015
 */

public class PrincipalWindow extends JFrame {

    JButton botonregistrar;
    JButton botonacceder;
    JButton botonmostrarmapa;
    JLabel labelsecciones;
    JLabel labelayuda;
    JLabel labelcomentarios;
    JLabel labelhaceruncomentario;
    JLabel labelproductos;
    JLabel labeltiendas;
    JLabel labeleventos;
    JLabel labelentretenimiento;
    JLabel labelhorarios;
    JLabel labelsobrelocales;
    JLabel labelcerrarsesion;
    JLabel labelusuario;

    public PrincipalWindow(boolean editando) {

        setTitle("Acceso al sistema");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

        Font fuentearial = new Font("Arial", Font.BOLD, 18);
        Map atributos = fuentearial.getAttributes();

        Font fuentearialpeque = new Font("Arial", Font.PLAIN, 16);
        Map atributos2 = fuentearialpeque.getAttributes();

        JPanel p = new PanelImagen();
        p.setLayout(null);
        p.setBounds(0, 0, getWidth(), getHeight());
        add(p);
        
        

        botonregistrar = new JButton("Registrarse");
        botonregistrar.setBounds(130, 230, 120, 40);
        botonregistrar.addMouseListener(new MouseListener() {

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

        p.add(botonregistrar);

        if (editando != false) {
            botonacceder = new JButton("Mi cuenta");
            botonacceder.setBounds(340, 230, 150, 40);
            botonacceder.addMouseListener(new MouseListener() {

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
            p.add(botonacceder);
        } else {
            botonacceder = new JButton("Acceder");
            botonacceder.setBounds(340, 230, 150, 40);
            botonacceder.addMouseListener(new MouseListener() {

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
            p.add(botonacceder);
        }

        botonmostrarmapa = new JButton("Mostrar Mapa");
        botonmostrarmapa.setBounds(570, 230, 150, 40);
        p.add(botonmostrarmapa);

        labelsecciones = new JLabel("Secciones");
        labelsecciones.setBounds(140, 300, 120, 40);
        labelsecciones.setFont(fuentearial.deriveFont(atributos));
        labelsecciones.setForeground(Color.WHITE);
        p.add(labelsecciones);

        labelayuda = new JLabel("Ayuda");
        labelayuda.setBounds(380, 300, 120, 40);
        labelayuda.setFont(fuentearial.deriveFont(atributos));
        labelayuda.setForeground(Color.WHITE);
        p.add(labelayuda);

        labelcomentarios = new JLabel("Comentarios");
        labelcomentarios.setBounds(585, 300, 120, 40);
        labelcomentarios.setFont(fuentearial.deriveFont(atributos));
        labelcomentarios.setForeground(Color.WHITE);
        p.add(labelcomentarios);

        labeltiendas = new JLabel("Tiendas");
        labeltiendas.setBounds(155, 350, 120, 40);
        labeltiendas.setFont(fuentearialpeque.deriveFont(atributos2));
        labeltiendas.setForeground(Color.WHITE);
        labeltiendas.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new Gestionproductos();
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
        p.add(labeltiendas);

        labelproductos = new JLabel("Productos");
        labelproductos.setBounds(148, 400, 120, 40);
        labelproductos.setFont(fuentearialpeque.deriveFont(atributos2));
        labelproductos.setForeground(Color.WHITE);
        labelproductos.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new productos();
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
        p.add(labelproductos);

        labeleventos = new JLabel("Eventos");
        labeleventos.setBounds(153, 450, 120, 40);
        labeleventos.setFont(fuentearialpeque.deriveFont(atributos2));
        labeleventos.setForeground(Color.WHITE);
        labeleventos.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new eventosdelsitio();
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
        p.add(labeleventos);

        labelhorarios = new JLabel("Horarios");
        labelhorarios.setBounds(380, 350, 120, 40);
        labelhorarios.setFont(fuentearialpeque.deriveFont(atributos2));
        labelhorarios.setForeground(Color.WHITE);
        p.add(labelhorarios);

        labelsobrelocales = new JLabel("Sobre Locales");
        labelsobrelocales.setBounds(360, 400, 120, 40);
        labelsobrelocales.setFont(fuentearialpeque.deriveFont(atributos2));
        labelsobrelocales.setForeground(Color.WHITE);
        p.add(labelsobrelocales);

        labelhaceruncomentario =new JLabel("Hacer un Comentario");
        labelhaceruncomentario.setBounds(565, 350, 150, 40);
        labelhaceruncomentario.setFont(fuentearialpeque.deriveFont(atributos2));
        if(!editando){            
            
            labelhaceruncomentario.setForeground(Color.GRAY);
            labelhaceruncomentario.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Debe Autenticarse para hacer comentarios",
                            "Informacion", JOptionPane.ERROR_MESSAGE);
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
        else{
            labelhaceruncomentario.setForeground(Color.WHITE);
            labelhaceruncomentario.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new eventosdelsitio();
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
        p.add(labelhaceruncomentario);
        
        
        if(editando){
            
        labelusuario = new JLabel ("Bienvenido  " + Usuario.usuarioLogueado.nombre); 
        labelusuario.setFont(fuentearialpeque.deriveFont(atributos2));
        labelusuario.setForeground(Color.WHITE);
        labelusuario.setBounds(5, 5, 250, 40);        
        p.add(labelusuario);
            
        labelcerrarsesion =new JLabel("<HTML><U>Cerrar Sesion<U></HTML>");
        labelcerrarsesion.setFont(fuentearialpeque.deriveFont(atributos2));
        labelcerrarsesion.setForeground(Color.WHITE);
        labelcerrarsesion.setBounds(5, 27, 150, 40);
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
        p.add(labelcerrarsesion);
            
        }
        
       
        
    }

    

    public static void main(String[] args) {

        
        // se agregan dos productos para que se carguen al abrir la ventana productos por defecto        
        Producto.Productos.add(new Producto("C:\\aimages\\zapatodama.jpg", "Zapatos Dama", "Color Rosa", "Ropa", "50.000"));
        Producto.Productos.add(new Producto("C:\\aimages\\camisa.jpg", "Camisa Hombre", "Color Blanco Azul, Tallas M,L", "Ropa", "25.000"));
        
        
        PrincipalWindow f = new PrincipalWindow(false);
        

    }

}
