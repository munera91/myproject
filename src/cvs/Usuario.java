package cvs;

/**
 * Esta Clase almacena los usuarios clientes del sistema, los usuarios son almacenados
 * en una lista llamada usuarios
 * @author Victor Dorado
 * @version 08/04/2015
 */

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

    public static lista<Usuario> usuarios = new lista<>();

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
    
    /**
     * Si el usuario y la contraseña ingresador en el login frame coinciden con los datos almacenados
     * en la lista usuarios se loguea el usuario
     * @param correo
     * @param contrasena
     * @return retorna verdadero si el usuario fue logueado o falso si el usuario es incorrecto o no se encuentra
     */

    public static boolean loguearUsuario(String correo, String contrasena) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).info.correo.equals(correo) && usuarios.get(i).info.contrasena.equals(contrasena)) {
                usuarioLogueado = usuarios.get(i).info; //Si coincide el correo y pass, se pone como usuario logueado el que coincidió
                return true;
            }
        }
        return false;
    }

}
