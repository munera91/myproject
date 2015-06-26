package cvs;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class eventos extends JFrame {
    
    JLabel labelnombreevento;
    JTextField textoevento;
    JDateChooser calendar;
    JButton botonbuscar;
    JButton botonatras;
    JLabel labelfecha;
    JLabel labelproximoseventos;

    public eventos (){
        
        setTitle("Eventos");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Que hacer cuando se presiona el boton cerrar
        setSize(800,600);
        setLocationRelativeTo(null); //Centra el jframe en la pantalla
        setVisible(true);      
                
        
        JPanel Peventos = new PanelImagen3();
        Peventos.setLayout(null);
        Peventos.setBounds(0, 0, getWidth(), getHeight());
        add(Peventos);
        
        Font fuentearial = new Font("Arial", Font.BOLD, 18);
        Map atributos = fuentearial.getAttributes();
        
        labelnombreevento =new JLabel("Nombre del evento");
        labelnombreevento.setBounds(100, 100, 200, 40);
        labelnombreevento.setFont(fuentearial);
        labelnombreevento.setForeground(Color.white);
        Peventos.add(labelnombreevento);
        
        textoevento =new JTextField();
        textoevento.setBounds(100, 150, 90, 30);
        Peventos.add(textoevento);
        
        labelfecha =new JLabel("Fecha del Evento");
        labelfecha.setBounds(100, 200, 160, 40);
        labelfecha.setFont(fuentearial);
        labelfecha.setForeground(Color.WHITE);
        Peventos.add(labelfecha);
        
        
        calendar =new JDateChooser();
        calendar.setBounds(100, 250, 120, 40);
        Peventos.add(calendar);
        
        
        botonbuscar =new JButton("Buscar");
        botonbuscar.setBounds(100, 330, 80, 40);
        Peventos.add(botonbuscar);
        
        botonatras =new JButton("Atras");
        botonatras.setBounds(230, 330, 80, 40);
        Peventos.add(botonatras);
        botonatras.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
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
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
}
