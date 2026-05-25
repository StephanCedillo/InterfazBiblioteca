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
import ups.edu.ec.bibleoteca.interfazclases.Busqueda.InterfazBusqueda;

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
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);

        Panel navBar = efectuarCambio();
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
        if (ventanaAnterior.isVisible()) {
            Point posicionActual = ventanaAnterior.getLocation();

            ventanaAnterior.dispose();

            new InterfazUsuarios(posicionActual);

        }

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
    
    public Panel efectuarCambio() {
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

                //btn.addActionListener(new InterfazUsuarios(this));

            } else if (opcion.equals("Libros")) {

               btn.addActionListener(new InterfazLibros(this));

            } else if (opcion.equals("Búsqueda")) {

                btn.addActionListener(new InterfazBusqueda(this));

            } else if (opcion.equals("Registros")) {

              //  btn.addActionListener(new InterfazRegistros(this));

            } else if (opcion.equals("Devolución")) {

             //   btn.addActionListener(new InterfazDevolucion(this));
            }

            navBar.add(btn);
        }
        return navBar;
    }
}
