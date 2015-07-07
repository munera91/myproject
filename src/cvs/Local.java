package cvs;

/**
 * Clase Local almacena los locales en la lista, local
 * @author Santiago Llano
 * 04/07/2015
 */

class Local {

    int numerodelocal;
    String tipocontrato;
    String nombredelocal;
    String tipodecontrato;

    public static lista<Local> locales = new lista<>();

    public Local(int numerodelocal, String tipocontrato, String nombredelocal) {
        this.numerodelocal = numerodelocal;
        this.tipocontrato = tipocontrato;
        this.nombredelocal = nombredelocal;
           
    }
    
    /**
     * toString
     * @return retorna el local, (Numero y nombre de local)
     */
    
    public String toString() {
        return "Local " + numerodelocal + " (" + nombredelocal + ")";
    }
}
