package ups.edu.ec.bibleoteca.interfazclases.Busqueda;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class BusquedaUsuario {
    private Panel panelGeneral = new Panel(new GridLayout(2, 1));
    private Panel panelBusqueda = new Panel(new GridLayout(3, 1, 0, 10));

    private Panel panelEncontrado = new Panel(new FlowLayout(FlowLayout.CENTER));
    private InputBusqueda busqueda = new InputBusqueda(new Label("Cedula"));
    private Button botonEnviar = new Button("Buscar Usuario");

    public BusquedaUsuario() {
        generarPanel();
        panelGeneral.setVisible(true);
    }
    
    public Panel getPanelGeneral() {
        return panelGeneral;
    }

    public void setPanelGeneral(Panel panelGeneral) {
        this.panelGeneral = panelGeneral;
    }
     
    public void generarPanel(){
        Label titulo = new Label("BUSQUEDA DE USUARIO", Label.CENTER);
        titulo.setFont(new Font("Serif", Font.PLAIN, 36));
        
        botonEnviar.setBackground(new Color(45, 45, 45));
       
        botonEnviar.setFont(new Font("SansSerif", Font.BOLD, 14));

        panelBusqueda.add(titulo);
        panelBusqueda.add(busqueda.getPanelInput());
        panelBusqueda.add(botonEnviar);
        
        panelEncontrado.add(crearEtiquetaUsuario("Alfonso Auquilla", "alfonso.auquillas@gmail.com", "18 años", "Lope de Vega", "Masculino", "Estudiantil", "05/09/26", "Tiene discapacidad:"));
        
        panelGeneral.add(panelBusqueda);
        panelGeneral.add(panelEncontrado);
    }
    
    private Panel crearEtiquetaUsuario(String nombre, String gmail, String edad, String direccion, String genero, String membresia, String caduca, String discapacidad) {
        Panel tarjeta = new Panel(new BorderLayout(20, 10));
        tarjeta.setBackground(new Color(242, 242, 242));

        Label iconoAvatar = new Label(" \u25CF ", Label.CENTER); 
        iconoAvatar.setFont(new Font("SansSerif", Font.PLAIN, 120));
        tarjeta.add(iconoAvatar, BorderLayout.WEST);

        Panel infoCentro = new Panel(new GridLayout(5, 1));
        infoCentro.setBackground(new Color(242, 242, 242));
        
        Label lblNombre = new Label(nombre);
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 20));
        infoCentro.add(lblNombre);
        
        Label lblGmail = new Label("Email : " + gmail);
        lblGmail.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoCentro.add(lblGmail);
        
        Label lblEdad = new Label("Edad: " + edad);
        lblEdad.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoCentro.add(lblEdad);
        
        Label lblDireccion = new Label("Dirección: " + direccion);
        lblDireccion.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoCentro.add(lblDireccion);
        
        Label lblGenero = new Label("Genero: " + genero);
        lblGenero.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoCentro.add(lblGenero);

        tarjeta.add(infoCentro, BorderLayout.CENTER);

        Panel infoDerecha = new Panel(new GridLayout(4, 1));
        infoDerecha.setBackground(new Color(242, 242, 242));
        
        infoDerecha.add(new Label(""));
        
        Label lblCaduca = new Label("Caduca en: " + caduca);
        lblCaduca.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoDerecha.add(lblCaduca);
        
        Label lblMembresia = new Label("Membresia : " + membresia);
        lblMembresia.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoDerecha.add(lblMembresia);
        
        Label lblDiscapacidad = new Label(discapacidad);
        lblDiscapacidad.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoDerecha.add(lblDiscapacidad);

        tarjeta.add(infoDerecha, BorderLayout.EAST);

        Panel contenedorLinea = new Panel(new GridLayout(1, 2));
        contenedorLinea.setBackground(new Color(242, 242, 242));
        
        contenedorLinea.add(new Label(""));
        
        Label lineaRoja = new Label("");
        lineaRoja.setBackground(new Color(192, 90, 90));
        contenedorLinea.add(lineaRoja); 
        
        tarjeta.add(contenedorLinea, BorderLayout.SOUTH);

        return tarjeta;
    }
}