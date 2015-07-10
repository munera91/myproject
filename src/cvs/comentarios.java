package cvs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class comentarios extends JFrame {

    JLabel labelseccioncomentarios;
    JLabel labelnombre;
    JTextField textonombre;
    JLabel labelcorreo;
    JTextField textocorreo;
    JLabel labeltipocomentario;
    JComboBox<String> combotipocomentario;
    JLabel labeldescripcion;
    JTextField textodescripcion;
    JButton botonenviar;

    public comentarios() {

        setTitle("Seccion de comentarios");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panelcomentarios = new PanelImagen3();
        setContentPane(panelcomentarios);
        setSize(400, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

        Font fuentearial = new Font("Arial", Font.BOLD, 16);
        Map atributos = fuentearial.getAttributes();

        labelseccioncomentarios = new JLabel("Realizar un nuevo comentario");
        labelseccioncomentarios.setBounds(60, 20, 250, 50);
        labelseccioncomentarios.setForeground(Color.WHITE);
        labelseccioncomentarios.setFont(fuentearial);
        panelcomentarios.add(labelseccioncomentarios);

        labelnombre = new JLabel("Nombre");
        labelnombre.setBounds(60, 70, 150, 50);
        panelcomentarios.add(labelnombre);

        textonombre = new JTextField();
        textonombre.setBounds(160, 80, 140, 30);
        panelcomentarios.add(textonombre);

        labelcorreo = new JLabel("Correo");
        labelcorreo.setBounds(60, 110, 150, 50);
        panelcomentarios.add(labelcorreo);

        textocorreo = new JTextField();
        textocorreo.setBounds(160, 120, 140, 30);
        panelcomentarios.add(textocorreo);

        labeltipocomentario = new JLabel("Tipo Comentario");
        labeltipocomentario.setBounds(60, 160, 150, 30);
        panelcomentarios.add(labeltipocomentario);

        combotipocomentario = new JComboBox<>();
        combotipocomentario.setBounds(160, 160, 140, 30);
        combotipocomentario.addItem("Queja");
        combotipocomentario.addItem("Reclamo");
        combotipocomentario.addItem("Inquietud");
        combotipocomentario.addItem("Reconocimiento");
        panelcomentarios.add(combotipocomentario);

        labeldescripcion = new JLabel("Descripcion:");
        labeldescripcion.setBounds(60, 190, 150, 50);
        panelcomentarios.add(labeldescripcion);

        textodescripcion = new JTextField();
        textodescripcion.setBounds(60, 250, 270, 150);
        panelcomentarios.add(textodescripcion);

        botonenviar = new JButton("Enviar Comentario");
        botonenviar.setBounds(120, 430, 160, 30);
        botonenviar.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (textodescripcion.getText() == null) {
                    JOptionPane.showMessageDialog(null, "Completo todos los campos",
                            "Informacion", JOptionPane.ERROR_MESSAGE);
                } else {
                    limpiar();
                    JOptionPane.showMessageDialog(null, "El comentario fue enviado Correctamente, "
                            + "daremos respuesta a su correo electronico en la brevedad posible",
                            "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    new PrincipalWindow(true);
                    dispose();
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
        panelcomentarios.add(botonenviar);

    }

    void limpiar() {
        textocorreo.setText("");
        textodescripcion.setText("");
        textonombre.setText("");
        combotipocomentario.setSelectedIndex(0);

    }

}
