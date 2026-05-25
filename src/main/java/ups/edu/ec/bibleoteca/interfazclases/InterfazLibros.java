/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.bibleoteca.interfazclases;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
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
        this.setSize(450, 710);
        this.setLocationRelativeTo(null);

        Panel navBar = new Panel(new FlowLayout(FlowLayout.RIGHT));
        String[] opciones = {"Creación", "Usuarios", "Libros", "Registros", "Devolución", "Búsqueda"};

        for (String opcion : opciones) {
            Button btn = new Button(opcion);

            if (opcion.equals("Libros")) {
                btn.setBackground(Color.black);
                btn.setForeground(Color.white);
            }
            if (opcion.equals("Creación")) {
                btn.addActionListener(new InterfazBibleoteca(this));
            } else if (opcion.equals("Usuarios")) {
                btn.addActionListener(new InterfazUsuarios(this));
            }

            navBar.add(btn);
        }
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
        Point posicionActual = ventanaAnterior.getLocation();
        ventanaAnterior.dispose();
        new InterfazLibros(posicionActual);
    }

    private Panel crearEtiquetaLibro(String titulo, String isbn, String autor, String restriccion, String idioma, String genero, String cantidad, String estado) {
        Panel tarjeta = new Panel(new BorderLayout());

        Panel info = new Panel(new GridLayout(8, 1));
        info.setBackground(Color.white);

        info.add(new Label("  Título: " + titulo));
        info.add(new Label("  ISBN: " + isbn));
        info.add(new Label("  Autor: " + autor));
        info.add(new Label("  Restriccion: " + restriccion));
        info.add(new Label("  Idioma: " + idioma));
        info.add(new Label("  Genero: " + genero));
        info.add(new Label("  Cantidad: " + cantidad));
        info.add(new Label("  Estado: " + estado));

        tarjeta.add(info, BorderLayout.CENTER);

        Label lineaNegra = new Label("");
        lineaNegra.setBackground(Color.black);
        tarjeta.add(lineaNegra, BorderLayout.SOUTH);

        return tarjeta;
    }
}
