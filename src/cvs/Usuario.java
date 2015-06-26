package cvs;

import static cvs.Propietario.propietarios;
import java.util.ArrayList;

class Usuario {

    String tipoDocumento;
    int documento;
    String apellido;
    String nombre;
    int telefono;
    long celular;
    String correo;
    String genero;
    String contrasena;

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    
    
    public static Usuario usuarioLogueado;

    public Usuario(String tipoDocumento, int documento, String apellido,
            String nombre, int telefono, long celular, String correo, String genero,
            String contrasena) {
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.celular = celular;
        this.correo = correo;
        this.genero = genero;
        this.contrasena = contrasena;
    }

    public static boolean loguearUsuario(String correo, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.correo.equals(correo) && usuario.contrasena.equals(contrasena)) {
                usuarioLogueado = usuario; //Si coincide el correo y pass, se pone como usuario logueado el que coincidió
                return true;
            }
        }
        return false;
    }

}
