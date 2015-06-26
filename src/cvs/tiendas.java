
package cvs;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;


public class tiendas {
    
   JLabel labelbuscar;
   JButton botonbuscar;
   JComboBox<String> comboCategoria;
   JLabel labelestado;
   JLabel labelnombrelocal;
   
   public tiendas(){
       
       labelbuscar =new JLabel ("Buscar");
       comboCategoria = new JComboBox<>();
       comboCategoria.addItem("Zapatos");
       
       
       
       
       
       
   }
   
      
    
}
