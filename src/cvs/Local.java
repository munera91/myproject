package cvs;

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
    
    public String toString() {
        return "Local " + numerodelocal + " (" + nombredelocal + ")";
    }
}
