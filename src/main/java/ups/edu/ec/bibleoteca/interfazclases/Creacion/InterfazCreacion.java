package ups.edu.ec.bibleoteca.interfazclases.Creacion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author stephancedillo
 */
public class InterfazCreacion {

    private Panel panelInterfaz = new Panel();
    private Panel panelIzquierda = new Panel();
    private Panel panelDerecha = new Panel();
    
 
    Panel[] panelesIntercambio = new Panel[3];
    CreacionLibro libro = new CreacionLibro();
    CreacionUsuario usuario = new CreacionUsuario();
    CreacionPrestamo prestamo = new CreacionPrestamo();
    Panel panelIntercambioPrincipal = new Panel();

    public InterfazCreacion() {
        
        panelInterfaz.setLayout(new BorderLayout(30, 0)); 
        panelInterfaz.setBackground(new Color(245, 240, 240)); 

        crearPanelIzquierdo();
        crearPanelDerecho();
        
    
        panelInterfaz.add(panelIzquierda, BorderLayout.WEST);
        panelInterfaz.add(panelDerecha, BorderLayout.CENTER);
    }

    public Panel getPanelInterfaz() {
        return panelInterfaz;
    }

    public void setPanelInterfaz(Panel panelInterfaz) {
        this.panelInterfaz = panelInterfaz;
    }

    public void crearPanelIzquierdo() {
       
        panelIzquierda.setLayout(new BorderLayout(0, 20));
        panelIzquierda.setBackground(new Color(245, 240, 240));

        Panel panelNombre = new Panel();
        
        Label labelNombre = new Label("ANDRESITO BOOKS", Label.CENTER); 
     
        labelNombre.setFont(new Font("Monospaced", Font.BOLD, 22)); 
        panelNombre.add(labelNombre);

        Panel panelImage = new Panel();
        String dibujo = "__________________________________________¶¶¶¶¶¶¶¶\n"
                + "____¶¶¶________________________________¶¶¶¶____¶¶\n"
                + "___¶¶__¶¶¶___________________________¶¶¶______¶¶\n"
                + "___¶_____¶¶¶¶______________________¶¶________¶¶\n"
                + "___¶________¶¶¶¶_________________¶¶_________¶¶\n"
                + "__¶¶___________¶¶¶¶_____________¶¶_________¶¶\n"
                + "__¶¶______________¶¶¶¶¶¶_______¶__________¶¶\n"
                + "__¶¶___________________¶¶¶___¶¶__________¶¶\n"
                + "___¶_____________________¶¶__¶______¶¶¶¶¶¶¶\n"
                + "___¶¶____________________¶¶_¶_____¶¶____ö_¶¶¶\n"
                + "____¶¶_____________________¶¶¶¶¶¶¶_________¶¶¶¶\n"
                + "______¶¶_________________________________¶¶¶\n"
                + "_______¶¶¶______________________________¶¶\n"
                + "__________¶¶¶¶_________________________¶¶\n"
                + "______________¶¶______________________¶¶\n"
                + "_______________¶¶¶¶¶¶________________¶¶\n"
                + "_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶____________________¶¶\n"
                + "__¶______________________________¶¶¶¶\n"
                + "___¶¶________________________¶¶¶¶¶\n"
                + "____¶¶_______________¶¶¶¶¶¶¶¶¶\n"
                + "______¶¶¶¶_____________¶¶\n";
        
      
        TextArea areaTexto = new TextArea(dibujo, 25, 45, TextArea.SCROLLBARS_NONE);
        areaTexto.setEditable(false); 
        areaTexto.setBackground(new Color(220, 215, 215)); 

        panelImage.add(areaTexto);
        panelNombre.setBackground(Color.GRAY);

        panelIzquierda.add(panelNombre, BorderLayout.NORTH);
        
        panelIzquierda.add(panelImage, BorderLayout.CENTER); 
    }

    public void crearPanelDerecho() {
  
        panelDerecha.setLayout(new BorderLayout(0, 20)); 
        panelDerecha.setBackground(new Color(245, 240, 240));

        Panel botones = new Panel();
        
        botones.setLayout(new GridLayout(1, 3)); 

        Button[] buttons = new Button[3];
        buttons[0] = new Button("Usuario");
        buttons[1] = new Button("Libro");
        buttons[2] = new Button("Prestamo");

        panelesIntercambio[0] = usuario.getPanelGeneral();
        panelesIntercambio[1] = libro.getPanelGeneral();
        panelesIntercambio[2] = prestamo.getPanelGeneral();

        panelIntercambioPrincipal = panelesIntercambio[0];

        for (int i = 0; i < 3; i++) {
            
            buttons[i].setBackground(new Color(230, 230, 230)); 
            buttons[i].setFont(new Font("SansSerif", Font.PLAIN, 14));
            botones.add(buttons[i]);

            final int index = i;

            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ejecutarCambio(index);
                }
            });
        }
        
        panelDerecha.add(botones, BorderLayout.NORTH);
        panelDerecha.add(panelIntercambioPrincipal, BorderLayout.CENTER); 
    }

    public void ejecutarCambio(int i) {
        panelDerecha.remove(panelIntercambioPrincipal);

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

        panelDerecha.add(panelIntercambioPrincipal, BorderLayout.CENTER);

        panelDerecha.revalidate(); // Para enviar una actualizacion
        panelDerecha.repaint(); // Para que se dibuje de nuevo el panel
    }
}