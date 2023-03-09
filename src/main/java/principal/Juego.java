package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Juego extends JFrame {

    private JPanel panel;
    private JLabel titulo;
    private JLabel pregunta;
    private JRadioButton turnoX;
    private JRadioButton turnoO;
    private JButton botonAceptar;
    private boolean equis;
    Icon advertencia;

    public Juego() {
        Image icono = Toolkit.getDefaultToolkit().getImage("src/main/java/imagenes/icono.png");
        setIconImage(icono);
        setSize(550, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
        setResizable(false);
    }

    public void iniciarComponentes() {
        agregarPanel();
        agregarTitulo();
        agregarBotonTurno();
        agregarBotonAceptar();
        agregarPregunta();
    }

    public void agregarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.black);
        this.getContentPane().add(panel);
    }

    private void agregarTitulo() {
        ImageIcon imagen = new ImageIcon("src/main/java/imagenes/titulo.jpg");
        titulo = new JLabel();
        titulo.setBounds(0, 50, 534, 100);
        titulo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(titulo.getWidth(), titulo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(titulo);
    }

    public void agregarBotonTurno() {
        turnoX = new JRadioButton("Jugador X", false);
        turnoX.setFont(new Font("arial", 1, 20));
        turnoX.setBounds(200, 310, 150, 30);
        turnoX.setBackground(Color.blue);
        turnoX.setForeground(Color.white);
        panel.add(turnoX);

        turnoO = new JRadioButton("Jugador O", false);
        turnoO.setText("Jugador O");
        turnoO.setFont(new Font("arial", 1, 20));
        turnoO.setBounds(200, 350, 150, 30);
        turnoO.setBackground(Color.green);
        turnoO.setForeground(Color.white);
        panel.add(turnoO);

        ButtonGroup grupoRadioBoton = new ButtonGroup();
        grupoRadioBoton.add(turnoX);
        grupoRadioBoton.add(turnoO);
    }

    public void agregarBotonAceptar() {
        botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        botonAceptar.setFont(new Font("arial", 1, 15));
        botonAceptar.setForeground(Color.white);
        botonAceptar.setBackground(Color.RED);
        botonAceptar.setBorderPainted(false);
        botonAceptar.setBounds(227, 400, 90, 30);
        panel.add(botonAceptar);
        eventoBoton();
    }

    public void agregarPregunta() {
        pregunta = new JLabel();
        pregunta.setBounds(158, 230, 220, 100);
        pregunta.setText("¿Quien inicia el juego?");
        pregunta.setFont(new Font("arial", 1, 20));
        pregunta.setForeground(Color.white);
        panel.add(pregunta);
    }

    public void eventoBoton() {
        ActionListener evento = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turnoX.isSelected() == true) {
                    equis = true;
                    dispose();
                    Interfaz ventana = new Interfaz(equis);
                    //ventana.setVisible(true);
                } else if (turnoO.isSelected() == true) {
                    equis = false;
                    dispose();
                    Interfaz ventana = new Interfaz(equis);
                    //ventana.setVisible(true);
                } else {
                    advertencia = new ImageIcon("src/main/java/imagenes/aviso.png");
                    JOptionPane.showMessageDialog(null, "¡Seleccione un jugador!","Aviso",JOptionPane.WARNING_MESSAGE,advertencia);
                }

            }
        };

        botonAceptar.addActionListener(evento);
    }
    
}