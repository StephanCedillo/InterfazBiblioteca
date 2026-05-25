/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ups.edu.ec.bibleoteca.interfazbibleoteca;

import java.awt.Frame;
import ups.edu.ec.bibleoteca.interfazclases.Creacion.InterfazCreacion;

/**
 *
 * @author stephancedillo
 */
public class InterfazBibleoteca {

    public static void main(String[] args) {
         Frame frame = new Frame("Ventana");
         frame.setSize(900, 900);
         InterfazCreacion interfazCreacion= new InterfazCreacion();
         frame.add(interfazCreacion.getPanelInterfaz());
         
         frame.setVisible(true);
         
    }
}
