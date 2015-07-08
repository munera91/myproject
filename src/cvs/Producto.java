package cvs;

/**
 * en esta clase se almacenan todos los productos, el almacenamiento se realiza
 * en la lista productos
 * @author Camilo Munera
 */

public class Producto {

    String foto;
    String nombreproducto;
    String descripcionproducto;
    String precioproducto;
    String Categoria;

    public static lista<Producto> Productos = new lista<>();

    public Producto(String foto, String nombreproducto, String descripcionproducto,String Categoria, String precioproducto) {
        this.foto = foto;
        this.nombreproducto = nombreproducto;
        this.descripcionproducto = descripcionproducto;
        this.precioproducto = precioproducto;
        this.Categoria = Categoria;
    }

}


