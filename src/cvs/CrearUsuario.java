package cvs;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CrearUsuario extends JFrame {

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
    JComboBox<String> comboGenero;
    JPasswordField textoPass;
    JPasswordField textoConfirmarpass;
    JButton botoncrearusuario;
    JButton botonreestablecer;
    JButton botonatras;
    JButton botoneliminar;
    JComboBox combo1;
    boolean editando;

    public CrearUsuario(boolean editando) {
        if (editando == true) {
            setTitle("Modificar mis Datos");
        } else {
            setTitle("Registrar Usuario");

        }

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Que hacer cuando se presiona el boton cerrar
        this.editando = editando;

        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel contenidoPanelCU = new PanelImagen6();
        Border padding = BorderFactory.createEmptyBorder(40, 200, 40, 200);
        contenidoPanelCU.setBorder(padding);
        setContentPane(contenidoPanelCU);

        setLayout(new GridLayout(12, 2, 0, 10));

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

        comboGenero = new JComboBox<>();
        comboGenero.addItem("Masculino");
        comboGenero.addItem("Femenino");
        add(comboGenero);

        labelpass = new JLabel("Contraseña");
        add(labelpass);

        textoPass = new JPasswordField();
        add(textoPass);

        labelconfirmarpass = new JLabel("Confirmar Contraseña");
        add(labelconfirmarpass);

        textoConfirmarpass = new JPasswordField();
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
                long celular = Long.parseLong(textoCelular.getText());
                String correo = textoMail.getText();
                String contrasena = textoPass.getText();
                String confirmarpass = textoConfirmarpass.getText();
                if (!contrasena.equals(confirmarpass)) {
                    JOptionPane.showMessageDialog(null, "No coinciden las contraseñas",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                String genero = (String) comboGenero.getSelectedItem();
                
                if (textoMail.getText().matches("^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,4}$") && (textoPass.getText().length() == 8)) {

                    if (!editando) {
                        Usuario us = new Usuario(tipoDocumento, documento, apellido,
                                nombre, telefono, celular, correo, genero, contrasena);
                        Usuario.usuarios.add(us); //Agregar al array
                        
                        
                        JOptionPane.showMessageDialog(null, "Se ha Registrado con exito, Inice Sesion para acceder",
                                "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        new LoginFrame();
                        dispose(); //Me cierro yo
                    } else {
                        Usuario.usuarioLogueado.tipoDocumento = tipoDocumento;
                        Usuario.usuarioLogueado.documento = documento;
                        Usuario.usuarioLogueado.apellido = apellido;
                        Usuario.usuarioLogueado.nombre = nombre;
                        Usuario.usuarioLogueado.telefono = telefono;
                        Usuario.usuarioLogueado.celular = celular;
                        Usuario.usuarioLogueado.correo = correo;
                        Usuario.usuarioLogueado.genero = genero;
                        Usuario.usuarioLogueado.contrasena = contrasena;

                        //Cambiar todos
                        JOptionPane.showMessageDialog(null, "Usuario modificado",
                                "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Campos Incorrectos",
                            "Informacion", JOptionPane.ERROR_MESSAGE);
                    if (textoMail.getText().matches("^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,4}$")) {
                        labelmail.setForeground(Color.BLACK);
                    } else {
                        labelmail.setForeground(Color.RED);
                    }
                    if (textoPass.getText().length() == 8) {
                        labelpass.setForeground(Color.BLACK);
                        labelconfirmarpass.setForeground(Color.BLACK);
                    } else {
                        labelpass.setForeground(Color.RED);
                        labelconfirmarpass.setForeground(Color.RED);
                    }

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
                comboGenero.setSelectedIndex(0);
                textoPass.setText("");
                textoConfirmarpass.setText("");

            }
        });

        botonatras = new JButton("Atras");
        add(botonatras);
        botonatras.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent ev) {
                if(!editando){
                 new PrincipalWindow(false);
                 dispose();   
                }
                else{
                  new PrincipalWindow(true);
                 dispose();     
                }
                

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

        botoneliminar = new JButton("Eliminar cuenta");
        if (editando == true) {
            add(botoneliminar);
        }
        botoneliminar.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent ev) {
                eliminarusuario();

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

        if (editando) {
            cargarDatos();
            botoncrearusuario.setText("Modificar");
        }
    }

    void cargarDatos() {
        for (int i = 0; i < comboTipodocumento.getItemCount(); i++) { //buscar entre los items del combobox 
            if (((String) comboTipodocumento.getItemAt(i)).equals(Usuario.usuarioLogueado.tipoDocumento)) {
                comboTipodocumento.setSelectedIndex(i);
                break;
            }
        }

        textoDocumento.setText(Integer.toString(Usuario.usuarioLogueado.documento)); //Obtener los datos del usuario logueado
        textoApellidos.setText(Usuario.usuarioLogueado.apellido);
        textoNombre.setText(Usuario.usuarioLogueado.nombre);
        textoTelefono.setText(Integer.toString(Usuario.usuarioLogueado.telefono));
        textoCelular.setText(Long.toString(Usuario.usuarioLogueado.celular));
        textoMail.setText(Usuario.usuarioLogueado.correo);
        labelpass.setText("Cambiar Contraseña");
        textoPass.setText(Usuario.usuarioLogueado.contrasena);
        textoConfirmarpass.setText(Usuario.usuarioLogueado.contrasena);
        for (int i = 0; i < comboGenero.getItemCount(); i++) { //buscar entre los items del combobox 
            if (((String) comboGenero.getItemAt(i)).equals(Usuario.usuarioLogueado.genero)) {
                comboGenero.setSelectedIndex(i);
                break;
            }
        }

    }

    void eliminarusuario() {

        String removerusuario = JOptionPane.showInputDialog("Introduzca su contraseña");

        if (removerusuario.equals(Usuario.usuarioLogueado.contrasena)) {

            for (int i = 0; i < Usuario.usuarios.size(); i++) {
                Usuario usr = Usuario.usuarios.get(i);
                if (Usuario.usuarioLogueado.documento == usr.documento) {
                    Usuario.usuarios.remove(i);
                    JOptionPane.showMessageDialog(null, "Su cuenta ha sido eliminada",
                            "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    new PrincipalWindow(false);
                    break;

                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "La contraseña es incorrecta",
                    "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void main(String[] arg) {
        new CrearUsuario(false);
    }
}
