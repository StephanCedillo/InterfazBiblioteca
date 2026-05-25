package ups.edu.ec.bibleoteca.interfazclases.Busqueda;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class BusquedaLibro {
    private Panel panelGeneral = new Panel(new GridLayout(2, 1));
    private Panel panelBusqueda = new Panel(new GridLayout(3, 1, 0, 10));
    private Panel panelEncontrado = new Panel(new FlowLayout(FlowLayout.CENTER));
    private InputBusqueda busqueda = new InputBusqueda(new Label("ISBN"));
    private Button botonEnviar = new Button("Buscar Libro");
    
    public BusquedaLibro() {
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
        Label titulo = new Label("BUSQUEDA DE LIBRO", Label.CENTER);
        titulo.setFont(new Font("Serif", Font.PLAIN, 36));
        
        botonEnviar.setBackground(new Color(45, 45, 45));
        
        botonEnviar.setFont(new Font("SansSerif", Font.BOLD, 14));

        panelBusqueda.add(titulo);
        panelBusqueda.add(busqueda.getPanelInput());
        panelBusqueda.add(botonEnviar);
        
        panelEncontrado.add(crearEtiquetaLibro("La caidas de Andres", "IDASID192415", "Andres Zuñiga", "no", "Espanol", "Autobiografia", "140", "Biblioteca"));
        
        panelGeneral.add(panelBusqueda);
        panelGeneral.add(panelEncontrado);
    }
    
    private Panel crearEtiquetaLibro(String tituloLibro, String isbn, String autor, String restriccion, String idioma, String genero, String cantidad, String estado) {
        Panel tarjeta = new Panel(new BorderLayout(20, 10));
        tarjeta.setBackground(new Color(249,245,245));

        Label iconoLibro = new Label(" \u25A0 ", Label.CENTER); 
        iconoLibro.setFont(new Font("SansSerif", Font.PLAIN, 120));
        tarjeta.add(iconoLibro, BorderLayout.WEST);

        Panel infoCentro = new Panel(new GridLayout(4, 1));
        infoCentro.setBackground(new Color(249,245,245));
        
        Label lblTitulo = new Label(tituloLibro);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 20));
        infoCentro.add(lblTitulo);
        
        Label lblAutor = new Label("Autor: " + autor);
        lblAutor.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoCentro.add(lblAutor);
        
        Label lblIsbn = new Label("ISBN: " + isbn);
        lblIsbn.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoCentro.add(lblIsbn);
        
        Label lblIdioma = new Label("Idioma: " + idioma);
        lblIdioma.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoCentro.add(lblIdioma);

        tarjeta.add(infoCentro, BorderLayout.CENTER);

        Panel infoDerecha = new Panel(new GridLayout(4, 1));
        infoDerecha.setBackground(new Color(242, 242, 242));
        
        Label lblGenero = new Label("Genero: " + genero);
        lblGenero.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoDerecha.add(lblGenero);
        
        Label lblEstado = new Label("Estado: " + estado);
        lblEstado.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoDerecha.add(lblEstado);
        
        Label lblCantidad = new Label("Cantidad: " + cantidad);
        lblCantidad.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoDerecha.add(lblCantidad);
        
        Label lblRestriccion = new Label("Restriccion: " + restriccion);
        lblRestriccion.setFont(new Font("SansSerif", Font.BOLD, 14));
        infoDerecha.add(lblRestriccion);

        tarjeta.add(infoDerecha, BorderLayout.EAST);

        Panel contenedorLinea = new Panel(new GridLayout(1, 2));
        contenedorLinea.setBackground(new Color(249,245,245));
        
        contenedorLinea.add(new Label(""));
        
        Label lineaRoja = new Label("");
        lineaRoja.setBackground(new Color(192, 90, 90));
        contenedorLinea.add(lineaRoja); 
        
        tarjeta.add(contenedorLinea, BorderLayout.SOUTH);

        return tarjeta;
    }
}