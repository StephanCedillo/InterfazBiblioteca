/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.bibleoteca.interfazclases;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import ups.edu.ec.bibleoteca.interfazbibleoteca.InterfazBibleoteca;
import ups.edu.ec.bibleoteca.interfazclases.Busqueda.InterfazBusqueda;

/**
 *
 * @author stephancedillo
 */
public class InterfazLibros extends Frame implements ActionListener {

    private Frame ventanaAnterior;

    public InterfazLibros(Frame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
    }

    public InterfazLibros(Point ubicacion) {
        super("Sistema Biblioteca - Catálogo de Libros");

        this.setLayout(new BorderLayout());
        this.setSize(900, 710);
        this.setLocationRelativeTo(null);
        
        Panel navBar = efectuarCambio();
        
        this.add(navBar, BorderLayout.NORTH);

        Panel listaLibros = new Panel(new GridLayout(3, 1, 0, 15));

        listaLibros.add(crearEtiquetaLibro("La caidas de Andres", "IDASID192415", "Andres Zuñiga", "no", "Espanol", "Autobiografia", "140", "Biblioteca"));
        listaLibros.add(crearEtiquetaLibro("La caidas de Andres", "IDASID192415", "Andres Zuñiga", "no", "Espanol", "Autobiografia", "140", "Biblioteca"));
        listaLibros.add(crearEtiquetaLibro("La caidas de Andres", "IDASID192415", "Andres Zuñiga", "no", "Espanol", "Autobiografia", "140", "Biblioteca"));

        Panel panelCentrador = new Panel(new FlowLayout(FlowLayout.CENTER, 0, 40));
        panelCentrador.add(listaLibros);

        this.add(panelCentrador, BorderLayout.CENTER);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ventanaAnterior.isVisible()) {
            Point posicionActual = ventanaAnterior.getLocation();

            ventanaAnterior.dispose();

            new InterfazLibros(posicionActual);

        }

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

    public Panel efectuarCambio() {
        Panel navBar = new Panel(new FlowLayout(FlowLayout.RIGHT));
        String[] opciones = {"Creación", "Usuarios", "Libros", "Prestamo", "Devolucion", "Búsqueda"};
        for (String opcion : opciones) {

            Button btn = new Button(opcion);

            if (opcion.equals("Libros")) {
                btn.setBackground(Color.black);
            }

            if (opcion.equals("Creación")) {

                btn.addActionListener(new InterfazBibleoteca(this));

            } else if (opcion.equals("Usuarios")) {

                btn.addActionListener(new InterfazUsuarios(this));

            }  else if (opcion.equals("Búsqueda")) {

                btn.addActionListener(new InterfazBusqueda(this));

            } else if (opcion.equals("Prestamo")) {

                btn.addActionListener(new InterfazPrestamo(this));

            } else if (opcion.equals("Devolucion")) {

               btn.addActionListener(new InterfazDevolucion(this));
            }

            navBar.add(btn);
        }
        return navBar;
    }
}
