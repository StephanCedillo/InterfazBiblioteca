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
public class InterfazPrestamo extends Frame implements ActionListener {

    private Frame ventanaAnterior;

    public InterfazPrestamo(Frame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
    }

    public InterfazPrestamo(Point ubicacion) {
        super("Sistema Biblioteca - Gestión de Registros y Préstamos");
        this.setLayout(new BorderLayout());


        this.setSize(1050, 710);
        this.setLocationRelativeTo(null);

        Panel navBar = efectuarCambio();
        
        this.add(navBar, BorderLayout.NORTH);

        Panel listaRegistros = new Panel(new GridLayout(3, 1, 0, 15));

        listaRegistros.add(crearEtiquetaRegistro(
                "001", "098421567", "IDASID192415", "IDASID192415",
                "Alfonso Auquilla", "alfonso@gmail.com", "Las Caidas de Andres", "Las Caidas de Andres",
                "06/29/2008", "N/R", "140", "Prestado"
        ));

        listaRegistros.add(crearEtiquetaRegistro(
                "001", "098421567", "IDASID192415", "IDASID192415",
                "Alfonso Auquilla", "alfonso@gmail.com", "Las Caidas de Andres", "Las Caidas de Andres",
                "06/29/2008", "N/R", "140", "Prestado"
        ));

        listaRegistros.add(crearEtiquetaRegistro(
                "001", "098421567", "IDASID192415", "IDASID192415",
                "Alfonso Auquilla", "alfonso@gmail.com", "Las Caidas de Andres", "Las Caidas de Andres",
                "06/29/2008", "N/R", "140", "Prestado"
        ));

        Panel panelCentrador = new Panel(new FlowLayout(FlowLayout.CENTER, 0, 40));
        panelCentrador.add(listaRegistros);

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
        new InterfazPrestamo(posicionActual);
    }

    private Panel crearEtiquetaRegistro(
            String id, String cedula, String isb1, String isb2,
            String nombre, String gmail, String nombrel1, String nombrel2,
            String fechaPedido, String fechaDevuelto, String cantidad, String estado) {

        Panel tarjeta = new Panel(new BorderLayout(20, 10));
        tarjeta.setBackground(new Color(249, 245, 245));

        
        Label iconoRegistro = new Label(" \u25A0 ", Label.CENTER); 
        iconoRegistro.setFont(new Font("SansSerif", Font.PLAIN, 120));
        tarjeta.add(iconoRegistro, BorderLayout.WEST);

        // Panel central 
        Panel info = new Panel(new GridLayout(1, 3));
        info.setBackground(new Color(249, 245, 245));

        // Columna Izquierda
        Panel panelIzquierda = new Panel(new GridLayout(4, 1));
        panelIzquierda.setBackground(new Color(249, 245, 245));
        panelIzquierda.add(crearLabelFormateado(" ID: " + id));
        panelIzquierda.add(crearLabelFormateado(" Cédula: " + cedula));
        panelIzquierda.add(crearLabelFormateado(" ISBN 1: " + isb1));
        panelIzquierda.add(crearLabelFormateado(" ISBN 2: " + isb2));

        // Columna Centro
        Panel panelCentro = new Panel(new GridLayout(4, 1));
        panelCentro.setBackground(new Color(249, 245, 245));
        panelCentro.add(crearLabelFormateado(" Nombre: " + nombre));
        panelCentro.add(crearLabelFormateado(" Correo: " + gmail));
        panelCentro.add(crearLabelFormateado(" Libro 1: " + nombrel1));
        panelCentro.add(crearLabelFormateado(" Libro 2: " + nombrel2));

        // Columna Derecha
        Panel panelDerecha = new Panel(new GridLayout(4, 1));
        panelDerecha.setBackground(new Color(242, 242, 242));
        panelDerecha.add(crearLabelFormateado(" Pedido: " + fechaPedido));
        panelDerecha.add(crearLabelFormateado(" Devolución: " + fechaDevuelto));
        panelDerecha.add(crearLabelFormateado(" Cantidad: " + cantidad));
        panelDerecha.add(crearLabelFormateado(" Estado: " + estado));

        info.add(panelIzquierda);
        info.add(panelCentro);
        info.add(panelDerecha);

        tarjeta.add(info, BorderLayout.CENTER);

      
        Panel contenedorLinea = new Panel(new GridLayout(1, 2));
        contenedorLinea.setBackground(new Color(249, 245, 245));
        contenedorLinea.add(new Label("")); 
        
        Label lineaRoja = new Label("");
        lineaRoja.setBackground(new Color(192, 90, 90));
        contenedorLinea.add(lineaRoja); 
        
        tarjeta.add(contenedorLinea, BorderLayout.SOUTH);

        return tarjeta;
    }

    
    private Label crearLabelFormateado(String texto) { // Para poner estilo
        Label lbl = new Label(texto);
        lbl.setFont(new Font("SansSerif", Font.BOLD, 14));
        return lbl;
    }

    public Panel efectuarCambio() {
        Panel navBar = new Panel(new FlowLayout(FlowLayout.RIGHT));
        String[] opciones = {"Creación", "Usuarios", "Libros", "Prestamo", "Devolucion", "Búsqueda"};
        for (String opcion : opciones) {

            Button btn = new Button(opcion);

            
            if (opcion.equals("Prestamo")) {
                btn.setBackground(Color.black);
           
            }

            if (opcion.equals("Creación")) {
                btn.addActionListener(new InterfazBibleoteca(this));
            } else if (opcion.equals("Usuarios")) {
                btn.addActionListener(new InterfazUsuarios(this));
            } else if (opcion.equals("Libros")) {
                btn.addActionListener(new InterfazLibros(this));
            } else if (opcion.equals("Búsqueda")) {
                btn.addActionListener(new InterfazBusqueda(this));
            } else if (opcion.equals("Prestamo")) {
                // btn.addActionListener(new InterfazRegistros(this));
            } else if (opcion.equals("Devolucion")) {
                 btn.addActionListener(new InterfazDevolucion(this));
            }

            navBar.add(btn);
        }
        return navBar;
    }
}