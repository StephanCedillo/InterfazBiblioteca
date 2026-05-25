package ups.edu.ec.bibleoteca.interfazclases.Creacion;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Font;

public class InputLabel {
    private Panel panelInput = new Panel();
    private Label mensaje;
    private TextField text = new TextField("");
    
    public InputLabel(Label mensaje) {
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