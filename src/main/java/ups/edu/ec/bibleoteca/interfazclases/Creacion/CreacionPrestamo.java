package ups.edu.ec.bibleoteca.interfazclases.Creacion;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class CreacionPrestamo {
    private Panel panelGeneral = new Panel();

    public CreacionPrestamo() {
        panelGeneral.setBackground(new Color(245, 240, 240));
        panelGeneral.setLayout(new BorderLayout(0, 30));

        Panel tarjeta1 = new Panel(new BorderLayout(0, 15));
        tarjeta1.setBackground(Color.WHITE);

        Label labelPrincipal = new Label("CREACIÓN DE PRESTAMOS", Label.CENTER);
        labelPrincipal.setFont(new Font("SansSerif", Font.BOLD, 16));
        tarjeta1.add(labelPrincipal, BorderLayout.NORTH);
        tarjeta1.add(new InputLabel(new Label("Cedula")).getPanelInput(), BorderLayout.CENTER);

        Panel tarjeta2 = new Panel(new BorderLayout(0, 25));
        tarjeta2.setBackground(Color.WHITE);

        tarjeta2.add(new InputLabel(new Label("ISBN")).getPanelInput(), BorderLayout.NORTH);

        Panel panelOpciones = new Panel(new BorderLayout(0, 15));
        Label labelOpcion = new Label("Desea ingresar otro libro:");
        labelOpcion.setFont(new Font("SansSerif", Font.PLAIN, 12));
        panelOpciones.add(labelOpcion, BorderLayout.NORTH);

        Panel panelBotones = new Panel(new GridLayout(1, 2, 20, 0));
        
        Button btnSi = new Button("Si");
        btnSi.setBackground(new Color(45, 45, 45));

        btnSi.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        Button btnAutorizar = new Button("Autorizar Préstamo");
        btnAutorizar.setBackground(new Color(45, 45, 45));

        btnAutorizar.setFont(new Font("SansSerif", Font.PLAIN, 14));

        panelBotones.add(btnSi);
        panelBotones.add(btnAutorizar);

        panelOpciones.add(panelBotones, BorderLayout.CENTER);
        tarjeta2.add(panelOpciones, BorderLayout.CENTER);

        Panel wrapper = new Panel(new BorderLayout());
        wrapper.add(tarjeta2, BorderLayout.NORTH);

        panelGeneral.add(tarjeta1, BorderLayout.NORTH);
        panelGeneral.add(wrapper, BorderLayout.CENTER);
    }

    public Panel getPanelGeneral() {
        return panelGeneral;
    }

    public void setPanelGeneral(Panel panelGeneral) {
        this.panelGeneral = panelGeneral;
    }
}