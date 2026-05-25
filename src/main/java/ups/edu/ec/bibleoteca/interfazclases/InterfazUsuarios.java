/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.bibleoteca.interfazclases;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import ups.edu.ec.bibleoteca.interfazbibleoteca.InterfazBibleoteca;

/**
 *
 * @author stephancedillo
 */
public class InterfazUsuarios extends Frame implements ActionListener {

    private Frame ventanaAnterior;

    public InterfazUsuarios(Frame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
    }

    public InterfazUsuarios(Point ubicacion) {

        this.setLayout(new BorderLayout());
        this.setSize(470, 600);
        this.setLocationRelativeTo(null);

        Panel navBar = new Panel(new FlowLayout(FlowLayout.RIGHT));
        String[] opciones = {"Creación", "Usuarios", "Libros", "Registros", "Devolución", "Búsqueda"};

        for (String opcion : opciones) {
            Button btn = new Button(opcion);

            if (opcion.equals("Usuarios")) {
                btn.setBackground(Color.black);
                btn.setForeground(Color.white);
            }
            if (opcion.equals("Creación")) {
                btn.addActionListener(new InterfazBibleoteca(this));
            } else if (opcion.equals("Libros")) {
                btn.addActionListener(new InterfazLibros(this));
            }

            navBar.add(btn);
        }
        this.add(navBar, BorderLayout.NORTH);

        Panel listaUsuarios = new Panel(new GridLayout(3, 1, 0, 15));

        listaUsuarios.add(crearEtiquetaUsuario("Alfonso Auquilla", "alfonso.auquillas@gmail.com", "18", "Lope de Vega", "Masculino", "Estudiantil", "05/09/26", "no"));
        listaUsuarios.add(crearEtiquetaUsuario("Alfonso Auquilla", "alfonso.auquillas@gmail.com", "18", "Lope de Vega", "Masculino", "Estudiantil", "05/09/26", "no"));
        listaUsuarios.add(crearEtiquetaUsuario("Alfonso Auquilla", "alfonso.auquillas@gmail.com", "18", "Lope de Vega", "Masculino", "Estudiantil", "05/09/26", "no"));

        Panel panelCentrador = new Panel(new FlowLayout(FlowLayout.CENTER, 0, 40));
        panelCentrador.add(listaUsuarios);

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
        new InterfazUsuarios(posicionActual);
    }

    private Panel crearEtiquetaUsuario(String nombre, String gmail, String edad, String direccion, String genero, String membresia, String caduca, String discapacidad) {
        Panel tarjeta = new Panel(new BorderLayout());

        Panel info = new Panel(new GridLayout(7, 1));
        info.setBackground(Color.white);

        info.add(new Label("  Nombre: " + nombre));
        info.add(new Label("  Gmail: " + gmail));
        info.add(new Label("  Edad: " + edad));
        info.add(new Label("  Direccion: " + direccion));
        info.add(new Label("  Genero: " + genero));
        info.add(new Label("  Membresia: " + membresia));
        info.add(new Label("  Caduca en: " + caduca));
        info.add(new Label("  Discapacidad: " + discapacidad));

        tarjeta.add(info, BorderLayout.CENTER);

        Label lineaNegra = new Label("");
        lineaNegra.setBackground(Color.black);
        tarjeta.add(lineaNegra, BorderLayout.SOUTH);

        return tarjeta;
    }
}
