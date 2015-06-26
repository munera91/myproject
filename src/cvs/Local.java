package cvs;

import java.util.ArrayList;

class Local {

    int numerodelocal;
    String tipocontrato;
    String nombredelocal;
    String tipodecontrato;

    public static ArrayList<Local> locales = new ArrayList<>();

    public Local(int numerodelocal, String tipocontrato, String nombredelocal) {
        this.numerodelocal = numerodelocal;
        this.tipocontrato = tipocontrato;
        this.nombredelocal = nombredelocal;
           
    }
    
    public String toString() {
        return "Local " + numerodelocal + " (" + nombredelocal + ")";
    }
}
