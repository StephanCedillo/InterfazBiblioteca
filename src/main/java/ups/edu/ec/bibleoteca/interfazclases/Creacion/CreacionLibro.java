package ups.edu.ec.bibleoteca.interfazclases.Creacion;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stephancedillo
 */
public class CreacionLibro {
    private Panel panelGeneral = new Panel();
    private Label labelPrincipal = new Label("CREACIÓN DE LIBRO", Label.CENTER);
    private Panel panelBotones = new Panel(new GridLayout(8, 1, 0, 5));
    private Button botonEnviar = new Button("Aceptar");

    public CreacionLibro() {
        panelGeneral.setBackground(new Color(245, 240, 240));
        panelGeneral.setLayout(new BorderLayout(0, 15));
        
        labelPrincipal.setFont(new Font("SansSerif", Font.BOLD, 16));
        panelGeneral.add(labelPrincipal, BorderLayout.NORTH);
        
        generarPanelBotones();
        panelGeneral.add(panelBotones, BorderLayout.CENTER);
        
        botonEnviar.setBackground(new Color(45, 45, 45));
        botonEnviar.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        Panel panelCentrarBoton = new Panel();
        panelCentrarBoton.add(botonEnviar);
        panelGeneral.add(panelCentrarBoton, BorderLayout.SOUTH);
    }

    public Panel getPanelGeneral() {
        return panelGeneral;
    }

    public void setPanelGeneral(Panel panelGeneral) {
        this.panelGeneral = panelGeneral;
    }

    public void generarPanelBotones() {
        Panel fila3 = new Panel(new GridLayout(1, 2, 20, 0));
        fila3.add(new InputLabel(new Label("Genero")).getPanelInput());
        fila3.add(new InputLabel(new Label("Numero de paginas")).getPanelInput());

        Panel fila4 = new Panel(new GridLayout(1, 2, 20, 0));
        fila4.add(new InputLabel(new Label("Idioma")).getPanelInput());
        fila4.add(new InputLabel(new Label("Restriccion de edad")).getPanelInput());

        Panel fila7 = new Panel(new GridLayout(1, 2, 20, 0));
        fila7.add(new InputLabel(new Label("Nombre")).getPanelInput());
        fila7.add(new InputLabel(new Label("Apellido")).getPanelInput());

        panelBotones.add(new InputLabel(new Label("ISBN")).getPanelInput());
        panelBotones.add(new InputLabel(new Label("Nombre")).getPanelInput());
        
        panelBotones.add(fila3);
        panelBotones.add(fila4);
        
        panelBotones.add(new InputLabel(new Label("Nombre del autor")).getPanelInput());
        
        Label separador = new Label("Si el autor no esta registrado en el sistema ingresar ; ");
        separador.setFont(new Font("SansSerif", Font.PLAIN, 14));
        separador.setForeground(Color.gray);
        panelBotones.add(separador);
        
        panelBotones.add(fila7);
        
        panelBotones.add(new InputLabel(new Label("Genero")).getPanelInput());
    }
}