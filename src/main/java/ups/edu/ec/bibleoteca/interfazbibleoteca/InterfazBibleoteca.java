/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ups.edu.ec.bibleoteca.interfazbibleoteca;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import ups.edu.ec.bibleoteca.interfazclases.InterfazLibros;
import ups.edu.ec.bibleoteca.interfazclases.InterfazUsuarios;

/**
 *
 * @author stephancedillo
 */
public class InterfazBibleoteca extends Frame implements ActionListener {

    Frame ventanaAnterior;

    public InterfazBibleoteca(Frame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
    }

    public InterfazBibleoteca(Point ubicacion) {
        super("Sistema Biblioteca - Creación / Inicio");
        this.setLayout(new BorderLayout());
        this.setSize(470, 600);
        this.setLocation(ubicacion);

        Panel navBar = new Panel(new FlowLayout(FlowLayout.RIGHT));

        Button bCreacion = new Button("Creación");
        Button bUsuarios = new Button("Usuarios");
        Button bLibros = new Button("Libros");
        Button bRegistros = new Button("Registros");
        Button bDevolucion = new Button("Devolución");
        Button bBusqueda = new Button("Búsqueda");

        bCreacion.setBackground(Color.black);
        bCreacion.setForeground(Color.white);

        bUsuarios.addActionListener(new InterfazUsuarios(this));
        bLibros.addActionListener(new InterfazLibros(this));

        navBar.add(bCreacion);
        navBar.add(bUsuarios);
        navBar.add(bLibros);
        navBar.add(bRegistros);
        navBar.add(bDevolucion);
        navBar.add(bBusqueda);

        this.add(navBar, BorderLayout.NORTH);

        Panel centro = new Panel(new FlowLayout(FlowLayout.CENTER, 0, 40));
        centro.add(new Label("BIENVENIDO AL INICIO (ÁREA DE CREACIÓN)"));
        this.add(centro, BorderLayout.CENTER);

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
        Point p = ventanaAnterior.getLocation();
        ventanaAnterior.dispose();
        new InterfazBibleoteca(p);
    }

    public static void main(String[] args) {
        // Arranca la ventana en el centro
        new InterfazBibleoteca(new Point(100, 100));
    }
}
