package cvs;

import java.util.ArrayList;

class Propietario {

    String cedula;
    String nombre;
    Long celular;
    Local local;
    String Pass;

    public static ArrayList<Propietario> propietarios = new ArrayList<>();
    
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
            if(propietarios.get(i).local.numerodelocal == localAbuscar.numerodelocal) {
                return propietarios.get(i);
            }
        }
        return null;
    }
    
    public static boolean loguearpropietario(String correo, String contrasena) {
        for (Propietario propietario : propietarios) {
            if (propietario.nombre.equals(correo) && propietario.Pass.equals(contrasena)) {
                propietariologueado = propietario; //Si coincide el correo y pass, se pone como usuario logueado el que coincidió
                return true;
            }
        }
        return false;
    }
}
