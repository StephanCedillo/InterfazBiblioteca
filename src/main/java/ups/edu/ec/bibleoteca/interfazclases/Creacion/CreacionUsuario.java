
package ups.edu.ec.bibleoteca.interfazclases.Creacion;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

/**
 *
 * @author stephancedillo
 */
public class CreacionUsuario {

    private Panel panelGeneral = new Panel();
    private Label labelPrincipal = new Label("CREACIÓN DE USUARIO", Label.CENTER);
    private Panel panelBotones = new Panel(new BorderLayout(0, 15));
    private Button botonEnviar = new Button("Aceptar");

    public CreacionUsuario() {
        panelGeneral.setBackground(Color.gray);
        panelGeneral.setLayout(new BorderLayout(0, 25));
        
        labelPrincipal.setFont(new Font("SansSerif", Font.BOLD, 16));
        panelGeneral.add(labelPrincipal, BorderLayout.NORTH);
        
        generarPanelBotones();
        panelGeneral.add(panelBotones, BorderLayout.CENTER);
        
        botonEnviar.setBackground(new Color(45, 45, 45));
        
        botonEnviar.setFont(new Font("SansSerif", Font.PLAIN, 14));
        panelGeneral.add(botonEnviar, BorderLayout.SOUTH);
    }

    public Panel getPanelGeneral() {
        return panelGeneral;
    }

    public void setPanelGeneral(Panel panelGeneral) {
        this.panelGeneral = panelGeneral;
    }

    public void generarPanelBotones() {
        Panel subpanel = new Panel(new GridLayout(4, 2, 20, 15));
        String[] cadenas = {"Email", "Contraseña", "Nombre", "Cedula", "Apellido", "Edad", "¿Quiere membresia?", "Genero", "Tiene discapacidad", "Dirección"};
        
        panelBotones.add(subpanel, BorderLayout.CENTER);
        
        for (int i = 0; i <= 9; i++) {
            InputLabel input = new InputLabel(new Label(cadenas[i]));
            if (i == 0) {
                panelBotones.add(input.getPanelInput(), BorderLayout.NORTH);
            } else if (i < 9) {
                subpanel.add(input.getPanelInput());
            } else {
                panelBotones.add(input.getPanelInput(), BorderLayout.SOUTH);
            }
        }
    }

}
