package cvs;

public class Administrador {

    String user;
    String password;

    public static Administrador admin = new Administrador("admin", "1234");

    public Administrador(String user, String password) {
        this.user = user;
        this.password = password;
    }

}
