/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.bibleoteca.interfazclases.Busqueda;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

/**
 *
 * @author stephancedillo
 */
public class InputBusqueda {
    private Panel panelInput = new Panel();
    private Label mensaje;
    private TextField text = new TextField("");
    
    public InputBusqueda(Label mensaje) {
        this.mensaje = mensaje;
        this.mensaje.setFont(new Font("SansSerif", Font.PLAIN, 12));
        panelInput.setLayout(new GridLayout(2, 1, 0, 5));
        panelInput.add(this.mensaje);
        panelInput.add(text);
    }

    public Panel getPanelInput() {
        return panelInput;
    }

    public void setPanelInput(Panel panelInput) {
        this.panelInput = panelInput;
    }
}
