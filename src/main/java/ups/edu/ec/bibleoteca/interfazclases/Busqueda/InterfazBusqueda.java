package ups.edu.ec.bibleoteca.interfazclases.Busqueda;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ups.edu.ec.bibleoteca.interfazbibleoteca.InterfazBibleoteca;
import ups.edu.ec.bibleoteca.interfazclases.InterfazDevolucion;
import ups.edu.ec.bibleoteca.interfazclases.InterfazLibros;
import ups.edu.ec.bibleoteca.interfazclases.InterfazPrestamo;
import ups.edu.ec.bibleoteca.interfazclases.InterfazUsuarios;

public class InterfazBusqueda extends Frame implements ActionListener {

    private Frame ventanaAnterior;
    private Panel panelGeneral = new Panel();
    private Panel[] panelesIntercambio = new Panel[3];
    private Panel panelIntercambioPrincipal = new Panel();

    private BusquedaUsuario busquedaUsuario = new BusquedaUsuario();
    private BusquedaLibro busquedaLibro = new BusquedaLibro();
    private BusquedaPrestamo busquedaPrestamo = new BusquedaPrestamo();

    public InterfazBusqueda(Frame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
    }

    public InterfazBusqueda(Point ubicacion) {
        super("Sistema Biblioteca - Busqueda");

        this.setLayout(new BorderLayout());
        this.setSize(900, 710);
        this.setBackground(Color.WHITE);
        if (ubicacion != null) {
            this.setLocation(ubicacion);
        } else {
            this.setLocationRelativeTo(null);
        }

        Panel navBar = efectuarCambio();
        this.add(navBar, BorderLayout.NORTH);

        Panel panelCentrador = new Panel(new FlowLayout(FlowLayout.CENTER, 0, 40));
        panelCentrador.setBackground(Color.WHITE);
        generarPanelGeneral();
        panelCentrador.add(panelGeneral);

        this.add(panelCentrador, BorderLayout.CENTER);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.setVisible(true);
    }

    public Panel efectuarCambio() {
        Panel navBar = new Panel(new FlowLayout(FlowLayout.RIGHT, 15, 15));
        navBar.setBackground(Color.WHITE);
        
        String[] opciones = {"Creación", "Usuarios", "Libros", "Prestamo", "Devolucion", "Búsqueda"};
        
        for (String opcion : opciones) {
            Button btn = new Button(opcion);
            btn.setFont(new Font("SansSerif", Font.BOLD, 12));

            if (opcion.equals("Búsqueda")) {
                btn.setBackground(new Color(45, 45, 45)); 
                btn.setForeground(Color.WHITE);
            } else {
                btn.setBackground(new Color(242, 242, 242));
                btn.setForeground(Color.BLACK);
            }

            if (opcion.equals("Creación")) {
                btn.addActionListener(new InterfazBibleoteca(this));
            } else if (opcion.equals("Usuarios")) {
                btn.addActionListener(new InterfazUsuarios(this));
            } else if (opcion.equals("Libros")) {
                btn.addActionListener(new InterfazLibros(this));
            } else if (opcion.equals("Prestamo")) {
                btn.addActionListener(new InterfazPrestamo(this));
            } else if (opcion.equals("Devolucion")) {
                
                btn.addActionListener(new InterfazDevolucion(this));
                
            }

            navBar.add(btn);
        }
        return navBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ventanaAnterior != null && ventanaAnterior.isVisible()) {
            Point posicionActual = ventanaAnterior.getLocation();
            ventanaAnterior.dispose();
            new InterfazBusqueda(posicionActual);
        }
    }

    public void generarPanelGeneral() {
        panelGeneral.setLayout(new BorderLayout(0, 20));
        panelGeneral.setBackground(Color.WHITE);

        Panel botones = new Panel();
        botones.setLayout(new GridLayout(1, 3, 10, 0)); 
        botones.setBackground(Color.WHITE);

        Button[] buttons = new Button[3];
        buttons[0] = new Button("Usuario");
        buttons[1] = new Button("Libro");
        buttons[2] = new Button("Préstamo");

        panelesIntercambio[0] = busquedaUsuario.getPanelGeneral();
        panelesIntercambio[1] = busquedaLibro.getPanelGeneral();
        panelesIntercambio[2] = busquedaPrestamo.getPanelGeneral();

        panelIntercambioPrincipal = panelesIntercambio[0];

        for (int i = 0; i < 3; i++) {
            buttons[i].setBackground(new Color(230, 230, 230));
            buttons[i].setForeground(Color.BLACK);
            buttons[i].setFont(new Font("SansSerif", Font.BOLD, 14));
            botones.add(buttons[i]);

            final int index = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ejecutarCambio(index);
                }
            });
        }

        panelGeneral.add(botones, BorderLayout.NORTH);
        panelGeneral.add(panelIntercambioPrincipal, BorderLayout.CENTER);
    }

    public void ejecutarCambio(int i) {
        panelGeneral.remove(panelIntercambioPrincipal);

        switch (i) {
            case 0:
                panelIntercambioPrincipal = panelesIntercambio[0];
                break;
            case 1:
                panelIntercambioPrincipal = panelesIntercambio[1];
                break;
            case 2:
                panelIntercambioPrincipal = panelesIntercambio[2];
                break;
        }

        panelGeneral.add(panelIntercambioPrincipal, BorderLayout.CENTER);
        panelGeneral.revalidate(); 
        panelGeneral.repaint(); 
    }
}