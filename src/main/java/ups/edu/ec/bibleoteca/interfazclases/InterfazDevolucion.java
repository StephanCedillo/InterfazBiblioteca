package ups.edu.ec.bibleoteca.interfazclases;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import ups.edu.ec.bibleoteca.interfazbibleoteca.InterfazBibleoteca;
import ups.edu.ec.bibleoteca.interfazclases.Busqueda.InterfazBusqueda;

public class InterfazDevolucion extends Frame implements ActionListener {

    private Frame ventanaAnterior;

    public InterfazDevolucion(Frame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
    }

    public InterfazDevolucion(Point ubicacion) {
        super("Sistema Biblioteca - Devolución de Libros");
        
        this.setLayout(new BorderLayout()); 
        this.setSize(1050, 710);
        this.setLocationRelativeTo(null);

        Panel navBar = efectuarCambio();
        this.add(navBar, BorderLayout.NORTH);

        Panel panelCentral = new Panel(new FlowLayout(FlowLayout.CENTER, 0, 40));
        panelCentral.setBackground(new Color(242, 242, 242));

        Panel panelFormulario = new Panel();
        panelFormulario.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
        panelFormulario.setPreferredSize(new Dimension(700, 550));
        panelFormulario.setBackground(new Color(242, 242, 242));

        Panel pnlTitulo = new Panel(new FlowLayout(FlowLayout.CENTER));
        pnlTitulo.setPreferredSize(new Dimension(700, 80));
        Label lblTitulo = new Label("SISTEMA DE DEVOLUCIÓN");
        lblTitulo.setFont(new Font("Serif", Font.PLAIN, 46));
        pnlTitulo.add(lblTitulo);
        panelFormulario.add(pnlTitulo);

        panelFormulario.add(crearCampo("Id"));
        panelFormulario.add(crearCampo("ISBN"));
        panelFormulario.add(crearCampo("Cedula"));

        Button btnEnviar = new Button("Enviar");
        btnEnviar.setBackground(new Color(40, 40, 40));

        btnEnviar.setFont(new Font("SansSerif", Font.BOLD, 18));
        
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarToast();
            }
        });

        Panel pnlBtn = new Panel(new BorderLayout());
        pnlBtn.setPreferredSize(new Dimension(600, 45));
        pnlBtn.add(btnEnviar, BorderLayout.CENTER);

        Panel pnlBtnContenedor = new Panel(new FlowLayout(FlowLayout.CENTER));
        pnlBtnContenedor.setPreferredSize(new Dimension(700, 80));
        pnlBtnContenedor.add(pnlBtn);

        panelFormulario.add(pnlBtnContenedor);

        panelCentral.add(panelFormulario);
        this.add(panelCentral, BorderLayout.CENTER);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.setVisible(true);
    }

    private Panel crearCampo(String titulo) {
        Panel pnlWrapper = new Panel(new FlowLayout(FlowLayout.CENTER));
        pnlWrapper.setPreferredSize(new Dimension(700, 75));
        
        Panel pnlInner = new Panel(new BorderLayout(0, 5));
        pnlInner.setPreferredSize(new Dimension(600, 65));
        pnlInner.setBackground(new Color(242, 242, 242));
        
        Label lbl = new Label(titulo);
        lbl.setFont(new Font("SansSerif", Font.PLAIN, 20));
        
        TextField txt = new TextField();
        txt.setFont(new Font("SansSerif", Font.PLAIN, 18));
        
        pnlInner.add(lbl, BorderLayout.NORTH);
        pnlInner.add(txt, BorderLayout.CENTER);
        
        pnlWrapper.add(pnlInner);
        return pnlWrapper;
    }

    private void mostrarToast() {
        Window toast = new Window(this);
        toast.setSize(380, 180);
        toast.setBackground(new Color(217, 217, 217));
        toast.setLayout(new BorderLayout());

        Panel pnlTexto = new Panel(new GridLayout(2, 1));
        
        Panel row1 = new Panel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        Label lblLinea1 = new Label("El libro se devolvió");
        lblLinea1.setFont(new Font("SansSerif", Font.BOLD, 28));
        row1.add(lblLinea1);
        
        Panel row2 = new Panel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        Label lblLinea2 = new Label("correctamente");
        lblLinea2.setFont(new Font("SansSerif", Font.BOLD, 28));
        row2.add(lblLinea2);

        pnlTexto.add(row1);
        pnlTexto.add(row2);
        
        Panel pnlSur = new Panel(new FlowLayout(FlowLayout.CENTER, 0, 25));
        Panel pnlVerde = new Panel();
        pnlVerde.setBackground(new Color(119, 212, 106)); 
        pnlVerde.setPreferredSize(new Dimension(280, 8));
        pnlSur.add(pnlVerde);

        toast.add(pnlTexto, BorderLayout.CENTER);
        toast.add(pnlSur, BorderLayout.SOUTH);

        Point loc = this.getLocationOnScreen();
        toast.setLocation(loc.x + (this.getWidth() - toast.getWidth()) / 2, loc.y + (this.getHeight() - toast.getHeight()) / 2 + 50);
        
        toast.setVisible(true);

        new Thread(() -> {
            try {
                Thread.sleep(2500); 
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            toast.dispose();
        }).start();
    }

    public Panel efectuarCambio() {
        Panel navBar = new Panel(new BorderLayout());
        navBar.setBackground(Color.white);

        Panel pnlLogo = new Panel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        Label lblLogo = new Label(" \u25A0 "); 
        lblLogo.setFont(new Font("SansSerif", Font.PLAIN, 30));
        pnlLogo.add(lblLogo);

        Panel pnlBotones = new Panel(new FlowLayout(FlowLayout.RIGHT, 10, 15));
        String[] opciones = {"Creacion", "Usuarios", "Libros", "Registros", "Devolución", "Busqueda"};
        
        for (String opcion : opciones) {
            Button btn = new Button(opcion);

            if (opcion.equals("Devolución")) {
                btn.setBackground(Color.black);
                btn.setForeground(Color.white); 
            } else {
                btn.setBackground(Color.white);
            }

            if (opcion.equals("Creacion")) {
                btn.addActionListener(new InterfazBibleoteca(this));
            } else if (opcion.equals("Usuarios")) {
                btn.addActionListener(new InterfazUsuarios(this));
            } else if (opcion.equals("Libros")) {
                btn.addActionListener(new InterfazLibros(this));
            } else if (opcion.equals("Busqueda")) {
                btn.addActionListener(new InterfazBusqueda(this));
            } else if (opcion.equals("Prestamo")) {
                btn.addActionListener(new InterfazPrestamo(this));
            } 

            pnlBotones.add(btn);
        }

        navBar.add(pnlLogo, BorderLayout.WEST);
        navBar.add(pnlBotones, BorderLayout.EAST);
        
        return navBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ventanaAnterior != null && ventanaAnterior.isVisible()) {
            Point posicionActual = ventanaAnterior.getLocation();
            ventanaAnterior.dispose();
            
            new InterfazDevolucion(posicionActual); 
        }
    }
}