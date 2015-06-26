package cvs;

class Propietario {

    String cedula;
    String nombre;
    Long celular;
    Local local;
    String Pass;

    public static lista<Propietario> propietarios = new lista<>();
    
    public static Propietario propietariologueado;

    public Propietario(String cedula, String nombre, Long celular, Local local, String Pass) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.celular = celular;
        this.local = local;
        this.Pass = Pass;
    }

    public String toString() {
        return nombre;
    }
    
    public static Propietario getPropietario(Local localAbuscar) {
        for (int i = 0; i < propietarios.size(); i++) {
            if(propietarios.get(i).info.local.numerodelocal == localAbuscar.numerodelocal) {
                return propietarios.get(i).info;
            }
        }
        return null;
    }
    
    public static boolean loguearpropietario(String correo, String contrasena) {
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).info.nombre.equals(correo) && propietarios.get(i).info.Pass.equals(contrasena)) {
                propietariologueado = propietarios.get(i).info; //Si coincide el correo y pass, se pone como usuario logueado el que coincidió
                return true;
            }
        }
        return false;
    }
}
